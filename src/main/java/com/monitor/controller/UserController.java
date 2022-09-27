package com.monitor.controller;

import com.monitor.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    /*
    * not the perfect way to update the information
    * but here we are using only one user for ref...
    * */
    @GetMapping("/updateUser")
    public String updateUser(@RequestParam double max, @RequestParam double min){
        new UserService().updateUserDetails(max, min);
        return "Successfully updated user information";

    }
}
