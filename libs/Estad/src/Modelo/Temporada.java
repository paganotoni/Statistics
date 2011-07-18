/*
 * Temporada.java
 *
 * Created on 9 de agosto de 2007, 08:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;

/**
 * Clase Entidad Temporada
 * 
 * @author Jakolov
 */

public class Temporada implements Serializable {

    private int id;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    
    /** Creates a new instance of Temporada */
    public Temporada() {
    }

    /**
     * Obtener el id de este Temporada.
     * @return el id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Define el id de este Temporada al valor especificado.
     * @param id el nuevoid
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Determina si otro objeto es igual a este Temporada.  El resultado es  
     * <code>verdadero</code> si y solo siel argumento no es nulo y es unTemporada objeto que tiene  valores identicos en el campo id tal como este objeto.
     * @param objeto que referencia el objeto con el cual comparar @return <code>verdadero</code> si este objeto es identico al argumento; de otra manera sera<code>falso</code>.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temporada)) {
            return false;
        }
        Temporada other = (Temporada)object;
        if(this.id == other.id){    
            return true;
        }else{
            return false;
        }
            
    }

    /**
     * Returna un representacion de cadena del objeto.  Esta implementacion construye esta representacion basada sobre los campos id.
     * @return una  representacion de cadena del objeto.
     */
    @Override
    public String toString() {
        return "Modelo.Temporada[id=" + id + "]";
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

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }


    
}
