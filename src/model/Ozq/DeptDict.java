package model.Ozq;

/**
 * DeptDictId entity. @author MyEclipse Persistence Tools
 */

public class DeptDict implements java.io.Serializable {

	// Fields
	private int id;
	private Short serialNo;
	private String deptCode;
	private String deptName;
	private String deptAlias;
	private Boolean clinicAttr;
	private Boolean outpOrInp;
	private Boolean internalOrSergery;
	private String inputCode;
	private String position;
	private String sign;
	private String inputCodeWb;
	private Boolean virtualCabinet;
	private Boolean dispensingCumulate;
	private Short orderCode;
	private String outType;
	private Short quotaSet;
	private String area;
	private String deptNamebak;
	private String upId;
	private String branchCode;
	private String bigDeptCode;
	private String areaInDept;
	private String statDeptCode;
	private Integer regSeqNo;
	private Boolean deptFlag;
	private String deptDesc;

	// Property accessors
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Short getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(Short serialNo) {
		this.serialNo = serialNo;
	}

	public String getDeptCode() {
		return this.deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptAlias() {
		return this.deptAlias;
	}

	public void setDeptAlias(String deptAlias) {
		this.deptAlias = deptAlias;
	}

	public Boolean getClinicAttr() {
		return this.clinicAttr;
	}

	public void setClinicAttr(Boolean clinicAttr) {
		this.clinicAttr = clinicAttr;
	}

	public Boolean getOutpOrInp() {
		return this.outpOrInp;
	}

	public void setOutpOrInp(Boolean outpOrInp) {
		this.outpOrInp = outpOrInp;
	}

	public Boolean getInternalOrSergery() {
		return this.internalOrSergery;
	}

	public void setInternalOrSergery(Boolean internalOrSergery) {
		this.internalOrSergery = internalOrSergery;
	}

	public String getInputCode() {
		return this.inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getInputCodeWb() {
		return this.inputCodeWb;
	}

	public void setInputCodeWb(String inputCodeWb) {
		this.inputCodeWb = inputCodeWb;
	}

	public Boolean getVirtualCabinet() {
		return this.virtualCabinet;
	}

	public void setVirtualCabinet(Boolean virtualCabinet) {
		this.virtualCabinet = virtualCabinet;
	}

	public Boolean getDispensingCumulate() {
		return this.dispensingCumulate;
	}

	public void setDispensingCumulate(Boolean dispensingCumulate) {
		this.dispensingCumulate = dispensingCumulate;
	}

	public Short getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(Short orderCode) {
		this.orderCode = orderCode;
	}

	public String getOutType() {
		return this.outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}

	public Short getQuotaSet() {
		return this.quotaSet;
	}

	public void setQuotaSet(Short quotaSet) {
		this.quotaSet = quotaSet;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDeptNamebak() {
		return this.deptNamebak;
	}

	public void setDeptNamebak(String deptNamebak) {
		this.deptNamebak = deptNamebak;
	}

	public String getUpId() {
		return this.upId;
	}

	public void setUpId(String upId) {
		this.upId = upId;
	}

	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBigDeptCode() {
		return this.bigDeptCode;
	}

	public void setBigDeptCode(String bigDeptCode) {
		this.bigDeptCode = bigDeptCode;
	}

	public String getAreaInDept() {
		return this.areaInDept;
	}

	public void setAreaInDept(String areaInDept) {
		this.areaInDept = areaInDept;
	}

	public String getStatDeptCode() {
		return this.statDeptCode;
	}

	public void setStatDeptCode(String statDeptCode) {
		this.statDeptCode = statDeptCode;
	}

	public Integer getRegSeqNo() {
		return this.regSeqNo;
	}

	public void setRegSeqNo(Integer regSeqNo) {
		this.regSeqNo = regSeqNo;
	}

	public Boolean getDeptFlag() {
		return this.deptFlag;
	}

	public void setDeptFlag(Boolean deptFlag) {
		this.deptFlag = deptFlag;
	}

	public String getDeptDesc() {
		return this.deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSerialNo() == null ? 0 : this.getSerialNo().hashCode());
		result = 37 * result
				+ (getDeptCode() == null ? 0 : this.getDeptCode().hashCode());
		result = 37 * result
				+ (getDeptName() == null ? 0 : this.getDeptName().hashCode());
		result = 37 * result
				+ (getDeptAlias() == null ? 0 : this.getDeptAlias().hashCode());
		result = 37
				* result
				+ (getClinicAttr() == null ? 0 : this.getClinicAttr()
						.hashCode());
		result = 37 * result
				+ (getOutpOrInp() == null ? 0 : this.getOutpOrInp().hashCode());
		result = 37
				* result
				+ (getInternalOrSergery() == null ? 0 : this
						.getInternalOrSergery().hashCode());
		result = 37 * result
				+ (getInputCode() == null ? 0 : this.getInputCode().hashCode());
		result = 37 * result
				+ (getPosition() == null ? 0 : this.getPosition().hashCode());
		result = 37 * result
				+ (getSign() == null ? 0 : this.getSign().hashCode());
		result = 37
				* result
				+ (getInputCodeWb() == null ? 0 : this.getInputCodeWb()
						.hashCode());
		result = 37
				* result
				+ (getVirtualCabinet() == null ? 0 : this.getVirtualCabinet()
						.hashCode());
		result = 37
				* result
				+ (getDispensingCumulate() == null ? 0 : this
						.getDispensingCumulate().hashCode());
		result = 37 * result
				+ (getOrderCode() == null ? 0 : this.getOrderCode().hashCode());
		result = 37 * result
				+ (getOutType() == null ? 0 : this.getOutType().hashCode());
		result = 37 * result
				+ (getQuotaSet() == null ? 0 : this.getQuotaSet().hashCode());
		result = 37 * result
				+ (getArea() == null ? 0 : this.getArea().hashCode());
		result = 37
				* result
				+ (getDeptNamebak() == null ? 0 : this.getDeptNamebak()
						.hashCode());
		result = 37 * result
				+ (getUpId() == null ? 0 : this.getUpId().hashCode());
		result = 37
				* result
				+ (getBranchCode() == null ? 0 : this.getBranchCode()
						.hashCode());
		result = 37
				* result
				+ (getBigDeptCode() == null ? 0 : this.getBigDeptCode()
						.hashCode());
		result = 37
				* result
				+ (getAreaInDept() == null ? 0 : this.getAreaInDept()
						.hashCode());
		result = 37
				* result
				+ (getStatDeptCode() == null ? 0 : this.getStatDeptCode()
						.hashCode());
		result = 37 * result
				+ (getRegSeqNo() == null ? 0 : this.getRegSeqNo().hashCode());
		result = 37 * result
				+ (getDeptFlag() == null ? 0 : this.getDeptFlag().hashCode());
		result = 37 * result
				+ (getDeptDesc() == null ? 0 : this.getDeptDesc().hashCode());
		return result;
	}

}