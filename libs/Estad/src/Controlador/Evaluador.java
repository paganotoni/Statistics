/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Accion;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Jakolov
 */
public class Evaluador {

    private static String NUMEROS;         //Validos como Numeros
    private static String FUNDAMENTOS;     //Validos como Fundamentos
    private static String VALORES;    //Validos como Valores
    private static String TIPOS;           //Validos como Tipos
    private static String ZONAS;           //Validos como Zonas
    private static String ORDEN;           //Orden de los Gestos
    private static String prefijos;        //Prefijos
    private static String paresEvaluaciones[] = {"#=", "+-", "!/", "=#", "-+", "!/"};

    public Evaluador() {
        prefijos = "*a";
        NUMEROS = "1234567890$";
        FUNDAMENTOS = "SRABDE";
        VALORES = "#+!/-=";
        TIPOS = "HMQTUNO";
        ZONAS = "123456789";
        ORDEN = "SREABD";
    }

    public Evaluador(String pre, String num, String fun, String val, String tip, String zon) {
        prefijos = pre;
        NUMEROS = num;
        FUNDAMENTOS = fun;
        VALORES = val;
        TIPOS = tip;
        ZONAS = zon;
        ORDEN = "SREABD";
    }

    public Accion[] procesar(String s) {
        Accion[] acciones = new Accion[0];
        if (esCompuesto(s)) {
            if (!s.contains("*") && !s.contains("a")) {
                s = "*" + s;
            }
            String[] dividida = divideCompuesto(s, ".");
            String[] patrones = getPatrones(dividida);
            String[][] result = completar(dividida, patrones);
            acciones = new Accion[2];
            acciones[0] = new Accion();
            acciones[0].setCodigo(result[0][0]);
            acciones[0].setPatron(result[0][1]);
            acciones[1] = new Accion();
            acciones[1].setCodigo(result[1][0]);
            acciones[1].setPatron(result[1][1]);
        } else {
            String patron = getPatron(s);
            String[] result = completarSimple(s,patron);
            s = result[0];
            patron = result[1];
            acciones = new Accion[1];
            acciones[0] = new Accion();
            acciones[0].setCodigo(s);
            acciones[0].setPatron(patron);
        }
        return acciones;
    }

    public String[] divideCompuesto(String s, String caracter) {
        StringTokenizer stk = new StringTokenizer(s, ".");

        int max = stk.countTokens();
        String result[] = new String[max];
        for (int i = 0; i < max; i++) {
            result[i] = "";
            result[i] += stk.nextToken();
        }
        return result;
    }

