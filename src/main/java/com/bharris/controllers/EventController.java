package com.bharris.controllers;

import com.bharris.entities.User;
import com.bharris.services.UserRepository;
import com.bharris.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Controller
public class EventController {
    @Autowired
    UserRepository users;

    @RequestMapping(path="/dash", method = RequestMethod.GET)
    public String dashboard(HttpSession session, Model model){
        System.out.println("GOT HERE");
        return "dashboard";
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public String login(HttpSession session, String login_username, String login_password, HttpServletResponse response) throws Exception {
        User user = users.findFirstByUsername(login_username);
        if(user == null) {
            response.sendRedirect("/");
        }else if (user.verifyPassword(login_password)){
            session.setAttribute("userName", login_username);
            return "redirect:/dash";
        }else {
            throw new Exception("Incorrect login information");
        }
        return "redirect:/dash";
    }

    @RequestMapping(path="/register", method = RequestMethod.POST)
    public String registerAccount(HttpSession session, String create_username, String create_password, String first_name, String email, HttpServletResponse response) throws Exception {
        User user = users.findFirstByUsername(create_username);
        if(user != null) {
            throw new Exception("Username is taken");
        }else {
            user = new User(create_username, create_password, first_name, email);
            session.setAttribute("userName", create_username);
            users.save(user);
        }

        return "redirect:/dash";
    }
}
