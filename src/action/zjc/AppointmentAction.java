package action.zjc;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import util.MyUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Ozq.ClinicAppoints;
import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;
import bo.IBo_zjc;

public class AppointmentAction extends ActionSupport{
	private IBo_zjc bo ;
	
	private List<DeptDict> depts ; 
	private DeptDict dept;
	private List<StaffDict> doctorsInfo ;
	private List<OutpDoctorRegist> outDoctors ; 
	private List<ClinicAppoints> appointsList;
	private ClinicAppoints appoint;
	private PatMasterIndex pat ;
	private List<String> times;
	
	private String mess ;
	private Integer deptCode ;
	private Integer doctorNo;
	private String date;
	private String mess2;
	private String mess3;

	private List<Object[]> OutpDoctorRegistTime;
	
	// 找科室
	public String findDepts(){
		System.out.println("findDept");
		depts = bo.getDepts();
		System.out.println("depts = " + depts);
		mess = "科室";
		return "depts";
	}
	
	// 找医生
	public String findDoctors(){
		System.out.println("findDoctors");
		doctorsInfo = bo.getDoctorsInfo(deptCode);
		dept = bo.getDept(deptCode);
////		ActionContext.getContext().getSession().put("dept",dept);  // 放session
//		dept = bo.getDept(deptCode);
		return "doctors";
	}
	
	// 预约 具体时间
	public String appointTimes(){
		System.out.println("appointTime");
//		String a= MyUtil.formatContent(mess);
//		mess2 =  (String) ActionContext.getContext().getSession().get("doctName"); //医生姓名
		mess2= MyUtil.formatContent(mess2);  // 医生编号
		System.out.println(mess2);
		date = MyUtil.formatContent(date);  // 日期
		System.out.println(date);
		mess = MyUtil.formatContent(mess);  // 上午
		System.out.println(mess);
		mess3 = MyUtil.formatContent(mess3);  // queueName
		System.out.println(mess3);
//		times = bo.getAppointTimes(mess2, date, mess);
		
//		OutpDoctorRegistTime = bo.CheckRegistTime(doctorno, counseldate, clinicduration, queuename);
		OutpDoctorRegistTime = bo.CheckRegistTime(mess2, date, mess, mess3);
		if(OutpDoctorRegistTime.size() != 0){
			String[] registtime = new String[OutpDoctorRegistTime.size()];
			for(int i = 0; i < OutpDoctorRegistTime.size(); i++){
				Object[] obj = OutpDoctorRegistTime.get(i);
				registtime[i] = (String) obj[1];
				System.out.println(registtime[i]);
//				System.out.println(registtime.length);
			}
//			request.put("registtime", registtime);
			ActionContext.getContext().getSession().put("preTimes",registtime);  // 放session
			System.out.println("1");
		}else{
//		request.put("registtime", null);
			ActionContext.getContext().getSession().put("preTimes",null);  // 放session
			System.out.println("2");
		}
		System.out.println(times);
		return "appointTimes";
	}
	
	
	public String addAppoint(){
		System.out.println("addAppoint");
		
		
		
		return "appointsInfo";
	}
	
	// 查询预约
	public String checkAppoints(){
		System.out.println("checkAppointment");
		 pat = (PatMasterIndex) ActionContext.getContext().getSession().get("pat");
		if(pat != null){
			appointsList = bo.getAppoints(pat);
			ActionContext.getContext().getSession().put("appointsList",appointsList);  // 放session
			// 医生名称
			System.out.println("appointsList"+appointsList);
			return "appoints";
		}else{
			return "login";
		} 
	}
	
//	// 排班
//	public String findDoctorTime(){
//		System.out.println("doctorNo:"+doctorNo);
////		outDoctors = bo.getOutpDoctor(doctorNo);
////		System.out.println("length = " + outDoctors.size());
//		return "doctorTime";
//	}
	
