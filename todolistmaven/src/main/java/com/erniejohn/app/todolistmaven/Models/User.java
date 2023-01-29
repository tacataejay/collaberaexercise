package com.erniejohn.app.todolistmaven.Models;

import jakarta.persistence.*;

//this object will be used for actual CRUD of the REST API
@Entity //Entity annotation tells mysql that this User class will indeed the table of the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column // Tells that each of the attribute is a column to a database
    private String tododesc;


    public String getTododesc() {
        return tododesc;
    }

    public void setTododesc(String tododesc) {
        this.tododesc = tododesc;
    }
}
