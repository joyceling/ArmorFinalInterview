package com.armor.finalinterview.controllers;

import com.armor.finalinterview.LocalDateTimeAttributeConverter;
import com.armor.finalinterview.Priority;
import com.armor.finalinterview.models.SupportTicket;
import com.armor.finalinterview.repositories.SupportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

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
        // pass to the view
        viewModel.addAttribute("supportTicket", new SupportTicket());
        viewModel.addAttribute("priorityEnum", Priority.values());

        return "support";
    }

    @PostMapping("/support")
    public String postSupportForm (
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
    public String getSupportSubmitted (@PathVariable long id, Model model) {

        SupportTicket supportTicket = supportDao.findOne(id);
        Priority priority = supportTicket.getPriority();

        // check to see what priority this ticket has and assign appropriate number of hours
        int hours = 0;
        switch (priority.toString()) {
            case "LOW":
                hours = 48;
                break;
            case "MEDIUM":
                hours = 24;
                break;
            case "HIGH":
                hours = 4;
                break;
        }

        // pass hours to the view
        model.addAttribute("hours", hours);

        // convert Date to LocalDateTime
        LocalDateTimeAttributeConverter converter = new LocalDateTimeAttributeConverter();
        LocalDateTime localDateTime = converter.convertToEntityAttribute(new Timestamp(supportTicket.getDate().getTime()));
        // add the appropriate number of hours using built in LocalDateTime method
        LocalDateTime newDateTime = localDateTime.plusHours(hours);
        // convert localdate back to date via timestamp
        Date date = new Date (converter.convertToDatabaseColumn(newDateTime).getTime());
        // save response time (current time + response time) to current support ticket
        supportTicket.setResponseTimeAlert(date);
        // save support ticket to database
        supportDao.save(supportTicket);

        return "confirmation";
    }

}
