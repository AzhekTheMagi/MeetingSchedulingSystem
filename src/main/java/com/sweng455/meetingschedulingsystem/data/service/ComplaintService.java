package com.sweng455.meetingschedulingsystem.data.service;

import com.sweng455.meetingschedulingsystem.data.entity.Complaints;
import com.sweng455.meetingschedulingsystem.data.repository.ComplaintsRepository;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import java.util.List;

@Service
public class ComplaintService implements CrudListener<Complaints> {

    private final ComplaintsRepository repository;

    public ComplaintService(ComplaintsRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<Complaints> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Complaints add(Complaints complaints) {
        return this.repository.save(complaints);
    }

    @Override
    public Complaints update(Complaints complaints) {
        return this.repository.save(complaints);
    }

    @Override
    public void delete(Complaints complaints) {
        this.repository.delete(complaints);
    }
}
