package com.example.coworking.service;

import com.example.coworking.abstraction.AbstractService;
import com.example.coworking.entity.Booking;
import com.example.coworking.repository.BookingRepo;
import com.example.coworking.util.exception.CustomConflictException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class BookingService extends AbstractService<Booking, BookingRepo> {
    public BookingService(BookingRepo repository) {
        super(repository);
    }

    @Override
    public Booking save(Booking object) {
        LocalDateTime from = object.getFrom();
        LocalDateTime until = object.getUntil();
        if (until.isBefore(from) || until.isEqual(from)) {
            throw new CustomConflictException("Date until should be before date from at least in 30 min");
        }

        //проверяем, что шаг бронирования 30 минут. Например, можно бронировать в 13:00, 13:30 до 15:00, 15:30
        if (until.getMinute() % 30 != 0 || from.getMinute() % 30 != 0) {
            throw new CustomConflictException("Date until should be before date from");
        }
        return super.save(object);
    }
}
