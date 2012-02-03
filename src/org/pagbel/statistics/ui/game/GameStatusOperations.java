/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.ui.game;

import java.awt.Font;
import java.io.InputStream;
import javax.swing.JLabel;

/**
 *
 * @author antoniopagano
 */
public class GameStatusOperations {

  private Font scoreFont;
  private InputStream scoreFontFile = getClass().getResourceAsStream("/org/statistics/ui/fonts/DS-DIGI.ttf");

  public GameStatusOperations() {
    try {
      scoreFont = Font.createFont(Font.PLAIN, scoreFontFile);
    } catch (Exception e) {
      System.out.println("Exeption Loading scoreboard Font");
    }
  }

  public void setScoreboardFont(JLabel lftPointsLabel, JLabel rghPointsLabel, JLabel leftPartialsLabel, JLabel rightPartialsLabel) {
    if (scoreFont != null) {
      lftPointsLabel.setFont(scoreFont.deriveFont(28f));
      rghPointsLabel.setFont(scoreFont.deriveFont(28f));
      leftPartialsLabel.setFont(scoreFont.deriveFont(20f));
      rightPartialsLabel.setFont(scoreFont.deriveFont(20f));
    }
  }
  
  //TODO: Here should be the rest of the operations shared between Vertical and horizontal status.
}
