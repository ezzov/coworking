package com.example.coworking.service;

import com.example.coworking.abstraction.AbstractService;
import com.example.coworking.dto.RoomCheckDto;
import com.example.coworking.entity.Booking;
import com.example.coworking.entity.Room;
import com.example.coworking.repository.BookingRepo;
import com.example.coworking.util.exception.CustomConflictException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class BookingService extends AbstractService<Booking, BookingRepo> {

    private final RoomService roomService;

    public BookingService(BookingRepo repository, RoomService roomService) {
        super(repository);
        this.roomService = roomService;
    }

    @Override
    public Booking save(Booking object) {
        LocalDateTime from = object.getStartDate();
        LocalDateTime until = object.getEndDate();
        if (until.isBefore(from) || until.isEqual(from)) {
            log.error("Date until should be before date from at least in 30 min");
            throw new CustomConflictException("Date until should be before date from at least in 30 min");
        }

        //проверяем, что шаг бронирования 30 минут. Например, можно бронировать в 13:00, 13:30 до 15:00, 15:30
        if (until.getMinute() % 30 != 0 || from.getMinute() % 30 != 0) {
            log.error("The minutes should be 00 or 30 min");
            throw new CustomConflictException("The minutes should be 00 or 30 min");
        }

        if (checkOccupancy(object.getRoom().getId(), from, until)) {
            log.info("Request for saving Booking from {} to {}, room id {}", from, until, object.getRoom().getId());
            return super.save(object);
        } else {
            log.error("The room is occupant for this dates");
            throw new CustomConflictException("The room is occupant for this dates");
        }
    }

    public Boolean checkOccupancy(Long roomId, LocalDateTime from, LocalDateTime until) {
        RoomCheckDto dto = RoomCheckDto.builder()
                .id(roomId)
                .from(from)
                .until(until)
                .build();
        return roomService.checkRoomOccupancy(dto);
    }
}
