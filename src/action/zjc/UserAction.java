package action.zjc;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionContext;

import bo.IBo_zjc;
import model.lhb.PatMasterIndex;
import model.zjc.MessageBox;

public class UserAction
{
	private IBo_zjc bo ;
	private PatMasterIndex patMasterIndex;
	private MessageBox advice ;
	
	String mess ;
	String userName;
	String passWord;
	
	String year;
	String month;
	String day;
	
	// 登录
	public String login(){
		System.out.println("action");
		patMasterIndex = bo.verify(userName,passWord);
		System.out.println("patMasterIndex="+ patMasterIndex);
		if(patMasterIndex.getName() != "" ){
			ActionContext.getContext().getSession().put("pat",patMasterIndex);  // 放session
			return "success";
		}else
			return "false";
	}
	
	// 注册
	public String register(){
		System.out.println("register");
		String birthDate = year+"-"+month+"-"+day;
		System.out.println(birthDate);
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		
		Timestamp ts = null;
		try {
			ts = new Timestamp(format.parse(birthDate).getTime());
		} catch (ParseException e) {
			System.out.println("注册日期转换");
			e.printStackTrace();
		}  
		
		patMasterIndex.setDateOfBirth(ts);
		mess = bo.addRegister(patMasterIndex);
		System.out.println(mess);
		return "success";
	}
	
	// 建议箱
	public String advice(){
		System.out.println("advice");
		advice.setWriteDate(new Date(0));
		System.out.println(advice);
		mess = bo.addAdvice(advice);
		System.out.println(mess);
		return "advice";
	}
	
	// 退出
	public String exit(){
		ActionContext.getContext().getSession().clear(); 
		return "success";
	}
	
	
/* =============================================================== */
	
	
	
	public String getMess() {
		return mess;
	}

	

	public MessageBox getAdvice() {
		return advice;
	}

	public void setAdvice(MessageBox advice) {
		this.advice = advice;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public IBo_zjc getBo() {
		return bo;
	}

	public void setBo(IBo_zjc bo) {
		this.bo = bo;
	}

	
	public PatMasterIndex getPatMasterIndex() {
		return patMasterIndex;
	}

	public void setPatMasterIndex(PatMasterIndex patMasterIndex) {
		this.patMasterIndex = patMasterIndex;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
