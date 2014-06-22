package action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	private List<Object[]> OutpDoctorRegist12;
	
	private List<Object[]> twoday;
	private List<Object[]> twodaymoring;
	private List<Object[]> twodaynoon;
	private List<Object[]> twodayafternoon;
	private List<Object[]> twodaynight;
	
	private List<Object[]> threeday;
	private List<Object[]> threedaymoring;
	private List<Object[]> threedaynoon;
	private List<Object[]> threedayafternoon;
	private List<Object[]> threedaynight;
	
	private List<Object[]> fourday;
	private List<Object[]> fourdaymoring;
	private List<Object[]> fourdaynoon;
	private List<Object[]> fourdayafternoon;
	private List<Object[]> fourdaynight;
	
	private List<Object[]> fiveday;
	private List<Object[]> fivedaymoring;
	private List<Object[]> fivedaynoon;
	private List<Object[]> fivedayafternoon;
	private List<Object[]> fivedaynight;
	
	private List<Object[]> sixday;
	private List<Object[]> sixdaymoring;
	private List<Object[]> sixdaynoon;
	private List<Object[]> sixdayafternoon;
	private List<Object[]> sixdaynight;
	
	private List<Object[]> sevenday;
	private List<Object[]> sevendaymoring;
	private List<Object[]> sevendaynoon;
	private List<Object[]> sevendayafternoon;
	private List<Object[]> sevendaynight;
	
	private List<Object[]> eightday;
	private List<Object[]> eightdaymoring;
	private List<Object[]> eightdaynoon;
	private List<Object[]> eightdayafternoon;
	private List<Object[]> eightdaynight;
	
	private List<Object[]> OutpDoctorRegistDoctorName;
	private List<Object[]> OutpDoctorRegistDeptName;
	private List<Object[]> OutpDoctorRegistTime;
	private List<Timestamp> thedate;

	private String doctor_name;
	private String clinic_dept;
	private String doctor_no;

	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	HttpServletRequest req;
	HttpServletResponse resp;
	
	private String date2;
	private String date3;
	private String date4;
	private String date5;
	private String date6;
	private String date7;
	private String date8;
	private String day2;
	private String day3;
	private String day4;
	private String day5;
	private String day6;
	private String day7;
	private String day8;

	
	public OzqBo getOzqBo() {
		return ozqBo;
	}
	public void setOzqBo(OzqBo ozqBo) {
		this.ozqBo = ozqBo;
	}

	public List<Object[]> getOutpDoctorRegist12() {
		return OutpDoctorRegist12;
	}
	public void setOutpDoctorRegist12(List<Object[]> outpDoctorRegist12) {
		OutpDoctorRegist12 = outpDoctorRegist12;
	}

	public List<Object[]> getTwoday() {
		return twoday;
	}
	public void setTwoday(List<Object[]> twoday) {
		this.twoday = twoday;
	}
	public List<Object[]> getTwodaymoring() {
		return twodaymoring;
	}
	public void setTwodaymoring(List<Object[]> twodaymoring) {
		this.twodaymoring = twodaymoring;
	}
	public List<Object[]> getTwodaynoon() {
		return twodaynoon;
	}
	public void setTwodaynoon(List<Object[]> twodaynoon) {
		this.twodaynoon = twodaynoon;
	}
	public List<Object[]> getTwodayafternoon() {
		return twodayafternoon;
	}
	public void setTwodayafternoon(List<Object[]> twodayafternoon) {
		this.twodayafternoon = twodayafternoon;
	}
	public List<Object[]> getTwodaynight() {
		return twodaynight;
	}
	public void setTwodaynight(List<Object[]> twodaynight) {
		this.twodaynight = twodaynight;
	}
	public List<Object[]> getThreeday() {
		return threeday;
	}
	public void setThreeday(List<Object[]> threeday) {
		this.threeday = threeday;
	}
	public List<Object[]> getThreedaymoring() {
		return threedaymoring;
	}
	public void setThreedaymoring(List<Object[]> threedaymoring) {
		this.threedaymoring = threedaymoring;
	}
	public List<Object[]> getThreedaynoon() {
		return threedaynoon;
	}
	public void setThreedaynoon(List<Object[]> threedaynoon) {
		this.threedaynoon = threedaynoon;
	}
	public List<Object[]> getThreedayafternoon() {
		return threedayafternoon;
	}
	public void setThreedayafternoon(List<Object[]> threedayafternoon) {
		this.threedayafternoon = threedayafternoon;
	}
	public List<Object[]> getThreedaynight() {
		return threedaynight;
	}
	public void setThreedaynight(List<Object[]> threedaynight) {
		this.threedaynight = threedaynight;
	}
	public List<Object[]> getFourday() {
		return fourday;
	}
	public void setFourday(List<Object[]> fourday) {
		this.fourday = fourday;
	}
	public List<Object[]> getFourdaymoring() {
		return fourdaymoring;
	}
	public void setFourdaymoring(List<Object[]> fourdaymoring) {
		this.fourdaymoring = fourdaymoring;
	}
	public List<Object[]> getFourdaynoon() {
		return fourdaynoon;
	}
	public void setFourdaynoon(List<Object[]> fourdaynoon) {
		this.fourdaynoon = fourdaynoon;
	}
	public List<Object[]> getFourdayafternoon() {
		return fourdayafternoon;
	}
	public void setFourdayafternoon(List<Object[]> fourdayafternoon) {
		this.fourdayafternoon = fourdayafternoon;
	}
	public List<Object[]> getFourdaynight() {
		return fourdaynight;
	}
	public void setFourdaynight(List<Object[]> fourdaynight) {
		this.fourdaynight = fourdaynight;
	}
	public List<Object[]> getFiveday() {
		return fiveday;
	}
	public void setFiveday(List<Object[]> fiveday) {
		this.fiveday = fiveday;
	}
	public List<Object[]> getFivedaymoring() {
		return fivedaymoring;
	}
	public void setFivedaymoring(List<Object[]> fivedaymoring) {
		this.fivedaymoring = fivedaymoring;
	}
	public List<Object[]> getFivedaynoon() {
		return fivedaynoon;
	}
	public void setFivedaynoon(List<Object[]> fivedaynoon) {
		this.fivedaynoon = fivedaynoon;
	}
	public List<Object[]> getFivedayafternoon() {
		return fivedayafternoon;
	}
	public void setFivedayafternoon(List<Object[]> fivedayafternoon) {
		this.fivedayafternoon = fivedayafternoon;
	}
	public List<Object[]> getFivedaynight() {
		return fivedaynight;
	}
	public void setFivedaynight(List<Object[]> fivedaynight) {
		this.fivedaynight = fivedaynight;
	}
	public List<Object[]> getSixday() {
		return sixday;
	}
	public void setSixday(List<Object[]> sixday) {
		this.sixday = sixday;
	}
	public List<Object[]> getSixdaymoring() {
		return sixdaymoring;
	}
	public void setSixdaymoring(List<Object[]> sixdaymoring) {
		this.sixdaymoring = sixdaymoring;
	}
	public List<Object[]> getSixdaynoon() {
		return sixdaynoon;
	}
	public void setSixdaynoon(List<Object[]> sixdaynoon) {
		this.sixdaynoon = sixdaynoon;
	}
	public List<Object[]> getSixdayafternoon() {
		return sixdayafternoon;
	}
	public void setSixdayafternoon(List<Object[]> sixdayafternoon) {
		this.sixdayafternoon = sixdayafternoon;
	}
	public List<Object[]> getSixdaynight() {
		return sixdaynight;
	}
	public void setSixdaynight(List<Object[]> sixdaynight) {
		this.sixdaynight = sixdaynight;
	}
	public List<Object[]> getSevenday() {
		return sevenday;
	}
	public void setSevenday(List<Object[]> sevenday) {
		this.sevenday = sevenday;
	}
	public List<Object[]> getSevendaymoring() {
		return sevendaymoring;
	}
	public void setSevendaymoring(List<Object[]> sevendaymoring) {
		this.sevendaymoring = sevendaymoring;
	}
	public List<Object[]> getSevendaynoon() {
		return sevendaynoon;
	}
	public void setSevendaynoon(List<Object[]> sevendaynoon) {
		this.sevendaynoon = sevendaynoon;
	}
	public List<Object[]> getSevendayafternoon() {
		return sevendayafternoon;
	}
	public void setSevendayafternoon(List<Object[]> sevendayafternoon) {
		this.sevendayafternoon = sevendayafternoon;
	}
	public List<Object[]> getSevendaynight() {
		return sevendaynight;
	}
	public void setSevendaynight(List<Object[]> sevendaynight) {
		this.sevendaynight = sevendaynight;
	}
	public List<Object[]> getEightday() {
		return eightday;
	}
	public void setEightday(List<Object[]> eightday) {
		this.eightday = eightday;
	}
	public List<Object[]> getEightdaymoring() {
		return eightdaymoring;
	}
	public void setEightdaymoring(List<Object[]> eightdaymoring) {
		this.eightdaymoring = eightdaymoring;
	}
	public List<Object[]> getEightdaynoon() {
		return eightdaynoon;
	}
	public void setEightdaynoon(List<Object[]> eightdaynoon) {
		this.eightdaynoon = eightdaynoon;
	}
	public List<Object[]> getEightdayafternoon() {
		return eightdayafternoon;
	}
	public void setEightdayafternoon(List<Object[]> eightdayafternoon) {
		this.eightdayafternoon = eightdayafternoon;
	}
	public List<Object[]> getEightdaynight() {
		return eightdaynight;
	}
	public void setEightdaynight(List<Object[]> eightdaynight) {
		this.eightdaynight = eightdaynight;
	}
	
	public List<Object[]> getOutpDoctorRegistDoctorName() {
		return OutpDoctorRegistDoctorName;
	}
	public void setOutpDoctorRegistDoctorName(List<Object[]> outpDoctorRegistDoctorName) {
		OutpDoctorRegistDoctorName = outpDoctorRegistDoctorName;
	}
	
	public List<Object[]> getOutpDoctorRegistDeptName() {
		return OutpDoctorRegistDeptName;
	}
	public void setOutpDoctorRegistDeptName(List<Object[]> outpDoctorRegistDeptName) {
		OutpDoctorRegistDeptName = outpDoctorRegistDeptName;
	}
	
	public List<Object[]> getOutpDoctorRegistTime() {
		return OutpDoctorRegistTime;
	}
	public void setOutpDoctorRegistTime(List<Object[]> outpDoctorRegistTime) {
		OutpDoctorRegistTime = outpDoctorRegistTime;
	}
	
	public List<Timestamp> getThedate() {
		return thedate;
	}
	public void setThedate(List<Timestamp> thedate) {
		this.thedate = thedate;
	}
	
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
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
	
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getDate3() {
		return date3;
	}
	public void setDate3(String date3) {
		this.date3 = date3;
	}
	public String getDate4() {
		return date4;
	}
	public void setDate4(String date4) {
		this.date4 = date4;
	}
	public String getDate5() {
		return date5;
	}
	public void setDate5(String date5) {
		this.date5 = date5;
	}
	public String getDate6() {
		return date6;
	}
	public void setDate6(String date6) {
		this.date6 = date6;
	}
	public String getDate7() {
		return date7;
	}
	public void setDate7(String date7) {
		this.date7 = date7;
	}
	public String getDate8() {
		return date8;
	}
	public void setDate8(String date8) {
		this.date8 = date8;
	}
	
	public String getDay2() {
		return day2;
	}
	public void setDay2(String day2) {
		this.day2 = day2;
	}
	public String getDay3() {
		return day3;
	}
	public void setDay3(String day3) {
		this.day3 = day3;
	}
	public String getDay4() {
		return day4;
	}
	public void setDay4(String day4) {
		this.day4 = day4;
	}
	public String getDay5() {
		return day5;
	}
	public void setDay5(String day5) {
		this.day5 = day5;
	}
	public String getDay6() {
		return day6;
	}
	public void setDay6(String day6) {
		this.day6 = day6;
	}
	public String getDay7() {
		return day7;
	}
	public void setDay7(String day7) {
		this.day7 = day7;
	}
	public String getDay8() {
		return day8;
	}
	public void setDay8(String day8) {
		this.day8 = day8;
	}
	
	public OzqAction()
	   {
	      request = (Map<String, Object>) ActionContext.getContext().get("request");
	      session = ActionContext.getContext().getSession();
	      application = ActionContext.getContext().getApplication();
	      req = ServletActionContext.getRequest();
	      resp = ServletActionContext.getResponse();
	   }
	
	//设置日期格式
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
//	//查12天排班
//	public String CheckOnDutyMany(){
//		OutpDoctorRegist12 = ozqBo.CheckOnDutyMany("0103", "0301");
//		System.out.println(OutpDoctorRegist12+"==================");
//		request.put("doctorregist", OutpDoctorRegist12);
//		return "success";
//	}
	
	
	//查排班
	public String CheckOnDuty() throws UnsupportedEncodingException{
		System.out.println("action1...");
		
		String doctorname = req.getParameter("doctor_name");
		System.out.println(doctorname);
		doctorname=new String(doctorname.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(doctorname);
		request.put("doctorname", doctorname);
		ActionContext.getContext().getSession().put("doctName",doctorname);  // 放session
		
		String deptname = req.getParameter("dept_name");
		System.out.println(deptname);
		deptname=new String(deptname.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(deptname);
		request.put("deptname", deptname);
		ActionContext.getContext().getSession().put("thedeptName",deptname);  // 放session
		
		//根据医生名字找到科室编号和医生编号
		Object[] doctor = ozqBo.CheckClinicDeptDoctorNo(doctorname).get(0);
		String clinic_dept = (String) doctor[0];
		String doctor_no = (String) doctor[1];
		
		//查7天的排班
		CheckOnDutyTwoday(doctorname,clinic_dept,doctor_no);
		CheckOnDutyThreeday(doctorname,clinic_dept,doctor_no);
		CheckOnDutyFourday(doctorname,clinic_dept,doctor_no);
		CheckOnDutyFiveday(doctorname,clinic_dept,doctor_no);
		CheckOnDutySixday(doctorname,clinic_dept,doctor_no);
		CheckOnDutySevenday(doctorname,clinic_dept,doctor_no);
		CheckOnDutyEightday(doctorname,clinic_dept,doctor_no);
		
		return "success";
	}
	
	//查Twoday排班
	public void CheckOnDutyTwoday(String doctorname,String clinic_dept,String doctor_no){
		System.out.println("action1...");
		
		twoday = ozqBo.CheckOnDutyTwoday(clinic_dept, doctor_no);
		OutpDoctorRegist ob = new OutpDoctorRegist();
		//判断当天是否有排班
		if(twoday.size() != 0){
			//得到当天时间和星期几
			Object[] obj1 = twoday.get(0);
			ob.setDoctorNo((String) obj1[2]);
			ob.setDoctor(obj1[3]);
			ob.setCounselDate(obj1[4]);
			date2 = df.format(obj1[4]);
			request.put("date2", date2);
			try {
				if(df.parse(df.format(obj1[4])).getDay() == 0){
					day2 = "星期天";
				}else if(df.parse(df.format(obj1[4])).getDay() == 1){
					day2 = "星期一";
				}else if(df.parse(df.format(obj1[4])).getDay() == 2){
					day2 = "星期二";
				}else if(df.parse(df.format(obj1[4])).getDay() == 3){
					day2 = "星期三";
				}else if(df.parse(df.format(obj1[4])).getDay() == 4){
					day2 = "星期四";
				}else if(df.parse(df.format(obj1[4])).getDay() == 5){
					day2 = "星期五";
				}else{
					day2 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ob);
			request.put("twoday", ob);
			System.out.println(ob);
			
			//当天排了多少班
			for(int i = 0; i<twoday.size(); i++){
				Object[] obj = twoday.get(i);
				//排了什么时候的班
				if("上午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("twodaymoring", ob1);
				}else if("急诊中午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("twodaynoon", ob1);
				}else if("下午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("twodayafternoon", ob1);
				}else{
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("twodaynight", ob1);
				}
			}
		
			System.out.println("1");
		}else{
			
			ob.setDoctor(doctorname);
			
			//日期
			Date Twoday = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(Twoday);
			calendar.add(calendar.DATE,1);//把日期往后增加.整数往后推,负数往前移动
			Twoday=calendar.getTime(); //这个时间就是日期往后推的结果 
			String d = df.format(Twoday);
			thedate = ozqBo.CheckDate(d);
			Timestamp t = thedate.get(0);
			ob.setCounselDate(t);
			date2 = df.format(t);
			try {
				if(df.parse(df.format(t)).getDay() == 0){
					day2 = "星期天";
				}else if(df.parse(df.format(t)).getDay() == 1){
					day2 = "星期一";
				}else if(df.parse(df.format(t)).getDay() == 2){
					day2 = "星期二";
				}else if(df.parse(df.format(t)).getDay() == 3){
					day2 = "星期三";
				}else if(df.parse(df.format(t)).getDay() == 4){
					day2 = "星期四";
				}else if(df.parse(df.format(t)).getDay() == 5){
					day2 = "星期五";
				}else{
					day2 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.put("twoday", ob);
			System.out.println("2");
		}
		System.out.println(ob);
		
		System.out.println("twoday action end...");
		
	}
	
	//查Threeday排班
	public void CheckOnDutyThreeday(String doctorname,String clinic_dept,String doctor_no){
		System.out.println("action1...");
		
		threeday = ozqBo.CheckOnDutyThreeday(clinic_dept, doctor_no);
		OutpDoctorRegist ob = new OutpDoctorRegist();
		//判断当天是否有排班
		if(threeday.size() != 0){
			//得到当天时间和星期几
			Object[] obj1 = threeday.get(0);
			ob.setDoctorNo((String) obj1[2]);
			ob.setDoctor(obj1[3]);
			ob.setCounselDate(obj1[4]);
			date3 = df.format(obj1[4]);
			request.put("date3", date3);
			try {
				if(df.parse(df.format(obj1[4])).getDay() == 0){
					day3 = "星期天";
				}else if(df.parse(df.format(obj1[4])).getDay() == 1){
					day3 = "星期一";
				}else if(df.parse(df.format(obj1[4])).getDay() == 2){
					day3 = "星期二";
				}else if(df.parse(df.format(obj1[4])).getDay() == 3){
					day3 = "星期三";
				}else if(df.parse(df.format(obj1[4])).getDay() == 4){
					day3 = "星期四";
				}else if(df.parse(df.format(obj1[4])).getDay() == 5){
					day3 = "星期五";
				}else{
					day3 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.put("threeday", ob);
			
			//当天排了多少班
			for(int i = 0; i<threeday.size(); i++){
				Object[] obj = threeday.get(i);
				//排了什么时候的班
				if("上午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("threedaymoring", ob1);
				}else if("急诊中午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("threedaynoon", ob1);
				}else if("下午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("threedayafternoon", ob1);
				}else{
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("threedaynight", ob1);
				}
			}
		
			System.out.println("1");
		}else{
			
			ob.setDoctor(doctorname);
			
			//日期
			Date Threeday = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(Threeday);
			calendar.add(calendar.DATE,2);//把日期往后增加.整数往后推,负数往前移动
			Threeday=calendar.getTime(); //这个时间就是日期往后推的结果 
			String d = df.format(Threeday);
			thedate = ozqBo.CheckDate(d);
			Timestamp t = thedate.get(0);
			ob.setCounselDate(t);
			date3 = df.format(t);
			try {
				if(df.parse(df.format(t)).getDay() == 0){
					day3 = "星期天";
				}else if(df.parse(df.format(t)).getDay() == 1){
					day3 = "星期一";
				}else if(df.parse(df.format(t)).getDay() == 2){
					day3 = "星期二";
				}else if(df.parse(df.format(t)).getDay() == 3){
					day3 = "星期三";
				}else if(df.parse(df.format(t)).getDay() == 4){
					day3 = "星期四";
				}else if(df.parse(df.format(t)).getDay() == 5){
					day3 = "星期五";
				}else{
					day3 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.put("threeday", ob);
			System.out.println("2");
		}
		System.out.println(ob);
		
		System.out.println("threeday action end...");
		
	}
	
	//查Fourday排班
	public void CheckOnDutyFourday(String doctorname,String clinic_dept,String doctor_no){
		System.out.println("action1...");
		
		fourday = ozqBo.CheckOnDutyFourday(clinic_dept, doctor_no);
		OutpDoctorRegist ob = new OutpDoctorRegist();
		//判断当天是否有排班
		if(fourday.size() != 0){
			//得到当天时间和星期几
			Object[] obj1 = fourday.get(0);
			ob.setDoctorNo((String) obj1[2]);
			ob.setDoctor(obj1[3]);
			ob.setCounselDate(obj1[4]);
			date4 = df.format(obj1[4]);
			request.put("date4", date4);
			try {
				if(df.parse(df.format(obj1[4])).getDay() == 0){
					day4 = "星期天";
				}else if(df.parse(df.format(obj1[4])).getDay() == 1){
					day4 = "星期一";
				}else if(df.parse(df.format(obj1[4])).getDay() == 2){
					day4 = "星期二";
				}else if(df.parse(df.format(obj1[4])).getDay() == 3){
					day4 = "星期三";
				}else if(df.parse(df.format(obj1[4])).getDay() == 4){
					day4 = "星期四";
				}else if(df.parse(df.format(obj1[4])).getDay() == 5){
					day4 = "星期五";
				}else{
					day4 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.put("fourday", ob);
			
			//当天排了多少班
			for(int i = 0; i<fourday.size(); i++){
				Object[] obj = fourday.get(i);
				//排了什么时候的班
				if("上午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("fourdaymoring", ob1);
				}else if("急诊中午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("fourdaynoon", ob1);
				}else if("下午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("fourdayafternoon", ob1);
				}else{
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("fourdaynight", ob1);
				}
			}
		
			System.out.println("1");
		}else{
			
			ob.setDoctor(doctorname);
			
			//日期
			Date Fourday = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(Fourday);
			calendar.add(calendar.DATE,3);//把日期往后增加.整数往后推,负数往前移动
			Fourday=calendar.getTime(); //这个时间就是日期往后推的结果 
			String d = df.format(Fourday);
			thedate = ozqBo.CheckDate(d);
			Timestamp t = thedate.get(0);
			ob.setCounselDate(t);
			date4 = df.format(t);
			try {
				if(df.parse(df.format(t)).getDay() == 0){
					day4 = "星期天";
				}else if(df.parse(df.format(t)).getDay() == 1){
					day4 = "星期一";
				}else if(df.parse(df.format(t)).getDay() == 2){
					day4 = "星期二";
				}else if(df.parse(df.format(t)).getDay() == 3){
					day4 = "星期三";
				}else if(df.parse(df.format(t)).getDay() == 4){
					day4 = "星期四";
				}else if(df.parse(df.format(t)).getDay() == 5){
					day4 = "星期五";
				}else{
					day4 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.put("fourday", ob);
			System.out.println("2");
		}
		System.out.println(ob);
		
		System.out.println("fourday action end...");
		
	}
	
	//查Fiveday排班
	public void CheckOnDutyFiveday(String doctorname,String clinic_dept,String doctor_no){
		System.out.println("action1...");
		
		fiveday = ozqBo.CheckOnDutyFiveday(clinic_dept, doctor_no);
		OutpDoctorRegist ob = new OutpDoctorRegist();
		//判断当天是否有排班
		if(fiveday.size() != 0){
			//得到当天时间和星期几
			Object[] obj1 = fiveday.get(0);
			ob.setDoctorNo((String) obj1[2]);
			ob.setDoctor(obj1[3]);
			ob.setCounselDate(obj1[4]);
			date5 = df.format(obj1[4]);
			request.put("date5", date5);
			try {
				if(df.parse(df.format(obj1[4])).getDay() == 0){
					day5 = "星期天";
				}else if(df.parse(df.format(obj1[4])).getDay() == 1){
					day5 = "星期一";
				}else if(df.parse(df.format(obj1[4])).getDay() == 2){
					day5 = "星期二";
				}else if(df.parse(df.format(obj1[4])).getDay() == 3){
					day5 = "星期三";
				}else if(df.parse(df.format(obj1[4])).getDay() == 4){
					day5 = "星期四";
				}else if(df.parse(df.format(obj1[4])).getDay() == 5){
					day5 = "星期五";
				}else{
					day5 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.put("fiveday", ob);
			
			//当天排了多少班
			for(int i = 0; i<fiveday.size(); i++){
				Object[] obj = fiveday.get(i);
				//排了什么时候的班
				if("上午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("fivedaymoring", ob1);
				}else if("急诊中午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("fivedaynoon", ob1);
				}else if("下午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("fivedayafternoon", ob1);
				}else{
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("fivedaynight", ob1);
				}
			}
		
			System.out.println("1");
		}else{
			
			ob.setDoctor(doctorname);
			
			//日期
			Date Fiveday = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(Fiveday);
			calendar.add(calendar.DATE,4);//把日期往后增加.整数往后推,负数往前移动
			Fiveday=calendar.getTime(); //这个时间就是日期往后推的结果 
			String d = df.format(Fiveday);
			thedate = ozqBo.CheckDate(d);
			Timestamp t = thedate.get(0);
			ob.setCounselDate(t);
			date5 = df.format(t);
			try {
				if(df.parse(df.format(t)).getDay() == 0){
					day5 = "星期天";
				}else if(df.parse(df.format(t)).getDay() == 1){
					day5 = "星期一";
				}else if(df.parse(df.format(t)).getDay() == 2){
					day5 = "星期二";
				}else if(df.parse(df.format(t)).getDay() == 3){
					day5 = "星期三";
				}else if(df.parse(df.format(t)).getDay() == 4){
					day5 = "星期四";
				}else if(df.parse(df.format(t)).getDay() == 5){
					day5 = "星期五";
				}else{
					day5 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.put("fiveday", ob);
			System.out.println("2");
		}
		System.out.println(ob);
		
		System.out.println("fiveday action end...");
		
	}
	
	//查Sixday排班
	public void CheckOnDutySixday(String doctorname,String clinic_dept,String doctor_no){
		System.out.println("action1...");
		
		sixday = ozqBo.CheckOnDutySixday(clinic_dept, doctor_no);
		OutpDoctorRegist ob = new OutpDoctorRegist();
		//判断当天是否有排班
		if(sixday.size() != 0){
			//得到当天时间和星期几
			Object[] obj1 = sixday.get(0);
			ob.setDoctorNo((String) obj1[2]);
			ob.setDoctor(obj1[3]);
			ob.setCounselDate(obj1[4]);
			date6 = df.format(obj1[4]);
			request.put("date6", date6);
			try {
				if(df.parse(df.format(obj1[4])).getDay() == 0){
					day6 = "星期天";
				}else if(df.parse(df.format(obj1[4])).getDay() == 1){
					day6 = "星期一";
				}else if(df.parse(df.format(obj1[4])).getDay() == 2){
					day6 = "星期二";
				}else if(df.parse(df.format(obj1[4])).getDay() == 3){
					day6 = "星期三";
				}else if(df.parse(df.format(obj1[4])).getDay() == 4){
					day6 = "星期四";
				}else if(df.parse(df.format(obj1[4])).getDay() == 5){
					day6 = "星期五";
				}else{
					day6 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.put("sixday", ob);
			
			//当天排了多少班
			for(int i = 0; i<sixday.size(); i++){
				Object[] obj = sixday.get(i);
				//排了什么时候的班
				if("上午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("sixdaymoring", ob1);
				}else if("急诊中午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("sixdaynoon", ob1);
				}else if("下午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("sixdayafternoon", ob1);
				}else{
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("sixdaynight", ob1);
				}
			}
		
			System.out.println("1");
		}else{
			
			ob.setDoctor(doctorname);
			
			//日期
			Date Sixday = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(Sixday);
			calendar.add(calendar.DATE,5);//把日期往后增加.整数往后推,负数往前移动
			Sixday=calendar.getTime(); //这个时间就是日期往后推的结果 
			String d = df.format(Sixday);
			thedate = ozqBo.CheckDate(d);
			Timestamp t = thedate.get(0);
			ob.setCounselDate(t);
			date6 = df.format(t);
			try {
				if(df.parse(df.format(t)).getDay() == 0){
					day6 = "星期天";
				}else if(df.parse(df.format(t)).getDay() == 1){
					day6 = "星期一";
				}else if(df.parse(df.format(t)).getDay() == 2){
					day6 = "星期二";
				}else if(df.parse(df.format(t)).getDay() == 3){
					day6 = "星期三";
				}else if(df.parse(df.format(t)).getDay() == 4){
					day6 = "星期四";
				}else if(df.parse(df.format(t)).getDay() == 5){
					day6 = "星期五";
				}else{
					day6 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.put("sixday", ob);
			System.out.println("2");
		}
		System.out.println(ob);
		
		System.out.println("sixday action end...");
		
	}
	
	//查Sevenday排班
	public void CheckOnDutySevenday(String doctorname,String clinic_dept,String doctor_no){
		System.out.println("action1...");
		
		sevenday = ozqBo.CheckOnDutySevenday(clinic_dept, doctor_no);
		OutpDoctorRegist ob = new OutpDoctorRegist();
		//判断当天是否有排班
		if(sevenday.size() != 0){
			//得到当天时间和星期几
			Object[] obj1 = sevenday.get(0);
			ob.setDoctorNo((String) obj1[2]);
			ob.setDoctor(obj1[3]);
			ob.setCounselDate(obj1[4]);
			date7 = df.format(obj1[4]);
			request.put("date7", date7);
			try {
				if(df.parse(df.format(obj1[4])).getDay() == 0){
					day7 = "星期天";
				}else if(df.parse(df.format(obj1[4])).getDay() == 1){
					day7 = "星期一";
				}else if(df.parse(df.format(obj1[4])).getDay() == 2){
					day7 = "星期二";
				}else if(df.parse(df.format(obj1[4])).getDay() == 3){
					day7 = "星期三";
				}else if(df.parse(df.format(obj1[4])).getDay() == 4){
					day7 = "星期四";
				}else if(df.parse(df.format(obj1[4])).getDay() == 5){
					day7 = "星期五";
				}else{
					day7 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.put("sevenday", ob);
			
			//当天排了多少班
			for(int i = 0; i<sevenday.size(); i++){
				Object[] obj = sevenday.get(i);
				//排了什么时候的班
				if("上午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("sevendaymoring", ob1);
				}else if("急诊中午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("sevendaynoon", ob1);
				}else if("下午".equals(obj[5])){
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("sevendayafternoon", ob1);
				}else{
					OutpDoctorRegist ob1 = new OutpDoctorRegist();
					System.out.println(ob1.toString());
					ob1.setCounselDate(obj[4]);
					ob1.setClinicDuration(obj[5]);
					ob1.setQueueName(obj[6]);
					ob1.setLimitNumApp(obj[14]);
					ob1.setRegistApped(obj[16]);
				
					request.put("sevendaynight", ob1);
				}
			}
		
			System.out.println("1");
		}else{
			
			ob.setDoctor(doctorname);
			
			//日期
			Date Sevenday = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(Sevenday);
			calendar.add(calendar.DATE,6);//把日期往后增加.整数往后推,负数往前移动
			Sevenday=calendar.getTime(); //这个时间就是日期往后推的结果 
			String d = df.format(Sevenday);
			thedate = ozqBo.CheckDate(d);
			Timestamp t = thedate.get(0);
			ob.setCounselDate(t);
			date7 = df.format(t);
			try {
				if(df.parse(df.format(t)).getDay() == 0){
					day7 = "星期天";
				}else if(df.parse(df.format(t)).getDay() == 1){
					day7 = "星期一";
				}else if(df.parse(df.format(t)).getDay() == 2){
					day7 = "星期二";
				}else if(df.parse(df.format(t)).getDay() == 3){
					day7 = "星期三";
				}else if(df.parse(df.format(t)).getDay() == 4){
					day7 = "星期四";
				}else if(df.parse(df.format(t)).getDay() == 5){
					day7 = "星期五";
				}else{
					day7 = "星期六";
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.put("sevenday", ob);
			System.out.println("2");
		}
		System.out.println(ob);
		
		System.out.println("sevenday action end...");
		
	}
	
	//查Eightday排班
		public void CheckOnDutyEightday(String doctorname,String clinic_dept,String doctor_no){
			System.out.println("action1...");
			
			eightday = ozqBo.CheckOnDutyEightday(clinic_dept, doctor_no);
			OutpDoctorRegist ob = new OutpDoctorRegist();
			//判断当天是否有排班
			if(eightday.size() != 0){
				//得到医生编号，医生姓名，当天时间和星期几
				Object[] obj1 = eightday.get(0);
				ob.setDoctorNo((String) obj1[2]);
				ob.setDoctor(obj1[3]);
				ob.setCounselDate(obj1[4]);
				date8 = df.format(obj1[4]);
				request.put("date8", date8);
				try {
					if(df.parse(df.format(obj1[4])).getDay() == 0){
						day8 = "星期天";
					}else if(df.parse(df.format(obj1[4])).getDay() == 1){
						day8 = "星期一";
					}else if(df.parse(df.format(obj1[4])).getDay() == 2){
						day8 = "星期二";
					}else if(df.parse(df.format(obj1[4])).getDay() == 3){
						day8 = "星期三";
					}else if(df.parse(df.format(obj1[4])).getDay() == 4){
						day8 = "星期四";
					}else if(df.parse(df.format(obj1[4])).getDay() == 5){
						day8 = "星期五";
					}else{
						day8 = "星期六";
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.put("eightday", ob);
				
				//当天排了多少班
				for(int i = 0; i<eightday.size(); i++){
					Object[] obj = eightday.get(i);
					//排了什么时候的班
					if("上午".equals(obj[5])){
						OutpDoctorRegist ob1 = new OutpDoctorRegist();
						System.out.println(ob1.toString());
						ob1.setCounselDate(obj[4]);
						ob1.setClinicDuration(obj[5]);
						ob1.setQueueName(obj[6]);
						ob1.setLimitNumApp(obj[14]);
						ob1.setRegistApped(obj[16]);
					
						request.put("eightdaymoring", ob1);
					}else if("急诊中午".equals(obj[5])){
						OutpDoctorRegist ob1 = new OutpDoctorRegist();
						System.out.println(ob1.toString());
						ob1.setCounselDate(obj[4]);
						ob1.setClinicDuration(obj[5]);
						ob1.setQueueName(obj[6]);
						ob1.setLimitNumApp(obj[14]);
						ob1.setRegistApped(obj[16]);
					
						request.put("eightdaynoon", ob1);
					}else if("下午".equals(obj[5])){
						OutpDoctorRegist ob1 = new OutpDoctorRegist();
						System.out.println(ob1.toString());
						ob1.setCounselDate(obj[4]);
						ob1.setClinicDuration(obj[5]);
						ob1.setQueueName(obj[6]);
						ob1.setLimitNumApp(obj[14]);
						ob1.setRegistApped(obj[16]);
					
						request.put("eightdayafternoon", ob1);
					}else{
						OutpDoctorRegist ob1 = new OutpDoctorRegist();
						System.out.println(ob1.toString());
						ob1.setCounselDate(obj[4]);
						ob1.setClinicDuration(obj[5]);
						ob1.setQueueName(obj[6]);
						ob1.setLimitNumApp(obj[14]);
						ob1.setRegistApped(obj[16]);
					
						request.put("eightdaynight", ob1);
					}
				}
			
				System.out.println("1");
			}else{
				
				ob.setDoctor(doctorname);
				
				//日期
				Date eightday = new Date();
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(eightday);
				calendar.add(calendar.DATE,7);//把日期往后增加.整数往后推,负数往前移动
				eightday=calendar.getTime(); //这个时间就是日期往后推的结果
				String d = df.format(eightday);
				thedate = ozqBo.CheckDate(d);
				Timestamp t = thedate.get(0);
				ob.setCounselDate(t);
				date8 = df.format(t);
				try {
					if(df.parse(df.format(t)).getDay() == 0){
						day8 = "星期天";
					}else if(df.parse(df.format(t)).getDay() == 1){
						day8 = "星期一";
					}else if(df.parse(df.format(t)).getDay() == 2){
						day8 = "星期二";
					}else if(df.parse(df.format(t)).getDay() == 3){
						day8 = "星期三";
					}else if(df.parse(df.format(t)).getDay() == 4){
						day8 = "星期四";
					}else if(df.parse(df.format(t)).getDay() == 5){
						day8 = "星期五";
					}else{
						day8 = "星期六";
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.put("eightday", ob);
				System.out.println("2");
			}
			System.out.println(ob);
			
			System.out.println("eightday action end...");
			
		}
	
	//查每个时间点
	public String CheckRegistTime() throws UnsupportedEncodingException{
			System.out.println("action1...");
			
			String doctorno = req.getParameter("doctor_no");
			doctorno=new String(doctorno.getBytes("ISO-8859-1"), "UTF-8");
			
			String counseldate = req.getParameter("counsel_date");
			counseldate=new String(counseldate.getBytes("ISO-8859-1"), "UTF-8");
			request.put("counseldate", counseldate);
			
			String clinicduration = req.getParameter("clinic_duration");
			clinicduration=new String(clinicduration.getBytes("ISO-8859-1"), "UTF-8");
			request.put("clinicduration", clinicduration);
			
			String queuename = req.getParameter("queue_name");
			queuename=new String(queuename.getBytes("ISO-8859-1"), "UTF-8");
			request.put("queuename", queuename);
			
			OutpDoctorRegistTime = ozqBo.CheckRegistTime(doctorno, counseldate, clinicduration, queuename);
			if(OutpDoctorRegistTime.size() != 0){
				String[] registtime = new String[OutpDoctorRegistTime.size()];
				for(int i = 0; i < OutpDoctorRegistTime.size(); i++){
					Object[] obj = OutpDoctorRegistTime.get(i);
					registtime[i] = (String) obj[1];
					System.out.println(registtime[i]);
					System.out.println(registtime.length);
				}
				request.put("registtime", registtime);
				System.out.println("1");
			}else{
			request.put("registtime", "");
			System.out.println("2");
			}
			return "success";
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
		
}
