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
    String ano = data.substring(0, 4);
    return ano;
   }

public static String getMes(String data){
    String mes = data.substring(5, 7);
    return mes;
   }

public static String getDia(String data){
    String dia = data.substring(8, 10);
    return dia;
   }

public static String getHora(String data){
    String hora = data.substring(11, 13);
    return hora;
   }

public static String getMin(String data){
    String min = data.substring(14, 16);
    return min;
   }

public static String getSec(String data){
    String sec = data.substring(17, 19);
    return sec;
   }


}
