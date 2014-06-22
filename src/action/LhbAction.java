package action;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ozq.ClinicAppoints;
import model.lhb.PatMasterIndex;

import org.apache.struts2.ServletActionContext;

import util.MD5;
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
   private String year;
   private String month;
   private String day;
   private String sex;
   
   public String getYear()
   {
      return year;
   }

   public void setYear(String year)
   {
      this.year = year;
   }

   public String getMonth()
   {
      return month;
   }

   public void setMonth(String month)
   {
      this.month = month;
   }

   public String getDay()
   {
      return day;
   }

   public void setDay(String day)
   {
      this.day = day;
   }

   public String getSex()
   {
      return sex;
   }

   public void setSex(String sex)
   {
      this.sex = sex;
   }

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
         pmi.setSex(sex);
         String state = lhbBo.regist(pmi,(year+"-"+month+"-"+day));
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

   public void makeAppoints()
   {
      // appoints
      appoints = new ClinicAppoints();
      appoints.setName("刘浩斌");
      Date date = Date.valueOf("2014-10-10");
      appoints.setVisitDateAppted(date);
      appoints.setClinicLabel("内科副主任号");
      appoints.setVisitTimeAppted("15:20");
      appoints.setSerialNo((short) 1);
      appoints.setRegTimePoint(String.valueOf(date) + "15:20");
      appoints.setPreRegistDoctor("钟灵");
      appoints.setRegistStatus("1");
      appoints.setRegistFlag("1");
      user_id = "441900199201157075";
      String state = lhbBo.makeAppoints(appoints,user_id);
      //return state;
      System.out.println("state is :" + state + "!!!!!");
   }
   
   public void checkFlag() throws IOException
   {
      String user_id = "441900199201157075";//requestForAjax.getParameter("user_id");
      String state = lhbBo.checkForFlag(user_id);
      System.out.println(state);
      //response.getWriter().write(state);
   }
   
   public String exit()
   {
      request.clear();
      session.clear();
      application.clear();
      return SUCCESS;
   }
   
   private Date stringToDate(String year,String month,String day)
   {
      Date date =new Date(Integer.valueOf(year),
                Integer.valueOf(month), Integer.valueOf(day));
   
      return date;
   }
}
