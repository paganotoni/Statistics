/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormAnalisisZona.java
 *
 * Created on 13-oct-2008, 22:36:20
 */
package Vista;

import Controlador.OperacionesAnalisisZona;
import Modelo.Juego;
import Modelo.PanelImagen;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

/**
 *
 * @author Jakolov
 */
public class FormAnalisisZona extends javax.swing.JInternalFrame {

    private OperacionesAnalisisZona ope;
    private Juego juego;
    private PanelImagen pnlImg = new PanelImagen(new ImageIcon(getClass().getResource("/Iconos/Zonas.png")).getImage());

    private JLabel lbl_TOT_4;
    private JLabel lbl_POS_4;
    private JLabel lbl_NEG_4;

    private JLabel lbl_TOT_7;
    private JLabel lbl_POS_7;
    private JLabel lbl_NEG_7;

    private JLabel lbl_TOT_5;
    private JLabel lbl_POS_5;
    private JLabel lbl_NEG_5;

    private JLabel lbl_TOT_6;
    private JLabel lbl_POS_6;
    private JLabel lbl_NEG_6;

    private JLabel lbl_TOT_8;
    private JLabel lbl_POS_8;
    private JLabel lbl_NEG_8;

    private JLabel lbl_TOT_3;
    private JLabel lbl_POS_3;
    private JLabel lbl_NEG_3;

    private JLabel lbl_TOT_2;
    private JLabel lbl_POS_2;
    private JLabel lbl_NEG_2;

    private JLabel lbl_TOT_9;
    private JLabel lbl_POS_9;
    private JLabel lbl_NEG_9;

    private JLabel lbl_TOT_1;
    private JLabel lbl_POS_1;
    private JLabel lbl_NEG_1;

    /** Creates new form FormAnalisisZona */
    public FormAnalisisZona() {
        initComponents();
        pnlImg.setLayout(null);
        this.pnlCont.add(pnlImg);
        setLabels();
    }

