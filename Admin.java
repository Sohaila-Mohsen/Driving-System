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
public class Admin extends AbstractUser{
    void register(Admin admin) {
        
    }

    public void listAllPending(){
        DataBase.listPendding();
    }
    //   void verify(){
//       DataBase.listDrivers();
//
//    }
    public void verify(int id){
        Driver driver = DataBase.searchPennding(id);
        DataBase.removePending(driver);
        DataBase.addDriver(driver);
        driver.setStatue(DriverStatue.ACTIVE);
    }
    public void suspendDriver(int id){
         Driver driver = DataBase.searchDriver(id);
         driver.setStatue(DriverStatue.SUSPENDED);
    }
    
    public void RejectPending(int id){
        Driver driver = DataBase.searchPennding(id);
        DataBase.removePending(driver);
   }
    
    ///////////
    public void suspendRuser(int id){
    	AbstractUser user=new RegularUser();
        user = DataBase.searchUser(id);
       // user.setStatue(UserStatue.SUSPENDED);
    }
    
}
