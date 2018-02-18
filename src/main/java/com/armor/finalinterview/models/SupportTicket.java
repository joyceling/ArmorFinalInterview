package com.armor.finalinterview.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "support")
public class SupportTicket {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "date")
    private Date date = new Date();

    @Size(max = 100, message = "This field must be less than 100 characters.")
    @NotBlank(message = "This field cannot be blank.")
    @Column(nullable = false, length = 100)
    private String firstName;

    @Size(max = 100, message = "This field must be less than 100 characters.")
    @NotBlank(message = "This field cannot be blank.")
    @Column(nullable = false, length = 100)
    private String lastName;

    @Email(message = "Format must be: example@yourdomain.com.")
    @Pattern(regexp = ".+@.+\\..+", message = "Must be valid email.")
    @NotBlank(message = "This field cannot be blank.")
    @Column(nullable = false, length = 100)
    private String email;

    @Size(max = 100, message = "This field must be less than 100 characters.")
    @NotBlank(message = "This field cannot be blank.")
    @Column(nullable = false, length = 100)
    private String subject;

    @Size(max = 100, message = "This field must be less than 5000 characters.")
    @NotBlank(message = "This field cannot be blank.")
    @Column(nullable = false, length = 5000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private Date responseTimeAlert;

    public SupportTicket() {
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

    public void setDate(Date date) {
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
