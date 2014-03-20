package service;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import util.FileAdressConstant;
import util.PageBean;
import DAO.ElectrictDocumentAdressDAO;
import DAO.util.PageHandler;
import bean.Document;
import bean.ElectrictDocumentAdress;
import bean.PersonalDocument;
import bean.UnitDocument;

public class ElectricDocumentManager {
	private ElectrictDocumentAdressDAO electrictDocumentAdressDAO;
	private FileAdressConstant fileAdressConstant;
	private PageBean edPageBean;


	public PageBean getEdPageBean() {
		return edPageBean;
	}

	public void setEdPageBean(PageBean edPageBean) {
		this.edPageBean = edPageBean;
	}

	public FileAdressConstant getFileAdressConstant() {
		return fileAdressConstant;
	}

	public void setFileAdressConstant(FileAdressConstant fileAdressConstant) {
		this.fileAdressConstant = fileAdressConstant;
	}

	public ElectrictDocumentAdressDAO getElectrictDocumentAdressDAO() {
		return electrictDocumentAdressDAO;
	}

	public void setElectrictDocumentAdressDAO(
			ElectrictDocumentAdressDAO electrictDocumentAdressDAO) {
		this.electrictDocumentAdressDAO = electrictDocumentAdressDAO;
	}
	
	public String createUnitDocumentName(UnitDocument document,String type){
		Date date=new Date();
		String name="unit_"+type+"_"+document.getUnitIdentifyId()+"_"+document.getUnitName()+"_"+date.getTime();
		  
		return name;
	}
	public void addElectricUnitDocument(UnitDocument document,String type,String filename,String time,String documentDir){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentId(document.getId());
		eda.setElectricDocumentName(documentDir);
		eda.setDocumentType("unit_"+type);
		eda.setAddressUrl(filename);
		eda.setTime(time);
		this.electrictDocumentAdressDAO.merge(eda);
	}
	
	public List<ElectrictDocumentAdress> findElectricUnitDocumentAdresses(UnitDocument document,String type){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentType("unit_"+type);
		eda.setDocumentId(document.getId());
		List<ElectrictDocumentAdress>list=this.electrictDocumentAdressDAO.findByExample(eda);
		return list;

	}
	
	public PageBean findElectricUnitDocumentAdressesForPage(UnitDocument document,String type,int pageSize,int page){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentType("unit_"+type);
		eda.setDocumentId(document.getId());
		String hql="from ElectrictDocumentAdress as model where model.documentType='"+eda.getDocumentType()+"' and model.documentId" +
				"='"+eda.getDocumentId()+"'";
		List<ElectrictDocumentAdress>list=this.electrictDocumentAdressDAO.findByExample(eda);
		int totalRow=list.size();
		PageHandler ph=new PageHandler();
		PageBean pb=new PageBean();
		pb=ph.queryForPage(electrictDocumentAdressDAO, hql, totalRow, pageSize, page);
		return pb;

	}
	public PageBean searchElectricUnitDocumentAdressesByTime(UnitDocument document,String type,String time,int pageSize,int page){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentType("unit_"+type);
		eda.setDocumentId(document.getId());
		eda.setTime(time);
		String hql="from ElectrictDocumentAdress as model where model.documentType='"+eda.getDocumentType()+"' and model.documentId" +
				"='"+eda.getDocumentId()+"' and time='"+eda.getTime()+"'";
		List<ElectrictDocumentAdress>list=this.electrictDocumentAdressDAO.findByExample(eda);
		int totalRow=list.size();
		PageHandler ph=new PageHandler();
		PageBean pb=ph.queryForPage(electrictDocumentAdressDAO, hql, totalRow, pageSize, page);
		return pb;

	}
	
	
	public String createPersonalDocumentName(PersonalDocument document,String type){
		Date date = new Date();
		String name="personal_"+type+"_"+document.getSocialInsuranceNumber()+"_"+document.getName()+"_"+date.getTime();
		
		return name;
	}
	public void addElectricPersonalDocument(PersonalDocument document,String type,String filename,String time,String documentDir){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setElectricDocumentName(documentDir);
		eda.setDocumentId(document.getId());
		eda.setDocumentType("personal_"+type);
		eda.setAddressUrl(filename);
		eda.setTime(time);
		this.electrictDocumentAdressDAO.merge(eda);
	}
	
	public void addElectricDocument(Document document,String type,String filename,String time,String documentDir){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setElectricDocumentName(documentDir);
		eda.setDocumentId(document.getId());
		eda.setDocumentType(type);
		eda.setAddressUrl(filename);
		eda.setTime(document.getTime());
		this.electrictDocumentAdressDAO.merge(eda);
	}
	public List<ElectrictDocumentAdress> findElectricPersonalDocumentAdresses(PersonalDocument document,String type){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentType("personal_"+type);
		eda.setDocumentId(document.getId());
		List<ElectrictDocumentAdress>list=this.electrictDocumentAdressDAO.findByExample(eda);
		return list;
	}
	
