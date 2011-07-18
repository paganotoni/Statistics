  /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Accion;
import Vista.FormPrincipal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author jakolov
 */
public class OperacionesControladorJuego {

    private Coneccion con;
    private OperacionesBasicas ope;
    //contantes para la evaluacion del patron del codigo.
    private static String GESTOS;
    private static String TIPOS;
    private static String VALORES;
    private static String ZONAS;
    private static String NUMEROS = "0123456789$";
    private static String PREFIJOS = "a*";
    //Ids de los Gestos actuales en el sistema
    private LinkedList<Integer> listaidGestos;
    //Ids de los Valores actuales en el sistema
    private LinkedList<Integer> listaidValores;
    //Ids de los Zonas actuales en el sistema
    private LinkedList<Integer> listaidZonas;
    //Ids de los Tipos actuales en el sistema
    private LinkedList<Integer> listaidTipos;
    //Codigos de los Jugadores de ambos equipos
    private LinkedList<String> listaCodigosPropio;
    private LinkedList<String> listaCodigosOpp;
    //Numeros de los Jugadores de ambos equipos
    private LinkedList<String> listaNumerosPropio;
    private LinkedList<String> listaNumerosOpp;
    //Codigos de ambos equipos
    private String codPropio;
    private String codOpp;
    //Codigo del Juego
    private String idJuego;
    private String idParcialActual;
    private int numeroParcialActual;
    private int maximoParcialActual;
    private String idRallyActual;
    //Lista de las evaluaciones que otorgan y producen puntos de los gestos
    private LinkedList<Integer> listaIdsOtorgan;
    private LinkedList<Integer> listaIdsProducen;
    private Evaluador evaluador;

    //Datos del juego
    private int ptosPropios;
    private int ptosOpp;
    private int posP;
    private int posAp;
    private String idEqpSaca;
    private String tipoJuego;

    public OperacionesControladorJuego() {
    }

    public OperacionesControladorJuego(Coneccion con, OperacionesBasicas ope,
            String codPropio, String codOpp, String idJuego) {

        this.con = con;
        this.ope = ope;
        this.idJuego = idJuego;

        //Codigos de los equipos
        this.codPropio = codPropio;
        this.codOpp = codOpp;

        //Cargamos GESTOS, TIPOS, ZONAS y VALORES.
        this.cargarGestos();
        this.cargarTipos();
        this.cargarZona();
        this.cargarValores();

        //Cargar los ids de los Gestos, de los Valores, y de las Zonas
        this.cargarIdGestos();
        this.cargarIdValores();
        this.cargarIdZonas();
        this.cargarIdTipos();

        //Cargar los ids de los Jugadores
        this.cargarCodPropios();
        this.cargarNumerosPropios();
        this.cargarCodOpp();
        this.cargarNumerosOpp();

        //carga el id del rally actual
        this.cargarParcialActual();
        this.cargarNumeroParcialActual();
        this.cargarMaximoParcial();
        this.cargarRallyActual();
        this.cargarSaqueActual();
        //carga la lista de las evaluaciones que producen y otorgan
        this.cargarListaProduce();
        this.cargarListaOtorga();

        this.cargarPtosPropios();
        this.cargarPtosOpp();
        this.cargarTipoJuego(idJuego);
        evaluador = new Evaluador(this.PREFIJOS, this.NUMEROS, this.GESTOS, this.VALORES, this.TIPOS, this.ZONAS);

    }

    private void cargarRallyActual() {
        try {
            this.idRallyActual = con.devuelvePrimerRegistroString("Select max(idrally) from rally where idParcial = " + this.idParcialActual);
        } catch (Exception e) {
        }
    }

    private void cargarSaqueActual() {
        try {
            this.idEqpSaca = con.devuelvePrimerRegistroString("select saque from rally where idrally = " + this.idRallyActual);
        } catch (Exception e) {
        }
    }

    private void cargarParcialActual() {
        try {
            this.idParcialActual = con.devuelvePrimerRegistroString("Select max(idparcial) from parcial where idJuego = " + idJuego);
        } catch (Exception e) {
        }
    }

