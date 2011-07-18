/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author jakolov
 */
public class OperacionesListaJugadores {
    private Coneccion con;
    private OperacionesBasicas ope;
   
    public OperacionesListaJugadores(){
        
    }

    public OperacionesListaJugadores(Coneccion con, OperacionesBasicas ope) {
        this.con = con;
        this.ope = ope;
    }
    public void borrarJugadorJuego(String cod , String idjuego){
        try{
            con.ejecutaStatement("DELETE FROM JUGJUE " +
                                 "WHERE CODIGO = '"+cod+"' AND idJuego = "+idjuego);
        }catch(Exception e){
            
        }
    }
    
    public void setModelListaJugadores(String cod, String idJuego ,JTable tbl){
        ope.setTableModelSQL(con,
                "SELECT j.numero as num, j.codigo as cod, j.nombre,j.estatura, j.peso " +
                "FROM jugador as j, equipo as eq, juego as jue , jugjue as jj " +
                "WHERE  j.codigo = jj.codigo and jue.idjuego = jj.idjuego " +
                        "and j.codigoEquipo = eq.codigo and eq.codigo = '"+cod+"' and jue.idJuego = "+idJuego, tbl);
        setAnchoColumnas(tbl);
    }
    
    
     
    private void setAnchoColumnas(JTable tbl){
        TableColumn col = tbl.getColumnModel().getColumn(0);
        col.setPreferredWidth(40);
        col = tbl.getColumnModel().getColumn(1);
        col.setPreferredWidth(70);
        col = tbl.getColumnModel().getColumn(2);
        col.setPreferredWidth(230);
    }
    
}
