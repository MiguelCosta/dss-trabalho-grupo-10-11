/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

import java.util.GregorianCalendar;

/**
 *
 * @author Miguel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String data = "2010-01-14 09:14:10";
        String data2 = "2010-01-14 09:15:10";


        int ano = LerDatas.getAno(data);
        int mes = LerDatas.getMes(data);
        int dia = LerDatas.getDia(data);
        int hora = LerDatas.getHora(data);
        int min = LerDatas.getMin(data);
        int sec = LerDatas.getSec(data);
        
        System.out.println(""+ano);
        System.out.println(""+mes);
        System.out.println(""+dia);
        System.out.println(""+hora);
        System.out.println(""+min);
        System.out.println(""+sec);
        GregorianCalendar dataG1 = new GregorianCalendar(ano, mes, dia, hora, min, sec);

        int ano2 = LerDatas.getAno(data2);
        int mes2 = LerDatas.getMes(data2);
        int dia2 = LerDatas.getDia(data2);
        int hora2 = LerDatas.getHora(data2);
        int min2 = LerDatas.getMin(data2);
        int sec2 = LerDatas.getSec(data2);
        
        System.out.println(""+ano2);
        System.out.println(""+mes2);
        System.out.println(""+dia2);
        System.out.println(""+hora2);
        System.out.println(""+min2);
        System.out.println(""+sec2);
        GregorianCalendar dataG2 = new GregorianCalendar(ano2, mes2, dia2, hora2, min2, sec2);

        long re = LerDatas.diferencaEntreDatas(dataG1, dataG2);
        System.out.println("diferenca: "+re);

        
    }
}
