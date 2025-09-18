package com.edu.upeu.pe.samanacafe.domain.model;

public class Direccion {

    private Long id;
    private String calle;
    private String ciudad;
    private String distrito;
    private String referencia;

    public Direccion() {
    }

    public Direccion(Long id, String calle, String ciudad, String distrito, String referencia) {
        this.id = id;
        this.calle = calle;
        this.ciudad = ciudad;
        this.distrito = distrito;
        this.referencia = referencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
