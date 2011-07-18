/*
 * Gesto.java
 * 
 * Created on 19/09/2007, 11:47:07 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Jakolov
 */
public class Gesto {
    private String id;
    private String letra;
    private String nombre;
    private String factor;
    private String pct;

    public Gesto() {
    }
    

    public Gesto(String letra, String nombre) {
        this.letra = letra;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getPct() {
        return pct;
    }

    public void setPct(String pct) {
        this.pct = pct;
    }
    
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
