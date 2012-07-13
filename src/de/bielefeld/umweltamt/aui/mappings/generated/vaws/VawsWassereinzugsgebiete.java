package de.bielefeld.umweltamt.aui.mappings.generated.vaws;
// Generated 13.07.2012 16:41:06 by Hibernate Tools 3.3.0.GA


import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

/**
 * Home object for domain model class VawsWassereinzugsgebiete.
 * @see de.bielefeld.umweltamt.aui.mappings.generated.vaws.VawsWassereinzugsgebiete
 * @author Hibernate Tools
 */
public class VawsWassereinzugsgebiete extends AbstractVawsWassereinzugsgebiete {

    private static final Log log = LogFactory.getLog(VawsWassereinzugsgebiete.class);

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
    
    public void persist(VawsWassereinzugsgebiete transientInstance) {
        log.debug("persisting VawsWassereinzugsgebiete instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(VawsWassereinzugsgebiete instance) {
        log.debug("attaching dirty VawsWassereinzugsgebiete instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(VawsWassereinzugsgebiete instance) {
        log.debug("attaching clean VawsWassereinzugsgebiete instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(VawsWassereinzugsgebiete persistentInstance) {
        log.debug("deleting VawsWassereinzugsgebiete instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public VawsWassereinzugsgebiete merge(VawsWassereinzugsgebiete detachedInstance) {
        log.debug("merging VawsWassereinzugsgebiete instance");
        try {
            VawsWassereinzugsgebiete result = (VawsWassereinzugsgebiete) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public VawsWassereinzugsgebiete findById( int id) {
        log.debug("getting VawsWassereinzugsgebiete instance with id: " + id);
        try {
            VawsWassereinzugsgebiete instance = (VawsWassereinzugsgebiete) sessionFactory.getCurrentSession()
                    .get("de.bielefeld.umweltamt.aui.mappings.generated.vaws.VawsWassereinzugsgebiete", id);
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
