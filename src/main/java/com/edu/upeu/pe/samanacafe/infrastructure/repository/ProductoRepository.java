package com.edu.upeu.pe.samanacafe.infrastructure.repository;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}


