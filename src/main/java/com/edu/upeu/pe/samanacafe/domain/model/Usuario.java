package com.edu.upeu.pe.samanacafe.domain.model;

import com.edu.upeu.pe.samanacafe.infrastructure.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String dni;
    private String celular;
    private Role role;
    private List<Direccion> direcciones;
    private List<Carrito> carritos = new ArrayList<>();


    public Usuario() {
    }

    public Usuario(Long id, String name, String lastName, String email, String password, String dni, String celular, Role role, List<Direccion> direcciones, List<Carrito> carritos) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.celular = celular;
        this.role = role;
        this.direcciones = direcciones;
        this.carritos = carritos;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }
}
