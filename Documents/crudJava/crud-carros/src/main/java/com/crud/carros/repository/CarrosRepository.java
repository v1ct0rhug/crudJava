package com.crud.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.carros.entity.Carros;

@Repository
public interface CarrosRepository extends JpaRepository<Carros, Long> {

}