    public String getPatron(String s) {

        String patron = "";
        int contNumeros = 0;
        int contFundamentos = 0;
        int contEvaluaciones = 0;
        int contTipos = 0;
        int contZonaSalida = 0;
        int contZonaDestino = 0;
        int contPrefijos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (es(prefijos, String.valueOf(s.charAt(i))) && contPrefijos == 0) {
                patron += "P";
                contPrefijos++;
            } else if (es(NUMEROS, String.valueOf(s.charAt(i))) && !patron.contains("F") && contNumeros < 2) {
                patron += "N";
                contNumeros++;
            } else if (es(FUNDAMENTOS, String.valueOf(s.charAt(i))) && contFundamentos == 0) {
                patron += "F";
                contFundamentos++;
            } else if (es(VALORES, String.valueOf(s.charAt(i))) && contEvaluaciones == 0) {
                patron += "E";
                contEvaluaciones++;
            } else if (es(TIPOS, String.valueOf(s.charAt(i))) && contTipos == 0) {
                patron += "T";
                contTipos++;
            } else if (es(ZONAS, String.valueOf(s.charAt(i))) && contZonaSalida == 0) {
                patron += "S";
                contZonaSalida++;
            } else if (es(ZONAS, String.valueOf(s.charAt(i))) && contZonaDestino == 0) {
                patron += "D";
                contZonaDestino++;
            } else {
                patron += "XX";
            }
        }
        return patron;
    }

    public String[] completarSimple(String s, String p) {
        String[] result = new String[2];

        if (!p.contains("N")) {
            s = "$$" + s;
            p = "NN" + p;
        }

        if (!s.startsWith("a") && !s.startsWith("*")) {
            s = "*" + s;
            p = "P" + p;
        }

        result[0] = s;
        result[1] = p;
        return result;
    }

    public String[][] completar(String[] s, String[] patrones) {
        String fCompletado = "";
        String eCompletada = "";
        int indFACompletar = 0;
        int indEACompletar = 0;
        String[][] result = new String[2][2];

        if (!patrones[0].startsWith("P") && patrones[1].startsWith("P")) {
            if (s[1].startsWith("a")) {
                s[0] = "*" + s[0];
                patrones[0] = "P" + patrones[0];
            } else {
                s[0] = "a" + s[0];
                patrones[0] = "P" + patrones[0];
            }
        } else if (!patrones[1].startsWith("P") && patrones[0].startsWith("P")) {
            if (s[0].startsWith("a")) {
                s[1] = "*" + s[1];
                patrones[1] = "P" + patrones[1];
            } else {
                s[1] = "a" + s[1];
                patrones[1] = "P" + patrones[1];
            }
        }



        if (!patrones[0].contains("N")) {
            s[0] = s[0].substring(0, 1) + "$$" + s[0].substring(1, s[0].length());
            patrones[0] = patrones[0].substring(0, 1) + "NN" + patrones[0].substring(1, patrones[0].length());
        }

        if (!patrones[1].contains("N")) {
            s[1] = s[1].substring(0, 1) + "$$" + s[1].substring(1, s[1].length());
            patrones[1] = patrones[1].substring(0, 1) + "NN" + patrones[1].substring(1, patrones[1].length());
        }

        if (patrones[0].contains("F") && !patrones[1].contains("F")) {
            String fundamento = String.valueOf(s[0].charAt(patrones[0].indexOf("F")));
            fCompletado = getSiguienteFundamento(fundamento);
            indFACompletar = 1;
            String[] completado = insertarFundamento(s[1], patrones[1], fCompletado);
            s[1] = completado[0];
            patrones[1] = completado[1];
        } else if (patrones[1].contains("F") && !patrones[0].contains("F")) {
            String fundamento = String.valueOf(s[1].charAt(patrones[1].indexOf("F")));
            fCompletado = getAnteriorFundamento(fundamento);
            indFACompletar = 0;
            String[] completado = insertarFundamento(s[0], patrones[0], fCompletado);
            s[0] = completado[0];
            patrones[0] = completado[1];
        }

        if (patrones[0].contains("E") && !patrones[1].contains("E")) {
            String evaluacion = String.valueOf(s[0].charAt(patrones[0].indexOf("E")));
            eCompletada = getSiguienteEvaluacion(evaluacion);
            indEACompletar = 1;
            String[] completado = insertarEvaluacion(s[1], patrones[1], eCompletada);
            s[1] = completado[0];
            patrones[1] = completado[1];
        } else if (patrones[1].contains("E") && !patrones[0].contains("E")) {
            String evaluacion = String.valueOf(s[1].charAt(patrones[1].indexOf("E")));
            eCompletada = getAnteriorEvaluacion(evaluacion);
            indEACompletar = 0;
            String[] completado = insertarEvaluacion(s[0], patrones[0], eCompletada);
            s[0] = completado[0];
            patrones[0] = completado[1];
        }
        result[0][0] = s[0];
        result[0][1] = patrones[0];
        result[1][0] = s[1];
        result[1][1] = patrones[1];

        return result;
    }

    public String[] getPatrones(String[] s) {
        String[] result = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = getPatron(s[i]);
        //System.out.println(getPatron(s[i]));
        }
        return result;
    }

    public boolean esCompuesto(String s) {
        return s.contains(".");
    }

    public boolean es(String patron, String s) {
        return patron.contains(s);
    }

    public String getAnteriorFundamento(String f) {
        String result = "";
        int indF = ORDEN.indexOf(f);
        if (indF == 0) {
            result = String.valueOf(ORDEN.charAt(ORDEN.length() - 1));
        } else {
            result = String.valueOf(ORDEN.charAt(indF - 1));
        }
        return result;
    }

    public String getSiguienteFundamento(String f) {
        String result = "";
        int indF = ORDEN.indexOf(f);
        if (indF == ORDEN.length() - 1) {
            result = String.valueOf(ORDEN.charAt(0));
        } else {
            result = String.valueOf(ORDEN.charAt(indF + 1));
        }
        return result;
    }

    public String getSiguienteEvaluacion(String e) {
        String result = "";
        for (int i = 0; i < paresEvaluaciones.length; i++) {
            if (String.valueOf(paresEvaluaciones[i].charAt(0)).equalsIgnoreCase(e)) {
                result = String.valueOf(paresEvaluaciones[i].charAt(1));
                i = paresEvaluaciones.length;
            }
        }
        return result;
    }

    public String getAnteriorEvaluacion(String e) {
        String result = "";
        for (int i = 0; i < paresEvaluaciones.length; i++) {
            if (String.valueOf(paresEvaluaciones[i].charAt(1)).equalsIgnoreCase(e)) {
                result = String.valueOf(paresEvaluaciones[i].charAt(0));
                i = paresEvaluaciones.length;
            }
        }
        return result;
    }

    public String[] insertarFundamento(String s, String p, String completado) {
        String[] result = new String[2];
        int ind = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(p.charAt(i)).equalsIgnoreCase("E")) {
                ind = i;
            }
        }
        result[0] = s.substring(0, ind) + completado + s.substring(ind, s.length());
        result[1] = p.substring(0, ind) + "F" + p.substring(ind, p.length());
        return result;
    }

    public String[] insertarEvaluacion(String s, String p, String completado) {
        String[] result = new String[2];
        int ind = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(p.charAt(i)).equalsIgnoreCase("T")) {
                ind = i;
            }
        }
        result[0] = s.substring(0, ind) + completado + s.substring(ind, s.length());
        result[1] = p.substring(0, ind) + "E" + p.substring(ind, p.length());
        return result;
    }

    public String[] insertarNumeros(String s, String p) {
        String[] result = new String[2];
        int ind = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(p.charAt(i)).equalsIgnoreCase("T")) {
                ind = i;
            }
        }
        return result;
    }

    public String[] insertarTipo(String s, String p, String completado) {
        String[] result = new String[2];
        int ind = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(p.charAt(i)).equalsIgnoreCase("S")) {
                ind = i;
            }
        }
        result[0] = s.substring(0, ind) + completado + s.substring(ind, s.length());
        result[1] = p.substring(0, ind) + "T" + p.substring(ind, p.length());
        return result;
    }
}
