/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.action;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.pagbel.statistics.engine.EndingAttributeCombination;
import org.pagbel.statistics.game.Game;
import org.pagbel.statistics.game.Partial;
import org.pagbel.statistics.structure.Team;

/**
 *
 * @author apagano
 */
@Entity
@Table(name = "st_action")
public class GameAction implements Serializable {

  static final String DEFAULT_PLAYER_NUMBER = "99";
  static final String DEFAULT_TEAM = "*";
  static final String DEFAULT_ZONES = "00";
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @ManyToOne
  @JoinColumn(name = "game_fk")
  private Game game;
  
  @ManyToOne
  @JoinColumn(name = "partial_fk")
  private Partial partial;
  
  @ManyToOne
  @JoinColumn(name = "team_fk")
  private Team actionTeam;
  
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date dateCreated = new Date();
  
  private String completeCode;
  private Boolean wrongCode;
  
  private String team;  //should be the real team
  private String playerNumber;
  private String fundamental;
  private String evaluation;
  private String zones;
  private Integer selfTeamPoints;
  private Integer opponentTeamPoints;
  private String[] selfTeamRotation;
  private String[] opponentTeamRotation;
  private String selfTeamPasser;
  private String opponentTeamPasser;
  private Boolean service;

  public GameAction() {
    
  }

  public GameAction(String completeCode) {
    this.completeCode = completeCode;
    this.wrongCode = Boolean.TRUE;
    this.dateCreated = new Date();
  }

  public GameAction(String completeCode, String team, String playerNumber, String fundamental, String evaluation, String zones) {
    this(completeCode);
    this.team = team.trim().length() == 0 ? DEFAULT_TEAM : team;
    this.playerNumber = playerNumber.trim().length() == 0 ? DEFAULT_PLAYER_NUMBER : playerNumber;
    this.fundamental = fundamental;
    this.evaluation = evaluation;
    this.zones = zones.trim().length() == 0 ? DEFAULT_ZONES : zones;
    this.setWrongCode(Boolean.FALSE);
    this.dateCreated = new Date();
  }

  public Boolean isEnding() {
    Boolean result = Boolean.FALSE;
    for (EndingAttributeCombination combination : EndingAttributeCombination.values()) {
      result = combination.getEvaluation().equals(this.getEvaluation()) && combination.getFundamental().equals(this.getFundamental()) ? Boolean.TRUE : Boolean.FALSE;

      if (result) {
        break;
      }
    }

    return result;
  }

  public String getEvaluation() {
    return evaluation;
  }

  public String getFundamental() {
    return fundamental;
  }

  public String getPlayerNumber() {
    return playerNumber;
  }

  public String getTeam() {
    return team;
  }

  public String getZones() {
    return zones;
  }

  /**
   * @param team the team to set
   */
  public void setTeam(String team) {
    this.team = team;
  }

  /**
   * @param playerNumber the playerNumber to set
   */
  public void setPlayerNumber(String playerNumber) {
    this.playerNumber = playerNumber;
  }

  /**
   * @param fundamental the fundamental to set
   */
  public void setFundamental(String fundamental) {
    this.fundamental = fundamental;
  }

  /**
   * @param evaluation the evaluation to set
   */
  public void setEvaluation(String evaluation) {
    this.evaluation = evaluation;
  }

  /**
   * @param zones the zones to set
   */
  public void setZones(String zones) {
    this.zones = zones;
  }

  /**
   * @return the selfTeamRotation
   */
  public String[] getSelfTeamRotation() {
    return selfTeamRotation;
  }

  /**
   * @param selfTeamRotation the selfTeamRotation to set
   */
  public void setSelfTeamRotation(String[] selfTeamRotation) {
    this.selfTeamRotation = selfTeamRotation;
  }

  /**
   * @return the opponentTeamRotation
   */
  public String[] getOpponentTeamRotation() {
    return opponentTeamRotation;
  }

  /**
   * @param opponentTeamRotation the opponentTeamRotation to set
   */
  public void setOpponentTeamRotation(String[] opponentTeamRotation) {
    this.opponentTeamRotation = opponentTeamRotation;
  }

  /**
   * @return the selfTeamPasser
   */
  public String getSelfTeamPasser() {
    return selfTeamPasser;
  }

  /**
   * @param selfTeamPasser the selfTeamPasser to set
   */
  public void setSelfTeamPasser(String selfTeamPasser) {
    this.selfTeamPasser = selfTeamPasser;
  }

  /**
   * @return the opponentTeamPasser
   */
  public String getOpponentTeamPasser() {
    return opponentTeamPasser;
  }

  /**
   * @param opponentTeamPasser the opponentTeamPasser to set
   */
  public void setOpponentTeamPasser(String opponentTeamPasser) {
    this.opponentTeamPasser = opponentTeamPasser;
  }

  /**
   * @return the service
   */
  public Boolean getService() {
    return service;
  }

  /**
   * @param service the service to set
   */
  public void setService(Boolean service) {
    this.service = service;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public Integer getOpponentTeamPoints() {
    return opponentTeamPoints;
  }

  public void setOpponentTeamPoints(Integer opponentTeamPoints) {
    this.opponentTeamPoints = opponentTeamPoints;
  }

  public Partial getPartial() {
    return partial;
  }

  public void setPartial(Partial partial) {
    this.partial = partial;
  }

  public Integer getSelfTeamPoints() {
    return selfTeamPoints;
  }

  public void setSelfTeamPoints(Integer selfTeamPoints) {
    this.selfTeamPoints = selfTeamPoints;
  }

  public String getCompleteCode() {
    return completeCode;
  }

  public void setCompleteCode(String completeCode) {
    this.completeCode = completeCode.startsWith("*") || completeCode.startsWith("a") ? completeCode : ("*" + completeCode);
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Boolean getWrongCode() {
    return wrongCode;
  }

  public void setWrongCode(Boolean wrongCode) {
    this.wrongCode = wrongCode;
  }

  public Integer getSelfPasserPosition() {
    int result = -1;
    String[] selfRotation = this.getSelfTeamRotation();
    if (selfRotation != null) {
      for (int i = 0; i < selfRotation.length; i++) {
        if (selfRotation[i].equals(this.getSelfTeamPasser())) {
          result = i + 1;
          break;
        }
      }

    }

    return result;
  }

  public Integer getOpponentPasserPosition() {
    int result = -1;
    String[] opponentRotation = this.getOpponentTeamRotation();
    if (opponentRotation != null) {
      for (int i = 0; i < opponentRotation.length; i++) {
        if (opponentRotation[i].equals(this.getOpponentTeamPasser())) {
          result = i + 1;
          break;
        }
      }
    }

    return result;
  }

  public String getCodeByActionParts() {
    return this.team + this.playerNumber + this.fundamental + this.evaluation + this.zones;
  }
  
  public String getActionDetailsString(){
    return this.team + this.playerNumber + this.fundamental + this.evaluation + this.zones;
  }
  
  public Team getActionTeam() {
    return actionTeam;
  }

  public void setActionTeam(Team actionTeam) {
    this.actionTeam = actionTeam;
  }
}
