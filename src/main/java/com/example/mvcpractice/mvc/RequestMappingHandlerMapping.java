package com.example.mvcpractice.mvc;

import com.example.mvcpractice.mvc.controller.Controller;
import com.example.mvcpractice.mvc.controller.HomeController;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    void init() {
        mappings.put("/", new HomeController());

    }

    public Controller findHandler(String urlPath) {
        return mappings.get(urlPath);
    }
}