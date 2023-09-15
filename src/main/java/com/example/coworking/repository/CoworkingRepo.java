package com.example.coworking.repository;

import com.example.coworking.abstraction.AbstractRepository;
import com.example.coworking.entity.Coworking;
import org.springframework.stereotype.Repository;

@Repository
public interface CoworkingRepo extends AbstractRepository<Coworking> {
}
