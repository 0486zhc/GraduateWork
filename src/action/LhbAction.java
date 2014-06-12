package action;

import model.lhb.PatMasterIndex;
import bo.LhbBo;

import com.opensymphony.xwork2.ActionSupport;

public class LhbAction extends ActionSupport
{
   private LhbBo lhbBo;
   private String pat_id;
   private String pwd;
   
   // private PatMasterIndex user;

   public LhbBo getLhbBo()
   {
      return lhbBo;
   }

   public void setLhbBo(LhbBo lhbBo)
   {
      this.lhbBo = lhbBo;
   }

   public String getPat_id()
   {
      return pat_id;
   }
   
   public void setPat_id(String pat_id)
   {
      this.pat_id = pat_id;
   }
   
   public String getPwd()
   {
      return pwd;
   }
   
   public void setPwd(String pwd)
   {
      this.pwd = pwd;
   }
   public String loginQuery()
   {
      lhbBo.loginQuery(pat_id, pwd);
      return "success";
   }


}
