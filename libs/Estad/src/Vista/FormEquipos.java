/*
 * FormEquipos.java
 *
 * Created on 9 de agosto de 2007, 03:02 PM
 */

package Vista;
import java.util.LinkedList;
import Controlador.OperacionesEquipo;
import javax.swing.table.TableColumn;
/**
 *
 * @author  Jakolov
 */
public class FormEquipos extends javax.swing.JInternalFrame {
    private LinkedList listaIndices;
    private OperacionesEquipo opEquipo;
    /** Creates new form FormEquipos */
    public FormEquipos() {
        initComponents();
        listaIndices = new LinkedList();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comBorrar = new javax.swing.JButton();
        comNuevoJugador = new javax.swing.JButton();
        comCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipos = new javax.swing.JTable();
        comVerEquipo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Equipos");
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
            }
        });

        comBorrar.setText("Borrar");
        comBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBorrarActionPerformed(evt);
            }
        });

        comNuevoJugador.setText("Nuevo");
        comNuevoJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comNuevoJugadorActionPerformed(evt);
            }
        });

        comCerrar.setText("Cerrar");
        comCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCerrarActionPerformed(evt);
            }
        });

        tblEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblEquipos);

        comVerEquipo.setText("Ver Equipo");
        comVerEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comVerEquipoActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eqGrande.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comNuevoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comVerEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comNuevoJugador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comVerEquipo)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(comCerrar)))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-579)/2, (screenSize.height-375)/2, 579, 375);
    }// </editor-fold>//GEN-END:initComponents

private void comNuevoJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comNuevoJugadorActionPerformed
    // TODO add your handling code here:
    FormPrincipal.getFormNuevoEquipo().setVisible(true);
}//GEN-LAST:event_comNuevoJugadorActionPerformed

private void comCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCerrarActionPerformed
    // TODO add your handling code here:
    this.setVisible(false);
}//GEN-LAST:event_comCerrarActionPerformed

private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    // TODO add your handling code here:
    actualizaTabla();
}//GEN-LAST:event_formInternalFrameActivated

private void comVerEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comVerEquipoActionPerformed
    // TODO add your handling code here:
    try{
        int sel = tblEquipos.getSelectedRow();
        if ( sel >= 0 ){
            FormPrincipal.getFormDetallesEquipo().setidEquipo(listaIndices.get(sel).toString());
            FormPrincipal.getFormDetallesEquipo().setVisible(true);
        }
    }catch(Exception e){
        
    }
    FormPrincipal.getFormDetallesEquipo().setVisible(true);
}//GEN-LAST:event_comVerEquipoActionPerformed

private void comBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBorrarActionPerformed
    // TODO add your handling code here:
    try{
        int sel = tblEquipos.getSelectedRow();
        if ( sel >= 0 ){
            opEquipo.borrarEquipo(listaIndices.get(sel).toString());
            actualizaTabla();
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
}//GEN-LAST:event_comBorrarActionPerformed
    
    private void actualizaTabla(){
        opEquipo = new OperacionesEquipo(FormPrincipal.getCon(),FormPrincipal.getOperacionesBasicas());
        opEquipo.setModeloEquipos(tblEquipos);
        listaIndices = opEquipo.getListaIndices();
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comBorrar;
    private javax.swing.JButton comCerrar;
    private javax.swing.JButton comNuevoJugador;
    private javax.swing.JButton comVerEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEquipos;
    // End of variables declaration//GEN-END:variables
    
}
