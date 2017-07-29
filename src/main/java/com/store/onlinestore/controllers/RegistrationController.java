package com.store.onlinestore.controllers;

import com.store.onlinestore.model.entity.User;
import com.store.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dach1016 on 27.07.2017.
 *
 */

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@ModelAttribute("user") User user){
        if(userService.findUserByLogin(user.getLogin())!=null)
            return new ModelAndView("registration", "error", "Такой логин уже используеться");
        userService.saveUser(user);
        return new ModelAndView("login");
    }
}
