package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.PageBean;
import util.TableAndObjectMap;
import DAO.UnitBirthInsuranceDocumentDAO;
import DAO.UnitInjeryInsuranceDocumentDAO;
import DAO.UnitMedicalInsuranceDocumentDAO;
import DAO.UnitPensionInsuranceDocumentDAO;
import DAO.UnitSocialInsuranceAuditDocumentDAO;
import DAO.UnitSocialInsuranceCollectionDocumentDAO;
import DAO.UnitSocialInsuranceManagerDocumentDAO;
import DAO.UnitSocialInsuranceStatisticsDocumentDAO;
import DAO.UnitUnemployeeInsuranceDocumentDAO;
import DAO.util.PageHandler;
import bean.UnitBirthInsuranceDocument;
import bean.UnitDocument;
import bean.UnitInjeryInsuranceDocument;
import bean.UnitMedicalInsuranceDocument;
import bean.UnitPensionInsuranceDocument;
import bean.UnitSocialInsuranceAuditDocument;
import bean.UnitSocialInsuranceCollectionDocument;
import bean.UnitSocialInsuranceManagerDocument;
import bean.UnitSocialInsuranceStatisticsDocument;
import bean.UnitUnemployeeInsuranceDocument;
public class UnitDocumentManager {
	private UnitBirthInsuranceDocumentDAO unitBirthInsuranceDocumentDAO;
	private UnitInjeryInsuranceDocumentDAO unitInjeryInsuranceDocumentDAO;
	private UnitMedicalInsuranceDocumentDAO unitMedicalInsuranceDocumentDAO;
	private UnitPensionInsuranceDocumentDAO unitPensionInsuranceDocumentDAO;
	private UnitSocialInsuranceAuditDocumentDAO unitSocialInsuranceAuditDocumentDAO;
	private UnitSocialInsuranceCollectionDocumentDAO unitSocialInsuranceCollectionDocumentDAO;
	private UnitSocialInsuranceManagerDocumentDAO unitSocialInsuranceManagerDocumentDAO;
	private UnitSocialInsuranceStatisticsDocumentDAO unitSocialInsuranceStatisticsDocumentDAO;
	private UnitUnemployeeInsuranceDocumentDAO unitUnemployeeInsuranceDocumentDAO;
	public static final String U_B_I_D="生育保险待遇类";
	public static final String U_I_I_D="工伤保险待遇类";
	public static final String U_M_I_D="医疗保险待遇类";
	public static final String U_P_I_D="养老保险待遇类";
	public static final String U_S_I_A_D="社会保险稽核类";
	public static final String U_S_I_M_D="社会保险管理类";
	public static final String U_S_I_C_D="社会保险征缴类";
	public static final String U_S_I_S_D="社会保险业务统计报表类";
	public static final String U_U_I_D="失业保险待遇类";
	private static List<String>types=new ArrayList<String>();
	static{
		types.add("生育保险待遇类");
		types.add("工伤保险待遇类");
		types.add("医疗保险待遇类");
		types.add("养老保险待遇类");
		types.add("社会保险稽核类");
		types.add("社会保险管理类");
		types.add("社会保险业务统计报表类");
		types.add("失业保险待遇类");
		types.add("社会保险征缴类");
	}
	public List<UnitDocument>addSomeDocumentFromList(List<UnitDocument>documents){
		List<UnitDocument>result=new ArrayList<UnitDocument>();
		for(UnitDocument document:documents){
			for(String type :types){
				if(this.findDocument(document, type)==null){
					this.addUnitDocument(document, type);
				}
				else{
					result.add(document);
				}
			}
		}
		return result;
	}
	public List<UnitDocument> findAll(String type){	
		if(type.equals(U_B_I_D)){			
			return unitBirthInsuranceDocumentDAO.findAll();
		}
		else if(type.equals(U_I_I_D)){			
			return unitInjeryInsuranceDocumentDAO.findAll();
		}
		else if(type.equals(U_M_I_D)){				
			return unitMedicalInsuranceDocumentDAO.findAll();
		}
		else if(type.equals(U_P_I_D)){			
			return unitPensionInsuranceDocumentDAO.findAll();
		}
		else if(type.equals(U_S_I_A_D)){
			return unitSocialInsuranceAuditDocumentDAO.findAll();
		}
		else if(type.equals(U_S_I_M_D)){
			return unitSocialInsuranceManagerDocumentDAO.findAll();
		}
		else if(type.equals(U_S_I_C_D)){
			return unitSocialInsuranceCollectionDocumentDAO.findAll();
		}
		else if(type.equals(U_S_I_S_D)){
			return unitSocialInsuranceStatisticsDocumentDAO.findAll();
		}
		else if(type.equals(U_U_I_D)){
			return unitUnemployeeInsuranceDocumentDAO.findAll();
		}
		return null;
	}
	
