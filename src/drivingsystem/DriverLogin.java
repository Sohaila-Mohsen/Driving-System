/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

/**
 *
 * @author DELL
 */
public class DriverLogin implements Login{
    
    @Override
	public AbstractUser verifyInformation(String phone, String password) {
		// TODO Auto-generated method stub
    	for (int i = 0; i < data.getDrivers().size(); i++) {
    		if(phone==data.getDrivers().get(i).mobileNumber && password==data.getDrivers().get(i).password) {
    			return data.getDrivers().get(i);
    		}
    	}
		return null;
	}
}
