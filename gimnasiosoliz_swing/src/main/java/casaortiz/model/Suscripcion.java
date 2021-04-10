/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.model;

import java.util.Date;

/**
 *
 * @author jorge
 */
public class Suscripcion {
    private int id;
    private String numeroRecibo;
    private Date fechaSuscripcion;
    private Date fechaDesde;
    private Date fechaHasta;
    private Double precio;
    private Double descuento;
    private Double importeTotal;
    private String observaciones;
    private int personaId;
    private int tipoSuscripcionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public Date getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(Date fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public int getTipoSuscripcionId() {
        return tipoSuscripcionId;
    }

    public void setTipoSuscripcionId(int tipoSuscripcionId) {
        this.tipoSuscripcionId = tipoSuscripcionId;
    }

    @Override
    public String toString() {
        return "Suscripcion{" + "id=" + id + ", numeroRecibo=" + numeroRecibo + ", fechaSuscripcion=" + fechaSuscripcion + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", precio=" + precio + ", descuento=" + descuento + ", importeTotal=" + importeTotal + ", observaciones=" + observaciones + ", personaId=" + personaId + ", tipoSuscripcionId=" + tipoSuscripcionId + '}';
    }

    
}
