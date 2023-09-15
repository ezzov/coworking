package com.example.coworking.abstraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<M extends AbstractModel> extends JpaRepository<M, Long>, JpaSpecificationExecutor<M> {
}
