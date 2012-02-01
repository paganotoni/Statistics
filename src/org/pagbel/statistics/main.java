package org.pagbel.statistics;

import org.pagbel.statistics.configuration.ApplicationConfig;
import org.pagbel.statistics.ui.MainWindow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
