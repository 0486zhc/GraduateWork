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
	
	//查12天排班
	public List<OutpDoctorRegist> CheckOnDutyMany(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		List<OutpDoctorRegist> odr = OzqDao.CheckOnDutyMany(clinic_dept, doctor_no);
		System.out.println(odr.get(0) instanceof OutpDoctorRegist);
		for (int i = 0; i < odr.size(); i++) {
			if(odr.get(i).getLimitNumApp() == odr.get(i).getRegistApped())
			{
				odr.remove(i);
			}
		
		}
		return odr;
	}

	//查Today排班
	public OutpDoctorRegist CheckOnDutyToday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return  OzqDao.CheckOnDutyToday(clinic_dept, doctor_no);
	}
	
	//查Twoday排班
	public OutpDoctorRegist CheckOnDutyTwoday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyTwoday(clinic_dept, doctor_no);
	}
	
	//查Threeday排班
	public OutpDoctorRegist CheckOnDutyThreeday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyThreeday(clinic_dept, doctor_no);
	}
	
	//查Fourday排班
	public OutpDoctorRegist CheckOnDutyFourday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyFourday(clinic_dept, doctor_no);
	}
	
	//查Fiveday排班
	public OutpDoctorRegist CheckOnDutyFiveday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyFiveday(clinic_dept, doctor_no);
	}
	
	//查Sixday排班
	public OutpDoctorRegist CheckOnDutySixday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutySixday(clinic_dept, doctor_no);
	}
	
	//查Sevenday排班
	public OutpDoctorRegist CheckOnDutySevenday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutySevenday(clinic_dept, doctor_no);
	}
	
	//查Eightday排班
	public OutpDoctorRegist CheckOnDutyEightday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyEightday(clinic_dept, doctor_no);
	}
	
	//查Nineday排班
	public OutpDoctorRegist CheckOnDutyNineday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyNineday(clinic_dept, doctor_no);
	}
	
	//查Tenday排班
	public OutpDoctorRegist CheckOnDutyTenday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyTenday(clinic_dept, doctor_no);
	}
	
	//查Elevenday排班
	public OutpDoctorRegist CheckOnDutyElevenday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyElevenday(clinic_dept, doctor_no);
	}
	
	//查Twelveday排班
	public OutpDoctorRegist CheckOnDutyTwelveday(String clinic_dept, String doctor_no) {
		System.out.println("bo CheckOnDuty begin...");
		return OzqDao.CheckOnDutyTwelveday(clinic_dept, doctor_no);
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
