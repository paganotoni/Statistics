package Vista;

/*
 * formComando.java
 *
 * Created on 28 de agosto de 2007, 05:24 PM
 */



/**
 *
 * @author  Jakolov
 */
import Controlador.Coneccion;
import org.deitel.ResultSetTableModel;
public class FormComando extends javax.swing.JInternalFrame {
    private Coneccion con;
    /** Creates new form formComando */
    public FormComando() {
        initComponents();
        con = new Coneccion();
        this.setVisible(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComando = new javax.swing.JTextArea();
        comCerrar = new javax.swing.JButton();
        comEhecutar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(true);
        setTitle("Consultas SQL");

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblResultados);

        txtComando.setColumns(20);
        txtComando.setRows(3);
        txtComando.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComandoKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtComando);

        comCerrar.setText("Cerrar");
        comCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCerrarActionPerformed(evt);
            }
        });

        comEhecutar.setText("Ejecutar");
        comEhecutar.setFocusCycleRoot(true);
        comEhecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEhecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comEhecutar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comCerrar)
                    .addComponent(comEhecutar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-535)/2, (screenSize.height-316)/2, 535, 316);
    }// </editor-fold>//GEN-END:initComponents

    private void comCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCerrarActionPerformed
    // TODO add your handling code here:
    this.setVisible(false);
}//GEN-LAST:event_comCerrarActionPerformed

    private void txtComandoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComandoKeyPressed
    // TODO add your handling code here:
    if(evt.getKeyCode() == 10){
        
        try{
            if((txtComando.getText().contains("create"))||(txtComando.getText().contains("insert"))||(txtComando.getText().contains("delete"))||(txtComando.getText().contains("alter"))||(txtComando.getText().contains("drop"))|| (txtComando.getText().contains("update"))){
                con.ejecutaStatement(txtComando.getText());
                txtComando.setText("");
            }else{
                ResultSetTableModel modelo = new ResultSetTableModel(con.getDriver(),con.getBase(),txtComando.getText()); 
                tblResultados.setModel(modelo);
                txtComando.setText("");
            }
           
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        }   
        
    }
}//GEN-LAST:event_txtComandoKeyPressed

    private void comEhecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEhecutarActionPerformed
        // TODO add your handling code here:
        try{
            if((txtComando.getText().contains("create"))||(txtComando.getText().contains("insert"))||(txtComando.getText().contains("delete"))||(txtComando.getText().contains("alter"))||(txtComando.getText().contains("drop"))|| (txtComando.getText().contains("update"))){
                con.ejecutaStatement(txtComando.getText());
                txtComando.setText("");
            }else{
                ResultSetTableModel modelo = new ResultSetTableModel(con.getDriver(),con.getBase(),txtComando.getText()); 
                tblResultados.setModel(modelo);
                txtComando.setText("");
            }
           
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        }   
    }//GEN-LAST:event_comEhecutarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comCerrar;
    private javax.swing.JButton comEhecutar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextArea txtComando;
    // End of variables declaration//GEN-END:variables
    
}
