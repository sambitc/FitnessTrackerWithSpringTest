/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sambitc
 */
@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";
    }

    @RequestMapping(value = "loginFailed", method = RequestMethod.GET)
    public String loginFailed(ModelMap model) {
        model.addAttribute("error", "true");

        return "login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "logout";
    }

    @RequestMapping(value = "403", method = RequestMethod.GET)
    public String error403(ModelMap model) {
        return "403";
    }

    @RequestMapping(value = "405", method = RequestMethod.POST)
    public String error405(ModelMap model) {
        System.out.println("--------------inside 405");
        return "405";
    }

}
