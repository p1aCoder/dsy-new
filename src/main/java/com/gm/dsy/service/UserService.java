package com.gm.dsy.service;

import com.gm.dsy.dao.UserDAO;
import com.gm.dsy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User findByUser(String username){
        return userDAO.findByUsername(username);
    }

    public boolean isExist(String username){
        User user=userDAO.findByUsername(username);
        return null != user;
    }

    public User get(String username,String password){
        return userDAO.findByUsernameAndPassword(username,password);
    }

    public void add(User user){
        userDAO.save(user);
    }

}
