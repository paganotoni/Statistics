/*
 * OperacionesJugador.java
 * 
 * Created on 13/09/2007, 03:19:20 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.util.LinkedList;


public class OperacionesJugador {
    private Coneccion con;
    private OperacionesBasicas ope;

    public OperacionesJugador(Coneccion con, OperacionesBasicas ope) {
        this.con = con;
        this.ope = ope;
    }
    
    public void insertarJugador(String numero, String codigo ,String nombre, String estatura, String peso, String equipo){
        try{
            con.ejecutaStatement("insert into jugador(codigo, numero, nombre, estatura, peso, codigoequipo) values('"+codigo+"','"+numero+"','"+nombre+"','"+estatura+"','"+peso+"','"+equipo+"')");
        }catch(Exception e){
            
        }
   }
    public LinkedList getListaNumeros(String idEquipo){
        LinkedList result = new LinkedList();
        try{
            result = con.devuelveColumnaString("select numero from jugador where codigoEquipo = '"+idEquipo+"'", "numero");
        }catch(Exception e){
            
        }
        return result;
    }
    
    public void actualizarJugador(String cbase,String numero, String codigo ,String nombre, String estatura, String peso){
        try{  
        con.ejecutaStatement("update jugador set codigo='"+codigo+"' , numero = '"+numero+"',nombre='"+nombre+"',estatura='"+estatura+"',peso='"+peso+"' where codigo='"+cbase+"';");
        }catch(Exception e){
            
        }
    }
    public void insertarJugadorJuego(String codJugador, String idJuego){
        try{  
        con.ejecutaStatement("INSERT INTO JUGJUE(CODIGO,IDJUEGO) VALUES ('"+codJugador+"','"+idJuego+"')");
        }catch(Exception e){
            
        }
    }
    
   
    
}
