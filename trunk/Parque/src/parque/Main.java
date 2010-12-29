/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parque;

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

        String ano = LerDatas.getAno(data);
        String mes = LerDatas.getMes(data);
        String dia = LerDatas.getDia(data);
        String hora = LerDatas.getHora(data);
        String min = LerDatas.getMin(data);
        String sec = LerDatas.getSec(data);
        
        System.out.println(ano);
        System.out.println(mes);
        System.out.println(dia);
        System.out.println(hora);
        System.out.println(min);
        System.out.println(sec);
    }
}
