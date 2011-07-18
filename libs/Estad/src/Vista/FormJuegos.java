/*
 * FormJuegos.java
 *
 * Created on 9 de agosto de 2007, 05:37 AM
 */

package Vista;
import Controlador.OperacionesJuego;
import Modelo.Juego;
import java.util.LinkedList;
 
/*
 * @author  Jakolov
*/

public class FormJuegos extends javax.swing.JInternalFrame {
    LinkedList listaIdTorneos;
    LinkedList<Integer> listaIdJuegos; 
    OperacionesJuego opJuego;
    /** Creates new form FormJuegos */
    public FormJuegos() {
        initComponents();
        listaIdTorneos = new LinkedList(); 
        this.setVisible(false);
    }
    
    private void actualiza(){
        opJuego = new OperacionesJuego(FormPrincipal.getCon(),FormPrincipal.getOperacionesBasicas());
        FormPrincipal.getOperacionesBasicas().setDatosCombo("select Nombre from Torneo", cboTorneos,FormPrincipal.getCon(),"nombre");
        listaIdTorneos = FormPrincipal.getCon().devuelveColumnaEntero("Select idTorneo from Torneo", "idTorneo");                                           
        try{                                           
            int sel = cboTorneos.getSelectedIndex();
            if (sel < 0){
                cboTorneos.setSelectedIndex(0);
                opJuego.setModeloJuegos(tblJuegos,listaIdTorneos.get(0).toString());
                listaIdJuegos = opJuego.getListaIdJuegos(Integer.parseInt(listaIdTorneos.get(0).toString()));
            }else{
                opJuego.setModeloJuegos(tblJuegos,listaIdTorneos.get(sel).toString());
                listaIdJuegos = opJuego.getListaIdJuegos(Integer.parseInt(listaIdTorneos.get(sel).toString()));
            }
        }catch(Exception e){

        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        comBorrar = new javax.swing.JButton();
        comNuevaTemporada = new javax.swing.JButton();
        comCerrar = new javax.swing.JButton();
        cboTorneos = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        scpJuegos = new javax.swing.JScrollPane();
        tblJuegos = new javax.swing.JTable();
        comEditar = new javax.swing.JButton();
        comCargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Juegos");
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        comBorrar.setText("Borrar");
        comBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBorrarActionPerformed(evt);
            }
        });

        comNuevaTemporada.setText("Nuevo");
        comNuevaTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comNuevaTemporadaActionPerformed(evt);
            }
        });

        comCerrar.setText("Cerrar");
        comCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCerrarActionPerformed(evt);
            }
        });

        cboTorneos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTorneosItemStateChanged(evt);
            }
        });

        jLabel1.setText("Torneo:");

        tblJuegos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scpJuegos.setViewportView(tblJuegos);

        comEditar.setText("Editar");
        comEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEditarActionPerformed(evt);
            }
        });

        comCargar.setText("Cargar");
        comCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboTorneos, 0, 480, Short.MAX_VALUE))
                    .addComponent(scpJuegos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(comCargar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comNuevaTemporada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comBorrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cboTorneos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comNuevaTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
    // TODO add your handling code here:
   
}//GEN-LAST:event_formInternalFrameOpened


private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    // TODO add your handling code here:
    opJuego = new OperacionesJuego(FormPrincipal.getCon(),FormPrincipal.getOperacionesBasicas());
    FormPrincipal.getOperacionesBasicas().setDatosCombo("select Nombre from Torneo", cboTorneos,FormPrincipal.getCon(),"nombre");
    listaIdTorneos = FormPrincipal.getCon().devuelveColumnaEntero("Select idTorneo from Torneo", "idTorneo");                                           
    try{//GEN-LAST:event_formInternalFrameActivated
        int sel = cboTorneos.getSelectedIndex();
        if (sel < 0){
            cboTorneos.setSelectedIndex(0);
            opJuego.setModeloJuegos(tblJuegos,listaIdTorneos.get(0).toString());
            listaIdJuegos = opJuego.getListaIdJuegos(Integer.parseInt(listaIdTorneos.get(0).toString()));
        }else{
            opJuego.setModeloJuegos(tblJuegos,listaIdTorneos.get(sel).toString());
            listaIdJuegos = opJuego.getListaIdJuegos(Integer.parseInt(listaIdTorneos.get(sel).toString()));
        }
    }catch(Exception e){
        
    }
    
    
}                                           

