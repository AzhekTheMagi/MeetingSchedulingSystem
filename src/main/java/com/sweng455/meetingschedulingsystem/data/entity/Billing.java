package com.sweng455.meetingschedulingsystem.data.entity;

import com.sweng455.meetingschedulingsystem.data.AbstractEntity;
import javax.persistence.Entity;

@Entity
public class Billing extends AbstractEntity {
    private String streetAddress;
    private String creditCardNumber; // Requires encryption
    private int    zipCode;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
