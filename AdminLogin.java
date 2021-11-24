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
public class AdminLogin implements Login{
    	@Override
	public AbstractUser verifyInformation(String phone, String password) {
    	for (int i = 0; i < data.getAdmins().size(); i++) {
    		if(phone==data.getAdmins().get(i).mobileNumber && password==data.getAdmins().get(i).password) {
    			return data.getAdmins().get(i);
    		}
    	}
		return null;
	}
}


