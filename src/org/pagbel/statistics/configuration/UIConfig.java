/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import org.pagbel.statistics.ui.MainWindow;
import org.pagbel.statistics.ui.action.ActionList;
import org.pagbel.statistics.ui.action.EditAction;
import org.pagbel.statistics.ui.game.*;
import org.pagbel.statistics.ui.reports.GameReport;
import org.pagbel.statistics.ui.structure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
  
  public @Bean GameHorizontalStatus getStatusWindow(){
    return new GameHorizontalStatus();
  }
    
  public @Bean GameVerticalStatus getVerticalStatusWindow(){
    return new GameVerticalStatus();
  }
  
  public @Bean GameStatusOperations getGameStatusOperations(){
    return new GameStatusOperations();
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
  
  public @Bean GameReport getGameReport(){
    return new GameReport();
  }
}
