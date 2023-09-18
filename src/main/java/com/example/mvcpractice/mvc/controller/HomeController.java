package com.example.mvcpractice.mvc.controller;

import com.example.mvcpractice.mvc.annotation.Controller;
import com.example.mvcpractice.mvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController{

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "home";
    }
}