    private void cargarNumeroParcialActual() {
        try {
            this.numeroParcialActual = con.devuelvePrimerRegistroEntero("select count(*) from parcial where idJuego =" + this.idJuego);
        //System.out.println(this.numeroParcialActual);
        } catch (Exception e) {
        }
    }

    private void cargarTipoJuego(String idJuego) {
        try {
            this.tipoJuego = con.devuelvePrimerRegistroString("select tipo from juego where idJuego =" + idJuego);
        //System.out.println(tipoJuego);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarPtosPropios() {
        try {
            this.ptosPropios = Integer.parseInt(con.devuelvePrimerRegistroString("select ptopropio from rally where idRally = " + this.idRallyActual));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarPtosOpp() {
        try {
            this.ptosOpp = Integer.parseInt(con.devuelvePrimerRegistroString("select ptoopp from rally where idRally = " + this.idRallyActual));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarListaOtorga() {
        try {
            this.listaIdsOtorgan = con.devuelveColumnaEntero("select otorga from gesto", "otorga");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarListaProduce() {
        try {
            this.listaIdsProducen = con.devuelveColumnaEntero("select produce from gesto", "produce");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarCodPropios() {
        try {
            this.listaCodigosPropio = con.devuelvePrimeraColumnaString("select codigo from jugador,jugjue " +
                    "where jugjue.codigo = jugador.codigo " +
                    "and jugjue.idjuego = " + idJuego + " " +
                    "and jugador.codigoequipo = '" + codPropio + "'");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarCodOpp() {
        try {
            this.listaCodigosOpp = con.devuelvePrimeraColumnaString("select codigo from jugador,jugjue " +
                    "where jugjue.codigo = jugador.codigo " +
                    "and jugjue.idjuego = " + idJuego + " " +
                    "and jugador.codigoequipo = '" + codOpp + "'");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarNumerosPropios() {
        try {
            this.listaNumerosPropio = con.devuelvePrimeraColumnaString("select numero from jugador,jugjue " +
                    "where jugjue.codigo = jugador.codigo " +
                    "and jugjue.idjuego = " + idJuego + " " +
                    "and jugador.codigoequipo = '" + codPropio + "'");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarNumerosOpp() {
        try {
            this.listaNumerosOpp = con.devuelvePrimeraColumnaString("select numero from jugador,jugjue " +
                    "where jugjue.codigo = jugador.codigo " +
                    "and jugjue.idjuego = " + idJuego + " " +
                    "and jugador.codigoequipo = '" + codOpp + "'");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void cargarIdTipos() {
        try {
            this.listaidTipos = con.devuelvePrimeraColumnaEntero("select idtipo from tipo");
        } catch (Exception ex) {
            ex.getCause();
        }

    }

    private void cargarIdZonas() {
        try {
            this.listaidZonas = con.devuelvePrimeraColumnaEntero("select idzona from zona");
        } catch (Exception ex) {
            ex.getCause();
        }

    }

    private void cargarIdGestos() {
        try {
            this.listaidGestos = con.devuelvePrimeraColumnaEntero("select idgesto from gesto");
        } catch (Exception ex) {
            ex.getCause();
        }
    }

    private void cargarIdValores() {
        try {
            this.listaidValores = con.devuelvePrimeraColumnaEntero("select idvalor from valor");
        } catch (Exception ex) {
            ex.getCause();
        }
    }

    private void cargarGestos() {
        try {
            GESTOS = "";
            LinkedList<String> lista = con.devuelvePrimeraColumnaString("select letra from gesto");
            Iterator i = lista.iterator();
            while (i.hasNext()) {
                GESTOS = GESTOS + i.next();
            }
        } catch (Exception e) {
        }
    }

    private void cargarTipos() {
        try {
            TIPOS = "";
            LinkedList<String> lista = con.devuelvePrimeraColumnaString("select letra from tipo");
            Iterator i = lista.iterator();
            while (i.hasNext()) {
                TIPOS = TIPOS + i.next();
            }
        } catch (Exception e) {
        }
    }

    private void cargarValores() {
        try {
            VALORES = "";
            LinkedList<String> lista = con.devuelvePrimeraColumnaString("select letra from valor");
            Iterator i = lista.iterator();
            while (i.hasNext()) {
                VALORES = VALORES + i.next();
            }
        } catch (Exception e) {
        }
    }

    private void cargarZona() {
        try {
            ZONAS = "";
            LinkedList<String> lista = con.devuelvePrimeraColumnaString("select letra from zona");
            Iterator i = lista.iterator();
            while (i.hasNext()) {
                ZONAS = ZONAS + i.next();
            }
        } catch (Exception e) {
        }
    }

    public boolean isEventoValido(String str) {

        boolean result = false;
        Pattern cambio = Pattern.compile("C[0123456789]{1,2}?:[0123456789]{1,2}?");
        Matcher m = cambio.matcher(str);

        String idEquipo = this.codPropio;
        if (str.startsWith("a")) {
            idEquipo = this.codOpp;
            str = str.substring(1);
        }

        if (m.find(0)) {
            //cambio de jugadores
        } else if (str.equalsIgnoreCase("T")) {
            //tiempo
        } else if (str.equalsIgnoreCase("LIN")) {
            //Alineaciones
        } else if (str.equalsIgnoreCase("ROT- DER")) {
        } else if (str.equalsIgnoreCase("ROT+ DER")) {
        } else if (str.equalsIgnoreCase("ROT- IZQ")) {
        } else if (str.equalsIgnoreCase("ROT* IZQ")) {
        } else if (str.equalsIgnoreCase("FRD")) {
        } else if (str.equalsIgnoreCase("FRI")) {
        }
        return result;
    }

    public Accion[] getAcciones(String str) {
        Accion[] acciones = evaluador.procesar(str);

        for (int i = 0; i < acciones.length; i++) {
            String prefijo = getDePatron("P", acciones[i].getCodigo(), acciones[i].getPatron());
            String numero = getDePatron("N", acciones[i].getCodigo(), acciones[i].getPatron());
            String gesto = getDePatron("F", acciones[i].getCodigo(), acciones[i].getPatron());
            String valor = getDePatron("E", acciones[i].getCodigo(), acciones[i].getPatron());
            String tipo = getDePatron("T", acciones[i].getCodigo(), acciones[i].getPatron());
            String salida = getDePatron("S", acciones[i].getCodigo(), acciones[i].getPatron());
            String destino = getDePatron("D", acciones[i].getCodigo(), acciones[i].getPatron());

            String idJugador = "";
            String codEquipo = "";
            String idGesto = "";
            String idValor = "";
            String idTipo = "";
            String idSalida = "";
            String idDestino = "";
            if (prefijo.equals("*")) {
                codEquipo = this.codPropio;
                if (numero != null && numero.length() > 0 && this.listaNumerosPropio.indexOf(numero) != -1) {
                    idJugador = this.listaCodigosPropio.get(this.listaNumerosPropio.indexOf(numero));
                }

            } else {
                codEquipo = this.codOpp;
                if (numero != null && numero.length() > 0 && this.listaNumerosOpp.indexOf(numero) != -1) {
                    idJugador = this.listaCodigosOpp.get(this.listaNumerosOpp.indexOf(numero));
                }
            }

            if (gesto != null && gesto.length() > 0) {
                idGesto = String.valueOf(this.listaidGestos.get(this.GESTOS.indexOf(gesto)));
            }

            if (valor != null && valor.length() > 0) {
                idValor = String.valueOf(this.listaidValores.get(this.VALORES.indexOf(valor)));
            }

            if (tipo != null && tipo.length() > 0) {
                idTipo = String.valueOf(this.listaidTipos.get(this.TIPOS.indexOf(tipo)));
            }
            if (salida != null && salida.length() > 0) {
                idSalida = String.valueOf(this.listaidZonas.get(this.ZONAS.indexOf(salida)));
            }
            if (destino != null && destino.length() > 0) {
                idDestino = String.valueOf(this.listaidZonas.get(this.ZONAS.indexOf(destino)));
            }
            acciones[i].setIdEquipo(codEquipo);
            acciones[i].setIdJugador(idJugador);
            acciones[i].setIdJuego(this.idJuego);
            acciones[i].setIdGesto(idGesto);
            acciones[i].setIdValor(idValor);
            acciones[i].setIdTipo(idTipo);
            acciones[i].setIdZsalida(idSalida);
            acciones[i].setIdZDestino(idDestino);
        }
        return acciones;
    }

    public String getDePatron(String let, String str, String patron) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(patron.charAt(i)).equals(let)) {
                res += String.valueOf(str.charAt(i));
            }
        }
        return res;
    }

    public void guardarAccion(Accion a) {
        try {
            this.idParcialActual = con.devuelvePrimerRegistroString("Select max(idparcial) from parcial where idJuego = " + idJuego);
            String idRally = String.valueOf(con.devuelvePrimerRegistroEntero("select max(idRally) from rally where idParcial = '" + idParcialActual + "' "));
            con.ejecutaStatement("insert into accion(codJugador, " +
                    "codEquipo,idJuego, idgesto,idvalor,idtipo,idzsalida," +
                    "idzdestino,idrally,rd,pso,texto,error,idRally) values ('" + a.getIdJugador() + "'," +
                    "'" + a.getIdEquipo() + "','" + a.getIdJuego() + "','" + a.getIdGesto() + "','" + a.getIdValor() + "'," +
                    "'" + a.getIdTipo() + "','" + a.getIdZsalida() + "','" + a.getIdZDestino() + "',0,'','','" + a.getCodigo() + "'," + a.getError() + "," + idRally + ") ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cambioDeRally(Accion a) {
        try {
            this.posP = this.getPosP();
            this.posAp = this.getPosAP();
            int idGesto = Integer.parseInt(a.getIdGesto());
            int idValor = Integer.parseInt(a.getIdValor());
            int indGesto = this.listaidGestos.indexOf(idGesto);
            //String valor = String.valueOf(this.VALORES.charAt(this.listaidValores.indexOf(idValor)));
            if (listaIdsOtorgan.get(indGesto) == idValor) {
                if (a.getIdEquipo().equals(this.codPropio)) {
                    ptosOpp = ptosOpp + 1;
                    if (this.idEqpSaca.equals(this.codPropio)) {
                        this.idEqpSaca = this.codOpp;
                        if (this.posAp > 1) {
                            this.posAp = this.posAp - 1;
                        } else if (posAp == 1) {
                            this.posAp = 6;
                        }
                    }
                } else {
                    ptosPropios = ptosPropios + 1;
                    if (this.idEqpSaca.equals(this.codOpp)) {
                        this.idEqpSaca = this.codPropio;
                        if (this.posP > 1) {
                            this.posP = this.posP - 1;
                        } else if (posP == 1) {
                            this.posP = 6;
                        }
                    }
                }
            } else if (listaIdsProducen.get(indGesto) == idValor) {
                if (a.getIdEquipo().equals(this.codPropio)) {
                    ptosPropios = ptosPropios + 1;
                    if (this.idEqpSaca.equals(this.codOpp)) {
                        this.idEqpSaca = this.codPropio;
                        if (this.posP > 1) {
                            this.posP = this.posP - 1;
                        } else if (posP == 1) {
                            this.posP = 6;
                        }
                    }
                } else {
                    ptosOpp = ptosOpp + 1;
                    if (this.idEqpSaca.equals(this.codPropio)) {
                        this.idEqpSaca = this.codOpp;
                        if (this.posAp > 1) {
                            this.posAp = this.posAp - 1;
                        } else if (posAp == 1) {
                            this.posAp = 6;
                        }
                    }
                //System.out.println(ptosOpp);
                }
            }
            if (this.ptosPropios >= this.maximoParcialActual && (this.ptosPropios - this.ptosOpp) >= 2) {
                this.ptosPropios = 0;
                this.ptosOpp = 0;
                cambioSet(this.codPropio);
            } else if (this.ptosOpp >= this.maximoParcialActual && (this.ptosOpp - this.ptosPropios) >= 2) {
                this.ptosPropios = 0;
                this.ptosOpp = 0;
                cambioSet(this.codOpp);
            }
            this.nuevoRally();
        } catch (Exception e) {
        }

    }

    public void cambioSet(String codGanador) {
        String posequipos = "0";
        try {
            posequipos = con.devuelvePrimerRegistroString("select posequipos from parcial where idParcial= " + this.idParcialActual);
        } catch (Exception e) {
        }
        try {
            con.ejecutaStatement("update parcial set codganador= '" + codGanador + "' where idParcial=" + this.idParcialActual);
        } catch (Exception e) {
        }
        if (posequipos.equals("0")) {
            posequipos = "1";
        } else {
            posequipos = "0";
        }
        if (this.tipoJuego.equalsIgnoreCase("3 de 5")) {
            this.numeroParcialActual++;
            if (this.numeroParcialActual < 5) {
                try {

                    con.ejecutaStatement("insert into parcial(idJuego, numero, maximo,posequipos) " +
                            "values(" + this.idJuego + ",'" + this.numeroParcialActual + "','25','" + posequipos + "')");
                } catch (Exception e) {
                }
            } else if (this.numeroParcialActual == 5) {
                try {
                    con.ejecutaStatement("insert into parcial(idJuego, numero, maximo,posequipos) " +
                            "values(" + this.idJuego + ",'" + this.numeroParcialActual + "','15','" + posequipos + "')");
                } catch (Exception e) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fin Del Juego");
            }
            this.cargarParcialActual();
        } else {
            this.numeroParcialActual++;
            if (this.numeroParcialActual < 3) {
                try {
                    con.ejecutaStatement("insert into parcial(idJuego, numero, maximo,posequipos) " +
                            "values(" + this.idJuego + ",'" + this.numeroParcialActual + "','25','" + posequipos + "')");
                } catch (Exception e) {
                }
            } else if (this.numeroParcialActual == 3) {
                try {
                    con.ejecutaStatement("insert into parcial(idJuego, numero, maximo,posequipos) " +
                            "values(" + this.idJuego + ",'" + this.numeroParcialActual + "','15','" + posequipos + "')");
                } catch (Exception e) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fin Del Juego");
            }
        }

        FormPrincipal.getFormRotacion().setVisible(true);
    }

    public void nuevoRally() {
        try {
            con.ejecutaStatement("insert into rally(idParcial, ptopropio, ptoopp, p, ap,bp,saque)" +
                    "values(" + this.idParcialActual + ",'" + this.ptosPropios + "','" + this.ptosOpp + "','" + this.posP + "','" + this.posAp + "','1','" + this.idEqpSaca + "')");
        } catch (Exception e) {
        }
    }

    public int getPtosPropios() {
        int result = 0;
        try {
            result = con.devuelvePrimerRegistroEntero("select ptopropio from rally where idrally =" + idRallyActual);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getPtosOpp() {
        int result = 0;
        try {
            result = con.devuelvePrimerRegistroEntero("select ptoopp from rally where idrally =" + idRallyActual);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getPosP() {
        int result = 0;
        try {
            result = Integer.parseInt(con.devuelvePrimerRegistroString("select p from rally where idRally =" + idRallyActual));
        } catch (Exception e) {
        }
        return result;
    }

    public int getPosAP() {
        int result = 0;
        try {
            result = Integer.parseInt(con.devuelvePrimerRegistroString("select ap from rally where idRally =" + idRallyActual));
        } catch (Exception e) {
        }
        return result;
    }

    public void cargarMaximoParcial() {
        try {
            this.maximoParcialActual = Integer.parseInt(con.devuelvePrimerRegistroString("select maximo from parcial where idParcial = " + this.idParcialActual));
        } catch (Exception e) {
        }
    }
}
