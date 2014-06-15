package model.zjc;

import java.util.Date;

/**
 * PatMasterIndex entity. @author MyEclipse Persistence Tools
 */

public class PatMasterIndex implements java.io.Serializable {

	// Fields

	private String patientId;
	private String inpNo;
	private String name;
	private String namePhonetic;
	private String sex;
	private Date dateOfBirth;
	private String birthPlace;
	private String citizenship;
	private String nation;
	private String idNo;
	private String identity;
	private String chargeType;
	private String unitInContract;
	private String mailingAddress;
	private String zipCode;
	private String phoneNumberHome;
	private String phoneNumberBusiness;
	private String nextOfKin;
	private String relationship;
	private String nextOfKinAddr;
	private String nextOfKinZipCode;
	private String nextOfKinPhone;
	private Date lastVisitDate;
	private boolean vipIndicator;
	private Date createDate;
	private String operator;
	private String serviceAgency;
	private String businessZipCode;
	private String photo;
	private String patientClass;
	private String degree;
	private String race;
	private String religion;
	private String motherLanguage;
	private String foreignLanguage;
	private String idType;
	private String vipNo;
	private String EName;
	private String occupation;
	private String nextOfSex;
	private Date nextOfBath;
	private String nextOfId;
	private String nativePlace;
	private String mailingAddressCode;
	private String healthyCardNo;
	private String gfFlag;
	private String gfGyzh;
	private String ybYbzh;
	private String nowAddr;
	private String nowZipCode;
	private String zgBh;
	private String zgZzFlag;
	private String gfDwdm;
	private String mailingStreetCode;
	private String parentName;
	private String parentPatientId;
	private String patName2;
	private double tz;
	private String mailingAddrAreaCode;
	private String mailingAddrStreetNo;
	private String regResidenceAreaCode;
	private String regResidence;
	private String regResidenceStreetNo;
	private String regResidenceZipCode;
	private String unitName;
	private String unitAddrAreaCode;
	private String unitAddress;
	private String unitAddrStreetNo;
	private String unitAddrZipCode;
	private String password;

	// Constructors

	/** default constructor */
	public PatMasterIndex() {
	}

	/** full constructor */
	public PatMasterIndex(String inpNo, String name, String namePhonetic,
			String sex, Date dateOfBirth, String birthPlace,
			String citizenship, String nation, String idNo, String identity,
			String chargeType, String unitInContract, String mailingAddress,
			String zipCode, String phoneNumberHome, String phoneNumberBusiness,
			String nextOfKin, String relationship, String nextOfKinAddr,
			String nextOfKinZipCode, String nextOfKinPhone, Date lastVisitDate,
			boolean vipIndicator, Date createDate, String operator,
			String serviceAgency, String businessZipCode, String photo,
			String patientClass, String degree, String race, String religion,
			String motherLanguage, String foreignLanguage, String idType,
			String vipNo, String EName, String occupation, String nextOfSex,
			Date nextOfBath, String nextOfId, String nativePlace,
			String mailingAddressCode, String healthyCardNo, String gfFlag,
			String gfGyzh, String ybYbzh, String nowAddr, String nowZipCode,
			String zgBh, String zgZzFlag, String gfDwdm,
			String mailingStreetCode, String parentName,
			String parentPatientId, String patName2, double tz,
			String mailingAddrAreaCode, String mailingAddrStreetNo,
			String regResidenceAreaCode, String regResidence,
			String regResidenceStreetNo, String regResidenceZipCode,
			String unitName, String unitAddrAreaCode, String unitAddress,
			String unitAddrStreetNo, String unitAddrZipCode, String password) {
		this.inpNo = inpNo;
		this.name = name;
		this.namePhonetic = namePhonetic;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.birthPlace = birthPlace;
		this.citizenship = citizenship;
		this.nation = nation;
		this.idNo = idNo;
		this.identity = identity;
		this.chargeType = chargeType;
		this.unitInContract = unitInContract;
		this.mailingAddress = mailingAddress;
		this.zipCode = zipCode;
		this.phoneNumberHome = phoneNumberHome;
		this.phoneNumberBusiness = phoneNumberBusiness;
		this.nextOfKin = nextOfKin;
		this.relationship = relationship;
		this.nextOfKinAddr = nextOfKinAddr;
		this.nextOfKinZipCode = nextOfKinZipCode;
		this.nextOfKinPhone = nextOfKinPhone;
		this.lastVisitDate = lastVisitDate;
		this.vipIndicator = vipIndicator;
		this.createDate = createDate;
		this.operator = operator;
		this.serviceAgency = serviceAgency;
		this.businessZipCode = businessZipCode;
		this.photo = photo;
		this.patientClass = patientClass;
		this.degree = degree;
		this.race = race;
		this.religion = religion;
		this.motherLanguage = motherLanguage;
		this.foreignLanguage = foreignLanguage;
		this.idType = idType;
		this.vipNo = vipNo;
		this.EName = EName;
		this.occupation = occupation;
		this.nextOfSex = nextOfSex;
		this.nextOfBath = nextOfBath;
		this.nextOfId = nextOfId;
		this.nativePlace = nativePlace;
		this.mailingAddressCode = mailingAddressCode;
		this.healthyCardNo = healthyCardNo;
		this.gfFlag = gfFlag;
		this.gfGyzh = gfGyzh;
		this.ybYbzh = ybYbzh;
		this.nowAddr = nowAddr;
		this.nowZipCode = nowZipCode;
		this.zgBh = zgBh;
		this.zgZzFlag = zgZzFlag;
		this.gfDwdm = gfDwdm;
		this.mailingStreetCode = mailingStreetCode;
		this.parentName = parentName;
		this.parentPatientId = parentPatientId;
		this.patName2 = patName2;
		this.tz = tz;
		this.mailingAddrAreaCode = mailingAddrAreaCode;
		this.mailingAddrStreetNo = mailingAddrStreetNo;
		this.regResidenceAreaCode = regResidenceAreaCode;
		this.regResidence = regResidence;
		this.regResidenceStreetNo = regResidenceStreetNo;
		this.regResidenceZipCode = regResidenceZipCode;
		this.unitName = unitName;
		this.unitAddrAreaCode = unitAddrAreaCode;
		this.unitAddress = unitAddress;
		this.unitAddrStreetNo = unitAddrStreetNo;
		this.unitAddrZipCode = unitAddrZipCode;
		this.password = password;
	}