private void comCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCerrarActionPerformed
    // TODO add your handling code here:
    this.setVisible(false);
}//GEN-LAST:event_comCerrarActionPerformed

private void comNuevaTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comNuevaTemporadaActionPerformed
    // TODO add your handling code here:
    FormPrincipal.getFormEdicionJuego().setJu(null);
    FormPrincipal.getFormEdicionJuego().setVisible(true);
}//GEN-LAST:event_comNuevaTemporadaActionPerformed

private void comBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBorrarActionPerformed
    // TODO add your handling code here:
    try{
        int idJuego = listaIdJuegos.get(tblJuegos.getSelectedRow());
        //System.out.println("idJuego " + idJuego);
        opJuego.borrarJuego(idJuego);
        actualiza();
    }catch(Exception e){
        
    }
    
}//GEN-LAST:event_comBorrarActionPerformed



private void cboTorneosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTorneosItemStateChanged
    // TODO add your handling code here:
    try{                                           
        opJuego.setModeloJuegos(tblJuegos,listaIdTorneos.get(cboTorneos.getSelectedIndex()).toString());
        listaIdJuegos = opJuego.getListaIdJuegos(Integer.parseInt(listaIdTorneos.get(cboTorneos.getSelectedIndex()).toString()));
    }catch(Exception e){
        
    }
}//GEN-LAST:event_cboTorneosItemStateChanged

private void comEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEditarActionPerformed
    try{
        listaIdJuegos = opJuego.getListaIdJuegos(Integer.parseInt(listaIdTorneos.get(cboTorneos.getSelectedIndex()).toString()));
        int idJuego = listaIdJuegos.get(tblJuegos.getSelectedRow());
        Juego j = FormPrincipal.getCon().devuelveJuego("select * from juego where idjuego = "+ String.valueOf(idJuego));
        this.setVisible(false);
        FormPrincipal.getFormEdicionJuego().setJu(j);
        actualiza();
    }catch(Exception e){
        
    }
}//GEN-LAST:event_comEditarActionPerformed

private void comCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCargarActionPerformed
    // TODO add your handling code here:
    try{      
        listaIdJuegos = opJuego.getListaIdJuegos(Integer.parseInt(listaIdTorneos.get(cboTorneos.getSelectedIndex()).toString()));
        int idJuego = listaIdJuegos.get(tblJuegos.getSelectedRow());
        Juego j = FormPrincipal.getCon().devuelveJuego("select * from juego where idjuego = "+ String.valueOf(idJuego));
        this.setVisible(false);
        FormPrincipal.getFormListaJugadores().setJuego(j);
        FormPrincipal.getFormControladorDeJuego().setJuego(j);
        FormPrincipal.getFormListaAcciones().setJuego(j);
        FormPrincipal.getFormControladorDeJuego().setVisible(true);
        //FormPrincipal.getFormListaJugadores().setVisible(true);
        FormPrincipal.getFormListaAcciones().setVisible(true);
        FormPrincipal.getFormJuego().setVisible(true);
        FormPrincipal.getFormJuego().setJuego(j);
    }catch(Exception e){//GEN-LAST:event_comCargarActionPerformed
    
    }

}                                         
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboTorneos;
    private javax.swing.JButton comBorrar;
    private javax.swing.JButton comCargar;
    private javax.swing.JButton comCerrar;
    private javax.swing.JButton comEditar;
    private javax.swing.JButton comNuevaTemporada;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scpJuegos;
    private javax.swing.JTable tblJuegos;
    // End of variables declaration//GEN-END:variables
    
}
