package com.hendisantika.onlinebanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myprofile")
public class ProfileController {

    @GetMapping
    public String getProfile() {
        return "newSite/myprofile";
    }
}
