package com.example.coworking.service;

import com.example.coworking.abstraction.AbstractService;
import com.example.coworking.dto.RoomFilterDto;
import com.example.coworking.entity.Room;
import com.example.coworking.repository.RoomRepo;
import com.example.coworking.specification.RoomSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RoomService extends AbstractService<Room, RoomRepo> {

    private final RoomSpecification roomSpecification;

    public RoomService(RoomRepo repository, RoomSpecification roomSpecification) {
        super(repository);
        this.roomSpecification = roomSpecification;
    }

    public Page<Room> findByFilter(RoomFilterDto dto, Integer page) {
        Pageable pageable = PageRequest.of(page, 50);
        return repository.findAll(filter(dto), pageable);
    }

    private Specification<Room> filter(RoomFilterDto dto) {
        Specification<Room> specification = roomSpecification.checkOccupancyForDates(dto.getFrom(), dto.getUntil());
        if (dto.getId() != null) {
            specification = specification.and(roomSpecification.byId(dto.getId()));
        }
        if (dto.getCapacity() != null) {
            specification = specification.and(roomSpecification.byCapacity(dto.getCapacity()));
        }
        return specification;

    }
}
