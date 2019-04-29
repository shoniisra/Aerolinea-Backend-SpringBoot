package com.demo.aerolinea.models.entities;



import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="VUELO")
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVUELO")
    private Integer idvuelo;

    @Column(name = "CODIGO")
    @NotEmpty
    @Size(max = 255)
    private String codigo;

    @Column(name = "FECHA")
    @NotEmpty
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Calendar fecha;

    @Column(name = "ORIGEN")
    @NotEmpty
    @Size(max = 255)
    private String origen;

    @Column(name = "DESTINO")
    @NotEmpty
    @Size(max = 255)
    private String destino;

    @JoinColumn(name="IDAVION", referencedColumnName = "IDAVION")//claves foraneas
    @ManyToOne
    private Avion avion;

    @JoinColumn(name="IDPILOTO", referencedColumnName = "IDPILOTO")//claves foraneas
    @ManyToOne
    private Piloto piloto;


    public Vuelo() {
        super();
    }

    public Vuelo(Integer idvuelo) {
        super();
        this.idvuelo = idvuelo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Integer idvuelo) {
        this.idvuelo = idvuelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
}
