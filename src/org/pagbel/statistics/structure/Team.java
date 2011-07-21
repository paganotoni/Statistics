/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.structure;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.pagbel.statistics.action.GameAction;

/**
 *
 * @author apagano
 */
@Entity
@Table(name="st_teams")
public class Team implements Serializable {
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id;
  
  @OneToMany(mappedBy="team")
  Set<Player> players;
  
  @OneToMany(mappedBy="team")
  Set<GameAction> actions;
  
  private String name;
  private String code;

  public Team() {
    
  }

  public Team(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  @Override
  public String toString(){
    return this.code + " - " + this.name;
  }

  public Set<Player> getPlayers() {
    return players;
  }
  
  

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Team other = (Team) obj;
    if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
      return false;
    }
    if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
      return false;
    }
    if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
    hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
    hash = 79 * hash + (this.code != null ? this.code.hashCode() : 0);
    return hash;
  }
  
  
  
}
