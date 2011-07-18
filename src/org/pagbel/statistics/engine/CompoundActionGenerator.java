/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.engine;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.pagbel.statistics.action.GameAction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apagano
 */
public class CompoundActionGenerator extends SequenceOperator {

  @Autowired
  ActionGenerator actionGenerator;
  final static String technicalSequenceOrder = "SRPABD";
  final static String passingInitialActions = "SA";
  final static String[] continuationFundamentals = new String[]{"SR", "AB", "PA", "AD"};
  final static String[] continuationEvaluations = new String[]{"-+", "!¡", "=#", "+-", "¡!", "#=" };

  public GameAction[] generate(String code) {
    GameAction[] actions = null;
    String[] codeParts = code.split("\\.");

    //We decide to handle only 2 actions
    if (codeParts.length >= 2) {

      String partOne = codeParts[0];
      String partTwo = codeParts[1];

      GameAction actionOne = buildAction(partOne);
      GameAction actionTwo = buildAction(partTwo);
      
      Boolean alternateTeam = false;
      
      //Completing Fundamentals
      fundamentals: 
      for( String continuation : continuationFundamentals ){
        Boolean starts = String.valueOf(continuation.charAt(0)).equals( actionOne.getFundamental() );
        Boolean ends = String.valueOf(continuation.charAt(1)).equals( actionTwo.getFundamental() );
        
        if( starts || ends ){
          
          if( starts ){
            actionTwo.setFundamental( String.valueOf( continuation.charAt(1) ) );
          }else if( ends ) {
            actionOne.setFundamental( String.valueOf( continuation.charAt(0) ) );
          }
          
          break fundamentals;
        }
      }
      
      
      
      //Completing Evaluations
      evaluations:
      for( String continuation : continuationEvaluations ){
        Boolean starts = String.valueOf(continuation.charAt(0)).equals( actionOne.getEvaluation() );
        Boolean ends = String.valueOf(continuation.charAt(1)).equals( actionTwo.getEvaluation() );
        
        if( starts || ends ){
          if( starts ){
            actionTwo.setEvaluation( String.valueOf( continuation.charAt(1) ) );
          }else if( ends ) {
            actionOne.setEvaluation( String.valueOf( continuation.charAt(0) ) );
          }
          
          break evaluations;
        }
      }

      //Action Teams
      for(char ch : passingInitialActions.toCharArray()){
        if( actionOne.getFundamental().equals( String.valueOf(ch) ) ){
          alternateTeam = true;
        }
      }
      
      actionOne.setTeam( actionOne.getTeam() == null ? "*" : actionOne.getTeam() );
      
      if( alternateTeam ){
        actionTwo.setTeam( actionOne.getTeam().equals("*") ? "a" : "*");
      }else{
        actionTwo.setTeam( actionOne.getTeam().equals("*") ? "*" : "a");
      }
      
      
      
      //Updating complete codes :P
      actionOne.setCompleteCode( actionOne.getCodeByActionParts() );
      actionTwo.setCompleteCode( actionTwo.getCodeByActionParts() );
      
      actions = new GameAction[2];
      actions[0] = actionOne;
      actions[1] = actionTwo;
      
    }



    return actions;
  }

  private GameAction buildAction(String partialCode) {
   
    Pattern pattern = Pattern.compile("([" + TEAM + "]?)([" + NUMBERS + "]{0,2})([" + TECHNICAL + "]?)([" + EVALUATIONS + "]?)([" + ZONES + "]{0,2})");

    Matcher matcher = pattern.matcher(partialCode);
    matcher.find();

    GameAction action = new GameAction();
    action.setTeam(matcher.group(1).length() > 0 ? matcher.group(1) : "*");
    action.setPlayerNumber(matcher.group(2).length() > 0 ? matcher.group(2) : "99");
    action.setFundamental(matcher.group(3).length() > 0 ? matcher.group(3) : null);
    action.setEvaluation(matcher.group(4).length() > 0 ? matcher.group(4) : null);
    //Can be set to blank or 00
    action.setZones(matcher.group(5).length() > 0 ? matcher.group(5) : "00");
    action.setWrongCode(Boolean.FALSE);
  
    return action;
  }
  
  
}
