package com.armor.finalinterview.controllers;

import com.armor.finalinterview.Priority;
import com.armor.finalinterview.models.SupportTicket;
import com.armor.finalinterview.repositories.SupportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;

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
    public String getSupportForm (Model viewModel) {
        viewModel.addAttribute("supportTicket", new SupportTicket());
        viewModel.addAttribute("priorityEnum", Priority.values());

        Calendar calendar = Calendar.getInstance();
        java.util.Date now = calendar.getTime();
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

        viewModel.addAttribute("timestamp", currentTimestamp);

        return "support";
    }

    @PostMapping("/support/create")
    public String postSupportForm (@ModelAttribute SupportTicket supportTicket) {

        supportDao.save(supportTicket);

        return "redirect:/support";
    }

}
