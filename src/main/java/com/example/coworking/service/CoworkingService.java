package com.example.coworking.service;

import com.example.coworking.abstraction.AbstractService;
import com.example.coworking.entity.Coworking;
import com.example.coworking.repository.CoworkingRepo;
import org.springframework.stereotype.Service;

@Service
public class CoworkingService extends AbstractService<Coworking, CoworkingRepo> {

    public CoworkingService(CoworkingRepo repository) {
        super(repository);
    }
}
