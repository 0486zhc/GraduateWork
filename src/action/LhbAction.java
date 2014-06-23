package action;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
   private String visit_date;
   private String clinic_Label;
   private String visit_time;//白天 中午 晚上
   private String timePoint;
   private String doc_no;
   
   
   
   public String getVisit_date()
   {
      return visit_date;
   }

   public void setVisit_date(String visit_date)
   {
      this.visit_date = visit_date;
   }

   public String getClinic_Label()
   {
      return clinic_Label;
   }

   public void setClinic_Label(String clinic_Label)
   {
      this.clinic_Label = clinic_Label;
   }

   public String getVisit_time()
   {
      return visit_time;
   }

   public void setVisit_time(String visit_time)
   {
      this.visit_time = visit_time;
   }

   public String getTimePoint()
   {
      return timePoint;
   }

   public void setTimePoint(String timePoint)
   {
      this.timePoint = timePoint;
   }

   public String getDoc_no()
   {
      return doc_no;
   }

   public void setDoc_no(String doc_no)
   {
      this.doc_no = doc_no;
   }

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

   public String makeAppoints()
   {
      if(session.get("user") == null)
      {
         return SUCCESS;
      }
      PatMasterIndex pi = (PatMasterIndex) session.get("user");
      // appoints
      appoints = new ClinicAppoints();
      appoints.setPatientId(pi.getPatientId());
      appoints.setName(pi.getName());
      appoints.setAge(getAge(pi.getDateOfBirth()));
      appoints.setRegistFlag("0");
      appoints.setRegistStatus("0");
      appoints.setModeCode("7");
      appoints.setVisitDateAppted(Date.valueOf(visit_date));
      //appoints.setClinicLabel(clinic_Label);
      appoints.setClinicLabel((String)session.get("queuename"));
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date today = new Date(System.currentTimeMillis());
      appoints.setApptMadeDate(today);
      appoints.setVisitTimeAppted(visit_time);
      appoints.setRegTimePoint(visit_date + " " + timePoint);
      appoints.setPreRegistDoctor((String)session.get("doctorno"));
      String state = lhbBo.makeAppoints(appoints,user_id);
      return state;
     
      
      
      
      
   }
   
   private Long getAge(Timestamp dateOfBirth)
   {
      
      Calendar cal = Calendar.getInstance();
      int year = cal.get(Calendar.YEAR);
      Long age = (long) (year- (dateOfBirth.getYear()+1900));
       
      return age;
   }

   public void checkFlag() throws IOException
   {
      String state = lhbBo.checkForFlag(user_id);
      response.getWriter().write(state);
   }
   
   public String exit()
   {
      request.clear();
      session.clear();
      application.clear();
      return SUCCESS;
   }

}