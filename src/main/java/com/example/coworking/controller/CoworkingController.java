package com.example.coworking.controller;

import com.example.coworking.entity.Coworking;
import com.example.coworking.service.CoworkingService;
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
@RequestMapping("coworking")
public class CoworkingController {

    private final CoworkingService service;

    @GetMapping("{id}")
    public ResponseEntity<Coworking> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Coworking>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Coworking> save(@RequestBody Coworking object) {
        return new ResponseEntity<>(service.save(object), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Coworking> update(@RequestBody Coworking object) {
        return new ResponseEntity<>(service.save(object), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
