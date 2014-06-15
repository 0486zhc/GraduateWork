package dao;

import java.util.List;

import model.lhb.PatMasterIndex;

import org.hibernate.FlushMode;
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

public class PatMasterIndexDAO
{
   private HibernateTemplate template = null;

   Query                     query;

   public HibernateTemplate getTemplate()
   {
      return template;
   }

   public void setTemplate(HibernateTemplate hibernateTemplate)
   {
      this.template = hibernateTemplate;
   }

   @SuppressWarnings("unchecked")
   public PatMasterIndex find(String user_id, String pwd)
   {
      Session session = HibernateUtil.getSession();

      List<PatMasterIndex> pmi = null;

      String queryStr = "from PatMasterIndex where id_no = ? and password = ?";
      query = session.createQuery(queryStr);

      query.setString(0, user_id);
      query.setString(1, pwd);
      pmi = query.list();
      return pmi.get(0);
   }

   @SuppressWarnings("rawtypes")
   public void regist(PatMasterIndex pmi)
   {
//      Session session = HibernateUtil.getSession();
//      session.setFlushMode(FlushMode.AUTO);
//      Transaction ts = session.beginTransaction();
//      ts.begin();
//       String queryStr = "select max(patient_id) from pat_master_index";
//       query = session.createSQLQuery(queryStr);
//       List max = query.list();
//       Integer maxNum = Integer.valueOf(max.get(0).toString())+1;
//       pmi.setPatientId(maxNum.toString());
//      session.saveOrUpdate(pmi);
//      ts.commit();
//      session.flush();
//      session.close();
      
      Session session = HibernateUtil.getSession();
      Transaction ts = session.beginTransaction();
      //得到数据库中pat_id最大值
      String str = "insert into pat_master_index (patient_id,name,phone_number_business,id_no,password) values (?,?,?,?,?)";
      String pat_id = getMaxId(session);
      //插入数据
      query = session.createSQLQuery(str);
      query.setString(0, pat_id);
      query.setString(1, pmi.getName());
      query.setString(2, pmi.getPhoneNumberBusiness());
      query.setString(3, pmi.getIdNo());
      query.setString(4, pmi.getPassword());
      int i = query.executeUpdate();
      ts.commit();
      session.flush();
      session.close();
   }
   private String getMaxId(Session session)
   {
      String queryStr = "select max(patient_id) from pat_master_index";
      query = session.createSQLQuery(queryStr);
      List max = query.list();
      Integer maxNum = Integer.valueOf(max.get(0).toString())+1;
     
      return getLeft(maxNum);
   }
   
   private String getLeft(Integer i)
   {
      StringBuilder strb = new StringBuilder();
      int zeros = i.toString().length();
      for (int j = 0; j < (10-zeros); j++)
      {
         strb.append(0);
      }
      return strb.append(i.toString()).toString();
   }
}