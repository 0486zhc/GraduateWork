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
	private OutpDoctorRegist today;
	private OutpDoctorRegist twoday;
	private OutpDoctorRegist threeday;
	private OutpDoctorRegist fourday;
	private OutpDoctorRegist fiveday;
	private OutpDoctorRegist sixday;
	private OutpDoctorRegist sevenday;
	private OutpDoctorRegist eightday;
	private OutpDoctorRegist nineday;
	private OutpDoctorRegist tenday;
	private OutpDoctorRegist elevenday;
	private OutpDoctorRegist twelveday;
	private List<String> OutpDoctorRegistDoctorName;
	private List<String> OutpDoctorRegistDeptName;

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

	public OutpDoctorRegist getToday() {
		return today;
	}
	public void setToday(OutpDoctorRegist today) {
		this.today = today;
	}
	public OutpDoctorRegist getTwoday() {
		return twoday;
	}
	public void setTwoday(OutpDoctorRegist twoday) {
		this.twoday = twoday;
	}
	public OutpDoctorRegist getThreeday() {
		return threeday;
	}
	public void setThreeday(OutpDoctorRegist threeday) {
		this.threeday = threeday;
	}
	public OutpDoctorRegist getFourday() {
		return fourday;
	}
	public void setFourday(OutpDoctorRegist fourday) {
		this.fourday = fourday;
	}
	public OutpDoctorRegist getFiveday() {
		return fiveday;
	}
	public void setFiveday(OutpDoctorRegist fiveday) {
		this.fiveday = fiveday;
	}
	public OutpDoctorRegist getSixday() {
		return sixday;
	}
	public void setSixday(OutpDoctorRegist sixday) {
		this.sixday = sixday;
	}
	public OutpDoctorRegist getSevenday() {
		return sevenday;
	}
	public void setSevenday(OutpDoctorRegist sevenday) {
		this.sevenday = sevenday;
	}
	public OutpDoctorRegist getEightday() {
		return eightday;
	}
	public void setEightday(OutpDoctorRegist eightday) {
		this.eightday = eightday;
	}
	public OutpDoctorRegist getNineday() {
		return nineday;
	}
	public void setNineday(OutpDoctorRegist nineday) {
		this.nineday = nineday;
	}
	public OutpDoctorRegist getTenday() {
		return tenday;
	}
	public void setTenday(OutpDoctorRegist tenday) {
		this.tenday = tenday;
	}
	public OutpDoctorRegist getElevenday() {
		return elevenday;
	}
	public void setElevenday(OutpDoctorRegist elevenday) {
		this.elevenday = elevenday;
	}
	public OutpDoctorRegist getTwelveday() {
		return twelveday;
	}
	public void setTwelveday(OutpDoctorRegist twelveday) {
		this.twelveday = twelveday;
	}
	
	public List<String> getOutpDoctorRegistDoctorName() {
		return OutpDoctorRegistDoctorName;
	}
	public void setOutpDoctorRegistDoctorName(
			List<String> outpDoctorRegistDoctorName) {
		OutpDoctorRegistDoctorName = outpDoctorRegistDoctorName;
	}
	
	public List<String> getOutpDoctorRegistDeptName() {
		return OutpDoctorRegistDeptName;
	}
	public void setOutpDoctorRegistDeptName(List<String> outpDoctorRegistDeptName) {
		OutpDoctorRegistDeptName = outpDoctorRegistDeptName;
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
	public String CheckOnDutyMany(){
		OutpDoctorRegist12 = ozqBo.CheckOnDutyMany("0103", "0301");
		System.out.println(OutpDoctorRegist12+"==================");
		request.put("doctorregist", OutpDoctorRegist12);
		return "success";
	}
	
	
	//查排班
	public String CheckOnDuty12(){
		System.out.println("action1...");
		
		CheckOnDutyToday();
		CheckOnDutyTwoday();
		CheckOnDutyThreeday();
		CheckOnDutyFourday();
		CheckOnDutyFiveday();
		CheckOnDutySixday();
		CheckOnDutySevenday();
		CheckOnDutyEightday();
		CheckOnDutyNineday();
		CheckOnDutyTenday();
		CheckOnDutyElevenday();
		CheckOnDutyTwelveday();
		
		return "success";
	}
	
	//查Today排班
	public void CheckOnDutyToday(){
		System.out.println("action1...");
		
		today = ozqBo.CheckOnDutyToday("0103", "0301");
//		Object[] obj = today.get(0);
//		System.out.println(obj[6]);
//		OutpDoctorRegist ob = new OutpDoctorRegist();
//		ob.setAddress((String)obj[6]);
		
		if(today != null){
		System.out.println(today);
			request.put("today", today);
			System.out.println("1");
		}else{
			request.put("today", "");
			System.out.println("2");
		}
		System.out.println(today);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Twoday排班
	public void CheckOnDutyTwoday(){
		System.out.println("action1...");
		
		twoday = ozqBo.CheckOnDutyTwoday("0103", "0301");
		if(twoday != null){
			request.put("twoday", twoday);
		}else{
			request.put("twoday", "");
		}
		System.out.println(twoday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Threeday排班
	public void CheckOnDutyThreeday(){
		System.out.println("action1...");
		
		threeday = ozqBo.CheckOnDutyThreeday("0103", "0301");
		if(threeday != null){
			request.put("threeday", threeday);
		}else{
			request.put("threeday", "");
		}
		System.out.println(threeday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Fourday排班
	public void CheckOnDutyFourday(){
		System.out.println("action1...");
		
		fourday = ozqBo.CheckOnDutyFourday("0103", "0301");
		if(fourday != null){
			request.put("fourday", fourday);
		}else{
			request.put("fourday", "");
		}
		System.out.println(fourday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Fiveday排班
	public void CheckOnDutyFiveday(){
		System.out.println("action1...");
		
		fiveday = ozqBo.CheckOnDutyFiveday("0103", "0301");
		if(fiveday != null){
			request.put("fiveday", fiveday);
		}else{
			request.put("fiveday", "");
		}
		System.out.println(fiveday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Sixday排班
	public void CheckOnDutySixday(){
		System.out.println("action1...");
		
		sixday = ozqBo.CheckOnDutySixday("0103", "0301");
		if(sixday != null){
			request.put("sixday", sixday);
		}else{
			request.put("sixday", "");
		}
		System.out.println(sixday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Sevenday排班
	public void CheckOnDutySevenday(){
		System.out.println("action1...");
		
		sevenday = ozqBo.CheckOnDutySevenday("0103", "0301");
		if(sevenday != null){
			request.put("sevenday", sevenday);
		}else{
			request.put("sevenday", "");
		}
		System.out.println(sevenday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Eightday排班
	public void CheckOnDutyEightday(){
		System.out.println("action1...");
		
		eightday = ozqBo.CheckOnDutyEightday("0103", "0301");
		if(eightday != null){
			request.put("eightday", eightday);
		}else{
			request.put("eightday", "");
		}
		System.out.println(eightday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Nineday排班
	public void CheckOnDutyNineday(){
		System.out.println("action1...");
		
		nineday = ozqBo.CheckOnDutyNineday("0103", "0301");
		if(nineday != null){
			request.put("nineday", nineday);
		}else{
			request.put("nineday", "");
		}
		System.out.println(nineday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Tenday排班
	public void CheckOnDutyTenday(){
		System.out.println("action1...");
		
		tenday = ozqBo.CheckOnDutyTenday("0103", "0301");
		if(tenday != null){
			request.put("tenday", tenday);
		}else{
			request.put("tenday", "");
		}
		System.out.println(tenday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Elevenday排班
	public void CheckOnDutyElevenday(){
		System.out.println("action1...");
		
		elevenday = ozqBo.CheckOnDutyElevenday("0103", "0301");
		if(elevenday != null){
			request.put("elevenday", elevenday);
		}else{
			request.put("elevenday", "");
		}
		System.out.println(elevenday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
	
	//查Twelveday排班
	public void CheckOnDutyTwelveday(){
		System.out.println("action1...");
		
		twelveday = ozqBo.CheckOnDutyTwelveday("0103", "0301");
		if(twelveday != null){
			request.put("twelveday", twelveday);
		}else{
			request.put("twelveday", "");
		}
		System.out.println(twelveday);
		
		//OutpDoctorRegist = OzqBo.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
		System.out.println("action2...");
		
//		return "success";
	}
		
		//查医生
		public String CheckDoctorName() throws IOException{
			System.out.println("action1...");
			
			String deptname = req.getParameter("dept_name");
			System.out.println(deptname);
			deptname=new String(deptname.getBytes("ISO-8859-1"), "UTF-8");
			System.out.println(deptname);
		    OutpDoctorRegistDoctorName = ozqBo.CheckDoctorName(deptname);
		    request.put("DoctorName", OutpDoctorRegistDoctorName);
		    System.out.println(OutpDoctorRegistDoctorName.get(1));
		    System.out.println("click doctor.............");
		    return "success";
		}

		//查tab1的医生
		public String CheckDoctorNametab1() throws IOException{
			System.out.println("action1...");
			
		    OutpDoctorRegistDoctorName = ozqBo.CheckDoctorName("门诊内科");
		    request.put("DoctorNametab1", OutpDoctorRegistDoctorName);
		    System.out.println(OutpDoctorRegistDoctorName.get(1));
		    System.out.println("login doctor.............");
		    return "success";
		}
		
		//查tab2的医生
		public String CheckDoctorNametab2() throws IOException{
			System.out.println("action1...");
			
		    OutpDoctorRegistDoctorName = ozqBo.CheckDoctorName("门诊妇科");
		    request.put("DoctorNametab2", OutpDoctorRegistDoctorName);
		    System.out.println(OutpDoctorRegistDoctorName.get(1));
		    System.out.println("login doctor.............");
		    return "success";
		}
		
		//查tab3的医生
		public String CheckDoctorNametab3() throws IOException{
			System.out.println("action1...");
			
		    OutpDoctorRegistDoctorName = ozqBo.CheckDoctorName("门诊急诊科");
		    request.put("DoctorNametab3", OutpDoctorRegistDoctorName);
		    System.out.println(OutpDoctorRegistDoctorName.get(1));
		    System.out.println("login doctor.............");
		    return "success";
		}
		
		//查tab4的医生
		public String CheckDoctorNametab4() throws IOException{
			System.out.println("action1...");
			
		    OutpDoctorRegistDoctorName = ozqBo.CheckDoctorName("门诊口腔科");
		    request.put("DoctorNametab4", OutpDoctorRegistDoctorName);
		    System.out.println(OutpDoctorRegistDoctorName.get(1));
		    System.out.println("login doctor.............");
		    return "success";
		}
		
		//查tab5的医生
		public String CheckDoctorNametab5() throws IOException{
			System.out.println("action1...");
			
		    OutpDoctorRegistDoctorName = ozqBo.CheckDoctorName("门诊中医科");
		    request.put("DoctorNametab5", OutpDoctorRegistDoctorName);
		    System.out.println(OutpDoctorRegistDoctorName.get(1));
		    System.out.println("login doctor.............");
		    return "success";
		}
		
		//查tab6的医生
		public String CheckDoctorNametab6() throws IOException{
			System.out.println("action1...");
			
		    OutpDoctorRegistDoctorName = ozqBo.CheckDoctorName("门诊外科");
		    request.put("DoctorNametab6", OutpDoctorRegistDoctorName);
		    System.out.println(OutpDoctorRegistDoctorName.get(1));
		    System.out.println("login doctor.............");
		    return "success";
		}
		
		//查tab7的医生
		public String CheckDoctorNametab7() throws IOException{
			System.out.println("action1...");
			
		    OutpDoctorRegistDoctorName = ozqBo.CheckDoctorName("体检科");
		    request.put("DoctorNametab7", OutpDoctorRegistDoctorName);
		    System.out.println(OutpDoctorRegistDoctorName.get(1));
		    System.out.println("login doctor.............");
		    return "success";
		}
		
		//查一进入首页时显示的科室
		public String CheckDeptName() throws IOException{
			System.out.println("action1...");
			
		    OutpDoctorRegistDeptName = ozqBo.CheckDeptName();
		    request.put("DeptName", OutpDoctorRegistDeptName);
		    System.out.println(OutpDoctorRegistDeptName.get(1));
		    System.out.println("login doctor.............");
		    return "success";
		}
}
