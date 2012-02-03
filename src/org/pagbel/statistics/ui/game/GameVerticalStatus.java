/*
 * FormJuego.java
 *
 * Created on 9 de agosto de 2007, 05:21 AM
 */
package org.pagbel.statistics.ui.game;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.pagbel.statistics.engine.GameHolder;
import org.pagbel.statistics.game.Game;
import org.pagbel.statistics.game.Partial;
import org.pagbel.statistics.hibernate.DatabaseOperator;
import org.pagbel.statistics.ui.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author  Jakolov
 */
public class GameVerticalStatus extends javax.swing.JInternalFrame {

  @Autowired
  GameHolder gameHolder;
  @Autowired
  MainWindow mainWindow;
  @Autowired
  DatabaseOperator databaseOperator;
  @Autowired
  GameStatusOperations gameStatusOperations;        
  
  ImageIcon serviceIcon = new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/saq.png"));
  ImageIcon receptionIcon = new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/nsaq.png"));
  CourtPanel pnlImg;
  Dimension zoneDimension = new Dimension(47, 51);
  
  Point[] leftLocations = new Point[]{new Point(125, 55), new Point(75, 55), new Point(25, 55), new Point(125, 125), new Point(75, 125), new Point(25, 125)};
  Point[] rightLocations = new Point[]{new Point(125, 170), new Point(75,170), new Point(25, 170), new Point(25, 240), new Point(75, 240), new Point(125, 240)};
  Point topService = new Point( 25, 0 );
  Point bottomService = new Point( 145, 315 );
  
  JLabel lbl_1i;
  JLabel lbl_2i;
  JLabel lbl_3i;
  JLabel lbl_4i;
  JLabel lbl_5i;
  JLabel lbl_6i;
  JLabel lbl_1d;
  JLabel lbl_2d;
  JLabel lbl_3d;
  JLabel lbl_4d;
  JLabel lbl_5d;
  JLabel lbl_6d;
  JLabel rghService;
  JLabel lftService;
  JLabel[] rightLabels;
  JLabel[] leftLabels;

  /** Creates new form FormJuego */
  public GameVerticalStatus() {
    initComponents();
  }

  public void loadPanel() {
    String resource = "/org/statistics/ui/icons/salaVert.png";
    Image image = new ImageIcon(getClass().getResource(resource)).getImage();
    this.pnlImg = new CourtPanel(image);
  }

  public void updateStatus() {
    restoreRotationLabelsColor();
    Game game = gameHolder.getCurrentGame();
    Partial currentPartial = game.getCurrentPartial();

    String leftPoints = currentPartial.getSelfTeamLeftTop() ? currentPartial.getSelfPoints().toString() : currentPartial.getOpponentPoints().toString();
    String rightPoints = !(currentPartial.getSelfTeamLeftTop()) ? currentPartial.getSelfPoints().toString() : currentPartial.getOpponentPoints().toString();
    Color lftColor = currentPartial.getSelfTeamLeftTop() ? Color.BLUE : Color.RED;
    Color rghColor = !(currentPartial.getSelfTeamLeftTop()) ? Color.BLUE : Color.RED;

    String leftCode = currentPartial.getSelfTeamLeftTop() ? game.getSelfCode() : game.getOpponentCode();
    String rightCode = !(currentPartial.getSelfTeamLeftTop()) ? game.getSelfCode() : game.getOpponentCode();

    this.lftPoints.setText(leftPoints);
    this.rghPoints.setText(rightPoints);

    this.leftCode.setText(leftCode);
    this.rightCode.setText(rightCode);

    this.leftCode.setForeground(lftColor);
    this.rightCode.setForeground(rghColor);

    this.lftPoints.setForeground(lftColor);
    this.rghPoints.setForeground(rghColor);

    //Updating Service :)
    Boolean selfOnLeft = currentPartial.getSelfTeamLeftTop();
    Boolean selfService = currentPartial.isSelfTeamOnService();

    this.leftPartials.setText(selfOnLeft ? game.selfWinPartialsCount().toString() : game.opponentWinPartialsCount().toString());
    this.rightPartials.setText(!selfOnLeft ? game.selfWinPartialsCount().toString() : game.opponentWinPartialsCount().toString());
    this.leftPartials.setForeground(lftColor);
    this.rightPartials.setForeground(rghColor);

    lftService.setIcon(selfOnLeft && selfService ? serviceIcon : receptionIcon);
    rghService.setIcon(selfOnLeft && selfService ? receptionIcon : serviceIcon);

    String[] leftRotation = selfOnLeft ? currentPartial.getSelfTeamRotation() : currentPartial.getOpponentTeamRotation();
    String[] rightRotation = !selfOnLeft ? currentPartial.getSelfTeamRotation() : currentPartial.getOpponentTeamRotation();


    //loafing Rotations
    loadLeftRotation(leftRotation != null ? leftRotation : new String[]{"", "", "", "", "", ""});
    loadRightRotation(rightRotation != null ? rightRotation : new String[]{"", "", "", "", "", ""});

    this.markLeftPasser();
    this.markRightPasser();
    
    gameStatusOperations.setScoreboardFont(lftPoints, rghPoints, leftPartials, rightPartials);

  }

