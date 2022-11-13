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
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author emjan
 */
@Controller
public class AnnouncementController {
    @Autowired
    private AnnouncementDao announcementDao;
    @Autowired
    private UserDao userDao;
    
    @GetMapping("/announcements")
    public String announcementsList(Model m, Principal principal) {
        m.addAttribute("user", userDao.findByLogin(principal.getName()));
        m.addAttribute("announcementsList", announcementDao.findAll());
        return "announcements";
    }
    
    @GetMapping("/add-announcement")
    public String addAnnouncement(Model m, Principal principal) {
        m.addAttribute("user", userDao.findByLogin(principal.getName()));
        m.addAttribute("announcement", new Announcement());
        return "add-announcement";
    }

    @PostMapping("/add-announcement")
    public String addAnnouncementPOST(@ModelAttribute(value = "announcement") @Valid Announcement announcement, BindingResult binding, Model m, Principal principal) {
        
        if (binding.hasErrors()) {
            m.addAttribute("user", userDao.findByLogin(principal.getName()));
            return "add-announcement"; // powrót do formularza
        }

        // ustawienie id użytkownika dla dodanego ogłoszenia jako id zalogowanego użytkownika
        announcement.setUserid(userDao.findByLogin(principal.getName()).getUserid());
        announcementDao.save(announcement);
        return "redirect:/profile";
    }
    
    @GetMapping("/edit-announcement/{announcementid}")
    public String editAnnouncement(Model m, @PathVariable Integer announcementid, Principal principal) {
        
        User user = userDao.findByLogin(principal.getName());
        Announcement announcement = announcementDao.findById(announcementid).get();
        
        m.addAttribute("user", user);
        
        if(user.getUserid() == announcement.getUserid()) {
            m.addAttribute("announcement", announcement);
            return "edit-announcement";
        } else {
            return "error-page";
        }
    }

    @PostMapping("/update-announcement")
    public String updateAnnouncement(@ModelAttribute(value = "announcement") @Valid Announcement announcement, BindingResult binding, Model m, Principal principal) {
        if (binding.hasErrors()) {
            m.addAttribute("user", userDao.findByLogin(principal.getName()));
            return "edit-announcement"; // powrót do formularza
        }
        
        announcement.setUserid(userDao.findByLogin(principal.getName()).getUserid());
        announcementDao.save(announcement);
        return "redirect:/profile";
    }
    
    @GetMapping("/delete-announcement/{announcementid}")
    public String deleteAnnouncement(@PathVariable Integer announcementid, Model m, Principal principal) {
        User user = userDao.findByLogin(principal.getName());
        Announcement announcement = announcementDao.findById(announcementid).get();
        
        m.addAttribute("user", user);
        
        if(user.getUserid() == announcement.getUserid()) {
            announcementDao.delete(announcement);
            return "redirect:/profile";
        } else {
            return "error-page";
        }
    }
}
