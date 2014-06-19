package bo;

import java.util.List;

import model.Ozq.OutpDoctorRegist;
import dao.OzqDao;

public class OzqBo{

private OzqDao OzqDao;
	
	public OzqDao getOzqDao() {
		return OzqDao;
	}
	public void setOzqDao(OzqDao OzqDao) {
		this.OzqDao = OzqDao;
	}

	//查排班
	public List<OutpDoctorRegist> CheckOnDuty(String start_time,String end_time, String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDuty(start_time, end_time, clinic_dept, doctor_no);
	}
	
	//查医生姓名
	public List<String> CheckDoctorName(String deptname) {
		System.out.println("bo...");
		List<String> odr = OzqDao.CheckDoctorName(deptname);
		System.out.println("bo CheckDoctorName end...");
		return odr;
	}
	
	//查科室
		public List<String> CheckDeptName() {
			System.out.println("bo...");
			List<String> odr = OzqDao.CheckDeptName();
			System.out.println("bo CheckDeptName end...");
			return odr;
		}

}
