package com.armor.finalinterview.controllers;

import com.armor.finalinterview.models.Priority;
import com.armor.finalinterview.models.SupportTicket;
import com.armor.finalinterview.repositories.SupportRepository;
import com.armor.finalinterview.utilities.PriorityHoursPolicy;
import com.armor.finalinterview.utilities.ResponseTimePolicy;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;


@Controller
public class SupportController {
    private final SupportRepository supportDao;

    // constructor
    public SupportController(SupportRepository supportDao) {
        this.supportDao = supportDao;
    }

    // ensure that all strings received from form are trimmed for whitespace
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }

    @GetMapping("/")
    public String landing() {
        return "landing";
    }

    @GetMapping("/support")
    public String getSupportForm(Model viewModel) {
        // pass to the view
        viewModel.addAttribute("supportTicket", new SupportTicket());
        viewModel.addAttribute("priorityEnum", Priority.values());

        return "support";
    }

    @PostMapping("/support")
    public String postSupportForm(
            @Valid SupportTicket supportTicket,
            Errors validation,
            Model model
    ) {

        // VALIDATION
        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("supportTicket", supportTicket);
            return "support";
        }

        supportDao.save(supportTicket);


        return "redirect:/support/submitted/" + supportTicket.getId();
    }

    @GetMapping("/support/submitted/{id}")
    public String getSupportSubmitted(@PathVariable long id, Model model) {
        SupportTicket supportTicket = supportDao.findOne(id);
        PriorityHoursPolicy priorityHoursPolicy = new PriorityHoursPolicy();

        // check to see what priority this ticket has and assign appropriate number of hours
        int hours = priorityHoursPolicy.convertPriorityToHours(supportTicket.getPriority());

        // pass hours to the view
        model.addAttribute("hours", hours);

        // update response time
        ResponseTimePolicy responseTimePolicy = new ResponseTimePolicy();
        SupportTicket newSupportTicket = responseTimePolicy.getResponseTime(hours, supportTicket);

        // save new support ticket to database
        supportDao.save(newSupportTicket);

        return "confirmation";
    }

}
