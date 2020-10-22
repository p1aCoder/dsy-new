package com.gm.dsy.controller;

import com.gm.dsy.pojo.User;
import com.gm.dsy.result.Result;
import com.gm.dsy.result.ResultFactory;
import com.gm.dsy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;


@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("api/login")
    public Result login(@RequestBody User user){
        String username=user.getUsername();
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,user.getPassword());

        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(username);
        } catch (AuthenticationException e) {
            return ResultFactory.buildFailureResult("账号密码错误");
        }
    }

    @PostMapping("api/register")
    public Result register(@RequestBody User user){
        String username=user.getUsername();
        String password=user.getPassword();
        username= HtmlUtils.htmlEscape(username);

        if (userService.isExist(username)){
            return ResultFactory.buildFailureResult("用户名已存在");
        }

        String salt=new SecureRandomNumberGenerator().nextBytes().toString();

        String encodedPassword=new SimpleHash("md5",password,salt,2).toString();
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);

    }

    @GetMapping("api/logout")
    public Result logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return ResultFactory.buildSuccessResult("成功登出");
    }

}
