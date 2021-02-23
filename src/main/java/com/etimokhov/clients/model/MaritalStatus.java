package com.etimokhov.clients.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class MaritalStatus {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

}
