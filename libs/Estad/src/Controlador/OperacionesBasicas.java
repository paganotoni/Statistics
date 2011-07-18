package Controlador;
/*
 * OperacionesBasicas.java
 *
 * Created on 9 de agosto de 2007, 03:22 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Jakolov
 */
import javax.swing.*;
import org.deitel.ResultSetTableModel;
import javax.swing.JComboBox;
import java.util.LinkedList;
import javax.swing.text.MaskFormatter;

public class OperacionesBasicas {
    
    /** Creates a new instance of OperacionesBasicas */
    public OperacionesBasicas() {
    }
     /** Cierra Una internal cualquiera */
    public void cerrarFormulario(JInternalFrame internal){
        internal.setVisible(false);
    }
     /** Termina la Aplicacion */
    public void salir(){
        System.gc();
        System.exit(0);
    }
     /** Centra el formulario en su padre*/
    public void centrar(JInternalFrame internal){
        internal.setBounds((Vista.FormPrincipal.getWith()-internal.getBounds().width)/2, (Vista.FormPrincipal.getHeigth()-internal.getBounds().height)/2, internal.getBounds().width, internal.getBounds().height);
    }
    
    /** Devuelve el model de un JTable a partir de una consulta sql*/
    public void setTableModelSQL(Coneccion con, String comando, JTable tbl){
        ResultSetTableModel modelo = null;
        try{
        modelo = new ResultSetTableModel(con.getDriver(),con.getBase(),comando);     
        tbl.setModel(modelo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en la Lectura de Datos");
            e.printStackTrace();
        }
    }
    public void setTableModelSQLEditable(Coneccion con, String comando, JTable tbl){
        ResultSetTableModel modelo = null;
        try{
        modelo = new ResultSetTableModel(con.getDriver(),con.getBase(),comando,0);     
        tbl.setModel(modelo);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en la Lectura de Datos");
            e.printStackTrace();
        }
    }
    public void setDatosCombo(String query,JComboBox combo,Coneccion con,String campo){
        LinkedList listaResultados = con.devuelveColumnaString(query,campo);
        combo.setModel(new javax.swing.DefaultComboBoxModel(listaResultados.toArray()));
    }
    

    
   
    
    
    
    
    
}
