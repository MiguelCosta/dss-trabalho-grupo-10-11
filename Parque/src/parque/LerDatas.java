/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parque;

/**
 *
 * @author Hugo
 */
public class LerDatas {

public static String getAno(String data){
    String ano = data.substring(0, 3);
    return ano;
   }

public static String getMes(String data){
    String mes = data.substring(5, 6);
    return mes;
   }

public static String getDia(String data){
    String dia = data.substring(8, 9);
    return dia;
   }

public static String getHora(String data){
    String hora = data.substring(11, 12);
    return hora;
   }

public static String getMin(String data){
    String min = data.substring(14, 15);
    return min;
   }

public static String getSec(String data){
    String sec = data.substring(17, 18);
    return sec;
   }


}
