package action.zjc;

import java.sql.Date;

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
		mess = bo.addRegister(patMasterIndex);
		System.out.println(mess);
		return "success";
	}
	
	public String advice(){
		System.out.println("advice");
		advice.setWriteDate(new Date(0));
		System.out.println(advice);
		mess = bo.addAdvice(advice);
		System.out.println(mess);
		return "advice";
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

}
