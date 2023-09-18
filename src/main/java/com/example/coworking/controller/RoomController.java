package com.example.coworking.controller;

import com.example.coworking.dto.RoomCheckDto;
import com.example.coworking.dto.RoomFilterDto;
import com.example.coworking.entity.Room;
import com.example.coworking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("room")
public class RoomController {

    private final RoomService service;

    @GetMapping("{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Room>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/findByFilter/{page}")
    public ResponseEntity<Page<Room>> findByFilter(@PathVariable Integer page,
                                                   @RequestBody RoomFilterDto filterDto) {
        return new ResponseEntity<>(service.findByFilter(filterDto, page), HttpStatus.OK);
    }

    @PostMapping("/checkRoomOccupancy")
    public ResponseEntity<Boolean> checkRoomOccupancy(@RequestBody RoomCheckDto dto) {
        return new ResponseEntity<>(service.checkRoomOccupancy(dto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Room> save(@RequestBody Room object) {
        return new ResponseEntity<>(service.save(object), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Room> update(@RequestBody Room object) {
        return new ResponseEntity<>(service.save(object), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
