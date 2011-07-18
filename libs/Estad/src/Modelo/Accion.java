
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jakolov
 */
public class Accion {

    private String codJugador;
    private String idEquipo;
    private String idJuego;
    private String idGesto;
    private String idTipo;
    private String idValor;
    private String idZsalida;
    private String idZDestino;
    private String codigo;
    private int Error;
    private String idRally;
    private String patron;
    public Accion() {

    }

    public Accion(String idJugador, String idEquipo, String idGesto, String idTipo, String idValor, String idZsalida, String idZDestino, String idRally, String tiempo) {

        this.codJugador = idJugador;
        this.idEquipo = idEquipo;
        this.idGesto = idGesto;
        this.idTipo = idTipo;
        this.idValor = idValor;
        this.idZsalida = idZsalida;
        this.idZDestino = idZDestino;

    }

    public int getError() {
        return Error;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }
    
    public void setError(int Error) {
        this.Error = Error;
    }

    public String getIdRally() {
        return idRally;
    }

    public void setIdRally(String idRally) {
        this.idRally = idRally;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getIdGesto() {
        return idGesto;
    }

    public void setIdGesto(String idGesto) {
        this.idGesto = idGesto;
    }

    public String getIdJugador() {
        return codJugador;
    }

    public void setIdJugador(String idJugador) {
        this.codJugador = idJugador;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getIdValor() {
        return idValor;
    }

    public void setIdValor(String idValor) {
        this.idValor = idValor;
    }

    public String getIdZDestino() {
        return idZDestino;
    }

    public void setIdZDestino(String idZDestino) {
        this.idZDestino = idZDestino;
    }

    public String getIdZsalida() {
        return idZsalida;
    }

    public void setIdZsalida(String idZsalida) {
        this.idZsalida = idZsalida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the patron
     */
    public String getPatron() {
        return patron;
    }

    /**
     * @param patron the patron to set
     */
    public void setPatron(String patron) {
        this.patron = patron;
    }
}
