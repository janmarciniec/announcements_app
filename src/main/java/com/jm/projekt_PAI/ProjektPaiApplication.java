package com.jm.projekt_PAI;

import com.jm.projekt_PAI.dao.AnnouncementDao;
import com.jm.projekt_PAI.dao.UserDao;
import com.jm.projekt_PAI.entity.Announcement;
import com.jm.projekt_PAI.entity.User;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjektPaiApplication {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private AnnouncementDao announcementDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ProjektPaiApplication.class, args);
    }
}
