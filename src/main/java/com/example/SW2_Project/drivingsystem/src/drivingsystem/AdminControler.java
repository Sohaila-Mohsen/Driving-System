/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SW2_Project.drivingsystem.src.drivingsystem;

import java.util.ArrayList;

/**
 *
 * @author kingston
 */
public class AdminControler {
    private Admin A;

    public AdminControler(Admin A) {
        this.A = A;
    }

    public void listAllPending() {
        A.DataBase.listPendding();
    }

    public void listAllEvents() {
        A.DataBase.listEvents();
    }

    public void verify(int id) {
        Driver driver = A.searchDriver.searchPennding(id);
        if (driver == null)
            System.out.println("Driver Not Found");
        else {
            A.DataBase.removePending(driver);
            A.DataBase.addDriver(driver);
            driver.setStatue(DriverStatue.ACTIVE);
        }
    }

    public void suspendDriver(int id) {
        Driver driver = A.searchDriver.searchDriver(id);
        driver.setStatue(DriverStatue.SUSPENDED);
    }

    public void addDiscountArea(String area) {
        boolean exists = false;
        for (int i = 0; i < A.DataBase.getDiscountAreas().size(); i++) {
            String get = A.DataBase.getDiscountAreas().get(i);
            if (get.equalsIgnoreCase(area)) {
                exists = true;
                break;
            }
        }
        if (!exists)
            A.DataBase.addArea(area);
        else
            System.out.println("Area already exists");
    }

    public void RejectPending(int id) {
        Driver driver = A.searchDriver.searchPennding(id);
        A.DataBase.removePending(driver);
    }

    public boolean suspendRuser(int id) {

        RegularUser user = A.searchRUser.searchUser(id);
        if (user != null) {
            user.setStatue(UserStatue.SUSPENDED);
            return true;
        } else
            return false;
    }

    public ArrayList<String> ListPending() {
        return A.DataBase.ListAllPendding();
    }

    public boolean SuspendDriver(int id) {
        Driver driver = A.searchDriver.searchDriver(id);
        if (driver == null)
            return false;
        driver.setStatue(DriverStatue.SUSPENDED);
        return true;
    }

    public String addDArea(String area) {
        boolean exists = false;
        for (int i = 0; i < A.DataBase.getDiscountAreas().size(); i++) {
            String get = A.DataBase.getDiscountAreas().get(i);
            if (get.equalsIgnoreCase(area)) {
                exists = true;
                break;
            }
        }
        if (!exists){
            A.DataBase.addArea(area);
            return "Area Added Successfuly";
        }
        else
            return"Area already exists";
    }

    public String verifyDriver(int id) {
        Driver driver = A.searchDriver.searchPennding(id);
        if (driver == null)
            return "Driver Not Found";
        else {
            A.DataBase.removePending(driver);
            A.DataBase.addDriver(driver);
            driver.setStatue(DriverStatue.ACTIVE);
            return "Driver Verified Successfuly";
        }
    }

    public String RemovePending(int id) {
        Driver driver = A.searchDriver.searchPennding(id);
        if(driver==null)
            return"Driver Not Found";
        AbstractUser.DataBase.removePending(driver);
        return "Request Removed Successfuly";
    }

}
