/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.pagbel.statistics.hibernate.DatabaseOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

/**
 *
 * @author apagano
 */
@Configuration
@Import({HibernateConfig.class , DatabaseOperatorConfig.class, TransactionManagerConfig.class})
public class TransactionProxyConfig {
  
  
  @Autowired 
  private SessionFactory sessionFactory;
  
  @Autowired
  private HibernateTransactionManager transactionManager;

  
}
