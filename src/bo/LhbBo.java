package bo;

import java.sql.Date;

import model.Ozq.ClinicAppoints;
import model.lhb.PatMasterIndex;
import dao.PatMasterIndexDAO;

public class LhbBo
{
   private PatMasterIndexDAO   pmiDao;
   private static final String SUCCESS = "success";
   private static final String ERROR   = "error";

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

   public String regist(PatMasterIndex pmi,String date)
   {
      pmiDao.regist(pmi,date);
      return SUCCESS;
   }

   public String checkForUserId(String user)
   {
      PatMasterIndex pat = pmiDao.checkForUserId(user);
      if(pat == null)
      {
         return SUCCESS;
      }
      return ERROR;
   }

   public String makeAppoints(ClinicAppoints appoints,String user_id)
   {
      pmiDao.makeAppoints(appoints,user_id);
      return SUCCESS;
   }

   public String checkForFlag(String user_id)
   {
      PatMasterIndex pat = pmiDao.checkForFlag(user_id);
      Integer i = pat.getFlag();
      if(i <= 3 || i == null)
      {
         return SUCCESS;
      }
      return ERROR;
   }
}
