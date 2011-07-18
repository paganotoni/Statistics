/*
 * Tipo.java
 * 
 * Created on 18/09/2007, 03:49:18 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Jakolov
 */
public class Tipo {
    private int idTipo;
    private String nombre;
    private String letra;

    public Tipo(int idTipo, String nombre, String letra) {
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.letra = letra;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
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
