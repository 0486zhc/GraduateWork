package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
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

	public static void main(String[] args) {
		ImplDao_zjc dao = new ImplDao_zjc();
		dao.getDepts();
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
	
}
