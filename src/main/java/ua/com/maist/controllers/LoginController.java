package ua.com.maist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.maist.service.email.EmailSender;

/**
 * Created by dach1016 on 25.07.2017.
 * Controller for work with login.jsp
 */

@Controller
public class LoginController {

    @Autowired
    private EmailSender sender;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){

        sender.send("danil1996-96@mail.ru", "Test Maist", "Hello World. I am laughing!");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
