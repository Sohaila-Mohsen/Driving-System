/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingsystem;

/**
 *
 * @author kingston
 */
public class AdminControler  {
    private Admin A ;

    public AdminControler(Admin A) {
        this.A = A;
    }
    
    public void listAllPending(){
        A.DataBase.listPendding();
    }

    public void verify(int id){
        Driver driver = A.searchDriver.searchPennding(id);
        if(driver==null)
            System.out.println("Driver Not Found");
        else{
            A.DataBase.removePending(driver);
            A.DataBase.addDriver(driver);
            driver.setStatue(DriverStatue.ACTIVE);
        }
    }
    public void suspendDriver(int id){
         Driver driver = A.searchDriver.searchDriver(id);
         driver.setStatue(DriverStatue.SUSPENDED);
    }
    
    public void RejectPending(int id){
        Driver driver = A.searchDriver.searchPennding(id);
        A.DataBase.removePending(driver);
    }
    public void suspendRuser(int id){
        RegularUser user = A.searchRUser.searchUser(id);
        user.setStatue(UserStatue.SUSPENDED);
    }
    
}
