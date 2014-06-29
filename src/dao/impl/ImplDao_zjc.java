package dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import model.Ozq.ClinicAppoints;
import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;
import model.zjc.MessageBox;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import util.HibernateUtil;
import util.MyUtil;
import dao.IDao_zjc;

public class ImplDao_zjc implements IDao_zjc {
	private HibernateTemplate template = null;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	@SuppressWarnings("unchecked")
	public PatMasterIndex verify(String userName, String passWord) {
		try {
			String hql;
			if (userName.length() == 10) {
				hql = "from PatMasterIndex where patient_id = '" + userName
						+ "'" + "and password = '" + passWord + "'";
			} else {
				hql = "from PatMasterIndex where id_no = '" + userName + "'"
						+ "and password = '" + passWord + "'";
			}
			PatMasterIndex pat = (PatMasterIndex) excuteHibernate(hql).get(0);
			return pat;
		} catch (Exception e) {
			System.out.println("Dao-login():账号密码错误");
			return null;
		}
	}

	@Override
	public String getMaxPatientId() {
		String hql = "from PatMasterIndex where rownum=1 order by patient_id Desc ";
		PatMasterIndex pat = (PatMasterIndex) excuteHibernate(hql).get(0);
		Long maxNum = Long.valueOf(pat.getPatientId().toString()) + 1;
//		System.out.println("maxNum" + maxNum);
		return switchStringAndLeftFilling(maxNum);
	}

	@Override
	public boolean savePatientInfo(PatMasterIndex patMasterIndex) {
		try {
			System.out.println(patMasterIndex);
			template.save(patMasterIndex);
			return true;
		} catch (Exception e) {
			System.out.println("savePatientInfo is false");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DeptDict> getDepts() {
		System.out.println("dao getDepts");
		// 显示有预约科室的时间
//		String hql = "from DeptDict where dept_code in (select clinicDept from OutpDoctorRegist where to_date(sysdate) <= COUNSEL_DATE) ";
		String hql = "from DeptDict where dept_code in (select clinicDept from OutpDoctorRegist where to_date(sysdate) <= COUNSEL_DATE) and COUNSEL_DATE <= to_date(sysdate)+7 )";
		
		// 显示全部科室（暂用）
//		String hql = "from DeptDict where dept_code in (select clinicDept from OutpDoctorRegist ) ";
		List<DeptDict> deptDicts = excuteHibernate(hql);
		return deptDicts;
	}

	@Override
	public List<StaffDict> getDoctorsInfo(Integer deptCode) {
		String hql = "from StaffDict where emp_no in (select distinct doctorNo from OutpDoctorRegist where to_date(sysdate) <= COUNSEL_DATE and COUNSEL_DATE <= to_date(sysdate)+7 ) and dept_code = "
				+ deptCode;
		System.out.println(hql);
		List<StaffDict> doctorsInfo = excuteHibernate(hql);
		return doctorsInfo;
	}

	// 执行自定义hibernate 语句
	@SuppressWarnings("unchecked")
	public List excuteHibernate(final String hql) {
		List list = template
				.executeFind(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						List list = query.list();
						return list;
					}
				});
		return list;
	}

	// 将interger转换为String，并左补齐
	private String switchStringAndLeftFilling(Long i) {
		StringBuilder strb = new StringBuilder();
		int zeros = i.toString().length();
		for (int j = 0; j < (10 - zeros); j++) {
			strb.append(0);
		}
		return strb.append(i.toString()).toString();
	}

	@Override
	public DeptDict getDept(Integer deptCode) {
		// String dept_code = String.valueOf(deptCode);
		// System.out.println(dept_code);
		// DeptDict d = template.get(DeptDict.class, dept_code);
		// System.out.println("单个部门："+d);
		String hql = "from DeptDict where dept_code = " + deptCode;
		return (DeptDict) excuteHibernate(hql).get(0);
	}

	@Override
	public List<OutpDoctorRegist> getOutpDoctor(Integer doctorNo) {
		String hql = "from OutpDoctorRegist where doctor_no= " + doctorNo;
		List<OutpDoctorRegist> outDoctor = excuteHibernate(hql);
		System.out.println("outDoctor" + outDoctor);
		return outDoctor;
	}

