package action;

import java.util.Map;

import model.lhb.PatMasterIndex;
import bo.LhbBo;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LhbAction extends ActionSupport
{
   private LhbBo lhbBo;
   private String pat_id;
   private String pwd;
   private Map<String,Object> request;
   private Map<String, Object> session;
   private Map<String, Object> application;
   
   @SuppressWarnings("unchecked")
   public LhbAction()
   {
      request = (Map<String, Object>) ActionContext.getContext().get("request");
      session = ActionContext.getContext().getSession();
      application = ActionContext.getContext().getApplication();
   }
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
      PatMasterIndex pmi = lhbBo.loginQuery(pat_id, pwd);
      session.put("user", pmi); 
      return "success";
   }


}
