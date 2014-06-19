package bo;

import model.lhb.PatMasterIndex;

public interface IBo_zjc
{
	String verify(String userName, String passWord);
	
	String addRegister(PatMasterIndex patMasterIndex);
}
