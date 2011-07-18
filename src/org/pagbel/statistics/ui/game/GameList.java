/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GameList.java
 *
 * Created on Jun 26, 2011, 9:49:15 AM
 */
package org.pagbel.statistics.ui.game;

import org.pagbel.statistics.engine.GameHolder;
import org.pagbel.statistics.game.Game;
import org.pagbel.statistics.hibernate.DatabaseOperator;
import org.pagbel.statistics.ui.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apagano
 */
public class GameList extends javax.swing.JInternalFrame {

  Object[] games;
  
  @Autowired
  DatabaseOperator databaseOperator;
  
  @Autowired
  GameHolder gameHolder;
  
  @Autowired
  MainWindow mainWindow;
  
  
  /** Creates new form GameList */
  public GameList() {
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

    btnLoad = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    tblGames = new javax.swing.JTable();
    btlDelete = new javax.swing.JButton();
    btnCancel = new javax.swing.JButton();
    btnCreateGame = new javax.swing.JButton();

    setClosable(true);
    setTitle("Games");
    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        onShown(evt);
      }
    });

    btnLoad.setText("Load");
    btnLoad.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLoadActionPerformed(evt);
      }
    });

    tblGames.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {},
        {}
      },
      new String [] {

      }
    ));
    jScrollPane1.setViewportView(tblGames);

    btlDelete.setText("Delete");
    btlDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btlDeleteActionPerformed(evt);
      }
    });

    btnCancel.setText("Cancel");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelActionPerformed(evt);
      }
    });

    btnCreateGame.setText("Create");
    btnCreateGame.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCreateGameActionPerformed(evt);
      }
    });

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .addContainerGap()
        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 289, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
          .add(btnLoad, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)
          .add(btlDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)
          .add(btnCreateGame, 0, 0, Short.MAX_VALUE))
        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
          .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
          .add(layout.createSequentialGroup()
            .add(btnLoad)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(btlDelete)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(btnCreateGame)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 121, Short.MAX_VALUE)
            .add(btnCancel)))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    this.setVisible( false );
    this.dispose();
  }//GEN-LAST:event_btnCancelActionPerformed

  private void onShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_onShown
    this.reloadTableData();
  }//GEN-LAST:event_onShown

  private void btlDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlDeleteActionPerformed
    Game selectedGame = this.getSelectedGame();
    
    if( selectedGame != null ){
      databaseOperator.delete( selectedGame );
      this.reloadTableData();
    }
  }//GEN-LAST:event_btlDeleteActionPerformed

  private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
    Game selectedGame = this.getSelectedGame();
    if(selectedGame != null){
      this.setVisible(false);
      gameHolder.setGame(selectedGame);
      mainWindow.showCommandEditor();
      mainWindow.showStatus();
      mainWindow.showActionList();
    }
  }//GEN-LAST:event_btnLoadActionPerformed

  private void btnCreateGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateGameActionPerformed
    mainWindow.showCreateGame( Boolean.FALSE );
  }//GEN-LAST:event_btnCreateGameActionPerformed

  
  public void reloadTableData(){
    games = databaseOperator.find("from Game").toArray();
    Object[][] tableData = new Object[games.length][3];

    for (int i = 0; i < games.length; i++) {
      Game g = (Game) games[i];
      tableData[i][0] = g.getSelfCode();
      tableData[i][1] = g.getOpponentCode();
      tableData[i][2] = g.getGameConfiguration();
    }

    tblGames.setModel(new javax.swing.table.DefaultTableModel(tableData,new String[]{"Team", "Opponent", "Type"}));
  }
  
  private Game getSelectedGame(){
    Game result = null;
    Integer index = tblGames.getSelectedRow();
    if( index != -1){
      result = (Game)games[ index ];
    }
    return result;
  }
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btlDelete;
  private javax.swing.JButton btnCancel;
  private javax.swing.JButton btnCreateGame;
  private javax.swing.JButton btnLoad;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblGames;
  // End of variables declaration//GEN-END:variables
}
