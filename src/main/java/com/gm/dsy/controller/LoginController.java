package com.gm.dsy.controller;

import com.gm.dsy.pojo.User;
import com.gm.dsy.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @CrossOrigin
    @PostMapping("api/login")
    public Result login(@RequestBody User user){
        if(!"admin".equals(user.getUsername()) || !"123".equals(user.getPassword())){
            return new Result(400);
        }else {
            return new Result(200);
        }
    }

}
