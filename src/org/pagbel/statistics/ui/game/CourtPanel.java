/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.ui.game;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CourtPanel extends JPanel {

  private Image image;

  public CourtPanel() {
    this("/Iconos/sala.png");
  }

  public CourtPanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public CourtPanel(Image img) {
    this.image = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  @Override
  public void paintComponent(Graphics g) {  
    super.paintComponent(g);
    g.drawImage(image, 1, 1, getWidth(), getHeight(), null);  
    this.repaint();
  }
  
}