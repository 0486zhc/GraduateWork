package dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
	
//	//查12天排班
//	public List<Object[]> CheckOnDutyMany(String clinic_dept,String doctor_no) {
//		System.out.println("dao...");
//		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//		//开始日期
//		Date today = new Date();
//		String start_time = df.format(today);
//		//结束日期(12天)
//		Date Twelveday = new Date();
//		Calendar calendar = new GregorianCalendar();
//		calendar.setTime(Twelveday);
//		calendar.add(calendar.DATE,11);//把日期往后增加.整数往后推,负数往前移动
//		Twelveday=calendar.getTime(); //这个时间就是日期往后推的结果 
//		String end_time = df.format(Twelveday);
//		
//		Session session = HibernateUtil.getSession();
//		List<Object[]> odr = null;
//		
//		Query query = session.createSQLQuery("select * FROM outp_doctor_regist WHERE to_date(COUNSEL_DATE) >= to_date( ?,'yyyy-mm-dd')and to_date(COUNSEL_DATE) <= to_date( ?,'yyyy-mm-dd') and (CLINIC_DEPT = ?) and (DOCTOR_NO = ?)")
//				.setParameter(0, start_time)
//				.setParameter(1, end_time)
//				.setParameter(2, clinic_dept)
//				.setParameter(3, doctor_no);
//	    System.out.println("dao end1...");
//	    odr = query.list();
//	    System.out.println("dao CheckOnDuty end2...");
//	    return odr;
//	}
	
	//查之后一共7天的排班
	//查Twoday排班
	public List<Object[]> CheckOnDutyTwoday(String clinic_dept,String doctor_no) {
		System.out.println("dao...");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

		//日期
		Date twoday = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(twoday);
		calendar.add(calendar.DATE,1);//把日期往后增加.整数往后推,负数往前移动
		twoday=calendar.getTime(); //这个时间就是日期往后推的结果 
		String start_time = df.format(twoday);
		
		Session session = HibernateUtil.getSession();
		List<Object[]> odr = null;
		
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
	      "WHERE to_date(A.COUNSEL_DATE) = to_date( ?,'yyyy-mm-dd') " +
	      "and (A.CLINIC_DEPT = ?) " +
	      "and (A.DOCTOR_NO = ?)")
	      .setParameter(0, start_time)
	      .setParameter(1, clinic_dept)
	      .setParameter(2, doctor_no);
	    System.out.println("dao end1...");
	    odr = query.list();
	    System.out.println("dao CheckOnDuty end2...");
	    return odr;
	}
	
	//查Threeday排班
	public List<Object[]> CheckOnDutyThreeday(String clinic_dept,String doctor_no) {
		System.out.println("dao...");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

		//日期
		Date Threeday = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(Threeday);
		calendar.add(calendar.DATE,2);//把日期往后增加.整数往后推,负数往前移动
		Threeday=calendar.getTime(); //这个时间就是日期往后推的结果 
		String start_time = df.format(Threeday);
		
		Session session = HibernateUtil.getSession();
		List<Object[]> odr = null;
		
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
	      "WHERE to_date(A.COUNSEL_DATE) = to_date( ?,'yyyy-mm-dd') " +
	      "and (A.CLINIC_DEPT = ?) " +
	      "and (A.DOCTOR_NO = ?)")
	      .setParameter(0, start_time)
	      .setParameter(1, clinic_dept)
	      .setParameter(2, doctor_no);
	    System.out.println("dao end1...");
	    odr = query.list();
	    System.out.println("dao CheckOnDuty end2...");
	    return odr;
	}
	
	//查Fourday排班
	public List<Object[]> CheckOnDutyFourday(String clinic_dept,String doctor_no) {
		System.out.println("dao...");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

		//日期
		Date Fourday = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(Fourday);
		calendar.add(calendar.DATE,3);//把日期往后增加.整数往后推,负数往前移动
		Fourday=calendar.getTime(); //这个时间就是日期往后推的结果 
		String start_time = df.format(Fourday);
		
		Session session = HibernateUtil.getSession();
		List<Object[]> odr = null;
		
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
	      "WHERE to_date(A.COUNSEL_DATE) = to_date( ?,'yyyy-mm-dd') " +
	      "and (A.CLINIC_DEPT = ?) " +
	      "and (A.DOCTOR_NO = ?)")
	      .setParameter(0, start_time)
	      .setParameter(1, clinic_dept)
	      .setParameter(2, doctor_no);
	    System.out.println("dao end1...");
	    odr = query.list();
	    System.out.println("dao CheckOnDuty end2...");
	    return odr;
	}
	
	//查Fiveday排班
	public List<Object[]> CheckOnDutyFiveday(String clinic_dept,String doctor_no) {
		System.out.println("dao...");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

		//日期
		Date Fiveday = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(Fiveday);
		calendar.add(calendar.DATE,4);//把日期往后增加.整数往后推,负数往前移动
		Fiveday=calendar.getTime(); //这个时间就是日期往后推的结果 
		String start_time = df.format(Fiveday);
		
		Session session = HibernateUtil.getSession();
		List<Object[]> odr = null;
		
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
	      "WHERE to_date(A.COUNSEL_DATE) = to_date( ?,'yyyy-mm-dd') " +
	      "and (A.CLINIC_DEPT = ?) " +
	      "and (A.DOCTOR_NO = ?)")
	      .setParameter(0, start_time)
	      .setParameter(1, clinic_dept)
	      .setParameter(2, doctor_no);
	    System.out.println("dao end1...");
	    odr = query.list();
	    System.out.println("dao CheckOnDuty end2...");
	    return odr;
	}
	
	//查Sixday排班
	public List<Object[]> CheckOnDutySixday(String clinic_dept,String doctor_no) {
		System.out.println("dao...");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

		//日期
		Date Sixday = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(Sixday);
		calendar.add(calendar.DATE,5);//把日期往后增加.整数往后推,负数往前移动
		Sixday=calendar.getTime(); //这个时间就是日期往后推的结果 
		String start_time = df.format(Sixday);
		
		Session session = HibernateUtil.getSession();
		List<Object[]> odr = null;
		
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
	      "WHERE to_date(A.COUNSEL_DATE) = to_date( ?,'yyyy-mm-dd') " +
	      "and (A.CLINIC_DEPT = ?) " +
	      "and (A.DOCTOR_NO = ?)")
	      .setParameter(0, start_time)
	      .setParameter(1, clinic_dept)
	      .setParameter(2, doctor_no);
	    System.out.println("dao end1...");
	    odr = query.list();
	    System.out.println("dao CheckOnDuty end2...");
	    return odr;
	}
	
	//查Sevenday排班
	public List<Object[]> CheckOnDutySevenday(String clinic_dept,String doctor_no) {
		System.out.println("dao...");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

		//日期
		Date Sevenday = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(Sevenday);
		calendar.add(calendar.DATE,6);//把日期往后增加.整数往后推,负数往前移动
		Sevenday=calendar.getTime(); //这个时间就是日期往后推的结果 
		String start_time = df.format(Sevenday);
		
		Session session = HibernateUtil.getSession();
		List<Object[]> odr = null;
		
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
	      "WHERE to_date(A.COUNSEL_DATE) = to_date( ?,'yyyy-mm-dd') " +
	      "and (A.CLINIC_DEPT = ?) " +
	      "and (A.DOCTOR_NO = ?)")
	      .setParameter(0, start_time)
	      .setParameter(1, clinic_dept)
	      .setParameter(2, doctor_no);
	    System.out.println("dao end1...");
	    
	    odr = query.list();
	    System.out.println("dao CheckOnDuty end2...");
	    return odr;
	}
	
	//查Eightday排班
		public List<Object[]> CheckOnDutyEightday(String clinic_dept,String doctor_no) {
			System.out.println("dao...");
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			//日期
			Date Eightday = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(Eightday);
			calendar.add(calendar.DATE,7);//把日期往后增加.整数往后推,负数往前移动
			Eightday=calendar.getTime(); //这个时间就是日期往后推的结果 
			String start_time = df.format(Eightday);
			
			Session session = HibernateUtil.getSession();
			List<Object[]> odr = null;
			
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
	      "WHERE to_date(A.COUNSEL_DATE) = to_date( ?,'yyyy-mm-dd') " +
	      "and (A.CLINIC_DEPT = ?) " +
	      "and (A.DOCTOR_NO = ?)")
	      .setParameter(0, start_time)
	      .setParameter(1, clinic_dept)
	      .setParameter(2, doctor_no);
		    System.out.println("dao end1...");
		    odr = query.list();
		    System.out.println("dao CheckOnDuty end2...");
		    return odr;
		}
	
	//查每个时间点
	public List<Object[]> CheckRegistTime(String doctor_no, String counsel_date, String clinic_duration, String queue_name){
		System.out.println("dao...");
		
		Session session = HibernateUtil.getSession();
		List<Object[]> odr = null;
		
		Query query = session.createSQLQuery(
				"SELECT T_A.TIMES, to_char(T_A.TIMES, 'hh24:mi') as regist_time, to_char(T_A.TIMES, 'yyyy-mm-dd hh24:mi') as real_regist_time, T_A.SQNO " + 
  "FROM (select T.times as times, rownum as sqno " + 
          "from (select to_date(bb || ':00', 'yyyy-mm-dd hh24:mi:ss') times " + 
                  "from (select a.doctor_no, a.doctor, a.queue_name, a.clinic_duration, to_char(a.counsel_date, 'yyyy-mm-dd') || ' ' || nvl(a.reg_begin_time, b.reg_begin_time) bb, to_char(a.counsel_date, 'yyyy-mm-dd') || ' ' || nvl(a.reg_end_time, b.reg_end_time) cc " + 
                          "from OUTP_DOCTOR_REGIST a, " + 
                               "TIME_INTERVAL_DICT b, " + 
                               "clinic_index       c " + 
                         "where a.clinic_dept = b.dept_code " + 
                           "and a.queue_name = c.clinic_label " + 
                           "and a.clinic_duration = b.time_interval_name " + 
                           "and to_date(a.counsel_date) = to_date(?, 'yyyy-mm-dd') " + 
                           "and a.doctor_no = ? " + 
                           "and a.clinic_duration = ?) " + 
                "union " + 
                "select y.tt + 1 / (24 * 60) * rownum * 15 as times " + 
                  "from (select to_date(bb || ':00', 'yyyy-mm-dd hh24:mi:ss') tt, " + 
                               "floor((((case " + 
                                       "when to_date(bb || ':00', 'yyyy-mm-dd hh24:mi:ss') > " + 
                                            "to_date(cc || ':00', 'yyyy-mm-dd hh24:mi:ss')  " + 
                                            "then " + 
                                            "to_date(cc || ':00', 'yyyy-mm-dd hh24:mi:ss') + 1 " + 
                                       "else " + 
                                            "to_date(cc || ':00', 'yyyy-mm-dd hh24:mi:ss') " + 
                                     "end) - to_date(bb || ':00', 'yyyy-mm-dd hh24:mi:ss')) * 24 * 60 - 5) / 15) times " + 
                          "from (select a.doctor_no, a.doctor, a.queue_name, a.clinic_duration, to_char(a.counsel_date, 'yyyy-mm-dd') || ' ' || nvl(a.reg_begin_time, b.reg_begin_time) bb, to_char(a.counsel_date, 'yyyy-mm-dd') || ' ' || nvl(a.reg_end_time, b.reg_end_time) cc " + 
                                  "from OUTP_DOCTOR_REGIST a, " + 
                                       "TIME_INTERVAL_DICT b, " + 
                                       "clinic_index c " + 
                                 "where a.clinic_dept = b.dept_code " + 
                                   "and a.queue_name = c.clinic_label " + 
                                   "and a.clinic_duration = b.time_interval_name " + 
                                   "and to_date(a.counsel_date) = to_date(?, 'yyyy-mm-dd') " + 
                                   "and a.doctor_no = ? " + 
                                   "and a.QUEUE_NAME = ? " + 
                                   "and a.clinic_duration = ?) X, dept_dict z) Y " + 
                 "where rownum <= y.times) T) T_A " + 
 "where to_char(T_A.times, 'yyyy-mm-dd hh24:mi') not in " + 
       "(select REG_TIME_POINT " + 
          "from CLINIC_APPOINTS " + 
          "where PRE_REGIST_DOCTOR = ? " + 
            "and REGIST_STATUS <> '2' " + 
            "and to_date(VISIT_DATE_APPTED) = to_date(?, 'yyyy-mm-dd')) " +
            "and T_A.times > sysdate " + 
 "order by T_A.times")
 		.setParameter(0, counsel_date)
        .setParameter(1, doctor_no)
        .setParameter(2, clinic_duration)
        .setParameter(3, counsel_date)
        .setParameter(4, doctor_no)
        .setParameter(5, queue_name)
        .setParameter(6, clinic_duration)
        .setParameter(7, doctor_no)
        .setParameter(8, counsel_date);
	    System.out.println("dao end1...");
	    odr = query.list();
	    System.out.println("dao CheckClinicDeptDoctorNo end2...");
	    return odr;
	}
	
	//查诊室代号 & 医生工号
		public List<Object[]> CheckClinicDeptDoctorNo(String doctor_name) {
			System.out.println("dao...");
			
			Session session = HibernateUtil.getSession();
			List<Object[]> odr = null;
			
			Query query = session.createSQLQuery(
					"select CLINIC_DEPT,DOCTOR_NO " + 
					"from OUTP_DOCTOR_REGIST " + 
					"where DOCTOR like ?" + 
					"group by CLINIC_DEPT,DOCTOR_NO")
	        .setParameter(0, doctor_name); 
		    System.out.println("dao end1...");
		    odr = query.list();
		    System.out.println("dao CheckClinicDeptDoctorNo end2...");
		    return odr;
		}
	
	//查医生名字
		public List<Object[]> CheckDoctorName(String deptname) {
			System.out.println("dao...");
			
			Session session = HibernateUtil.getSession();
			Query query = session.createSQLQuery(
					"select DOCTOR " + 
					"from OUTP_DOCTOR_REGIST " + 
					"where CLINIC_DEPT in (select DEPT_CODE " + 
					"from DEPT_DICT where DEPT_NAME " + 
					"like ?)" + 
					"group by DOCTOR")
					.setParameter(0, deptname);
		    System.out.println("dao end1...");
		    List<Object[]> odr = query.list();
		    System.out.println(odr.get(0));
		    System.out.println("dao CheckDoctorName end2...");
		    return odr;
		}
		
		//查其他医生名字
				public List<Object[]> CheckOtherDoctorName(String deptname,String doctorname) {
					System.out.println("dao...");
					
					Session session = HibernateUtil.getSession();
					Query query = session.createSQLQuery(
							"select DOCTOR " + 
							"from OUTP_DOCTOR_REGIST " + 
							"where CLINIC_DEPT in (select DEPT_CODE " + 
							"from DEPT_DICT where DEPT_NAME " + 
							"like ? and DOCTOR != ?)" + 
							"group by DOCTOR")
							.setParameter(0, deptname)
							.setParameter(1, doctorname);
				    System.out.println("dao end1...");
				    List<Object[]> odr = query.list();
				    System.out.println(odr.get(0));
				    System.out.println("dao CheckDoctorName end2...");
				    return odr;
				}
		
//		//查时间
//		public List<Timestamp> CheckDate(String date) throws ParseException{
//			System.out.println("dao...");
//			
//			Session session = HibernateUtil.getSession();
//			Query query = session.createSQLQuery(
//						"select COUNSEL_DATE from outp_doctor_regist where to_date(COUNSEL_DATE) = to_date( ?,'yyyy-mm-dd')"
//						).setParameter(0, date);
//			System.out.println("dao end1...");
//			List<Timestamp> da = query.list();
//			if(da != null){
//			System.out.println("dao CheckDate end2...");
//			return da;
//			}else{
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				da.add(0, (Timestamp) sdf.parse(date));
//				return (List<Timestamp>) da.get(0);
//			}
//		}
}
