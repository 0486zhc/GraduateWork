package action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ozq.OutpDoctorRegist;

import org.apache.struts2.ServletActionContext;

import bo.OzqBo;

import com.opensymphony.xwork2.ActionContext;

public class OzqAction{

	private OzqBo ozqBo;
	private List<OutpDoctorRegist> OutpDoctorRegist12;
	private List<OutpDoctorRegist> OutpDoctorRegist7;
	private List<String> OutpDoctorRegistDoctorName;

	private Date start_time;
	private Date end_time;
	private String clinic_dept;
	private String doctor_no;

	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	HttpServletRequest req;
	HttpServletResponse resp;

	
	
	public OzqBo getOzqBo() {
		return ozqBo;
	}
	public void setOzqBo(OzqBo ozqBo) {
		this.ozqBo = ozqBo;
	}

	public List<OutpDoctorRegist> getOutpDoctorRegist12() {
		return OutpDoctorRegist12;
	}
	public void setOutpDoctorRegist12(List<OutpDoctorRegist> outpDoctorRegist12) {
		OutpDoctorRegist12 = outpDoctorRegist12;
	}
	public List<OutpDoctorRegist> getOutpDoctorRegist7() {
		return OutpDoctorRegist7;
	}
	public void setOutpDoctorRegist7(List<OutpDoctorRegist> outpDoctorRegist7) {
		OutpDoctorRegist7 = outpDoctorRegist7;
	}
	
	public List<String> getOutpDoctorRegistDoctorName() {
		return OutpDoctorRegistDoctorName;
	}
	public void setOutpDoctorRegistDoctorName(
			List<String> outpDoctorRegistDoctorName) {
		OutpDoctorRegistDoctorName = outpDoctorRegistDoctorName;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
	public String getClinic_dept() {
		return clinic_dept;
	}
	public void setClinic_dept(String clinic_dept) {
		this.clinic_dept = clinic_dept;
	}
	
	public String getDoctor_no() {
		return doctor_no;
	}
	public void setDoctor_no(String doctor_no) {
		this.doctor_no = doctor_no;
	}
	
	public OzqAction()
	   {
	      request = (Map<String, Object>) ActionContext.getContext().get("request");
	      session = ActionContext.getContext().getSession();
	      application = ActionContext.getContext().getApplication();
	      req = ServletActionContext.getRequest();
	      resp = ServletActionContext.getResponse();
	   }
	
	//查12天排班
	public String CheckOnDuty12(){
		System.out.println("action1...");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		//开始日期
		Date today = new Date();
		String str1 = df.format(today);
		//结束日期
		Date twelveday = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(twelveday);
		calendar.add(calendar.DATE,11);//把日期往后增加一天.整数往后推,负数往前移动
		twelveday=calendar.getTime(); //这个时间就是日期往后推的结果 
		String str2 = df.format(twelveday);
		
		System.out.println(str1);
		System.out.println(str2);
		
		OutpDoctorRegist12 = ozqBo.CheckOnDuty(str1, str2, "0101", "1106");
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
		return "success";
	}
	
	//查7天排班
		public String CheckOnDuty7(){
			System.out.println("action1...");
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			//开始日期
			Date today = new Date();
			String str1 = df.format(today);
			//结束日期
			Date twelveday = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(twelveday);
			calendar.add(calendar.DATE,6);//把日期往后增加一天.整数往后推,负数往前移动
			twelveday=calendar.getTime(); //这个时间就是日期往后推的结果 
			String str2 = df.format(twelveday);
			
			System.out.println(str1);
			System.out.println(str2);
			
			OutpDoctorRegist7 = ozqBo.CheckOnDuty(str1, str2, "0101", "1106");
			//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
			System.out.println("action2...");
			
			return "success";
		}
		
		public void CheckDoctorName() throws IOException{
			System.out.println("action1...");
			
			String deptname = req.getParameter("dept_name");
			deptname = new String(deptname.getBytes("ISO-8859-1"),"UTF-8");
		    System.out.println(deptname);
		    OutpDoctorRegistDoctorName = ozqBo.CheckDoctorName(deptname);
		    session.put("DoctorName", OutpDoctorRegistDoctorName);
		    System.out.println(OutpDoctorRegistDoctorName.get(1));
		    String state = "";
		    if(OutpDoctorRegistDoctorName != null){
		    	state = "success";
			}else{
				state = "fail";
			}
		    resp.getWriter().write(state);
		}

}
