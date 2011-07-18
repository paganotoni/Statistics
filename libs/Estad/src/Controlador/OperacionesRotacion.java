/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.LinkedList;
import javax.swing.JTable;

/**
 *
 * @author Jakolov
 */
public class OperacionesRotacion {

    private Coneccion con;
    private OperacionesBasicas ope;
    private int idParcial;
    private int idJuego;
    private String codPropio;
    private String codOpp;
    private LinkedList codJugadoresPropio;
    private LinkedList numJugadoresPropio;
    private LinkedList codJugadoresOpp;
    private LinkedList numJugadoresOpp;
    private LinkedList jugadoresParcialPropio;
    private LinkedList posicionesParcialPropio;
    private LinkedList jugadoresParcialOpp;
    private LinkedList posicionesParcialOpp;

    public OperacionesRotacion() {
    }

    public OperacionesRotacion(Coneccion con, OperacionesBasicas ope, int idJuego, String codPropio, String codOpp) {
        this.con = con;
        this.ope = ope;

        this.idJuego = idJuego;
        this.codPropio = codPropio;
        this.codOpp = codOpp;
        this.idParcial = this.getIdParcialActual();

        this.codJugadoresPropio = this.getListaCodJugadoresPropio(String.valueOf(idParcial));
        this.codJugadoresOpp = this.getListaCodJugadoresOpp(String.valueOf(idParcial));
        this.numJugadoresPropio = this.getListaNumJugadoresPropio(String.valueOf(idParcial));
        this.numJugadoresOpp = this.getListaNumJugadoresOpp(String.valueOf(idParcial));
    //this.jugadoresParcialPropio = this.getJugadoresParcialPropio(String.valueOf(idParcial));
    //this.jugadoresParcialOpp = this.getJugadoresParcialOpp(String.valueOf(idParcial));
    //this.posicionesParcialPropio = this.getPosicionesParcialPropio(String.valueOf(idParcial));
    //this.posicionesParcialOpp = this.getPosicionesParcialOpp(String.valueOf(idParcial));
    }

