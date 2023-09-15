package com.example.coworking.controller;

import com.example.coworking.entity.Booking;
import com.example.coworking.entity.Room;
import com.example.coworking.service.BookingService;
import com.example.coworking.service.RoomService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("booking")
public class BookingController {

    private final BookingService service;

    @GetMapping("{id}")
    public ResponseEntity<Booking> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Booking>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Booking> save(@RequestBody Booking object) {
        return new ResponseEntity<>(service.save(object), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Booking> update(@RequestBody Booking object) {
        return new ResponseEntity<>(service.save(object), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
