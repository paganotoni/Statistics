/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apagano
 */
public class HibernateTransactionalTemplate {
  
  @Autowired
  private SessionFactory sessionFactory;
  
  
  public void saveOrUpdate( Object object ){
     sessionFactory.getCurrentSession().saveOrUpdate(object);
  }
  
  public void delete( Object object ){
     sessionFactory.getCurrentSession().delete(object);
  }
  
}
