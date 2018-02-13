package com.armor.finalinterview.controllers;

import com.armor.finalinterview.repositories.SupportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SupportController {
    private final SupportRepository supportDao;

    public SupportController (SupportRepository supportDao) {
        this.supportDao = supportDao;
    }

    @GetMapping("/")
    public String landing () {
        return "landing";
    }

    @GetMapping("/support")
    public String getSupportForm () {

        return "support-form";
    }

    @PostMapping("/support")
    public String postSupportForm () {

        return "support-form";
    }

}
