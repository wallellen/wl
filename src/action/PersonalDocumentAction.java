package action;

import java.util.List;

import bean.ElectrictDocumentAdress;
import bean.PersonalDocument;
import bean.UnitDocument;
import bean.User;
import service.ElectricDocumentManager;
import service.PersonalDocumentManager;
import util.PageBean;
import util.SessionContants;

public class PersonalDocumentAction extends BaseAction {
	private PersonalDocumentManager personalDocumentManager;
	private ElectricDocumentManager electricDocumentManager;
	private List<ElectrictDocumentAdress>edas;
	public List<ElectrictDocumentAdress> getEdas() {
		return edas;
	}
	public void setEdas(List<ElectrictDocumentAdress> edas) {
		this.edas = edas;
	}
	public ElectricDocumentManager getElectricDocumentManager() {
		return electricDocumentManager;
	}
	public void setElectricDocumentManager(
			ElectricDocumentManager electricDocumentManager) {
		this.electricDocumentManager = electricDocumentManager;
	}
	private String socialInsuranceNumber;
	private String name;
	private String identifyCardId;
	private String documentName;
	private String physicsAdress;
	private String retentionPeriod;
	private String type;
	private String newDocumentName;
	private String newName;
	private String newIdentifyCardId;
	private String newPhysicsAdress;
	private String newRetentionPeriod;
	private String time;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String initSearch(){
		//this.type=this.type;
		return "done";
	}
	public String initModify(){
		return "init";
	}
	public String initUpload(){
		return "uploadinit";
	}
	
	
	public String modifyPersonalDocument(){
		PersonalDocument ud= new PersonalDocument();
		ud.setSocialInsuranceNumber(socialInsuranceNumber);
		ud.setTime(time);
		ud.setId(id);
		if((ud=(PersonalDocument)this.personalDocumentManager.findDocumentOnlyId(ud, type))!=null){
			
			if(newDocumentName!=null&&!this.newDocumentName.equals("")){
			ud.setDocumentName(newDocumentName);
			this.documentName=this.newDocumentName;
			}
			if(newPhysicsAdress!=null&&!this.newPhysicsAdress.equals("")){
			ud.setPhysicsAdress(newPhysicsAdress);
			this.physicsAdress=this.newPhysicsAdress;
			}
			if(newRetentionPeriod!=null&&!this.newRetentionPeriod.equals("")){
			ud.setRetentionPeriod(newRetentionPeriod);
			this.retentionPeriod=this.newRetentionPeriod;
			}
			if(this.newName!=null&&!this.newName.equals("")){
			ud.setName(newName);
			this.name=this.newName;
			}
			if(this.newIdentifyCardId!=null&&!this.newIdentifyCardId.equals("")){
				ud.setIdentifyCardId(newIdentifyCardId);
				this.identifyCardId=this.newIdentifyCardId;
			}
			
			this.personalDocumentManager.addPersonalDocument(ud, type);
			
			return "modify_sucess";
		}
		else{
			return "fail";
		}

	}
	public String deletePersonalDocument(){
		PersonalDocument ud= new PersonalDocument();
		ud.setSocialInsuranceNumber(socialInsuranceNumber);
		ud.setTime(time);
		ud.setId(id);
		if((ud=(PersonalDocument)this.personalDocumentManager.findDocumentOnlyId(ud, type))!=null){
			this.personalDocumentManager.deletePersonalDocument(ud, type);
			this.electricDocumentManager.deleteAllElectricPersonalDocumentForThisPersonalDocument(ud,type);
			return null;
		}
		
		return "fail";
	}
	
	public String addPersonalDocument(){
		PersonalDocument ud= new PersonalDocument();
		ud.setSocialInsuranceNumber(socialInsuranceNumber);
		ud.setTime(time);
		if(this.personalDocumentManager.findDocument(ud, type)==null){
			ud.setDocumentName(documentName);
			ud.setPhysicsAdress(physicsAdress);
			ud.setRetentionPeriod(retentionPeriod);
			ud.setIdentifyCardId(identifyCardId);
			ud.setName(name);
			ud.setTime(time);
			ud=this.personalDocumentManager.addPersonalDocument(ud, type);
			this.id=ud.getId();
			ud.setId(id);
			return "sucess";
		}
		else{
			return "exist";
		}
	}
	private PageBean documentPageBean;
	public PageBean getDocumentPageBean() {
		return documentPageBean;
	}
	public void setDocumentPageBean(PageBean documentPageBean) {
		this.documentPageBean = documentPageBean;
	}
	private List<PersonalDocument>documents;
	
	public List<PersonalDocument> getDocuments() {
		return documents;
	}
	public void setDocuments(List<PersonalDocument> documents) {
		this.documents = documents;
	}
	public String searchAllDocument(){
		PersonalDocument document = new PersonalDocument();
		if(this.socialInsuranceNumber!=null&&!this.socialInsuranceNumber.equals("")){
			document.setSocialInsuranceNumber(socialInsuranceNumber);
		}
		if(this.time!=null&&!this.time.equals("")){
			document.setTime(this.time);
		}
		if(this.identifyCardId!=null&&!this.identifyCardId.equals("")){
			document.setIdentifyCardId(identifyCardId);
		}
		this.documentPageBean=this.personalDocumentManager.findDocumentWithPage(document, type, pageSize, page);
		this.documents=this.documentPageBean.getList();
		return "sucess";
	}
	
