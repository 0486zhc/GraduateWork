package dao;

import java.util.List;

import model.Ozq.ClinicAppoints;
import model.lhb.PatMasterIndex;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
@SuppressWarnings("unchecked")
public class PatMasterIndexDAO
{
   private HibernateTemplate   template     = null;
   private Query               query;
   private Session             session;
   private static final String strForLogin  = "from PatMasterIndex where id_no = ? and password = ?";
   private static final String strForRegist = "insert into pat_master_index (patient_id,name,phone_number_business,id_no,password) values (?,?,?,?,?)";
   private static final String strForMaxId  = "select max(patient_id) from pat_master_index";
   private static final String strByUserId  = "from PatMasterIndex where id_no = ?";

   public HibernateTemplate getTemplate()
   {
      return template;
   }

   public void setTemplate(HibernateTemplate hibernateTemplate)
   {
      this.template = hibernateTemplate;
   }

   public PatMasterIndex find(String user_id, String pwd)
   {
      session = HibernateUtil.getSession();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
      List<PatMasterIndex> pmi = null;
      query = session.createQuery(strForLogin);
      query.setString(0, user_id);
      query.setString(1, pwd);
      pmi = query.list();
      return pmi.get(0);
   }

   public void regist(PatMasterIndex pmi)
   {
      // Session session = HibernateUtil.getSession();
      // session.setFlushMode(FlushMode.AUTO);
      // Transaction ts = session.beginTransaction();
      // ts.begin();
      // String queryStr = "select max(patient_id) from pat_master_index";
      // query = session.createSQLQuery(queryStr);
      // List max = query.list();
      // Integer maxNum = Integer.valueOf(max.get(0).toString())+1;
      // pmi.setPatientId(maxNum.toString());
      // session.saveOrUpdate(pmi);
      // ts.commit();
      // session.flush();
      // session.close();
      // =============================================================================================
      session = HibernateUtil.getSession();
      Transaction ts = session.beginTransaction();
      // 得到表中patient_id最大值
      String pat_id = getMaxId(session);
      query = session.createSQLQuery(strForRegist);
      query.setString(0, pat_id);
      query.setString(1, pmi.getName());
      query.setString(2, pmi.getPhoneNumberBusiness());
      query.setString(3, pmi.getIdNo());
      query.setString(4, pmi.getPassword());
      query.executeUpdate();
      ts.commit();
      session.flush();
      session.close();
   }

   @SuppressWarnings("rawtypes")
   private String getMaxId(Session session)
   {
      query = session.createSQLQuery(strForMaxId);
      List max = query.list();
      Integer maxNum = Integer.valueOf(max.get(0).toString()) + 1;
      return getLeft(maxNum);
   }

   private String getLeft(Integer i)
   {
      StringBuilder strb = new StringBuilder();
      int zeros = i.toString().length();
      for (int j = 0; j < (10 - zeros); j++)
      {
         strb.append(0);
      }
      return strb.append(i.toString()).toString();
   }

   public PatMasterIndex checkForUserId(String user)
   {
      session = HibernateUtil.getSession();
      List<PatMasterIndex> pmi = null;
      query = session.createQuery(strByUserId);
      query.setString(0, user);
      pmi = query.list();
      if(pmi.isEmpty())
      {
         return null;
      }
      return pmi.get(0);
   }

   public void makeAppoints(ClinicAppoints appoints,String user_id)
   {
      Session session = HibernateUtil.getSession();
      Transaction ts = session.beginTransaction();
      ts.begin();
      session.saveOrUpdate(appoints);
      addOne(user_id);
      ts.commit();
      session.flush();
      session.close();
   }

   public void addOne(String user_id)
   {
      session = HibernateUtil.getSession();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
      PatMasterIndex pmi = null;
      query = session.createQuery(strByUserId);
      query.setString(0, user_id);
      pmi = (PatMasterIndex) query.list().get(0);
      pmi.setFlag(pmi.getFlag()+1);
      
       Transaction ta = session.beginTransaction();
       session.update(pmi); 
       ta.commit();
       session.close();
   }
  
   public PatMasterIndex checkForFlag(String user_id)
   {
      session = HibernateUtil.getSession();
      List<PatMasterIndex> pmi = null;
      query = session.createQuery(strByUserId);
      query.setString(0, user_id);
      pmi = query.list();
      return pmi.get(0);  
    }
}