	// 查排班
	@SuppressWarnings("unchecked")
	public List<OutpDoctorRegist> CheckOnDuty(Integer dayNum,String clinic_dept, String doctor_no) {
		System.out.println("Dao CheckOnDuty ...");
		String start_time = MyUtil.getToday();
		String end_time =MyUtil.getOtherDay(dayNum);

		System.out.println("start_time=" + start_time + "; end_time ="
				+ end_time + "; clinic_dept =" + clinic_dept
				+ " ; doctor_no = " + doctor_no);

		Session session = HibernateUtil.getSession();
		// List<OutpDoctorRegist> odr = null;

		// Query query =
		// session.createSQLQuery("SELECT A.COUNSEL_NO,A.CLINIC_DEPT,A.DOCTOR_NO,A.DOCTOR, A.COUNSEL_DATE, A.CLINIC_DURATION, A.QUEUE_NAME, A.AUTO_ASSIGN_PATIENT, A.SIGN_INDICATOR,A.SIGN_TIME, "
		// +
		// "A.COUNSELED_NUM, A.ADDRESS,A.COLUMN_NUM,A.LIMIT_NUM,A.LIMIT_NUM_APP, A.REGIST_NOWED, A.REGIST_APPED,A.TIME_POINT,A.STOP_TIME,A.STOP_INDICATOR,A.REGISTER_APPOINT, "
		// +
		// "A.TIME_POINT_FLAG,A.REG_BEGIN_TIME,A.REG_END_TIME,A.MODIFIER,A.LAST_MODIFY_TIME, "
		// +
		// "(CASE WHEN TO_DATE(TO_CHAR((CASE WHEN (A.REG_BEGIN_TIME > A.REG_END_TIME) "
		// +
		// "THEN A.COUNSEL_DATE + 1 ELSE A.COUNSEL_DATE END),'YYYY-MM-DD')||' '|| "
		// +
		// "A.REG_END_TIME||':00','YYYY-MM-DD HH24:MI:SS') < SYSDATE " +
		// "THEN 1 ELSE 0 END) bb, " +
		// "nvl((SELECT SUM(1)  as "+
		// "FROM CLINIC_APPOINTS B "+
		// "where B.VISIT_DATE_APPTED = A.COUNSEL_DATE "+
		// "and B.CLINIC_LABEL = A.QUEUE_NAME "+
		// "and B.VISIT_TIME_APPTED = A.CLINIC_DURATION "+
		// "and B.PRE_REGIST_DOCTOR =  A.DOCTOR_NO "+
		// "and B.REGIST_STATUS IN('0') ) ,0)app_unregisted_num "+
		// "FROM outp_doctor_regist A " +
		// "WHERE to_date(A.COUNSEL_DATE) >= to_date( ?,'yyyy-mm-dd') and to_date(A.COUNSEL_DATE) <= to_date( ?,'yyyy-mm-dd') "
		// +
		// "and (A.CLINIC_DEPT = ? or nvl(?,'null')='null') " +
		// "and (A.DOCTOR_NO = ? or nvl(?,'null')='null')")
		// .setParameter(0, start_time)
		// .setParameter(1, end_time)
		// .setParameter(2, clinic_dept)
		// .setParameter(3, clinic_dept)
		// .setParameter(4, doctor_no)
		// .setParameter(5, doctor_no);
		String sql = "SELECT A.COUNSEL_NO,A.CLINIC_DEPT,A.DOCTOR_NO,A.DOCTOR, A.COUNSEL_DATE, A.CLINIC_DURATION, A.QUEUE_NAME, A.AUTO_ASSIGN_PATIENT, A.SIGN_INDICATOR,A.SIGN_TIME, "
				+ "A.COUNSELED_NUM, A.ADDRESS,A.COLUMN_NUM,A.LIMIT_NUM,A.LIMIT_NUM_APP, A.REGIST_NOWED, A.REGIST_APPED,A.TIME_POINT,A.STOP_TIME,A.STOP_INDICATOR,A.REGISTER_APPOINT, "
				+ "A.TIME_POINT_FLAG,A.REG_BEGIN_TIME,A.REG_END_TIME,A.MODIFIER,A.LAST_MODIFY_TIME, "
				+ "(CASE WHEN TO_DATE(TO_CHAR((CASE WHEN (A.REG_BEGIN_TIME > A.REG_END_TIME) "
				+ "THEN A.COUNSEL_DATE + 1 ELSE A.COUNSEL_DATE END),'YYYY-MM-DD')||' '|| "
				+ "A.REG_END_TIME||':00','YYYY-MM-DD HH24:MI:SS') < SYSDATE "
				+ "THEN 1 ELSE 0 END) bb, "
				+ "nvl((SELECT SUM(1)  as "
				+ "FROM ClinicAppoints B "
				+ "where B.VISIT_DATE_APPTED = A.COUNSEL_DATE "
				+ "and B.CLINIC_LABEL = A.QUEUE_NAME "
				+ "and B.VISIT_TIME_APPTED = A.CLINIC_DURATION "
				+ "and B.PRE_REGIST_DOCTOR =  A.DOCTOR_NO "
				+ "and B.REGIST_STATUS IN('0') ) ,0)app_unregisted_num "
				+ "FROM OutpDoctorRegist A "
				+ "WHERE to_date(A.COUNSEL_DATE) >= to_date('"
				+ start_time
				+ "','yyyy-mm-dd') and to_date(A.COUNSEL_DATE) <= to_date('"
				+ end_time
				+ "','yyyy-mm-dd') "
				+ "and (A.CLINIC_DEPT = "
				+ clinic_dept
				+ " or nvl('"
				+ clinic_dept
				+ "','null')='null') "
				+ "and (A.DOCTOR_NO = "
				+ doctor_no
				+ " or nvl('" + doctor_no + "','null')='null')";
//		Query query = session.createSQLQuery(sql);
		 // .setParameter(0, start_time)
		 // .setParameter(1, end_time)
		 // .setParameter(2, clinic_dept)
		 // .setParameter(3, clinic_dept)
		 // .setParameter(4, doctor_no)
		 // .setParameter(5, doctor_no);
		
		 System.out.println(sql);
//		List<OutpDoctorRegist> odr = query.list();
		 
		List<OutpDoctorRegist> odr  = excuteHibernate(sql);
		System.out.println("odr = " + odr.get(0));
		System.out.println("dao CheckOnDuty end2...");
		return odr;

	}

