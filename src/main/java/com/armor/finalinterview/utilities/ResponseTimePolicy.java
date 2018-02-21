package com.armor.finalinterview.utilities;

import com.armor.finalinterview.models.SupportTicket;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ResponseTimePolicy {

    public SupportTicket getResponseTime (int hours, SupportTicket supportTicket) {
        try {

            // convert Date to LocalDateTime
            LocalDateTimeAttributeConverter converter = new LocalDateTimeAttributeConverter();
            LocalDateTime localDateTime = converter.convertToEntityAttribute(new Timestamp(supportTicket.getDate().getTime()));
            // add the appropriate number of hours using built in LocalDateTime method
            LocalDateTime newDateTime = localDateTime.plusHours(hours);
            // convert localdate back to date via timestamp
            Date date = new Date(converter.convertToDatabaseColumn(newDateTime).getTime());
            // save response time (current time + response time) to current support ticket
            supportTicket.setResponseTimeAlert(date);

            if (hours == 0) {
                supportTicket.setResponseTimeAlert(null);
            }

            return supportTicket;

        } catch (NullPointerException e) {

            return supportTicket;
        }
    }
}
