package com.hendisantika.onlinebanking.controller;

import com.hendisantika.onlinebanking.entity.PrimaryAccount;
import com.hendisantika.onlinebanking.entity.User;
import com.hendisantika.onlinebanking.service.TransactionService;
import com.hendisantika.onlinebanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.security.Principal;

@Controller
public class ReplenishmentController {

    @Autowired
    private UserService userService;


    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/replenishment")
    public String getFeedback() {
        return "newSite/replenishment";
    }

    @RequestMapping( value = "replenishment/replenish", method = RequestMethod.POST)
    public String replenish(@ModelAttribute("amount") int amount,
                            @ModelAttribute("phoneNumber") String phoneNumber,
                            Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        if (primaryAccount.getAccountBalance().compareTo(new BigDecimal(amount))<0) {
            return "redirect:/transfer?error";
        }

        transactionService.replenish(phoneNumber, amount, primaryAccount);

        return "redirect:/account";
    }
}
