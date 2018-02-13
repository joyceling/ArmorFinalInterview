package com.armor.finalinterview.models;

import com.armor.finalinterview.Priority;
import com.armor.finalinterview.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="support")
public class SupportUser {
    @Id @GeneratedValue
    private long id;

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

    @Column(nullable = false)
    private Date date;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column (nullable = false)
    private Date responseTimeAlert;

    @Enumerated(EnumType.STRING)
    private Priority priority;

}
