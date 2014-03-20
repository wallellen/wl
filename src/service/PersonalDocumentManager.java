package service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import util.PageBean;
import util.TableAndObjectMap;

import bean.*;
import DAO.*;
import DAO.util.PageHandler;


public class PersonalDocumentManager {
	public PersonalBirthInsuranceDocumentDAO getPersonalBirthInsuranceDocumentDAO() {
		return personalBirthInsuranceDocumentDAO;
	}

	public PersonalInjuryInsuranceDocumentDAO getPersonalInjuryInsuranceDocumentDAO() {
		return personalInjuryInsuranceDocumentDAO;
	}

	public PersonalMedicalInsuranceDocumentDAO getPersonalMedicalInsuranceDocumentDAO() {
		return personalMedicalInsuranceDocumentDAO;
	}

	public PersonalPensionInsuranceDocumentDAO getPersonalPensionInsuranceDocumentDAO() {
		return personalPensionInsuranceDocumentDAO;
	}

	public PersonalSocialInsuranceAuditDocumentDAO getPersonalSocialInsuranceAuditDocumentDAO() {
		return personalSocialInsuranceAuditDocumentDAO;
	}

	public PersonalSocialInsuranceCollectionDocumentDAO getPersonalSocialInsuranceCollectionDocumentDAO() {
		return personalSocialInsuranceCollectionDocumentDAO;
	}

	public PersonalSocialInsuranceDocumentDAO getPersonalSocialInsuranceDocumentDAO() {
		return personalSocialInsuranceDocumentDAO;
	}

	public PersonalSocialInsuranceStatisticsDocumentDAO getPersonalSocialInsuranceStatisticsDocumentDAO() {
		return personalSocialInsuranceStatisticsDocumentDAO;
	}

	public PersonalUnemployeeInsuranceDocumentDAO getPersonalUnemployeeInsuranceDocumentDAO() {
		return personalUnemployeeInsuranceDocumentDAO;
	}

	public void setPersonalBirthInsuranceDocumentDAO(
			PersonalBirthInsuranceDocumentDAO personalBirthInsuranceDocumentDAO) {
		this.personalBirthInsuranceDocumentDAO = personalBirthInsuranceDocumentDAO;
	}

	public void setPersonalInjuryInsuranceDocumentDAO(
			PersonalInjuryInsuranceDocumentDAO personalInjuryInsuranceDocumentDAO) {
		this.personalInjuryInsuranceDocumentDAO = personalInjuryInsuranceDocumentDAO;
	}

	public void setPersonalMedicalInsuranceDocumentDAO(
			PersonalMedicalInsuranceDocumentDAO personalMedicalInsuranceDocumentDAO) {
		this.personalMedicalInsuranceDocumentDAO = personalMedicalInsuranceDocumentDAO;
	}

	public void setPersonalPensionInsuranceDocumentDAO(
			PersonalPensionInsuranceDocumentDAO personalPensionInsuranceDocumentDAO) {
		this.personalPensionInsuranceDocumentDAO = personalPensionInsuranceDocumentDAO;
	}

	public void setPersonalSocialInsuranceAuditDocumentDAO(
			PersonalSocialInsuranceAuditDocumentDAO personalSocialInsuranceAuditDocumentDAO) {
		this.personalSocialInsuranceAuditDocumentDAO = personalSocialInsuranceAuditDocumentDAO;
	}

	public void setPersonalSocialInsuranceCollectionDocumentDAO(
			PersonalSocialInsuranceCollectionDocumentDAO personalSocialInsuranceCollectionDocumentDAO) {
		this.personalSocialInsuranceCollectionDocumentDAO = personalSocialInsuranceCollectionDocumentDAO;
	}

	public void setPersonalSocialInsuranceDocumentDAO(
			PersonalSocialInsuranceDocumentDAO personalSocialInsuranceDocumentDAO) {
		this.personalSocialInsuranceDocumentDAO = personalSocialInsuranceDocumentDAO;
	}

	public void setPersonalSocialInsuranceStatisticsDocumentDAO(
			PersonalSocialInsuranceStatisticsDocumentDAO personalSocialInsuranceStatisticsDocumentDAO) {
		this.personalSocialInsuranceStatisticsDocumentDAO = personalSocialInsuranceStatisticsDocumentDAO;
	}

