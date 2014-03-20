package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import service.ArchiveManager;
import service.DocumentManager;
import service.ElectricDocumentManager;
import service.PersonalDocumentManager;
import service.UnitDocumentManager;
import util.ExcelExcuter;
import util.FileAdressConstant;
import util.SessionContants;
import bean.Archive;
import bean.Document;
import bean.ElectrictDocumentAdress;
import bean.PersonalDocument;
import bean.UnitDocument;
import bean.User;

public class ElectricDocumentAction extends BaseAction {
	
	private PersonalDocumentManager personalDocumentManager;
	private UnitDocumentManager unitDocumentManager;
	private DocumentManager documentManager;
	private ElectricDocumentManager electricDocumentManager;
	private FileAdressConstant fileAdressConstant;
	private ArchiveManager archiveManager;
	private String excelType;
	public DocumentManager getDocumentManager() {
		return documentManager;
	}
	public void setDocumentManager(DocumentManager documentManager) {
		this.documentManager = documentManager;
	}
	public FileAdressConstant getFileAdressConstant() {
		return fileAdressConstant;
	}
	public void setFileAdressConstant(FileAdressConstant fileAdressConstant) {
		this.fileAdressConstant = fileAdressConstant;
	}
	public ElectricDocumentManager getElectricDocumentManager() {
		return electricDocumentManager;
	}
	public String getType() {
		return type;
	}
	public String getUnitIdentifyId() {
		return unitIdentifyId;
	}
	public void setElectricDocumentManager(
			ElectricDocumentManager electricDocumentManager) {
		this.electricDocumentManager = electricDocumentManager;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setUnitIdentifyId(String unitIdentifyId) {
		this.unitIdentifyId = unitIdentifyId;
	}
	public PersonalDocumentManager getPersonalDocumentManager() {
		return personalDocumentManager;
	}
	public UnitDocumentManager getUnitDocumentManager() {
		return unitDocumentManager;
	}
	public void setPersonalDocumentManager(
			PersonalDocumentManager personalDocumentManager) {
		this.personalDocumentManager = personalDocumentManager;
	}
	public void setUnitDocumentManager(UnitDocumentManager unitDocumentManager) {
		this.unitDocumentManager = unitDocumentManager;
	}
	private String uploadFileName;
	private String savePath;
	private File upload;
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public File getUpload() {
		return upload;
	}
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	private String type;
	private String unitIdentifyId;
	private List<ElectrictDocumentAdress>edas;
	private String archiveNumber;
	public List<ElectrictDocumentAdress> getEdas() {
		return edas;
	}
	public void setEdas(List<ElectrictDocumentAdress> edas) {
		this.edas = edas;
	}
	private String socialInsuranceNumber;
	public String getSocialInsuranceNumber() {
		return socialInsuranceNumber;
	}
	public void setSocialInsuranceNumber(String socialInsuranceNumber) {
		this.socialInsuranceNumber = socialInsuranceNumber;
	}
	public String findAllElectricUnitDocumentForThisUnitDocument(){
		
		UnitDocument document = new UnitDocument();
		document.setUnitIdentifyId(unitIdentifyId);
		document=this.unitDocumentManager.findDocument(document, type);
		if(document==null){
			return null;
		}
		edas=this.electricDocumentManager.findElectricUnitDocumentAdresses(document, type);
		return"sucess";
	}
	

	private String time ;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private int documentId;
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	private int index;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String uploadElectricUnitDocument() throws IOException{
		UnitDocument document=new UnitDocument();
		if(documentId!=0)
		document.setId(documentId);
		document= this.unitDocumentManager.findDocumentOnlyId(document, type);
		if(document==null){
			return "fail";
		}
		String documentName= this.electricDocumentManager.createUnitDocumentName(document, type);
		this.uploadElectricDocument(documentName);
		this.electricDocumentManager.addElectricUnitDocument(document, type,documentName,time,fileAdressConstant.getSavePath());
		return "unit_add_sucess";
	} 
	
	public String uploadElectricPersonalDocument() throws IOException{
		PersonalDocument document = new PersonalDocument();
		document.setSocialInsuranceNumber(socialInsuranceNumber);
		if(documentId!=0)
			document.setId(documentId);
		document=this.personalDocumentManager.findDocumentOnlyId(document, type);
		if(document==null){
			return "fail";
		}
		String documentName=this.electricDocumentManager.createPersonalDocumentName(document, type);
		this.uploadElectricDocument(documentName);
		this.electricDocumentManager.addElectricPersonalDocument(document, type,documentName,time,fileAdressConstant.getSavePath());
		return "personal_add_sucess";
	}

	private void uploadElectricDocument(String savedFileName) throws IOException{
		
		FileOutputStream fos=new FileOutputStream(fileAdressConstant.getSavePath()+"\\"
				+savedFileName+".jpg");
		FileInputStream fis=new FileInputStream(this.getUpload());
		byte[]buffer=new byte[1024];
		int len=0;
		while((len=fis.read(buffer))>0)
		{
			fos.write(buffer, 0, len);
		}
		fos.close();
		fis.close();
	}
    //必须的参数，格式：表单名+ContentType，表示上传文件类型  
    private String uploadContentType;   
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	/***
	 * 上传excel文件
	 * @return 
	 * @throws IOException
	 */
	private File uploadDocumentExcel() throws IOException{
		File uploadExcel=this.getUpload();
		
		String excelPost=postMap.get(this.getUploadContentType());
		String fileUrl=fileAdressConstant.getTempFileSavePath()+"\\"
		+makeTempExcelName()+"."+excelPost;
		FileOutputStream fos=new FileOutputStream(fileUrl);
		FileInputStream fis=new FileInputStream(this.getUpload());
		byte[]buffer=new byte[1024];
		int len=0;
		while((len=fis.read(buffer))>0)
		{
			fos.write(buffer, 0, len);
		}
		fos.close();
		fis.close();
		return new File(fileUrl);
	}
	private static HashMap<String,String>postMap=new HashMap<String,String>();
	static{
		postMap.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet","xlsx");
		postMap.put("application/vnd.ms-excel","xls");
	}
	
	public void uploadPersonalDocumentExcel() throws Exception{
		
		File excel= uploadDocumentExcel();
		ExcelExcuter ee = new ExcelExcuter();
		List<PersonalDocument> list=ee.readExcelForPersonalDocument(excel);
		list=this.personalDocumentManager.addSomeDocumentFromList(list);
	}
	
	
	public void uploadUnitDocumentExcel() throws Exception{		
		File excel= uploadDocumentExcel();
		ExcelExcuter ee = new ExcelExcuter();
		List<UnitDocument> list=ee.readExcelForUnitDocument(excel);
		list=this.unitDocumentManager.addSomeDocumentFromList(list);
	}
	
	/*public void uploadDocumentFromExcel() throws Exception{
		
		File excel= uploadDocumentExcel();
		ExcelExcuter ee = new ExcelExcuter();
		List<Document> list=ee.readExcelForDocument(excel);
		list=this.personalDocumentManager.addSomeDocumentFromList(list);
	}
	*/
	private String makeTempExcelName() {
		// TODO Auto-generated method stub
		String str=makeTempFileName()+"excel";
		return str;
	}
	private String makeTempOutputExcelName(){
		return makeTempFileName()+"OutputExcel";
	}
	public String outputPersonalExcel() throws Exception{
		List<PersonalDocument> documents= this.personalDocumentManager.findAll(type);
		ExcelExcuter ee = new ExcelExcuter();
		if(documents!=null&&documents.size()>0){
			String outputExcelURL=fileAdressConstant.getTempFileSavePath()+"\\"+makeTempOutputExcelName()+".xls";
			ee.writePersonalExcel(documents, outputExcelURL);
			excelUrl="temp/"+makeTempOutputExcelName()+".xls";
			return "download_excel";
		}
		return "notfind";
	}
	
	public String outputDocumentExcel() throws Exception{
		Archive archive = new Archive();
		archive.setArchiveNumber(archiveNumber);
		List<Document> documents= this.archiveManager.findAllDocumentByArchive(archive);
		ExcelExcuter ee = new ExcelExcuter();
		if(documents!=null&&documents.size()>0){
			String outputExcelURL=fileAdressConstant.getTempFileSavePath()+"\\"+makeTempOutputExcelName()  +".xls";
			ee.writeDocumentExcel(documents, outputExcelURL,excelType);
			//excelUrl=fileAdressConstant.getTempFileSavePath() + makeTempOutputExcelName()+".xls";
			excelUrl="temp/"+makeTempOutputExcelName() +".xls";
			return "download_excel";
		}
		return "notfind";
		
	}
	
	public String outputUnitExcel() throws Exception{
		List<UnitDocument> documents= this.unitDocumentManager.findAll(type);
		ExcelExcuter ee = new ExcelExcuter();
		if(documents!=null&&documents.size()>0){
			String outputExcelURL=fileAdressConstant.getTempFileSavePath()+"\\"+makeTempOutputExcelName()+".xls";
			ee.writeUnitDocumentExcel(documents, outputExcelURL);
			excelUrl="temp/"+makeTempOutputExcelName()+".xls";
			return "download_excel";
		}
		return "notfind";
	}
	private String excelUrl;
	public String getExcelUrl() {
		return excelUrl;
	}
	public void setExcelUrl(String excelUrl) {
		this.excelUrl = excelUrl;
	}
	private int electricId;
	
	
	public int getElectricId() {
		return electricId;
	}
	public void setElectricId(int electricId) {
		this.electricId = electricId;
	}
	
	
	private String deleteElectricDocument(){
		ElectrictDocumentAdress eda;
		eda=this.electricDocumentManager.getElectrictDocumentAdressDAO().findById(this.electricId);
		if(eda==null){
			return "fail";
		}
		this.electricDocumentManager.deleteOneElectricDocument(eda);
		return "sucess";
	}
	public String deletePersonalElectricDocument(){
		if(!this.deleteElectricDocument().equals("sucess")){
			return "delete_fail";
		}
		return "delete_personal_sucess";
	}
	public String deleteUnitlElectricDocument(){
		if(!this.deleteElectricDocument().equals("sucess")){
			return "delete_fail";
		}
		return "delete_unit_sucess";
	}
	
	public String deleteElectricDocumentById(){
		if(!this.deleteElectricDocument().equals("sucess")){
			return "delete_fail";
		}
		return "delete_document_sucess";
	}
	
	private int waitTimeToMakeSureOpenRightImage;
	
	public int getWaitTimeToMakeSureOpenRightImage() {
		return waitTimeToMakeSureOpenRightImage;
	}
	public void setWaitTimeToMakeSureOpenRightImage(
			int waitTimeToMakeSureOpenRightImage) {
		this.waitTimeToMakeSureOpenRightImage = waitTimeToMakeSureOpenRightImage;
	}
	
	private int nextIndex;
	
	public int getNextIndex() {
		return nextIndex;
	}
	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}
	private int isExistNextIndex=1;
	private int preIndex;
	private int isExistPreIndex=1;
	

