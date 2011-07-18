/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import org.pagbel.statistics.hibernate.DatabaseOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author apagano
 */
@Configuration
public class DatabaseOperatorConfig {
  
 public @Bean DatabaseOperator getDatabaseOperator(){
   return new DatabaseOperator();
 }
 
}