	@Override
	public StaffDict getDoctor(Integer doctorNO) {
		String hql = "from StaffDict where emp_no = " + doctorNO;
		return (StaffDict) excuteHibernate(hql).get(0);
	}

	@Override
	public List<ClinicAppoints> getAppoints(PatMasterIndex pat) {
		System.out.println("pat"+pat);
		String hql = "from ClinicAppoints where patient_id = '" + pat.getPatientId() + "' and regist_status =0 and to_date(sysdate) <= VISIT_DATE_APPTED";
		System.out.println("hql"+hql);
		List<ClinicAppoints> appoints = excuteHibernate(hql);
		System.out.println("appoints" +appoints);
		return appoints;
	}

	@Override
	public boolean saveAdvice(MessageBox advice) {
		try {
			System.out.println("advice dao = "+advice);
			template.save(advice);
			System.out.println("===");
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	@Override
	public boolean cancleAppoint(ClinicAppoints appoint) {
		try {
			String cancleStatus = String.valueOf(2);
//			appoint.setRegistStatus(cancleStatus);
//			template.save(appoint);
//			template.saveOrUpdate(appoint);
//			template.update(appoint);
			String updateSql = "update clinic_appoints set REGIST_STATUS=? where PRE_REGIST_DOCTOR =? and REG_TIME_POINT =? ";	 
			 Session session = HibernateUtil.getSession();
		      Transaction ts = session.beginTransaction();
		      Query query = session.createSQLQuery(updateSql);
		      query.setString(0, cancleStatus);
		      query.setString(1, appoint.getPreRegistDoctor());
		      query.setString(2, appoint.getRegTimePoint());
		      query.executeUpdate();
		      ts.commit();
		      session.flush();
		      session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}

	public static void main(String[] args) {
		ImplDao_zjc dao = new ImplDao_zjc();
		String s = "2014-06-20 08:00?doctorNo=9999";
		String s1 = s.substring(0, 16);
		String s2 = s.substring(26);
		System.out.println(s1);
		System.out.println(s2);
	}
	
	//查每个时间点
	@Override
	public OutpDoctorRegist getOutpDoctorOne(String doctorName, String date,
			String duration) {
		String hql ="from OutpDoctorRegist where doctor='" + doctorName +"' and CLINIC_DURATION ='"+duration+"' and to_date(COUNSEL_DATE) = to_date('"+ date +"','yyyy-MM-dd')";
		return (OutpDoctorRegist) excuteHibernate(hql).get(0);
	}

	@Override
	public List<Object[]> CheckRegistTime(String doctor_no,
			String counsel_date, String clinic_duration, String queue_name) {
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
}
