package bo;

import dao.LhbDao;

public class LhbBo
{
   private LhbDao lhbDao;

   public LhbDao getLhbDao()
   {
      return lhbDao;
   }

   public void setLhbDao(LhbDao lhbDao)
   {
      this.lhbDao = lhbDao;
   }

   public String loginQuery(String user, String pwd)
   {
      return lhbDao.loginQuery(user, pwd);
   }
   
   public void helo()
   {
      System.out.println("hello");
   }
}
