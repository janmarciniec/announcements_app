/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jm.projekt_PAI.controllers;

import com.jm.projekt_PAI.dao.AnnouncementDao;
import com.jm.projekt_PAI.dao.UserDao;
import com.jm.projekt_PAI.entity.Announcement;
import com.jm.projekt_PAI.entity.User;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

/**
 *
 * @author emjan
 */
@Controller
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AnnouncementDao announcementDao;

    @GetMapping("/login")
    public String loginPage() {
        //zwrócenie nazwy widoku logowania - login.html
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model m) {
        //dodanie do modelu nowego użytkownika
        m.addAttribute("user", new User());
        //zwrócenie nazwy widoku rejestracji - register.html
        return "register";
    }

    @PostMapping("/register")
    public String registerPagePOST(@ModelAttribute(value = "user") @Valid User user, BindingResult binding) {
        
        if (binding.hasErrors()) {
            return "register"; // powrót do formularza
        }
        
        Iterable<User> users = userDao.findAll();
        List<String> logins = new ArrayList<String>();
        for(User user1: users){
            logins.add(user1.getLogin());
        }
        
        if(logins.contains(user.getLogin())) {
            return "register";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.save(user);
            //przekierowanie do adresu url: /login
            return "redirect:/login";
        }
    }

    @GetMapping("/profile")
    public String profilePage(Model m, Principal principal) {
        User user = userDao.findByLogin(principal.getName());
        
        //dodanie do modelu obiektu user - aktualnie zalogowanego użytkownika:
        m.addAttribute("user", user);
                
        List<Announcement> announcementsList = new ArrayList<Announcement>();
        
        Iterable<Announcement> announcements = announcementDao.findAll();
        for(Announcement announcement: announcements){
            if(announcement.getUserid() == user.getUserid()) {
                announcementsList.add(announcement);
            }
        }
        
        m.addAttribute("announcementsList", announcementsList);
        
        return "profile";
    }

    @GetMapping("/edit")
    public String editProfile(Model m, Principal principal) {
        //dodanie do modelu obiektu user - aktualnie zalogowanego użytkownika:
        m.addAttribute("user", userDao.findByLogin(principal.getName()));
        //zwrócenie nazwy widoku edycji profilu użytkownika - edit.html
        return "edit";
    }

    @PostMapping("/update")
    public String updateProfile(@ModelAttribute(value = "user") @Valid User user, BindingResult binding) {
        
        if (binding.hasErrors()) {
            return "edit"; // powrót do formularza
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //User user = dao.findByLogin(principal.getName());
        userDao.save(user);
        return "redirect:profile";
    }

    @GetMapping("/delete")
    public String deleteProfile(Principal principal) {
        User user = userDao.findByLogin(principal.getName());
        userDao.delete(user);
        
        // usunięcie wszystkich ogłoszeń użytkownika
        Iterable<Announcement> announcements = announcementDao.findAll();
        for(Announcement announcement: announcements){
            if(announcement.getUserid() == user.getUserid()) {
                announcementDao.delete(announcement);
            }
        }

        return "redirect:logout";
    }
}