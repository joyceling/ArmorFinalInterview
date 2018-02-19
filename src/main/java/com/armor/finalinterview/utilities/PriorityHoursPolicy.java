package com.armor.finalinterview.utilities;

import com.armor.finalinterview.models.Priority;
import org.springframework.stereotype.Service;

@Service
public class PriorityHoursPolicy {
    public int convertPriorityToHours(Priority priority) {
        try {

            int hours = 0;

            switch (priority.toString()) {
                case "NONE":
                    hours = 0;
                    break;
                case "LOW":
                    hours = 48;
                    break;
                case "MEDIUM":
                    hours = 24;
                    break;
                case "HIGH":
                    hours = 4;
                    break;
                default:
                    hours = 0;
                    break;
            }

            return hours;

        } catch (NullPointerException e) {

            return 0;
        }
    }
}