    private void setLabels() {
        java.awt.Font fuente = new java.awt.Font("", java.awt.Font.BOLD, 10);
        this.lbl_TOT_4 = new JLabel("");
        this.lbl_TOT_4.setFont(fuente);
        this.lbl_TOT_4.setForeground(Color.BLACK);
        this.lbl_TOT_4.setBounds(30, 30, 90, 20);

        this.lbl_POS_4 = new JLabel("");
        this.lbl_POS_4.setFont(fuente);
        this.lbl_POS_4.setForeground(Color.WHITE);
        this.lbl_POS_4.setBounds(30, 45, 90, 20);

        this.lbl_NEG_4 = new JLabel("");
        this.lbl_NEG_4.setFont(fuente);
        this.lbl_NEG_4.setForeground(Color.WHITE);
        this.lbl_NEG_4.setBounds(30, 60, 90, 20);

        this.lbl_TOT_7 = new JLabel("");
        this.lbl_TOT_7.setFont(fuente);
        this.lbl_TOT_7.setForeground(Color.BLACK);
        this.lbl_TOT_7.setBounds(30, 110, 90, 20);

        this.lbl_POS_7 = new JLabel("");
        this.lbl_POS_7.setFont(fuente);
        this.lbl_POS_7.setForeground(Color.WHITE);
        this.lbl_POS_7.setBounds(30, 125, 90, 20);

        this.lbl_NEG_7 = new JLabel("");
        this.lbl_NEG_7.setFont(fuente);
        this.lbl_NEG_7.setForeground(Color.WHITE);
        this.lbl_NEG_7.setBounds(30, 140, 90, 20);

        this.lbl_TOT_5 = new JLabel("");
        this.lbl_TOT_5.setFont(fuente);
        this.lbl_TOT_5.setForeground(Color.BLACK);
        this.lbl_TOT_5.setBounds(30, 190, 90, 20);

        this.lbl_POS_5 = new JLabel("");
        this.lbl_POS_5.setFont(fuente);
        this.lbl_POS_5.setForeground(Color.WHITE);
        this.lbl_POS_5.setBounds(30, 205, 90, 20);

        this.lbl_NEG_5 = new JLabel("");
        this.lbl_NEG_5.setFont(fuente);
        this.lbl_NEG_5.setForeground(Color.WHITE);
        this.lbl_NEG_5.setBounds(30, 220, 90, 20);

        this.lbl_TOT_6 = new JLabel("");
        this.lbl_TOT_6.setFont(fuente);
        this.lbl_TOT_6.setForeground(Color.BLACK);
        this.lbl_TOT_6.setBounds(135, 190, 90, 20);

        this.lbl_POS_6 = new JLabel("");
        this.lbl_POS_6.setFont(fuente);
        this.lbl_POS_6.setForeground(Color.WHITE);
        this.lbl_POS_6.setBounds(135, 205, 90, 20);

        this.lbl_NEG_6 = new JLabel("");
        this.lbl_NEG_6.setFont(fuente);
        this.lbl_NEG_6.setForeground(Color.WHITE);
        this.lbl_NEG_6.setBounds(135, 220, 90, 20);

        this.lbl_TOT_8 = new JLabel("");
        this.lbl_TOT_8.setFont(fuente);
        this.lbl_TOT_8.setForeground(Color.BLACK);
        this.lbl_TOT_8.setBounds(135, 110, 90, 20);

        this.lbl_POS_8 = new JLabel("");
        this.lbl_POS_8.setFont(fuente);
        this.lbl_POS_8.setForeground(Color.WHITE);
        this.lbl_POS_8.setBounds(135, 125, 90, 20);

        this.lbl_NEG_8 = new JLabel("");
        this.lbl_NEG_8.setFont(fuente);
        this.lbl_NEG_8.setForeground(Color.WHITE);
        this.lbl_NEG_8.setBounds(135, 140, 90, 20);

        this.lbl_TOT_3 = new JLabel("");
        this.lbl_TOT_3.setFont(fuente);
        this.lbl_TOT_3.setForeground(Color.BLACK);
        this.lbl_TOT_3.setBounds(135, 30, 90, 20);

        this.lbl_POS_3 = new JLabel("");
        this.lbl_POS_3.setFont(fuente);
        this.lbl_POS_3.setForeground(Color.WHITE);
        this.lbl_POS_3.setBounds(135, 45, 90, 20);

        this.lbl_NEG_3 = new JLabel("");
        this.lbl_NEG_3.setFont(fuente);
        this.lbl_NEG_3.setForeground(Color.WHITE);
        this.lbl_NEG_3.setBounds(135, 60, 90, 20);

        this.lbl_TOT_2 = new JLabel("");
        this.lbl_TOT_2.setFont(fuente);
        this.lbl_TOT_2.setForeground(Color.BLACK);
        this.lbl_TOT_2.setBounds(240, 30, 90, 20);

        this.lbl_POS_2 = new JLabel("");
        this.lbl_POS_2.setFont(fuente);
        this.lbl_POS_2.setForeground(Color.WHITE);
        this.lbl_POS_2.setBounds(245, 45, 90, 20);

        this.lbl_NEG_2 = new JLabel("");
        this.lbl_NEG_2.setFont(fuente);
        this.lbl_NEG_2.setForeground(Color.WHITE);
        this.lbl_NEG_2.setBounds(245, 60, 90, 20);

        this.lbl_TOT_9 = new JLabel("");
        this.lbl_TOT_9.setFont(fuente);
        this.lbl_TOT_9.setForeground(Color.BLACK);
        this.lbl_TOT_9.setBounds(240, 110, 90, 20);

        this.lbl_POS_9 = new JLabel("");
        this.lbl_POS_9.setFont(fuente);
        this.lbl_POS_9.setForeground(Color.WHITE);
        this.lbl_POS_9.setBounds(240, 125, 90, 20);

        this.lbl_NEG_9 = new JLabel("");
        this.lbl_NEG_9.setFont(fuente);
        this.lbl_NEG_9.setForeground(Color.WHITE);
        this.lbl_NEG_9.setBounds(240, 140, 90, 20);

        this.lbl_TOT_1 = new JLabel("");
        this.lbl_TOT_1.setFont(fuente);
        this.lbl_TOT_1.setForeground(Color.BLACK);
        this.lbl_TOT_1.setBounds(240, 190, 90, 20);

        this.lbl_POS_1 = new JLabel("");
        this.lbl_POS_1.setFont(fuente);
        this.lbl_POS_1.setForeground(Color.WHITE);
        this.lbl_POS_1.setBounds(240, 205, 90, 20);

        this.lbl_NEG_1 = new JLabel("");
        this.lbl_NEG_1.setFont(fuente);
        this.lbl_NEG_1.setForeground(Color.WHITE);
        this.lbl_NEG_1.setBounds(240, 220, 90, 20);



        this.pnlImg.add(this.lbl_TOT_4);
        this.pnlImg.add(this.lbl_POS_4);
        this.pnlImg.add(this.lbl_NEG_4);

        this.pnlImg.add(this.lbl_TOT_7);
        this.pnlImg.add(this.lbl_POS_7);
        this.pnlImg.add(this.lbl_NEG_7);

        this.pnlImg.add(this.lbl_TOT_5);
        this.pnlImg.add(this.lbl_POS_5);
        this.pnlImg.add(this.lbl_NEG_5);

        this.pnlImg.add(this.lbl_TOT_6);
        this.pnlImg.add(this.lbl_POS_6);
        this.pnlImg.add(this.lbl_NEG_6);

        this.pnlImg.add(this.lbl_TOT_8);
        this.pnlImg.add(this.lbl_POS_8);
        this.pnlImg.add(this.lbl_NEG_8);

        this.pnlImg.add(this.lbl_TOT_3);
        this.pnlImg.add(this.lbl_POS_3);
        this.pnlImg.add(this.lbl_NEG_3);

        this.pnlImg.add(this.lbl_TOT_2);
        this.pnlImg.add(this.lbl_POS_2);
        this.pnlImg.add(this.lbl_NEG_2);

        this.pnlImg.add(this.lbl_TOT_9);
        this.pnlImg.add(this.lbl_POS_9);
        this.pnlImg.add(this.lbl_NEG_9);

        this.pnlImg.add(this.lbl_TOT_1);
        this.pnlImg.add(this.lbl_POS_1);
        this.pnlImg.add(this.lbl_NEG_1);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCont = new javax.swing.JPanel();
        comActualizar = new javax.swing.JButton();
        comCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cboEquipo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboParciales = new javax.swing.JComboBox();
        cboGestos = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboP = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cboZona = new javax.swing.JComboBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);
        setTitle("Analisis de Zonas");

