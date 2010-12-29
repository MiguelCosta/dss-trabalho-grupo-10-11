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

public String getAno(String data){
    String ano = data.substring(0, 3);
    return ano;
   }

public String getMes(String data){
    String mes = data.substring(5, 6);
    return mes;
   }

public String getDia(String data){
    String dia = data.substring(8, 9);
    return dia;
   }

public String getHora(String data){
    String hora = data.substring(11, 12);
    return hora;
   }

public String getMin(String data){
    String min = data.substring(14, 15);
    return min;
   }

public String getSec(String data){
    String sec = data.substring(17, 18);
    return sec;
   }


}
