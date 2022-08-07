package com.sweng455.meetingschedulingsystem.data.service;

import com.sweng455.meetingschedulingsystem.data.entity.User;
import com.sweng455.meetingschedulingsystem.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import org.vaadin.crudui.crud.CrudListener;
import java.util.List;

@Service
public class UserService extends CrudService<User, Integer> {
    private final UserRepository repository;

    public UserService(@Autowired UserRepository repository)
    {
        this.repository = repository;
    }

    public UserRepository getRepository() {
        return this.repository;
    }
/*
    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User add(User user) {
        return this.repository.save(user);
    }

    @Override
    public User update(User user) {
        return this.repository.save(user);
    }

    @Override
    public void delete(User user) {
        this.repository.delete(user);
    }

 */
}