	public int getPreIndex() {
		return preIndex;
	}
	public void setPreIndex(int preIndex) {
		this.preIndex = preIndex;
	}
	public int getIsExistPreIndex() {
		return isExistPreIndex;
	}
	public void setIsExistPreIndex(int isExistPreIndex) {
		this.isExistPreIndex = isExistPreIndex;
	}
	public int getIsExistNextIndex() {
		return isExistNextIndex;
	}
	public void setIsExistNextIndex(int isExistNextIndex) {
		this.isExistNextIndex = isExistNextIndex;
	}
	private int pagesSize;
	
	
	public int getPagesSize() {
		return pagesSize;
	}
	public void setPagesSize(int pagesSize) {
		this.pagesSize = pagesSize;
	}
	public String openPersonalElectricDocument() throws IOException, InterruptedException{
		ElectrictDocumentAdress eda;
		//eda=this.electricDocumentManager.getElectrictDocumentAdressDAO().findById(this.electricId);
		PersonalDocument document= new PersonalDocument();
		document.setId(documentId);
		document=this.personalDocumentManager.findDocumentOnlyId(document, type);
		this.edas=this.electricDocumentManager.findElectricPersonalDocumentAdresses(document, type);
		eda=this.edas.get(index);
		if(eda==null){
			return "fail";
		}
		this.pagesSize=this.edas.size();
		this.endIndex=pagesSize-1;
		if(this.index<edas.size()-1){
			this.nextIndex=this.index+1;
		}
		else{
			this.nextIndex=this.index+1;
			this.isExistNextIndex=0;
		}
		if(this.index>0){
			this.preIndex=this.index-1;
		}
		else{
			this.preIndex=this.index-1;
			this.isExistPreIndex=0;
		}
		
		this.openElectricDocument(eda.getAddressUrl(),eda.getElectricDocumentName());
		Thread.sleep(waitTimeToMakeSureOpenRightImage);
		return "check_sucess_personal";
	}
	
