package action;


import java.util.ArrayList;
import java.util.List;

import service.DocumentManager;
import service.ElectricDocumentManager;
import util.PageBean;
import util.SessionContants;
import DAO.ArchiveDAO;
import bean.Archive;
import bean.Document;
import bean.ElectrictDocumentAdress;
import bean.PersonalDocument;
import bean.UnitDocument;
import bean.User;


public class DocumentAction extends BaseAction {
	private String documentNumber;
	private String archiveTitle;
	private int sequenceNumber;
	private int packageNumber;
	private String fileNumber;
	private String author;
	private String title;
	private String pageNumber;
	private String retentionPeriod;
	private String time;
	private String sqcurityLevel;
	private String comments;
	private String frameNumber;
	public String getFrameNumber() {
		return frameNumber;
	}
	public void setFrameNumber(String frameNumber) {
		this.frameNumber = frameNumber;
	}


	private int id;
	
	private ElectricDocumentManager electricDocumentManager;
	public ElectricDocumentManager getElectricDocumentManager() {
		return electricDocumentManager;
	}
	public void setElectricDocumentManager(
			ElectricDocumentManager electricDocumentManager) {
		this.electricDocumentManager = electricDocumentManager;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	private String kind;
	private String type;
	
	private List<String> acessesList;
	private ArchiveDAO archiveDAO;
	
	private List documents = new ArrayList();
	private PageBean documentPageBean;
	private PageBean edPageBean;
	
	public PageBean getEdPageBean() {
		return edPageBean;
	}
	public void setEdPageBean(PageBean edPageBean) {
		this.edPageBean = edPageBean;
	}
	public List<ElectrictDocumentAdress> getEdas() {
		return edas;
	}
	public void setEdas(List<ElectrictDocumentAdress> edas) {
		this.edas = edas;
	}


	private List<ElectrictDocumentAdress>edas;
	public PageBean getDocumentPageBean() {
		return documentPageBean;
	}
	public void setDocumentPageBean(PageBean documentPageBean) {
		this.documentPageBean = documentPageBean;
	}


	private DocumentManager documentManager;

	public static final int pageSize=10;
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getArchiveTitle() {
		return archiveTitle;
	}
	public void setArchiveTitle(String archiveTitle) {
		this.archiveTitle = archiveTitle;
	}
	public List getDocuments() {
		return documents;
	}
	public void setDocuments(List documents) {
		this.documents = documents;
	}
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public String getFileNumber() {
		return fileNumber;
	}
	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getRetentionPeriod() {
		return retentionPeriod;
	}
	public void setRetentionPeriod(String retentionPeriod) {
		this.retentionPeriod = retentionPeriod;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPackageNumber() {
		return packageNumber;
	}
	public void setPackageNumber(int packageNumber) {
		this.packageNumber = packageNumber;
	}
	public String getSqcurityLevel() {
		return sqcurityLevel;
	}
	public void setSqcurityLevel(String sqcurityLevel) {
		this.sqcurityLevel = sqcurityLevel;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String addDocument() throws Exception{
		if(!isAcess())
			return "error";
		
		Archive archive = new Archive();
		archive.setArchiveNumber(documentNumber);
		List list = archiveDAO.findByExample(archive);
	/*	if(list != null && list.size() > 0){
			archive = (Archive)list.get(0);
			type = comments;
			if(kind.equals("个人")){
				PersonalDocument document = new PersonalDocument();
				document.setArchive(archive);
				document.setAuthor(author);
				document.setComments(comments);
				document.setFileNumber(fileNumber);
				document.setPageNumber(pageNumber);
				document.setRetentionPeriod(retentionPeriod);
				document.setSequenceNumber(sequenceNumber);
				document.setTime(time);
				document.setTitle(title);
				documentManager.addPersonalDocument(document, type);
			}
			else if(kind.equals("单位")){
				UnitDocument document = new UnitDocument();
				document.setArchive(archive);
				document.setAuthor(author);
				document.setComments(comments);
				document.setFileNumber(fileNumber);
				document.setPageNumber(pageNumber);
				document.setRetentionPeriod(retentionPeriod);
				document.setSequenceNumber(sequenceNumber);
				document.setTime(time);
				document.setTitle(title);
				documentManager.addUnitDocument(document, type);
			}
			return "sucess";
		}*/
		if(list != null && list.size() > 0){
			archive = (Archive)list.get(0);
			Document document = new Document();
			document.setArchive(archive);
			document.setAuthor(author);
			document.setComments(comments);
			document.setFileNumber(fileNumber);
			document.setPageNumber(pageNumber);
			document.setRetentionPeriod(retentionPeriod);
			document.setSequenceNumber(sequenceNumber);
			document.setTime(time);
			document.setTitle(title);
			document.setType(type);
			document.setKind(kind);
			document.setPackageNumber(packageNumber);
			document.setFrameNumber(frameNumber);
			
			List docList = documentManager.findDocumentByExample(document);
			if(docList != null && docList.size() > 0){
				return "exist";
			}
			document = documentManager.addDocument(document);
			this.id = document.getId();
			document.setId(id);
			this.sequenceNumber++;
			this.packageNumber++;
			return "sucess";
		}
		return "archivenotfind";
		
		
	}
	
	public String searchAllDocument(){
		acessesList = getAcessesList();
		documentPageBean = documentManager.searchAllDocumentWithPageBean(acessesList,pageSize,page,documentNumber,sequenceNumber,author,title);
		documents = documentPageBean.getList();
		return "findsucess";
	}
	
	public String searchDocument(){
		
		/*if(kind.equals("个人")){
			PersonalDocument personalDocument = documentManager.findPersonalDocumentById(id,type);
			this.documentNumber = personalDocument.getArchive().getArchiveNumber();
			this.retentionPeriod = personalDocument.getRetentionPeriod();
			this.time = personalDocument.getTime();
			this.sequenceNumber = personalDocument.getSequenceNumber();
			this.fileNumber = personalDocument.getFileNumber();
			this.author = personalDocument.getAuthor();
			this.title = personalDocument.getTitle();
			this.pageNumber = personalDocument.getPageNumber();
			this.comments = personalDocument.getComments();
			
		}else if(kind.equals("单位")){
			UnitDocument unitDocument = documentManager.findUnitDocumnetById(id, type);
			this.documentNumber = unitDocument.getArchive().getArchiveNumber();
			this.retentionPeriod = unitDocument.getRetentionPeriod();
			this.time = unitDocument.getTime();
			this.sequenceNumber = unitDocument.getSequenceNumber();
			this.fileNumber = unitDocument.getFileNumber();
			this.author = unitDocument.getAuthor();
			this.title = unitDocument.getTitle();
			this.pageNumber = unitDocument.getPageNumber();
			this.comments = unitDocument.getComments();
		}*/
		Document document = documentManager.findDocumentById(id);
		if(document == null){
			return "notfind";
		}
		this.kind = document.getKind();
		this.documentNumber = document.getArchive().getArchiveNumber();
		this.retentionPeriod = document.getRetentionPeriod();
		this.time = document.getTime();
		this.sequenceNumber = document.getSequenceNumber();
		this.packageNumber = document.getPackageNumber();
		this.fileNumber = document.getFileNumber();
		this.author = document.getAuthor();
		this.title = document.getTitle();
		this.pageNumber = document.getPageNumber();
		this.comments = document.getComments();
		this.id = document.getId();
		this.frameNumber = document.getFrameNumber();
		searchDocumentForElectricDocumentTime();
		
		User user = (User)getSession(SessionContants.USER);
		if(user.getPermition().equals(User.QUERY_PERMITION)){
			return "detailforsearch";
		}else
		    return "detail";
	}
	

	public String initModify(){
		return "initModify";
	}
	
	public String initAdd(){
		return "initadd";
	}
	
	public String initUpload(){
		return "initupload";
	}
	
	public String initSearch(){
		return "initsearch";
	}
	public ArchiveDAO getArchiveDAO() {
		return archiveDAO;
	}
	public void setArchiveDAO(ArchiveDAO archiveDAO) {
		this.archiveDAO = archiveDAO;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public DocumentManager getDocumentManager() {
		return documentManager;
	}
	public void setDocumentManager(DocumentManager documentManager) {
		this.documentManager = documentManager;
	}
	
	private boolean isAcess(){
		type = comments;
		acessesList = getAcessesList();
		if(acessesList.contains(type)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	private List<String> getAcessesList(){
		return (List<String>)this.getSession(SessionContants.ACESSES);
	}
	
	public String modifyDocument(){
		Document document = documentManager.findDocumentById(id);
		Archive archive = new Archive();
		archive.setArchiveNumber(documentNumber);
		List list = archiveDAO.findByExample(archive);
		
		if(document != null && list != null && list.size() > 0){
			archive = (Archive)list.get(0);
			document.setArchive(archive);
			type = comments;
			document.setAuthor(author);
			document.setComments(comments);
			document.setFileNumber(fileNumber);
			document.setKind(kind);
			document.setPageNumber(pageNumber);
			document.setRetentionPeriod(retentionPeriod);
			document.setSequenceNumber(sequenceNumber);
			document.setSqcurityLevel(sqcurityLevel);
			document.setTime(time);
			document.setTitle(title);
			document.setType(type);
			document.setPackageNumber(packageNumber);
			document.setFrameNumber(frameNumber);
			documentManager.modifyDocument(document);
			return "modifysucess";
		}
		
		return "notfind";
	}
	
	public String searchDocumentForElectricDocumentTime(){
		Document document = new Document();
		document.setTime(time);
		document.setId(id);
		document = (Document)this.documentManager.findDocumentById(id);
		if(document!=null){
			this.documentNumber = document.getArchive().getArchiveNumber();
			this.retentionPeriod = document.getRetentionPeriod();
			this.time = document.getTime();
			this.sequenceNumber = document.getSequenceNumber();
			this.packageNumber = document.getPackageNumber();
			this.fileNumber = document.getFileNumber();
			this.author = document.getAuthor();
			this.title = document.getTitle();
			this.pageNumber = document.getPageNumber();
			this.comments = document.getComments();
			this.id = document.getId();
			this.type = document.getType();
			this.findAllElectricDocumentForThisDocument(document);
		}
		else{
			this.id=0;
			this.documentNumber = document.getArchive().getArchiveNumber();
			this.retentionPeriod = document.getRetentionPeriod();
			this.time = document.getTime();
			this.sequenceNumber = document.getSequenceNumber();
			this.fileNumber = document.getFileNumber();
			this.author = document.getAuthor();
			this.title = document.getTitle();
			this.pageNumber = document.getPageNumber();
			this.comments = document.getComments();
			this.id = document.getId();
			return "notfind";
		}
		return "sucess";
	}
	private String electricTime;
	
	public String getElectricTime() {
		return electricTime;
	}
	public void setElectricTime(String time) {
		this.electricTime = time;
	}
	private void findAllElectricDocumentForThisDocument(Document document){

		this.edPageBean=this.electricDocumentManager.findElectricDocumentAdressesForPage(document, type, pageSize, page);
		this.edas=this.edPageBean.getList();
	}
	
	public String deleteDocument(){
		Document document = new Document();
		document.setId(id);
		documentManager.deleteDocument(document);
		return "deletesucess";
	}
	
}
