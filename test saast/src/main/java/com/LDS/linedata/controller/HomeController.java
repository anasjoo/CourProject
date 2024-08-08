package com.LDS.linedata.controller;


import com.LDS.linedata.user.User;
import com.LDS.linedata.user.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    userService UserService;

    @GetMapping("hi")
    public String bonjour() {
        return "bonjourr souhabi";
    }


}
