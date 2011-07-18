package org.pagbel.statistics;

import java.util.ArrayList;
import java.util.Scanner;
import org.h2.tools.Server;

import org.pagbel.statistics.action.GameAction;
import org.pagbel.statistics.engine.ActionGenerator;
import org.pagbel.statistics.engine.ActionValidator;
import org.pagbel.statistics.engine.ActionProcessor;
import org.pagbel.statistics.engine.GameHolder;
import org.pagbel.statistics.game.Game;
import org.pagbel.statistics.game.Game.GameResult;
import org.pagbel.statistics.game.GameConfiguration;
import org.pagbel.statistics.game.Partial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import org.pagbel.statistics.configuration.ApplicationConfig;
import org.pagbel.statistics.ui.game.DefineRotations;
import org.pagbel.statistics.ui.MainWindow;

/**
 *
 * @author apagano
 */
public class main {

  public static void main(String... args) {
    ApplicationContext context = new AnnotationConfigApplicationContext( ApplicationConfig.class );
    MainWindow mainWindow = context.getBean(MainWindow.class);
    mainWindow.setVisible( true );
  }
}
