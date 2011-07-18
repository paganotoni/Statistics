/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.JComponent;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.ImageWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.openide.util.Utilities;

/**
 *
 * @author Jakolov
 */
public class PanelDirecciones {

    private Scene escena;
    private String[] labels = new String[]{"=", "/", "-", "¡", "+", "#"};
    private Color[] colores = new Color[]{Color.RED, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK};
    int[][] salidas = new int[][]{
        {109, 229},
        {214, 229},
        {214, 149},
        {214, 69},
        {109, 69},
        {109, 149},
        {214, 69},
        {109, 69},
        {109, 149}
    };
    int[][] destinos = new int[][]{
        {393, 69},
        {264, 69},
        {264, 149},
        {264, 229},
        {393, 229},
        {393, 149},
        {326, 229},
        {326, 149},
        {326, 69}
    };

    public JComponent getComponenteVistaDirecciones(LinkedList<String> zsalida, LinkedList<String> zdestino, LinkedList<String> valores) {
        java.awt.Font fuente = new java.awt.Font("", java.awt.Font.BOLD, 10);
        java.awt.Font flables = new java.awt.Font("", java.awt.Font.PLAIN, 9);
        if (this.escena == null) {
            setEscena(new Scene());
        } else {
            escena.removeChildren();
        }

        LayerWidget mainLayer = new LayerWidget(getEscena());
        getEscena().addChild(mainLayer);

        LayerWidget connectionLayer = new LayerWidget(getEscena());
        getEscena().addChild(connectionLayer);

        ImageWidget second = new ImageWidget(getEscena());
        second.setImage(Utilities.loadImage("Iconos/Direcciones.png"));
        second.setPreferredLocation(new Point(0, 0));
        mainLayer.addChild(second);
        int totPOS = 0;
        int totERR = 0;
        for (int i = 0; i < zsalida.size(); i++) {
            String sal = zsalida.get(i);
            String des = zdestino.get(i);
            String val = valores.get(i);
            try {
                int salida = Integer.parseInt(sal);
                int destino = Integer.parseInt(des);
                int valor = Integer.parseInt(val.substring(0, 1)) - 1;
                Color colorLinea = colores[valor];
                String texto = labels[valor];
                int ranX1 = (int) (Math.random() * 30);
                int ranY1 = (int) (Math.random() * 30);

                Point s = new Point(salidas[salida - 1][0], salidas[salida - 1][1]);
                Point d = new Point(destinos[destino - 1][0] + ranX1, destinos[destino - 1][1] + ranY1);

                LabelWidget ini = new LabelWidget(getEscena(), " ");
                ini.setPreferredLocation(s);
                mainLayer.addChild(ini);

                LabelWidget dest = new LabelWidget(getEscena(), texto);
                dest.setPreferredLocation(d);
                dest.setFont(flables);
                dest.setForeground(colorLinea);
                mainLayer.addChild(dest);

                ConnectionWidget connection = new ConnectionWidget(getEscena());
                connection.setSourceAnchor(AnchorFactory.createCircularAnchor(ini, 2));
                connection.setTargetAnchor(AnchorFactory.createCircularAnchor(dest, 12));
                connection.setTargetAnchorShape(AnchorShape.NONE);
                connection.setLineColor(colorLinea);
                connection.setStroke(new BasicStroke(1.0f));
                connectionLayer.addChild(connection);

                if (valor == 0) {
                    totERR++;
                }
                if (valor == 5) {
                    totPOS++;
                }

            } catch (Exception e) {
                System.out.println("error agregando linea de direccion");
            }

        }
        if (zsalida.size() > 0) {
            LabelWidget total = new LabelWidget(getEscena(), "Total: " + zsalida.size());
            total.setPreferredLocation(new Point(50, 270));
            total.setFont(fuente);
            mainLayer.addChild(total);

            LabelWidget totalEFFC = new LabelWidget(getEscena(), "EFFC: " + ((float)totPOS / zsalida.size()) * 100 + "%");
            totalEFFC.setPreferredLocation(new Point(50, 285));
            totalEFFC.setFont(fuente);
            totalEFFC.setForeground(Color.WHITE);
            mainLayer.addChild(totalEFFC);

            LabelWidget totalERROR = new LabelWidget(getEscena(), "ERR: " + ((float) totERR / zsalida.size()) * 100 + "%");
            totalERROR.setPreferredLocation(new Point(50, 300));
            totalERROR.setFont(fuente);
            totalERROR.setForeground(Color.WHITE);
            mainLayer.addChild(totalERROR);
        }

        //linea de conexion

        this.getEscena().validate();
        return this.getEscena().createView();
    }

    /**
     * @return the escena
     */
    public Scene getEscena() {
        return escena;
    }

    /**
     * @param escena the escena to set
     */
    public void setEscena(Scene escena) {
        this.escena = escena;
    }
}
