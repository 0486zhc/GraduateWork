package bo.impl;

import java.util.List;

import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;
import bo.IBo_zjc;
import dao.IDao_zjc;

public class ImplBo_zjc implements IBo_zjc{

	private IDao_zjc dao ;
	
	public IDao_zjc getDao() {
		return dao;
	}

	public void setDao(IDao_zjc dao) {
		this.dao = dao;
	}


	@Override
	public String verify(String userName, String passWord) {
		String patName = dao.verify(userName, passWord);
		return patName;
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
		return dao.getOutpDoctor(doctorNo);
	}
}
