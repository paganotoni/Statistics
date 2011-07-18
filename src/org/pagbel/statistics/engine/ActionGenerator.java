/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.pagbel.statistics.action.Action;
import org.pagbel.statistics.action.GameAction;

/**
 *
 * @author apagano
 */
public class ActionGenerator extends SequenceOperator {

  private Pattern processingPattern = Pattern.compile("([" + TEAM + "]?)([" + NUMBERS + "]{0,2})([" + TECHNICAL + "])([" + EVALUATIONS + "])([" + ZONES + "]{0,2})");
  private ActionValidator validator;
  
  public ActionGenerator( ActionValidator validator ){
    this.validator = validator;
  }
  
  public GameAction generate(String input) {
    GameAction action = new GameAction( input );
    if( validator.isValid( input ) ){

      Matcher matcher = processingPattern.matcher( input );
      matcher.find();
      
      String complete = matcher.group(0);
      String team = matcher.group(1);
      String player = matcher.group(2);
      String tech = matcher.group(3);
      String eval = matcher.group(4);
      String zone = matcher.group(5);
      
      action = new GameAction( complete , team, player, tech, eval, zone );
    }
    
    return action;
  }
}
