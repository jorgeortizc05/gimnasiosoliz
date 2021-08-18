/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.model;

/**
 * Modelo Tipo de Comprobante: factura, nota de venta, etc
 * @author Ing. Jorge Luis Ortiz Caceres
 * @since 18/08/2021
 * @version 1.0.0
 * 
 */
public class TipoComprobante {
    
    private int id;
    private String nombre;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoComprobante{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
}
