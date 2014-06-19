package bo;

import java.util.List;

import model.Ozq.DeptDict2;
import model.Ozq.OutpDoctorRegist;
import model.lhb.PatMasterIndex;

public interface IBo_zjc
{
	String verify(String userName, String passWord);
	
	String addRegister(PatMasterIndex patMasterIndex);
	
	/* 获得预约的科室  */
	List<DeptDict2> getDept();
	
	/* 获取预约的医生 */
	List<OutpDoctorRegist> getDoctor();
}
