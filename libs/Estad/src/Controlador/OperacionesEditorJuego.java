/*
 * OperacionesEditorJuego.java
 * 
 * Created on 27/09/2007, 03:24:01 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.LinkedList;
import javax.swing.JComboBox;

/**
 *
 * @author Jakolov
 */
public class OperacionesEditorJuego {

    private Coneccion con;
    private OperacionesBasicas ope;
    private int swAccion;

    public OperacionesEditorJuego(Coneccion con, OperacionesBasicas ope) {
        this.con = con;
        this.ope = ope;
    }

    public Coneccion getCon() {
        return con;
    }

    public void actualizarJuego(int idjuego, String tipo, String fase, String dia, String juego, String fecha,
            String ciudad, String coliseo, String espectadores, String recaudos, String eqpPropio,
            String eqpOpp, String comPropio, String comOpp) {
        try {
            con.ejecutaStatement("update juego set tipo = '" + tipo + "'," +
                    "fase = '" + fase + "'," +
                    "dia = '" + dia + "'," +
                    "juegoNumero = '" + juego + "'," +
                    "fecha = '" + fecha + "'," +
                    "ciudad = '" + ciudad + "'," +
                    "coliseo = '" + coliseo + "'," +
                    "espectadores = '" + espectadores + "'," +
                    "recaudos = '" + recaudos + "'," +
                    "eqpPropio ='" + eqpPropio + "'," +
                    "eqpOpp = '" + eqpOpp + "'," +
                    "comPropio = '" + comPropio + "'," +
                    "comOpp = '" + comOpp + "'" +
                    "where idjuego = " + idjuego);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void crearJuego(int idTorneo, String tipo, String fase, String dia, String juego, String fecha,
            String ciudad, String coliseo, String espectadores, String anotador, String jueces, String recaudos, String eqpPropio,
            String eqpOpp, String comOpp, String comPropio) {
        /*obtendremos el mayor id de la tabla*/


        try {
            //agregamos el juego a la lista
            con.ejecutaStatement("insert into juego (idtorneo,eqppropio,eqpopp,tipo,fase,dia,juegonumero,fecha,ciudad,coliseo,espectadores,recaudos,anotador,compropio,comopp,jueces)" +
                    " values (" + idTorneo + ",'" + eqpPropio + "','" + eqpOpp + "','" + tipo + "','" + fase + "','" + dia + "','" + juego + "','" + fecha + "','" + ciudad + "'," + "'" + coliseo + "','" + espectadores + "','" + recaudos + "','" + anotador + "','" + comPropio + "','" + comOpp + "','" + jueces + "')");
            //agregamos los jugadores al juego
            LinkedList listaOpp = con.devuelvePrimeraColumnaString("Select codigo from jugador where codigoEquipo='" + eqpOpp + "'");
            LinkedList listaPropio = con.devuelvePrimeraColumnaString("Select codigo from jugador where codigoEquipo='" + eqpPropio + "'");


            int max = 0;
            max = con.devuelvePrimerRegistroEntero("select max(idJuego) from juego");
            //este nuevo id debe ser mayor al mayor que este en la lista

            for (int i = 0; i < listaOpp.size(); i++) {
                con.ejecutaStatement("insert into jugjue(codigo,idjuego) values('" + listaOpp.get(i).toString() + "'," + max + ")");
            }

            for (int i = 0; i < listaPropio.size(); i++) {
                con.ejecutaStatement("insert into jugjue(codigo,idjuego) values('" + listaPropio.get(i).toString() + "'," + max + ")");
            }

            // Creamos un primer set para el juego, pero hay que identificar que tipo de juego es primero
            con.ejecutaStatement("insert into parcial(idJuego, numero, maximo,posequipos) " +
                    "values(" + max + ",'1','25','0')");

            String idParcial = String.valueOf(con.devuelvePrimerRegistroEntero("select max(idParcial) " +
                    "from parcial "));

            con.ejecutaStatement("insert into rally(idParcial, ptopropio, ptoopp, posp, posap,bp,saque,p,ap)" +
                    "values(" + idParcial + ",'0','0','0','0','1','" + eqpPropio + "','0','0')");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public OperacionesBasicas getOpe() {
        return ope;
    }

    public void cuadraCajaTorneos(JComboBox cbo) {
        ope.setDatosCombo("Select nombre from torneo", cbo, con, "nombre");
    }

    public void cuadraCajaEquipos(JComboBox cbo) {
        ope.setDatosCombo("Select codigo from equipo", cbo, con, "codigo");
    }

    public String getNombreEquipo(String cod) {
        String resultado = con.devuelveRegistroString("Select nombre from equipo where codigo = '" + cod + "'", "nombre");
        return resultado;
    }

    public String getEntrenadorEquipo(String cod) {
        String resultado = con.devuelveRegistroString("Select entrenador from equipo where codigo = '" + cod + "'", "entrenador");
        return resultado;
    }

    public LinkedList<Integer> getListaIdTorneos() {
        return con.devuelveColumnaEntero("Select idTorneo from torneo", "idTorneo");
    }

    public LinkedList<String> getListaCodEquipos() {
        return con.devuelveColumnaString("Select codigo from equipo", "codigo");
    }
}
