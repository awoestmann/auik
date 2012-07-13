package de.bielefeld.umweltamt.aui.mappings.generated.vaws;
// Generated 13.07.2012 16:41:06 by Hibernate Tools 3.3.0.GA


import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

/**
 * Home object for domain model class VawsPruefergebnisse.
 * @see de.bielefeld.umweltamt.aui.mappings.generated.vaws.VawsPruefergebnisse
 * @author Hibernate Tools
 */
public class VawsPruefergebnisse extends AbstractVawsPruefergebnisse {

    private static final Log log = LogFactory.getLog(VawsPruefergebnisse.class);

    private final SessionFactory sessionFactory = getSessionFactory();
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(VawsPruefergebnisse transientInstance) {
        log.debug("persisting VawsPruefergebnisse instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(VawsPruefergebnisse instance) {
        log.debug("attaching dirty VawsPruefergebnisse instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(VawsPruefergebnisse instance) {
        log.debug("attaching clean VawsPruefergebnisse instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(VawsPruefergebnisse persistentInstance) {
        log.debug("deleting VawsPruefergebnisse instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public VawsPruefergebnisse merge(VawsPruefergebnisse detachedInstance) {
        log.debug("merging VawsPruefergebnisse instance");
        try {
            VawsPruefergebnisse result = (VawsPruefergebnisse) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public VawsPruefergebnisse findById( int id) {
        log.debug("getting VawsPruefergebnisse instance with id: " + id);
        try {
            VawsPruefergebnisse instance = (VawsPruefergebnisse) sessionFactory.getCurrentSession()
                    .get("de.bielefeld.umweltamt.aui.mappings.generated.vaws.VawsPruefergebnisse", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
}
