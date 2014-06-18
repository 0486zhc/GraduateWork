package action;

import bo.IBo_zjc;
import model.lhb.PatMasterIndex;

public class ZjcAction
{
	private PatMasterIndex patMasterIndex; 
	private IBo_zjc bo ;
	
	String mess ;
	String userName;
	String passWord;
	
	public String Login(){
		System.out.println("action");
		mess = bo.verify(userName,passWord);
		System.out.println(mess);
		return "success";
	}
	
	public String register(){
		System.out.println("register");
		mess = bo.addRegister(patMasterIndex);
		System.out.println(mess);
		return "success";
	}
	public String getMess() {
		return mess;
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
