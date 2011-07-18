/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author investigacion
 */
public class OperacionesJuegoCargado {

    private String rallyActual;
    private String parcialActual;
    OperacionesBasicas ope;
    Coneccion con;

    public OperacionesJuegoCargado(Coneccion con, OperacionesBasicas ope) {
        this.ope = ope;
        this.con = con;
    }

    public String[] getPosicionesEquipo(String idJuego, String codPropio, String codOpp) {
        cargarParcial(idJuego);
        cargarRally();
        String[] result = new String[2];
        try {
            String posiciones = con.devuelvePrimerRegistroString("select posequipos from parcial where idparcial = " + parcialActual);
            if (posiciones.equalsIgnoreCase("0")) {
                result[0] = codPropio;
                result[1] = codOpp;
            } else {
                result[0] = codOpp;
                result[1] = codPropio;
            }
        } catch (Exception e) {
        }
        return result;
    }

    public void cargarRally() {
        try {
            rallyActual = con.devuelvePrimerRegistroString("select max(idRally) from rally where idParcial = " + parcialActual);
        } catch (Exception e) {
        }
    }

    public void cargarParcial(String idJuego) {
        try {
            parcialActual = con.devuelvePrimerRegistroString("select max(idParcial) from parcial where idJuego = " + idJuego);
        } catch (Exception e) {
        }
    }

    public String getPosicionesEquipos() {
        String result = "0";
        try {
            result = con.devuelvePrimerRegistroString("select posequipos from parcial where idparcial = " + parcialActual);
        } catch (Exception e) {
        }
        return result;
    }

    public String[] cambiarPosicionesEquipo(String codPropio, String codOpp) {
        String posiciones = getPosicionesEquipos();
        String[] result = new String[2];
        try {
            if (posiciones.equals("0")) {
                con.ejecutaStatement("update parcial set posequipos = '1' where idParcial =" + parcialActual);
                result[0] = codOpp;
                result[1] = codPropio;
            } else {
                con.ejecutaStatement("update parcial set posequipos = '0' where idParcial =" + parcialActual);
                result[0] = codPropio;
                result[1] = codOpp;
            }
        } catch (Exception e) {
        }
        return result;
    }

    public String getSaque(String codPropio, String codOpp) {
        String result = codPropio;
        try {
            result = con.devuelvePrimerRegistroString("select saque from rally where idRally=" + this.rallyActual);
        } catch (Exception e) {
        }
        return result;
    }

    public String cambiarSaque(String saque, String codPropio, String codOpp) {
        if (saque.equals(codPropio)) {
            saque = codOpp;
        } else {
            saque = codPropio;
        }
        try {
            con.ejecutaStatement("update rally set saque = '" + saque + "' where idrally=" + this.rallyActual);
        } catch (Exception e) {
        }
        return saque;
    }

    public void subirPuntos(int sw, int ptos) {
        ptos = ptos + 1;
        if (sw == 0) {
            try {
                con.ejecutaStatement("update rally set ptopropio = '" + ptos + "' where idRally =" + this.rallyActual);
            } catch (Exception e) {
            }
        } else {
            try {
                con.ejecutaStatement("update rally set ptoopp = '" + ptos + "' where idRally =" + this.rallyActual);
            } catch (Exception e) {
            }
        }
    }

    public void bajarPuntos(int sw, int ptos) {
        ptos = ptos - 1;
        if (ptos < 0) {
            ptos = 0;
        }
        if (sw == 0) {
            try {
                con.ejecutaStatement("update rally set ptopropio = '" + ptos + "' where idRally =" + this.rallyActual);
            } catch (Exception e) {
            }
        } else {
            try {
                con.ejecutaStatement("update rally set ptoopp = '" + ptos + "' where idRally =" + this.rallyActual);
            } catch (Exception e) {
            }
        }
    }

    public int getPuntosPropios() {
        int result = 0;
        try {
            result = con.devuelvePrimerRegistroEntero("select ptopropio from rally where idrally =" + rallyActual);
        } catch (Exception e) {
        }
        return result;
    }

    public int getPuntosOpp() {
        int result = 0;
        try {
            result = con.devuelvePrimerRegistroEntero("select ptoopp from rally where idrally =" + rallyActual);
        } catch (Exception e) {
        }
        return result;
    }

    public int getSetsEquipo(String idJuego, String codPropio) {
        int result = 0;
        try {
            result = con.devuelvePrimerRegistroEntero("select count(*) from parcial where codganador = '" + codPropio + "' and idJuego = " + idJuego);
        } catch (Exception e) {
        }
        return result;
    }

