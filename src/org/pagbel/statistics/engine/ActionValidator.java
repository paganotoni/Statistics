/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.engine;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author apagano
 */
public class ActionValidator extends SequenceOperator{

  private Pattern validationPattern = Pattern.compile("["+TEAM+"]?["+NUMBERS+"]{0,2}["+TECHNICAL+"]["+EVALUATIONS+"]["+ZONES+"]{0,2}");
  
  public Boolean isValid( String sequence ){
    Matcher matcher = validationPattern.matcher(sequence);
    return matcher.matches();
  }
  
}
