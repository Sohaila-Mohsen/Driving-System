package drivingsystem;

public interface  Login {
	
	DB data=DB.getDatabase();
	public AbstractUser verifyInformation(String phone ,String password);
}
