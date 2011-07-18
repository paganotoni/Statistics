/*
 * Jugador.java
 * 
 * Created on 8/09/2007, 03:40:23 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Jakolov
 */
public class Jugador {
    
    private String numero;
    private String codigo;
    private String nombre;
    private String estatura;
    private String peso;
    
    public Jugador(){

    }

    public Jugador(String numero, String codigo, String nombre, String estatura, String peso) {
        this.numero = numero;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estatura = estatura;
        this.peso = peso;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    
}
