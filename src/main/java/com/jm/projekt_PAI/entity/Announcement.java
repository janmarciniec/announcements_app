/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jm.projekt_PAI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author emjan
 */

@Entity
@Table(name = "Announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer announcementid;
    
    @NotBlank(message="Pole Tytuł nie może być puste")
//    @Size(min=5, message="Tytuł musi zawierać minimum 5 znaków")
    private String title;
    
    @NotBlank(message="Pole Opis nie może być puste")
//    @Size(min=5, max=200, message="Opis musi zawierać od 5 do 200 znaków")
    private String description;
    
    @NotNull(message="Pole Cena nie może być puste")
//    @Pattern(regexp = "^(0|[1-9][0-9]*)$", message="Podaj poprawną kwotę")
    private Integer price;
    
    @NotBlank(message="Pole Lokalizacja nie może być puste")
//    @Size(min=3, max=20, message="Opis musi zawierać od 3 do 20 znaków")
    private String location;
    
    @NotBlank(message="Pole Numer kontaktowy nie może być puste")
//    @Size(min=9, max=9, message="Numer telefonu musi składać się z 9 cyfr")
    @Pattern(regexp = "^[0-9]*$", message="Numer telefonu może składać się wyłącznie z cyfr")
    private String phone;
    
    private Integer userid;

    public Announcement() {
    }

    public Announcement(String title, String description, Integer price, String location, String phone, Integer userid) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.phone = phone;
        this.userid = userid;
    }

    public Integer getAnnouncementid() {
        return announcementid;
    }

    public void setAnnouncementid(Integer announcementid) {
        this.announcementid = announcementid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
