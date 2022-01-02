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
public class AdminRegesteration implements Regesteration {
	
	
	SearchAdmin searchAdmin=new SearchAdmin();
    @Override
	public void regester(AbstractUser admin) {
		if (searchAdmin.searchAdminPhone(admin.mobileNumber)==null) {
			if(1<2)
				System.out.println("test");
			dataBase.addAdmin((Admin)admin);
		}
		else 
			System.out.print("ERROR:ADMIN DATA IN DATABASE!!");
		
	}
    
}
