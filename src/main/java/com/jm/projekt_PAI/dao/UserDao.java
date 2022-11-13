/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jm.projekt_PAI.dao;

import com.jm.projekt_PAI.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author emjan
 */
public interface UserDao extends CrudRepository<User, Integer> {
    public User findByLogin(String login);
}
