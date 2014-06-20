package action.zjc;

import java.util.List;

import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import bo.IBo_zjc;

public class AppointmentAction {
	private IBo_zjc bo ;
	
	private List<DeptDict> depts ; 
	private DeptDict dept;
	private List<StaffDict> doctorsInfo ;
	private List<OutpDoctorRegist> outDoctor ; 
	
	private String mess ;
	private Integer deptCode ;
	private Integer doctorNo;
	
	public String findDoctors(){
		System.out.println("findDoctors");
		doctorsInfo = bo.getDoctorsInfo(deptCode);
		dept = bo.getDept(deptCode);
		System.out.println("doctors"+doctorsInfo);
		return "doctors";
	}
	
	public String findDoctorTime(){
		System.out.println("doctorNo:"+doctorNo);
		outDoctor = bo.getOutpDoctor(doctorNo);
		System.out.println("length = " + outDoctor.size());
		return "doctorTime";
	}
	
	
	public List<OutpDoctorRegist> getOutDoctor() {
		return outDoctor;
	}

	public void setOutDoctor(List<OutpDoctorRegist> outDoctor) {
		this.outDoctor = outDoctor;
	}
	
	public Integer getDoctorNo() {
		return doctorNo;
	}

	public void setDoctorNo(Integer doctorNo) {
		this.doctorNo = doctorNo;
	}

	public DeptDict getDept() {
		return dept;
	}

	public void setDept(DeptDict dept) {
		this.dept = dept;
	}

	public List<StaffDict> getDoctorsInfo() {
		return doctorsInfo;
	}

	public void setDoctorsInfo(List<StaffDict> doctorsInfo) {
		this.doctorsInfo = doctorsInfo;
	}

	public Integer getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(Integer deptCode) {
		this.deptCode = deptCode;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public List<DeptDict> getDepts() {
		return depts;
	}

	public void setDepts(List<DeptDict> depts) {
		this.depts = depts;
	}

	public IBo_zjc getBo() {
		return bo;
	}

	public void setBo(IBo_zjc bo) {
		this.bo = bo;
	}

	public String findDepts(){
		System.out.println("findDept");
		depts = bo.getDepts();
		System.out.println("depts = " + depts);
		mess = "科室";
		return "depts";
	}
	
	
}
