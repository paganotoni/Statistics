/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import org.pagbel.statistics.engine.GameBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author apagano
 */
@Configuration
public class GameBuilderConfig {
  
  @Bean
  public GameBuilder getGameBuilder(){
    return new GameBuilder();
  }
   
}
