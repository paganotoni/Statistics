/*
 * OperacionesTipos.java
 * 
 * Created on 18/09/2007, 02:06:28 PM
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
public class OperacionesTipo {
    private Coneccion con;
    private OperacionesBasicas ope;
    
    public OperacionesTipo(Coneccion con, OperacionesBasicas ope) {
        this.con = con;
        this.ope = ope;
    }

    public Coneccion getCon() {
        return con;
    }

    public OperacionesBasicas getOpe() {
        return ope;
    }
    
    public void setModeloTipos(JTable tbl){
        ope.setTableModelSQL(con, "select Letra , nombre from Tipo", tbl);
        setAnchoColumnas(tbl);
    }
    
    public LinkedList getListaIndices(){
        LinkedList result =con.devuelveColumnaString("Select idTipo from Tipo", "idTipo");
        return result;
    }
    
    public LinkedList getListaTipCre(){
        LinkedList result =con.devuelveColumnaString("Select tipCre from Tipo", "tipcre");
        return result;
    }
    
    public void borrarTipo(String cod){
        try{
            con.ejecutaStatement("delete from tipo where idTipo ='"+cod+"'");
        }catch(Exception e){
            
        }
    }
    
    public void insertarTipo(String letra, String nombre){
        try{
            con.ejecutaStatement("insert into tipo(letra,nombre) values ('"+letra+"','"+nombre+"') ");
        }catch(Exception e){
            
        }
    }
    public void actualizarTipo(int id ,String letra, String nombre){
        try{
            con.ejecutaStatement("update Tipo set letra = '"+letra+"', nombre = '"+nombre+"' where idTipo="+id);
        }catch(Exception e){
            
        }
    }
    
    
    private void setAnchoColumnas(JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(40);
        col = tbl.getColumnModel().getColumn(1);
        col.setPreferredWidth(150);
    }
    
}
