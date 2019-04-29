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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="PILOTO")
public class Piloto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPILOTO")
    private Integer idpiloto;

    @Column(name = "NOMBRE")
    @NotEmpty
    @Size(max = 255)
    private String nombre;

    @Column(name = "HORASDEVUELO")
    private float horasdevuelo;

    @OneToMany(mappedBy="vuelo", fetch=FetchType.LAZY)
    private List<Vuelo> vuelos;


    public Piloto() {
        super();
    }

    public Piloto(Integer idpiloto) {
        super();
        this.idpiloto = idpiloto;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdpiloto() {
        return idpiloto;
    }

    public void setIdpiloto(Integer idpiloto) {
        this.idpiloto = idpiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getHorasdevuelo() {
        return horasdevuelo;
    }

    public void setHorasdevuelo(float horasdevuelo) {
        this.horasdevuelo = horasdevuelo;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
}
