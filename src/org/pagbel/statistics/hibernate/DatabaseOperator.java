/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.hibernate;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A simple class to handle transaction proxy 
 * 
 * @author apagano
 */
public class DatabaseOperator {
  
  @Autowired
  SessionFactory sessionFactory;
  
  public void saveOrUpdate(Object o){
    Session session = sessionFactory.openSession();
    
    Transaction tx = session.beginTransaction();
    session.saveOrUpdate(o);
    tx.commit();
    
    session.flush();
    session.close();
  }
  

  public void save( Object o ){
    Session session = sessionFactory.openSession();
    
    Transaction tx = session.beginTransaction();
    session.save(o);
    tx.commit();
    
    session.flush();
    session.close();
  }

  public void update( Object object){
    Session session = sessionFactory.openSession();
    
    Transaction tx = session.beginTransaction();
    session.update(object);
    tx.commit();
    
    session.flush();
    session.close();
  }
  

 public void delete( Object o ){
    Session session = sessionFactory.openSession();
    
    Transaction tx = session.beginTransaction();
    session.delete(o);
    tx.commit();
    
    session.flush();
    session.close();
  }
  
  public List find( String queryHQL ){
    Session session = sessionFactory.openSession();
    Query query = session.createQuery(queryHQL);
    List result = query.list();
    session.close();
    return result;
  }
  
  public List find( String queryHQL , Object... params){
    Session session = sessionFactory.openSession();
    Query query = session.createQuery(queryHQL);
    params = params instanceof Object[] ? params : new Object[]{params};  
    for(int i = 0 ; i< params.length ; i++){
      query.setParameter(i, params[i]);
    }
    
    List result = query.list();
    session.close();
    return result;
  }
  
  
  
}
