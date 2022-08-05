package com.sweng455.meetingschedulingsystem.data.service;

import com.sweng455.meetingschedulingsystem.data.entity.Meetings;
import com.sweng455.meetingschedulingsystem.data.repository.MeetingRepository;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import java.util.List;

@Service
public class MeetingService implements CrudListener<Meetings> {

    private final MeetingRepository repository;

    public MeetingService(MeetingRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<Meetings> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Meetings add(Meetings meeting) {
        return this.repository.save(meeting);
    }

    @Override
    public Meetings update(Meetings meeting) {
        return this.repository.save(meeting);
    }

    @Override
    public void delete(Meetings meeting) {
        this.repository.delete(meeting);
    }
}
