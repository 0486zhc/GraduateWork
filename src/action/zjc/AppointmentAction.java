package action.zjc;

import java.util.List;

import model.Ozq.DeptDict;

import bo.IBo_zjc;
import bo.OzqBo;

public class AppointmentAction {
	private IBo_zjc bo ;
	
	List<DeptDict> depts ; 
	
	public IBo_zjc getBo() {
		return bo;
	}

	public void setBo(IBo_zjc bo) {
		this.bo = bo;
	}

	public String findDept(){
		System.out.println("findDept");
		depts = bo.getDept();
		System.out.println(depts);
		DeptDict d1 = depts.get(0);
		System.out.println(d1.getDeptName());
		DeptDict d2 = depts.get(1);
		System.out.println(d2.getDeptName());
//		OzqBo bo = new OzqBo();
//		List<String> names = bo.CheckDeptName();
//		String name = names.get(0);
//		System.out.println(name);
		return "";
	}
}
