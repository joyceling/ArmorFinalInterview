package com.armor.finalinterview.models;

import com.armor.finalinterview.Priority;
import com.armor.finalinterview.Status;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="support")
public class SupportTicket {
    @Id @GeneratedValue
    private long id;

    @Column(name = "DATETIME_FIELD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String subject;

    @Column(nullable = false, length = 5000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String responseTimeAlert;

    public SupportTicket () {
        this.status = Status.NEW;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Date getDatetimeField() {
        return date;
    }

    public void setDatetimeField(Date datetimeField) {
        this.date = datetimeField;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setResponseTimeAlert(String responseTimeAlert) {
        this.responseTimeAlert = responseTimeAlert;
    }

    public String getResponseTimeAlert() {
        return responseTimeAlert;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
