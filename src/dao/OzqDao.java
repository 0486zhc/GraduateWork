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
		return getTemplate().find(" SELECT A.COUNSEL_NO,A.CLINIC_DEPT,A.DOCTOR_NO,A.DOCTOR, A.COUNSEL_DATE, A.CLINIC_DURATION, A.QUEUE_NAME, A.AUTO_ASSIGN_PATIENT, A.SIGN_INDICATOR,A.SIGN_TIME, " +
                " A.COUNSELED_NUM, A.ADDRESS,A.COLUMN_NUM,A.LIMIT_NUM,A.LIMIT_NUM_APP, A.REGIST_NOWED, A.REGIST_APPED,A.TIME_POINT,A.STOP_TIME,A.STOP_INDICATOR,A.REGISTER_APPOINT, " +
                " A.TIME_POINT_FLAG,A.REG_BEGIN_TIME,A.REG_END_TIME,A.MODIFIER,A.LAST_MODIFY_TIME, " +
                " (CASE WHEN TO_DATE(TO_CHAR((CASE WHEN (A.REG_BEGIN_TIME > A.REG_END_TIME) " +
                " THEN A.COUNSEL_DATE + 1 ELSE A.COUNSEL_DATE END),'YYYY-MM-DD')||' '|| " +
                "A.REG_END_TIME||':00','YYYY-MM-DD HH24:MI:SS') < SYSDATE " +
                " THEN 1 ELSE 0 END) bb, " +
                " nvl((SELECT SUM(1)  as "+
                " FROM CLINIC_APPOINTS "+
                " where CLINIC_APPOINTS.VISIT_DATE_APPTED   = A.COUNSEL_DATE "+
                 " and CLINIC_APPOINTS.CLINIC_LABEL       = A.QUEUE_NAME "+
                 " and CLINIC_APPOINTS.VISIT_TIME_APPTED   = A.clinic_duration "+
                 " and CLINIC_APPOINTS.PRE_REGIST_DOCTOR   =  A.DOCTOR_NO "+
                 " and CLINIC_APPOINTS.REGIST_STATUS IN('0') ) ,0)app_unregisted_num "+
        " FROM OutpDoctorRegist A " +
        " WHERE   to_date(A.COUNSEL_DATE) >= to_date( '" + start_time + "','yyyy-mm-dd') " +
        " and to_date(A.COUNSEL_DATE) <= to_date( '" + end_time + "','yyyy-mm-dd') and (A.CLINIC_DEPT = '" + clinic_dept + "' or nvl('" + clinic_dept + "','null')='null') " +
        " and (A.DOCTOR_NO = '" + doctor_no + "' or nvl('" + doctor_no + "','null')='null' )");
	}
}
