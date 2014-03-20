package DAO;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bean.Archive;

/**
 * A data access object (DAO) providing persistence and search support for
 * Archive entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see bean.Archive
 * @author MyEclipse Persistence Tools
 */

public class ArchiveDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(ArchiveDAO.class);
	// property constants
	public static final String ARCHIVE_NUMBER = "archiveNumber";
	public static final String ARCHIVE_TITLE = "archiveTitle";

	protected void initDao() {
		// do nothing
	}

	public void save(Archive transientInstance) {
		log.debug("saving Archive instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Archive persistentInstance) {
		log.debug("deleting Archive instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
			getHibernateTemplate().flush();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Archive findById(java.lang.Integer id) {
		log.debug("getting Archive instance with id: " + id);
		try {
			Archive instance = (Archive) getHibernateTemplate().get(
					"bean.Archive", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Archive instance) {
		log.debug("finding Archive instance by example");
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
		log.debug("finding Archive instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Archive as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByArchiveNumber(Object archiveNumber) {
		return findByProperty(ARCHIVE_NUMBER, archiveNumber);
	}

	public List findByArchiveTitle(Object archiveTitle) {
		return findByProperty(ARCHIVE_TITLE, archiveTitle);
	}

	public List findAll() {
		log.debug("finding all Archive instances");
		try {
			String queryString = "from Archive";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Archive merge(Archive detachedInstance) {
		log.debug("merging Archive instance");
		try {
			Archive result = (Archive) getHibernateTemplate().merge(
					detachedInstance);
			getHibernateTemplate().flush();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Archive instance) {
		log.debug("attaching dirty Archive instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Archive instance) {
		log.debug("attaching clean Archive instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ArchiveDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ArchiveDAO) ctx.getBean("ArchiveDAO");
	}
}