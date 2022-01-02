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
public class RegularUserLogin implements Login{
	@Override
	public AbstractUser verifyInformation(String phone, String password) {
    	for (int i = 0; i < data.getRegularUsers().size(); i++) {
    		if(phone.equalsIgnoreCase(data.getRegularUsers().get(i).mobileNumber) && password.equalsIgnoreCase(data.getRegularUsers().get(i).password)) {
    			data.getRegularUsers().get(i).setLogedIn(true);
    			return data.getRegularUsers().get(i);
    		}
    	}
		// TODO Auto-generated method stub
		return null;
	}
}
