package bo.impl;

import java.util.ArrayList;
import java.util.List;

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
		if(dao.savePatientInfo(patMasterIndex)){
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
}
