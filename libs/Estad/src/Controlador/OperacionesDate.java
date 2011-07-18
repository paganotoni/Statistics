/*
 * OperacionesDate.java
 * 
 * Created on 3/09/2007, 10:34:22 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import java.util.Date;
import java.text.DateFormat;
import java.util.StringTokenizer;
/**
 *
 * @author Jakolov
 */
public class OperacionesDate {

    public OperacionesDate() {
    }
    
    public static String cadenaDate(Date d){
        
        String result = "";
        try{
            DateFormat formateador = DateFormat.getDateInstance(DateFormat.MEDIUM);
            result = formateador.format(d);
        }catch (Exception e){
            
        }
        return result;
    }
    public static Date dateCadena(String s){
        Date result = new Date();
        StringTokenizer token = new StringTokenizer(s,"/");
        try{
            result.setDate(Integer.parseInt(token.nextToken()));
            result.setMonth(Integer.parseInt(token.nextToken())-1);
            result.setYear(Integer.parseInt(token.nextToken())-1900);
        }catch(Exception e){
            result = null;
        }
        return result ;
    }

}
