/*
 * Torneo.java
 *
 * Created on 9 de agosto de 2007, 08:16 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;

/**
 * Clase Entidad Torneo
 * 
 * @author Jakolov
 */
public class Torneo implements Serializable {

       
    private Integer id;
    private String nombre;
    private String fechaInicio;
    
    /** Creates a new instance of Torneo */
    public Torneo() {
    }

    /**
     * Obtener el id de este Torneo.
     * @return el id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Define el id de este Torneo al valor especificado.
     * @param id el nuevoid
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returna un valor de c�digo hash para el objeto.  Esta implementaci�n computa
     * un valor de c�digo hash basado sobre los campos id en este objeto.
     * @return  un valor de c�digo hash para este objeto.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determina si otro objeto es igual a este Torneo.  El resultado es  
     * <code>verdadero</code> s� y s�lo s� el argumento no es nulo y es unTorneo objeto que tiene  valores id�nticos en el campo id tal como este objeto.
     * @param objeto que referencia el objeto con el cual comparar @return <code>verdadero</code> si este objeto es id�ntico al argumento; de otra manera ser�<code>falso</code>.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returna un representacion de cadena del objeto.  Esta implementaci�n construye esta representaci�n basada sobre los campos id.
     * @return una  representacon de cadena del objeto.
     */
    @Override
    public String toString() {
        return "Modelo.Torneo[id=" + id + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    
}