	private int documentId;
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String searchDocument(){
		PersonalDocument ud= new PersonalDocument();
		if(!this.socialInsuranceNumber.equals(""))
		ud.setSocialInsuranceNumber(this.socialInsuranceNumber);
		if(!this.time.equals(""))
		ud.setTime(time);
		ud=(PersonalDocument)this.personalDocumentManager.findDocument(ud, type);
		if(ud!=null){
			this.documentName=ud.getDocumentName();
			this.physicsAdress=ud.getPhysicsAdress();
			this.retentionPeriod=ud.getRetentionPeriod();
			this.identifyCardId=ud.getIdentifyCardId();
			this.name=ud.getName();
			this.id=ud.getId();
			this.documentId=this.id;
			findAllElectricPersonalDocumentForThisPersonalDocument(ud);
		}
		else{
			this.id=0;
			this.documentId=this.id;
			this.documentName="";
			this.physicsAdress="";
			this.retentionPeriod="";
			this.identifyCardId="";
			this.name="";
			this.socialInsuranceNumber="";
			this.edas=null;
			return "notfind";
		}
		User user = (User)getSession(SessionContants.USER);
		if(user.getPermition().equals(User.QUERY_PERMITION)){
			return "detailforsearch";
		}else
		    return "detial";
	}
	public String searchDocumentForElectricDocumentTime(){
		PersonalDocument ud= new PersonalDocument();
		ud.setSocialInsuranceNumber(this.socialInsuranceNumber);
		ud.setTime(time);
		ud.setId(id);
		ud=(PersonalDocument)this.personalDocumentManager.findDocumentOnlyId(ud, type);
		if(ud!=null){
			this.documentName=ud.getDocumentName();
			this.physicsAdress=ud.getPhysicsAdress();
			this.retentionPeriod=ud.getRetentionPeriod();
			this.identifyCardId=ud.getIdentifyCardId();
			this.name=ud.getName();
			this.findAllElectricPersonalDocumentForThisUnitDocumentAndTime(ud);
		}
		else{
			this.id=0;
			this.documentName="";
			this.physicsAdress="";
			this.retentionPeriod="";
			this.identifyCardId="";
			this.name="";
			this.socialInsuranceNumber="";
			this.edas=null;
			return "notfind";
		}
		return "sucess";
	}
	
	
	
	private PageBean edPageBean;
	private int page;
	
	public PageBean getEdPageBean() {
		return edPageBean;
	}
	public int getPage() {
		return page;
	}
	public void setEdPageBean(PageBean edPageBean) {
		this.edPageBean = edPageBean;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public static final int pageSize=10;
	private void findAllElectricPersonalDocumentForThisPersonalDocument(PersonalDocument document){

		this.edPageBean=this.electricDocumentManager.findElectricPersonalDocumentAdressesForPage(document, type, pageSize, page);
		this.edas=this.edPageBean.getList();
	}
	private String electricTime;
	
	public String getElectricTime() {
		return electricTime;
	}
	public void setElectricTime(String time) {
		this.electricTime = time;
	}
	private void findAllElectricPersonalDocumentForThisUnitDocumentAndTime(PersonalDocument document){

		this.edPageBean=this.electricDocumentManager.searchElectricPersonalDocumentAdressesByTime(document, type, electricTime, pageSize, page);
		this.edas=this.edPageBean.getList();
	}
	
	public PersonalDocumentManager getPersonalDocumentManager() {
		return personalDocumentManager;
	}

	public String getSocialInsuranceNumber() {
		return socialInsuranceNumber;
	}

	public String getName() {
		return name;
	}

	public String getIdentifyCardId() {
		return identifyCardId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public String getPhysicsAdress() {
		return physicsAdress;
	}

	public String getRetentionPeriod() {
		return retentionPeriod;
	}

	public void setSocialInsuranceNumber(String socialInsuranceNumber) {
		this.socialInsuranceNumber = socialInsuranceNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIdentifyCardId(String identifyCardId) {
		this.identifyCardId = identifyCardId;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public void setPhysicsAdress(String physicsAdress) {
		this.physicsAdress = physicsAdress;
	}

	public void setRetentionPeriod(String retentionPeriod) {
		this.retentionPeriod = retentionPeriod;
	}

	public void setPersonalDocumentManager(
			PersonalDocumentManager personalDocumentManager) {
		this.personalDocumentManager = personalDocumentManager;
	}
	public String getNewDocumentName() {
		return newDocumentName;
	}
	public String getNewName() {
		return newName;
	}
	public String getNewIdentifyCardId() {
		return newIdentifyCardId;
	}
	public String getNewPhysicsAdress() {
		return newPhysicsAdress;
	}
	public String getNewRetentionPeriod() {
		return newRetentionPeriod;
	}
	public void setNewDocumentName(String newDocumentName) {
		this.newDocumentName = newDocumentName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public void setNewIdentifyCardId(String newIdentifyCardId) {
		this.newIdentifyCardId = newIdentifyCardId;
	}
	public void setNewPhysicsAdress(String newPhysicsAdress) {
		this.newPhysicsAdress = newPhysicsAdress;
	}
	public void setNewRetentionPeriod(String newRetentionPeriod) {
		this.newRetentionPeriod = newRetentionPeriod;
	}
	
}
