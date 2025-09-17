package com.edu.upeu.pe.samanacafe.infrastructure.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "usuarios")

public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 100)
    private String name;

    @Column(nullable = true, length = 100)
    private String last_name;

    @Column(nullable = false, length = 8,unique = true)
    private String dni;

    @Column(nullable = false, length = 9,unique = true)
    private String celular;

    @Column(nullable = false, length = 50,unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String name, String last_name, String dni, String celular, String email, String password) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.dni = dni;
        this.celular = celular;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
