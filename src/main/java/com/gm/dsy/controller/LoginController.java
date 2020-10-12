package com.gm.dsy.controller;

import com.gm.dsy.pojo.User;
import com.gm.dsy.result.Result;
import com.gm.dsy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @Autowired
    UserService userService;


    @CrossOrigin
    @PostMapping("api/login")
    public Result login(@RequestBody User user){
        User requestUser=userService.get(user.getUsername(),user.getPassword());
        if(requestUser==null){
            return new Result(400);
        }else {
            return new Result(200);
        }
    }

}
