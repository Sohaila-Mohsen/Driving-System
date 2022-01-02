/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

import javax.jws.WebService;

/**
 *
 * @author DELL
 */
@WebService
public class DriverLogin implements Login{
    
    @Override
	public AbstractUser verifyInformation(String phone, String password) {
    	for (int i = 0; i < data.getDrivers().size(); i++) {
    		if(phone.equalsIgnoreCase(data.getDrivers().get(i).mobileNumber) && password.equalsIgnoreCase(data.getDrivers().get(i).password)) {
                        data.getDrivers().get(i).setLogedIn(true);
    			return data.getDrivers().get(i);
    		}
    	}
		return null;
	}
}