  public void loadLeftRotation(String[] rotation) {
    this.leftLabels[2].setText(rotation[0]);
    this.leftLabels[5].setText(rotation[1]);
    this.leftLabels[4].setText(rotation[2]);
    this.leftLabels[3].setText(rotation[3]);
    this.leftLabels[0].setText(rotation[4]);
    this.leftLabels[1].setText(rotation[5]);
  }

  public void loadRightRotation(String[] rotation) {
    this.rightLabels[2].setText(rotation[3]);
    this.rightLabels[5].setText(rotation[4]);
    this.rightLabels[4].setText(rotation[5]);
    this.rightLabels[3].setText(rotation[0]);
    this.rightLabels[0].setText(rotation[1]);
    this.rightLabels[1].setText(rotation[2]);
  }

  public void loadRotationLabels() {
    rightLabels = new JLabel[]{lbl_5i, lbl_6i, lbl_1i, lbl_4i, lbl_3i, lbl_2i};
    leftLabels = new JLabel[]{lbl_5d, lbl_6d, lbl_1d, lbl_4d, lbl_3d, lbl_2d};
    Font basicFont = new Font("", java.awt.Font.BOLD, 20);

    for (int i = 0; i < rightLabels.length; i++) {
      JLabel label = new javax.swing.JLabel("");
      label.setFont(basicFont);
      label.setSize(zoneDimension);
      label.setLocation(rightLocations[i]);
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setForeground(java.awt.Color.black);
      pnlImg.add(label);
      rightLabels[i] = label;
    }

    for (int i = 0; i < leftLabels.length; i++) {
      JLabel label = new javax.swing.JLabel(" ");
      label.setFont(basicFont);
      label.setSize(zoneDimension);
      label.setLocation(leftLocations[i]);
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setForeground(java.awt.Color.GRAY);
      pnlImg.add(label);
      leftLabels[i] = label;
    }

    //Service Icon
    lftService = new javax.swing.JLabel();
    lftService.setSize(30, 30);
    lftService.setLocation(topService);
    lftService.setIcon(serviceIcon);
    

    rghService = new javax.swing.JLabel();
    rghService.setSize(30, 30);
    rghService.setLocation(bottomService);
    rghService.setIcon(receptionIcon);


    pnlImg.add(lftService);
    pnlImg.add(rghService);
  }

  private void markLeftPasser() {
    Game game = gameHolder.getCurrentGame();
    Partial currentPartial = game.getCurrentPartial();
    Color leftColor = currentPartial.getSelfTeamLeftTop() ? Color.BLUE : Color.RED;

    String leftPasser = currentPartial.getSelfTeamLeftTop() ? currentPartial.getSelfPasser() : currentPartial.getOpponentPasser();

    for (JLabel label : leftLabels) {
      if (label.getText().equals(leftPasser)) {
        label.setForeground(leftColor);
      }
    }
  }

  private void markRightPasser() {
    Game game = gameHolder.getCurrentGame();
    Partial currentPartial = game.getCurrentPartial();
    Color rightColor = !(currentPartial.getSelfTeamLeftTop()) ? Color.BLUE : Color.RED;

    String rightPasser = !currentPartial.getSelfTeamLeftTop() ? currentPartial.getSelfPasser() : currentPartial.getOpponentPasser();

    for (JLabel label : rightLabels) {
      if (label.getText().equals(rightPasser)) {
        label.setForeground(rightColor);
      }
    }

  }

