/*
 * Principal.java
 *
 * Created on 6 de agosto de 2007, 10:08 PM
 */
package Vista;

import Controlador.OperacionesBasicas;
import Controlador.Coneccion;
import Vista.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.OfficeSilver2007Skin;
import org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel;


/**
 *
 * @author  Jakolov
 */
public class FormPrincipal extends javax.swing.JFrame {

    private static Coneccion con;
    private static int width;
    private static int heigth;
    private static OperacionesBasicas operacionesBasicas;
    private static FormComentarios FormComentarios;

    /**
     * @return the FormAnalisisZonas
     */
    public static Vista.FormAnalisisZona getFormAnalisisZonas() {
        return FormAnalisisZonas;
    }

    /**
     * @param aFormAnalisisZonas the FormAnalisisZonas to set
     */
    public static void setFormAnalisisZonas(Vista.FormAnalisisZona aFormAnalisisZonas) {
        FormAnalisisZonas = aFormAnalisisZonas;
    }

    /**
     * @return the menAnalisis
     */
    public static javax.swing.JMenu getMenAnalisis() {
        return menAnalisis;
    }

    /**
     * @param aMenAnalisis the menAnalisis to set
     */
    public static void setMenAnalisis(javax.swing.JMenu aMenAnalisis) {
        menAnalisis = aMenAnalisis;
    }

    /**
     * @return the FormAnalisisDireccion
     */
    public static Vista.FormAnalisisDireccion getFormAnalisisDireccion() {
        return FormAnalisisDireccion;
    }

    /**
     * @param aFormAnalisisDireccion the FormAnalisisDireccion to set
     */
    public static void setFormAnalisisDireccion(Vista.FormAnalisisDireccion aFormAnalisisDireccion) {
        FormAnalisisDireccion = aFormAnalisisDireccion;
    }

    /** Creates new form Principal */
    public FormPrincipal() {
        setLookAndFeel();
        con = new Coneccion();
        initComponents();
        this.setLocationRelativeTo(null);
        this.width = this.getBounds().width;
        heigth = this.getBounds().height;
        operacionesBasicas = new OperacionesBasicas();
        ocultaInternals();
        FormComentarios = new FormComentarios(this);

    }

