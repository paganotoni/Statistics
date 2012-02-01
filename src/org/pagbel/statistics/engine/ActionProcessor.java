/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.engine;

import javax.swing.JOptionPane;
import org.pagbel.statistics.action.GameAction;
import org.pagbel.statistics.game.Game;
import org.pagbel.statistics.game.Game.GameResult;
import org.pagbel.statistics.game.GameConfiguration;
import org.pagbel.statistics.game.Partial;
import org.pagbel.statistics.game.Partial.PartialResult;
import org.pagbel.statistics.hibernate.DatabaseOperator;
import org.pagbel.statistics.ui.MainWindow;
import org.pagbel.statistics.ui.action.ActionList;
import org.pagbel.statistics.ui.game.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apagano
 */
public class ActionProcessor {

  GameHolder gameHolder;
  @Autowired
  DatabaseOperator databaseOperator;
  @Autowired
  GameStatus gameStatus;
  @Autowired
  ActionList actionList;
  @Autowired
  MainWindow mainWindow;

  public ActionProcessor(GameHolder gameHolder) {
    this.gameHolder = gameHolder;
  }

  public Game getCurrentGame() {
    return this.gameHolder.getCurrentGame();
  }

  /**
   * This method should affect :
   * 
   * - Partial Points   DONE
   * - Service Order    DONE
   * - Teams rotations  DONE
   * - Partial State if maxPoint reached ( or diff) DONE
   * - Game state if maxSets reached  DONE
   * - Needs to detect if game has ended and depending on it accept or not
   *   new actions.
   * 
   * @param action 
   */
  public void processAction(GameAction action, Boolean applySideEffects) {

    Partial currentPartial = getCurrentGame().getCurrentPartial();
    action.setSelfTeamPasser(currentPartial.getSelfPasser());
    action.setOpponentTeamPasser(currentPartial.getOpponentPasser());
    action.setSelfTeamRotation(currentPartial.getSelfTeamRotation());
    action.setOpponentTeamRotation(currentPartial.getOpponentTeamRotation());

    Game currentGame = gameHolder.getCurrentGame();
    
    action.setGame(currentGame);
    action.setPartial(currentPartial);
    
    if( action.getWrongCode() == false ) {
      action.setActionTeam( action.getTeam().equals( "*" ) ? currentGame.getSelfTeam() : currentGame.getOpponentTeam()  );
    }
    
    action.setOpponentTeamPoints(currentPartial.getOpponentPoints());
    action.setSelfTeamPoints(currentPartial.getSelfPoints());
    
    
    if (action.getWrongCode() == Boolean.FALSE) {
      action.setService(this.isService(currentPartial, action));
    }
    
    databaseOperator.saveOrUpdate(action);
    
    //Side Operators should not apply if GameConfiguration says its a Training Session.
     applySideEffects = applySideEffects && currentGame.getGameConfiguration() != GameConfiguration.TRAINING;
    
    if( applySideEffects == Boolean.TRUE ) {
      if (!action.getWrongCode() && action.isEnding()) {
        
        // Point Assignation logic
        Boolean selfPoint = isSelfPoint(action);
        alterPartialPoints( selfPoint );

        // Service change logic
        Boolean serviceChangeRequired = isServiceChange(selfPoint);
        if (serviceChangeRequired) {
          changeService();
          rotateServiceTeam();
        }

        //Partial Ending logic
        if (isFinishedPartial()) {
          gameStatus.updateStatus();

          finishCurrentPartial();
          if (isFinishedGame()) {
            finishGame();
            JOptionPane.showInternalMessageDialog(mainWindow.getDesktopPane(), "Game has Ended");

          } else {

            mainWindow.showDefineRotations();
            //Creation of the next set;
            Partial nextPartial = new Partial(getCurrentGame().nextPartialMaxPoints());
            getCurrentGame().addPartial(nextPartial);
          }
        }
      }
    }
    
    

    databaseOperator.saveOrUpdate(currentPartial);
    databaseOperator.saveOrUpdate(gameHolder.getCurrentGame());

    gameStatus.updateStatus();
    actionList.reloadActionList();
    //Reload Game status
  }

