package com.sweng455.meetingschedulingsystem.data.entity;

import com.sweng455.meetingschedulingsystem.data.AbstractEntity;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
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
    private boolean active;
    @OneToMany
    private List<Meetings> meeting = new LinkedList<>();
    @OneToOne
    private Billing billing;
    @Column(nullable = false, unique = true)
    private String userName;
    private String activationCode;
    private String passwordSalt;
    private String passwordHash;
    private Role role;

    public User() {

    }

    public User(String username, String password, Role role) {
        this.userName = username;
        this.role     = role;
        this.passwordSalt = RandomStringUtils.random(32);
        this.passwordHash = DigestUtils.sha1Hex(password); //+ passwordSalt);
        this.activationCode = RandomStringUtils.randomAlphanumeric(32);
    }

    public boolean checkPassword(String password) {
        return DigestUtils.sha1Hex(password).equals(this.passwordHash); //+ passwordSalt).equals(passwordHash);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

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

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
