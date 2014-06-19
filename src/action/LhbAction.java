package action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import util.MD5;
import model.Ozq.ClinicAppoints;
import model.lhb.PatMasterIndex;
import bo.LhbBo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LhbAction extends ActionSupport
{
   private LhbBo               lhbBo;
   private String              pwd;
   private String              phoneNum;
   private String              user_id;
   private String              user_name;
   private Map<String, Object> request;
   private Map<String, Object> session;
   private Map<String, Object> application;
   private PatMasterIndex      pmi;
   private ClinicAppoints      appoints;
   private String              rand;               // 表单中的rand
   private HttpServletResponse response;
   private HttpServletRequest  requestForAjax;
   private static final String SUCCESS = "success";
   private static final String ERROR   = "error";

   public String getRand()
   {
      return rand;
   }

   public void setRand(String rand)
   {
      this.rand = rand;
   }

   public String getPhoneNum()
   {
      return phoneNum;
   }

   public void setPhoneNum(String phoneNum)
   {
      this.phoneNum = phoneNum;
   }

   public String getUser_id()
   {
      return user_id;
   }

   public void setUser_id(String user_id)
   {
      this.user_id = user_id;
   }

   public String getUser_name()
   {
      return user_name;
   }

   public void setUser_name(String user_name)
   {
      this.user_name = user_name;
   }

   public LhbBo getLhbBo()
   {
      return lhbBo;
   }

   public void setLhbBo(LhbBo lhbBo)
   {
      this.lhbBo = lhbBo;
   }

   public String getPwd()
   {
      return pwd;
   }

   public void setPwd(String pwd)
   {
      this.pwd = pwd;
   }

   @SuppressWarnings("unchecked")
   public LhbAction()
   {
      request = (Map<String, Object>) ActionContext.getContext().get("request");
      requestForAjax = ServletActionContext.getRequest();
      session = ActionContext.getContext().getSession();
      application = ActionContext.getContext().getApplication();
      response = ServletActionContext.getResponse();
   }

   public String loginQuery()
   {
      pwd = MD5.afterMd5(pwd);
      String arandom = (String) session.get("random");
      try
      {
         pmi = lhbBo.loginQuery(user_id, pwd);
         if(arandom.equals(this.getRand()))
         {
            session.put("user", pmi);
         }
         else
         {
            throw new Exception();
         }
      } catch (Exception ex)
      {
         ex.printStackTrace();
         return ERROR;
      }
      return SUCCESS;
   }

   public String regist() throws IOException
   {
      try
      {
         pmi = new PatMasterIndex();
         pmi.setPassword(MD5.afterMd5(pwd));
         pmi.setIdNo(user_id);
         pmi.setName(user_name);
         pmi.setPhoneNumberBusiness(phoneNum);
         String state = lhbBo.regist(pmi);
         if(SUCCESS.equals(state))
         {
            session.put("user", pmi);
         }
         return state;
      } catch (Exception ex)
      {
         ex.printStackTrace();
         return ERROR;
      }

   }

   public void checkUserId() throws IOException
   {
      user_id = requestForAjax.getParameter("user_id");
      String state = lhbBo.checkForUserId(user_id);
      response.getWriter().write(state);

   }

   public String makeAppoints()
   {
      // appoints
      String state = lhbBo.makeAppoints(appoints);
      return state;

   }
}
