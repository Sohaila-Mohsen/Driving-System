package com.example.SW2_Project.drivingsystem.src.drivingsystem;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AdminAPI {
    Admin X=new Admin();
    Admin A=new Admin();
    Driver D=new Driver();



    @PostMapping("/admin/suspendRUser/{id}")
    String suspendRUser(@PathVariable int id)
    {
        if(Admin.controler.suspendRuser(id))
            return "Suspending has Done";
        else
            return"SomeThing went wrong at suspending";
    }


    @PostMapping("/admin/listPending")    
    ArrayList<String> PenddingList(){
        return Admin.controler.ListPending();
    }

    @PostMapping("/admin/listUsers")  
    ArrayList<String> UserList(){
        return Admin.DataBase.ListRuser();
    }
    
    @PostMapping("/admin/SusspendDriver/{id}")  
    String  SuspendDriver(@PathVariable int id){
        if(Admin.controler.SuspendDriver(id))
            return "Driver susspended succesfully";
        else
            return "some thing went wrong"; 
    }
    @PostMapping("/admin/listEvents")  
    ArrayList<String> EventList(){
        return Admin.DataBase.ListEvents();
    }

    @PostMapping("/admin/addDiscountArea/{area}")  
    String  AddDiscountArea(@PathVariable String area){
        return (Admin.controler.addDArea(area));
    }

    @PostMapping("/admin/acceptDriver/{id}")  
    String  acceptDriver(@PathVariable int id){
        return Admin.controler.verifyDriver(id);
    }

    
    @PostMapping("/admin/rejectDriver/{mobile}/{id}")  
    String  rejectDriver(@PathVariable String mobile,@PathVariable int id){
        if(SearchAdmin.searchAdminPhone(mobile)==null)
        return "Admin Not Found";
        else if (SearchAdmin.searchAdminPhone(mobile).isLogedIn()){
            Admin A = (Admin) SearchAdmin.searchAdminPhone(mobile);
            return A.getControler().RemovePending(id);
        }
        else
        return "Login First";
    }
    


    
/*
    if(SearchRUser.searchRegularUser(mobile)==null)
        return "User Not Found";
        else if (SearchRUser.searchRegularUser(mobile).isLogedIn()){
            RegularUser U = (RegularUser) SearchRUser.searchRegularUser(mobile);
            U.getConroler().requestRide(source,des,num);
            return "Ride Requested Sucssfuly ";
        }
        else
        return "Login First";
    A.DataBase.listRuser();

    ((Admin)A).controler.suspendDriver(id);

    ((Admin)A).controler.RejectPending(id);

    x.controler.listAllPending();

    ((Admin)A).controler.verify(id);


    x.controler.listAllEvents();

    ((Admin)A).controler.addDiscountArea(area);
    */

    
    
}
