package com.DelhiLabourWebAppAdmin.controller;
import com.DelhiLabourWebAppAdmin.DTO.LoginDTO;
import com.DelhiLabourWebAppAdmin.model.Admin;
import com.DelhiLabourWebAppAdmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {
    @Autowired
    HttpSession hs;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(@RequestBody LoginDTO loginDTO) {
        try {
            System.out.println("working");
            Admin admin = userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
            if (admin != null) {
                loginSuccess(loginDTO.getUsername());
                System.out.println("logged in");
                return "dashboard";
            }
            return "error";
        }catch(Exception e){
                return "error";
            }
    }

    public void loginSuccess(String User) {
        try {
                hs.setAttribute("username", User);
                hs.setAttribute("session", hs);
            }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