	// 取消预约
	public String cancle(){
		System.out.println("cancle");
		String regTime = mess.substring(0, 16);
		String regDoctorNo = mess.substring(26);
		appointsList = (List<ClinicAppoints>) ActionContext.getContext().getSession().get("appointsList");
		for(ClinicAppoints c : appointsList){
			if(c.getRegTimePoint().equals(regTime) && c.getPreRegistDoctor().equals(regDoctorNo)){
				appoint = c;
				System.out.println("appoint="+ appoint);
			}
		}
		mess = bo.modifyAppoint(appoint);
		System.out.println(mess);
		return "appointsInfo";
	}
	
	
/*    =====================小乔===========================   */
//	private Map<String, Object> request;
//	HttpServletRequest req;
//	
//	//查排班
//		public String CheckOnDuty() throws UnsupportedEncodingException{
//			System.out.println("action1...");
//			
//			String doctorname = req.getParameter("doctor_name");
//			System.out.println(doctorname);
//			doctorname=new String(doctorname.getBytes("ISO-8859-1"), "UTF-8");
//			System.out.println(doctorname);
//			request.put("doctorname", doctorname);
//			String deptname = req.getParameter("dept_name");
//			System.out.println(deptname);
//			deptname=new String(deptname.getBytes("ISO-8859-1"), "UTF-8");
//			System.out.println(deptname);
//			request.put("deptname", deptname);
//			
//			//根据医生名字名字找到科室编号和医生编号
//			Object[] doctor = ozqBo.CheckClinicDeptDoctorNo(doctorname).get(0);
//			String clinic_dept = (String) doctor[0];
//			String doctor_no = (String) doctor[1];
//	//// leovany
////			doctor_no = "3506";
//			//查7天的排班
//			CheckOnDutyToday(clinic_dept,doctor_no);
//			CheckOnDutyTwoday(clinic_dept,doctor_no);
//			CheckOnDutyThreeday(clinic_dept,doctor_no);
//			CheckOnDutyFourday(clinic_dept,doctor_no);
//			CheckOnDutyFiveday(clinic_dept,doctor_no);
//			CheckOnDutySixday(clinic_dept,doctor_no);
//			CheckOnDutySevenday(clinic_dept,doctor_no);
//			
//			return "success";
//		}
//	
//	
//		//查Twoday排班
//		public void CheckOnDutyTwoday(String clinic_dept,String doctor_no){
//			System.out.println("action1...");
//// 增加个传参日期
//			twoday = ozqBo.CheckOnDutyTwoday(clinic_dept, doctor_no);  
//			OutpDoctorRegist ob = new OutpDoctorRegist();
//			//判断当天是否有排班
//			if(twoday.size() != 0){
//				//得到当天时间和星期几
//				Object[] obj1 = twoday.get(0);
//				ob.setDoctor(obj1[3]);
//				ob.setCounselDate(obj1[4]);
//				date2 = df.format(obj1[4]);
//				try {
//					if(df.parse(df.format(obj1[4])).getDay() == 0){
//						day2 = "星期天";
//					}else if(df.parse(df.format(obj1[4])).getDay() == 1){
//						day2 = "星期一";
//					}else if(df.parse(df.format(obj1[4])).getDay() == 2){
//						day2 = "星期二";
//					}else if(df.parse(df.format(obj1[4])).getDay() == 3){
//						day2 = "星期三";
//					}else if(df.parse(df.format(obj1[4])).getDay() == 4){
//						day2 = "星期四";
//					}else if(df.parse(df.format(obj1[4])).getDay() == 5){
//						day2 = "星期五";
//					}else{
//						day2 = "星期六";
//					}
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				request.put("twoday", ob);
//				
//				//当天排了多少班
//				for(int i = 0; i<twoday.size(); i++){
//					Object[] obj = twoday.get(i);
//					//排了什么时候的班
//					if("上午".equals(obj[5])){
//						OutpDoctorRegist ob1 = new OutpDoctorRegist();
//						System.out.println(ob1.toString());
//						ob1.setCounselDate(obj[4]);
//						ob1.setClinicDuration(obj[5]);
//						ob1.setQueueName(obj[6]);
//						ob1.setLimitNumApp(obj[14]);
//						ob1.setRegistApped(obj[16]);
//					
//						request.put("twodaymoring", ob1);
//					}else if("急诊中午".equals(obj[5])){
//						OutpDoctorRegist ob1 = new OutpDoctorRegist();
//						System.out.println(ob1.toString());
//						ob1.setCounselDate(obj[4]);
//						ob1.setClinicDuration(obj[5]);
//						ob1.setQueueName(obj[6]);
//						ob1.setLimitNumApp(obj[14]);
//						ob1.setRegistApped(obj[16]);
//					
//						request.put("twodaynoon", ob1);
//					}else if("下午".equals(obj[5])){
//						OutpDoctorRegist ob1 = new OutpDoctorRegist();
//						System.out.println(ob1.toString());
//						ob1.setCounselDate(obj[4]);
//						ob1.setClinicDuration(obj[5]);
//						ob1.setQueueName(obj[6]);
//						ob1.setLimitNumApp(obj[14]);
//						ob1.setRegistApped(obj[16]);
//					
//						request.put("twodayafternoon", ob1);
//					}else{
//						OutpDoctorRegist ob1 = new OutpDoctorRegist();
//						System.out.println(ob1.toString());
//						ob1.setCounselDate(obj[4]);
//						ob1.setClinicDuration(obj[5]);
//						ob1.setQueueName(obj[6]);
//						ob1.setLimitNumApp(obj[14]);
//						ob1.setRegistApped(obj[16]);
//					
//						request.put("twodaynight", ob1);
//					}
//				}
//			
//				System.out.println("1");
//			}else{
//				
//				ob.setDoctor("钟灵");
//				
//				//日期
//				Date Twoday = new Date();
//				Calendar calendar = new GregorianCalendar();
//				calendar.setTime(Twoday);
//				calendar.add(calendar.DATE,1);//把日期往后增加.整数往后推,负数往前移动
//				Twoday=calendar.getTime(); //这个时间就是日期往后推的结果 
//				String d = df.format(Twoday);
//				thedate = ozqBo.CheckDate(d);
//				Timestamp t = thedate.get(0);
//				ob.setCounselDate(t);
//				date2 = df.format(t);
//				try {
//					if(df.parse(df.format(t)).getDay() == 0){
//						day2 = "星期天";
//					}else if(df.parse(df.format(t)).getDay() == 1){
//						day2 = "星期一";
//					}else if(df.parse(df.format(t)).getDay() == 2){
//						day2 = "星期二";
//					}else if(df.parse(df.format(t)).getDay() == 3){
//						day2 = "星期三";
//					}else if(df.parse(df.format(t)).getDay() == 4){
//						day2 = "星期四";
//					}else if(df.parse(df.format(t)).getDay() == 5){
//						day2 = "星期五";
//					}else{
//						day2 = "星期六";
//					}
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				request.put("twoday", ob);
//				System.out.println("2");
//			}
//			System.out.println(ob);
//			
//			System.out.println("twoday action end...");
//			
//		}
//	
//	
	
	
	
	
	
	
	
/*  ==================== get/set 方法=======================================	*/
	
	
	public List<OutpDoctorRegist> getOutDoctors() {
		return outDoctors;
	}

