/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.engine;

import org.pagbel.statistics.game.Game;

/**
 *
 * @author apagano
 */
public class GameHolder {
  private Game currentGame;

  public Game getCurrentGame() {
    return currentGame;
  }

  public void setGame(Game currentGame) {
    this.currentGame = currentGame;
  }
}
