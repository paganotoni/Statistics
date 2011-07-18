/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.ui.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class CourtPanel extends JPanel {

  private Image img;
  
  public CourtPanel(){
      this("/Iconos/sala.png");
  }
  
  public CourtPanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public CourtPanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

    @Override
  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

}