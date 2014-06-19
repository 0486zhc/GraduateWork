package model.lhb;

import java.util.Date;

/**
 * ClinicAppoints entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class ClinicAppoints implements java.io.Serializable
{

   // Fields

   
   private Date   visitDateAppted;
   private String clinicLabel;
   private String visitTimeAppted;
   private short  serialNo;
   private String regTimePoint;
   private String preRegistDoctor;
   private String registStatus;
   private String           patientId;
   private Date             apptMadeDate;
   private String           modeCode;
   private String           cardName;
   private String           cardNo;
   private String           name;
   private String           sex;
   private long             age;
   private String           identity;
   private String           chargeType;
   private String           insuranceNo;
   private String           insuranceType;
   private String           unitInContract;
   private String           namePhonetic;
   private String           operator;
   private String           cancelResean;
   private String           phoneNo;
   private Date             cancelDate;
   private String           cancelOperator;
   private short            appointNo;
   private String           registFlag;
   private Date             dateOfBirth;
   private String           mailingAddrAreaCode;
   private String           mailingAddrStreetNo;
   private Date             phoneNumberHome;

   // Constructors

   /** default constructor */
   public ClinicAppoints()
   {
   }

   /** minimal constructor */




   // Property accessors

   

   public String getPatientId()
   {
      return this.patientId;
   }

   public ClinicAppoints(Date visitDateAppted, String clinicLabel,
         String visitTimeAppted, short serialNo, String regTimePoint,
         String preRegistDoctor, String registStatus, String patientId,
         Date apptMadeDate, String modeCode, String cardName, String cardNo,
         String name, String sex, long age, String identity, String chargeType,
         String insuranceNo, String insuranceType, String unitInContract,
         String namePhonetic, String operator, String cancelResean,
         String phoneNo, Date cancelDate, String cancelOperator,
         short appointNo, String registFlag, Date dateOfBirth,
         String mailingAddrAreaCode, String mailingAddrStreetNo,
         Date phoneNumberHome)
   {
      super();
      this.visitDateAppted = visitDateAppted;
      this.clinicLabel = clinicLabel;
      this.visitTimeAppted = visitTimeAppted;
      this.serialNo = serialNo;
      this.regTimePoint = regTimePoint;
      this.preRegistDoctor = preRegistDoctor;
      this.registStatus = registStatus;
      this.patientId = patientId;
      this.apptMadeDate = apptMadeDate;
      this.modeCode = modeCode;
      this.cardName = cardName;
      this.cardNo = cardNo;
      this.name = name;
      this.sex = sex;
      this.age = age;
      this.identity = identity;
      this.chargeType = chargeType;
      this.insuranceNo = insuranceNo;
      this.insuranceType = insuranceType;
      this.unitInContract = unitInContract;
      this.namePhonetic = namePhonetic;
      this.operator = operator;
      this.cancelResean = cancelResean;
      this.phoneNo = phoneNo;
      this.cancelDate = cancelDate;
      this.cancelOperator = cancelOperator;
      this.appointNo = appointNo;
      this.registFlag = registFlag;
      this.dateOfBirth = dateOfBirth;
      this.mailingAddrAreaCode = mailingAddrAreaCode;
      this.mailingAddrStreetNo = mailingAddrStreetNo;
      this.phoneNumberHome = phoneNumberHome;
   }

   public Date getVisitDateAppted()
   {
      return visitDateAppted;
   }

   public void setVisitDateAppted(Date visitDateAppted)
   {
      this.visitDateAppted = visitDateAppted;
   }

   public String getClinicLabel()
   {
      return clinicLabel;
   }

   public void setClinicLabel(String clinicLabel)
   {
      this.clinicLabel = clinicLabel;
   }

   public String getVisitTimeAppted()
   {
      return visitTimeAppted;
   }

   public void setVisitTimeAppted(String visitTimeAppted)
   {
      this.visitTimeAppted = visitTimeAppted;
   }

   public short getSerialNo()
   {
      return serialNo;
   }

   public void setSerialNo(short serialNo)
   {
      this.serialNo = serialNo;
   }

   public String getRegTimePoint()
   {
      return regTimePoint;
   }

   public void setRegTimePoint(String regTimePoint)
   {
      this.regTimePoint = regTimePoint;
   }

   public String getPreRegistDoctor()
   {
      return preRegistDoctor;
   }

   public void setPreRegistDoctor(String preRegistDoctor)
   {
      this.preRegistDoctor = preRegistDoctor;
   }

   public String getRegistStatus()
   {
      return registStatus;
   }

   public void setRegistStatus(String registStatus)
   {
      this.registStatus = registStatus;
   }

   public void setPatientId(String patientId)
   {
      this.patientId = patientId;
   }

   public Date getApptMadeDate()
   {
      return this.apptMadeDate;
   }

   public void setApptMadeDate(Date apptMadeDate)
   {
      this.apptMadeDate = apptMadeDate;
   }

   public String getModeCode()
   {
      return this.modeCode;
   }

   public void setModeCode(String modeCode)
   {
      this.modeCode = modeCode;
   }

   public String getCardName()
   {
      return this.cardName;
   }

   public void setCardName(String cardName)
   {
      this.cardName = cardName;
   }

   public String getCardNo()
   {
      return this.cardNo;
   }

   public void setCardNo(String cardNo)
   {
      this.cardNo = cardNo;
   }

   public String getName()
   {
      return this.name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getSex()
   {
      return this.sex;
   }

   public void setSex(String sex)
   {
      this.sex = sex;
   }

   public long getAge()
   {
      return this.age;
   }

   public void setAge(long age)
   {
      this.age = age;
   }

   public String getIdentity()
   {
      return this.identity;
   }

   public void setIdentity(String identity)
   {
      this.identity = identity;
   }

   public String getChargeType()
   {
      return this.chargeType;
   }

   public void setChargeType(String chargeType)
   {
      this.chargeType = chargeType;
   }

   public String getInsuranceNo()
   {
      return this.insuranceNo;
   }

   public void setInsuranceNo(String insuranceNo)
   {
      this.insuranceNo = insuranceNo;
   }

   public String getInsuranceType()
   {
      return this.insuranceType;
   }

   public void setInsuranceType(String insuranceType)
   {
      this.insuranceType = insuranceType;
   }

   public String getUnitInContract()
   {
      return this.unitInContract;
   }

   public void setUnitInContract(String unitInContract)
   {
      this.unitInContract = unitInContract;
   }

   public String getNamePhonetic()
   {
      return this.namePhonetic;
   }

   public void setNamePhonetic(String namePhonetic)
   {
      this.namePhonetic = namePhonetic;
   }

   public String getOperator()
   {
      return this.operator;
   }

   public void setOperator(String operator)
   {
      this.operator = operator;
   }

   public String getCancelResean()
   {
      return this.cancelResean;
   }

   public void setCancelResean(String cancelResean)
   {
      this.cancelResean = cancelResean;
   }

   public String getPhoneNo()
   {
      return this.phoneNo;
   }

   public void setPhoneNo(String phoneNo)
   {
      this.phoneNo = phoneNo;
   }

   public Date getCancelDate()
   {
      return this.cancelDate;
   }

   public void setCancelDate(Date cancelDate)
   {
      this.cancelDate = cancelDate;
   }

   public String getCancelOperator()
   {
      return this.cancelOperator;
   }

   public void setCancelOperator(String cancelOperator)
   {
      this.cancelOperator = cancelOperator;
   }

   public short getAppointNo()
   {
      return this.appointNo;
   }

   public void setAppointNo(short appointNo)
   {
      this.appointNo = appointNo;
   }

   public String getRegistFlag()
   {
      return this.registFlag;
   }

   public void setRegistFlag(String registFlag)
   {
      this.registFlag = registFlag;
   }

   public Date getDateOfBirth()
   {
      return this.dateOfBirth;
   }

   public void setDateOfBirth(Date dateOfBirth)
   {
      this.dateOfBirth = dateOfBirth;
   }

   public String getMailingAddrAreaCode()
   {
      return this.mailingAddrAreaCode;
   }

   public void setMailingAddrAreaCode(String mailingAddrAreaCode)
   {
      this.mailingAddrAreaCode = mailingAddrAreaCode;
   }

   public String getMailingAddrStreetNo()
   {
      return this.mailingAddrStreetNo;
   }

   public void setMailingAddrStreetNo(String mailingAddrStreetNo)
   {
      this.mailingAddrStreetNo = mailingAddrStreetNo;
   }

   public Date getPhoneNumberHome()
   {
      return this.phoneNumberHome;
   }

   public void setPhoneNumberHome(Date phoneNumberHome)
   {
      this.phoneNumberHome = phoneNumberHome;
   }

}