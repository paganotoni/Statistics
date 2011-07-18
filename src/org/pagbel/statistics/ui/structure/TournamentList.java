/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TournamentList.java
 *
 * Created on Jul 15, 2011, 10:18:54 PM
 */
package org.pagbel.statistics.ui.structure;

import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import org.pagbel.statistics.hibernate.DatabaseOperator;
import org.pagbel.statistics.structure.Tournament;
import org.pagbel.statistics.ui.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apagano
 */
public class TournamentList extends javax.swing.JInternalFrame {
  
  @Autowired
  DatabaseOperator databaseOperator;
  
  @Autowired
  MainWindow mainWindow;
  
  Object[] tournaments;
  
  /** Creates new form TournamentList */
  public TournamentList() {
    initComponents();
  }

  public void reloadTableData(){
    tournaments = databaseOperator.find("from Tournament").toArray();
    Object[][] tableData = new Object[tournaments.length][1];

    for (int i = 0; i < tournaments.length; i++) {
      Tournament t = (Tournament) tournaments[i];
      tableData[i][0] = t.getName();
    }

    tblTournaments.setModel(new javax.swing.table.DefaultTableModel(tableData,new String[]{"Name"}));
    this.fixTableColumns();
  }
  
  private void fixTableColumns(){
    TableColumn col = tblTournaments.getColumnModel().getColumn(0);
    col.setPreferredWidth(200);
  }
  
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    btnDelete = new javax.swing.JButton();
    btnEdit = new javax.swing.JButton();
    btnCancel = new javax.swing.JButton();
    btnCreate = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();

    tblTournaments = new javax.swing.JTable();

    setClosable(true);
    setTitle("Tournament List");

    btnDelete.setText("Delete");
    btnDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnDeleteActionPerformed(evt);
      }
    });

    btnEdit.setText("Edit");
    btnEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEditActionPerformed(evt);
      }
    });

    btnCancel.setText("Cancel");
    btnCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelActionPerformed(evt);
      }
    });

    btnCreate.setText("Create");
    btnCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCreateActionPerformed(evt);
      }
    });

    tblTournaments.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {"aaa"},
        {null},
        {null},
        {null}
      },
      new String [] {
        "Name"
      }
    ));
    jScrollPane1.setViewportView(tblTournaments);

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(layout.createSequentialGroup()
            .add(11, 11, 11)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
              .add(btnCreate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
              .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(btnDelete, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(2, 2, 2))
              .add(org.jdesktop.layout.GroupLayout.TRAILING, btnEdit, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .add(layout.createSequentialGroup()
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .addContainerGap()
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
          .add(layout.createSequentialGroup()
            .add(btnEdit)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(btnDelete)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(btnCreate)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(btnCancel))
          .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 243, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(20, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    int selectedIndex = tblTournaments.getSelectedRow();
    if( selectedIndex != -1 ){
      Object tournament = tournaments[selectedIndex];
      databaseOperator.delete(tournament);
      JOptionPane.showInternalMessageDialog(mainWindow.getDesktopPane(), "Tournament Deleted");
      this.reloadTableData();
    }else{
      JOptionPane.showInternalMessageDialog(mainWindow.getDesktopPane(), "Please select the tournament you want to delete.");
    }
}//GEN-LAST:event_btnDeleteActionPerformed

  private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

}//GEN-LAST:event_btnEditActionPerformed

  private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
    this.setVisible(false);
}//GEN-LAST:event_btnCancelActionPerformed

  private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
    mainWindow.showCreateTournament();
}//GEN-LAST:event_btnCreateActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCancel;
  private javax.swing.JButton btnCreate;
  private javax.swing.JButton btnDelete;
  private javax.swing.JButton btnEdit;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable tblTournaments;
  // End of variables declaration//GEN-END:variables
}
