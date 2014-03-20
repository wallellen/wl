package service;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import util.PageBean;
import DAO.DocumentDAO;
import bean.Document;
import bean.PersonalDocument;
import bean.UnitDocument;


public class DocumentManager {
	private PersonalDocumentManager personalDocumentManager;
	private UnitDocumentManager unitDocumentManager;
	private DocumentDAO documentDAO;
	public static final String P_B_I_D="生育保险待遇类";
	public static final String P_I_I_D="工伤保险待遇类";
	public static final String P_M_I_D="医疗保险待遇类";
	public static final String P_P_I_D="养老保险待遇类";
	public static final String P_S_I_A_D="社会保险稽核类";
	public static final String P_S_I_M_D="社会保险管理类";
	public static final String P_S_I_S_D="社会保险业务统计报表类";
	public static final String P_U_I_D="失业保险待遇类";
	public static final String P_S_I_C_D="社会保险征缴类";
	
	public PersonalDocumentManager getPersonalDocumentManager() {
		return personalDocumentManager;
	}
	public void setPersonalDocumentManager(
			PersonalDocumentManager personalDocumentManager) {
		this.personalDocumentManager = personalDocumentManager;
	}
	public UnitDocumentManager getUnitDocumentManager() {
		return unitDocumentManager;
	}
	public void setUnitDocumentManager(UnitDocumentManager unitDocumentManager) {
		this.unitDocumentManager = unitDocumentManager;
	}
	
	public PersonalDocument addPersonalDocument(PersonalDocument document ,String type){
		return personalDocumentManager.addPersonalDocument(document, type);
	}
	
	public UnitDocument addUnitDocument(UnitDocument document ,String type){
		return unitDocumentManager.addUnitDocument(document, type);
	}
	
