package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Rafael on 16/06/2016.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error",required = false) String error,
                        @RequestParam(value = "logout",required = false) String logout,Model model){
        if(error!=null){
            model.addAttribute("error","Invalid username and password!");
        }

        if(logout!=null){
            model.addAttribute("msg","You have been logged successfully!");
        }

        return "login";
    }
}
