/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import org.pagbel.statistics.engine.ActionGenerator;
import org.pagbel.statistics.engine.ActionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author apagano
 */
@Configuration
@Import(ActionValidatorConfig.class)
public class ActionGeneratorConfig {
  
  private @Autowired ActionValidator validator;
  
  public @Bean ActionGenerator getGenerator(){
    return new ActionGenerator(validator);
  } 
  
}
