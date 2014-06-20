package dao;

import java.util.List;

import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;

public interface IDao_zjc
{
	String verify(String userName, String passWord);
	
	String getMaxPatientId();
	
	boolean savePatientInfo(PatMasterIndex patMasterIndex);
	
	/* 获得预约的科室  */
	List<DeptDict> getDepts();
	
	/* 获取预约的医生 */
	List<StaffDict> getDoctorsInfo(Integer deptCode);
	
	/* 根据 科室编号 找 科室 */
	DeptDict getDept(Integer deptCode);
	
	/* 根据 医生编号 找 医生 - 预约医生 */
	List<OutpDoctorRegist> getOutpDoctor(Integer doctorNo); 
}
