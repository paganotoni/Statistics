/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.engine;

import org.pagbel.statistics.game.Game;
import org.pagbel.statistics.game.GameConfiguration;
import org.pagbel.statistics.game.Partial;
import org.pagbel.statistics.structure.Team;

/**
 *
 * @author apagano
 */

public class GameBuilder {
  
  /**
   * It builds a new Game for us 
   * 
   * @param selfCode
   * @param opponentCode
   * @param config
   * @return 
   */
  public Game buildGame( Team selfTeam, Team opponentTeam, GameConfiguration config ){
    Partial initialPartial = new Partial(config.getPartialsMaxPoints()[0]);
    return new Game( selfTeam, opponentTeam, config , initialPartial );
  }
}
