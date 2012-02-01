/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.*;
import org.pagbel.statistics.action.GameAction;

/**
 *
 * @author apagano
 */
@Entity
@Table(name = "st_partials")
public class Partial implements Serializable {

  public enum PartialResult {
    SELF_TEAM_WIN, OPPONENT_TEAM_WIN, GOING;
  }
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  @ManyToOne
  @JoinColumn(name = "game_id")
  Game game;
  @OneToMany(mappedBy = "partial", cascade=CascadeType.ALL)
  Set<GameAction> actions;
  Integer selfPoints;
  Integer opponentPoints;
  Integer maxPoints;
  String[] selfTeamRotation;
  String[] opponentTeamRotation;
  Integer selfPasserRotationIndex;
  Integer opponentPasserRotationIndex;
  String selfPasser;
  String opponentPasser;
  Boolean selfTeamOnService = Boolean.TRUE;
  Boolean selfTeamLeftTop = Boolean.TRUE;
  Boolean horizontalOrientation = Boolean.TRUE;
  @Enumerated(EnumType.STRING)
  PartialResult result = PartialResult.GOING;

  public Partial() {
  }

  public Partial(Integer maxPoints) {
    this.selfPoints = 0;
    this.opponentPoints = 0;
    this.maxPoints = maxPoints;
  }

  public void setResult(PartialResult result) {
    this.result = result;
  }

  public void incrementSelfPoints(Integer quantity) {
    this.selfPoints += quantity;
  }

  public void incrementOpponentPoints(Integer quantity) {
    this.opponentPoints += quantity;
  }

  public Boolean isSelfTeamOnService() {
    return selfTeamOnService;
  }

  public void setSelfTeamOnService(Boolean selfTeamOnService) {
    this.selfTeamOnService = selfTeamOnService;
  }

  public Integer getMaxPoints() {
    return maxPoints;
  }

  public Integer getOpponentPoints() {
    return opponentPoints;
  }

  public Integer getSelfPoints() {
    return selfPoints;
  }

  public String getOpponentPasser() {
    return opponentPasser;
  }

  public void setOpponentPasser(String opponentPasser) {
    this.opponentPasser = opponentPasser;
  }

  public Integer getOpponentPasserRotationIndex() {
    return opponentPasserRotationIndex;
  }

  public void setOpponentPasserRotationIndex(Integer opponentPasserRotationIndex) {
    this.opponentPasserRotationIndex = opponentPasserRotationIndex;
  }

  public String[] getOpponentTeamRotation() {
    return opponentTeamRotation;
  }

  public void setOpponentTeamRotation(String[] opponentTeamRotation) {
    this.opponentTeamRotation = opponentTeamRotation;
  }

  public String getSelfPasser() {
    return selfPasser;
  }

  public void setSelfPasser(String selfPasser) {
    this.selfPasser = selfPasser;
  }

  public Integer getSelfPasserRotationIndex() {
    return selfPasserRotationIndex;
  }

  public void setSelfPasserRotationIndex(Integer selfPasserRotationIndex) {
    this.selfPasserRotationIndex = selfPasserRotationIndex;
  }

  public String[] getSelfTeamRotation() {
    return selfTeamRotation;
  }

  public void setSelfTeamRotation(String[] selfTeamRotation) {
    this.selfTeamRotation = selfTeamRotation;
  }

  public void rotateSelfTeam() {
    this.setSelfTeamRotation(rotateRotationOrder(this.selfTeamRotation));
  }

  public void rotateOpponentTeam() {
    this.setOpponentTeamRotation(rotateRotationOrder(this.opponentTeamRotation));
  }

  public void backSelfTeamRotation() {
    this.setSelfTeamRotation(rotateRotationOrderNegative(this.selfTeamRotation));
  }

  public void backOpponentTeamRotation() {
    this.setOpponentTeamRotation(rotateRotationOrderNegative(this.opponentTeamRotation));
  }

  public String getSelfRotationString() {
    return getStorageFormattedRotation(this.selfTeamRotation);
  }

  public String getOpponentRotationString() {
    return getStorageFormattedRotation(this.opponentTeamRotation);
  }

  public String getStorageFormattedRotation(String[] rotation) {
    String result = "";

    if (rotation.length > 0) {
      result += rotation[0];
      for (int index = 1; index < result.length(); index++) {
        result += "," + rotation[index].trim();
      }
    }

    return result;
  }

  public String[] rotateRotationOrder(String[] rotation) {
    if (rotation != null) {
      String[] copy = rotation.clone();

      for (int index = 0; index < rotation.length; index++) {
        copy[index] = index == (rotation.length - 1) ? rotation[0] : rotation[index + 1];
      }

      return copy;
    } else {
      return rotation;
    }
  }

  public String[] rotateRotationOrderNegative(String[] rotation) {
    if (rotation != null) {
      String[] copy = rotation.clone();

      for (int index = 0; index < rotation.length; index++) {
        copy[index] = index == 0 ? rotation[rotation.length - 1] : rotation[index - 1];
      }

      return copy;
    } else {
      return rotation;
    }
  }

  public String getState() {
    return "self => " + selfPoints + ", opponent => " + opponentPoints + ", selfService => " + this.selfTeamOnService + ", partial => " + this;
  }

  public Boolean getSelfTeamLeftTop() {
    return selfTeamLeftTop;
  }

  public void setSelfTeamLeftTop(Boolean selfTeamLeftTop) {
    this.selfTeamLeftTop = selfTeamLeftTop;
  }

  public Boolean getHorizontalOrientation() {
    this.horizontalOrientation = horizontalOrientation == null ? Boolean.FALSE : horizontalOrientation;
    return horizontalOrientation;
  }

  public void setHorizontalOrientation(Boolean horizontalOrientation) {
    this.horizontalOrientation = horizontalOrientation;
  }
}
