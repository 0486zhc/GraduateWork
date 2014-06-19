package dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import model.Ozq.DeptDict;
import model.Ozq.OutpDoctorRegist;
import model.lhb.PatMasterIndex;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
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
			final String hql = "from PatMasterIndex where id_no = '" + userName
					+ "'" + "and password = '" + passWord + "'";
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
	public List<DeptDict> getDept() {
//		String hql = "from DeptDict  where DEPT_CODE in (select CLINIC_DEPT from OutpDoctorRegist )";
//		String hql = "from DeptDict as d where d.dept_code in (select o.clinicDept from OutpDoctorRegist as o)";
		final String hql = "from DeptDict";
		DeptDict pat = (DeptDict) excuteHibernate(hql).get(0);
		System.out.println("pat:"+pat);
//			System.out.println("maxNum" + pat.G);
			return null;
		
//		String sql = "select * from dept_dict where dept_code in (select clinic_dept from outp_doctor_regist)";
//		Session session = HibernateUtil.getSession();
//		Query query = session.createSQLQuery(sql);
//	    List<Object> list = query.list();
////	    System.out.println("list"+list.get(0).getDeptName());
////	    System.out.println("=====");
////	    Iterator<DeptDict> i = list.iterator();
////	    while(i.hasNext()){
////	    	System.out.println(i.next());
////	    }
////	    System.out.println("=====");
//	    Object[] obj=(Object[])list.get(0);
//	    System.out.println((String)obj[0]);
	}

	@Override
	public List<OutpDoctorRegist> getDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	// 执行自定义hibernate 语句
	@SuppressWarnings("unchecked")
	public List<?> excuteHibernate(final String hql) {
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

	public static void main(String[] args) {
		ImplDao_zjc dao = new ImplDao_zjc();
		dao.getDept();
	}

}
