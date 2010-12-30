/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

import java.util.GregorianCalendar;

/**
 *
 * @author Hugo
 */
public class LerDatas {

    public static int getAno(String data) {
        String ano = data.substring(0, 4);
        return Integer.parseInt(ano);
    }

    public static int getMes(String data) {
        String mes = data.substring(5, 7);
        return Integer.parseInt(mes);
    }

    public static int getDia(String data) {
        String dia = data.substring(8, 10);
        return Integer.parseInt(dia);
    }

    public static int getHora(String data) {
        String hora = data.substring(11, 13);
        return Integer.parseInt(hora);
    }

    public static int getMin(String data) {
        String min = data.substring(14, 16);
        return Integer.parseInt(min);
    }

    public static int getSec(String data) {
        String sec = data.substring(17, 19);
        return Integer.parseInt(sec);
    }

    public static long diferencaEntreDatas(GregorianCalendar daTa1, GregorianCalendar daTa2) {

        long dt1 = daTa1.getTimeInMillis();
        long dt2 = daTa2.getTimeInMillis();
        long resultado = (long) ((dt2 - dt1) * 0.001);
        return resultado;
    }
}
