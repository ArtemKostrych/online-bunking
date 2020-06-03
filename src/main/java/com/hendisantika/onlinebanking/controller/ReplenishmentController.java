package com.hendisantika.onlinebanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/replenishment")
public class ReplenishmentController {
    @GetMapping
    public String getFeedback() {
        return "newSite/replenishment";
    }
}