	public void setPersonalUnemployeeInsuranceDocumentDAO(
			PersonalUnemployeeInsuranceDocumentDAO personalUnemployeeInsuranceDocumentDAO) {
		this.personalUnemployeeInsuranceDocumentDAO = personalUnemployeeInsuranceDocumentDAO;
	}

	private PersonalBirthInsuranceDocumentDAO personalBirthInsuranceDocumentDAO;
	private PersonalInjuryInsuranceDocumentDAO personalInjuryInsuranceDocumentDAO;
	private PersonalMedicalInsuranceDocumentDAO personalMedicalInsuranceDocumentDAO;
	private PersonalPensionInsuranceDocumentDAO personalPensionInsuranceDocumentDAO;
	private PersonalSocialInsuranceAuditDocumentDAO personalSocialInsuranceAuditDocumentDAO;
	private PersonalSocialInsuranceCollectionDocumentDAO personalSocialInsuranceCollectionDocumentDAO;
	private PersonalSocialInsuranceDocumentDAO personalSocialInsuranceDocumentDAO;
	private PersonalSocialInsuranceStatisticsDocumentDAO personalSocialInsuranceStatisticsDocumentDAO;
	private PersonalUnemployeeInsuranceDocumentDAO personalUnemployeeInsuranceDocumentDAO;
	public static final String P_B_I_D="生育保险待遇类";
	public static final String P_I_I_D="工伤保险待遇类";
	public static final String P_M_I_D="医疗保险待遇类";
	public static final String P_P_I_D="养老保险待遇类";
	public static final String P_S_I_A_D="社会保险稽核类";
	public static final String P_S_I_M_D="社会保险管理类";
	public static final String P_S_I_S_D="社会保险业务统计报表类";
	public static final String P_U_I_D="失业保险待遇类";
	public static final String P_S_I_C_D="社会保险征缴类";
	
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
	public List<PersonalDocument>addSomeDocumentFromList(List<PersonalDocument>documents){
		List<PersonalDocument>result=new ArrayList<PersonalDocument>();
		for(PersonalDocument document:documents){
			for(String type :types){
				if(this.findDocument(document, type)==null){
					this.addPersonalDocument(document, type);
				}
				else{
					result.add(document);
				}
			}
		}
		return result;
	}
	public List<PersonalDocument> findAll(String type){		
		if(type.equals(P_B_I_D)){			
			 return personalBirthInsuranceDocumentDAO.findAll();
		}
		else if(type.equals(P_I_I_D)){
			 return personalInjuryInsuranceDocumentDAO.findAll();

		}
		else if(type.equals(P_M_I_D)){
			 return personalMedicalInsuranceDocumentDAO.findAll();

		}
		else if(type.equals(P_P_I_D)){
			 return personalPensionInsuranceDocumentDAO.findAll();

		}
		else if(type.equals(P_S_I_A_D)){
			 return personalSocialInsuranceAuditDocumentDAO.findAll();

		}
		else if(type.equals(P_S_I_M_D)){
			 return personalSocialInsuranceDocumentDAO.findAll();

		}
		else if(type.equals(P_S_I_C_D)){
			 return personalSocialInsuranceCollectionDocumentDAO.findAll();

		}
		else if(type.equals(P_S_I_S_D)){
			 return personalSocialInsuranceStatisticsDocumentDAO.findAll();

		}
		else if(type.equals(P_U_I_D)){
			 return personalUnemployeeInsuranceDocumentDAO.findAll();
			
			}
		return null;	
	}
	
	public PersonalDocument findById(int id,String type){		
		if(type.equals(P_B_I_D)){			
			 return personalBirthInsuranceDocumentDAO.findById(id);
		}
		else if(type.equals(P_I_I_D)){
			 return personalInjuryInsuranceDocumentDAO.findById(id);

		}
		else if(type.equals(P_M_I_D)){
			 return personalMedicalInsuranceDocumentDAO.findById(id);

		}
		else if(type.equals(P_P_I_D)){
			 return personalPensionInsuranceDocumentDAO.findById(id);

		}
		else if(type.equals(P_S_I_A_D)){
			 return personalSocialInsuranceAuditDocumentDAO.findById(id);

		}
		else if(type.equals(P_S_I_M_D)){
			 return personalSocialInsuranceDocumentDAO.findById(id);

		}
		else if(type.equals(P_S_I_C_D)){
			 return personalSocialInsuranceCollectionDocumentDAO.findById(id);

		}
		else if(type.equals(P_S_I_S_D)){
			 return personalSocialInsuranceStatisticsDocumentDAO.findById(id);

		}
		else if(type.equals(P_U_I_D)){
			 return personalUnemployeeInsuranceDocumentDAO.findById(id);
			
			}
		return null;	
	}
	
