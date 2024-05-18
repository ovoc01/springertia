package com.springertia.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.noar.inert.js.annotation.InertiaRender;

@Controller
public class InertiaDemoController {
    
    @GetMapping("/")
    @InertiaRender(view = "Home")
    public ModelAndView index() {
        return null;
    }
}
