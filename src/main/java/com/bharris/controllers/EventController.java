package com.bharris.controllers;

import com.bharris.entities.User;
import com.bharris.services.UserRepository;
import com.bharris.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class EventController {
    @Autowired
    UserRepository users;

    @RequestMapping(name="/login")
    public void login(HttpSession session, String login_username, String login_password, HttpServletResponse response) throws Exception {
        User user = users.findFirstByUsername(login_username);
        if(user == null) {
            response.sendRedirect("/");
        }else if (!user.verifyPassword(login_password)){
            throw new Exception("Login Failed");
        }
        session.setAttribute("userName", login_username);
        response.sendRedirect("/");

    }

    @RequestMapping(name="/register")
    public void registerAccount(){

    }
}