	public String openElectricDocument() throws IOException, InterruptedException{
		ElectrictDocumentAdress eda;
		//eda=this.electricDocumentManager.getElectrictDocumentAdressDAO().findById(this.electricId);
		Document document= new Document();
		document.setId(documentId);
		document=this.documentManager.findDocumentById(documentId);
		this.edas=this.electricDocumentManager.findElectricDocumentAdresses(document, type);
		eda=this.edas.get(index);
		if(eda==null){
			return "fail";
		}
		this.pagesSize=this.edas.size();
		this.endIndex=pagesSize-1;
		if(this.index<edas.size()-1){
			this.nextIndex=this.index+1;
		}
		else{
			this.nextIndex=this.index+1;
			this.isExistNextIndex=0;
		}
		if(this.index>0){
			this.preIndex=this.index-1;
		}
		else{
			this.preIndex=this.index-1;
			this.isExistPreIndex=0;
		}
		
		this.openElectricDocument(eda.getAddressUrl(),eda.getElectricDocumentName());
		Thread.sleep(waitTimeToMakeSureOpenRightImage);
		return "check_sucess_document";
	}
	private int endIndex;
	
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public String openUnitElectricDocument() throws IOException, InterruptedException{
		ElectrictDocumentAdress eda;
		//eda=this.electricDocumentManager.getElectrictDocumentAdressDAO().findById(this.electricId);
		UnitDocument document= new UnitDocument();
		document.setId(documentId);
		document=this.unitDocumentManager.findDocumentOnlyId(document, type);
		this.edas=this.electricDocumentManager.findElectricUnitDocumentAdresses(document, type);
		eda=this.edas.get(index);
		if(eda==null){
			return "fail";
		}
		this.pagesSize=this.edas.size();
		this.endIndex=pagesSize-1;
		if(this.index<edas.size()-1){
			this.nextIndex=this.index+1;
		}
		else{
			this.nextIndex=this.index+1;
			this.isExistNextIndex=0;
		}
		if(this.index>0){
			this.preIndex=this.index-1;
		}
		else{
			this.preIndex=this.index-1;
			this.isExistPreIndex=0;
		}
		
		this.openElectricDocument(eda.getAddressUrl(),eda.getElectricDocumentName());
		Thread.sleep(waitTimeToMakeSureOpenRightImage);
		return "check_sucess_unit";
	}
	
