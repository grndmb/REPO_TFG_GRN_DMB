package persistencia;
// Generated 2 jun. 2022 16:39:39 by Hibernate Tools 5.4.32.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class DatosEfa.
 * @see persistencia.DatosEfa
 * @author Hibernate Tools
 */
public class DatosEfaHome {

	private static final Logger logger = Logger.getLogger(DatosEfaHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DatosEfa transientInstance) {
		logger.log(Level.INFO, "persisting DatosEfa instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DatosEfa instance) {
		logger.log(Level.INFO, "attaching dirty DatosEfa instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(DatosEfa instance) {
		logger.log(Level.INFO, "attaching clean DatosEfa instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(DatosEfa persistentInstance) {
		logger.log(Level.INFO, "deleting DatosEfa instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public DatosEfa merge(DatosEfa detachedInstance) {
		logger.log(Level.INFO, "merging DatosEfa instance");
		try {
			DatosEfa result = (DatosEfa) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public DatosEfa findById(java.lang.String id) {
		logger.log(Level.INFO, "getting DatosEfa instance with id: " + id);
		try {
			DatosEfa instance = (DatosEfa) sessionFactory.getCurrentSession().get("persistencia.DatosEfa", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(DatosEfa instance) {
		logger.log(Level.INFO, "finding DatosEfa instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("persistencia.DatosEfa")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
