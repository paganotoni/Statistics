/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.game;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.pagbel.statistics.action.GameAction;
import org.pagbel.statistics.structure.Team;
import org.pagbel.statistics.structure.Tournament;

/**
 *
 * @author apagano
 */
@Entity
@Table(name="st_games")
public class Game implements Serializable {
  
  public enum GameResult {
    SELF_TEAM_WIN, OPPONENT_TEAM_WIN, GOING;
  }
  
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  Long id;
  
  @ManyToOne
  @JoinColumn(name="fk_tournament")
  Tournament tournament;
  
  @ManyToOne
  @JoinColumn(name="self_team_id")
  Team selfTeam;
  
  @ManyToOne
  @JoinColumn(name="opponent_team_id")
  Team opponentTeam;
  
  @OneToMany(mappedBy="game")
  Set<GameAction> actions;
  
  @Enumerated
  GameResult gameResult;
  
  @Enumerated
  GameConfiguration configuration;
  
  @Temporal(javax.persistence.TemporalType.DATE)
  Date programationDate;
  
  @Temporal(javax.persistence.TemporalType.DATE)
  Date created_at = new Date();
  
  String city;
  String country;
  
  @OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
  Set<Partial> partials = new HashSet<Partial>();

  public Game() {
    
  }
  
  public Game( Team selfTeam, Team opponentTeam, GameConfiguration configuration, Partial initialPartial ){
    this.selfTeam = selfTeam;
    this.opponentTeam = opponentTeam;
    this.configuration = configuration;
    gameResult = GameResult.GOING;
    partials.add( initialPartial );
  }
  
  /**
   * Returns the current GOING server.
   * 
   * @return 
   */
  public Partial getCurrentPartial(){
    Partial result = null;
    
    for( Partial partial : partials ){
      result = partial.result == Partial.PartialResult.GOING ? partial : result;
      if( result != null ){
        break ;
      }
    }
    
    return result;
  }
  
  public void addPartial( Partial partial ){
    partials.add( partial );
  }
  
  public GameConfiguration getGameConfiguration( ){
    return this.configuration;
  }

  public GameResult getGameResult() {
    return gameResult;
  }

  public void setGameResult(GameResult result) {
    this.gameResult = result;
  }
  
  public Integer lastPartialNumber( ){
    return this.partials.size();
  }
  
  public Integer nextPartialMaxPoints(){
    Integer nextPartialIndex = lastPartialNumber();
    return this.configuration.getPartialsMaxPoints()[nextPartialIndex];
  }
  
  public Integer selfWinPartialsCount(){
    Integer result = 0;
    
    for( Partial partial : partials ){
      result = partial.result == Partial.PartialResult.SELF_TEAM_WIN ? result + 1 : result;
    }
    
    return result;
  }
  
  public Integer opponentWinPartialsCount(){
    Integer result = 0;
    
    for( Partial partial : partials ){
      result = partial.result == Partial.PartialResult.OPPONENT_TEAM_WIN ? result + 1 : result;
    }
    
    return result;
  }

  public String getOpponentCode() {
    return this.opponentTeam.getCode();
  }

  public String getSelfCode() {
    return this.selfTeam.getCode();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<GameAction> getActions() {
    return actions;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Game other = (Game) obj;
    if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
    return hash;
  }
  
  
  

}