    public void setRotacion(int idJuego, String codEquipo, JLabel[] labels, Color c, Color d, String codPropio) {
        this.cargarParcial(String.valueOf(idJuego));
        this.cargarRally();
        String sql = "";
        if (codEquipo == codPropio) {
            sql = "select p from rally where idRally = " + this.rallyActual;
        } else {
            sql = "select ap from rally where idRally = " + this.rallyActual;
        }
        int posP = 0;
        String numP = "0";
        try {
            posP = Integer.valueOf(con.devuelvePrimerRegistroString(sql));
        } catch (Exception e) {
            // e.printStackTrace();
        }

        try {
            String num_uno = con.devuelvePrimerRegistroString("select numuno from rotacion where idParcial=" + this.parcialActual + " and codeqp = '" + codEquipo + "'");
            String num_dos = con.devuelvePrimerRegistroString("select numdos from rotacion where idParcial=" + this.parcialActual + " and codeqp = '" + codEquipo + "'");
            String num_tre = con.devuelvePrimerRegistroString("select numtres from rotacion where idParcial=" + this.parcialActual + " and codeqp = '" + codEquipo + "'");
            String num_cua = con.devuelvePrimerRegistroString("select numcuatro from rotacion where idParcial=" + this.parcialActual + " and codeqp = '" + codEquipo + "'");
            String num_cin = con.devuelvePrimerRegistroString("select numcinco from rotacion where idParcial=" + this.parcialActual + " and codeqp = '" + codEquipo + "'");
            String num_sei = con.devuelvePrimerRegistroString("select numseis from rotacion where idParcial=" + this.parcialActual + " and codeqp = '" + codEquipo + "'");
            String num_pas = con.devuelvePrimerRegistroString("select numpas from rotacion where idParcial=" + this.parcialActual + " and codeqp = '" + codEquipo + "'");
            numP = num_pas;
            if (num_uno != null) {
                labels[0].setText(num_uno);
            }
            if (num_dos != null) {
                labels[1].setText(num_dos);
            }
            if (num_tre != null) {
                labels[2].setText(num_tre);
            }
            if (num_cua != null) {
                labels[3].setText(num_cua);
            }
            if (num_cin != null) {
                labels[4].setText(num_cin);
            }
            if (num_sei != null) {
                labels[5].setText(num_sei);
            }
            for (int i = 0; i < labels.length; i++) {
                if (labels[i].getText().equals(num_pas)) {
                    labels[i].setForeground(c);
                } else {
                    labels[i].setForeground(d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.ajustar(labels, posP, numP);
    }

    private void ajustar(JLabel[] lbl, int posP, String numP) {
        try {
            int sw = 0;
            while (sw == 0) {
                if (lbl[posP - 1].getText().equals(numP)) {
                    sw = 1;
                } else {
                    rotarMas(lbl);
                }
            }
        } catch (Exception e) {
        }

    }

    public void guardarPosP(JLabel[] lbl, int swPropio, Color c) {
        int pos = 0;
        for (int i = 0; i < lbl.length; i++) {
            if (lbl[i].getForeground().equals(c)) {
                pos = i + 1;
            }
        }

        try {
            if (swPropio == 0) {
                con.ejecutaStatement("update rally set P = " + pos + " where idRally = " + this.rallyActual);
            } else {
                con.ejecutaStatement("update rally set AP = " + pos + " where idRally = " + this.rallyActual);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void rotarMas(JLabel[] lbl) {
        String temp = lbl[0].getText();
        Color c = lbl[0].getForeground();
        lbl[0].setText(lbl[1].getText());
        lbl[0].setForeground(lbl[1].getForeground());
        lbl[1].setText(lbl[2].getText());
        lbl[1].setForeground(lbl[2].getForeground());
        lbl[2].setText(lbl[3].getText());
        lbl[2].setForeground(lbl[3].getForeground());
        lbl[3].setText(lbl[4].getText());
        lbl[3].setForeground(lbl[4].getForeground());
        lbl[4].setText(lbl[5].getText());
        lbl[4].setForeground(lbl[5].getForeground());
        lbl[5].setText(temp);
        lbl[5].setForeground(c);
        
    }

    public void rotarMenos(JLabel[] lbl) {
        String temp = lbl[5].getText();
        Color c = lbl[5].getForeground();
        lbl[5].setText(lbl[4].getText());
        lbl[5].setForeground(lbl[4].getForeground());
        lbl[4].setText(lbl[3].getText());
        lbl[4].setForeground(lbl[3].getForeground());
        lbl[3].setText(lbl[2].getText());
        lbl[3].setForeground(lbl[2].getForeground());
        lbl[2].setText(lbl[1].getText());
        lbl[2].setForeground(lbl[1].getForeground());
        lbl[1].setText(lbl[0].getText());
        lbl[1].setForeground(lbl[0].getForeground());
        lbl[0].setText(temp);
        lbl[0].setForeground(c);
    }
}
