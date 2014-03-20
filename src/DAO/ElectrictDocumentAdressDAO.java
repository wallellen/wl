package DAO;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bean.ElectrictDocumentAdress;

/**
 * A data access object (DAO) providing persistence and search support for
 * ElectrictDocumentAdress entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see bean.ElectrictDocumentAdress
 * @author MyEclipse Persistence Tools
 */

public class ElectrictDocumentAdressDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(ElectrictDocumentAdressDAO.class);
	// property constants
	public static final String ADDRESS_URL = "addressUrl";
	public static final String DOCUMENT_TYPE = "documentType";
	public static final String DOCUMENT_ID = "documentId";
	public static final String TIME = "time";
	public static final String ELECTRIC_DOCUMENT_NAME = "electricDocumentName";

	protected void initDao() {
		// do nothing
	}

	public void save(ElectrictDocumentAdress transientInstance) {
		log.debug("saving ElectrictDocumentAdress instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ElectrictDocumentAdress persistentInstance) {
		log.debug("deleting ElectrictDocumentAdress instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ElectrictDocumentAdress findById(java.lang.Integer id) {
		log.debug("getting ElectrictDocumentAdress instance with id: " + id);
		try {
			ElectrictDocumentAdress instance = (ElectrictDocumentAdress) getHibernateTemplate()
					.get("bean.ElectrictDocumentAdress", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ElectrictDocumentAdress instance) {
		log.debug("finding ElectrictDocumentAdress instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ElectrictDocumentAdress instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ElectrictDocumentAdress as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAddressUrl(Object addressUrl) {
		return findByProperty(ADDRESS_URL, addressUrl);
	}

	public List findByDocumentType(Object documentType) {
		return findByProperty(DOCUMENT_TYPE, documentType);
	}

	public List findByDocumentId(Object documentId) {
		return findByProperty(DOCUMENT_ID, documentId);
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findByElectricDocumentName(Object electricDocumentName) {
		return findByProperty(ELECTRIC_DOCUMENT_NAME, electricDocumentName);
	}

	public List findAll() {
		log.debug("finding all ElectrictDocumentAdress instances");
		try {
			String queryString = "from ElectrictDocumentAdress";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ElectrictDocumentAdress merge(
			ElectrictDocumentAdress detachedInstance) {
		log.debug("merging ElectrictDocumentAdress instance");
		try {
			ElectrictDocumentAdress result = (ElectrictDocumentAdress) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ElectrictDocumentAdress instance) {
		log.debug("attaching dirty ElectrictDocumentAdress instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ElectrictDocumentAdress instance) {
		log.debug("attaching clean ElectrictDocumentAdress instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ElectrictDocumentAdressDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ElectrictDocumentAdressDAO) ctx
				.getBean("ElectrictDocumentAdressDAO");
	}
}