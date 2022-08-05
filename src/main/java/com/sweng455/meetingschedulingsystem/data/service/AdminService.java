package com.sweng455.meetingschedulingsystem.data.service;

import com.sweng455.meetingschedulingsystem.data.entity.Admin;
import com.sweng455.meetingschedulingsystem.data.repository.AdminRepository;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import java.util.List;

@Service
public class AdminService implements CrudListener<Admin> {

    private final AdminRepository repository;

    public AdminService(AdminRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<Admin> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Admin add(Admin adminUser) {
        return this.repository.save(adminUser);
    }

    @Override
    public Admin update(Admin adminUser) {
        return this.repository.save(adminUser);
    }

    @Override
    public void delete(Admin adminUser) {
        this.repository.delete(adminUser);
    }
}
