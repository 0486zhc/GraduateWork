package dao;

import java.util.List;

import model.Ozq.OutpDoctorRegist;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class OzqDao{

	private HibernateTemplate template = null;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate hibernateTemplate) {
		this.template = hibernateTemplate;
	}
	
	//≤È≈≈∞‡
	public List<OutpDoctorRegist> CheckOnDuty(String start_time,String end_time,String clinic_dept,String doctor_no) {
		System.out.println("dao...");
		return getTemplate().find(" SELECT COUNSEL_NO,CLINIC_DEPT,DOCTOR_NO,DOCTOR, COUNSEL_DATE, CLINIC_DURATION, QUEUE_NAME, AUTO_ASSIGN_PATIENT, SIGN_INDICATOR,SIGN_TIME, " +
                " COUNSELED_NUM, ADDRESS,COLUMN_NUM,LIMIT_NUM,LIMIT_NUM_APP, REGIST_NOWED, REGIST_APPED,TIME_POINT,STOP_TIME,STOP_INDICATOR,REGISTER_APPOINT, " +
                " TIME_POINT_FLAG,REG_BEGIN_TIME,REG_END_TIME,MODIFIER,LAST_MODIFY_TIME, " +
                " (CASE WHEN TO_DATE(TO_CHAR((CASE WHEN (REG_BEGIN_TIME > REG_END_TIME) " +
                " THEN COUNSEL_DATE + 1 ELSE COUNSEL_DATE END),'YYYY-MM-DD')||' '|| " +
                " REG_END_TIME||':00','YYYY-MM-DD HH24:MI:SS') < SYSDATE " +
                " THEN 1 ELSE 0 END) bb, " +
                " nvl((SELECT SUM(1)  as "+
                " FROM CLINIC_APPOINTS "+
                " where CLINIC_APPOINTS.VISIT_DATE_APPTED   = COUNSEL_DATE "+
                 " and CLINIC_APPOINTS.CLINIC_LABEL       = QUEUE_NAME "+
                 " and CLINIC_APPOINTS.VISIT_TIME_APPTED   = Clinic_duration "+
                 " and CLINIC_APPOINTS.PRE_REGIST_DOCTOR   =  DOCTOR_NO "+
                 " and CLINIC_APPOINTS.REGIST_STATUS IN('0') ) ,0)app_unregisted_num "+
        " FROM OutpDoctorRegist " +
        " WHERE   to_date(COUNSEL_DATE) >= to_date( '" + start_time + "','yyyy-mm-dd') " +
        " and to_date(COUNSEL_DATE) <= to_date( '" + end_time + "','yyyy-mm-dd') and (CLINIC_DEPT = '" + clinic_dept + "' or nvl('" + clinic_dept + "','null')='null') " +
        " and (DOCTOR_NO = '" + doctor_no + "' or nvl('" + doctor_no + "','null')='null' )");
	}
}
