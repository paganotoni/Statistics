/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author apagano
 */
@Configuration

public class HibernateConfig {

  @Bean
  public SessionFactory getSessionFactory(){
    org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
    configuration.setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.EmbeddedDriver");
    configuration.setProperty("hibernate.connection.url", "jdbc:derby:statistics;create=true"/*jdbc:h2:tcp://localhost/~/statistics"*/);
    configuration.setProperty("hibernate.connection.user", "");
    configuration.setProperty("hibernate.connection.password", "");
    
    //Use to play with this param to update database :)
    configuration.setProperty("hibernate.hbm2ddl.auto", "update");
    configuration.setProperty("hibernate.show_sql", "true" );
    configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
    configuration.setProperty("hibernate.current_session_context_class", "org.hibernate.context.ThreadLocalSessionContext");
    
    configuration.addAnnotatedClass(org.pagbel.statistics.structure.Team.class);
    configuration.addAnnotatedClass(org.pagbel.statistics.game.Game.class);
    configuration.addAnnotatedClass(org.pagbel.statistics.game.Partial.class);
    configuration.addAnnotatedClass(org.pagbel.statistics.action.GameAction.class);
    configuration.addAnnotatedClass(org.pagbel.statistics.structure.Player.class);
    configuration.addAnnotatedClass(org.pagbel.statistics.structure.Tournament.class);
    return configuration.buildSessionFactory();
  }
  
  
}
