package com.sweng455.meetingschedulingsystem.data.entity;

import com.sweng455.meetingschedulingsystem.data.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Room extends AbstractEntity {
    private Long roomNumber;
    private Boolean specialRoom;

    @OneToMany
    private List<Meetings> meetings = new LinkedList<>();

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Boolean getSpecialRoom() {
        return specialRoom;
    }

    public void setSpecialRoom(Boolean specialRoom) {
        this.specialRoom = specialRoom;
    }

    public List<Meetings> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meetings> meetings) {
        this.meetings = meetings;
    }
}
