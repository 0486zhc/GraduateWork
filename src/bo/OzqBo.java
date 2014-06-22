package bo;

import java.sql.Timestamp;
import java.util.List;

import dao.OzqDao;

public class OzqBo{

private OzqDao OzqDao;
	
	public OzqDao getOzqDao() {
		return OzqDao;
	}
	public void setOzqDao(OzqDao OzqDao) {
		this.OzqDao = OzqDao;
	}
	
//	//查12天排班
//	public List<Object[]> CheckOnDutyMany(String clinic_dept, String doctor_no) {
//		System.out.println("bo CheckOnDuty begin...");
//		List<Object[]> odr = OzqDao.CheckOnDutyMany(clinic_dept, doctor_no);
//		System.out.println(odr instanceof Object);
////		for (int i = 0; i < odr.size(); i++) {
////				if(odr.get(i).getLimitNumApp() == odr.get(i).getRegistApped())
////				{
////					odr.remove(i);
////				}
////		
////		}
//		return odr;
//	}

	//查Today排班
	public List<Object[]> CheckOnDutyToday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return  OzqDao.CheckOnDutyToday(clinic_dept, doctor_no);
	}
	
	//查Twoday排班
	public List<Object[]> CheckOnDutyTwoday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyTwoday(clinic_dept, doctor_no);
	}
	
	//查Threeday排班
	public List<Object[]> CheckOnDutyThreeday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyThreeday(clinic_dept, doctor_no);
	}
	
	//查Fourday排班
	public List<Object[]> CheckOnDutyFourday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyFourday(clinic_dept, doctor_no);
	}
	
	//查Fiveday排班
	public List<Object[]> CheckOnDutyFiveday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyFiveday(clinic_dept, doctor_no);
	}
	
	//查Sixday排班
	public List<Object[]> CheckOnDutySixday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutySixday(clinic_dept, doctor_no);
	}
	
	//查Sevenday排班
	public List<Object[]> CheckOnDutySevenday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutySevenday(clinic_dept, doctor_no);
	}
	
	//查医生姓名
	public List<Object[]> CheckDoctorName(String deptname) {
		System.out.println("bo...");
		List<Object[]> odr = OzqDao.CheckDoctorName(deptname);
		System.out.println("bo CheckDoctorName end...");
		return odr;
	}
	
	//查每个时间点
		public List<Object[]> CheckRegistTime(String doctor_no, String counsel_date, String clinic_duration, String queue_name){
			System.out.println("bo CheckRegistTime begin...");
			return OzqDao.CheckRegistTime(doctor_no, counsel_date, clinic_duration, queue_name);
		}
	
	//查诊室代号 & 医生工号
			public List<Object[]> CheckClinicDeptDoctorNo(String doctor_name) {
				System.out.println("bo...");
				
			    return OzqDao.CheckClinicDeptDoctorNo(doctor_name);
			}
		
	//查时间
		public List<Timestamp> CheckDate(String date){
			System.out.println("bo...");
			List<Timestamp> da = OzqDao.CheckDate(date);
			System.out.println("bo CheckDate end2...");
			return da;
		}

}