	public List<ElectrictDocumentAdress> findElectricDocumentAdresses(Document document,String type){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentType(type);
		eda.setDocumentId(document.getId());
		List<ElectrictDocumentAdress>list=this.electrictDocumentAdressDAO.findByExample(eda);
		return list;
	}
	
	public PageBean findElectricPersonalDocumentAdressesForPage(PersonalDocument document,String type,int pageSize,int page){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentType("personal_"+type);
		eda.setDocumentId(document.getId());
		String hql="from ElectrictDocumentAdress as model where model.documentType='"+eda.getDocumentType()+"' and model.documentId" +
				"='"+eda.getDocumentId()+"'";
		List<ElectrictDocumentAdress>list=this.electrictDocumentAdressDAO.findByExample(eda);
		int totalRow=list.size();
		PageHandler ph=new PageHandler();
		PageBean pb=new PageBean();
		pb=ph.queryForPage(electrictDocumentAdressDAO, hql, totalRow, pageSize, page);
		return pb;
	}
	
	public PageBean findElectricDocumentAdressesForPage(Document document,String type,int pageSize,int page){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentType(type);
		eda.setDocumentId(document.getId());
		String hql="from ElectrictDocumentAdress as model where model.documentType='"+eda.getDocumentType()+"' and model.documentId" +
				"='"+eda.getDocumentId()+"'";
		List<ElectrictDocumentAdress>list=this.electrictDocumentAdressDAO.findByExample(eda);
		int totalRow=list.size();
		PageHandler ph=new PageHandler();
		PageBean pb=new PageBean();
		pb=ph.queryForPage(electrictDocumentAdressDAO, hql, totalRow, pageSize, page);
		return pb;
	}
	
	public PageBean searchElectricPersonalDocumentAdressesByTime(PersonalDocument document,String type,String time,int pageSize,int page){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentType("personal_"+type);
		eda.setDocumentId(document.getId());
		eda.setTime(time);
		String hql="from ElectrictDocumentAdress as model where model.documentType='"+eda.getDocumentType()+"' and model.documentId" +
				"='"+eda.getDocumentId()+"' and time='"+eda.getTime()+"'";
		List<ElectrictDocumentAdress>list=this.electrictDocumentAdressDAO.findByExample(eda);
		int totalRow=list.size();
		PageHandler ph=new PageHandler();
		PageBean pb=ph.queryForPage(electrictDocumentAdressDAO, hql, totalRow, pageSize, page);
		return pb;

	}
	
	public PageBean searchElectricDocumentAdressesByTime(Document document,String type,String time,int pageSize,int page){
		ElectrictDocumentAdress eda=new ElectrictDocumentAdress();
		eda.setDocumentType(type);
		eda.setDocumentId(document.getId());
		eda.setTime(time);
		String hql="from ElectrictDocumentAdress as model where model.documentType='"+eda.getDocumentType()+"' and model.documentId" +
				"='"+eda.getDocumentId()+"' and time='"+eda.getTime()+"'";
		List<ElectrictDocumentAdress>list=this.electrictDocumentAdressDAO.findByExample(eda);
		int totalRow=list.size();
		PageHandler ph=new PageHandler();
		PageBean pb=ph.queryForPage(electrictDocumentAdressDAO, hql, totalRow, pageSize, page);
		return pb;

	}
	public void deleteAllElectricUnitDocumentForThisUnitDocument(UnitDocument document,String type){
		List<ElectrictDocumentAdress>list=this.findElectricUnitDocumentAdresses(document, type);
		Iterator<ElectrictDocumentAdress>it=list.iterator();
		while(it.hasNext()){
			ElectrictDocumentAdress current=it.next();
			this.deleteOneElectricDocument(current);
		}

	}
	public void deleteAllElectricPersonalDocumentForThisPersonalDocument(PersonalDocument document,String type){
		List<ElectrictDocumentAdress>list=this.findElectricPersonalDocumentAdresses(document, type);
		Iterator<ElectrictDocumentAdress>it=list.iterator();
		while(it.hasNext()){
			ElectrictDocumentAdress current=it.next();
			this.deleteOneElectricDocument(current);
		}
	}
	
	public void deleteOneElectricDocument(ElectrictDocumentAdress ea){
		String fileName=ea.getAddressUrl();
		String url=this.fileAdressConstant.getSavePath()+"\\"+fileName+".jpg";
		this.electrictDocumentAdressDAO.delete(ea);
		File file=new File(url);
		if(file.exists()){
			file.delete();
		}
	}
}
