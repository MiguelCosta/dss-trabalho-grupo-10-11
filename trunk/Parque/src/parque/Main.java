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
    }
}
