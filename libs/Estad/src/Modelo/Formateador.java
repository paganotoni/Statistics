/*
 * Formateador.java
 * 
 * Created on 8/09/2007, 04:18:35 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
/**
 *
 * @author Jakolov
 */
public class Formateador extends JFormattedTextField.AbstractFormatter{
    /** Se le pasa el texto del editor y debe devolver una clase Mayuscula */
    @Override
    public Object stringToValue(String text) throws ParseException
    {
        return text.toUpperCase();
    }

    /** Se le pasa una clase Mayuscula o null y devuelve la cadena para poner en
           el editor */
    @Override
    public String valueToString(Object value) throws ParseException{
        if (value==null)
            return ("");
        return value.toString().toUpperCase();
    }
}

