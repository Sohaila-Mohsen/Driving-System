package com.drivingsystem.src.drivingsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class AdminAPI {
    @PostMapping("/admin/suspendRUser/{id}")
    String suspendRUser(@PathVariable int id)
    {
        if(Admin.controler.suspendRuser( id))
            return "Suspending has Done";
        else
            return"SomeThing went wrong at suspending";
    }
}