  /**
   * It restores Rotations labels to default Gray and Black colors.
   */
  private void restoreRotationLabelsColor() {
    for (JLabel label : rightLabels) {
      label.setForeground(java.awt.Color.black);
    }

    for (JLabel label : leftLabels) {
      label.setForeground(java.awt.Color.GRAY);
    }
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel6 = new javax.swing.JPanel();
        pnlCont = new javax.swing.JPanel();
        pnlButtons = new javax.swing.JPanel();
        btnRotateLeft = new javax.swing.JButton();
        btnReturnRotationLeft = new javax.swing.JButton();
        btnDecreaseLeftPoints = new javax.swing.JButton();
        btnIncreaseLeftPoints = new javax.swing.JButton();
        btnSwitchSides = new javax.swing.JButton();
        btnIncreaseRightPoints = new javax.swing.JButton();
        btnDecreaseRightPoints = new javax.swing.JButton();
        btnReturnRotationRight = new javax.swing.JButton();
        btnRotateRight = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblCodIzq2 = new javax.swing.JLabel();
        rghPoints = new javax.swing.JLabel();
        lblCodIzq4 = new javax.swing.JLabel();
        rightPartials = new javax.swing.JLabel();
        rightCode = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRotations = new javax.swing.JButton();
        btnHorizontal = new javax.swing.JButton();
        btnSwitchService = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        leftCode = new javax.swing.JLabel();
        lblCodIzq3 = new javax.swing.JLabel();
        lblCodIzq1 = new javax.swing.JLabel();
        leftPartials = new javax.swing.JLabel();
        lftPoints = new javax.swing.JLabel();

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
        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                internalFrameOppened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
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

        pnlCont.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCont.setOpaque(false);

        javax.swing.GroupLayout pnlContLayout = new javax.swing.GroupLayout(pnlCont);
        pnlCont.setLayout(pnlContLayout);
        pnlContLayout.setHorizontalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        pnlContLayout.setVerticalGroup(
            pnlContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlButtons.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlButtons.setLayout(new java.awt.GridLayout(9, 1));

        btnRotateLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/RotarMas.png"))); // NOI18N
        btnRotateLeft.setToolTipText("Rot +");
        btnRotateLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotateLeftActionPerformed(evt);
            }
        });
        pnlButtons.add(btnRotateLeft);

        btnReturnRotationLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/RotarMenos.png"))); // NOI18N
        btnReturnRotationLeft.setToolTipText("Rot -");
        btnReturnRotationLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnRotationLeftActionPerformed(evt);
            }
        });
        pnlButtons.add(btnReturnRotationLeft);

        btnDecreaseLeftPoints.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/PuntosMenos.png"))); // NOI18N
        btnDecreaseLeftPoints.setToolTipText("Puntos -");
        btnDecreaseLeftPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecreaseLeftPointsActionPerformed(evt);
            }
        });
        pnlButtons.add(btnDecreaseLeftPoints);

        btnIncreaseLeftPoints.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/PuntosMas.png"))); // NOI18N
        btnIncreaseLeftPoints.setToolTipText("Puntos +");
        btnIncreaseLeftPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncreaseLeftPointsActionPerformed(evt);
            }
        });
        pnlButtons.add(btnIncreaseLeftPoints);

        btnSwitchSides.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/Cambiar.png"))); // NOI18N
        btnSwitchSides.setToolTipText("Cambiar Equipos de Lado");
        btnSwitchSides.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchSidesActionPerformed(evt);
            }
        });
        pnlButtons.add(btnSwitchSides);

        btnIncreaseRightPoints.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/PuntosMas.png"))); // NOI18N
        btnIncreaseRightPoints.setToolTipText("Puntos +");
        btnIncreaseRightPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncreaseRightPointsActionPerformed(evt);
            }
        });
        pnlButtons.add(btnIncreaseRightPoints);

        btnDecreaseRightPoints.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/PuntosMenos.png"))); // NOI18N
        btnDecreaseRightPoints.setToolTipText("Puntos -");
        btnDecreaseRightPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecreaseRightPointsActionPerformed(evt);
            }
        });
        pnlButtons.add(btnDecreaseRightPoints);

        btnReturnRotationRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/RotarMenos.png"))); // NOI18N
        btnReturnRotationRight.setToolTipText("Rot -");
        btnReturnRotationRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnRotationRightActionPerformed(evt);
            }
        });
        pnlButtons.add(btnReturnRotationRight);

        btnRotateRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/RotarMas.png"))); // NOI18N
        btnRotateRight.setToolTipText("Rot +");
        btnRotateRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotateRightActionPerformed(evt);
            }
        });
        pnlButtons.add(btnRotateRight);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lblCodIzq2.setBackground(new java.awt.Color(0, 153, 255));
        lblCodIzq2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        lblCodIzq2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodIzq2.setText("POINT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        jPanel2.add(lblCodIzq2, gridBagConstraints);

        rghPoints.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rghPoints.setForeground(new java.awt.Color(102, 102, 102));
        rghPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rghPoints.setText("XX");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 6;
        jPanel2.add(rghPoints, gridBagConstraints);

        lblCodIzq4.setBackground(new java.awt.Color(0, 153, 255));
        lblCodIzq4.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        lblCodIzq4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodIzq4.setText("SET");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        jPanel2.add(lblCodIzq4, gridBagConstraints);

        rightPartials.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rightPartials.setForeground(new java.awt.Color(255, 0, 0));
        rightPartials.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rightPartials.setText("XX");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 6;
        jPanel2.add(rightPartials, gridBagConstraints);

        rightCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rightCode.setForeground(new java.awt.Color(255, 0, 51));
        rightCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rightCode.setText("OPP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 6;
        jPanel2.add(rightCode, gridBagConstraints);

        jPanel3.setLayout(new java.awt.GridLayout(3, 1, 2, 2));

        btnRotations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/rotation.png"))); // NOI18N
        btnRotations.setToolTipText("Definir Rotacion");
        btnRotations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotationsActionPerformed(evt);
            }
        });
        jPanel3.add(btnRotations);

        btnHorizontal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/horizontal.png"))); // NOI18N
        btnHorizontal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorizontalActionPerformed(evt);
            }
        });
        jPanel3.add(btnHorizontal);

        btnSwitchService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/statistics/ui/icons/cambiarSaque.png"))); // NOI18N
        btnSwitchService.setToolTipText("Cambiar Saque");
        btnSwitchService.setMaximumSize(null);
        btnSwitchService.setMinimumSize(null);
        btnSwitchService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchServiceActionPerformed(evt);
            }
        });
        jPanel3.add(btnSwitchService);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        leftCode.setBackground(new java.awt.Color(0, 153, 255));
        leftCode.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        leftCode.setForeground(new java.awt.Color(51, 153, 255));
        leftCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leftCode.setText("PRO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 6;
        jPanel1.add(leftCode, gridBagConstraints);

        lblCodIzq3.setBackground(new java.awt.Color(0, 153, 255));
        lblCodIzq3.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        lblCodIzq3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodIzq3.setText("SET");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        jPanel1.add(lblCodIzq3, gridBagConstraints);

        lblCodIzq1.setBackground(new java.awt.Color(0, 153, 255));
        lblCodIzq1.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        lblCodIzq1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCodIzq1.setText("POINT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        jPanel1.add(lblCodIzq1, gridBagConstraints);

        leftPartials.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        leftPartials.setForeground(new java.awt.Color(255, 0, 0));
        leftPartials.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leftPartials.setText("XX");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 6;
        jPanel1.add(leftPartials, gridBagConstraints);

        lftPoints.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lftPoints.setForeground(new java.awt.Color(102, 102, 102));
        lftPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lftPoints.setText("XX");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 6;
        jPanel1.add(lftPoints, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(pnlCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 351, Short.MAX_VALUE)
                        .addComponent(pnlCont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-334)/2, (screenSize.height-409)/2, 334, 409);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRotationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotationsActionPerformed
      mainWindow.showDefineRotations();
}//GEN-LAST:event_btnRotationsActionPerformed

    private void btnSwitchSidesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchSidesActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      partial.setSelfTeamLeftTop(!partial.getSelfTeamLeftTop());
      this.updateStatus();
    }//GEN-LAST:event_btnSwitchSidesActionPerformed

    private void btnSwitchServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchServiceActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      partial.setSelfTeamOnService(!partial.isSelfTeamOnService());
      this.updateStatus();
}//GEN-LAST:event_btnSwitchServiceActionPerformed

    private void btnRotateLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotateLeftActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      Boolean selfOnLeft = partial.getSelfTeamLeftTop();

      if (selfOnLeft) {
        partial.rotateSelfTeam();
      } else {
        partial.rotateOpponentTeam();
      }

      this.updateStatus();
}//GEN-LAST:event_btnRotateLeftActionPerformed

    private void btnReturnRotationLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnRotationLeftActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      Boolean selfOnLeft = partial.getSelfTeamLeftTop();

      if (selfOnLeft) {
        partial.backSelfTeamRotation();
      } else {
        partial.backOpponentTeamRotation();
      }

      this.updateStatus();
}//GEN-LAST:event_btnReturnRotationLeftActionPerformed

    private void btnIncreaseLeftPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncreaseLeftPointsActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      Boolean selfOnLeft = partial.getSelfTeamLeftTop();

      if (selfOnLeft) {
        partial.incrementSelfPoints(1);
      } else {
        partial.incrementOpponentPoints(1);
      }

      this.updateStatus();
}//GEN-LAST:event_btnIncreaseLeftPointsActionPerformed

    private void btnRotateRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotateRightActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      Boolean selfOnLeft = partial.getSelfTeamLeftTop();

      if (!selfOnLeft) {
        partial.rotateSelfTeam();
      } else {
        partial.rotateOpponentTeam();
      }

      this.updateStatus();
}//GEN-LAST:event_btnRotateRightActionPerformed

    private void btnReturnRotationRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnRotationRightActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      Boolean selfOnLeft = partial.getSelfTeamLeftTop();

      if (!selfOnLeft) {
        partial.backSelfTeamRotation();
      } else {
        partial.backOpponentTeamRotation();
      }

      this.updateStatus();
}//GEN-LAST:event_btnReturnRotationRightActionPerformed

    private void btnIncreaseRightPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncreaseRightPointsActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      Boolean selfOnLeft = partial.getSelfTeamLeftTop();

      if (!selfOnLeft) {
        partial.incrementSelfPoints(1);
      } else {
        partial.incrementOpponentPoints(1);
      }

      this.updateStatus();
}//GEN-LAST:event_btnIncreaseRightPointsActionPerformed

    private void btnDecreaseRightPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecreaseRightPointsActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      Boolean selfOnLeft = partial.getSelfTeamLeftTop();

      if (!selfOnLeft) {
        partial.incrementSelfPoints(-1);
      } else {
        partial.incrementOpponentPoints(-1);
      }

      this.updateStatus();
}//GEN-LAST:event_btnDecreaseRightPointsActionPerformed

    private void btnDecreaseLeftPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecreaseLeftPointsActionPerformed
      Partial partial = gameHolder.getCurrentGame().getCurrentPartial();
      Boolean selfOnLeft = partial.getSelfTeamLeftTop();

      if (selfOnLeft) {
        partial.incrementSelfPoints(-1);
      } else {
        partial.incrementOpponentPoints(-1);
      }

      this.updateStatus();
}//GEN-LAST:event_btnDecreaseLeftPointsActionPerformed

    private void onShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_onShown
      System.out.println("Horizontal Orientation:");
      System.out.println(this.gameHolder.getCurrentGame().getCurrentPartial().getHorizontalOrientation());
      this.loadPanel();
      pnlImg.setLayout(null);
      this.loadRotationLabels();
      pnlCont.add(pnlImg);
      this.updateStatus();
    }//GEN-LAST:event_onShown

  private void btnHorizontalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorizontalActionPerformed
    Partial currentPartial = this.gameHolder.getCurrentGame().getCurrentPartial();
    currentPartial.setHorizontalOrientation(true);
    databaseOperator.saveOrUpdate(currentPartial);
    this.dispose();
    mainWindow.showStatus();
  }//GEN-LAST:event_btnHorizontalActionPerformed

  private void internalFrameOppened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_internalFrameOppened
    pnlCont.repaint();
  }//GEN-LAST:event_internalFrameOppened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDecreaseLeftPoints;
    private javax.swing.JButton btnDecreaseRightPoints;
    private javax.swing.JButton btnHorizontal;
    private javax.swing.JButton btnIncreaseLeftPoints;
    private javax.swing.JButton btnIncreaseRightPoints;
    private javax.swing.JButton btnReturnRotationLeft;
    private javax.swing.JButton btnReturnRotationRight;
    private javax.swing.JButton btnRotateLeft;
    private javax.swing.JButton btnRotateRight;
    private javax.swing.JButton btnRotations;
    private javax.swing.JButton btnSwitchService;
    private javax.swing.JButton btnSwitchSides;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblCodIzq1;
    private javax.swing.JLabel lblCodIzq2;
    private javax.swing.JLabel lblCodIzq3;
    private javax.swing.JLabel lblCodIzq4;
    private javax.swing.JLabel leftCode;
    private javax.swing.JLabel leftPartials;
    private javax.swing.JLabel lftPoints;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCont;
    private javax.swing.JLabel rghPoints;
    private javax.swing.JLabel rightCode;
    private javax.swing.JLabel rightPartials;
    // End of variables declaration//GEN-END:variables
}
