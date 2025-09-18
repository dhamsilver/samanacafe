package com.edu.upeu.pe.samanacafe.infrastructure.repository;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.CarritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoEntity, Long> {
}


