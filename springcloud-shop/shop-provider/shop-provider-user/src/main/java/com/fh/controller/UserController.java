package com.fh.controller;

import com.fh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("userController")
@CrossOrigin
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("toLogin")
    public Map toLogin(String username,String password){
        return iUserService.toLogin(username,password);
    }

}
