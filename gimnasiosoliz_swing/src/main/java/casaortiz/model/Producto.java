/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.model;

/**
 * Modelo Producto
 * @author Ing. Jorge Luis Ortiz Caceres
 * @since 18/08/2021
 * @version 1.0.0
 * 
 */
public class Producto {
    
    private int id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String codigoBarra;
    private String foto;
    private int subCategoriaId;

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getSubCategoriaId() {
        return subCategoriaId;
    }

    public void setSubCategoriaId(int subCategoriaId) {
        this.subCategoriaId = subCategoriaId;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", codigoBarra=" + codigoBarra + ", foto=" + foto + ", subCategoriaId=" + subCategoriaId + '}';
    }

    
}
