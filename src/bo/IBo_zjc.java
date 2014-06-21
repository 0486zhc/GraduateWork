package bo;

import java.util.List;

import model.Ozq.ClinicAppoints;
import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;
import model.zjc.MessageBox;

public interface IBo_zjc
{
	PatMasterIndex verify(String userName, String passWord);
	
	String addRegister(PatMasterIndex patMasterIndex);
	
	/* 获得预约的科室  */
	List<DeptDict> getDepts();
	
	/* 获取预约的医生 */
	List<StaffDict> getDoctorsInfo(Integer deptCode);
	
	StaffDict getDoctor(Integer doctorNO);
	
	DeptDict getDept(Integer deptCode);
	
	List<OutpDoctorRegist> getOutpDoctor(Integer doctorNo);

	List<ClinicAppoints> getAppoints(PatMasterIndex pat);

	String addAdvice(MessageBox advice);

	String modifyAppoint(ClinicAppoints appoint); 
}
