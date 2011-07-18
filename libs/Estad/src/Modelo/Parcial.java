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
public class Parcial {
    
    private String idParcial;
    private String idJuego;
    private String numero;
    private String maximo;
    private String posPropio;
    private ArrayList Rallys;
    
    public Parcial(String id, String idjuego, String numero, String maximo, String posPropio ) {
        this.idParcial = id;
        this.idJuego = idjuego;
        this.numero = numero;
        this.maximo = maximo;
        this.posPropio = posPropio;
    }

    public ArrayList getRallys() {
        return Rallys;
    }

    public void setRallys(ArrayList Rallys) {
        this.Rallys = Rallys;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public String getIdParcial() {
        return idParcial;
    }

    public void setIdParcial(String idParcial) {
        this.idParcial = idParcial;
    }

    public String getMaximo() {
        return maximo;
    }

    public void setMaximo(String maximo) {
        this.maximo = maximo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPosPropio() {
        return posPropio;
    }

    public void setPosPropio(String posPropio) {
        this.posPropio = posPropio;
    }
    
}
