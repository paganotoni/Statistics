/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewGame.java
 *
 * Created on Jun 24, 2011, 10:44:39 PM
 */
package org.pagbel.statistics.ui.game;

import org.pagbel.statistics.ui.MainWindow;
import javax.swing.JComboBox;
import org.pagbel.statistics.engine.GameBuilder;
import org.pagbel.statistics.engine.GameHolder;
import org.pagbel.statistics.game.Game;
import org.pagbel.statistics.game.GameConfiguration;
import org.pagbel.statistics.hibernate.DatabaseOperator;
import org.pagbel.statistics.structure.Team;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apagano
 */
public class CreateGame extends javax.swing.JInternalFrame {

  @Autowired
  GameHolder holder;
  @Autowired
  GameBuilder builder;
  @Autowired
  DatabaseOperator databaseOperator;
  @Autowired
  GameBuilder gameBuilder;
  @Autowired
  GameHolder gameHolder;
  @Autowired
  MainWindow mainWindow;
  @Autowired
  GameList gameListIF;
  private Boolean shouldLoadOnSave = true;

  /** Creates new form NewGame */
  public CreateGame() {
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

    jLabel2 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    cboGameConfiguration = new JComboBox( GameConfiguration.values() );
    btnCreate = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    cboSelfTeam = new javax.swing.JComboBox();
    cboOpponentTeam = new javax.swing.JComboBox();
    btnCancel = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    cboTournament = new javax.swing.JComboBox();

    setClosable(true);
    setForeground(java.awt.Color.white);
    setTitle("New Game");
    setToolTipText("Create New Game");
    addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
      public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
        onClose(evt);
      }
      public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
      }
      public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
      }
    });
    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        onShown(evt);
      }
    });

    jLabel2.setText("Opp Team");

    jLabel1.setText("Self Team");

    btnCreate.setText("Create Game");
    btnCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCreateActionPerformed(evt);
      }
    });

    jLabel3.setText("Game Type");

    btnCancel.setText("Cancel");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelActionPerformed(evt);
      }
    });

    jLabel4.setText("Tournament");

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .addContainerGap()
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
            .add(btnCancel)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
            .add(btnCreate))
          .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
              .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel2))
              .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
              .add(cboTournament, 0, 239, Short.MAX_VALUE)
              .add(org.jdesktop.layout.GroupLayout.LEADING, cboOpponentTeam, 0, 239, Short.MAX_VALUE)
              .add(org.jdesktop.layout.GroupLayout.LEADING, cboSelfTeam, 0, 239, Short.MAX_VALUE)
              .add(org.jdesktop.layout.GroupLayout.LEADING, cboGameConfiguration, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 239, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .addContainerGap()
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel4)
          .add(cboTournament, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel1)
          .add(cboSelfTeam, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel2)
          .add(cboOpponentTeam, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel3)
          .add(cboGameConfiguration, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(btnCreate)
          .add(btnCancel))
        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
    Team selfTeam = (Team) cboSelfTeam.getSelectedItem();
    Team opponentTeam = (Team) cboOpponentTeam.getSelectedItem();
    GameConfiguration configuration = (GameConfiguration) cboGameConfiguration.getSelectedItem();
    Game newGame = gameBuilder.buildGame(selfTeam, opponentTeam, configuration);

    databaseOperator.saveOrUpdate(newGame);
    gameListIF.reloadTableData();
    
    if ( this.shouldLoadOnSave ) {
      gameHolder.setGame(newGame);
      mainWindow.showCommandEditor();
      mainWindow.showStatus();
      mainWindow.showActionList();
      mainWindow.showDefineRotations();
    }

    this.setVisible(false);
}//GEN-LAST:event_btnCreateActionPerformed

  private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    this.setVisible(false);
  }//GEN-LAST:event_btnCancelActionPerformed

  private void onShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_onShown
    Object[] teams = databaseOperator.find("from Team").toArray();
    Object[] tournaments = databaseOperator.find("from Tournament").toArray();
    this.setTeams(teams);
    this.setTournaments( tournaments);
    
  }//GEN-LAST:event_onShown

  private void onClose(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_onClose
    this.shouldLoadOnSave = Boolean.TRUE;
  }//GEN-LAST:event_onClose

  public void setTeams(Object[] teams) {
    cboSelfTeam.setModel(new javax.swing.DefaultComboBoxModel( teams));
    cboOpponentTeam.setModel(new javax.swing.DefaultComboBoxModel(teams));
  }
  
  public void setTournaments(Object[] tournaments){
    cboTournament.setModel(new javax.swing.DefaultComboBoxModel( tournaments ));
  }

  public Boolean getShouldLoadOnSave() {
    return shouldLoadOnSave;
  }

  public void setShouldLoadOnSave(Boolean shouldLoadOnSave) {
    this.shouldLoadOnSave = shouldLoadOnSave;
  }
  
  
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCancel;
  private javax.swing.JButton btnCreate;
  private javax.swing.JComboBox cboGameConfiguration;
  private javax.swing.JComboBox cboOpponentTeam;
  private javax.swing.JComboBox cboSelfTeam;
  private javax.swing.JComboBox cboTournament;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  // End of variables declaration//GEN-END:variables
}
