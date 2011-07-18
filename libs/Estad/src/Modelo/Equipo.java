/*
 * Equipo.java
 *
 * Created on 9 de agosto de 2007, 08:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.util.LinkedList;
/**
 * Clase Entidad Equipo
 * 
 * @author Jakolov
 */

public class Equipo implements Serializable {


    private Integer id;
    private String codigo;
    private String nombre;
    private String ciudad;
    private String entrenador;
    private String asistente;
    private LinkedList listaJugadores;
    
    /** Creates a new instance of Equipo */
    public Equipo() {
    }

    /**
     * Obtener el id de este Equipo.
     * @return el id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Define el id de este Equipo al valor especificado.
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
     * Determina si otro objeto es igual a este Equipo.  El resultado es  
     * <code>verdadero</code> si y solo si el argumento no es nulo y es unEquipo objeto que tiene  valores identicos en el campo id tal como este objeto.
     * @param objeto que referencia el objeto con el cual comparar @return <code>verdadero</code> si este objeto es id�ntico al argumento; de otra manera ser�<code>falso</code>.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returna un representacion de cadena del objeto.  Esta implementacion construye esta representacion basada sobre los campos id.
     * @return una  representacion de cadena del objeto.
     */
    @Override
    public String toString() {
        return "Modelo.Equipo[id=" + id + "]";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getAsistente() {
        return asistente;
    }

    public void setAsistente(String asistente) {
        this.asistente = asistente;
    }


    
}
