package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import util.PageBean;
import DAO.ArchiveDAO;
import DAO.DocumentDAO;
import bean.Archive;
import bean.Document;

public class ArchiveManager {
	private ArchiveDAO archiveDAO;
	private DocumentDAO documentDAO;
	public ArchiveDAO getArchiveDAO() {
		return archiveDAO;
	}

	public void setArchiveDAO(ArchiveDAO archiveDAO) {
		this.archiveDAO = archiveDAO;
	}
	
	public Archive addArchive(Archive archive){
		return archiveDAO.merge(archive);
	}
	
	public Archive findArchiveByNumber(String number){
		List list = archiveDAO.findByArchiveNumber(number);
		if(list.size() > 0){
			return (Archive) list.get(0);
		}
		else
			return null;
	}
	
	public PageBean findArchiveWithPageBean(Archive archive,int pageSize,int page){
		//String baseSql = "select * from archive";
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Archive.class); 
		detachedCriteria.add(Restrictions.like("archiveNumber", "%" + archive.getArchiveNumber() + "%"));
		//String hql = "select count(*) from archive as model";
			
		//int totalRow = ((Number)archiveDAO.getHibernateTemplate().iterate(hql).next()).intValue();
		//int totalRow = archiveDAO.getHibernateTemplate().findByCriteria(detachedCriteria).size();
		int totalRow=((Integer) archiveDAO.getHibernateTemplate().findByCriteria(detachedCriteria.setProjection(Projections.rowCount())).get(0)).intValue(); 
		int totalPage = PageBean.countTotalPage(pageSize, totalRow);
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize; 
		final int currentPage = PageBean.countCurrentPage(page);  
		
		DetachedCriteria detachedCriteria1 = DetachedCriteria.forClass(Archive.class); 
		detachedCriteria1.add(Restrictions.like("archiveNumber", "%" + archive.getArchiveNumber() + "%"));
		
		List list = archiveDAO.getHibernateTemplate().findByCriteria(detachedCriteria1,offset,length);

		
        PageBean pageBean = new PageBean();  
        pageBean.setPageSize(pageSize);  
        pageBean.setCurrentPage(currentPage);  
        pageBean.setAllRow(totalRow);  
        pageBean.setTotalPage(totalPage);  
        pageBean.setList(list);  
        pageBean.init();  
        return pageBean; 
	}
	
	public List<Document> findAllDocumentByArchive(Archive archive){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Document.class).createAlias("archive", "ar");
		detachedCriteria.add(Restrictions.eq("ar.archiveNumber",archive.getArchiveNumber()));
		detachedCriteria.addOrder(Order.asc("sequenceNumber"));
		
		return (List<Document>)documentDAO.getHibernateTemplate().findByCriteria(detachedCriteria);
		
		
	}

	public DocumentDAO getDocumentDAO() {
		return documentDAO;
	}

	public void setDocumentDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}
}