  public void alterPartialPoints(Boolean selfPoint) {
    if (selfPoint) {
      this.getCurrentGame().getCurrentPartial().incrementSelfPoints(1);
    } else {
      this.getCurrentGame().getCurrentPartial().incrementOpponentPoints(1);
    }
  }

  public void changeService() {
    Partial currentPartial = this.getCurrentGame().getCurrentPartial();
    currentPartial.setSelfTeamOnService(!currentPartial.isSelfTeamOnService());
  }

  /**
   * Should be called after service change done.
   */
  public void rotateServiceTeam() {
    Partial currentPartial = this.getCurrentGame().getCurrentPartial();
    
    //Should determine if team rotations have been set.
    if (currentPartial.isSelfTeamOnService()) {
      System.out.println("New Rotation for: " + getCurrentGame().getSelfCode());
      currentPartial.rotateSelfTeam();
    } else {
      System.out.println("New Rotation for: " + getCurrentGame().getOpponentCode());
      currentPartial.rotateOpponentTeam();
    }
  }

  public void finishCurrentPartial() {
    Partial currentPartial = this.getCurrentGame().getCurrentPartial();

    PartialResult result = currentPartial.getOpponentPoints() > currentPartial.getSelfPoints() ? PartialResult.OPPONENT_TEAM_WIN : PartialResult.SELF_TEAM_WIN;
    currentPartial.setResult(result);
  }

  public void finishGame() {
    GameResult result = getCurrentGame().selfWinPartialsCount() > getCurrentGame().opponentWinPartialsCount() ? Game.GameResult.SELF_TEAM_WIN : Game.GameResult.OPPONENT_TEAM_WIN;
    getCurrentGame().setGameResult(result);
  }

  public Boolean isSelfPoint(GameAction action) {
    Boolean selfPositiveAction = action.getEvaluation().equals("#") && action.getTeam().equals("*");
    Boolean opponentError = action.getEvaluation().equals("=") && action.getTeam().equals("a");
    Boolean selfPoint = selfPositiveAction || opponentError;

    return selfPoint;
  }

  public Boolean isServiceChange(Boolean isSelfPoint) {
    Boolean isSelfService = getCurrentGame().getCurrentPartial().isSelfTeamOnService();
    return (isSelfPoint && !isSelfService) || (!isSelfPoint && isSelfService);
  }

  public Boolean isFinishedPartial() {
    Partial currentPartial = getCurrentGame().getCurrentPartial();
    Boolean maxPointsReachedBySelfTeam = currentPartial.getMaxPoints() <= currentPartial.getSelfPoints();
    Boolean maxPointsReachedByOpponentTeam = currentPartial.getMaxPoints() <= currentPartial.getOpponentPoints();

    Boolean maxPointReached = maxPointsReachedBySelfTeam || maxPointsReachedByOpponentTeam;
    Boolean differenceOfTwo = Math.abs(currentPartial.getOpponentPoints() - currentPartial.getSelfPoints()) >= 2;
    return maxPointReached && differenceOfTwo;
  }

  public Boolean isFinishedGame() {
    Boolean selfWin = getCurrentGame().selfWinPartialsCount() == getCurrentGame().getGameConfiguration().getMaxPartials();
    Boolean opponentWin = getCurrentGame().selfWinPartialsCount() == getCurrentGame().getGameConfiguration().getMaxPartials();
    return selfWin || opponentWin;
  }

  private Boolean isService(Partial currentPartial, GameAction action) {
    Boolean serviceForSelf = currentPartial.isSelfTeamOnService() && action.getTeam().equals("*");
    Boolean serviceForOpponent = !(currentPartial.isSelfTeamOnService()) && action.getTeam().equals("a");
    return serviceForOpponent || serviceForSelf;
  }
}
