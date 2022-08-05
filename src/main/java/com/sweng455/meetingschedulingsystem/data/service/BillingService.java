package com.sweng455.meetingschedulingsystem.data.service;

import com.sweng455.meetingschedulingsystem.data.entity.Billing;
import com.sweng455.meetingschedulingsystem.data.repository.BillingRepository;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import java.util.List;

@Service
public class BillingService implements CrudListener<Billing> {

    private final BillingRepository repository;

    public BillingService(BillingRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<Billing> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Billing add(Billing billing) {
        return this.repository.save(billing);
    }

    @Override
    public Billing update(Billing billing) {
        return this.repository.save(billing);
    }

    @Override
    public void delete(Billing billing) {
        this.repository.delete(billing);
    }
}
