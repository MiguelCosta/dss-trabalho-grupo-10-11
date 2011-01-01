/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pagamentos;

import java.util.GregorianCalendar;
import parque.LerDatas;

/**
 *
 * @author Hugo
 */
public class TabelaPreco {

    private static float precoBase;

     public void tabelaPreco(){
        precoBase= (float) 0.10; /* Preço Base Por cada 10 min*/
     }


     public float getPrecoBase(){
        return precoBase;
     }

     public void setPrecoBase(float pB){
        precoBase=pB;
     }

    public static float calculaPreco(GregorianCalendar daTa1, GregorianCalendar daTa2) {
	float resultado = LerDatas.diferencaEntreDatas(daTa1,daTa2);
	float preco;
	
	preco =(resultado/10) * precoBase;

	return preco;
    }
}
