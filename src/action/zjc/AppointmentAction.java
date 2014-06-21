package action.zjc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Ozq.ClinicAppoints;
import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;
import bo.IBo_zjc;

public class AppointmentAction extends ActionSupport{
	private IBo_zjc bo ;
	
	private List<DeptDict> depts ; 
	private DeptDict dept;
	private List<StaffDict> doctorsInfo ;
	private List<OutpDoctorRegist> outDoctors ; 
	private List<ClinicAppoints> appointsList;
	private ClinicAppoints appoint;
	private PatMasterIndex pat ;
	
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
	
	public String checkAppoints(){
		System.out.println("checkAppointment");
		 pat = (PatMasterIndex) ActionContext.getContext().getSession().get("pat");
		if(pat != null){
			appointsList = bo.getAppoints(pat);
			
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("appointsList", "appointsList");
			
			// 医生名称
			System.out.println("appointsList"+appointsList);
			return "appoints";
		}else{
			return "login";
		} 
	}
	
	// 排班
	public String findDoctorTime(){
		System.out.println("doctorNo:"+doctorNo);
//		outDoctors = bo.getOutpDoctor(doctorNo);
//		System.out.println("length = " + outDoctors.size());
		return "doctorTime";
	}
	
	// 取消预约
	public String cancle(){
		System.out.println("cancle");
//		?appoint=<s:property value="#str"/>
		
		HttpServletRequest request = ServletActionContext.getRequest();
		appointsList = (List<ClinicAppoints>) request.getAttribute("appointsList");
		
		System.out.println(appoint);
		System.out.println(appointsList);
		return "success";
	}
	
/*  ==================== get/set 方法=======================================	*/
	
	public List<OutpDoctorRegist> getOutDoctors() {
		return outDoctors;
	}

	public ClinicAppoints getAppoint() {
		return appoint;
	}

	public void setAppoint(ClinicAppoints appoint) {
		this.appoint = appoint;
	}

	public PatMasterIndex getPat() {
		return pat;
	}

	public void setPat(PatMasterIndex pat) {
		this.pat = pat;
	}

	public List<ClinicAppoints> getAppointsList() {
		return appointsList;
	}

	public void setAppointsList(List<ClinicAppoints> appointsList) {
		this.appointsList = appointsList;
	}

	public void setOutDoctors(List<OutpDoctorRegist> outDoctors) {
		this.outDoctors = outDoctors;
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
