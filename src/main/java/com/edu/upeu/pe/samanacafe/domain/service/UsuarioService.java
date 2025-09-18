package com.edu.upeu.pe.samanacafe.domain.service;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.UsuarioEntity;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    UsuarioEntity create(UsuarioEntity usuario);
    Optional<UsuarioEntity> findById(Long id);
    List<UsuarioEntity> findAll();
    UsuarioEntity update(Long id, UsuarioEntity usuario);
    void delete(Long id);
}


