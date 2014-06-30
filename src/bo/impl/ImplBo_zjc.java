package bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import oracle.jdbc.Const;

import model.Ozq.ClinicAppoints;
import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;
import model.zjc.MessageBox;
import bo.IBo_zjc;
import dao.IDao_zjc;

public class ImplBo_zjc implements IBo_zjc{

	private IDao_zjc dao ;
	
	final Integer dayNum = 7 ;
	
	public IDao_zjc getDao() {
		return dao;
	}

	public void setDao(IDao_zjc dao) {
		this.dao = dao;
	}


	@Override
	public PatMasterIndex verify(String userName, String passWord) {
		PatMasterIndex pat = dao.verify(userName, passWord);
		return pat;
	}

	@Override
	public String addRegister(PatMasterIndex patMasterIndex) {
		System.out.println("maxPatientId : "+dao.getMaxPatientId());
		patMasterIndex.setPatientId(dao.getMaxPatientId());
//		patMasterIndex.setDateOfBirth("1992-3-5");
		if(dao.savePatientInfo(patMasterIndex)){
			ActionContext.getContext().getSession().put("pat",patMasterIndex); 
			return "注册成功！";
		}else{
			return "注册失败！";
		}
	}

	@Override
	public List<DeptDict> getDepts() {
		System.out.println("getDept");
		return dao.getDepts();
	}

	@Override
	public List<StaffDict> getDoctorsInfo(Integer deptCode) {
		return dao.getDoctorsInfo(deptCode);
	}

	@Override
	public DeptDict getDept(Integer deptCode) {
		return dao.getDept(deptCode);
	}

	@Override
	public List<OutpDoctorRegist> getOutpDoctor(Integer doctorNo) {
		 StaffDict doctor = dao.getDoctor(doctorNo);
		 System.out.println("doctor=" + doctor);
		 List<OutpDoctorRegist> registDoctors= dao.CheckOnDuty(dayNum, doctor.getDeptCode(), String.valueOf(doctorNo));
		 System.out.println("registDoctors="+registDoctors);
		 return registDoctors ;
	}

	@Override
	public List<ClinicAppoints> getAppoints(PatMasterIndex pat) {

		return dao.getAppoints(pat);
	}

	@Override
	public StaffDict getDoctor(Integer doctorNO) {
		return dao.getDoctor(doctorNO);
	}

	@Override
	public String addAdvice(MessageBox advice) {
		if(dao.saveAdvice(advice)){
			return "提交成功";
		}else{
			return "提交失败";
		}
		
	}

	@Override
	public String modifyAppoint(ClinicAppoints appoint) {
		if(dao.cancleAppoint(appoint)){
			return "取消预约【成功】！";
		}else{
			return "取消预约【失败】！";
		}
	}

	@Override
	public List<String> getAppointTimes(String doctorName, String date,
			String duration) {
		OutpDoctorRegist out = dao.getOutpDoctorOne(doctorName,date,duration);
//		String start_time = out.getRegBeginTime();
//		String end_time = out.getRegEndTime();
//		System.out.println(start_time - end_time);
//		Integer num = out.getLimitNumApp();
		
//		List<String> times = new ArrayList<String>();
//		times.add(start_time);
//		times.add(end_time);
		
		System.out.println("out="+out);
		return null;
	}

	@Override
	public List<Object[]> CheckRegistTime(String doctor_no,
			String counsel_date, String clinic_duration, String queue_name) {
		System.out.println("bo CheckRegistTime begin...");
		return dao.CheckRegistTime(doctor_no, counsel_date, clinic_duration, queue_name);
	}

	@Override
	public String addAppoints(ClinicAppoints appoints, String user_id) {
//		&& dao.updateOutDoctor(appoints)
		 if(dao.addAppoints(appoints,user_id) && dao.updateOutDoctor(appoints) ){
			 return "预约成功！";
		 }else{
			 return "预约失败！";
		 }
	}
}
