/*
 * Acelerador.java
 * 
 * Created on 25/09/2007, 04:44:36 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Jakolov
 */
public class Acelerador {
    private String id;
    private String codigo;
    private String acelerador;
    private String descripcion;

    public Acelerador(String id, String codigo, String acelerador, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.acelerador = acelerador;
        this.descripcion = descripcion;
    }

    public String getAcelerador() {
        return acelerador;
    }

    public void setAcelerador(String acelerador) {
        this.acelerador = acelerador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
}
