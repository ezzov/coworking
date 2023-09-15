package com.example.coworking.abstraction;

import com.example.coworking.util.exception.CustomNoContentException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@RequiredArgsConstructor
public class AbstractService<M extends AbstractModel, R extends AbstractRepository> {

    protected final R repository;

    @SneakyThrows
    public M findById(Long id) {
        return (M) repository.findById(id).orElseThrow(() -> new CustomNoContentException("Объект не найден"));
    }

    public M save(M object) {
        return (M) repository.save(object);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<M> findAll() {
        return repository.findAll();
    }
}
