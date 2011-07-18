/*
 * OperacionesTorneo.java
 * 
 * Created on 9/09/2007, 05:25:23 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
/**
 *
 * @author Jakolov
 */
public class OperacionesTorneo {
    Coneccion con;
    OperacionesBasicas ope;
    public OperacionesTorneo(Coneccion con, OperacionesBasicas ope){
        this.con = con;
        this.ope = ope;
    }
    
    public void setModeloTorneo(JTable tbl){
        ope.setTableModelSQL(con, "select torneo.nombre as Nombre ,torneo.fechaIni as Inicio, Temporada.nombre as Temp from torneo,Temporada where torneo.idTemp = temporada.idTemporada", tbl);
        setAnchoColumnas(tbl);
    }
    
    public LinkedList getListaIndices(){
        LinkedList result =con.devuelveColumnaString("Select idTorneo from Torneo", "idTorneo");
        return result;
    }
    
    public void borrarTorneo(String cod){
        try {
                con.ejecutaStatement("delete from torneo where idTorneo ="+cod+"");
        } catch (Exception e) {
        
        }
          
    }
    
    private void setAnchoColumnas(JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(220);
    }
}
