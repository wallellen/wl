package DAO;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bean.UnitSocialInsuranceCollectionDocument;

/**
 * A data access object (DAO) providing persistence and search support for
 * UnitSocialInsuranceCollectionDocument entities. Transaction control of the
 * save(), update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see bean.UnitSocialInsuranceCollectionDocument
 * @author MyEclipse Persistence Tools
 */

public class UnitSocialInsuranceCollectionDocumentDAO extends
		HibernateDaoSupport {
	private static final Log log = LogFactory
			.getLog(UnitSocialInsuranceCollectionDocumentDAO.class);
	// property constants
	public static final String UNIT_IDENTIFY_ID = "unitIdentifyId";
	public static final String UNIT_NAME = "unitName";
	public static final String DOCUMENT_NAME = "documentName";
	public static final String PHYSICS_ADRESS = "physicsAdress";
	public static final String RETENTION_PERIOD = "retentionPeriod";
	public static final String TIME = "time";
	public static final String ZONE = "zone";
	public static final String SEQUENCE_NUMBER = "sequenceNumber";
	public static final String FILE_NUMBER = "fileNumber";
	public static final String AUTHOR = "author";
	public static final String TITLE = "title";
	public static final String PAGE_NUMBER = "pageNumber";
	public static final String COMMENTS = "comments";

	protected void initDao() {
		// do nothing
	}

	public void save(UnitSocialInsuranceCollectionDocument transientInstance) {
		log.debug("saving UnitSocialInsuranceCollectionDocument instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UnitSocialInsuranceCollectionDocument persistentInstance) {
		log.debug("deleting UnitSocialInsuranceCollectionDocument instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UnitSocialInsuranceCollectionDocument findById(java.lang.Integer id) {
		log.debug("getting UnitSocialInsuranceCollectionDocument instance with id: "
				+ id);
		try {
			UnitSocialInsuranceCollectionDocument instance = (UnitSocialInsuranceCollectionDocument) getHibernateTemplate()
					.get("bean.UnitSocialInsuranceCollectionDocument", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UnitSocialInsuranceCollectionDocument instance) {
		log.debug("finding UnitSocialInsuranceCollectionDocument instance by example");
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
		log.debug("finding UnitSocialInsuranceCollectionDocument instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UnitSocialInsuranceCollectionDocument as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUnitIdentifyId(Object unitIdentifyId) {
		return findByProperty(UNIT_IDENTIFY_ID, unitIdentifyId);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByDocumentName(Object documentName) {
		return findByProperty(DOCUMENT_NAME, documentName);
	}

	public List findByPhysicsAdress(Object physicsAdress) {
		return findByProperty(PHYSICS_ADRESS, physicsAdress);
	}

	public List findByRetentionPeriod(Object retentionPeriod) {
		return findByProperty(RETENTION_PERIOD, retentionPeriod);
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findByZone(Object zone) {
		return findByProperty(ZONE, zone);
	}

	public List findBySequenceNumber(Object sequenceNumber) {
		return findByProperty(SEQUENCE_NUMBER, sequenceNumber);
	}

	public List findByFileNumber(Object fileNumber) {
		return findByProperty(FILE_NUMBER, fileNumber);
	}

	public List findByAuthor(Object author) {
		return findByProperty(AUTHOR, author);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByPageNumber(Object pageNumber) {
		return findByProperty(PAGE_NUMBER, pageNumber);
	}

	public List findByComments(Object comments) {
		return findByProperty(COMMENTS, comments);
	}

	public List findAll() {
		log.debug("finding all UnitSocialInsuranceCollectionDocument instances");
		try {
			String queryString = "from UnitSocialInsuranceCollectionDocument";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UnitSocialInsuranceCollectionDocument merge(
			UnitSocialInsuranceCollectionDocument detachedInstance) {
		log.debug("merging UnitSocialInsuranceCollectionDocument instance");
		try {
			UnitSocialInsuranceCollectionDocument result = (UnitSocialInsuranceCollectionDocument) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UnitSocialInsuranceCollectionDocument instance) {
		log.debug("attaching dirty UnitSocialInsuranceCollectionDocument instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UnitSocialInsuranceCollectionDocument instance) {
		log.debug("attaching clean UnitSocialInsuranceCollectionDocument instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UnitSocialInsuranceCollectionDocumentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UnitSocialInsuranceCollectionDocumentDAO) ctx
				.getBean("UnitSocialInsuranceCollectionDocumentDAO");
	}
}