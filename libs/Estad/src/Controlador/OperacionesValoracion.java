/*
 * OperacionesTabla.java
 * 
 * Created on 25/09/2007, 06:58:30 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import java.util.LinkedList;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jakolov
 */
public class OperacionesValoracion{
    Coneccion con;
    OperacionesBasicas ope;
    LinkedList idGestoVG;
    LinkedList idValorVG;
    LinkedList idGesto;
    LinkedList idValor;
    LinkedList ValoracionVG;
    LinkedList Letras;
    LinkedList Nombres;
    
    public OperacionesValoracion(Coneccion con, OperacionesBasicas ope){
        this.con = con;
        this.ope = ope;        
    }
    
    public void setModelo(javax.swing.JTable tbl){    
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            getArreglo(),Letras.toArray()
        ));
        setAnchoColumnas(tbl);
    }
    public void setModeloTerminales(javax.swing.JTable tbl){
        ope.setTableModelSQLEditable(con, "Select nombre, produce as positivo,otorga as negativo from gesto", tbl);
    }
    
    public void setAnchoColumnas(javax.swing.JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(70);
        col = tbl.getColumnModel().getColumn(1);
        col.setPreferredWidth(30);
        col = tbl.getColumnModel().getColumn(2);
        col.setPreferredWidth(30);
        col = tbl.getColumnModel().getColumn(3);
        col.setPreferredWidth(30);
        col = tbl.getColumnModel().getColumn(4);
        col.setPreferredWidth(30);
        col = tbl.getColumnModel().getColumn(5);
        col.setPreferredWidth(30);
        col = tbl.getColumnModel().getColumn(6);
        col.setPreferredWidth(30);
    }
    
    public String[][] getArreglo(){
        
        idGestoVG = this.getListaIndicesGestosValges();
        idValorVG = this.getListaIndicesValoresValges();
        ValoracionVG = this.getListaValoracionesValges();
        idGesto = this.getListaIdGestos();
        idValor = this.getListaIdValores();
        Letras = this.getListaLetrasValores();
        Nombres = this.getListaNombreGestos();
        Letras.add(0, "Gesto");
        
        String[][] resultado = new String[idGesto.size()][idValor.size()+1];
        for(int i = 0 ; i < idGesto.size() ; i++){
            resultado[i][0] = Nombres.get(i).toString();
        }
        for( int i = 0 ; i < idGestoVG.size() ; i++ ){
            int idG = Integer.parseInt(idGestoVG.get(i).toString());
            int idV = Integer.parseInt(idValorVG.get(i).toString());
            int indiceG = this.idGesto.indexOf(idG);
            int indiceV = this.idValor.indexOf(idV);
            resultado[indiceG][indiceV+1] = this.ValoracionVG.get(i).toString();
        }
        return resultado;
    }
    
    public void guardarCambios(javax.swing.JTable tbl){
        for( int i = 0 ; i< idGesto.size() ; i++){
            for( int j = 0 ; j< idValor.size() ; j++){
                //System.out.println(tbl.getValueAt(i, j+1).toString());
                actualizarRegistro(idGesto.get(i).toString(),idValor.get(j).toString(),tbl.getValueAt(i, j+1).toString());
            }
        }
        //return resultado;
    }
    
    public void actualizarRegistro(String idg, String idv,String valoracion){
        try{
            con.ejecutaStatement("update valges set valoracion="+valoracion+" where idGesto="+idg+" and idValor="+idv);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public LinkedList getListaIdValores(){
        LinkedList result =con.devuelveColumnaEntero("Select idValor from valor", "idValor");
        return result;
    }
    
    public LinkedList getListaIndicesValoresValges(){
        LinkedList result =con.devuelveColumnaEntero("Select idValor from valges", "idValor");
        return result;
    }
    
    public LinkedList getListaNombreGestos(){
        LinkedList result =con.devuelveColumnaString("Select nombre from gesto", "nombre");
        return result;
    }
    public LinkedList getListaLetrasValores(){
        LinkedList result =con.devuelveColumnaString("Select letra from valor", "letra");
        return result;
    }
    
    public LinkedList getListaIndicesGestosValges(){
        LinkedList result =con.devuelveColumnaEntero("Select idGesto from valges", "idGesto");
        return result;
    }
    
    public LinkedList getListaIdGestos(){
        LinkedList result =con.devuelveColumnaEntero("Select idGesto from gesto", "idGesto");
        return result;
    }
    
    public LinkedList getListaValoracionesValges(){
        LinkedList result =con.devuelveColumnaEntero("Select valoracion from valges", "valoracion");
        return result;
    }
    
}