	public List<String> getTimes() {
		return times;
	}

	public String getMess3() {
		return mess3;
	}

	public void setMess3(String mess3) {
		this.mess3 = mess3;
	}

	public void setTimes(List<String> times) {
		this.times = times;
	}

	public String getMess2() {
		return mess2;
	}

	public void setMess2(String mess2) {
		this.mess2 = mess2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ClinicAppoints getAppoint() {
		return appoint;
	}

	public void setAppoint(ClinicAppoints appoint) {
		this.appoint = appoint;
	}

	public PatMasterIndex getPat() {
		return pat;
	}

	public void setPat(PatMasterIndex pat) {
		this.pat = pat;
	}

	public List<ClinicAppoints> getAppointsList() {
		return appointsList;
	}

	public void setAppointsList(List<ClinicAppoints> appointsList) {
		this.appointsList = appointsList;
	}

	public void setOutDoctors(List<OutpDoctorRegist> outDoctors) {
		this.outDoctors = outDoctors;
	}

	public Integer getDoctorNo() {
		return doctorNo;
	}

	public void setDoctorNo(Integer doctorNo) {
		this.doctorNo = doctorNo;
	}

	public DeptDict getDept() {
		return dept;
	}

	public void setDept(DeptDict dept) {
		this.dept = dept;
	}

	public List<StaffDict> getDoctorsInfo() {
		return doctorsInfo;
	}

	public void setDoctorsInfo(List<StaffDict> doctorsInfo) {
		this.doctorsInfo = doctorsInfo;
	}

	public Integer getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(Integer deptCode) {
		this.deptCode = deptCode;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public List<DeptDict> getDepts() {
		return depts;
	}

	public void setDepts(List<DeptDict> depts) {
		this.depts = depts;
	}

	public IBo_zjc getBo() {
		return bo;
	}

	public void setBo(IBo_zjc bo) {
		this.bo = bo;
	}

	
	
	
}