    public void Mostrar() {
        try {
            Connection s = con.getCon();
            String catalogo = s.getCatalog();
            setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Otra instancia del programa esta corriendo, cierrelo "
                    + "\npara poder abrir una nueva ");
            setVisible(false);
            // e.printStackTrace();
            System.exit(0);
        }
    }

    private void setLookAndFeel() {

        try {
          //SubstanceLookAndFeel.setSkin( new SubstanceOfficeBlue2007LookAndFeel() );
            SubstanceLookAndFeel.setSkin(new OfficeSilver2007Skin());
            // javax.swing.UIManager.setLookAndFeel("org.fife.plaf.Office2003.Office2003LookAndFeel");
            //javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel");
            //UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel");
            //javax.swing.UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
        } catch (Exception ex) {
            //javax.swing.JOptionPane.showMessageDialog(this, "Error en la carga del looknfeel!!!");
            ex.printStackTrace();
        }


    }

    private void ocultaInternals() {
        //getFormComentarios().setVisible(false);
        //getFormDatosJuego().setVisible(false);
    }

    /** regresa el ancho de la ventana Principal*/
    public static int getWith() {
        return width;
    }

    public static int getHeigth() {
        return heigth;
    }

    public static FormListaJugadores getFormListaJugadores() {
        return FormListaJugadores;
    }

    public static void setFormListaJugadores(FormListaJugadores FormListaJugadores) {
        FormPrincipal.FormListaJugadores = FormListaJugadores;
    }

    public static FormEdicionJuego getFormEdicionJuego() {
        return FormEdicionJuego;
    }

    public static FormNuevaTemporada getFormNuevaTemporada() {
        return FormNuevaTemporada;
    }

    public FormTemporadas getFormTemporadas() {
        return FormTemporadas;
    }

    public static Coneccion getCon() {
        return con;
    }

    public static OperacionesBasicas getOperacionesBasicas() {
        return operacionesBasicas;
    }

    public static FormNuevoTorneo getFormNuevoTorneo() {
        return FormNuevoTorneo;
    }

    public static FormNuevoEquipo getFormNuevoEquipo() {
        return FormNuevoEquipo;
    }

    public static FormDetallesEquipo getFormDetallesEquipo() {
        return FormDetallesEquipo;
    }

    public static FormEdicionJugador getFormEdicionJugador() {
        return FormEdicionJugador;
    }

    public static FormEdicionTipo getFormNuevoTipo() {
        return FormNuevoTipo;
    }

    public static FormEdicionGesto getFormEdicionGesto() {
        return FormEdicionGesto;
    }

    public static FormEdicionAceleradores getFormEdicionAceleradores() {
        return FormEdicionAceleradores;
    }

    public static FormComentarios getFormComentarios() {
        return FormComentarios;
    }

    public static FormControladorDeJuego getFormControladorDeJuego() {
        return FormControladorDeJuego;
    }

    public static FormListaAcciones getFormListaAcciones() {
        return FormListaAcciones;
    }

    /**
     * @return the FormJuego
     */
    public static Vista.FormJuego getFormJuego() {
        return FormJuego;
    }

    /**
     * @param aFormJuego the FormJuego to set
     */
    public static void setFormJuego(Vista.FormJuego aFormJuego) {
        FormJuego = aFormJuego;
    }

    /**
     * @return the FormRotacion
     */
    public static Vista.formRotacion getFormRotacion() {
        return FormRotacion;
    }

    /**
     * @param aFormRotacion the FormRotacion to set
     */
    public static void setFormRotacion(Vista.formRotacion aFormRotacion) {
        FormRotacion = aFormRotacion;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        deskMDI = new javax.swing.JDesktopPane();
        FormComando = new Vista.FormComando();
        FormTemporadas = new Vista.FormTemporadas();
        FormNuevaTemporada = new Vista.FormNuevaTemporada();
        FormTorneos = new Vista.FormTorneos();
        FormNuevoTorneo = new Vista.FormNuevoTorneo();
        FormEquipos = new Vista.FormEquipos();
        FormDetallesEquipo = new Vista.FormDetallesEquipo();
        FormEdicionJugador = new Vista.FormEdicionJugador();
        FormGestos = new Vista.FormGestos();
        FormTipos = new Vista.FormTipos();
        FormNuevoTipo = new Vista.FormEdicionTipo();
        FormNuevoEquipo = new Vista.FormNuevoEquipo();
        FormEdicionGesto = new Vista.FormEdicionGesto();
        FormEdicionAceleradores = new Vista.FormEdicionAceleradores();
        FormAceleradores = new Vista.FormAceleradores();
        tbaMenuIconos = new javax.swing.JToolBar();
        tbaElementos = new javax.swing.JToolBar();
        comEquipos = new javax.swing.JButton();
        comTorneos = new javax.swing.JButton();
        comTemporadas = new javax.swing.JButton();
        comJuegos = new javax.swing.JButton();
        tbaFundamentales = new javax.swing.JToolBar();
        comTipos = new javax.swing.JButton();
        comGestos = new javax.swing.JButton();
        comAceleradores = new javax.swing.JButton();
        comTablas = new javax.swing.JButton();
        tbaNuevos = new javax.swing.JToolBar();
        comNuevoJuego = new javax.swing.JButton();
        FormEdicionJuego = new Vista.FormEdicionJuego();
        FormJuegos = new Vista.FormJuegos();
        FormListaJugadores = new Vista.FormListaJugadores();
        FormControladorDeJuego = new Vista.FormControladorDeJuego();
        FormListaAcciones = new Vista.FormListaAcciones();
        FormTablas = new Vista.FormTablaValoracion();
        FormJuego = new Vista.FormJuego();
        FormRotacion = new Vista.formRotacion();
        FormAnalisisZonas = new Vista.FormAnalisisZona();
        FormAnalisisDireccion = new Vista.FormAnalisisDireccion();
        jMenuBar2 = new javax.swing.JMenuBar();
        menArchivo = new javax.swing.JMenu();
        mitBloquear = new javax.swing.JMenuItem();
        sepArchivo = new javax.swing.JSeparator();
        mitSalir = new javax.swing.JMenuItem();
        menEdicion = new javax.swing.JMenu();
        mitTemporada = new javax.swing.JMenuItem();
        mitTorneos = new javax.swing.JMenuItem();
        mitJuegos = new javax.swing.JMenuItem();
        mitEquipos = new javax.swing.JMenuItem();
        menAnalisis = new javax.swing.JMenu();
        mitAnalisisSimple = new javax.swing.JMenuItem();
        mitAnalisisZona = new javax.swing.JMenuItem();
        mitAnalisisDireccion = new javax.swing.JMenuItem();
        sepAnalisis = new javax.swing.JSeparator();
        mitReporteJuego = new javax.swing.JMenuItem();
        mitReporteNcaa = new javax.swing.JMenuItem();
        menUtilidades = new javax.swing.JMenu();
        mitComandosSQL = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("Menu"); // NOI18N
        jMenuBar1.add(jMenu1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estadisticas"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        FormComando.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        FormComando.setBounds(200, 160, 535, 324);
        deskMDI.add(FormComando, javax.swing.JLayeredPane.DEFAULT_LAYER);

        FormTemporadas.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        FormTemporadas.setBounds(270, 160, 534, 371);
        deskMDI.add(FormTemporadas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormNuevaTemporada.setBounds(310, 210, 353, 198);
        deskMDI.add(FormNuevaTemporada, javax.swing.JLayeredPane.POPUP_LAYER);

        FormTorneos.setVisible(false);
        FormTorneos.setBounds(240, 130, 565, 351);
        deskMDI.add(FormTorneos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormNuevoTorneo.setBounds(330, 220, 393, 185);
        deskMDI.add(FormNuevoTorneo, javax.swing.JLayeredPane.POPUP_LAYER);
        FormEquipos.setBounds(260, 100, 579, 379);
        deskMDI.add(FormEquipos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormDetallesEquipo.setBounds(220, 160, 636, 376);
        deskMDI.add(FormDetallesEquipo, javax.swing.JLayeredPane.MODAL_LAYER);
        FormEdicionJugador.setBounds(380, 170, 365, 217);
        deskMDI.add(FormEdicionJugador, javax.swing.JLayeredPane.POPUP_LAYER);
        FormGestos.setBounds(280, 150, 449, 314);
        deskMDI.add(FormGestos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormTipos.setBounds(370, 170, 319, 258);
        deskMDI.add(FormTipos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormNuevoTipo.setBounds(410, 230, 252, 160);
        deskMDI.add(FormNuevoTipo, javax.swing.JLayeredPane.POPUP_LAYER);
        FormNuevoEquipo.setBounds(380, 200, 260, 170);
        deskMDI.add(FormNuevoEquipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormEdicionGesto.setBounds(310, 170, 321, 206);
        deskMDI.add(FormEdicionGesto, javax.swing.JLayeredPane.POPUP_LAYER);

        FormEdicionAceleradores.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        FormEdicionAceleradores.setBounds(340, 180, 291, 185);
        deskMDI.add(FormEdicionAceleradores, javax.swing.JLayeredPane.POPUP_LAYER);
        FormAceleradores.setBounds(280, 120, 508, 341);
        deskMDI.add(FormAceleradores, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tbaMenuIconos.setFloatable(false);

        tbaElementos.setRollover(true);

        comEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Eq.png"))); // NOI18N
        comEquipos.setToolTipText("Equipos"); // NOI18N
        comEquipos.setFocusable(false);
        comEquipos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comEquipos.setIconTextGap(0);
        comEquipos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        comEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comEquiposActionPerformed(evt);
            }
        });
        tbaElementos.add(comEquipos);

        comTorneos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/to.png"))); // NOI18N
        comTorneos.setToolTipText("Torneos"); // NOI18N
        comTorneos.setFocusable(false);
        comTorneos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comTorneos.setIconTextGap(0);
        comTorneos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        comTorneos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comTorneosActionPerformed(evt);
            }
        });
        tbaElementos.add(comTorneos);

        comTemporadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/tmp.png"))); // NOI18N
        comTemporadas.setToolTipText("Temporadas"); // NOI18N
        comTemporadas.setFocusable(false);
        comTemporadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comTemporadas.setIconTextGap(0);
        comTemporadas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        comTemporadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comTemporadasActionPerformed(evt);
            }
        });
        tbaElementos.add(comTemporadas);

        comJuegos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Juegos.png"))); // NOI18N
        comJuegos.setToolTipText("Juegos"); // NOI18N
        comJuegos.setFocusable(false);
        comJuegos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comJuegos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        comJuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comJuegosActionPerformed(evt);
            }
        });
        tbaElementos.add(comJuegos);

        tbaMenuIconos.add(tbaElementos);

        tbaFundamentales.setRollover(true);

        comTipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Tipo.png"))); // NOI18N
        comTipos.setToolTipText("Tipos"); // NOI18N
        comTipos.setFocusable(false);
        comTipos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comTipos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        comTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comTiposActionPerformed(evt);
            }
        });
        tbaFundamentales.add(comTipos);

        comGestos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Gestos.png"))); // NOI18N
        comGestos.setToolTipText("Gestos"); // NOI18N
        comGestos.setFocusable(false);
        comGestos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comGestos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        comGestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comGestosActionPerformed(evt);
            }
        });
        tbaFundamentales.add(comGestos);

        comAceleradores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Aceleradores.png"))); // NOI18N
        comAceleradores.setToolTipText("Aceleradores"); // NOI18N
        comAceleradores.setFocusable(false);
        comAceleradores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comAceleradores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        comAceleradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comAceleradoresActionPerformed(evt);
            }
        });
        tbaFundamentales.add(comAceleradores);

        comTablas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ta.png"))); // NOI18N
        comTablas.setToolTipText("Tablas"); // NOI18N
        comTablas.setFocusable(false);
        comTablas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comTablas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        comTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comTablasActionPerformed(evt);
            }
        });
        tbaFundamentales.add(comTablas);

        tbaMenuIconos.add(tbaFundamentales);

        tbaNuevos.setRollover(true);

        comNuevoJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/NuevoJuego.png"))); // NOI18N
        comNuevoJuego.setToolTipText("Nuevo Juego"); // NOI18N
        comNuevoJuego.setFocusable(false);
        comNuevoJuego.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        comNuevoJuego.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        comNuevoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comNuevoJuegoActionPerformed(evt);
            }
        });
        tbaNuevos.add(comNuevoJuego);

        tbaMenuIconos.add(tbaNuevos);

        tbaMenuIconos.setBounds(0, 0, 990, 40);
        deskMDI.add(tbaMenuIconos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormEdicionJuego.setBounds(140, 110, 676, 363);
        deskMDI.add(FormEdicionJuego, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormJuegos.setBounds(200, 70, 649, 392);
        deskMDI.add(FormJuegos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormListaJugadores.setBounds(20, 60, 488, 341);
        deskMDI.add(FormListaJugadores, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormControladorDeJuego.setBounds(10, 420, 422, 70);
        deskMDI.add(FormControladorDeJuego, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormListaAcciones.setBounds(740, 50, 240, 370);
        deskMDI.add(FormListaAcciones, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormTablas.setBounds(280, 110, 343, 345);
        deskMDI.add(FormTablas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormJuego.setBounds(10, 50, 370, 360);
        deskMDI.add(FormJuego, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormRotacion.setBounds(330, 160, 277, 182);
        deskMDI.add(FormRotacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        FormAnalisisZonas.setResizable(false);
        FormAnalisisZonas.setBounds(360, 70, 383, 414);
        deskMDI.add(FormAnalisisZonas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        FormAnalisisDireccion.setBounds(310, 50, 502, 430);
        deskMDI.add(FormAnalisisDireccion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        menArchivo.setText("Archivo"); // NOI18N

        mitBloquear.setText("Bloquear Sesion"); // NOI18N
        menArchivo.add(mitBloquear);
        menArchivo.add(sepArchivo);

        mitSalir.setText("Salir"); // NOI18N
        mitSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSalirActionPerformed(evt);
            }
        });
        menArchivo.add(mitSalir);

        jMenuBar2.add(menArchivo);

        menEdicion.setText("Edicion"); // NOI18N
        menEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menEdicionActionPerformed(evt);
            }
        });

        mitTemporada.setText("Temporadas"); // NOI18N
        mitTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitTemporadaActionPerformed(evt);
            }
        });
        menEdicion.add(mitTemporada);

        mitTorneos.setText("Torneos"); // NOI18N
        mitTorneos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitTorneosActionPerformed(evt);
            }
        });
        menEdicion.add(mitTorneos);

        mitJuegos.setText("Juegos"); // NOI18N
        mitJuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitJuegosActionPerformed(evt);
            }
        });
        menEdicion.add(mitJuegos);

        mitEquipos.setText("Equipos"); // NOI18N
        mitEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitEquiposActionPerformed(evt);
            }
        });
        menEdicion.add(mitEquipos);

        jMenuBar2.add(menEdicion);

        menAnalisis.setText("Analisis"); // NOI18N
        menAnalisis.setEnabled(false);

        mitAnalisisSimple.setText("Analisis Simple"); // NOI18N
        mitAnalisisSimple.setEnabled(false);
        menAnalisis.add(mitAnalisisSimple);

        mitAnalisisZona.setText("Analisis de Zona"); // NOI18N
        mitAnalisisZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAnalisisZonaActionPerformed(evt);
            }
        });
        menAnalisis.add(mitAnalisisZona);

        mitAnalisisDireccion.setText("Analisis de Direccion"); // NOI18N
        mitAnalisisDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAnalisisDireccionActionPerformed(evt);
            }
        });
        menAnalisis.add(mitAnalisisDireccion);
        menAnalisis.add(sepAnalisis);

        mitReporteJuego.setText("Reporte de Juego"); // NOI18N
        mitReporteJuego.setEnabled(false);
        menAnalisis.add(mitReporteJuego);

        mitReporteNcaa.setText("Reporte NCAA"); // NOI18N
        mitReporteNcaa.setEnabled(false);
        menAnalisis.add(mitReporteNcaa);

        jMenuBar2.add(menAnalisis);

        menUtilidades.setText("Utilidades"); // NOI18N

        mitComandosSQL.setText("Comandos SQL"); // NOI18N
        mitComandosSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitComandosSQLActionPerformed(evt);
            }
        });
        menUtilidades.add(mitComandosSQL);

        jMenuItem1.setText("Analisis de Multiples Juegos");
        jMenuItem1.setEnabled(false);
        menUtilidades.add(jMenuItem1);

        jMenuBar2.add(menUtilidades);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskMDI, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEquiposActionPerformed
        // TODO add your handling code here:
        FormEquipos.setVisible(true);
}//GEN-LAST:event_mitEquiposActionPerformed