    public int RevisarAlineacion(javax.swing.JTable tbl) {
        int result = 0;
        //1. Revisar que no hayan repetidos.
        try {
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 7; j++) {
                    String primero = tbl.getValueAt(0, i).toString();
                    String segundo = tbl.getValueAt(0, j).toString();

                    String tercero = tbl.getValueAt(1, i).toString();
                    String cuarto = tbl.getValueAt(1, j).toString();

                    if (primero.equals(segundo) && i != j) {
                        result = 1;
                        i = 7;
                        j = 7;
                    }

                    if (tercero.equals(cuarto) && i != j) {
                        result = 1;
                        i = 7;
                        j = 7;
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            result = 1;
        }

        try {
            if (result == 0) {
                //2. Revisar que estos numeros pertenezcan a los equipos.
                for (int i = 1; i < 7; i++) {
                    if (!numJugadoresPropio.contains(Integer.parseInt(tbl.getValueAt(0, i).toString()))) {
                        result = 2;
                        i = 7;
                    }
                    if (!numJugadoresOpp.contains(Integer.parseInt(tbl.getValueAt(1, i).toString()))) {
                        result = 2;
                        i = 7;
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            result = 2;
        }


        if (result == 0 || result == 2) {
            //3.revisar que el pasador este en la rotacion
            String pasPro = tbl.getValueAt(0, 7).toString();
            String pasOpp = tbl.getValueAt(1, 7).toString();
            boolean pro = false;
            boolean opp = false;
            for (int i = 1; i < 7; i++) {
                if (tbl.getValueAt(0, i).toString().equals(pasPro)) {
                    pro = true;
                }
                if (tbl.getValueAt(1, i).toString().equals(pasOpp)) {
                    opp = true;
                }
            }
            if (!pro || !opp) {
                if (result == 2) {
                    result = 5;
                } else {
                    result = 3;
                }
            }
        }
        return result;
    }

    public String[][] getArregloRotacion() {
        String[][] result = new String[2][6];
        return result;
    }

    public LinkedList getPosicionesParcialPropio(String idParcial) {
        LinkedList result = con.devuelveColumnaEntero("Select inicial from jugparcial,jugador where idparcial = " + idParcial + " and jugador.codigoequipo = " + codPropio, "inicial");
        return result;
    }

    public LinkedList getJugadoresParcialPropio(String idParcial) {
        LinkedList result = con.devuelveColumnaEntero("Select codjugador from jugparcial,jugador where idparcial = " + idParcial + " and jugador.codigoequipo = " + codPropio, "codjugador");
        return result;
    }

    public LinkedList getPosicionesParcialOpp(String idParcial) {
        LinkedList result = con.devuelveColumnaEntero("Select inicial from jugparcial,jugador where idparcial = " + idParcial + " and jugador.codigoequipo = " + codOpp, "inicial");
        return result;
    }

    public LinkedList getJugadoresParcialOpp(String idParcial) {
        LinkedList result = con.devuelveColumnaEntero("Select codjugador from jugparcial,jugador where idparcial = " + idParcial + " and jugador.codigoequipo = " + codOpp, "codjugador");
        return result;
    }

    public LinkedList getListaNumJugadoresPropio(String idJuego) {
        LinkedList result = con.devuelveColumnaEntero("Select jugador.numero from jugador,jugjue where jugador.codigo = jugjue.codigo and " +
                "jugjue.idJuego=" + idJuego + " and jugador.codigoEquipo ='" + codPropio + "'", "jugador.numero");
        return result;
    }

    public LinkedList getListaCodJugadoresPropio(String idJuego) {
        LinkedList result = con.devuelveColumnaString("Select jugador.codigo from jugjue, jugador where jugador.codigo = jugjue.codigo and" +
                " idJuego=" + idJuego + " and jugador.codigoequipo = '" + codPropio + "'", "codigo");
        return result;
    }

    public LinkedList getListaNumJugadoresOpp(String idJuego) {
        LinkedList result = con.devuelveColumnaEntero("Select jugador.numero from jugador,jugjue where jugador.codigo = jugjue.codigo and " +
                "jugjue.idJuego=" + idJuego + " and jugador.codigoEquipo ='" + codOpp + "'", "jugador.numero");
        return result;
    }

    public LinkedList getListaCodJugadoresOpp(String idJuego) {

        LinkedList result = con.devuelveColumnaString("Select jugador.codigo from jugjue, jugador where jugador.codigo = jugjue.codigo and" +
                " idJuego=" + idJuego + " and jugador.codigoequipo = '" + codOpp + "'", "codigo");
        return result;
    }

    public int getIdParcialActual() {
        int result = 0;
        try {
            result = con.devuelvePrimerRegistroEntero("select max(idParcial) from parcial where idJuego = " + this.idJuego);
        } catch (Exception e) {
        }
        return result;
    }

    public void guardarRotaciones(JTable tbl, String idParcial, String codPropio, String codOpp) {
        String uno_pro = tbl.getValueAt(0, 1).toString();
        String dos_pro = tbl.getValueAt(0, 2).toString();
        String tre_pro = tbl.getValueAt(0, 3).toString();
        String cua_pro = tbl.getValueAt(0, 4).toString();
        String cin_pro = tbl.getValueAt(0, 5).toString();
        String sei_pro = tbl.getValueAt(0, 6).toString();
        String pas_pro = tbl.getValueAt(0, 7).toString();
        int cont = 0;
        try {
            cont = con.devuelvePrimerRegistroEntero("select idRotacion from rotacion where codeqp = '" + codPropio + "' and idParcial = " + idParcial);
        } catch (Exception e) {
        }
        if (cont == 0) {
            try {
                con.ejecutaStatement("insert into rotacion (numuno,numdos,numtres,numcuatro,numcinco,numseis,numpas,codEqp,idparcial) values ('" + uno_pro + "','" + dos_pro + "','" + tre_pro + "','" + cua_pro + "','" + cin_pro + "','" + sei_pro + "','" + pas_pro + "','" + codPropio + "','" + idParcial + "')");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                con.ejecutaStatement("update rotacion set numuno = '" + uno_pro + "', numdos = '" + dos_pro + "',numtres = '" + tre_pro + "',numcuatro = '" + cua_pro + "',numcinco = '" + cin_pro + "',numseis = '" + sei_pro + "',numpas = '" + pas_pro + "',codEqp = '" + codPropio + "',idparcial = '" + idParcial + "' where idrotacion = " + cont);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String uno_opp = tbl.getValueAt(1, 1).toString();
        String dos_opp = tbl.getValueAt(1, 2).toString();
        String tre_opp = tbl.getValueAt(1, 3).toString();
        String cua_opp = tbl.getValueAt(1, 4).toString();
        String cin_opp = tbl.getValueAt(1, 5).toString();
        String sei_opp = tbl.getValueAt(1, 6).toString();
        String pas_opp = tbl.getValueAt(1, 7).toString();
        int cont2 = 0;
        try {
            cont2 = con.devuelvePrimerRegistroEntero("select idRotacion from rotacion where codeqp = '" + codOpp + "' and idParcial = " + idParcial);
        } catch (Exception e) {
        }
        if (cont2 == 0) {
            try {
                con.ejecutaStatement("insert into rotacion (numuno,numdos,numtres,numcuatro,numcinco,numseis,numpas,codEqp,idparcial) values ('" + uno_opp + "','" + dos_opp + "','" + tre_opp + "','" + cua_opp + "','" + cin_opp + "','" + sei_opp + "','" + pas_opp + "','" + codOpp + "','" + idParcial + "')");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                con.ejecutaStatement("update rotacion set numuno = '" + uno_opp + "', numdos = '" + dos_opp + "',numtres = '" + tre_opp + "',numcuatro = '" + cua_opp + "',numcinco = '" + cin_opp + "',numseis = '" + sei_opp + "',numpas = '" + pas_opp + "',codEqp = '" + codOpp+ "',idparcial = '" + idParcial + "' where idrotacion = " + cont2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
