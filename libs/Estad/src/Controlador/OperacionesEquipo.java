/*
 * OperacionesEquipo.java
 * 
 * Created on 9/09/2007, 05:04:55 AM
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
public class OperacionesEquipo {
    Coneccion con;
    OperacionesBasicas ope;
    public OperacionesEquipo(Coneccion con, OperacionesBasicas ope){
        this.con = con;
        this.ope = ope;
    }
    
    public void setModeloEquipos(JTable tbl){
        ope.setTableModelSQL(con, "select codigo as COD,nombre as Nombre ,Entrenador , Asistente  from Equipo", tbl);
        setAnchoColumnas(tbl);
    }
    
    public LinkedList getListaIndices(){
        LinkedList result =con.devuelveColumnaString("Select codigo from Equipo", "codigo");
        return result;
    }
    
    public void borrarEquipo(String cod){
        try{
            con.ejecutaStatement("delete from equipo where codigo ='"+cod+"'");
        }catch(Exception e){
            
        }
    }
    
    private void setAnchoColumnas(JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(30);
        col = tbl.getColumnModel().getColumn(1);
        col.setPreferredWidth(200);
    }
    
    
    
}
