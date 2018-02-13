package com.armor.finalinterview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportController {

    @GetMapping("/")
    public String supportLanding () {

        return "index";
    }

}