	public List findDocumentByCirteria(DetachedCriteria detachedCriteria,String type){
		if(type.equals(P_B_I_D)){			
			return personalBirthInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(P_I_I_D)){			
			return personalInjuryInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(P_M_I_D)){				
			return personalMedicalInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(P_P_I_D)){			
			return personalPensionInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(P_S_I_A_D)){
			return personalSocialInsuranceAuditDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);		
		}
		else if(type.equals(P_S_I_M_D)){
			return personalSocialInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);			
		}
		else if(type.equals(P_S_I_C_D)){
			return personalSocialInsuranceCollectionDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		else if(type.equals(P_S_I_S_D)){
			return personalSocialInsuranceStatisticsDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);			
		}
		else if(type.equals(P_U_I_D)){
			return personalUnemployeeInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		}
		return null;
	}
	public List findDocumentByCirteriaWithSize(DetachedCriteria detachedCriteria,String type,int first,int max){
		if(type.equals(P_B_I_D)){			
			return personalBirthInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(P_I_I_D)){			
			return personalInjuryInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(P_M_I_D)){				
			return personalMedicalInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(P_P_I_D)){			
			return personalPensionInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(P_S_I_A_D)){
			return personalSocialInsuranceAuditDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);		
		}
		else if(type.equals(P_S_I_M_D)){
			return personalSocialInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);			
		}
		else if(type.equals(P_S_I_C_D)){
			return personalSocialInsuranceCollectionDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		else if(type.equals(P_S_I_S_D)){
			return personalSocialInsuranceStatisticsDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);			
		}
		else if(type.equals(P_U_I_D)){
			return personalUnemployeeInsuranceDocumentDAO.getHibernateTemplate().findByCriteria(detachedCriteria,first,max);
		}
		return null;
	}
	
	
	public int TotalRow(DetachedCriteria detachedCriteria,String type){
		String hql = "select count(*) from " + gainTableName(type) + " as model";
		if(type.equals(P_B_I_D)){	
			
			 return ((Number)personalBirthInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(P_I_I_D)){			
			return ((Number)personalInjuryInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(P_M_I_D)){				
			return ((Number)personalMedicalInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(P_P_I_D)){			
			return ((Number)personalPensionInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(P_S_I_A_D)){
			return ((Number)personalSocialInsuranceAuditDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();		
		}
		else if(type.equals(P_S_I_M_D)){
			return ((Number)personalSocialInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();			
		}
		else if(type.equals(P_S_I_C_D)){
			return ((Number)personalSocialInsuranceCollectionDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		else if(type.equals(P_S_I_S_D)){
			return ((Number)personalSocialInsuranceStatisticsDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();			
		}
		else if(type.equals(P_U_I_D)){
			return ((Number)personalUnemployeeInsuranceDocumentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		}
		return (int)0;
	}
	
	public PageBean findDocumentWithPage(PersonalDocument document,String type,int pageSize,int page){
		document=changeToSpecialDocument(document,type);
		
		if(type.equals(P_B_I_D)){

			
			return this.findDocumentWithPageBySocialInsuranceNumberAndTime(document, type, pageSize, page, personalBirthInsuranceDocumentDAO);
		}
		else if(type.equals(P_I_I_D)){

			return this.findDocumentWithPageBySocialInsuranceNumberAndTime(document, type, pageSize, page, personalInjuryInsuranceDocumentDAO);

		}
		else if(type.equals(P_M_I_D)){

			return this.findDocumentWithPageBySocialInsuranceNumberAndTime(document, type, pageSize, page, personalMedicalInsuranceDocumentDAO);

		}
		else if(type.equals(P_P_I_D)){
			return this.findDocumentWithPageBySocialInsuranceNumberAndTime(document, type, pageSize, page, personalPensionInsuranceDocumentDAO);

		}
		else if(type.equals(P_S_I_A_D)){
			return this.findDocumentWithPageBySocialInsuranceNumberAndTime(document, type, pageSize, page, personalSocialInsuranceAuditDocumentDAO);

		}
		else if(type.equals(P_S_I_M_D)){
			return this.findDocumentWithPageBySocialInsuranceNumberAndTime(document, type, pageSize, page, personalSocialInsuranceDocumentDAO);

		}
		else if(type.equals(P_S_I_C_D)){
			return this.findDocumentWithPageBySocialInsuranceNumberAndTime(document, type, pageSize, page, personalSocialInsuranceCollectionDocumentDAO);

		}
		else if(type.equals(P_S_I_S_D)){
			return this.findDocumentWithPageBySocialInsuranceNumberAndTime(document, type, pageSize, page, personalSocialInsuranceStatisticsDocumentDAO);

		}
		else if(type.equals(P_U_I_D)){
			return this.findDocumentWithPageBySocialInsuranceNumberAndTime(document, type, pageSize, page, personalUnemployeeInsuranceDocumentDAO);
			
			}
		return null;	
	}
	
	
	private PersonalDocument changeToSpecialDocument(PersonalDocument document,String type) {
		// TODO Auto-generated method stub
		if(type.equals(P_B_I_D)){
			PersonalBirthInsuranceDocument s= new PersonalBirthInsuranceDocument();
			s.setId(document.getId());
			s.setTime(document.getTime());
			s.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			s.setIdentifyCardId(document.getIdentifyCardId());
			s.setName(document.getName());
			s.setPhysicsAdress(document.getPhysicsAdress());
			s.setDocumentName(document.getDocumentName());
			s.setRetentionPeriod(document.getRetentionPeriod());
			return s;
		}
		else if(type.equals(P_I_I_D)){
			PersonalInjuryInsuranceDocument adder =new PersonalInjuryInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(P_M_I_D)){
			PersonalMedicalInsuranceDocument adder=new PersonalMedicalInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			return adder;
		}
		else if(type.equals(P_P_I_D)){
			PersonalPensionInsuranceDocument adder = new PersonalPensionInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(P_S_I_A_D)){
			PersonalSocialInsuranceAuditDocument adder= new PersonalSocialInsuranceAuditDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(P_S_I_C_D)){
			PersonalSocialInsuranceCollectionDocument adder=new PersonalSocialInsuranceCollectionDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			return adder;
		}
		else if(type.equals(P_S_I_M_D)){

			PersonalSocialInsuranceDocument adder=new PersonalSocialInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			return adder;
		}
		else if(type.equals(P_S_I_S_D)){
			PersonalSocialInsuranceStatisticsDocument adder=new  PersonalSocialInsuranceStatisticsDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}
		else if(type.equals(P_U_I_D)){
			PersonalUnemployeeInsuranceDocument adder =new PersonalUnemployeeInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			return adder;
		}	
		return null;
	}

	public Class changeToSpecialClass(String type){
		if(type.equals(P_B_I_D)){
			return PersonalBirthInsuranceDocument.class;
		}
		
		else if(type.equals(P_I_I_D)){
			return PersonalInjuryInsuranceDocument.class; 
		}
		else if(type.equals(P_M_I_D)){
			return PersonalMedicalInsuranceDocument.class;
		}
		else if(type.equals(P_P_I_D)){
			return PersonalPensionInsuranceDocument.class;
		}
		else if(type.equals(P_S_I_A_D)){
			return PersonalSocialInsuranceAuditDocument.class;
		}
		else if(type.equals(P_S_I_C_D)){
			return PersonalSocialInsuranceCollectionDocument.class;
		}
		else if(type.equals(P_S_I_M_D)){
			return PersonalSocialInsuranceDocument.class;
		}
		else if(type.equals(P_S_I_S_D)){
			return PersonalSocialInsuranceStatisticsDocument.class;
			
		}
		else if(type.equals(P_U_I_D)){
			return PersonalUnemployeeInsuranceDocument.class; 
		}
		return null;
	}
	
	private PageBean findDocumentWithPageBySocialInsuranceNumberAndTime(PersonalDocument document,String type,int pageSize,
			int page,HibernateDaoSupport dao){
		
		String hql=createHqlWithIdentifyCardId(
				createHqlWithTime(createHqlWithSocialInsuranceNumber(createBasisHql(document,type),document),document),document);
		//maybe wrong
		return createPageBeanFromThisHql(document, pageSize, page, dao, hql);
	}
	private PageBean createPageBeanFromThisHql(PersonalDocument document,
			int pageSize, int page, HibernateDaoSupport dao, String hql) {
		List<Object>list=dao.getHibernateTemplate().findByExample(document);
		int totalRow=list.size();
		PageHandler ph=new PageHandler();
		PageBean pb=ph.queryForPage(dao, hql, totalRow, pageSize, page);
		return pb;
	}
	private String createHqlWithIdentifyCardId(String hql, PersonalDocument document) {
		// TODO Auto-generated method stub
		if(document.getIdentifyCardId()==null||document.getIdentifyCardId().equals(""))
			return hql;
		
		int length=hql.split("where").length;
		if(length==1){
			//hql+=" where model.identifyCardId='"+document.getIdentifyCardId()+"'";
			hql+=" where model.identifyCardId like '%"+document.getIdentifyCardId()+"%'";
		}
		else{
			hql+=" and model.identifyCardId like '%"+document.getIdentifyCardId()+"%'";
		}
		return hql;
	}
	private String createHqlWithTime(String hql, PersonalDocument document) {
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
	private String createHqlWithSocialInsuranceNumber(String hql,PersonalDocument document) {
		// TODO Auto-generated method stub
		if(document.getSocialInsuranceNumber()==null||document.getSocialInsuranceNumber().equals(""))
			return hql;
		
		int length=hql.split("where").length;
		if(length==1){
			hql+=" where model.socialInsuranceNumber like '%"+document.getSocialInsuranceNumber()+"%'";
		}
		else{
			hql+=" and model.socialInsuranceNumber like '%"+document.getSocialInsuranceNumber()+"%'";
		}
		return hql;
	}
	private String createBasisHql(PersonalDocument document, String type) {
		// TODO Auto-generated method stub
		String hql="from "+gainTableName(type)+" as model";
		return hql;
	}
	private String gainTableName(String type) {
		// TODO Auto-generated method stub
		return TableAndObjectMap.getPersonalDocumentModel(type);
	}
	
	
	
	
	/***
	 * 既可以加也可以更新（因为用的是merge）
	 * @param document
	 * @param type
	 */
	public PersonalDocument addPersonalDocument(PersonalDocument document ,String type){
		if(type.equals(P_B_I_D)){
			PersonalBirthInsuranceDocument s= new PersonalBirthInsuranceDocument();
			s.setId(document.getId());
			s.setTime(document.getTime());
			s.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			s.setIdentifyCardId(document.getIdentifyCardId());
			s.setName(document.getName());
			s.setPhysicsAdress(document.getPhysicsAdress());
			s.setDocumentName(document.getDocumentName());
			s.setRetentionPeriod(document.getRetentionPeriod());
			s.setRetentionPeriod(document.getRetentionPeriod());
			
			
			s.setArchive(document.getArchive());
			s.setAuthor(document.getAuthor());
			s.setComments(document.getComments());
			s.setFileNumber(document.getFileNumber());
			s.setPageNumber(document.getPageNumber());
			s.setSequenceNumber(document.getSequenceNumber());
			s.setTitle(document.getTitle());
			/**
			 * 添加其他的内容
			 */
			return this.personalBirthInsuranceDocumentDAO.merge(s);
		}
		else if(type.equals(P_I_I_D)){
			PersonalInjuryInsuranceDocument adder =new PersonalInjuryInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			
			return this.personalInjuryInsuranceDocumentDAO.merge(adder);
		}
		else if(type.equals(P_M_I_D)){
			PersonalMedicalInsuranceDocument adder=new PersonalMedicalInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.personalMedicalInsuranceDocumentDAO.merge(adder);
		}
		else if(type.equals(P_P_I_D)){
			PersonalPensionInsuranceDocument adder = new PersonalPensionInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.personalPensionInsuranceDocumentDAO.merge(adder);
		}
		else if(type.equals(P_S_I_A_D)){
			PersonalSocialInsuranceAuditDocument adder= new PersonalSocialInsuranceAuditDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.personalSocialInsuranceAuditDocumentDAO.merge(adder);
		}
		else if(type.equals(P_S_I_C_D)){
			PersonalSocialInsuranceCollectionDocument adder=new PersonalSocialInsuranceCollectionDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.personalSocialInsuranceCollectionDocumentDAO.merge(adder);
		}
		else if(type.equals(P_S_I_M_D)){

			PersonalSocialInsuranceDocument adder=new PersonalSocialInsuranceDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.personalSocialInsuranceDocumentDAO.merge(adder);
		}
		else if(type.equals(P_S_I_S_D)){
			PersonalSocialInsuranceStatisticsDocument adder=new  PersonalSocialInsuranceStatisticsDocument();
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.personalSocialInsuranceStatisticsDocumentDAO.merge(adder);
		}
		else if(type.equals(P_U_I_D)){
			PersonalUnemployeeInsuranceDocument adder =new PersonalUnemployeeInsuranceDocument();
			//adder = (PersonalUnemployeeInsuranceDocument)(document);
			adder.setId(document.getId());
			adder.setTime(document.getTime());
			adder.setRetentionPeriod(document.getRetentionPeriod());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setIdentifyCardId(document.getIdentifyCardId());
			adder.setName(document.getName());
			adder.setPhysicsAdress(document.getPhysicsAdress());
			adder.setDocumentName(document.getDocumentName());
			
			adder.setArchive(document.getArchive());
			adder.setAuthor(document.getAuthor());
			adder.setComments(document.getComments());
			adder.setFileNumber(document.getFileNumber());
			adder.setPageNumber(document.getPageNumber());
			adder.setSequenceNumber(document.getSequenceNumber());
			adder.setTitle(document.getTitle());
			return this.personalUnemployeeInsuranceDocumentDAO.merge(adder);
		}
		return null;
	}
	
	public PersonalDocument findDocument(PersonalDocument document ,String type){
		if(type.equals(P_B_I_D)){
			PersonalBirthInsuranceDocument s= new PersonalBirthInsuranceDocument();
			s.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			s.setTime(document.getTime());
			 List list= this.personalBirthInsuranceDocumentDAO.findByExample(s);
			 if(list!=null&&list.size()>0){
				 return (PersonalDocument)list.get(0);
			 }
			 return null;
		}
		else if(type.equals(P_I_I_D)){
			PersonalInjuryInsuranceDocument adder =new PersonalInjuryInsuranceDocument();
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setTime(document.getTime());
			List list= this.personalInjuryInsuranceDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (PersonalDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(P_M_I_D)){
			PersonalMedicalInsuranceDocument adder=new PersonalMedicalInsuranceDocument();
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setTime(document.getTime());
			List list=this.personalMedicalInsuranceDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (PersonalDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(P_P_I_D)){
			PersonalPensionInsuranceDocument adder = new PersonalPensionInsuranceDocument();
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setTime(document.getTime());
			List list=this.personalPensionInsuranceDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (PersonalDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(P_S_I_A_D)){
			PersonalSocialInsuranceAuditDocument adder= new PersonalSocialInsuranceAuditDocument();
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setTime(document.getTime());
			List list=this.personalSocialInsuranceAuditDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (PersonalDocument)list.get(0);
			}
			return null;
		}
		else if(type.equals(P_S_I_M_D)){
			PersonalSocialInsuranceDocument adder=new PersonalSocialInsuranceDocument();
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setTime(document.getTime());
			List list=this.personalSocialInsuranceDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return(PersonalDocument) list.get(0);
			}
			return null;
		}
		else if(type.equals(P_S_I_C_D)){
			PersonalSocialInsuranceCollectionDocument adder=new PersonalSocialInsuranceCollectionDocument();
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setTime(document.getTime());
			List list=this.personalSocialInsuranceCollectionDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return(PersonalDocument) list.get(0);
			}
			return null;
		}
		else if(type.equals(P_S_I_S_D)){
			PersonalSocialInsuranceStatisticsDocument adder=new  PersonalSocialInsuranceStatisticsDocument();
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setTime(document.getTime());
			List list=this.personalSocialInsuranceStatisticsDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return(PersonalDocument) list.get(0);
			}
			return null;
		}
		else if(type.equals(P_U_I_D)){
			PersonalUnemployeeInsuranceDocument adder =new PersonalUnemployeeInsuranceDocument();
			adder.setSocialInsuranceNumber(document.getSocialInsuranceNumber());
			adder.setTime(document.getTime());
			List list=this.personalUnemployeeInsuranceDocumentDAO.findByExample(adder);
			if(list!=null&&list.size()>0){
				return (PersonalDocument)list.get(0);
			}
			return null;
		}
		return null;
	}
	public PersonalDocument findDocumentOnlyId(PersonalDocument document ,String type){
		if(document.getId().equals(null)||document.getId()==0)
			return null;
		if(type.equals(P_B_I_D)){

			return this.personalBirthInsuranceDocumentDAO.findById(document.getId());

		}
		else if(type.equals(P_I_I_D)){

			return this.personalInjuryInsuranceDocumentDAO.findById(document.getId());

		}
		else if(type.equals(P_M_I_D)){

			return this.personalMedicalInsuranceDocumentDAO.findById(document.getId());

		}
		else if(type.equals(P_P_I_D)){

			return this.personalPensionInsuranceDocumentDAO.findById(document.getId());

		}
		else if(type.equals(P_S_I_A_D)){

			return this.personalSocialInsuranceAuditDocumentDAO.findById(document.getId());

		}
		else if(type.equals(P_S_I_M_D)){

			return this.personalSocialInsuranceDocumentDAO.findById(document.getId());

		}
		else if(type.equals(P_S_I_C_D)){

			return this.personalSocialInsuranceCollectionDocumentDAO.findById(document.getId());

		}
		else if(type.equals(P_S_I_S_D)){

			return this.personalSocialInsuranceStatisticsDocumentDAO.findById(document.getId());

		}
		else if(type.equals(P_U_I_D)){

			return this.personalUnemployeeInsuranceDocumentDAO.findById(document.getId());
			}
		return null;

	}
	
	
	
	public void deletePersonalDocument(PersonalDocument document ,String type){
		
		document=this.findDocumentOnlyId(document, type);
		if(document==null){
			return ;
		}
		
		if(type.equals(P_B_I_D)){
			PersonalBirthInsuranceDocument s= (PersonalBirthInsuranceDocument)document;
			this.personalBirthInsuranceDocumentDAO.delete(s);
		}
		else if(type.equals(P_I_I_D)){
			PersonalInjuryInsuranceDocument adder =(PersonalInjuryInsuranceDocument)document;
			this.personalInjuryInsuranceDocumentDAO.delete(adder);
		}
		else if(type.equals(P_M_I_D)){
			PersonalMedicalInsuranceDocument adder=(PersonalMedicalInsuranceDocument)document;
			this.personalMedicalInsuranceDocumentDAO.delete(adder);
		}
		else if(type.equals(P_P_I_D)){
			PersonalPensionInsuranceDocument adder = (PersonalPensionInsuranceDocument)document;
			this.personalPensionInsuranceDocumentDAO.delete(adder);
		}
		else if(type.equals(P_S_I_A_D)){
			PersonalSocialInsuranceAuditDocument adder= (PersonalSocialInsuranceAuditDocument)document;
			this.personalSocialInsuranceAuditDocumentDAO.delete(adder);
		}
		else if(type.equals(P_S_I_C_D)){
			PersonalSocialInsuranceCollectionDocument adder=(PersonalSocialInsuranceCollectionDocument)document;
			this.personalSocialInsuranceCollectionDocumentDAO.delete(adder);
		}
		else if(type.equals(P_S_I_M_D)){
			PersonalSocialInsuranceDocument adder=(PersonalSocialInsuranceDocument)document;
			this.personalSocialInsuranceDocumentDAO.delete(adder);
		}
		else if(type.equals(P_S_I_S_D)){
			PersonalSocialInsuranceStatisticsDocument adder=(PersonalSocialInsuranceStatisticsDocument)document;
			this.personalSocialInsuranceStatisticsDocumentDAO.delete(adder);
		}
		else if(type.equals(P_U_I_D)){
			PersonalUnemployeeInsuranceDocument adder =(PersonalUnemployeeInsuranceDocument)document;
			this.personalUnemployeeInsuranceDocumentDAO.delete(adder);
		}
	}
	
	
}
