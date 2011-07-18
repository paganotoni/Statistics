/*
 * OperacionesTabla.java
 * 
 * Created on 25/09/2007, 06:58:30 PM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import java.awt.Component;
import java.util.LinkedList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.deitel.ResultSetTableModel;

/**
 *
 * @author Jakolov
 */
public class OperacionesTabla {
    Coneccion con;
    OperacionesBasicas ope;
    LinkedList idGestoVG;
    LinkedList idValorVG;
    LinkedList idGesto;
    LinkedList idValor;
    LinkedList ValoracionVG;
    LinkedList Letras;
    LinkedList Nombres;
    LinkedList Producen;
    LinkedList Otorgan;
    
    public OperacionesTabla(Coneccion con, OperacionesBasicas ope){
        this.con = con;
        this.ope = ope;  
    }
    
    public void setModeloValoracion(javax.swing.JTable tbl){    
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            getArregloValores(),Letras.toArray()
        ));
        setAnchoColumnas(tbl);
    }
    
    public void setModeloTerminales(javax.swing.JTable tbl){
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            getArregloTerminales(),new String[]{"Gesto","Positivo","Negativo"}
        ));
        Letras = this.getListaLetrasValores();
        Letras.add("");
        TableColumn colu1 = tbl.getColumnModel().getColumn(1);
        colu1.setCellEditor(new MyComboBoxEditor(Letras.toArray()));
        TableColumn colu2 = tbl.getColumnModel().getColumn(2);
        colu2.setCellEditor(new MyComboBoxEditor(Letras.toArray()));
        //col.setCellRenderer(new MyComboBoxRenderer(Letras.toArray()));
    }
    
    private String[][] getArregloTerminales(){
        idGesto = this.getListaIdGestos();
        Nombres = this.getListaNombreGestos();
        Producen = this.getListaProducen();
        Otorgan = this.getListaOtorgan();
        idValor = this.getListaIdValores();
        Letras = this.getListaLetrasValores();
        
        String[][] result = new String[idGesto.size()][3];
        for(int i = 0; i< Nombres.size() ; i++){
            int indLetraProduce = idValor.indexOf(Producen.get(i));
            int indLetraOtorga =idValor.indexOf(Otorgan.get(i));
            result[i][0] = Nombres.get(i).toString();
            String LetraProduce = "";
            String LetraOtorga = "";
            if(indLetraProduce != -1 )
             LetraProduce = Letras.get(indLetraProduce).toString();
            if(indLetraOtorga != -1 )
             LetraOtorga = Letras.get(indLetraOtorga).toString();
            result[i][1] = LetraProduce;
            result[i][2] = LetraOtorga;
        }
        return result;
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
    
    public String[][] getArregloValores(){
        
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
    
    public void guardarCambiosValores(javax.swing.JTable tbl){
        for( int i = 0 ; i< idGesto.size() ; i++){
            for( int j = 0 ; j< idValor.size() ; j++){
                //System.out.println(tbl.getValueAt(i, j+1).toString());
                actualizarRegistroValores(idGesto.get(i).toString(),idValor.get(j).toString(),tbl.getValueAt(i, j+1).toString());
            }
        }
        //return resultado;
    }
    public void guardarCambiosFinRally(javax.swing.JTable tbl){
        Letras = this.getListaLetrasValores();
        idValor = this.getListaIdValores();
        for( int i = 0 ; i< idGesto.size() ; i++){
            int indLetraProduce = Letras.indexOf(tbl.getValueAt(i, 1));
            int indLetraOtorga = Letras.indexOf(tbl.getValueAt(i, 2));
            String idValorProduce = "0";
            String idValorOtorga = "0";
            if(indLetraProduce != -1 )
            idValorProduce = idValor.get(indLetraProduce).toString();
            if(indLetraOtorga != -1 )
            idValorOtorga = idValor.get(indLetraOtorga).toString();
            
            actualizarFinRally(idGesto.get(i).toString(),String.valueOf(idValorProduce),String.valueOf(idValorOtorga));
        }
    }
    
    public void actualizarRegistroValores(String idg, String idv,String valoracion){
        try{
            con.ejecutaStatement("update valges set valoracion="+valoracion+" where idGesto="+idg+" and idValor="+idv);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actualizarFinRally(String idg, String produce,String otorga){
        try{
            con.ejecutaStatement("update gesto set produce="+produce+", otorga = "+otorga+" where idGesto="+idg );
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
    
    public LinkedList getListaProducen(){
        LinkedList result =con.devuelveColumnaEntero("Select produce from gesto", "produce");
        return result;
    }
    public LinkedList getListaOtorgan(){
        LinkedList result =con.devuelveColumnaEntero("Select otorga from gesto", "otorga");
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
    
    public class MyComboBoxRenderer extends JComboBox implements TableCellRenderer {
        public MyComboBoxRenderer(Object[] items) {
            super(items);
        }
    
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                super.setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
    
            // Select the current value
            setSelectedItem(value);
            return this;
        }
    }
    
    public class MyComboBoxEditor extends DefaultCellEditor {
        public MyComboBoxEditor(Object[] items) {
            super(new JComboBox(items));
        }
    }


    
}
