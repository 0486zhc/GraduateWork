package dao;

import java.util.List;

import model.Ozq.OutpDoctorRegist;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import util.HibernateUtil;

public class OzqDao{

	private HibernateTemplate template = null;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate hibernateTemplate) {
		this.template = hibernateTemplate;
	}
	
	//≤È≈≈∞‡
	@SuppressWarnings("unchecked")
	public List<OutpDoctorRegist> CheckOnDuty(String start_time,String end_time,String clinic_dept,String doctor_no) {
		System.out.println("dao...");
		
		Session session = HibernateUtil.getSession();
		List<OutpDoctorRegist> odr = null;
		
		Query query = session.createSQLQuery("SELECT A.COUNSEL_NO,A.CLINIC_DEPT,A.DOCTOR_NO,A.DOCTOR, A.COUNSEL_DATE, A.CLINIC_DURATION, A.QUEUE_NAME, A.AUTO_ASSIGN_PATIENT, A.SIGN_INDICATOR,A.SIGN_TIME, " +
                "A.COUNSELED_NUM, A.ADDRESS,A.COLUMN_NUM,A.LIMIT_NUM,A.LIMIT_NUM_APP, A.REGIST_NOWED, A.REGIST_APPED,A.TIME_POINT,A.STOP_TIME,A.STOP_INDICATOR,A.REGISTER_APPOINT, " +
                "A.TIME_POINT_FLAG,A.REG_BEGIN_TIME,A.REG_END_TIME,A.MODIFIER,A.LAST_MODIFY_TIME, " +
                "(CASE WHEN TO_DATE(TO_CHAR((CASE WHEN (A.REG_BEGIN_TIME > A.REG_END_TIME) " +
                "THEN A.COUNSEL_DATE + 1 ELSE A.COUNSEL_DATE END),'YYYY-MM-DD')||' '|| " +
                "A.REG_END_TIME||':00','YYYY-MM-DD HH24:MI:SS') < SYSDATE " +
                "THEN 1 ELSE 0 END) bb, " +
                "nvl((SELECT SUM(1)  as "+
                "FROM CLINIC_APPOINTS B "+
                "where B.VISIT_DATE_APPTED = A.COUNSEL_DATE "+
                 "and B.CLINIC_LABEL = A.QUEUE_NAME "+
                 "and B.VISIT_TIME_APPTED = A.CLINIC_DURATION "+
                 "and B.PRE_REGIST_DOCTOR =  A.DOCTOR_NO "+
                 "and B.REGIST_STATUS IN('0') ) ,0)app_unregisted_num "+
        "FROM outp_doctor_regist A " +
        "WHERE to_date(A.COUNSEL_DATE) >= to_date( ?,'yyyy-mm-dd') and to_date(A.COUNSEL_DATE) <= to_date( ?,'yyyy-mm-dd') " +
        "and (A.CLINIC_DEPT = ? or nvl(?,'null')='null') " +
        "and (A.DOCTOR_NO = ? or nvl(?,'null')='null')")
//        .setParameter(0, "2014-01-23")
//        .setParameter(1, "2014-01-25")
//        .setString(2, "0101")
//        .setString(3, "0101")
//        .setString(4, "1106")
//        .setString(5, "1106");
        
//        .setString(0, start_time)
//        .setString(1, end_time)
//        .setString(2, clinic_dept)
//        .setString(3, clinic_dept)
//        .setString(4, doctor_no)
//        .setString(5, doctor_no);       
        
        .setParameter(0, start_time)
        .setParameter(1, end_time)
        .setParameter(2, clinic_dept)
        .setParameter(3, clinic_dept)
        .setParameter(4, doctor_no)
        .setParameter(5, doctor_no); 
	    System.out.println("dao end1...");
	    odr = query.list();
	    System.out.println("dao end2...");
	    return odr;
	}
}
