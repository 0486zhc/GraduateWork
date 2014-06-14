package dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class LhbDao
{

   private HibernateTemplate template = null;

   public HibernateTemplate getTemplate() {
       return template;
   }

   public void setTemplate(HibernateTemplate hibernateTemplate) {
       this.template = hibernateTemplate;
   }
   
   public String loginQuery(String user,String pwd)
   {
      System.out.println(user + pwd);
      return "success";
   }
}
