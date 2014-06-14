package bo;

import model.lhb.PatMasterIndex;
import dao.PatMasterIndexDAO;

public class LhbBo
{
   private PatMasterIndexDAO pmiDao;

   public PatMasterIndexDAO getPmiDao()
   {
      return pmiDao;
   }

   public void setPmiDao(PatMasterIndexDAO pmiDao)
   {
      this.pmiDao = pmiDao;
   }


   public PatMasterIndex loginQuery(String user, String pwd)
   {
      PatMasterIndex pat = pmiDao.find(user, pwd);
     
      return pat;
   }
   
   public String regist(PatMasterIndex pmi)
   {
      String state;
      
      try
      {
         pmiDao.regist(pmi);
         state = "success";
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
         state = "error";
      }
      
      return state;
   }

}
