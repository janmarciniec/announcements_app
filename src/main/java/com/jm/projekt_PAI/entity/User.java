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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author emjan
 */
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;
    
    @NotNull(message="Pole Imię nie może być puste")
    @Pattern(regexp = "[a-zA-Z]{2,30}", message="Podaj poprawne imię")
    private String name;
    
    @NotNull(message="Pole Nazwisko nie może być puste")
    @Pattern(regexp = "[a-zA-Z]{2,30}", message="Podaj poprawne nazwisko")
    private String surname;
    
    @NotNull(message="Pole Login nie może być puste")
    @Size(min=2, max=30, message="Login musi zawierać od 2 do 30 znaków")
    private String login;
    
    @NotNull(message="Pole Hasło nie może być puste")
    @Size(min=4, message="Hasło musi się składać co najmniej z 4 znaków")
    private String password;

    public User() {
    }

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