	public DocumentDAO getDocumentDAO() {
		return documentDAO;
	}
	public void setDocumentDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}
	
	public Document addDocument(Document document){
		
		return documentDAO.merge(document);
	}
	
	public PageBean searchAllDocumentWithPageBean(List<String> acessesList,int pageSize,int page,String archiveNumber,int sequenceNumber,String author,String title){
	/*	int totalRow = 0;
		List list = new ArrayList();
		for(String type : acessesList){
			Class clazz = getPersonalDocumentManager().changeToSpecialClass(type);
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(clazz).createAlias("archive", "ar");
			detachedCriteria.add(Restrictions.like("ar.archiveNumber", "%" + archiveNumber + "%")).add(Restrictions.like("sequenceNumber", "%" + sequenceNumber + "%"))
			.add(Restrictions.like("author", "%" + author + "%")).add(Restrictions.like("title", "%" + title + "%"));
			totalRow += personalDocumentManager.TotalRow(detachedCriteria, type);
		}
		for(String type :acessesList){
			
			
			Class clazz1 = getUnitDocumentManager().changeToSpecialClass(type);
			DetachedCriteria detachedCriteria1 = DetachedCriteria.forClass(clazz1).createAlias("archive", "ar");
			detachedCriteria1.add(Restrictions.like("ar.archiveNumber", "%" + archiveNumber + "%")).add(Restrictions.like("sequenceNumber", "%" + sequenceNumber + "%"))
			.add(Restrictions.like("author", "%" + author + "%")).add(Restrictions.like("title", "%" + title + "%"));
			totalRow += unitDocumentManager.TotalRow(detachedCriteria1, type);
		}
		
		
		
		for(String type : acessesList){
			Class clazz = getPersonalDocumentManager().changeToSpecialClass(type);
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(clazz).createAlias("archive", "ar");
			detachedCriteria.add(Restrictions.like("ar.archiveNumber", "%" + archiveNumber + "%")).add(Restrictions.like("sequenceNumber", "%" + sequenceNumber + "%"))
			.add(Restrictions.like("author", "%" + author + "%")).add(Restrictions.like("title", "%" + title + "%"));
			list.addAll(findAllPeraonalDocuments(detachedCriteria, type));
		}
		
		for(String type :acessesList){
			Class clazz1 = getUnitDocumentManager().changeToSpecialClass(type);
			DetachedCriteria detachedCriteria1 = DetachedCriteria.forClass(clazz1).createAlias("archive", "ar");
			detachedCriteria1.add(Restrictions.like("ar.archiveNumber", "%" + archiveNumber + "%")).add(Restrictions.like("sequenceNumber", "%" + sequenceNumber + "%"))
			.add(Restrictions.like("author", "%" + author + "%")).add(Restrictions.like("title", "%" + title + "%"));
			list.addAll(findAllPeraonalDocuments(detachedCriteria1, type));
		}
		*/
		//String hql = "select count(*) from archive as model";
		//int totalRow = ((Number)documentDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Document.class).createAlias("archive", "ar");
		detachedCriteria.add(Restrictions.like("ar.archiveNumber", "%" + archiveNumber + "%"))
		.add(Restrictions.like("author", "%" + author + "%")).add(Restrictions.like("title", "%" + title + "%"));
		
		
		if(sequenceNumber != 0){
			detachedCriteria.add(Restrictions.eq("sequenceNumber", sequenceNumber));
		}
		Disjunction disjuction = Restrictions.disjunction();
		for(String type :acessesList){
			disjuction.add(Restrictions.eq("type", type));
		}
		
		detachedCriteria.add(disjuction);
		
		
		
		int totalRow=((Integer) documentDAO.getHibernateTemplate().findByCriteria(detachedCriteria.setProjection(Projections.rowCount())).get(0)).intValue(); 
		int totalPage = PageBean.countTotalPage(pageSize, totalRow);
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize; 
		final int currentPage = PageBean.countCurrentPage(page);  
		
		
		DetachedCriteria detachedCriteria1 = DetachedCriteria.forClass(Document.class).createAlias("archive", "ar");
		detachedCriteria1.add(Restrictions.like("ar.archiveNumber", "%" + archiveNumber + "%"))
		.add(Restrictions.like("author", "%" + author + "%")).add(Restrictions.like("title", "%" + title + "%"));
		

		if(sequenceNumber != 0){
			detachedCriteria1.add(Restrictions.eq("sequenceNumber", sequenceNumber));
		}
		Disjunction disjuction1 = Restrictions.disjunction();
		for(String type :acessesList){
			disjuction1.add(Restrictions.eq("type", type));
		}
		
		detachedCriteria1.add(disjuction1);
		detachedCriteria1.addOrder(Order.asc("ar.archiveNumber"));
		detachedCriteria1.addOrder(Order.asc("sequenceNumber"));
		List list = documentDAO.getHibernateTemplate().findByCriteria(detachedCriteria1,offset,length);
        PageBean pageBean = new PageBean();  
        pageBean.setPageSize(pageSize);  
        pageBean.setCurrentPage(currentPage);  
        pageBean.setAllRow(totalRow);  
        pageBean.setTotalPage(totalPage);  
        pageBean.setList(list);  
        pageBean.init();  
        
        return pageBean;
	}
	
	public Document modifyDocument(Document document){
		return documentDAO.merge(document);
	}
	
	
	public void deleteDocument(Document document){
		 documentDAO.delete(document);
	}
	public Document findDocumentById(int id){
		return documentDAO.findById(id);
	}
	public PersonalDocument findPersonalDocumentById(int id,String type){
		return personalDocumentManager.findById(id, type);
	}
	
	public UnitDocument findUnitDocumnetById(int id,String type){
		return unitDocumentManager.findById(id, type);
	}
	public List findAllPeraonalDocuments(DetachedCriteria detachedCriteria,String type){
		List list = personalDocumentManager.findDocumentByCirteria(detachedCriteria, type);
		return list;
	}
	public List findAllUnitDocuments(DetachedCriteria detachedCriteria,String type){
		List list = unitDocumentManager.findDocumentByCirteria(detachedCriteria, type);
		return list;
	}
	
	public List findDocumentByExample(Document document){
		return documentDAO.findByExample(document);
	}
	
}
