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
public class RedularUserRegestration implements Regesteration {
	SearchRUser searchRUser=new SearchRUser();
	
	@Override
	public void regester(AbstractUser regular) {
	    	
		if (searchRUser.searchRegularUser(regular.mobileNumber)==null) {
			dataBase.addRuser(regular);
		}
		else 
			System.out.print("ERROR:USER DATA IN DATABASE!!");	        
		// TODO Auto-generated method stub
		
	}
}
