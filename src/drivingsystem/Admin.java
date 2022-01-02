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
public class Admin extends AbstractUser{
	
	SearchDriver searchDriver=new SearchDriver();
	SearchRUser searchRUser=new SearchRUser();
        AdminControler controler;

    public Admin() {
        this.controler = new AdminControler(this);
    }
        
	
    void register(Admin admin) {
        
    }

    
}
