package com.vue.inertiajs.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.noar.inert.js.annotation.InertiaRender;
import com.noar.inert.js.core.Inertia;
import com.vue.inertiajs.demo.controller.model.UserForm;



@Controller
public class UserController {
    

    @GetMapping("/")
    @InertiaRender(view = "User")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", "John Doe");
        modelAndView.addObject("user2", "Jane Doe");

        return modelAndView;
    }

    @GetMapping("/forms")
    @InertiaRender(view = "Form")
    public ModelAndView forms(){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @PostMapping("/users")
    @InertiaRender(view = "User")
    public ModelAndView store(@RequestBody UserForm userForm){
        System.out.println(userForm);
    
        return new ModelAndView("redirect:/");
    }

    
}