        pnlCont.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 271, Short.MAX_VALUE)
        );

        comActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Rotacion.png"))); // NOI18N
        comActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comActualizarActionPerformed(evt);
            }
        });

        comCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cerrar.png"))); // NOI18N
        comCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCerrarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        cboEquipo.setFont(new java.awt.Font("Tahoma", 0, 10));
        cboEquipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("EQP:");

        jLabel2.setText("SET:");

        cboParciales.setFont(new java.awt.Font("Tahoma", 0, 10));
        cboParciales.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboGestos.setFont(new java.awt.Font("Tahoma", 0, 10));
        cboGestos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("GESTO:");

        cboP.setFont(new java.awt.Font("Tahoma", 0, 10));
        cboP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Condicion:");

        cboZona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboP, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboZona, 0, 76, Short.MAX_VALUE))
                    .addComponent(cboGestos, 0, 146, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboEquipo, cboParciales});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cboGestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(cboParciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCont, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comActualizar, 0, 0, Short.MAX_VALUE)
                            .addComponent(comCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCerrarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
}//GEN-LAST:event_comCerrarActionPerformed

    private void comActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comActualizarActionPerformed
        // TODO add your handling code here:
        String cons = ope.getCondicionSql(cboEquipo, cboParciales, cboGestos, cboP, cboZona);
        ope.analizar("1", lbl_TOT_1, lbl_POS_1, lbl_NEG_1, cons);
        ope.analizar("2", lbl_TOT_2, lbl_POS_2, lbl_NEG_2, cons);
        ope.analizar("3", lbl_TOT_3, lbl_POS_3, lbl_NEG_3, cons);
        ope.analizar("4", lbl_TOT_4, lbl_POS_4, lbl_NEG_4, cons);
        ope.analizar("5", lbl_TOT_5, lbl_POS_5, lbl_NEG_5, cons);
        ope.analizar("6", lbl_TOT_6, lbl_POS_6, lbl_NEG_6, cons);
        ope.analizar("7", lbl_TOT_7, lbl_POS_7, lbl_NEG_7, cons);
        ope.analizar("8", lbl_TOT_8, lbl_POS_8, lbl_NEG_8, cons);
        ope.analizar("9", lbl_TOT_9, lbl_POS_9, lbl_NEG_9, cons);
}//GEN-LAST:event_comActualizarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboEquipo;
    private javax.swing.JComboBox cboGestos;
    private javax.swing.JComboBox cboP;
    private javax.swing.JComboBox cboParciales;
    private javax.swing.JComboBox cboZona;
    private javax.swing.JButton comActualizar;
    private javax.swing.JButton comCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlCont;
    // End of variables declaration//GEN-END:variables

    private void cargarEquipos() {
        this.cboEquipo.setModel(new DefaultComboBoxModel(ope.getCodigosEquipos(getJuego().getId().toString())));
    }

    private void cargarGestos() {
        this.cboGestos.setModel(new DefaultComboBoxModel(ope.getGestos(getJuego().getId().toString())));
    }

    private void cargarParciales() {
        this.cboParciales.setModel(new DefaultComboBoxModel(ope.getParciales(getJuego().getId().toString())));
    }

    private void cargarCondiciones() {
        this.cboP.setModel(new DefaultComboBoxModel(new String[]{"NO", "P", "aP"}));
        this.cboZona.setModel(new DefaultComboBoxModel(new String[]{"Ninguna", "en 1", "en 2", "en 3", "en 4", "en 5", "en 6"}));
    }

    /**
     * @return the juego
     */
    public Juego getJuego() {
        return juego;
    }

    /**
     * @param juego the juego to set
     */
    public void setJuego(Juego juego) {
        this.juego = juego;
        this.ope = new OperacionesAnalisisZona(FormPrincipal.getCon(), FormPrincipal.getOperacionesBasicas());
        this.cargarEquipos();
        this.cargarGestos();
        this.cargarParciales();
        this.cargarCondiciones();
    }
}
