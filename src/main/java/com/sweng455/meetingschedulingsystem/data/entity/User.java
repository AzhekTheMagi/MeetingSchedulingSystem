package com.sweng455.meetingschedulingsystem.data.entity;

import com.sweng455.meetingschedulingsystem.data.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.LinkedList;
import java.util.List;

@Entity
public class User extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String email;

    @Column(nullable = false, unique = true)
    private String userName;
    private String passwordHash;
    private Role role;

    @OneToMany
    private List<Meetings> meeting = new LinkedList<>();

    @OneToOne
    private Billing billing;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Meetings> getMeeting() {
        return meeting;
    }

    public void setMeeting(List<Meetings> meeting) {
        this.meeting = meeting;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
