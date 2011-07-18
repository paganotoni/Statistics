/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import org.pagbel.statistics.engine.GameHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author apagano
 */
@Configuration
public class GameHolderConfig {
  
  @Bean
  public GameHolder getGameHolder(){
    return new GameHolder();
  }
}
