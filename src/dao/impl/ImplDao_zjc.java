package dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.Ozq.StaffDict;
import model.lhb.PatMasterIndex;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.dialect.IngresDialect;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import util.HibernateUtil;

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
	public String verify(String userName, String passWord) {
		try {
			String hql ;
			if(userName.length() == 10){
				 hql = "from PatMasterIndex where patient_id = '" + userName
						+ "'" + "and password = '" + passWord + "'";
			}else{
				 hql = "from PatMasterIndex where id_no = '" + userName
						+ "'" + "and password = '" + passWord + "'";
			}
			PatMasterIndex pat = (PatMasterIndex) excuteHibernate(hql).get(0);
			return pat.getName();
		} catch (Exception e) {
			System.out.println("Dao-login():账号密码错误");
			return "";
		}
	}

	@Override
	public String getMaxPatientId() {
		String hql = "from PatMasterIndex where rownum=1 order by patient_id Desc ";
		PatMasterIndex pat = (PatMasterIndex) excuteHibernate(hql).get(0);
			Long maxNum = Long.valueOf(pat.getPatientId().toString())  + 1;
			System.out.println("maxNum" + maxNum);
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
		System.out.println("dao getDepts" );
		String hql = "from DeptDict as d where dept_code in (select clinicDept from OutpDoctorRegist) ";
		List<DeptDict> deptDicts = excuteHibernate(hql);
//		list.get(0);
//		System.out.println(list);
		return deptDicts ;
	}

	@Override
	public List<StaffDict> getDoctorsInfo(Integer deptCode) {
//		String hql = "from OutpDoctorRegist where clinicDept = " + deptCode ;
		String hql = "from StaffDict where emp_no in (select distinct doctorNo from OutpDoctorRegist ) and dept_code = " + deptCode;
//		String hql = "select *,count(distinct doctor) from OutpDoctorRegist where clinicDept = " + deptCode + " group by doctor";
		System.out.println(hql);
		List<StaffDict> doctorsInfo = excuteHibernate(hql);
//		List<OutpDoctorRegist> doctorBak = new ArrayList<OutpDoctorRegist>() ;
//		
//		List<OutpDoctorRegist> doctorNew = new ArrayList<OutpDoctorRegist>() ;
//		doctorBak.addAll(doctorsAll);
//		
//		for(OutpDoctorRegist o : doctorsAll){
//			for(OutpDoctorRegist d : doctorBak){
//				if(!o.getDoctor().equals(d.getDoctor())){
//					doctorNew.add(o);
//				}
//			}
//		}
	
		return doctorsInfo;
	}

	// 执行自定义hibernate 语句
	@SuppressWarnings("unchecked")
	public List excuteHibernate(final String hql) {
		List<PatMasterIndex> list = template
				.executeFind(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						List<PatMasterIndex> list = query.list();
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
//		String dept_code = String.valueOf(deptCode);
//		System.out.println(dept_code);
//		DeptDict d = template.get(DeptDict.class, dept_code);
//		System.out.println("单个部门："+d);
		String hql = "from DeptDict where dept_code = " + deptCode;
		return (DeptDict) excuteHibernate(hql).get(0); 
	}

	@Override
	public List<OutpDoctorRegist> getOutpDoctor(Integer doctorNo) {
		String hql = "from OutpDoctorRegist where doctor_no= " + doctorNo;
		List<OutpDoctorRegist> outDoctor =  excuteHibernate(hql);
		System.out.println("outDoctor"+ outDoctor);
		return outDoctor;
	}
	
	//查7天排班
		public List<OutpDoctorRegist> CheckOnDuty(Integer dayNum,String clinic_dept,String doctor_no) {
			System.out.println("Dao CheckOnDuty ...");
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			//开始日期
			Date today = new Date();
			String start_time = df.format(today);
			//结束日期
			Date twelveday = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(twelveday);
//			calendar.add(calendar.DATE,6);//把日期往后增加一天.整数往后推,负数往前移动
			calendar.add(calendar.DATE,dayNum);
			twelveday=calendar.getTime(); //这个时间就是日期往后推的结果 
			String end_time = df.format(twelveday);
			
//			System.out.println(start_time);
//			System.out.println(end_time);
			System.out.println("start_time="+start_time +"; end_time =" + end_time + "; clinic_dept ="+clinic_dept + " ; doctor_no = "+doctor_no);
			
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
	        .setParameter(0, start_time)
	        .setParameter(1, end_time)
	        .setParameter(2, clinic_dept)
	        .setParameter(3, clinic_dept)
	        .setParameter(4, doctor_no)
	        .setParameter(5, doctor_no); 
		    odr = query.list();
		    
		    System.out.println("odr = " + odr);
		    System.out.println("dao CheckOnDuty end2...");
		    return odr;
		}

		@Override
		public StaffDict getDoctor(Integer doctorNO) {
			String hql = "from StaffDict where emp_no = " + doctorNO;
			return (StaffDict) excuteHibernate(hql).get(0);
		}
	
		public static void main(String[] args) {
//			ImplDao_zjc dao = new ImplDao_zjc();
//
//			dao.getDepts();
			
//			ImplDao_zjc dao = new ImplDao_zjc();
//			StaffDict s = dao.getDoctor(1104);
//			System.out.println("StaffDict="+s);
		}
}
