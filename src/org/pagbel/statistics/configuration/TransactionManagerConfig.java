/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate3.HibernateTransactionManager;

/**
 *
 * @author apagano
 */
@Configuration
@Import({HibernateConfig.class})
public class TransactionManagerConfig {
  @Autowired
  private SessionFactory sessionFactory;
  
  @Bean(name="transactionManager")
  public HibernateTransactionManager getHibernateTransactionManager(){
    return new HibernateTransactionManager( sessionFactory );
  }
}
