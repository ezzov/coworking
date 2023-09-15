package com.example.coworking.repository;

import com.example.coworking.abstraction.AbstractRepository;
import com.example.coworking.entity.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends AbstractRepository<Booking> {
}