	public UnitDocument findById(int id,String type){	
		if(type.equals(U_B_I_D)){			
			return unitBirthInsuranceDocumentDAO.findById(id);
		}
		else if(type.equals(U_I_I_D)){			
			return unitInjeryInsuranceDocumentDAO.findById(id);
		}
		else if(type.equals(U_M_I_D)){				
			return unitMedicalInsuranceDocumentDAO.findById(id);
		}
		else if(type.equals(U_P_I_D)){			
			return unitPensionInsuranceDocumentDAO.findById(id);
		}
		else if(type.equals(U_S_I_A_D)){
			return unitSocialInsuranceAuditDocumentDAO.findById(id);
		}
		else if(type.equals(U_S_I_M_D)){
			return unitSocialInsuranceManagerDocumentDAO.findById(id);
		}
		else if(type.equals(U_S_I_C_D)){
			return unitSocialInsuranceCollectionDocumentDAO.findById(id);
		}
		else if(type.equals(U_S_I_S_D)){
			return unitSocialInsuranceStatisticsDocumentDAO.findById(id);
		}
		else if(type.equals(U_U_I_D)){
			return unitUnemployeeInsuranceDocumentDAO.findById(id);
		}
		return null;
	}
	
	
	public List findDocumentByCirteria(DetachedCriteria detachedCriteria,String type){
		if(type.equals(U_B_I_D)){			
			return unitBirthInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(U_I_I_D)){			
			return unitInjeryInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(U_M_I_D)){				
			return unitMedicalInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(U_P_I_D)){			
			return unitPensionInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(U_S_I_A_D)){
			return unitSocialInsuranceAuditDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);		
		}
		else if(type.equals(U_S_I_M_D)){
			return unitSocialInsuranceManagerDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);			
		}
		else if(type.equals(U_S_I_C_D)){
			return unitSocialInsuranceCollectionDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(U_S_I_S_D)){
			return unitSocialInsuranceStatisticsDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);			
		}
		else if(type.equals(U_U_I_D)){
			return unitUnemployeeInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		return null;
	}
	
	public List findDocumentByCirteriaWithSize(DetachedCriteria detachedCriteria,String type,int first,int max){
		if(type.equals(U_B_I_D)){			
			return unitBirthInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(U_I_I_D)){			
			return unitInjeryInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(U_M_I_D)){				
			return unitMedicalInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(U_P_I_D)){			
			return unitPensionInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(U_S_I_A_D)){
			return unitSocialInsuranceAuditDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);		
		}
		else if(type.equals(U_S_I_M_D)){
			return unitSocialInsuranceManagerDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);			
		}
		else if(type.equals(U_S_I_C_D)){
			return unitSocialInsuranceCollectionDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(U_S_I_S_D)){
			return unitSocialInsuranceStatisticsDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);			
		}
		else if(type.equals(U_U_I_D)){
			return unitUnemployeeInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		return null;
	}
	
	public int TotalRow(DetachedCriteria detachedCriteria,String type){
		String hql = "select count(*) from " + gainTableName(type) + " as model";
		if(type.equals(U_B_I_D)){	
			
			 return ((Number)unitBirthInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(U_I_I_D)){			
			return ((Number)unitInjeryInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(U_M_I_D)){				
			return ((Number)unitMedicalInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(U_P_I_D)){			
			return ((Number)unitPensionInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(U_S_I_A_D)){
			return ((Number)unitSocialInsuranceAuditDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();		
		}
		else if(type.equals(U_S_I_M_D)){
			return ((Number)unitSocialInsuranceManagerDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();			
		}
		else if(type.equals(U_S_I_C_D)){
			return ((Number)unitSocialInsuranceCollectionDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(U_S_I_S_D)){
			return ((Number)unitSocialInsuranceStatisticsDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();			
		}
		else if(type.equals(U_U_I_D)){
			return ((Number)unitUnemployeeInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		return (int)0;
	}
	
	public PageBean findDocumentWithPage(UnitDocument document,String type,int pageSize,int page){
		document=changeToSpecialDocument(document,type);
		if(type.equals(U_B_I_D)){			
			return this.findDocumentWithPageByUnitIdentifyIdAndTime(document, type, pageSize, page, unitBirthInsuranceDocumentDAO);
		}
		else if(type.equals(U_I_I_D)){			
			return this.findDocumentWithPageByUnitIdentifyIdAndTime(document, type, pageSize, page, unitInjeryInsuranceDocumentDAO);
		}
		else if(type.equals(U_M_I_D)){				
			return this.findDocumentWithPageByUnitIdentifyIdAndTime(document, type, pageSize, page, unitMedicalInsuranceDocumentDAO);
		}
		else if(type.equals(U_P_I_D)){			
			return this.findDocumentWithPageByUnitIdentifyIdAndTime(document, type, pageSize, page, unitPensionInsuranceDocumentDAO);
		}
		else if(type.equals(U_S_I_A_D)){
			return this.findDocumentWithPageByUnitIdentifyIdAndTime(document, type, pageSize, page, unitSocialInsuranceAuditDocumentDAO);		
		}
		else if(type.equals(U_S_I_M_D)){
			return this.findDocumentWithPageByUnitIdentifyIdAndTime(document, type, pageSize, page, unitSocialInsuranceManagerDocumentDAO);			
		}
		else if(type.equals(U_S_I_C_D)){
			return this.findDocumentWithPageByUnitIdentifyIdAndTime(document, type, pageSize, page, unitSocialInsuranceCollectionDocumentDAO);
		}
		else if(type.equals(U_S_I_S_D)){
			return this.findDocumentWithPageByUnitIdentifyIdAndTime(document, type, pageSize, page, unitSocialInsuranceStatisticsDocumentDAO);			
		}
		else if(type.equals(U_U_I_D)){
			return this.findDocumentWithPageByUnitIdentifyIdAndTime(document, type, pageSize, page, unitUnemployeeInsuranceDocumentDAO);
		}
		return null;
	}
	private UnitDocument changeToSpecialDocument(UnitDocument document,
			String type) {
		if(type.equals(U_B_I_D)){
			UnitBirthInsuranceDocument adder= new UnitBirthInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			return adder;
		}
		else if(type.equals(U_I_I_D)){
			UnitInjeryInsuranceDocument adder =new UnitInjeryInsuranceDocument();
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(U_M_I_D)){
			UnitMedicalInsuranceDocument adder=new UnitMedicalInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(U_P_I_D)){
			UnitPensionInsuranceDocument adder = new UnitPensionInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(U_S_I_A_D)){
			UnitSocialInsuranceAuditDocument adder= new UnitSocialInsuranceAuditDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(U_S_I_M_D)){
			UnitSocialInsuranceManagerDocument adder=new UnitSocialInsuranceManagerDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(U_S_I_C_D)){
			UnitSocialInsuranceCollectionDocument adder=new UnitSocialInsuranceCollectionDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(U_S_I_S_D)){
			UnitSocialInsuranceStatisticsDocument adder=new UnitSocialInsuranceStatisticsDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(U_U_I_D)){
			UnitUnemployeeInsuranceDocument adder =new UnitUnemployeeInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		return null;
	}
	
	public Class changeToSpecialClass(String type) {
		if(type.equals(U_B_I_D)){
			return UnitBirthInsuranceDocument.class; 
		}
		else if(type.equals(U_I_I_D)){
			return UnitInjeryInsuranceDocument.class; 
		}
		else if(type.equals(U_M_I_D)){
			return UnitMedicalInsuranceDocument.class;
		}
		else if(type.equals(U_P_I_D)){
			return UnitPensionInsuranceDocument.class; 
		}
		else if(type.equals(U_S_I_A_D)){
			return UnitSocialInsuranceAuditDocument.class;
		}
		else if(type.equals(U_S_I_M_D)){
			return UnitSocialInsuranceManagerDocument.class;
		}
		else if(type.equals(U_S_I_C_D)){
			return UnitSocialInsuranceCollectionDocument.class;
		}
		else if(type.equals(U_S_I_S_D)){
			return UnitSocialInsuranceStatisticsDocument.class;
		}
		else if(type.equals(U_U_I_D)){
			return UnitUnemployeeInsuranceDocument.class;
		}
		return null;
	}
	private PageBean findDocumentWithPageByUnitIdentifyIdAndTime(UnitDocument document,String type,int pageSize,
			int page,HibernateDaoSupport dao){
		
		String hql=createHqlWithTime(createHqlWithUnitId(createBasisHql(document,type),document),document);
		//maybe wrong
		return createPageBeanFromThisHql(document, pageSize, page, dao, hql);
	}
	private PageBean createPageBeanFromThisHql(UnitDocument document,
			int pageSize, int page, HibernateDaoSupport dao, String hql) {
		List<Object>list=dao.getHibernateTemplate().findByExample(document);
		int totalRow=list.size();
		PageHandler ph=new PageHandler();
		PageBean pb=ph.queryForPage(dao, hql, totalRow, pageSize, page);
		return pb;
	}
	
	private String createHqlWithTime(String hql, UnitDocument document) {
		// TODO Auto-generated method stub
		if(document.getTime()==null||document.getTime().equals(""))
			return hql;
		
		int length=hql.split("where").length;
		if(length==1){
			hql+=" where model.time='"+document.getTime()+"'";
		}
		else{
			hql+=" and model.time='"+document.getTime()+"'";
		}
		return hql;
	}
	private String createHqlWithUnitId(String hql,UnitDocument document) {
		// TODO Auto-generated method stub
		if(document.getUnitIdentifyId()==null||document.getUnitIdentifyId().equals(""))
			return hql;
		int length=hql.split("where").length;
		if(length==1){
			hql+=" where model.unitIdentifyId='"+document.getUnitIdentifyId()+"'";
		}
		else{
			hql+=" and model.unitIdentifyId='"+document.getUnitIdentifyId()+"'";
		}
		return hql;
	}
	private String createBasisHql(UnitDocument document, String type) {
		// TODO Auto-generated method stub
		String hql="from "+gainTableName(type)+" as model";
		return hql;
	}
	private String gainTableName(String type) {
		// TODO Auto-generated method stub
		return TableAndObjectMap.getUnitDocumentModel(type);
	}
	
	
	public UnitDocument addUnitDocument(UnitDocument document ,String type){
		if(type.equals(U_B_I_D)){
			UnitBirthInsuranceDocument adder= new UnitBirthInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.unitBirthInsuranceDocumentDAO.merge(adder);
		}
		else if(type.equals(U_I_I_D)){
			UnitInjeryInsuranceDocument adder =new UnitInjeryInsuranceDocument();
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.unitInjeryInsuranceDocumentDAO.merge(adder);
		}
		else if(type.equals(U_M_I_D)){
			UnitMedicalInsuranceDocument adder=new UnitMedicalInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.unitMedicalInsuranceDocumentDAO.merge(adder);
		}
		else if(type.equals(U_P_I_D)){
			UnitPensionInsuranceDocument adder = new UnitPensionInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.unitPensionInsuranceDocumentDAO.merge(adder);
		}
		else if(type.equals(U_S_I_A_D)){
			UnitSocialInsuranceAuditDocument adder= new UnitSocialInsuranceAuditDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.unitSocialInsuranceAuditDocumentDAO.merge(adder);
		}
		else if(type.equals(U_S_I_M_D)){
			UnitSocialInsuranceManagerDocument adder=new UnitSocialInsuranceManagerDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			 return this.unitSocialInsuranceManagerDocumentDAO.merge(adder);
		}
		else if(type.equals(U_S_I_C_D)){
			UnitSocialInsuranceCollectionDocument adder=new UnitSocialInsuranceCollectionDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.unitSocialInsuranceCollectionDocumentDAO.merge(adder);
		}
		else if(type.equals(U_S_I_S_D)){
			UnitSocialInsuranceStatisticsDocument adder=new UnitSocialInsuranceStatisticsDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.unitSocialInsuranceStatisticsDocumentDAO.merge(adder);
		}
		else if(type.equals(U_U_I_D)){
			UnitUnemployeeInsuranceDocument adder =new UnitUnemployeeInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setUnitName(document.getUnitName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.unitUnemployeeInsuranceDocumentDAO.merge(adder);
		}
		return null;
	}
	
	public UnitDocument findDocument(UnitDocument document ,String type){
		if(type.equals(U_B_I_D)){
			UnitBirthInsuranceDocument s=new UnitBirthInsuranceDocument();
			s.setUnitIdentifyId(document.getUnitIdentifyId());
			s.setTime(document.getTime());
			s.setId(document.getId());
			 List list= this.unitBirthInsuranceDocumentDAO.findByExample(s);
			 if(list!=null&&list.size()>0){
				 return (UnitDocument)list.get(0);
			 }
			 return null;
		}
		else if(type.equals(U_I_I_D)){
			UnitInjeryInsuranceDocument adder =new UnitInjeryInsuranceDocument();
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setTime(document.getTime());
			adder.setId(document.getId());
			List list= this.unitInjeryInsuranceDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (UnitDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(U_M_I_D)){
			UnitMedicalInsuranceDocument adder=new UnitMedicalInsuranceDocument();
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setTime(document.getTime());
			adder.setId(document.getId());
			List list=this.unitMedicalInsuranceDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (UnitDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(U_P_I_D)){
			UnitPensionInsuranceDocument adder = new UnitPensionInsuranceDocument();	
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setTime(document.getTime());
			adder.setId(document.getId());
			List list=this.unitPensionInsuranceDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (UnitDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(U_S_I_A_D)){
			UnitSocialInsuranceAuditDocument adder= new UnitSocialInsuranceAuditDocument();
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setTime(document.getTime());
			adder.setId(document.getId());
			List list=this.unitSocialInsuranceAuditDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (UnitDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(U_S_I_M_D)){
			UnitSocialInsuranceManagerDocument adder=new UnitSocialInsuranceManagerDocument();
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setTime(document.getTime());
			adder.setId(document.getId());
			List list=this.unitSocialInsuranceManagerDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (UnitDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(U_S_I_C_D)){
			UnitSocialInsuranceCollectionDocument adder=new UnitSocialInsuranceCollectionDocument();
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setTime(document.getTime());
			adder.setId(document.getId());
			List list=this.unitSocialInsuranceCollectionDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (UnitDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(U_S_I_S_D)){
			UnitSocialInsuranceStatisticsDocument adder=new UnitSocialInsuranceStatisticsDocument();
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setTime(document.getTime());
			adder.setId(document.getId());
			List list=this.unitSocialInsuranceStatisticsDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (UnitDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(U_U_I_D)){
			UnitUnemployeeInsuranceDocument adder =new UnitUnemployeeInsuranceDocument();
			adder.setUnitIdentifyId(document.getUnitIdentifyId());
			adder.setTime(document.getTime());
			adder.setId(document.getId());
			List list=this.unitUnemployeeInsuranceDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (UnitDocument)list.get(0);
			}
			return null;
		}
		return null;
	}
	
	
	
	public UnitDocument findDocumentOnlyId(UnitDocument document ,String type){
		if(document.getId().equals(null)||document.getId()==0)
			return null;
		if(type.equals(U_B_I_D)){
			return this.unitBirthInsuranceDocumentDAO.findById(document.getId());
		}
		else if(type.equals(U_I_I_D)){

			return this.unitInjeryInsuranceDocumentDAO.findById(document.getId());

		}
		else if(type.equals(U_M_I_D)){
	
			return this.unitMedicalInsuranceDocumentDAO.findById(document.getId());

		}
		else if(type.equals(U_P_I_D)){

			return this.unitPensionInsuranceDocumentDAO.findById(document.getId());

		}
		else if(type.equals(U_S_I_A_D)){

			return this.unitSocialInsuranceAuditDocumentDAO.findById(document.getId());

		}
		else if(type.equals(U_S_I_M_D)){

			return this.unitSocialInsuranceManagerDocumentDAO.findById(document.getId());

		}
		else if(type.equals(U_S_I_C_D)){

		return this.unitSocialInsuranceCollectionDocumentDAO.findById(document.getId());

		}
		else if(type.equals(U_S_I_S_D)){

			return this.unitSocialInsuranceStatisticsDocumentDAO.findById(document.getId());

		}
		else if(type.equals(U_U_I_D)){

			return this.unitUnemployeeInsuranceDocumentDAO.findById(document.getId());
		}
		return null;
	}
	
	
	public void deleteDocument(UnitDocument document ,String type){
		document=this.findDocumentOnlyId(document, type);
		if(document==null){
			return;
		}
		
		if(type.equals(U_B_I_D)){
			UnitBirthInsuranceDocument adder= (UnitBirthInsuranceDocument)document;
			this.unitBirthInsuranceDocumentDAO.delete(adder);
		}
		else if(type.equals(U_I_I_D)){
			UnitInjeryInsuranceDocument adder =(UnitInjeryInsuranceDocument)document;
			this.unitInjeryInsuranceDocumentDAO.delete(adder);
		}
		else if(type.equals(U_M_I_D)){
			UnitMedicalInsuranceDocument adder=( UnitMedicalInsuranceDocument)document;
			this.unitMedicalInsuranceDocumentDAO.delete(adder);
		}
		else if(type.equals(U_P_I_D)){
			UnitPensionInsuranceDocument adder = ( UnitPensionInsuranceDocument)document;
			this.unitPensionInsuranceDocumentDAO.delete(adder);
		}
		else if(type.equals(U_S_I_A_D)){
			UnitSocialInsuranceAuditDocument adder= ( UnitSocialInsuranceAuditDocument)document;
			this.unitSocialInsuranceAuditDocumentDAO.delete(adder);
		}
		else if(type.equals(U_S_I_M_D)){
			UnitSocialInsuranceManagerDocument adder=( UnitSocialInsuranceManagerDocument)document;
			this.unitSocialInsuranceManagerDocumentDAO.delete(adder);
		}
		else if(type.equals(U_S_I_C_D)){
			UnitSocialInsuranceCollectionDocument adder=( UnitSocialInsuranceCollectionDocument)document;
			this.unitSocialInsuranceCollectionDocumentDAO.delete(adder);
		}
		else if(type.equals(U_S_I_S_D)){
			UnitSocialInsuranceStatisticsDocument adder=( UnitSocialInsuranceStatisticsDocument)document;
			this.unitSocialInsuranceStatisticsDocumentDAO.delete(adder);
		}
		else if(type.equals(U_U_I_D)){
			UnitUnemployeeInsuranceDocument adder =(UnitUnemployeeInsuranceDocument)document;
			this.unitUnemployeeInsuranceDocumentDAO.delete(adder);;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public UnitBirthInsuranceDocumentDAO getUnitBirthInsuranceDocumentDAO() {
		return unitBirthInsuranceDocumentDAO;
	}
	public UnitInjeryInsuranceDocumentDAO getUnitInjeryInsuranceDocumentDAO() {
		return unitInjeryInsuranceDocumentDAO;
	}
	public UnitMedicalInsuranceDocumentDAO getUnitMedicalInsuranceDocumentDAO() {
		return unitMedicalInsuranceDocumentDAO;
	}
	public UnitPensionInsuranceDocumentDAO getUnitPensionInsuranceDocumentDAO() {
		return unitPensionInsuranceDocumentDAO;
	}
	public UnitSocialInsuranceAuditDocumentDAO getUnitSocialInsuranceAuditDocumentDAO() {
		return unitSocialInsuranceAuditDocumentDAO;
	}
	public UnitSocialInsuranceCollectionDocumentDAO getUnitSocialInsuranceCollectionDocumentDAO() {
		return unitSocialInsuranceCollectionDocumentDAO;
	}
	public UnitSocialInsuranceManagerDocumentDAO getUnitSocialInsuranceManagerDocumentDAO() {
		return unitSocialInsuranceManagerDocumentDAO;
	}
	public UnitSocialInsuranceStatisticsDocumentDAO getUnitSocialInsuranceStatisticsDocumentDAO() {
		return unitSocialInsuranceStatisticsDocumentDAO;
	}
	public UnitUnemployeeInsuranceDocumentDAO getUnitUnemployeeInsuranceDocumentDAO() {
		return unitUnemployeeInsuranceDocumentDAO;
	}
	public void setUnitBirthInsuranceDocumentDAO(
			UnitBirthInsuranceDocumentDAO unitBirthInsuranceDocumentDAO) {
		this.unitBirthInsuranceDocumentDAO = unitBirthInsuranceDocumentDAO;
	}
	public void setUnitInjeryInsuranceDocumentDAO(
			UnitInjeryInsuranceDocumentDAO unitInjeryInsuranceDocumentDAO) {
		this.unitInjeryInsuranceDocumentDAO = unitInjeryInsuranceDocumentDAO;
	}
	public void setUnitMedicalInsuranceDocumentDAO(
			UnitMedicalInsuranceDocumentDAO unitMedicalInsuranceDocumentDAO) {
		this.unitMedicalInsuranceDocumentDAO = unitMedicalInsuranceDocumentDAO;
	}
	public void setUnitPensionInsuranceDocumentDAO(
			UnitPensionInsuranceDocumentDAO unitPensionInsuranceDocumentDAO) {
		this.unitPensionInsuranceDocumentDAO = unitPensionInsuranceDocumentDAO;
	}
	public void setUnitSocialInsuranceAuditDocumentDAO(
			UnitSocialInsuranceAuditDocumentDAO unitSocialInsuranceAuditDocumentDAO) {
		this.unitSocialInsuranceAuditDocumentDAO = unitSocialInsuranceAuditDocumentDAO;
	}
	public void setUnitSocialInsuranceCollectionDocumentDAO(
			UnitSocialInsuranceCollectionDocumentDAO unitSocialInsuranceCollectionDocumentDAO) {
		this.unitSocialInsuranceCollectionDocumentDAO = unitSocialInsuranceCollectionDocumentDAO;
	}
	public void setUnitSocialInsuranceManagerDocumentDAO(
			UnitSocialInsuranceManagerDocumentDAO unitSocialInsuranceManagerDocumentDAO) {
		this.unitSocialInsuranceManagerDocumentDAO = unitSocialInsuranceManagerDocumentDAO;
	}
	public void setUnitSocialInsuranceStatisticsDocumentDAO(
			UnitSocialInsuranceStatisticsDocumentDAO unitSocialInsuranceStatisticsDocumentDAO) {
		this.unitSocialInsuranceStatisticsDocumentDAO = unitSocialInsuranceStatisticsDocumentDAO;
	}
	public void setUnitUnemployeeInsuranceDocumentDAO(
			UnitUnemployeeInsuranceDocumentDAO unitUnemployeeInsuranceDocumentDAO) {
		this.unitUnemployeeInsuranceDocumentDAO = unitUnemployeeInsuranceDocumentDAO;
	}
	
}
