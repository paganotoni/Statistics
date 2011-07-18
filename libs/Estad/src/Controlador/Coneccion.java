/*
 * Coneccion.java
 * 
 * Created on 28/08/2007, 05:26:29 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

/**
 *
 * @author Jakolov
 */
import Modelo.Juego;
import java.sql.*;
import java.util.LinkedList;
public class Coneccion {
 private Connection con;
 private String driver = "org.hsqldb.jdbcDriver";
 private String base = "jdbc:hsqldb:Base/Data" ;
 private Statement sta;
 
 
    public Coneccion() {
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(base);
            
        }catch (Exception e){
            
        }
        
    }
    
    public LinkedList<Integer> devuelvePrimeraColumnaEntero(String query){
        LinkedList result = new LinkedList();
        try{
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(query); 
        while(rs.next()){
            result.add(Integer.valueOf(String.valueOf(rs.getInt(1)).trim()));
        }
        }catch (Exception e){
           // e.printStackTrace();
            System.out.println("Error En Consulta");
        }
        return result;
    }
    
    public Juego devuelveJuego(String query){
        Juego result = new Juego();
        try{
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery(query);
            rs.next();
            result.setAnotador(rs.getString("anotador"));
            result.setAsistencia(rs.getString("espectadores"));
            result.setCiudad(rs.getString("ciudad"));
            result.setColiseo(rs.getString("coliseo"));
            result.setComEntrenadorOpp(rs.getString("comOpp"));
            result.setComEntrenadorPropio(rs.getString("comPropio"));
            result.setDiaNumero(rs.getString("dia"));
            result.setFase(rs.getString("fase"));
            result.setFecha(rs.getString("fecha"));
            result.setId(rs.getInt("idJuego"));
            result.setJueces(rs.getString("jueces"));
            result.setNumero(rs.getString("juegoNumero"));
            result.setRecaudos(rs.getString("recaudos"));
            result.setTipo(rs.getString("tipo"));
            result.setCodOpp(rs.getString("eqpopp"));
            result.setCodPropio(rs.getString("eqppropio"));
        }catch(Exception e){
            //e.printStackTrace();
            System.out.println("Error En Consulta");
        } 
        return result;
    }
    
    public LinkedList<String> devuelvePrimeraColumnaString(String query){
                LinkedList result = new LinkedList();
        try{
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(query); 
        while(rs.next()){
            result.add(rs.getString(1).trim());
        }
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("Error En Consulta");
        }
        return result;
    }
    
    public LinkedList devuelveColumnaEntero(String query,String campo){
        LinkedList result = new LinkedList();
        try{
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(query); 
        while(rs.next()){
            result.add(rs.getInt(campo));
        }
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("Error En Consulta");
        }
        return result;
    }
    public LinkedList devuelveColumnaString(String query,String campo){
        LinkedList result = new LinkedList();
        try{
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(query); 
        while(rs.next()){
            result.add(rs.getString(campo).trim());
        }
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("Error En Consulta");
        }
        return result;
    }
    public void ejecutaStatement(String query)throws SQLException{
        sta = con.createStatement();
        sta.execute(query);    
    }
    
    public String devuelvePrimerRegistroString(String query){
        String result = "";
        try{
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(query); 
        rs.next();
        result = rs.getString(1);
        }catch (Exception e){
            System.out.println("Error En Consulta");
            //e.printStackTrace();
        }
        return result;
    }
    
    public int devuelvePrimerRegistroEntero(String query){
        int result = 0;
        try{
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(query); 
        rs.next();
        result = rs.getInt(1);
        }catch (Exception e){
            System.out.println("Error En Consulta");
            //e.printStackTrace();
        }
        return result;
    }
    
    public String devuelveRegistroString(String query, String campo){
        String result = "";
        try{
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(query); 
        rs.next();
        result = rs.getString(campo);
        }catch (Exception e){
            System.out.println("Error En Consulta");
            //e.printStackTrace();
        }
        return result;
    }
    
    public int devuelveRegistroInt(String query, String campo){
        int result = 0;
        try{
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery(query); 
        rs.next();
        result = rs.getInt(campo);
        }catch (Exception e){
            System.out.println("Error En Consulta");
            //e.printStackTrace();
        }
        return result;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getBase() {
        return base;
    }

    public String getDriver() {
        return driver;
    }
    

}
