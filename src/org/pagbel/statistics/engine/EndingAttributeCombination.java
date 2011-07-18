/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.engine;

/**
 *
 * @author apagano
 */
public enum EndingAttributeCombination {
  
  NEGATIVE_ATTACK("A", "="), 
  NEGATIVE_BLOCK("B", "="),
  NEGATIVE_DEFENSE("D", "="), 
  NEGATIVE_SERVICE("S", "="),
  NEGATIVE_RECEPTION("R", "="),
  NEGATIVE_PASS("P", "="),
  POSITIVE_SERVICE("S", "#"),
  POSITIVE_BLOCK("B", "#"),
  POSITIVE_ATTACK("A", "#");
  
  final String fundamental;
  final String evaluation;
  
  private EndingAttributeCombination( String fundamental, String evaluation ){
    this.fundamental = fundamental;
    this.evaluation = evaluation;
  }

  public String getEvaluation() {
    return evaluation;
  }

  public String getFundamental() {
    return fundamental;
  }
  
}
