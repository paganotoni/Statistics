/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.hibernate;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    session.saveOrUpdate(o);
    session.flush();
    session.close();
  }
  

  public void save( Object o ){
    Session session = sessionFactory.openSession();
    session.save(o);
    session.flush();
    session.close();
  }

  public void update( Object object){
    Session session = sessionFactory.openSession();
    session.update(object);
    session.flush();
    session.close();
  }
  

 public void delete( Object o ){
    Session session = sessionFactory.openSession();
    session.delete(o);
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
