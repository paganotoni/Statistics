/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreatePlayer.java
 *
 * Created on Jul 16, 2011, 3:32:45 PM
 */
package org.pagbel.statistics.ui.structure;

import org.pagbel.statistics.hibernate.DatabaseOperator;
import org.pagbel.statistics.structure.Player;
import org.pagbel.statistics.structure.Team;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apagano
 */
public class CreatePlayer extends javax.swing.JInternalFrame {

  private Team selectedTeam;
  
  @Autowired
  DatabaseOperator databaseOperator;
  
  @Autowired
  PlayerList playerListIF;
  
  private Player selectedPlayer;

 
  
  /** Creates new form CreatePlayer */
  public CreatePlayer() {
    initComponents();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    txtPlayerNumber = new javax.swing.JTextField();
    txtPlayerName = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    btnCreate = new javax.swing.JButton();
    btnCancel = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();

    setTitle("Create Player");
    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        onShown(evt);
      }
    });

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("#");

    jLabel2.setText("Name");

    btnCreate.setText("Create");
    btnCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCreateActionPerformed(evt);
      }
    });

    btnCancel.setText("Cancel");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelActionPerformed(evt);
      }
    });

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/EditarJugadorPequeno.png"))); // NOI18N

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .addContainerGap()
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
              .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
              .add(jLabel2))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
              .add(txtPlayerName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
              .add(layout.createSequentialGroup()
                .add(txtPlayerNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 154, Short.MAX_VALUE)
                .add(jLabel3))))
          .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
            .add(btnCancel)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(btnCreate)))
        .add(23, 23, 23))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .addContainerGap()
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
          .add(layout.createSequentialGroup()
            .add(16, 16, 16)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
              .add(txtPlayerNumber)
              .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
          .add(jLabel3))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(txtPlayerName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
          .add(jLabel2))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(btnCreate)
          .add(btnCancel))
        .add(20, 20, 20))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    this.dispose();
    this.setVisible(false);
  }//GEN-LAST:event_btnCancelActionPerformed

  public Player getSelectedPlayer() {
    return selectedPlayer;
  }

  public void setSelectedPlayer(Player selectedPlayer) {
    this.selectedPlayer = selectedPlayer;
  }
  
  public Team getSelectedTeam() {
    return selectedTeam;
  }

  public void setSelectedTeam(Team selectedTeam) {
    this.selectedTeam = selectedTeam;
  }

  private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
    Player player = selectedPlayer != null ? selectedPlayer : new Player();
    
    player.setNumber( txtPlayerNumber.getText());
    player.setName( txtPlayerName.getText());
    player.setTeam( selectedTeam );
    
    if( selectedPlayer == null ){
      databaseOperator.saveOrUpdate(player);
    } else {
      databaseOperator.update(player);
      selectedPlayer = null;
    }
    this.setVisible(false);
    this.dispose();
    
    playerListIF.setSelectedTeam(selectedTeam);
    playerListIF.reloadTableData();
    
  }//GEN-LAST:event_btnCreateActionPerformed

  private void onShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_onShown
    if( this.selectedPlayer !=  null ){
      this.txtPlayerName.setText( selectedPlayer.getName());
      this.txtPlayerNumber.setText( selectedPlayer.getNumber());
      
      this.btnCreate.setText("Update");
      this.setTitle("Update Player");
    }else{
      this.txtPlayerName.setText( "" );
      this.txtPlayerNumber.setText( "" );
      
      this.btnCreate.setText("Create");
      this.setTitle("Create Player");
    }
  }//GEN-LAST:event_onShown

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCancel;
  private javax.swing.JButton btnCreate;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField txtPlayerName;
  private javax.swing.JTextField txtPlayerNumber;
  // End of variables declaration//GEN-END:variables
}
