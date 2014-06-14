package dao;

import java.util.List;

import model.lhb.PatMasterIndex;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import util.HibernateUtil;

/**
 * A data access object (DAO) providing persistence and search support for
 * PatMasterIndex entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see model.lhb.PatMasterIndex
 * @author MyEclipse Persistence Tools
 */

public class PatMasterIndexDAO
{
    private static final Logger log = LoggerFactory
    .getLogger(PatMasterIndexDAO.class);
   

   private HibernateTemplate template = null;

   public HibernateTemplate getTemplate()
   {
      return template;
   }

   public void setTemplate(HibernateTemplate hibernateTemplate)
   {
      this.template = hibernateTemplate;
   }

   public void save(PatMasterIndex transientInstance)
   {
      log.debug("saving PatMasterIndex instance");
      try
      {
         getTemplate().save(transientInstance);
         log.debug("save successful");
      } catch (RuntimeException re)
      {
         log.error("save failed", re);
         throw re;
      }
   }

   public PatMasterIndex findById(java.lang.String id)
   {
      log.debug("getting PatMasterIndex instance with id: " + id);
      try
      {
         PatMasterIndex instance = (PatMasterIndex) getTemplate().find(id);
         
         return instance;
      } catch (RuntimeException re)
      {
         log.error("get failed", re);
         throw re;
      }
   }

   @SuppressWarnings("unchecked")
   public List<PatMasterIndex> findByExample(PatMasterIndex instance)
   {
      log.debug("finding PatMasterIndex instance by example");
      try
      {
         List<PatMasterIndex> results = getTemplate().findByExample(instance);
         log.debug("find by example successful, result size: " + results.size());
         return results;
      } catch (RuntimeException re)
      {
         log.error("find by example failed", re);
         throw re;
      }
   }

   

   @SuppressWarnings("unchecked")
   public List<PatMasterIndex> findAll()
   {
      log.debug("finding all PatMasterIndex instances");
      try
      {
         String queryString = "from PatMasterIndex";
         return getTemplate().find(queryString);
      } catch (RuntimeException re)
      {
         log.error("find all failed", re);
         throw re;
      }
   }

   public PatMasterIndex merge(PatMasterIndex detachedInstance)
   {
      log.debug("merging PatMasterIndex instance");
      try
      {
         PatMasterIndex result = (PatMasterIndex) getTemplate().merge(
               detachedInstance);
         log.debug("merge successful");
         return result;
      } catch (RuntimeException re)
      {
         log.error("merge failed", re);
         throw re;
      }
   }

   public void attachDirty(PatMasterIndex instance)
   {
      log.debug("attaching dirty PatMasterIndex instance");
      try
      {
         getTemplate().saveOrUpdate(instance);
         log.debug("attach successful");
      } catch (RuntimeException re)
      {
         log.error("attach failed", re);
         throw re;
      }
   }

   public void attachClean(PatMasterIndex instance)
   {
      log.debug("attaching clean PatMasterIndex instance");
      try
      {
         getTemplate().lock(instance, LockMode.NONE);
         log.debug("attach successful");
      } catch (RuntimeException re)
      {
         log.error("attach failed", re);
         throw re;
      }
   }

   public static PatMasterIndexDAO getFromApplicationContext(
         ApplicationContext ctx)
   {
      return (PatMasterIndexDAO) ctx.getBean("PatMasterIndexDAO");
 
   }
   
   @SuppressWarnings("unchecked")
   public PatMasterIndex find(String pat_id,String pwd)
   {
      Session session = HibernateUtil.getSession();
      
      List<PatMasterIndex> pmi = null;
      
      String queryStr = "from PatMasterIndex where patient_id = ? and password = ?";
      Query query = session.createQuery(queryStr);
      
      query.setString(0, pat_id);
      query.setString(1, pwd);
      pmi = query.list();
      return pmi.get(0);
   }
}