	// Property accessors

	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getInpNo() {
		return this.inpNo;
	}

	public void setInpNo(String inpNo) {
		this.inpNo = inpNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamePhonetic() {
		return this.namePhonetic;
	}

	public void setNamePhonetic(String namePhonetic) {
		this.namePhonetic = namePhonetic;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getCitizenship() {
		return this.citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdentity() {
		return this.identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getChargeType() {
		return this.chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getUnitInContract() {
		return this.unitInContract;
	}

	public void setUnitInContract(String unitInContract) {
		this.unitInContract = unitInContract;
	}

	public String getMailingAddress() {
		return this.mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumberHome() {
		return this.phoneNumberHome;
	}

	public void setPhoneNumberHome(String phoneNumberHome) {
		this.phoneNumberHome = phoneNumberHome;
	}

	public String getPhoneNumberBusiness() {
		return this.phoneNumberBusiness;
	}

	public void setPhoneNumberBusiness(String phoneNumberBusiness) {
		this.phoneNumberBusiness = phoneNumberBusiness;
	}

	public String getNextOfKin() {
		return this.nextOfKin;
	}

	public void setNextOfKin(String nextOfKin) {
		this.nextOfKin = nextOfKin;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getNextOfKinAddr() {
		return this.nextOfKinAddr;
	}

	public void setNextOfKinAddr(String nextOfKinAddr) {
		this.nextOfKinAddr = nextOfKinAddr;
	}

	public String getNextOfKinZipCode() {
		return this.nextOfKinZipCode;
	}

	public void setNextOfKinZipCode(String nextOfKinZipCode) {
		this.nextOfKinZipCode = nextOfKinZipCode;
	}

	public String getNextOfKinPhone() {
		return this.nextOfKinPhone;
	}

	public void setNextOfKinPhone(String nextOfKinPhone) {
		this.nextOfKinPhone = nextOfKinPhone;
	}

	public Date getLastVisitDate() {
		return this.lastVisitDate;
	}

	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}

	public boolean getVipIndicator() {
		return this.vipIndicator;
	}

	public void setVipIndicator(boolean vipIndicator) {
		this.vipIndicator = vipIndicator;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getServiceAgency() {
		return this.serviceAgency;
	}

	public void setServiceAgency(String serviceAgency) {
		this.serviceAgency = serviceAgency;
	}

	public String getBusinessZipCode() {
		return this.businessZipCode;
	}

	public void setBusinessZipCode(String businessZipCode) {
		this.businessZipCode = businessZipCode;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPatientClass() {
		return this.patientClass;
	}

	public void setPatientClass(String patientClass) {
		this.patientClass = patientClass;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getMotherLanguage() {
		return this.motherLanguage;
	}

	public void setMotherLanguage(String motherLanguage) {
		this.motherLanguage = motherLanguage;
	}

	public String getForeignLanguage() {
		return this.foreignLanguage;
	}

	public void setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getVipNo() {
		return this.vipNo;
	}

	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
	}

	public String getEName() {
		return this.EName;
	}

	public void setEName(String EName) {
		this.EName = EName;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNextOfSex() {
		return this.nextOfSex;
	}

	public void setNextOfSex(String nextOfSex) {
		this.nextOfSex = nextOfSex;
	}

	public Date getNextOfBath() {
		return this.nextOfBath;
	}

	public void setNextOfBath(Date nextOfBath) {
		this.nextOfBath = nextOfBath;
	}

	public String getNextOfId() {
		return this.nextOfId;
	}

	public void setNextOfId(String nextOfId) {
		this.nextOfId = nextOfId;
	}

	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getMailingAddressCode() {
		return this.mailingAddressCode;
	}

	public void setMailingAddressCode(String mailingAddressCode) {
		this.mailingAddressCode = mailingAddressCode;
	}

	public String getHealthyCardNo() {
		return this.healthyCardNo;
	}

	public void setHealthyCardNo(String healthyCardNo) {
		this.healthyCardNo = healthyCardNo;
	}

	public String getGfFlag() {
		return this.gfFlag;
	}

	public void setGfFlag(String gfFlag) {
		this.gfFlag = gfFlag;
	}

	public String getGfGyzh() {
		return this.gfGyzh;
	}

	public void setGfGyzh(String gfGyzh) {
		this.gfGyzh = gfGyzh;
	}

	public String getYbYbzh() {
		return this.ybYbzh;
	}

	public void setYbYbzh(String ybYbzh) {
		this.ybYbzh = ybYbzh;
	}

	public String getNowAddr() {
		return this.nowAddr;
	}

	public void setNowAddr(String nowAddr) {
		this.nowAddr = nowAddr;
	}

	public String getNowZipCode() {
		return this.nowZipCode;
	}

	public void setNowZipCode(String nowZipCode) {
		this.nowZipCode = nowZipCode;
	}

	public String getZgBh() {
		return this.zgBh;
	}

	public void setZgBh(String zgBh) {
		this.zgBh = zgBh;
	}

	public String getZgZzFlag() {
		return this.zgZzFlag;
	}

	public void setZgZzFlag(String zgZzFlag) {
		this.zgZzFlag = zgZzFlag;
	}

	public String getGfDwdm() {
		return this.gfDwdm;
	}

	public void setGfDwdm(String gfDwdm) {
		this.gfDwdm = gfDwdm;
	}

	public String getMailingStreetCode() {
		return this.mailingStreetCode;
	}

	public void setMailingStreetCode(String mailingStreetCode) {
		this.mailingStreetCode = mailingStreetCode;
	}

	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentPatientId() {
		return this.parentPatientId;
	}

	public void setParentPatientId(String parentPatientId) {
		this.parentPatientId = parentPatientId;
	}

	public String getPatName2() {
		return this.patName2;
	}

	public void setPatName2(String patName2) {
		this.patName2 = patName2;
	}

	public double getTz() {
		return this.tz;
	}

	public void setTz(double tz) {
		this.tz = tz;
	}

	public String getMailingAddrAreaCode() {
		return this.mailingAddrAreaCode;
	}

	public void setMailingAddrAreaCode(String mailingAddrAreaCode) {
		this.mailingAddrAreaCode = mailingAddrAreaCode;
	}

	public String getMailingAddrStreetNo() {
		return this.mailingAddrStreetNo;
	}

	public void setMailingAddrStreetNo(String mailingAddrStreetNo) {
		this.mailingAddrStreetNo = mailingAddrStreetNo;
	}

	public String getRegResidenceAreaCode() {
		return this.regResidenceAreaCode;
	}

	public void setRegResidenceAreaCode(String regResidenceAreaCode) {
		this.regResidenceAreaCode = regResidenceAreaCode;
	}

	public String getRegResidence() {
		return this.regResidence;
	}

	public void setRegResidence(String regResidence) {
		this.regResidence = regResidence;
	}

	public String getRegResidenceStreetNo() {
		return this.regResidenceStreetNo;
	}

	public void setRegResidenceStreetNo(String regResidenceStreetNo) {
		this.regResidenceStreetNo = regResidenceStreetNo;
	}

	public String getRegResidenceZipCode() {
		return this.regResidenceZipCode;
	}

	public void setRegResidenceZipCode(String regResidenceZipCode) {
		this.regResidenceZipCode = regResidenceZipCode;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitAddrAreaCode() {
		return this.unitAddrAreaCode;
	}

	public void setUnitAddrAreaCode(String unitAddrAreaCode) {
		this.unitAddrAreaCode = unitAddrAreaCode;
	}

	public String getUnitAddress() {
		return this.unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	public String getUnitAddrStreetNo() {
		return this.unitAddrStreetNo;
	}

	public void setUnitAddrStreetNo(String unitAddrStreetNo) {
		this.unitAddrStreetNo = unitAddrStreetNo;
	}

	public String getUnitAddrZipCode() {
		return this.unitAddrZipCode;
	}

	public void setUnitAddrZipCode(String unitAddrZipCode) {
		this.unitAddrZipCode = unitAddrZipCode;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}