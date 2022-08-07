package com.sweng455.meetingschedulingsystem.data.service;

import com.sweng455.meetingschedulingsystem.data.entity.Room;
import com.sweng455.meetingschedulingsystem.data.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import java.util.List;

@Service
public class RoomService implements CrudListener<Room> {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository)
    {
        this.repository = repository;
    }
    @Override
    public List<Room> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Room add(Room domainObjectToAdd) {
        return null;
    }

    @Override
    public Room update(Room domainObjectToUpdate) {
        return null;
    }

    @Override
    public void delete(Room domainObjectToDelete) {

    }
}
