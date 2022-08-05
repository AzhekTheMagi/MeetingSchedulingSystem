package com.sweng455.meetingschedulingsystem.data.entity;

import com.sweng455.meetingschedulingsystem.data.AbstractEntity;
import javax.persistence.Entity;

@Entity
public class Complaints extends AbstractEntity {
    private String email;
    private String complaint;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
