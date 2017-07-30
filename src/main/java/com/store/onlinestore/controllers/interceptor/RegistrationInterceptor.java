package com.store.onlinestore.controllers.interceptor;

import com.store.onlinestore.model.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by danil on 30.07.2017.
 *
 */
public class RegistrationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getAttribute("user");
        if(user.getPassword().equals(httpServletRequest.getAttribute("passerror"))) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/registration?passerror=true");
            return false;
        } else {
            return true;
        }
    }

}
