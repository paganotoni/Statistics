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
public class OperacionesAnalisisZona {

    private OperacionesBasicas ope;
    private Coneccion con;
    private String[] idGestos;
    private String[] idParciales;

    public OperacionesAnalisisZona(Coneccion con, OperacionesBasicas ope) {
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

    public String[] getGestos(String idJuego) {
        String[] result = new String[1];
        result[0] = "";
        try {
            LinkedList lst = con.devuelveColumnaString("select nombre from gesto", "nombre");
            result = new String[lst.size() + 1];
            result[0] = "Todos";
            for (int i = 1; i < lst.size() + 1; i++) {
                result[i] = lst.get(i - 1).toString();
            }
        } catch (Exception e) {
        }
        this.cargarIdGestos();
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

    public void cargarIdGestos() {
        String[] result = new String[1];
        result[0] = "";
        try {
            LinkedList lst = con.devuelveColumnaString("select idgesto from gesto", "idgesto");
            result = new String[lst.size()];
            for (int i = 0; i < lst.size(); i++) {
                result[i] = lst.get(i).toString();
            }
        } catch (Exception e) {
        }
        this.idGestos = result;
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

        if (cboGesto.getSelectedIndex() > 0) {
            where = where + " and accion.idGesto = " + this.idGestos[cboGesto.getSelectedIndex() - 1] + " ";
        }

        if (cboP.getSelectedIndex() > 0 && cboZona.getSelectedIndex() > 0) {
            where = where + " and rally." + cboP.getSelectedItem().toString() + " = '" + cboZona.getSelectedIndex() + "' ";
        }

        result = from + where;
        return result;
    }

    public void analizar(String zona, JLabel TOTAL, JLabel EFFC, JLabel ERROR, String consulta) {
        try {
            int Total = con.devuelvePrimerRegistroEntero("select count(*) " + consulta);
            String sqlTotalZona = "select count(*) " + consulta + " and accion.idZsalida = " + zona + " ";
            int totZona = con.devuelvePrimerRegistroEntero(sqlTotalZona);
            int totEff = con.devuelvePrimerRegistroEntero(sqlTotalZona + " and accion.idvalor = 6 ");
            int totErr = con.devuelvePrimerRegistroEntero(sqlTotalZona + " and accion.idvalor = 1 ");

            String totalZona = String.valueOf(((float)totZona / Total) * 100);
            String efcZona = String.valueOf(((float) totEff / totZona) * 100);
            String errZona = String.valueOf(((float) totErr / totZona) * 100);
            
            if(totalZona.length()>4)
                totalZona = totalZona.substring(0,4);
            if(efcZona.length()>4)
                efcZona = efcZona.substring(0,4);
            if(errZona.length()>4)
                errZona = errZona.substring(0,4);
            
            TOTAL.setText("Total: " + totZona + " (" + totalZona + "%)");
            EFFC.setText("EFF: " + totEff + " (" + efcZona + "%)");
            ERROR.setText("ERR: " + totErr + " (" + errZona + "%)");
            if (totZona == 0) {
                TOTAL.setText("");
                EFFC.setText("");
                ERROR.setText("");
            }
        } catch (Exception e) {
            TOTAL.setText("");
            EFFC.setText("");
            ERROR.setText("");
        }
    }
}
