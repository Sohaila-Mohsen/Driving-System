package drivingsystem;

import javax.jws.WebService;

@WebService
public interface  Login {
	
	DB data=DB.getDatabase();
	public AbstractUser verifyInformation(String phone ,String password);
}
