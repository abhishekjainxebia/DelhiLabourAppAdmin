package com.DelhiLabourWebAppAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class URLController  {
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        HttpSession session =request.getSession();
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/")
    public String admin(Model model){
       model.addAttribute("name","hello");
       return "admin";
    }



}