	private void openElectricDocument(String savedFileName,String documentDir) throws IOException{
		FileInputStream fis=new FileInputStream(documentDir+"\\"+savedFileName+".jpg");
		imgUrl="temp/"+this.makeTempFileName()+".jpg";
		FileOutputStream fos=new FileOutputStream(fileAdressConstant.getTempFileSavePath()+"\\"
				+this.makeTempFileName()+".jpg");
		byte[]buffer=new byte[1024];
		int len=0;
		while((len=fis.read(buffer))>0)
		{
			fos.write(buffer, 0, len);
			fos.flush();
		}
		fos.close();
		fis.close();
		
	}

	private String imgUrl;
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	private String makeTempFileName(){
		User loginUser=(User)this.getSession(SessionContants.USER);
		return loginUser.getUsername();
	}
	private String tempFileUrl;
	public String getTempFileUrl() {
		return tempFileUrl;
	}
	public void setTempFileUrl(String tempFileUrl) {
		this.tempFileUrl = tempFileUrl;
	}
	public ArchiveManager getArchiveManager() {
		return archiveManager;
	}
	public void setArchiveManager(ArchiveManager archiveManager) {
		this.archiveManager = archiveManager;
	}
	public String getArchiveNumber() {
		return archiveNumber;
	}
	public void setArchiveNumber(String archiveNumber) {
		this.archiveNumber = archiveNumber;
	}
	public String getExcelType() {
		return excelType;
	}
	public void setExcelType(String excelType) {
		this.excelType = excelType;
	}
	
}
