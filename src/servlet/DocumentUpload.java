package servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import service.DocumentManager;
import service.ElectricDocumentManager;
import service.PersonalDocumentManager;
import service.UnitDocumentManager;
import util.ApplicationCreater;
import util.DocumentNameMaker;
import util.FileAdressConstant;
import bean.Document;

@SuppressWarnings("serial")
public class DocumentUpload extends HttpServlet  implements SingleThreadModel  {

	/**
	 * Constructor of the object.
	 */
	public DocumentUpload() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	private UnitDocumentManager unitDocumentManager;
	private ElectricDocumentManager electricDocumentManager;
	private String type;
	private PersonalDocumentManager personalDocumentManager;
	private DocumentManager documentManager;
	private String time;
	private String socialInsuranceNumber;
	private FileAdressConstant fileAdressConstant;
	private int id;
	private ApplicationContext ctx = ApplicationCreater.getApplicationContext();
	private void initProperty(){
		
		unitDocumentManager=(UnitDocumentManager)ctx.getBean("unitDocumentManager");
		electricDocumentManager=(ElectricDocumentManager)ctx.getBean("electricDocumentManager");
		personalDocumentManager=(PersonalDocumentManager)ctx.getBean("personalDocumentManager");
		documentManager = (DocumentManager)ctx.getBean("documentManager");
		fileAdressConstant=(FileAdressConstant)ctx.getBean("fileAdressConstant");
	}
	
	public UnitDocumentManager getUnitDocumentManager() {
		return unitDocumentManager;
	}

	public ElectricDocumentManager getElectricDocumentManager() {
		return electricDocumentManager;
	}

	public String getType() {
		return type;
	}

	public PersonalDocumentManager getPersonalDocumentManager() {
		return personalDocumentManager;
	}

	public String getTime() {
		return time;
	}

	public String getSocialInsuranceNumber() {
		return socialInsuranceNumber;
	}

	public FileAdressConstant getFileAdressConstant() {
		return fileAdressConstant;
	}

	public int getId() {
		return id;
	}

	public void setUnitDocumentManager(UnitDocumentManager unitDocumentManager) {
		this.unitDocumentManager = unitDocumentManager;
	}

	public void setElectricDocumentManager(
			ElectricDocumentManager electricDocumentManager) {
		this.electricDocumentManager = electricDocumentManager;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPersonalDocumentManager(
			PersonalDocumentManager personalDocumentManager) {
		this.personalDocumentManager = personalDocumentManager;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setSocialInsuranceNumber(String socialInsuranceNumber) {
		this.socialInsuranceNumber = socialInsuranceNumber;
	}

	public void setFileAdressConstant(FileAdressConstant fileAdressConstant) {
		this.fileAdressConstant = fileAdressConstant;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println("get");
	}
	private  int count=0;
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		type=request.getParameter("type");
		id=Integer.parseInt(request.getParameter("id"));		
		Document document=new Document();		
		if(id!=0)
		document.setId(id);
		document= this.documentManager.findDocumentById(id);
		if(document==null){
			return ;
		}
		String documentName= DocumentNameMaker.createDocumentName(document, type);
		String dir = fileAdressConstant.getSavePath();
		String filePath = dir + "\\" +documentName+".jpg";
		this.electricDocumentManager.addElectricDocument(document, type,documentName,time,dir);		
		writeFile(request, filePath);	
		response.getWriter().println("{\"file\":\""+URLDecoder.decode(request.getHeader("X-File-Name"),"UTF-8")+"\"}");
	}
	
	
	private void writeFile(HttpServletRequest request, String filePath)
			throws IOException, FileNotFoundException {
		int v;
		InputStream inputStream = request.getInputStream();
		OutputStream outputStream = new FileOutputStream(new File(filePath));
		byte[] bytes = new byte[1024];
		while ((v = inputStream.read(bytes)) > 0) {
			outputStream.write(bytes, 0, v);
			outputStream.flush();
		}
		outputStream.close();
		inputStream.close();
	}
	
	private String documentId;
	public String getDocumentId() {
		return documentId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	private String documentType;

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		initProperty();
	}

	public DocumentManager getDocumentManager() {
		return documentManager;
	}

	public void setDocumentManager(DocumentManager documentManager) {
		this.documentManager = documentManager;
	}

}