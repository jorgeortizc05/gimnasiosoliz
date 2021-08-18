/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.model;

/**
 * Modelo Empresa: registra tu empresa
 * @author Ing. Jorge Luis Ortiz Caceres
 * @since 18/08/2021
 * @version 1.0.0
 * 
 */
public class Empresa {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String RUC;
    private String direccionMatriz;
    private String direccionSucursal;
    private int cantonID;

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

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getDireccionMatriz() {
        return direccionMatriz;
    }

    public void setDireccionMatriz(String direccionMatriz) {
        this.direccionMatriz = direccionMatriz;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    

    public int getCantonID() {
        return cantonID;
    }

    public void setCantonID(int cantonID) {
        this.cantonID = cantonID;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", RUC=" + RUC + ", direccionMatriz=" + direccionMatriz + ", direccionSucursal=" + direccionSucursal + ", idCanton=" + cantonID + '}';
    }

    
    
}
