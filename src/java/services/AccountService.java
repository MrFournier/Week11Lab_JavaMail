/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.UserDB;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author awarsyle
 */
public class AccountService {

    UserDB userDB;
    
    public AccountService() {
        UserDB userDB = new UserDB();
    }
    
    public User login(String username, String password, String path) {
        try {
            User user = userDB.getUser(username);

            if (user.getPassword().equals(password)) {
                // successful login
                Logger.getLogger(AccountService.class.getName())
                        .log(Level.INFO, "User {0} logged in.", user.getUsername());
                
                // send email upon successful login
                //GmailService.sendMail(user.getEmail(), "Notes App Login",
                //        "Hi " + user.getFirstname() + "\nYou just logged in.", false);
                String email = user.getEmail();
                String subject = "Notes App Login";
                String template = path + "/emailtemplates/login.html";
                
                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", user.getFirstname());
                tags.put("date", ((new java.util.Date())).toString());
                
                GmailService.sendMail(email, subject, template, tags);
                
                return user;
            }
        } catch (Exception e) {

        }

        return null;
    }
    
    public boolean forgotPassword(String email, String path) {
        
        UserService us = new UserService();
        
        User user = us.getByEmail(email);
        
        HashMap<String, String> tagsMap = new HashMap();
        
        tagsMap.put("username", user.getUsername());
        tagsMap.put("firstname", user.getFirstname());
        tagsMap.put("lastname", user.getLastname());
        tagsMap.put("password", user.getPassword());
        
        GmailService.sendMail(email, "Email Reset", path, tagsMap);
        
        return true;
    }
    
    public boolean resetPassword(String email, String path, String url) {
        
        String uuid = UUID.randomUUID().toString();
        
        String link = url + "?uuid=" + uuid;

        UserService us = new UserService();
        
        User user = us.getByEmail(email);
        
        user.setResetPasswordUUID(uuid);
        
        HashMap<String, String> tagsMap = new HashMap();
        
        tagsMap.put("firstname", user.getFirstname());
        tagsMap.put("lastname", user.getLastname());
        tagsMap.put("link", link);
        
        GmailService.sendMail(email, "Email Reset", path, tagsMap);
        
        return true;
    }
    
    public boolean changePassword(String uuid, String password) {
        UserService us = new UserService();
        try {
            User user = us.getByUUID(uuid);
            user.setPassword(password);
            user.setResetPasswordUUID(null);
            UserDB ur = new UserDB ();
            ur.update(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
