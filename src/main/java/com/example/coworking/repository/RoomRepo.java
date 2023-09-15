package com.example.coworking.repository;

import com.example.coworking.abstraction.AbstractRepository;
import com.example.coworking.entity.Room;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends AbstractRepository<Room> {
}
