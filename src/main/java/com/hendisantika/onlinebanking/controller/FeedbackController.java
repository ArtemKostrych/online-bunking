package com.hendisantika.onlinebanking.controller;

import com.hendisantika.onlinebanking.entity.Feedback;
import com.hendisantika.onlinebanking.entity.User;
import com.hendisantika.onlinebanking.repository.FeedBackDao;
import com.hendisantika.onlinebanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedBackDao feedBackDao;

    @Autowired
    private UserService userService;


    @GetMapping
    public String getFeedback(Model model) {
        model.addAttribute("feedback", feedBackDao.findAll());
        return "newSite/feedback";
    }

    @RequestMapping(value = "/addFeedback", method = RequestMethod.POST)
    public String addFeedback(@ModelAttribute("text") String text, @RequestParam("mark") int mark, Principal principal)
    {
        Feedback feedback = new Feedback();
        feedback.setText(text);
        feedback.setMark(mark);

        User user = userService.findByUsername(principal.getName());
        feedback.setUser(user);
        feedBackDao.save(feedback);
        return "redirect:/feedback";
    }
}
