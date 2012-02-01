/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author apagano
 */
@Configuration
public class DatasourceConfig {
  
  @Bean
  public ComboPooledDataSource getDataSource() throws PropertyVetoException{
     ComboPooledDataSource datasource = new ComboPooledDataSource();
     datasource.setDriverClass("org.apache.derby.jdbc.EmbeddedDriver");
     datasource.setJdbcUrl("jdbc:derby:statistics;create=true");
     return datasource;
  }
}
