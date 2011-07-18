/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author jakolov
 */
public class Rally {

    private String idRally;
    private String idParcial;
    private String ptoPropio;
    private String ptoOponente;
    private String posP;
    private String posAP;
    private String BP;
    private String Complejo;
    private ArrayList<Accion> Acciones;



    public Rally() {
    }

    public Rally(String idRally, String idParcial, String ptoPropio, String ptoOponente, String posP, String posAP, String BP, String Complejo) {
        this.idRally = idRally;
        this.idParcial = idParcial;
        this.ptoPropio = ptoPropio;
        this.ptoOponente = ptoOponente;
        this.posP = posP;
        this.posAP = posAP;
        this.BP = BP;
        this.Complejo = Complejo;
        Acciones = new ArrayList();
    }
    public ArrayList<Accion> getAcciones() {
        return Acciones;
    }

    public void setAcciones(ArrayList<Accion> Acciones) {
        this.Acciones = Acciones;
    }
    public String getBP() {
        return BP;
    }

    public void setBP(String BP) {
        this.BP = BP;
    }

    public String getComplejo() {
        return Complejo;
    }

    public void setComplejo(String Complejo) {
        this.Complejo = Complejo;
    }

    public String getIdParcial() {
        return idParcial;
    }

    public void setIdParcial(String idParcial) {
        this.idParcial = idParcial;
    }

    public String getIdRally() {
        return idRally;
    }

    public void setIdRally(String idRally) {
        this.idRally = idRally;
    }

    public String getPosAP() {
        return posAP;
    }

    public void setPosAP(String posAP) {
        this.posAP = posAP;
    }

    public String getPosP() {
        return posP;
    }

    public void setPosP(String posP) {
        this.posP = posP;
    }

    public String getPtoOponente() {
        return ptoOponente;
    }

    public void setPtoOponente(String ptoOponente) {
        this.ptoOponente = ptoOponente;
    }

    public String getPtoPropio() {
        return ptoPropio;
    }

    public void setPtoPropio(String ptoPropio) {
        this.ptoPropio = ptoPropio;
    }
}