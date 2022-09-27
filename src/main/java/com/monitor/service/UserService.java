package com.monitor.service;

import com.monitor.dao.UserDAO;

public class UserService {

    public void updateUserDetails(double maxAlertVal, double minAlertVal){
        new UserDAO().updateUser(maxAlertVal, minAlertVal);
    }

}
