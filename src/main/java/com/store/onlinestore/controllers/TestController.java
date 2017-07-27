package com.store.onlinestore.controllers;

import com.store.onlinestore.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dach1016 on 26.07.2017.
 * Test controller for test.jsp/user.jsp/admin.jsp
 */

@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        return  modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        System.out.println(user.getRoles());
        return modelAndView;
    }

    @RequestMapping(value = "/access-denied")
    public ModelAndView accessDenied(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/access-denied");
        return modelAndView;
    }

}
