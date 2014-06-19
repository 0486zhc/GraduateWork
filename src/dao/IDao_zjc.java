package dao;

import model.lhb.PatMasterIndex;

public interface IDao_zjc
{
	String verify(String userName, String passWord);
	
	String getMaxPatientId();
	
	boolean savePatientInfo(PatMasterIndex patMasterIndex);
}
