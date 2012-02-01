/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.game;

/**
 *
 * @author apagano
 */
public enum GameConfiguration {
  
  THREE_OF_FIVE( 3, new Integer[]{ 25, 25, 25, 25, 15}, "3 of 5" ), 
  TWO_OF_THREE( 2, new Integer[]{ 25, 25, 15 } , "2 of 3" ),
  TRAINING( 1, new Integer[]{ Integer.MAX_VALUE }, "Training Session");
  
  final Integer[] partialsMaxPoints;
  final Integer maxPartials;
  final String visual_name;
  
  private GameConfiguration( Integer maxPartials, Integer[] partialsMaxPoints, String visual_name ){
    this.maxPartials = maxPartials;
    this.partialsMaxPoints = partialsMaxPoints;
    this.visual_name = visual_name;
  }

  public Integer getMaxPartials() {
    return maxPartials;
  }

  public Integer[] getPartialsMaxPoints() {
    return partialsMaxPoints;
  }
  
  public String toString(){
    return this.visual_name;
  }
  
}
