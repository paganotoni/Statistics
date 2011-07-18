/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.pagbel.statistics.ui.action.ActionList;
import org.pagbel.statistics.ui.action.EditAction;
import org.pagbel.statistics.ui.game.CommandEditor;
import org.pagbel.statistics.ui.game.CreateGame;
import org.pagbel.statistics.ui.structure.CreateTeam;
import org.pagbel.statistics.ui.game.DefineRotations;
import org.pagbel.statistics.ui.game.GameList;
import org.pagbel.statistics.ui.game.GameStatus;
import org.pagbel.statistics.ui.MainWindow;
import org.pagbel.statistics.ui.structure.CreatePlayer;
import org.pagbel.statistics.ui.structure.CreateTournament;
import org.pagbel.statistics.ui.structure.PlayerList;
import org.pagbel.statistics.ui.structure.TeamList;
import org.pagbel.statistics.ui.structure.TournamentList;

/**
 *
 * @author apagano
 */
@Configuration
public class UIConfig {
  
  public @Bean MainWindow getMainWindow(){
    return new MainWindow();
  }
  
  public @Bean CreateGame getCreateGame(){
    return new CreateGame();
  }
  
  public @Bean CreateTeam getCreateTeam(){
    return new CreateTeam();
  }
  
  public @Bean DefineRotations getDefineRotation(){
    return new DefineRotations();
  }
  
  public @Bean TeamList getTeamList(){
    return new TeamList();
  }
  
    public @Bean GameStatus getStatusWindow(){
    return new GameStatus();
  }
  
  public @Bean GameList getGameList(){
    return new GameList();
  }
  
  public @Bean CommandEditor getCommandWindow(){
    return new CommandEditor();
  }
  
  public @Bean ActionList getActionList(){
    return new ActionList();
  }
  
  public @Bean EditAction getActionEdit(){
    return new EditAction();
  }
  
  public @Bean TournamentList getTournamentList(){
    return new TournamentList();
  }
  
  public @Bean CreateTournament getTournamentEdit(){
    return new CreateTournament();
  }
  
  public @Bean PlayerList getPlayerList(){
    return new PlayerList();
  }
  
  public @Bean CreatePlayer getCreatePlayer(){
    return new CreatePlayer();
  }
}