private void mitJuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitJuegosActionPerformed
    // TODO add your handling code here:
    FormJuegos.setVisible(true);
}//GEN-LAST:event_mitJuegosActionPerformed

private void menEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menEdicionActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_menEdicionActionPerformed

    private void mitTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitTorneosActionPerformed
        // TODO add your handling code here:
        FormTorneos.setVisible(true);
}//GEN-LAST:event_mitTorneosActionPerformed

    private void mitTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitTemporadaActionPerformed
        // TODO add your handling code here:
        FormTemporadas.setVisible(true);
}//GEN-LAST:event_mitTemporadaActionPerformed

    private void mitComandosSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitComandosSQLActionPerformed
        // TODO add your handling code here:
        FormComando.setVisible(true);
}//GEN-LAST:event_mitComandosSQLActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
    }//GEN-LAST:event_formWindowStateChanged

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
// TODO: Agrege su codigo aqui:
        tbaMenuIconos.setSize(this.getBounds().width, 35);
        deskMDI.setSize(this.getBounds().width, deskMDI.getHeight());
    }//GEN-LAST:event_formComponentResized

    private void mitSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSalirActionPerformed
// TODO: Agrege su codigo aqui:
        int sel = javax.swing.JOptionPane.showConfirmDialog(null, "Esta Seguro de Salir del Programa ?", "Salir", javax.swing.JOptionPane.OK_CANCEL_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (sel == javax.swing.JOptionPane.OK_OPTION) {
            try {
                this.con.getCon().close();
            } catch (Exception e) {
            }
            operacionesBasicas.salir();
        }


}//GEN-LAST:event_mitSalirActionPerformed

    private void comTorneosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comTorneosActionPerformed
        // TODO add your handling code here:
        FormTorneos.setVisible(true);
}//GEN-LAST:event_comTorneosActionPerformed

    private void comEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comEquiposActionPerformed
        // TODO add your handling code here:
        FormEquipos.setVisible(true);
    }//GEN-LAST:event_comEquiposActionPerformed

    private void comTemporadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comTemporadasActionPerformed
        // TODO add your handling code here:
        FormTemporadas.setVisible(true);
}//GEN-LAST:event_comTemporadasActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void comGestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comGestosActionPerformed
        // TODO add your handling code here:
        FormGestos.setVisible(true);
    }//GEN-LAST:event_comGestosActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    private void comTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comTiposActionPerformed
        // TODO add your handling code here:
        FormTipos.setVisible(true);

    }//GEN-LAST:event_comTiposActionPerformed

    private void comAceleradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comAceleradoresActionPerformed
        // TODO add your handling code here:
        FormAceleradores.setVisible(true);
    }//GEN-LAST:event_comAceleradoresActionPerformed

    private void comTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comTablasActionPerformed
        // TODO add your handling code here:
        FormTablas.setVisible(true);
    }//GEN-LAST:event_comTablasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            this.con.getCon().close();
            System.gc();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowClosing

    private void comNuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comNuevoJuegoActionPerformed
        // TODO add your handling code here:
        FormEdicionJuego.setVisible(true);
}//GEN-LAST:event_comNuevoJuegoActionPerformed

    private void comJuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comJuegosActionPerformed
        // TODO add your handling code here:
        FormJuegos.setVisible(true);
    }//GEN-LAST:event_comJuegosActionPerformed

    private void mitAnalisisZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAnalisisZonaActionPerformed
        // TODO add your handling code here:
        this.getFormAnalisisZonas().setVisible(true);
    }//GEN-LAST:event_mitAnalisisZonaActionPerformed

    private void mitAnalisisDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAnalisisDireccionActionPerformed
        // TODO add your handling code here:
        this.getFormAnalisisDireccion().setVisible(true);
    }//GEN-LAST:event_mitAnalisisDireccionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FormPrincipal fp = new FormPrincipal();
                fp.setDefaultLookAndFeelDecorated(true);
                fp.Mostrar();

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.FormAceleradores FormAceleradores;
    private static Vista.FormAnalisisDireccion FormAnalisisDireccion;
    private static Vista.FormAnalisisZona FormAnalisisZonas;
    private Vista.FormComando FormComando;
    private static Vista.FormControladorDeJuego FormControladorDeJuego;
    private static Vista.FormDetallesEquipo FormDetallesEquipo;
    private static Vista.FormEdicionAceleradores FormEdicionAceleradores;
    private static Vista.FormEdicionGesto FormEdicionGesto;
    private static Vista.FormEdicionJuego FormEdicionJuego;
    private static Vista.FormEdicionJugador FormEdicionJugador;
    private Vista.FormEquipos FormEquipos;
    private Vista.FormGestos FormGestos;
    private static Vista.FormJuego FormJuego;
    private Vista.FormJuegos FormJuegos;
    private static Vista.FormListaAcciones FormListaAcciones;
    private static Vista.FormListaJugadores FormListaJugadores;
    private static Vista.FormNuevaTemporada FormNuevaTemporada;
    private static Vista.FormNuevoEquipo FormNuevoEquipo;
    private static Vista.FormEdicionTipo FormNuevoTipo;
    private static Vista.FormNuevoTorneo FormNuevoTorneo;
    private static Vista.formRotacion FormRotacion;
    private Vista.FormTablaValoracion FormTablas;
    private Vista.FormTemporadas FormTemporadas;
    private static Vista.FormTipos FormTipos;
    private Vista.FormTorneos FormTorneos;
    private javax.swing.JButton comAceleradores;
    private javax.swing.JButton comEquipos;
    private javax.swing.JButton comGestos;
    private javax.swing.JButton comJuegos;
    private javax.swing.JButton comNuevoJuego;
    private javax.swing.JButton comTablas;
    private javax.swing.JButton comTemporadas;
    private javax.swing.JButton comTipos;
    private javax.swing.JButton comTorneos;
    private static javax.swing.JDesktopPane deskMDI;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private static javax.swing.JMenu menAnalisis;
    private javax.swing.JMenu menArchivo;
    private javax.swing.JMenu menEdicion;
    private javax.swing.JMenu menUtilidades;
    private javax.swing.JMenuItem mitAnalisisDireccion;
    private javax.swing.JMenuItem mitAnalisisSimple;
    private javax.swing.JMenuItem mitAnalisisZona;
    private javax.swing.JMenuItem mitBloquear;
    private javax.swing.JMenuItem mitComandosSQL;
    private javax.swing.JMenuItem mitEquipos;
    private javax.swing.JMenuItem mitJuegos;
    private javax.swing.JMenuItem mitReporteJuego;
    private javax.swing.JMenuItem mitReporteNcaa;
    private javax.swing.JMenuItem mitSalir;
    private javax.swing.JMenuItem mitTemporada;
    private javax.swing.JMenuItem mitTorneos;
    private javax.swing.JSeparator sepAnalisis;
    private javax.swing.JSeparator sepArchivo;
    private javax.swing.JToolBar tbaElementos;
    private javax.swing.JToolBar tbaFundamentales;
    private javax.swing.JToolBar tbaMenuIconos;
    private javax.swing.JToolBar tbaNuevos;
    // End of variables declaration//GEN-END:variables
}
