package dao;

import java.util.List;

import model.Ozq.DeptDict2;
import model.Ozq.OutpDoctorRegist;
import model.lhb.PatMasterIndex;

public interface IDao_zjc
{
	String verify(String userName, String passWord);
	
	String getMaxPatientId();
	
	boolean savePatientInfo(PatMasterIndex patMasterIndex);
	
	/* 获得预约的科室  */
	List<DeptDict2> getDept();
	
	/* 获取预约的医生 */
	List<OutpDoctorRegist> getDoctor();
	
	
}
