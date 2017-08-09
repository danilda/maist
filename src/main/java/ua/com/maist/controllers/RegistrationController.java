package ua.com.maist.controllers;

import ua.com.maist.model.entity.User;
import ua.com.maist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by dach1016 on 27.07.2017.
 */

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (userService.findUserByLogin(user.getLogin()) != null) {
            bindingResult.addError(new FieldError("user", "login", "Такой логин уже используеться"));
            return new ModelAndView("registration", "error", "Такой логин уже используеться");
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("registration", "error", bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        userService.saveUser(user);
        return new ModelAndView("login");
    }
}
