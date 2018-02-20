package com.armor.finalinterview;

import com.armor.finalinterview.models.Priority;
import com.armor.finalinterview.utilities.LocalDateTimeAttributeConverter;
import com.armor.finalinterview.utilities.PriorityHoursPolicy;
import com.armor.finalinterview.utilities.ResponseTimePolicy;

import org.junit.Test;
import org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.hamcrest.core.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FinalinterviewApplicationTests {

    @Test
    public void LocalDateConverterShouldConvertType() {
        LocalDateTimeAttributeConverter localDateTimeAttributeConverter = new LocalDateTimeAttributeConverter(); // Class to be tested

        // LocalDateTime
        LocalDateTime localDate1 = LocalDateTime.of(2018, 2, 19, 3, 30);
        LocalDateTime localDate2 = LocalDateTime.of(2018, 3, 19, 3, 30);
        LocalDateTime localDate3 = LocalDateTime.of(2018, 4, 19, 3, 30);

        // Timestamp Date
        Timestamp date1 = Timestamp.valueOf(localDate1);
        Timestamp date2 = Timestamp.valueOf(localDate2);
        Timestamp date3 = Timestamp.valueOf(localDate3);


        // assert statements
        // LocalDateTime to Timestamp


        assertEquals(date2, localDateTimeAttributeConverter.convertToDatabaseColumn(localDate2), "LocalDateTime should be converted to Timestamp");
        assertEquals(date3, localDateTimeAttributeConverter.convertToDatabaseColumn(localDate3), "LocalDateTime should be converted to Timestamp");

        // Timestamp to LocalDateTime
        assertEquals(localDate1, localDateTimeAttributeConverter.convertToEntityAttribute(date1), "Timestamp should be converted to LocalDateTime");
        assertEquals(localDate2, localDateTimeAttributeConverter.convertToEntityAttribute(date2), "Timestamp should be converted to LocalDateTime");
        assertEquals(localDate3, localDateTimeAttributeConverter.convertToEntityAttribute(date3), "Timestamp should be converted to LocalDateTime");
    }

    @Test
    public void priorityShouldChangeHours() {
        PriorityHoursPolicy priorityHoursPolicy = new PriorityHoursPolicy(); // Class to be tested

        // assert statements
        assertEquals(0, priorityHoursPolicy.convertPriorityToHours(Priority.NONE), "No priority must be 0");
        assertEquals(48, priorityHoursPolicy.convertPriorityToHours(Priority.LOW), "Low priority must be 48");
        assertEquals(24, priorityHoursPolicy.convertPriorityToHours(Priority.MEDIUM), "Medium priority must be 24");
        assertEquals(4, priorityHoursPolicy.convertPriorityToHours(Priority.HIGH), "High priority must be 4");
    }

    @Test
    public void responseTimeShouldBeCurrentTimePlusHours() {
        ResponseTimePolicy responseTimePolicy = new ResponseTimePolicy();



    }

}
