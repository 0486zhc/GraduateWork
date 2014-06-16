package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import util.HibernateUtil;

import model.lhb.PatMasterIndex;
import dao.IDao_zjc;

public class ImplDao_zjc implements IDao_zjc{
	private HibernateTemplate template = null ;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public PatMasterIndex verify(String userName, String passWord) {
		System.out.println("dao...");
		final String hql ="from PatMasterIndex where id_no = '"+userName+"'" + "and password = '"+passWord+"'";
	    List<PatMasterIndex> list = template.executeFind( new HibernateCallback() {
		     	 public Object doInHibernate(Session session) throws HibernateException, SQLException {  
		     		 Query query = session.createQuery(hql); 
				     List<PatMasterIndex> list = query.list();  
				     return list;  
		     	 }  
		   }
	     ); 
		return list.get(0);
	}

}
