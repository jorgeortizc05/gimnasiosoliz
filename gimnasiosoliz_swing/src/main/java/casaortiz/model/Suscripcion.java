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
    private Date fechaDesde;
    private Date fechaHasta;
    private Double precio;
    private Double descuento;
    private Double importeTotal;
    private String observaciones;
    private int idPersona;
    private int idTipoSuscripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
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

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdTipoSuscripcion() {
        return idTipoSuscripcion;
    }

    public void setIdTipoSuscripcion(int idTipoSuscripcion) {
        this.idTipoSuscripcion = idTipoSuscripcion;
    }

    @Override
    public String toString() {
        return "Suscripcion{" + "id=" + id + ", numeroRecibo=" + numeroRecibo + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", precio=" + precio + ", descuento=" + descuento + ", importeTotal=" + importeTotal + ", observaciones=" + observaciones + ", idPersona=" + idPersona + ", idTipoSuscripcion=" + idTipoSuscripcion + '}';
    }
    
}
