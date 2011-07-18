/*
 * FormJuego.java
 *
 * Created on 9 de agosto de 2007, 05:21 AM
 */
package Vista;

import Controlador.OperacionesJuegoCargado;
import Modelo.Juego;
import Modelo.PanelImagen;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author  Jakolov
 */
public class FormJuego extends javax.swing.JInternalFrame {

    OperacionesJuegoCargado ope;
    private Juego juego;
    private int ptosPropios = 0;
    private int ptosOpp = 0;
    private String sqeActual;
    PanelImagen pnlImg = new PanelImagen(new ImageIcon(getClass().getResource("/Iconos/sala.png")).getImage());
    javax.swing.JLabel lbl_1i;
    javax.swing.JLabel lbl_2i;
    javax.swing.JLabel lbl_3i;
    javax.swing.JLabel lbl_4i;
    javax.swing.JLabel lbl_5i;
    javax.swing.JLabel lbl_6i;
    javax.swing.JLabel lbl_1d;
    javax.swing.JLabel lbl_2d;
    javax.swing.JLabel lbl_3d;
    javax.swing.JLabel lbl_4d;
    javax.swing.JLabel lbl_5d;
    javax.swing.JLabel lbl_6d;
    javax.swing.JLabel lbl_sqeDer;
    javax.swing.JLabel lbl_sqeIzq;

    /** Creates new form FormJuego */
    public FormJuego() {
        initComponents();
        pnlImg.setLayout(null);
        cargarLabelRotacion();
        pnlCont.add(pnlImg);
    }

