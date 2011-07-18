/*
 * OperacionesGesto.java
 * 
 * Created on 19/09/2007, 04:27:40 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jakolov
 */
public class OperacionesGesto {
    Coneccion con;
    OperacionesBasicas ope;
    
    public OperacionesGesto(Coneccion con, OperacionesBasicas ope){
        this.con = con;
        this.ope = ope;
    }
    
    public void insertarGesto(String letra,String nombre, String factor, String pct){
        try{
            con.ejecutaStatement("insert into Gesto(letra, nombre, factor, pct,tipcre) values('"+letra+"','"+nombre+"','"+factor+"','"+pct+"','0')");
            String idGesto = String.valueOf(con.devuelveRegistroInt("select idGesto from gesto where letra = '"+letra+"' and nombre = '"+nombre+"' and factor ='"+factor+"' and pct = '"+pct+"'", "idGesto"));
            LinkedList listaValores = getListaValores();
            Iterator i = listaValores.iterator(); 
            while(i.hasNext()){
                con.ejecutaStatement("insert into valges(idgesto,idvalor,valoracion) values("+idGesto+","+i.next().toString()+",1)");
            }           
        }catch(Exception e){
            e.printStackTrace();
        }
   }
    
    public void actualizarGesto(String id,String letra,String nombre, String factor, String pct){
        try{  
        con.ejecutaStatement("update gesto set letra='"+letra+"' , nombre = '"+nombre+"',factor='"+factor+"',pct='"+pct+"' where idGesto='"+id+"';");
        }catch(Exception e){
            
        }
    }
    
    public void setModeloGestos(JTable tbl){
        ope.setTableModelSQL(con, "select letra,nombre,factor, pct from Gesto", tbl);
        setAnchoColumnas(tbl);
    }
    
    public LinkedList getListaIndices(){
        LinkedList result =con.devuelveColumnaString("Select idGesto from Gesto", "idGesto");
        return result;
    }
    
    public LinkedList getListaValores(){
        LinkedList result =con.devuelveColumnaString("Select idValor from Valor", "idValor");
        return result;
    }
    
    public void borrarGesto(String cod){
        try{
            con.ejecutaStatement("delete from Gesto where idGesto ='"+cod+"'");
            con.ejecutaStatement("delete from valges where idgesto='"+cod+"'");
        }catch(Exception e){
            
        }
    }
    
    private void setAnchoColumnas(JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(50);
        col = tbl.getColumnModel().getColumn(1);
        col.setPreferredWidth(120);
        col = tbl.getColumnModel().getColumn(2);
        col.setPreferredWidth(50);
        col = tbl.getColumnModel().getColumn(3);
        col.setPreferredWidth(40);
    }
}
