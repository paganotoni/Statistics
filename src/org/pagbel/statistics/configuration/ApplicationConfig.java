/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import java.util.Properties;
import org.pagbel.statistics.engine.ActionProcessor;
import org.pagbel.statistics.engine.CompoundActionGenerator;
import org.pagbel.statistics.engine.GameHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;


/**
 *
 * @author apagano
 */
@Configuration
@Import({ActionGeneratorConfig.class, 
         GameHolderConfig.class,
         GameBuilderConfig.class,
         UIConfig.class,
         HibernateTemplateConfig.class,
         TransactionManagerConfig.class ,
         TransactionProxyConfig.class })
@ImportResource("tx.xml")
public class ApplicationConfig {
  
  @Autowired
  private GameHolder gameHolder;
  
  public @Bean ActionProcessor getActionProcessor(){
    return new ActionProcessor(gameHolder);
  }
  
  public @Bean CompoundActionGenerator getCompoundProcessor(){
    return new CompoundActionGenerator();
  }
  
  
  
}
