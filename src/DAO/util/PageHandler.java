package DAO.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.support.DaoSupport;

import DAO.ElectrictDocumentAdressDAO;
import DAO.PersonalBirthInsuranceDocumentDAO;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bean.UnitDocument;

import util.PageBean;
public class PageHandler {
	
	public PageBean queryForPage( HibernateDaoSupport dao,final String hql,final int allRow,final int pageSize,final int page) {
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize; 
		final int currentPage = PageBean.countCurrentPage(page);  
		List list =  dao.getHibernateTemplate().executeFind(
				new HibernateCallback()
				{

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
				     	Query query = session.createQuery(hql);
		            	query.setFirstResult(offset);   
		            	query.setMaxResults(length);   
		            	List list = query.list();   
		            	
		            	return list;
					}
					}
				);
        PageBean pageBean = new PageBean();  
        pageBean.setPageSize(pageSize);  
        pageBean.setCurrentPage(currentPage);  
        pageBean.setAllRow(allRow);  
        pageBean.setTotalPage(totalPage);  
        pageBean.setList(list);  
        pageBean.init();  
        return pageBean; 
	}
}
