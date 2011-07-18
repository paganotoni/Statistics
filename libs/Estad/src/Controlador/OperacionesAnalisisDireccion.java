/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author Jakolov
 */
public class OperacionesAnalisisDireccion {

    private OperacionesBasicas ope;
    private Coneccion con;
    private String[] idParciales;

    public OperacionesAnalisisDireccion(Coneccion con, OperacionesBasicas ope) {
        this.ope = ope;
        this.con = con;
    }

    public String[] getCodigosEquipos(String idJuego) {
        String[] result = new String[2];
        try {
            result[0] = con.devuelvePrimerRegistroString("select eqpPropio from juego where idjuego = " + idJuego);
            result[1] = con.devuelvePrimerRegistroString("select eqpOpp from juego where idjuego = " + idJuego);
        } catch (Exception e) {
        }
        return result;
    }

    public String[] getParciales(String idJuego) {
        String[] result = new String[1];
        result[0] = "";
        try {
            LinkedList lst = con.devuelveColumnaString("select numero from parcial where idJuego=" + idJuego, "numero");
            result = new String[lst.size() + 1];
            result[0] = "*";
            for (int i = 1; i < lst.size() + 1; i++) {
                result[i] = lst.get(i - 1).toString();
            }
        } catch (Exception e) {
        }
        cargarIdParciales(idJuego);
        return result;
    }

    public void cargarIdParciales(String idJuego) {
        String[] result = new String[1];
        result[0] = "";
        try {
            LinkedList lst = con.devuelveColumnaString("select idParcial from parcial where idJuego=" + idJuego, "idparcial");
            result = new String[lst.size()];
            for (int i = 0; i < lst.size(); i++) {
                result[i] = lst.get(i).toString();
            }
        } catch (Exception e) {
        }

        this.idParciales = result;
    }

    public String getCondicionSql(JComboBox cboEqp, JComboBox cboParcial, JComboBox cboGesto, JComboBox cboP, JComboBox cboZona) {
        String result = "";
        String select = " select count(*) ";
        String from = " from accion, rally ";
        String where = " where accion.idrally = rally.idrally ";
        where = where + " and accion.codequipo = '" + cboEqp.getSelectedItem().toString() + "' ";

        if (cboParcial.getSelectedIndex() > 0) {
            where = where + " and rally.idParcial = " + this.idParciales[cboParcial.getSelectedIndex() - 1] + " ";
        }


        if (cboGesto.getSelectedIndex() == 0) {
            where = where + " and accion.idGesto = 26 ";
        } else {
            where = where + " and accion.idGesto = 22 ";
        }

        if (cboP.getSelectedIndex() > 0 && cboZona.getSelectedIndex() > 0) {
            where = where + " and rally." + cboP.getSelectedItem().toString() + " = '" + cboZona.getSelectedIndex() + "' ";
        }

        result = from + where;
        return result;
    }

    public LinkedList<String> getSalidas(String cond) {
        LinkedList<String> result = new LinkedList<String>();
        try {
            result = con.devuelveColumnaString("select idzsalida " + cond, "idzsalida");
        } catch (Exception e) {
        }
        return result;
    }

    public LinkedList<String> getDestinos(String cond) {
        LinkedList<String> result = new LinkedList<String>();
        try {
            result = con.devuelveColumnaString("select idzdestino " + cond, "idzdestino");
        } catch (Exception e) {
        }
        return result;
    }

    public LinkedList<String> getValores(String cond) {
        LinkedList<String> result = new LinkedList<String>();
        try {
            result = con.devuelveColumnaString("select idvalor " + cond, "idvalor");
        } catch (Exception e) {
        }
        return result;
    }
}
