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
public class DriverRegesteration implements Regesteration {
    @Override
    public void regester(AbstractUser driver){
    	
		if (dataBase.searchDriver(driver.mobileNumber)==null && dataBase.searchPending(driver.mobileNumber)==null) {
			dataBase.addPending(driver);
		}
		else 
			System.out.print("ERROR:DRIVER DATA IN DATABASE!!");
		
	}
}