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


   public String loginQuery(String user, String pwd)
   {
      PatMasterIndex pat = pmiDao.find(user, pwd);
      if(pat == null)
      {
         return "fail";
      }
      return "success";
   }

}
