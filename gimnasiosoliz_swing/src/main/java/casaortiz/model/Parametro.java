/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.model;

/**
 *
 * @author jorge
 */
public class Parametro {
    
    private int id;
    private int numero_recibo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero_recibo() {
        return numero_recibo;
    }

    public void setNumero_recibo(int numero_recibo) {
        this.numero_recibo = numero_recibo;
    }

    @Override
    public String toString() {
        return "Parametro{" + "id=" + id + ", numero_recibo=" + numero_recibo + '}';
    }
    
    
    
}
