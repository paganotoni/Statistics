/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */

package Controlador;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jakolov
 * 
 */

public class OperacionesListaAcciones {
    private Coneccion con;
    private OperacionesBasicas ope;
   
    public OperacionesListaAcciones(){
        
    }

    public OperacionesListaAcciones(Coneccion con, OperacionesBasicas ope) {
        this.con = con;
        this.ope = ope;
    }
    
    public void setModelJugadores(String idJuego,JTable tbl){
        ope.setTableModelSQL(con, "Select texto as codigo,p as P, ap as aP, time as HORA from accion,rally where accion.idrally = rally.idRally and idJuego ="+idJuego, tbl);
        setAnchoColumnas(tbl);
    }
    
    private void setAnchoColumnas(JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(80);
        col = tbl.getColumnModel().getColumn(1);
        col.setPreferredWidth(25);
        
        col = tbl.getColumnModel().getColumn(2);
        col.setPreferredWidth(20);
        col = tbl.getColumnModel().getColumn(3);
        col.setPreferredWidth(60);
    }

    public int getTotalAcciones(String idJuego){
        int result = 0;
        try {
            result = con.devuelvePrimerRegistroEntero("select count(*) from accion where idJuego = "+idJuego);
        } catch (Exception e) {
        }
        return result;
    }
}
