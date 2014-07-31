package action.zjc;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import model.Ozq.ClinicAppoints;
import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;
import util.MyUtil;
import bo.IBo_zjc;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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
	private String user_id; // 预约
	private String mess4;
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
		return "doctors";
	}
	
	// 预约 具体时间
	public String appointTimes(){
		System.out.println("appointTime");
		mess2= MyUtil.formatContent(mess2);  // 医生编号
		System.out.println(mess2);
		date = MyUtil.formatContent(date);  // 日期
		System.out.println(date);
		mess = MyUtil.formatContent(mess);  // 上午
		System.out.println(mess);
		mess3 = MyUtil.formatContent(mess3);  // 号别
		System.out.println(mess3);
		
		// 将医生编号，日期,上午 放入 session
		ActionContext.getContext().getSession().put("dNo", mess2);
		ActionContext.getContext().getSession().put("dDate", date);
		ActionContext.getContext().getSession().put("dDuring", mess);
		
		
		OutpDoctorRegistTime = bo.CheckRegistTime(mess2, date, mess, mess3);
		if(OutpDoctorRegistTime.size() != 0){
			String[] registtime = new String[OutpDoctorRegistTime.size()];
			for(int i = 0; i < OutpDoctorRegistTime.size(); i++){
				Object[] obj = OutpDoctorRegistTime.get(i);
				registtime[i] = (String) obj[1];
				System.out.println(registtime[i]);
			}
			ActionContext.getContext().getSession().put("preTimes",registtime);  // 放session
			System.out.println("1");
		}else{
			ActionContext.getContext().getSession().put("preTimes",null);  // 放session
			System.out.println("2");
		}
		System.out.println(times);
		return "appointTimes";
	}
	
	// 下预约
	public String addAppoint(){
		System.out.println("addAppoint");
		pat = (PatMasterIndex) ActionContext.getContext().getSession().get("pat");  // 放session 
		System.out.println(pat);
		if(pat == null){
			return "login";
		}
		System.out.println("pat="+pat);
		System.out.println("appoint="+appoint);
		System.out.println(pat.getPatientId());
		String id = pat.getPatientId();
		
		mess2 =(String) ActionContext.getContext().getSession().get("dNo"); // 医生编号
		date = (String) ActionContext.getContext().getSession().get("dDate"); // 日期
		mess3 = (String) ActionContext.getContext().getSession().get("dDuring");  // 白天 中午 晚上         
		mess = MyUtil.formatContent(mess);		// 时间点	
		mess4 = MyUtil.formatContent(mess4);// queuename 号别
					
//		System.out.println("医生编号："+mess2 +",日期:"+date+",间断:"+mess3+",时间点："+mess+",号别："+mess4);		
//		System.out.println(Date.valueOf(date));
		
		ClinicAppoints appoints = new ClinicAppoints();
		System.out.println(pat.getDateOfBirth());
		System.out.println("age="+getAge(pat.getDateOfBirth()));
		appoints.setAge(getAge(pat.getDateOfBirth()));
		
		appoints.setSex(pat.getSex());
		appoints.setPatientId(pat.getPatientId());
		appoints.setName(pat.getName());
	    appoints.setAge(MyUtil.getAge(pat.getDateOfBirth())); 
	    appoints.setRegistFlag("0");
	    appoints.setRegistStatus("0");
	    appoints.setModeCode("8");
	    appoints.setVisitDateAppted(Date.valueOf(date));
	    appoints.setClinicLabel(mess4); // 号别
	    Date today = new Date(System.currentTimeMillis());
	    appoints.setApptMadeDate(today);
	    appoints.setVisitTimeAppted(mess3);
	    appoints.setRegTimePoint(date + " " + mess);
	    appoints.setPreRegistDoctor(mess2);
//	    System.out.println(appoints);
	    
	    mess = bo.addAppoints(appoints,pat.getIdNo());
	    
		return "appointsInfo";
	}
	
	// 查询预约
	public String checkAppoints(){
		System.out.println("checkAppointment");
		 pat = (PatMasterIndex) ActionContext.getContext().getSession().get("pat");
		 System.out.println("查预约pat="+pat);
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
	
	 private Long getAge(Timestamp dateOfBirth)
	   {
	      Calendar cal = Calendar.getInstance();
	      int year = cal.get(Calendar.YEAR);
	      Long age = (long) (year- (dateOfBirth.getYear()+1900));
	       
	      return age;
	   }
	 
/*  ==================== get/set 方法=======================================	*/
	
	
	public List<OutpDoctorRegist> getOutDoctors() {
		return outDoctors;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public List<Object[]> getOutpDoctorRegistTime() {
		return OutpDoctorRegistTime;
	}

	public void setOutpDoctorRegistTime(List<Object[]> outpDoctorRegistTime) {
		OutpDoctorRegistTime = outpDoctorRegistTime;
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

	public String getMess4() {
		return mess4;
	}

	public void setMess4(String mess4) {
		this.mess4 = mess4;
	}

	
	
	
}
