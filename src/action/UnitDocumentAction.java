package action;

import java.util.List;

import bean.ElectrictDocumentAdress;
import bean.PersonalDocument;
import bean.UnitDocument;
import bean.User;
import service.ElectricDocumentManager;
import service.UnitDocumentManager;
import util.PageBean;
import util.SessionContants;

public class UnitDocumentAction extends BaseAction {
	private UnitDocumentManager unitDocumentManager;
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
	
	public UnitDocumentManager getUnitDocumentManager() {
		return unitDocumentManager;
	}

	public void setUnitDocumentManager(UnitDocumentManager unitDocumentManager) {
		this.unitDocumentManager = unitDocumentManager;
	}
	public String getType() {
		return type;
	}

	public String getUnitIdentifyId() {
		return unitIdentifyId;
	}

	public String getUnitName() {
		return unitName;
	}

	public String getDocumentName() {
		return documentName;
	}

	public String getRetentionPeriod() {
		return retentionPeriod;
	}

	public String getPhysicsAdress() {
		return physicsAdress;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUnitIdentifyId(String unitIdentifyId) {
		this.unitIdentifyId = unitIdentifyId;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public void setRetentionPeriod(String retentionPeriod) {
		this.retentionPeriod = retentionPeriod;
	}

	public void setPhysicsAdress(String physicsAdress) {
		this.physicsAdress = physicsAdress;
	}
	private String type;
	private String unitIdentifyId;
	private String unitName;
	private String documentName;
	private String retentionPeriod;
	private String physicsAdress;
	private String newDocumentName;
	private String newRetentionPeriod;
	private String newPhysicsAdress;
	private String newUnitName;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String addUnitDocument(){
		UnitDocument ud= new UnitDocument();
		ud.setUnitIdentifyId(unitIdentifyId);
		ud.setTime(time);
		
		if(this.unitDocumentManager.findDocument(ud, type)==null){
			ud.setDocumentName(documentName);
			ud.setPhysicsAdress(physicsAdress);
			ud.setRetentionPeriod(retentionPeriod);
			ud.setUnitName(unitName);
			ud=this.unitDocumentManager.addUnitDocument(ud, type);
			this.id=ud.getId();
			return "sucess";
		}
		else{
			return "exist";
		}
	}
	
	public String modifyUnitDocument(){
		UnitDocument ud= new UnitDocument();
		ud.setUnitIdentifyId(unitIdentifyId);
		ud.setTime(time);
		ud.setId(id);
		if((ud=(UnitDocument)this.unitDocumentManager.findDocumentOnlyId(ud, type))!=null){
			
			if(newDocumentName!=null&&!this.newDocumentName.equals(""))
			ud.setDocumentName(newDocumentName);
			if(newPhysicsAdress!=null&&!this.newPhysicsAdress.equals(""))
			ud.setPhysicsAdress(newPhysicsAdress);
			if(newRetentionPeriod!=null&&!this.newRetentionPeriod.equals(""))
			ud.setRetentionPeriod(newRetentionPeriod);
			if(newUnitName!=null&&!this.newUnitName.equals(""))
			ud.setUnitName(newUnitName);
			
			
			this.unitDocumentManager.addUnitDocument(ud, type);
			return "modify_sucess";
		}
		else{
			return "fail";
		}

	}
	private PageBean documentPageBean;
	public PageBean getDocumentPageBean() {
		return documentPageBean;
	}
	public void setDocumentPageBean(PageBean documentPageBean) {
		this.documentPageBean = documentPageBean;
	}
	private List<UnitDocument>documents;
	
	public List<UnitDocument> getDocuments() {
		return documents;
	}
	public void setDocuments(List<UnitDocument> documents) {
		this.documents = documents;
	}
	public String searchAllDocument(){
		UnitDocument document = new UnitDocument();
		if(this.unitIdentifyId!=null&&!this.unitIdentifyId.equals("")){
			document.setUnitIdentifyId(unitIdentifyId);
		}
		if(this.time!=null&&!this.time.equals("")){
			document.setTime(this.time);
		}
		this.documentPageBean=this.unitDocumentManager.findDocumentWithPage(document, type, pageSize, page);
		this.documents=this.documentPageBean.getList();
		return "sucess";
	}
	
	public String searchDocument(){
		UnitDocument ud= new UnitDocument();
		if(!this.unitIdentifyId.equals(""))
		ud.setUnitIdentifyId(unitIdentifyId);
		if(!this.time.equals(""))
		ud.setTime(time);
		ud=(UnitDocument)this.unitDocumentManager.findDocument(ud, type);
		if(ud!=null){
			this.documentName=ud.getDocumentName();
			this.physicsAdress=ud.getPhysicsAdress();
			this.retentionPeriod=ud.getRetentionPeriod();
			this.unitIdentifyId=ud.getUnitIdentifyId();
			this.unitName=ud.getUnitName();
			this.id=ud.getId();
			findAllElectricUnitDocumentForThisUnitDocument(ud);
		}
		else{
			this.id=0;
			this.documentName="";
			this.physicsAdress="";
			this.retentionPeriod="";
			this.unitIdentifyId="";
			this.unitName="";
			return "notfind";
		}
		User user = (User)getSession(SessionContants.USER);
		if(user.getPermition().equals(User.QUERY_PERMITION)){
			return "detailforsearch";
		}else
		    return "detial";
	}
	private String electricTime;
	private String time;

	public String getElectricTime() {
		return electricTime;
	}
	public String getTime() {
		return time;
	}
	public void setElectricTime(String electricTime) {
		this.electricTime = electricTime;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String searchDocumentForElectricDocumentTime(){
		UnitDocument ud= new UnitDocument();
		ud.setUnitIdentifyId(unitIdentifyId);
		ud.setTime(time);
		ud.setId(id);
		ud=(UnitDocument)this.unitDocumentManager.findDocumentOnlyId(ud, type);
		if(ud!=null){
			this.documentName=ud.getDocumentName();
			this.physicsAdress=ud.getPhysicsAdress();
			this.retentionPeriod=ud.getRetentionPeriod();
			this.unitIdentifyId=ud.getUnitIdentifyId();
			this.unitName=ud.getUnitName();
			findAllElectricUnitDocumentForThisUnitDocumentAndTime(ud);
		}
		else{
			this.id=0;
			this.documentName="";
			this.physicsAdress="";
			this.retentionPeriod="";
			this.unitIdentifyId="";
			this.unitName="";
			return "notfind";
		}
		return "sucess";
	}
	
	
	
	private PageBean edPageBean;
	
	public PageBean getEdPageBean() {
		return edPageBean;
	}
	public void setEdPageBean(PageBean edPageBean) {
		this.edPageBean = edPageBean;
	}
	private void findAllElectricUnitDocumentForThisUnitDocument(UnitDocument document){
		this.edPageBean=this.electricDocumentManager.findElectricUnitDocumentAdressesForPage(document, type, pageSize, page);
		this.edas=this.edPageBean.getList();
	}
	private void findAllElectricUnitDocumentForThisUnitDocumentAndTime(UnitDocument document){
		this.edPageBean=this.electricDocumentManager.searchElectricUnitDocumentAdressesByTime(document, type, electricTime, pageSize, page);
		this.edas=this.edPageBean.getList();
	}
	
	
	public static final int pageSize=10;
	private int page=1;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String deleteUnitDocument(){
		UnitDocument ud= new UnitDocument();
		ud.setUnitIdentifyId(unitIdentifyId);
		ud.setTime(time);
		ud.setId(id);
		if((ud=this.unitDocumentManager.findDocumentOnlyId(ud, type))!=null){
			this.unitDocumentManager.deleteDocument(ud, type);
			this.electricDocumentManager.deleteAllElectricUnitDocumentForThisUnitDocument(ud,type);
			return null;
		}		
		return "fail";
	}

	public String getNewDocumentName() {
		return newDocumentName;
	}

	public String getNewRetentionPeriod() {
		return newRetentionPeriod;
	}

	public String getNewPhysicsAdress() {
		return newPhysicsAdress;
	}

	public String getNewUnitName() {
		return newUnitName;
	}

	public void setNewDocumentName(String newDocumentName) {
		this.newDocumentName = newDocumentName;
	}

	public void setNewRetentionPeriod(String newRetentionPeriod) {
		this.newRetentionPeriod = newRetentionPeriod;
	}

	public void setNewPhysicsAdress(String newPhysicsAdress) {
		this.newPhysicsAdress = newPhysicsAdress;
	}

	public void setNewUnitName(String newUnitName) {
		this.newUnitName = newUnitName;
	}
}
