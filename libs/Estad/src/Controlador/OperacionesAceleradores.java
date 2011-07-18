/*
 * OperacionesAceleradores.java
 * 
 * Created on 25/09/2007, 04:18:06 PM
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
public class OperacionesAceleradores {
    Coneccion con;
    OperacionesBasicas ope;
    public OperacionesAceleradores(Coneccion con, OperacionesBasicas ope){
        this.con = con;
        this.ope = ope;
    }
    
    public void setModeloAceleradores(JTable tbl){
        ope.setTableModelSQL(con, "select codigo as COD,descripcion as Descripcion ,Acelerador from Acelerador", tbl);
        setAnchoColumnas(tbl);
    }
    
    public void borrarAcelerador(String cod){
        try{
            con.ejecutaStatement("delete from acelerador where idacelerador ='"+cod+"'");
        }catch(Exception e){
            
        }
    }
    
    public void insertarAcelerador(String cod,String acelerador,String descripcion){
        try{
            con.ejecutaStatement("insert into Acelerador(codigo,acelerador,descripcion) values ('"+cod+"','"+acelerador+"','"+descripcion+"')");
        }catch(Exception e){
            
        }
    }
    
    public void ActualizaAcelerador(String cod,String codigo,String acelerador, String descripcion){
        try{
            con.ejecutaStatement("update acelerador set codigo = '"+codigo+"',acelerador = '"+acelerador+"',descripcion='"+descripcion+"' where idacelerador ='"+cod+"'");
        }catch(Exception e){
            
        }
    }
    
    
    public LinkedList getListaIndices(){
        LinkedList result =con.devuelveColumnaString("Select idAcelerador from Acelerador", "idAcelerador");
        return result;
    }
    
    private void setAnchoColumnas(JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(50);
        col = tbl.getColumnModel().getColumn(1);
        col.setPreferredWidth(200);
        col = tbl.getColumnModel().getColumn(2);
        col.setPreferredWidth(120);
    }
}
