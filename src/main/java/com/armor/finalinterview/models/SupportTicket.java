package com.armor.finalinterview.models;

import com.armor.finalinterview.Priority;
import com.armor.finalinterview.Status;
import org.apache.tomcat.jni.Local;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="support")
public class SupportTicket {
    @Id @GeneratedValue
    private long id;

    @Column(name = "date")
    private Date date = new Date();

    @NotBlank(message = "This field cannot be blank.")
    @Column(nullable = false, length = 100)
    private String firstName;

    @NotBlank(message = "This field cannot be blank.")
    @Column(nullable = false, length = 100)
    private String lastName;

    @Email (message="Email must match the following format: youremail@website.com.")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address.")
    @Column(nullable = false, length = 100)
    private String email;

    @NotBlank(message = "This field cannot be blank.")
    @Column(nullable = false, length = 100)
    private String subject;

    @NotBlank(message = "This field cannot be blank.")
    @Column(nullable = false, length = 5000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private Date responseTimeAlert;

    public SupportTicket () {
        this.status = Status.NEW;
    }

    public long getId() {
        return id;
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

    public Date getDate() {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setResponseTimeAlert(Date responseTimeAlert) {
        this.responseTimeAlert = responseTimeAlert;
    }

    public Date getResponseTimeAlert() {
        return responseTimeAlert;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
