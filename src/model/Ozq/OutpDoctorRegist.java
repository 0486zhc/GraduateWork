package model.Ozq;

import java.sql.Timestamp;

/**
 * OutpDoctorRegist entity. @author MyEclipse Persistence Tools
 */

public class OutpDoctorRegist implements java.io.Serializable {

	// Fields

	private String doctorNo;
	private Timestamp counselDate;
	private String clinicDuration;
	private String queueName;
	private String counselNo;
	private String clinicDept;
	private String doctor;
	private String autoAssignPatient;
	private String signIndicator;
	private Timestamp signTime;
	private String leaveIndicator;
	private Timestamp leaveTime;
	private Short counseledNum;
	private String address;
	private Double maxSequence;
	private Integer nextSequence;
	private String roomCode;
	private String columnNum;
	private String stopIndicator;
	private Short counseledNow;
	private Timestamp stopTime;
	private Integer limitNum;
	private Integer limitNumApp;
	private Integer registNowed;
	private Integer registApped;
	private Short timePoint;
	private Boolean registerAppoint;
	private String modifier;
	private Timestamp lastModifyTime;
	private Boolean timePointFlag;
	private String regBeginTime;
	private String regEndTime;
	private String appType;

	// Property accessors

	public String getDoctorNo() {
		return doctorNo;
	}
	
	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}
	
	public Timestamp getCounselDate() {
		return counselDate;
	}
	
	public void setCounselDate(Timestamp counselDate) {
		this.counselDate = counselDate;
	}
	
	public String getClinicDuration() {
		return clinicDuration;
	}
	
	public void setClinicDuration(String clinicDuration) {
		this.clinicDuration = clinicDuration;
	}
	
	public String getQueueName() {
		return queueName;
	}
	
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	
	public String getCounselNo() {
		return this.counselNo;
	}

	public void setCounselNo(String counselNo) {
		this.counselNo = counselNo;
	}

	public String getClinicDept() {
		return this.clinicDept;
	}

	public void setClinicDept(String clinicDept) {
		this.clinicDept = clinicDept;
	}

	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getAutoAssignPatient() {
		return this.autoAssignPatient;
	}

	public void setAutoAssignPatient(String autoAssignPatient) {
		this.autoAssignPatient = autoAssignPatient;
	}

	public String getSignIndicator() {
		return this.signIndicator;
	}

	public void setSignIndicator(String signIndicator) {
		this.signIndicator = signIndicator;
	}

	public Timestamp getSignTime() {
		return this.signTime;
	}

	public void setSignTime(Timestamp signTime) {
		this.signTime = signTime;
	}

	public String getLeaveIndicator() {
		return this.leaveIndicator;
	}

	public void setLeaveIndicator(String leaveIndicator) {
		this.leaveIndicator = leaveIndicator;
	}

	public Timestamp getLeaveTime() {
		return this.leaveTime;
	}

	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}

	public Short getCounseledNum() {
		return this.counseledNum;
	}

	public void setCounseledNum(Short counseledNum) {
		this.counseledNum = counseledNum;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getMaxSequence() {
		return this.maxSequence;
	}

	public void setMaxSequence(Double maxSequence) {
		this.maxSequence = maxSequence;
	}

	public Integer getNextSequence() {
		return this.nextSequence;
	}

	public void setNextSequence(Integer nextSequence) {
		this.nextSequence = nextSequence;
	}

	public String getRoomCode() {
		return this.roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getColumnNum() {
		return this.columnNum;
	}

	public void setColumnNum(String columnNum) {
		this.columnNum = columnNum;
	}

	public String getStopIndicator() {
		return this.stopIndicator;
	}

	public void setStopIndicator(String stopIndicator) {
		this.stopIndicator = stopIndicator;
	}

	public Short getCounseledNow() {
		return this.counseledNow;
	}

	public void setCounseledNow(Short counseledNow) {
		this.counseledNow = counseledNow;
	}

	public Timestamp getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(Timestamp stopTime) {
		this.stopTime = stopTime;
	}

	public Integer getLimitNum() {
		return this.limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public Integer getLimitNumApp() {
		return this.limitNumApp;
	}

	public void setLimitNumApp(Integer limitNumApp) {
		this.limitNumApp = limitNumApp;
	}

	public Integer getRegistNowed() {
		return this.registNowed;
	}

	public void setRegistNowed(Integer registNowed) {
		this.registNowed = registNowed;
	}

	public Integer getRegistApped() {
		return this.registApped;
	}

	public void setRegistApped(Integer registApped) {
		this.registApped = registApped;
	}

	public Short getTimePoint() {
		return this.timePoint;
	}

	public void setTimePoint(Short timePoint) {
		this.timePoint = timePoint;
	}

	public Boolean getRegisterAppoint() {
		return this.registerAppoint;
	}

	public void setRegisterAppoint(Boolean registerAppoint) {
		this.registerAppoint = registerAppoint;
	}

	public String getModifier() {
		return this.modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Timestamp getLastModifyTime() {
		return this.lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Boolean getTimePointFlag() {
		return this.timePointFlag;
	}

	public void setTimePointFlag(Boolean timePointFlag) {
		this.timePointFlag = timePointFlag;
	}

	public String getRegBeginTime() {
		return this.regBeginTime;
	}

	public void setRegBeginTime(String regBeginTime) {
		this.regBeginTime = regBeginTime;
	}

	public String getRegEndTime() {
		return this.regEndTime;
	}

	public void setRegEndTime(String regEndTime) {
		this.regEndTime = regEndTime;
	}

	public String getAppType() {
		return this.appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

}