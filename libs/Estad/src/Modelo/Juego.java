/*
 * Juego.java
 *
 * Created on 9 de agosto de 2007, 09:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;


/**
 * Clase Entidad Juego
 * 
 * @author Jakolov
 */

public class Juego {


    private Integer id;
    private String fecha;
    private String numero;
    private String fase;
    private String diaNumero;
    private String coliseo;
    private String ciudad;
    private String jueces;
    private String recaudos;
    private String asistencia;
    private String comEntrenadorPropio ;
    private String comEntrenadorOpp;
    private String anotador;
    private String tipo;
    private String codPropio;
    private String codOpp;
    
    private ArrayList<Parcial> parciales;

    public ArrayList<Parcial> getParciales() {
        return parciales;
    }

    public void setParciales(ArrayList<Parcial> parciales) {
        this.parciales = parciales;
    }

    
    /** Creates a new instance of Juego */
    public Juego() {
    }
    public String getCodOpp() {
        return codOpp;
    }

    public void setCodOpp(String codOpp) {
        this.codOpp = codOpp;
    }

    public String getCodPropio() {
        return codPropio;
    }

    public void setCodPropio(String codPropio) {
        this.codPropio = codPropio;
    }
    public String getAnotador() {
        return anotador;
    }

    public void setAnotador(String anotador) {
        this.anotador = anotador;
    }

    /**
     * Obtener el id de este Juego.
     * @return el id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Define el id de este Juego al valor especificado.
     * @param id el nuevoid
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returna un valor de codigo hash para el objeto.  Esta implementacion computa
     * un valor de codigo hash basado sobre los campos id en este objeto.
     * @return  un valor de codigo hash para este objeto.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determina si otro objeto es igual a este Juego.  El resultado es  
     * <code>verdadero</code> si y solo si el argumento no es nulo y es unJuego objeto que tiene  valores identicos en el campo id tal como este objeto.
     * @param objeto que referencia el objeto con el cual comparar @return <code>verdadero</code> si este objeto es identico al argumento; de otra manera ser�<code>falso</code>.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juego)) {
            return false;
        }
        Juego other = (Juego)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returna un representacion de cadena del objeto.  Esta implementacion construye esta representacion basada sobre los campos id.
     * @return una  representacion de cadena del objeto.
     */
    @Override
    public String toString() {
        return "Modelo.Juego[id=" + id + "]";
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getDiaNumero() {
        return diaNumero;
    }

    public void setDiaNumero(String diaNumero) {
        this.diaNumero = diaNumero;
    }

    public String getColiseo() {
        return coliseo;
    }

    public void setColiseo(String coliseo) {
        this.coliseo = coliseo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getJueces() {
        return jueces;
    }

    public void setJueces(String jueces) {
        this.jueces = jueces;
    }

    public String getRecaudos() {
        return recaudos;
    }

    public void setRecaudos(String recaudos) {
        this.recaudos = recaudos;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getComEntrenadorOpp() {
        return comEntrenadorOpp;
    }

    public void setComEntrenadorOpp(String comEntrenadorOpp) {
        this.comEntrenadorOpp = comEntrenadorOpp;
    }

    public String getComEntrenadorPropio() {
        return comEntrenadorPropio;
    }

    public void setComEntrenadorPropio(String comEntrenadorPropio) {
        this.comEntrenadorPropio = comEntrenadorPropio;
    }
}
