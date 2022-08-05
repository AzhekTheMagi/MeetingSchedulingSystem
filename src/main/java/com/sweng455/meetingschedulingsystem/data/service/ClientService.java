package com.sweng455.meetingschedulingsystem.data.service;

import com.sweng455.meetingschedulingsystem.data.entity.Client;
import com.sweng455.meetingschedulingsystem.data.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import java.util.List;

@Service
public class ClientService implements CrudListener<Client> {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<Client> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Client add(Client userClient) {
        return this.repository.save(userClient);
    }

    @Override
    public Client update(Client userClient) {
        return this.repository.save(userClient);
    }

    @Override
    public void delete(Client userClient) {
        this.repository.delete(userClient);
    }
}
