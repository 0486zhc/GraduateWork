package bo;

import java.util.List;

import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;

public interface IBo_zjc
{
	String verify(String userName, String passWord);
	
	String addRegister(PatMasterIndex patMasterIndex);
	
	/* 获得预约的科室  */
	List<DeptDict> getDepts();
	
	/* 获取预约的医生 */
	List<StaffDict> getDoctorsInfo(Integer deptCode);
	
	DeptDict getDept(Integer deptCode);
	
	List<OutpDoctorRegist> getOutpDoctor(Integer doctorNo); 
}
