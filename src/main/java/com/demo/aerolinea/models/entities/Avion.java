package com.demo.aerolinea.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="AVION")
public class Avion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAVION")
    private Integer idavion;


    @Column(name = "TIPO")
    @Size(max = 255)
    private String tipo;

    @Column(name = "MARCA")
    @Size(max = 255)
    private String marca;

    @OneToMany(mappedBy="vuelo", fetch=FetchType.LAZY)
    private List<Vuelo> vuelos;

    public Avion() {
        super();
    }

    public Avion(Integer idavion) {
        super();
        this.idavion = idavion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdavion() {
        return idavion;
    }

    public void setIdavion(Integer idavion) {
        this.idavion = idavion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
}
