/*
 * OperacionesDetalleEquipo.java
 * 
 * Created on 12/09/2007, 04:28:30 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import Modelo.Jugador;
/**
 *
 * @author Jakolov
 */
public class OperacionesDetalleEquipo {
    
    private Coneccion con;
    private OperacionesBasicas ope;
   
    public OperacionesDetalleEquipo(){
        
    }

    public OperacionesDetalleEquipo(Coneccion con, OperacionesBasicas ope) {
        this.con = con;
        this.ope = ope;
    }
    
    public LinkedList getListaJugadores(String cod){
        LinkedList result = new LinkedList();
        String query = "select j.numero, j.codigo, j.nombre,j.estatura, j.peso from jugador as j, equipo as e where j.codigoEquipo = e.codigo and e.codigo = '"+cod+"'";
        try{
        Statement sta = con.getCon().createStatement();
        ResultSet rs = sta.executeQuery(query); 
        while(rs.next()){
            result.add(rs.getString("codigo"));
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public void borrarJugador(String cod){
        try{
            con.ejecutaStatement("Delete from jugador where codigo='"+cod+"'");    
        }catch(Exception e){
            
        }
        
    }
    
    public void setModelJugadores(String cod,JTable tbl){
        ope.setTableModelSQL(con, "select j.numero as num, j.codigo as cod, j.nombre,j.estatura, j.peso from jugador as j, equipo as e where j.codigoEquipo = e.codigo and e.codigo = '"+cod+"'", tbl);
        setAnchoColumnas(tbl);
    }
    
   private void setAnchoColumnas(JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(30);
        col = tbl.getColumnModel().getColumn(1);
        col.setPreferredWidth(70);
        col = tbl.getColumnModel().getColumn(2);
        col.setPreferredWidth(240);
    }
   
   public void setEntrenador(String cod, String entrenador){
       try{
         con.ejecutaStatement("Update Equipo set Entrenador = '"+entrenador+"' where codigo='"+cod+"'");
        }catch(Exception e){
            
        }
   }
   
   public void setAsistente(String cod, String Asistente){
       try{
          con.ejecutaStatement("Update Equipo set Asistente = '"+Asistente+"' where codigo='"+cod+"'");
        }catch(Exception e){
            
        }  
   }
   
   public void setCiudad(String cod, String Ciudad){
       try{
         con.ejecutaStatement("Update Equipo set Ciudad = '"+Ciudad+"' where codigo='"+cod+"'");
        }catch(Exception e){
            
        }
   }
   
   
   public String getEntrenador(String cod){
        String result = con.devuelveRegistroString("Select Entrenador from equipo where codigo='"+cod+"'", "Entrenador");
        return result;
    }
    
    public String getAsistente(String cod){
        String result = con.devuelveRegistroString("Select Asistente from equipo where codigo='"+cod+"'", "Asistente");
        return result;
    }
    
    public String getCiudad(String cod){
        String result = con.devuelveRegistroString("Select Ciudad from equipo where codigo='"+cod+"'", "Ciudad");
        return result;
    }
    
    public String getNombre(String cod){
        String result = con.devuelveRegistroString("Select Nombre from equipo where codigo='"+cod+"'", "Nombre");
        return result;
    }
    
    
    
}