    public void cargarLabelRotacion() {
        java.awt.Font fuente = new java.awt.Font("", java.awt.Font.BOLD, 20);
        lbl_5i = new javax.swing.JLabel(" ");
        lbl_5i.setBounds(55, 25, 47, 51);
        lbl_5i.setHorizontalAlignment(lbl_5i.CENTER);
        lbl_5i.setForeground(java.awt.Color.black);
        lbl_5i.setFont(fuente);

        lbl_6i = new javax.swing.JLabel(" ");
        lbl_6i.setBounds(55, 75, 47, 51);
        lbl_6i.setHorizontalAlignment(lbl_6i.CENTER);
        lbl_6i.setForeground(java.awt.Color.black);
        lbl_6i.setFont(fuente);

        lbl_1i = new javax.swing.JLabel(" ");
        lbl_1i.setBounds(55, 125, 47, 51);
        lbl_1i.setHorizontalAlignment(lbl_1i.CENTER);
        lbl_1i.setForeground(java.awt.Color.black);
        lbl_1i.setFont(fuente);

        lbl_4i = new javax.swing.JLabel(" ");
        lbl_4i.setBounds(120, 25, 47, 51);
        lbl_4i.setHorizontalAlignment(lbl_5i.CENTER);
        lbl_4i.setForeground(java.awt.Color.black);
        lbl_4i.setFont(fuente);

        lbl_3i = new javax.swing.JLabel(" ");
        lbl_3i.setBounds(120, 75, 47, 51);
        lbl_3i.setHorizontalAlignment(lbl_6i.CENTER);
        lbl_3i.setForeground(java.awt.Color.black);
        lbl_3i.setFont(fuente);

        lbl_2i = new javax.swing.JLabel(" ");
        lbl_2i.setBounds(120, 125, 47, 51);
        lbl_2i.setHorizontalAlignment(lbl_1i.CENTER);
        lbl_2i.setForeground(java.awt.Color.black);
        lbl_2i.setFont(fuente);


        lbl_2d = new javax.swing.JLabel(" ");
        lbl_2d.setBounds(170, 25, 47, 51);
        lbl_2d.setHorizontalAlignment(lbl_1i.CENTER);
        lbl_2d.setForeground(java.awt.Color.gray);
        lbl_2d.setFont(fuente);

        lbl_3d = new javax.swing.JLabel(" ");
        lbl_3d.setBounds(170, 75, 47, 51);
        lbl_3d.setHorizontalAlignment(lbl_6i.CENTER);
        lbl_3d.setForeground(java.awt.Color.gray);
        lbl_3d.setFont(fuente);

        lbl_4d = new javax.swing.JLabel(" ");
        lbl_4d.setBounds(170, 125, 47, 51);
        lbl_4d.setHorizontalAlignment(lbl_5i.CENTER);
        lbl_4d.setForeground(java.awt.Color.gray);
        lbl_4d.setFont(fuente);

        lbl_1d = new javax.swing.JLabel(" ");
        lbl_1d.setBounds(240, 25, 47, 51);
        lbl_1d.setHorizontalAlignment(lbl_1i.CENTER);
        lbl_1d.setForeground(java.awt.Color.gray);
        lbl_1d.setFont(fuente);

        lbl_6d = new javax.swing.JLabel(" ");
        lbl_6d.setBounds(240, 75, 47, 51);
        lbl_6d.setHorizontalAlignment(lbl_6i.CENTER);
        lbl_6d.setForeground(java.awt.Color.gray);
        lbl_6d.setFont(fuente);

        lbl_5d = new javax.swing.JLabel(" ");
        lbl_5d.setBounds(240, 125, 47, 51);
        lbl_5d.setHorizontalAlignment(lbl_5i.CENTER);
        lbl_5d.setForeground(java.awt.Color.gray);
        lbl_5d.setFont(fuente);

        lbl_sqeIzq = new javax.swing.JLabel();
        lbl_sqeIzq.setBounds(5, 145, 30, 30);
        lbl_sqeIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/saq.png")));

        lbl_sqeDer = new javax.swing.JLabel();
        lbl_sqeDer.setBounds(315, 25, 30, 30);
        lbl_sqeDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nsaq.png")));

        pnlImg.add(lbl_5i);
        pnlImg.add(lbl_6i);
        pnlImg.add(lbl_1i);
        pnlImg.add(lbl_4i);
        pnlImg.add(lbl_3i);
        pnlImg.add(lbl_2i);

        pnlImg.add(lbl_2d);
        pnlImg.add(lbl_3d);
        pnlImg.add(lbl_4d);
        pnlImg.add(lbl_1d);
        pnlImg.add(lbl_6d);
        pnlImg.add(lbl_5d);

        pnlImg.add(lbl_sqeIzq);
        pnlImg.add(lbl_sqeDer);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        pnlCont = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        comCambiar = new javax.swing.JButton();
        comRotaciones = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblPtosIzq = new javax.swing.JLabel();
        lblParcialesIzq = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPtosDer = new javax.swing.JLabel();
        lblParcialesDer = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblCodIzq = new javax.swing.JLabel();
        lblCodIzq1 = new javax.swing.JLabel();
        lblCodIzq3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblCodIzq2 = new javax.swing.JLabel();
        lblCodDer = new javax.swing.JLabel();
        lblCodIzq4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        comCambiarSaque = new javax.swing.JButton();
        comRotarMasIzquierda = new javax.swing.JButton();
        comRotarMenosIzquierda = new javax.swing.JButton();
        comSubirPtosIzq = new javax.swing.JButton();
        comRotarMasDerecha = new javax.swing.JButton();
        comRotarMenosDerecha = new javax.swing.JButton();
        comSubirPtosDer = new javax.swing.JButton();
        comBajarPtosIzq = new javax.swing.JButton();
        comBajarPtosDer = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        pnlCont.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        comCambiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cambiar.png"))); // NOI18N
        comCambiar.setToolTipText("Cambiar Equipos de Lado");
        comCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCambiarActionPerformed(evt);
            }
        });

        comRotaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Rotacion.png"))); // NOI18N
        comRotaciones.setToolTipText("Definir Rotacion");
        comRotaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comRotacionesActionPerformed(evt);
            }
        });

        lblPtosIzq.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblPtosIzq.setForeground(new java.awt.Color(102, 102, 102));
        lblPtosIzq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPtosIzq.setText("XX");

        lblParcialesIzq.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblParcialesIzq.setForeground(new java.awt.Color(255, 0, 0));
        lblParcialesIzq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblParcialesIzq.setText("XX");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(lblParcialesIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPtosIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblParcialesIzq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPtosIzq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblPtosDer.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblPtosDer.setForeground(new java.awt.Color(102, 102, 102));
        lblPtosDer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPtosDer.setText("XX");

        lblParcialesDer.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblParcialesDer.setForeground(new java.awt.Color(255, 0, 0));
        lblParcialesDer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblParcialesDer.setText("XX");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPtosDer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblParcialesDer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblPtosDer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblParcialesDer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCodIzq.setBackground(new java.awt.Color(0, 153, 255));
        lblCodIzq.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCodIzq.setForeground(new java.awt.Color(51, 153, 255));
        lblCodIzq.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodIzq.setText("PRO");

        lblCodIzq1.setBackground(new java.awt.Color(0, 153, 255));
        lblCodIzq1.setFont(new java.awt.Font("Tahoma", 1, 9));
        lblCodIzq1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodIzq1.setText("Ptos");

        lblCodIzq3.setBackground(new java.awt.Color(0, 153, 255));
        lblCodIzq3.setFont(new java.awt.Font("Tahoma", 1, 9));
        lblCodIzq3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodIzq3.setText("Sets");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblCodIzq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lblCodIzq3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCodIzq1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblCodIzq)
                .addComponent(lblCodIzq1)
                .addComponent(lblCodIzq3))
        );

        lblCodIzq2.setBackground(new java.awt.Color(0, 153, 255));
        lblCodIzq2.setFont(new java.awt.Font("Tahoma", 1, 9));
        lblCodIzq2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodIzq2.setText("Ptos");

        lblCodDer.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCodDer.setForeground(new java.awt.Color(255, 0, 51));
        lblCodDer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodDer.setText("OPP");

        lblCodIzq4.setBackground(new java.awt.Color(0, 153, 255));
        lblCodIzq4.setFont(new java.awt.Font("Tahoma", 1, 9));
        lblCodIzq4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodIzq4.setText("Sets");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodIzq2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCodIzq4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(lblCodDer)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblCodIzq2)
                .addComponent(lblCodDer)
                .addComponent(lblCodIzq4))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comRotaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel5});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel2, jPanel4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(comRotaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(comCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        comCambiarSaque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cambiarSaque.png"))); // NOI18N
        comCambiarSaque.setToolTipText("Cambiar Saque");
        comCambiarSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCambiarSaqueActionPerformed(evt);
            }
        });

        comRotarMasIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/RotarMas.png"))); // NOI18N
        comRotarMasIzquierda.setToolTipText("Rot +");
        comRotarMasIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comRotarMasIzquierdaActionPerformed(evt);
            }
        });

        comRotarMenosIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/RotarMenos.png"))); // NOI18N
        comRotarMenosIzquierda.setToolTipText("Rot -");
        comRotarMenosIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comRotarMenosIzquierdaActionPerformed(evt);
            }
        });

        comSubirPtosIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PuntosMas.png"))); // NOI18N
        comSubirPtosIzq.setToolTipText("Puntos +");
        comSubirPtosIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comSubirPtosIzqActionPerformed(evt);
            }
        });

        comRotarMasDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/RotarMas.png"))); // NOI18N
        comRotarMasDerecha.setToolTipText("Rot +");
        comRotarMasDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comRotarMasDerechaActionPerformed(evt);
            }
        });

        comRotarMenosDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/RotarMenos.png"))); // NOI18N
        comRotarMenosDerecha.setToolTipText("Rot -");
        comRotarMenosDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comRotarMenosDerechaActionPerformed(evt);
            }
        });

        comSubirPtosDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PuntosMas.png"))); // NOI18N
        comSubirPtosDer.setToolTipText("Puntos +");
        comSubirPtosDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comSubirPtosDerActionPerformed(evt);
            }
        });

        comBajarPtosIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PuntosMenos.png"))); // NOI18N
        comBajarPtosIzq.setToolTipText("Puntos -");
        comBajarPtosIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBajarPtosIzqActionPerformed(evt);
            }
        });

        comBajarPtosDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/PuntosMenos.png"))); // NOI18N
        comBajarPtosDer.setToolTipText("Puntos -");
        comBajarPtosDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBajarPtosDerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(comBajarPtosIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comSubirPtosIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comRotarMenosIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comRotarMasIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(comCambiarSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(comRotarMasDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comRotarMenosDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comSubirPtosDer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(comBajarPtosDer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comBajarPtosDer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comRotarMasDerecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comRotarMenosDerecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comBajarPtosIzq, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                        .addComponent(comSubirPtosIzq, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                        .addComponent(comRotarMenosIzquierda, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                        .addComponent(comRotarMasIzquierda, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                        .addComponent(comCambiarSaque, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(comSubirPtosDer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCont, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-366)/2, (screenSize.height-375)/2, 366, 375);
    }// </editor-fold>//GEN-END:initComponents

    private void comRotacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comRotacionesActionPerformed
        // TODO add your handling code here:
        ope = new OperacionesJuegoCargado(FormPrincipal.getCon(), FormPrincipal.getOperacionesBasicas());
        ope.cargarParcial(juego.getId().toString());
        ope.cargarRally();
        FormPrincipal.getFormRotacion().setJuego(juego);
        FormPrincipal.getFormRotacion().setVisible(true);
}//GEN-LAST:event_comRotacionesActionPerformed

    private void comCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCambiarActionPerformed
        // TODO add your handling code here:
        ope = new OperacionesJuegoCargado(FormPrincipal.getCon(), FormPrincipal.getOperacionesBasicas());
        ope.cargarParcial(juego.getId().toString());
        ope.cargarRally();
        String[] posiciones = ope.cambiarPosicionesEquipo(juego.getCodPropio(), juego.getCodOpp());
        this.lblCodIzq.setText(posiciones[0]);
        this.lblCodDer.setText(posiciones[1]);
        //Acomodamos el saque.
        this.sqeActual = ope.getSaque(juego.getCodPropio(), juego.getCodOpp());
        this.setSaque(this.sqeActual);
        this.cargarPuntos();
        this.cargarParciales();
        this.cargarRotaciones();
    }//GEN-LAST:event_comCambiarActionPerformed

    private void comCambiarSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCambiarSaqueActionPerformed
        // TODO add your handling code here:
        ope.cambiarSaque(this.sqeActual, juego.getCodPropio(), juego.getCodOpp());
        this.sqeActual = ope.getSaque(juego.getCodPropio(), juego.getCodOpp());
        this.setSaque(this.sqeActual);
        this.cargarPuntos();

}//GEN-LAST:event_comCambiarSaqueActionPerformed

    private void comRotarMasIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comRotarMasIzquierdaActionPerformed
        // TODO add your handling code here:
        ope.rotarMas(new JLabel[]{this.lbl_1i, this.lbl_2i, this.lbl_3i, this.lbl_4i, this.lbl_5i, this.lbl_6i});
        int swp = 0;
        if (!this.juego.getCodPropio().equals(this.lblCodIzq.getText())) {
            swp = 1;
        }
        ope.guardarPosP(new JLabel[]{this.lbl_1i, this.lbl_2i, this.lbl_3i, this.lbl_4i, this.lbl_5i, this.lbl_6i}, swp, new java.awt.Color(0, 153, 255));
}//GEN-LAST:event_comRotarMasIzquierdaActionPerformed

    private void comRotarMenosIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comRotarMenosIzquierdaActionPerformed
        // TODO add your handling code here:
        ope.rotarMenos(new JLabel[]{this.lbl_1i, this.lbl_2i, this.lbl_3i, this.lbl_4i, this.lbl_5i, this.lbl_6i});
        int swp = 0;
        if (!this.juego.getCodPropio().equals(this.lblCodIzq.getText())) {
            swp = 1;
        }
        ope.guardarPosP(new JLabel[]{this.lbl_1i, this.lbl_2i, this.lbl_3i, this.lbl_4i, this.lbl_5i, this.lbl_6i}, swp, new java.awt.Color(0, 153, 255));
}//GEN-LAST:event_comRotarMenosIzquierdaActionPerformed

    private void comSubirPtosIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comSubirPtosIzqActionPerformed
        // TODO add your handling code here:
        if (this.lblCodIzq.getText().equals(juego.getCodPropio())) {
            ope.subirPuntos(0, ptosPropios);
        } else {
            ope.subirPuntos(1, ptosOpp);
        }
        this.cargarPuntos();
}//GEN-LAST:event_comSubirPtosIzqActionPerformed

    private void comRotarMasDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comRotarMasDerechaActionPerformed
        // TODO add your handling code here:
        ope.rotarMas(new JLabel[]{this.lbl_1d, this.lbl_2d, this.lbl_3d, this.lbl_4d, this.lbl_5d, this.lbl_6d});
        int swp = 0;
        if (!this.juego.getCodPropio().equals(this.lblCodDer.getText())) {
            swp = 1;
        }
        ope.guardarPosP(new JLabel[]{this.lbl_1d, this.lbl_2d, this.lbl_3d, this.lbl_4d, this.lbl_5d, this.lbl_6d}, swp, java.awt.Color.RED);
}//GEN-LAST:event_comRotarMasDerechaActionPerformed

    private void comRotarMenosDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comRotarMenosDerechaActionPerformed
        // TODO add your handling code here:
        ope.rotarMenos(new JLabel[]{this.lbl_1d, this.lbl_2d, this.lbl_3d, this.lbl_4d, this.lbl_5d, this.lbl_6d});
        int swp = 0;
        if (!this.juego.getCodPropio().equals(this.lblCodDer.getText())) {
            swp = 1;
        }
        ope.guardarPosP(new JLabel[]{this.lbl_1d, this.lbl_2d, this.lbl_3d, this.lbl_4d, this.lbl_5d, this.lbl_6d}, swp, java.awt.Color.RED);
}//GEN-LAST:event_comRotarMenosDerechaActionPerformed

    private void comSubirPtosDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comSubirPtosDerActionPerformed
        // TODO add your handling code here:
        if (this.lblCodDer.getText().equals(juego.getCodPropio())) {
            ope.subirPuntos(0, ptosPropios);
        } else {
            ope.subirPuntos(1, ptosOpp);
        }
        this.cargarPuntos();
}//GEN-LAST:event_comSubirPtosDerActionPerformed

    private void comBajarPtosIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBajarPtosIzqActionPerformed
        // TODO add your handling code here:
        if (this.lblCodIzq.getText().equals(juego.getCodPropio())) {
            ope.bajarPuntos(0, ptosPropios);
        } else {
            ope.bajarPuntos(1, ptosOpp);
        }
        this.cargarPuntos();
}//GEN-LAST:event_comBajarPtosIzqActionPerformed

    private void comBajarPtosDerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comBajarPtosDerActionPerformed
        // TODO add your handling code here:
        if (this.lblCodDer.getText().equals(juego.getCodPropio())) {
            ope.bajarPuntos(0, ptosPropios);
        } else {
            ope.bajarPuntos(1, ptosOpp);
        }
        this.cargarPuntos();
}//GEN-LAST:event_comBajarPtosDerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comBajarPtosDer;
    private javax.swing.JButton comBajarPtosIzq;
    private javax.swing.JButton comCambiar;
    private javax.swing.JButton comCambiarSaque;
    private javax.swing.JButton comRotaciones;
    private javax.swing.JButton comRotarMasDerecha;
    private javax.swing.JButton comRotarMasIzquierda;
    private javax.swing.JButton comRotarMenosDerecha;
    private javax.swing.JButton comRotarMenosIzquierda;
    private javax.swing.JButton comSubirPtosDer;
    private javax.swing.JButton comSubirPtosIzq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblCodDer;
    private javax.swing.JLabel lblCodIzq;
    private javax.swing.JLabel lblCodIzq1;
    private javax.swing.JLabel lblCodIzq2;
    private javax.swing.JLabel lblCodIzq3;
    private javax.swing.JLabel lblCodIzq4;
    private javax.swing.JLabel lblParcialesDer;
    private javax.swing.JLabel lblParcialesIzq;
    private javax.swing.JLabel lblPtosDer;
    private javax.swing.JLabel lblPtosIzq;
    private javax.swing.JPanel pnlCont;
    // End of variables declaration//GEN-END:variables

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
        ope = new OperacionesJuegoCargado(FormPrincipal.getCon(), FormPrincipal.getOperacionesBasicas());
        this.juego = juego;
        String[] result = ope.getPosicionesEquipo(String.valueOf(juego.getId()), juego.getCodPropio(), juego.getCodOpp());
        this.lblCodIzq.setText(result[0]);
        this.lblCodDer.setText(result[1]);
        sqeActual = ope.getSaque(juego.getCodPropio(), juego.getCodOpp());
        cargarPuntos();
        cargarParciales();
        this.setSaque(sqeActual);
        this.cargarRotaciones();
    }

    private void cargarPuntos() {
        this.setPtosPropios(ope.getPuntosPropios());
        this.setPtosOpp(ope.getPuntosOpp());
    }

    private void cargarParciales() {
        this.setParcialesPropios();
        this.setParcialesOpp();
    }

    /**
     * @return the ptosPropios
     */
    public int getPtosPropios() {
        return ptosPropios;
    }

    /**
     * @param ptosPropios the ptosPropios to set
     */
    public void setPtosPropios(int ptosPropios) {
        this.ptosPropios = ptosPropios;
        if (this.lblCodDer.getText().equals(juego.getCodPropio())) {
            this.lblPtosDer.setText(String.valueOf(ptosPropios));
        } else {
            this.lblPtosIzq.setText(String.valueOf(ptosPropios));
        }
    }

    public void setParcialesPropios() {
        if (this.lblCodDer.getText().equals(juego.getCodPropio())) {
            this.lblParcialesDer.setText(String.valueOf(ope.getSetsEquipo(this.juego.getId().toString(), this.juego.getCodPropio())));
        } else {
            this.lblParcialesIzq.setText(String.valueOf(ope.getSetsEquipo(this.juego.getId().toString(), this.juego.getCodPropio())));
        }
    }

    public void setParcialesOpp() {
        if (this.lblCodDer.getText().equals(juego.getCodOpp())) {
            this.lblParcialesDer.setText(String.valueOf(ope.getSetsEquipo(this.juego.getId().toString(), this.juego.getCodOpp())));
        } else {
            this.lblParcialesIzq.setText(String.valueOf(ope.getSetsEquipo(this.juego.getId().toString(), this.juego.getCodOpp())));
        }
    }

    /**
     * @return the ptosOpp
     */
    public int getPtosOpp() {
        return ptosOpp;
    }

    /**
     * @param ptosOpp the ptosOpp to set
     */
    public void setPtosOpp(int ptosOpp) {
        this.ptosOpp = ptosOpp;
        if (this.lblCodDer.getText().equals(juego.getCodOpp())) {
            this.lblPtosDer.setText(String.valueOf(ptosOpp));
        } else {
            this.lblPtosIzq.setText(String.valueOf(ptosOpp));
        }
    }

    private void setSaque(String saque) {
        if (saque.equals(juego.getCodPropio())) {
            if (lblCodIzq.getText().equals(juego.getCodPropio())) {
                lbl_sqeIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/saq.png")));
                lbl_sqeDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nsaq.png")));
            } else {
                lbl_sqeDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/saq.png")));
                lbl_sqeIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nsaq.png")));
            }
        } else {
            if (lblCodIzq.getText().equals(juego.getCodOpp())) {
                lbl_sqeIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/saq.png")));
                lbl_sqeDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nsaq.png")));
            } else {
                lbl_sqeDer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/saq.png")));
                lbl_sqeIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nsaq.png")));
            }
        }
    }

    private void cargarRotaciones() {
        try {
            this.ope.setRotacion(juego.getId(), this.lblCodIzq.getText(), new JLabel[]{this.lbl_1i, this.lbl_2i, this.lbl_3i, this.lbl_4i, this.lbl_5i, this.lbl_6i}, new java.awt.Color(0, 153, 255), java.awt.Color.GRAY, juego.getCodPropio());
            this.ope.setRotacion(juego.getId(), this.lblCodDer.getText(), new JLabel[]{this.lbl_1d, this.lbl_2d, this.lbl_3d, this.lbl_4d, this.lbl_5d, this.lbl_6d}, java.awt.Color.RED, java.awt.Color.BLACK, juego.getCodPropio());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
