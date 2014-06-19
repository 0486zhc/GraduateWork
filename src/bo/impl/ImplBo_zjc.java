package bo.impl;

import java.util.List;

import dao.IDao_zjc;
import model.Ozq.DeptDict2;
import model.Ozq.OutpDoctorRegist;
import model.lhb.PatMasterIndex;
import bo.IBo_zjc;

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
	public List<DeptDict2> getDept() {
		System.out.println("getDept");
		return dao.getDept();
	}

	@Override
	public List<OutpDoctorRegist> getDoctor() {
		return dao.getDoctor();
	}
}
