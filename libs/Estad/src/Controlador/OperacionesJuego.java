/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Modelo.Juego;
import java.sql.ResultSet;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import java.util.LinkedList;
import javax.swing.JOptionPane;
/**
 *
 * @author jakolov
 */
public class OperacionesJuego {
    
    OperacionesBasicas ope;
    Coneccion con;
    
    
    public OperacionesJuego(Coneccion con, OperacionesBasicas ope){
        this.ope = ope;
        this.con = con; 
    }
    
    public void borrarJuego(int id){
        try{
            LinkedList<Integer> idParciales = con.devuelveColumnaEntero("select idparcial from parcial where idjuego = "+id, "idparcial");
            Iterator<Integer> it = idParciales.iterator();
            for(;it.hasNext();){
                int idParcial = it.next();
                LinkedList<Integer> idRallys = con.devuelveColumnaEntero("select idrally from rally where idparcial ="+idParcial, "idrally");
                con.ejecutaStatement("delete from parcial where idParcial = "+idParcial);
                Iterator<Integer> ite = idRallys.iterator();
                for(;ite.hasNext();){
                    int idRally = ite.next();
                    con.ejecutaStatement("delete from accion where idrally = "+idRally);
                }
            }
            con.ejecutaStatement("delete from parcial where idJuego="+id);
            con.ejecutaStatement("delete from juego where idJuego = "+id);                        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error en el borrado del equipo \n" +
                    ex.getMessage());
        }
        
    }
    
    public LinkedList<Integer> getListaIdJuegos(int idTorneo){
        LinkedList<Integer> lista = con.devuelvePrimeraColumnaEntero("Select idJuego from juego where idTorneo = "+idTorneo);
        return lista;
    }
    
    public void setModeloJuegos(JTable tbl,String idTorneo){
        ope.setTableModelSQL(con, "select fecha,eqpPropio as Propio , eqpOpp as Oponente ,torneo.nombre as Torneo from juego,torneo where torneo.idTorneo = juego.idTorneo and idtorneo = "+idTorneo, tbl);
        setAnchoColumnas(tbl);
    }
     
    private void setAnchoColumnas(JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(70);
        col = tbl.getColumnModel().getColumn(1);
        col.setPreferredWidth(70);
        col = tbl.getColumnModel().getColumn(2);
        col.setPreferredWidth(70);
        col = tbl.getColumnModel().getColumn(3);
        col.setPreferredWidth(240);
    }
}
