package com.example.coworking.service;

import com.example.coworking.abstraction.AbstractService;
import com.example.coworking.dto.RoomCheckDto;
import com.example.coworking.dto.RoomFilterDto;
import com.example.coworking.entity.Room;
import com.example.coworking.repository.RoomRepo;
import com.example.coworking.specification.RoomSpecification;
import com.example.coworking.util.exception.CustomConflictException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoomService extends AbstractService<Room, RoomRepo> {

    private final RoomSpecification roomSpecification;

    public RoomService(RoomRepo repository, RoomSpecification roomSpecification) {
        super(repository);
        this.roomSpecification = roomSpecification;
    }

    public Boolean checkRoomOccupancy(RoomCheckDto dto) {
        if (dto.getUntil().isBefore(dto.getFrom()) || dto.getUntil().isEqual(dto.getFrom())) {
            log.error("Date until should be before date from at least in 30 min");
            throw new CustomConflictException("Date until should be before date from at least in 30 min");
        }
        return !repository.findAll(roomSpecification.checkOccupancyForDates(dto.getId(), dto.getFrom(), dto.getUntil())).isEmpty();
    }

    public Page<Room> findByFilter(RoomFilterDto dto, Integer page) {
        Pageable pageable = PageRequest.of(page, 50);
        return repository.findAll(filter(dto), pageable);
    }

    private Specification<Room> filter(RoomFilterDto dto) {
        Specification<Room> specification = roomSpecification.byCapacity(dto.getCapacity());
        return specification;
    }
}
