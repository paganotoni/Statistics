/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pagbel.statistics.reports;

import java.util.ArrayList;
import java.util.List;
import org.pagbel.statistics.game.Game;
import org.pagbel.statistics.hibernate.DatabaseOperator;
import org.pagbel.statistics.structure.Player;
import org.pagbel.statistics.structure.Team;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apagano
 */
public class BasicReportsService {

  @Autowired
  DatabaseOperator databaseOperator;

  public List gameReportData(Game game) {
    System.out.println(game);
    
    // Teams
    
    Team selfTeam = game.getSelfTeam();
    Team opponentTeam = game.getOpponentTeam();
    
    List players = databaseOperator.find( "from Player where team = ?", selfTeam ); 
    ArrayList data =  new ArrayList();
    
    for( Object p : players ){
      Player current =  (Player) p;
      
      
      
      ArrayList playerData =  new ArrayList();
      String number = current.getNumber();
      
      //TODO: Rotations Detail 
      
      //Points
      Long totalP = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and evaluation = '#' and ( fundamental = 'S' or fundamental = 'A' or fundamental = 'B')" , game, selfTeam , number ).get(0);
      Long totalBP = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and evaluation = '#' and ( fundamental = 'S' or fundamental = 'A' or fundamental = 'B') and service = false" , game, selfTeam , number ).get(0);
      Long totalE = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and evaluation = '=' " , game, selfTeam , number ).get(0); 
      Long totalWL = totalP - totalE;
      
      
      
      //Service
      Long totalS = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'S'" , game, selfTeam , number ).get(0);
      Long errorS = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'S' and evaluation = '=' ", game, selfTeam , number ).get(0);
      Long pointsS = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'S' and evaluation = '#' ", game, selfTeam , number ).get(0);
      
      //Reception
      Long totalR = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'R'" , game, selfTeam , number ).get(0);
      Long errorR = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'R' and evaluation = '=' ", game, selfTeam , number ).get(0);
      Long pstvR = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'R' and ( evaluation = '#' or evaluation = '+') ", game, selfTeam , number ).get(0);
      Long exeR = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'R' and evaluation = '#' ", game, selfTeam , number ).get(0);
       
      //Attack
      Long totalA = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'A'" , game, selfTeam , number ).get(0);
      Long errorA = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'R' and evaluation = '=' ", game, selfTeam , number ).get(0);
      Long ptsA = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'R' and evaluation = '#'", game, selfTeam , number ).get(0);

      Long ptsPct = totalA > 0 ? (Long) ( ptsA / totalA ) : 0;
      
      // Block
      Long ptsB = (Long) databaseOperator.find("select count(*) from GameAction where game = ? and actionTeam = ? and playerNumber = ? and fundamental = 'B' and evaluation = '#'", game, selfTeam , number ).get(0);
      
      playerData.add(current.getNumber());
      playerData.add(current.getName());
      
      playerData.add("");
      playerData.add("");
      playerData.add("");
      playerData.add("");
      playerData.add("");
      
      playerData.add(totalP);
      playerData.add(totalP);
      playerData.add(totalBP);
      playerData.add(totalE);
      playerData.add(totalWL);
      playerData.add( totalS);
      playerData.add(errorS);
      playerData.add(pointsS);
      playerData.add(totalR);
      playerData.add(errorR);
      playerData.add(pstvR);
      playerData.add(exeR);
      playerData.add(totalA);
      playerData.add(errorA);
      playerData.add(ptsA);
      playerData.add(ptsPct);
      playerData.add(ptsB);
      
      data.add( playerData );
    }

    return data;
    
  }
  
  
  
  public List findActionsQuery( Game game, Team team , String playerNumber , String fundamental , String evaluation, String optionalQuery ){
    
    String query =  optionalQuery != null ? optionalQuery : "from GameAction where game = ? and team = ?" ;
    List params = new ArrayList();
    params.add( game );
    params.add( team );
    
    if( playerNumber != null ){
      query += "and playerNumber = ?";
      params.add( playerNumber );
    }
    
    if( fundamental != null ){
      query += "and fundamental = ?";
      params.add( fundamental );
    }
    
    if( fundamental != null ){
      query += "and evaluation = ?";
      params.add( evaluation );
    }
    
    return databaseOperator.find(query, params.toArray() );
  }
  
}
