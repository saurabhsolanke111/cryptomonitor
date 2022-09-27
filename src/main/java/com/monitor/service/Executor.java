package com.monitor.service;

import com.monitor.dao.PriceDAO;
import com.monitor.dao.UserDAO;
import com.monitor.entities.EmailDetails;
import com.monitor.entities.User;

public class Executor {

    public void updateCoinValue(double value){
        // insert value into the database
        new PriceDAO().insertPriceD(value);
        // send alert to the user
        alert(value);
    }

    public void alert(double value){
        // Only user from the database :
        try {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUser(1);
            EmailService emailService = new EmailService();
            if(value < user.getMinAlertVal()){
                //Send Alert
                EmailDetails emailDetails = new EmailDetails();
                emailDetails.setSubject("Bitcoin price alert");
                emailDetails.setMsgBody(" Bitcoin Down, current price "+value);
                emailDetails.setRecipient(user.getEmail());
                emailService.send(emailDetails);
                System.out.println("#################  down ####################### "+value);
            } else if(value > user.getMaxAlertVal()){
                EmailDetails emailDetails = new EmailDetails();
                emailDetails.setSubject("Bitcoin price alert");
                emailDetails.setMsgBody(" Bitcoin Down, current price "+value);
                emailDetails.setRecipient(user.getEmail());
                emailService.send(emailDetails);
                System.out.println("#################  up ####################### "+value);
            } else {
                System.out.println("#################  no alert #######################");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
