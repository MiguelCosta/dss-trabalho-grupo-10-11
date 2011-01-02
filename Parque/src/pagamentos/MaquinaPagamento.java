/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos;

import acessos.Bilhete;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import sci.BaseDados;
import parque.LerDatas;
import parque.TabelaPreco;
import sci.Model;

/**
 *
 * @author Miguel
 */
public class MaquinaPagamento {

    private int _idMaquina;
    private ArrayList<Recibo> _recibo = new ArrayList<Recibo>();

    public void leBilhete() {
        return;
    }

    public static float calculaMulta(Bilhete aBilhete) throws SQLException {
       
        String idBilhete = ""+aBilhete.getIdBilhete()+"";
        ResultSet rSet = null;
        
        String sql = "SELECT * FROM BILHETES WHERE ID_BILHETE = '"+idBilhete+"'";

        rSet= Model.stmt.executeQuery(sql);
        String data1="";
        GregorianCalendar dataActual = new GregorianCalendar();
        while(rSet.next()){
            data1=rSet.getString(3);
        }
        
        GregorianCalendar data = new GregorianCalendar(LerDatas.getAno(data1), LerDatas.getMes(data1), LerDatas.getDia(data1), LerDatas.getHora(data1), LerDatas.getMin(data1), LerDatas.getSec(data1));


        float resultado = TabelaPreco.calculaPreco(data, dataActual);

        return resultado;

    }

    public static void mostra(float aValor) {
        throw new UnsupportedOperationException();
    }

    public static void recebePagamento(float aValor) {
        throw new UnsupportedOperationException();
    }

    public static void registaNovaHoraSaida() {
    
    }

    public static void devolveBilhete() {
        return;
    }

    public static void comunicaErro(String aErro) {
    }

    public static void devolveCartaoMagnetico() {
        return;
    }

    public static void pedeCodigoCartaoMagnetico() {
        return;
    }

    public static float verificaSaldoCartaoMagnetico() {
        float saldo=0;
        return saldo;
    }

    public static void efectuaTransaccaoMultibanco() {
        return;
    }

    public static void leDados(String aImput) {
    }

    public static void comunicaSucesso() {
    }

    public static  float calculaValorPagar(Bilhete aBilhete) {

        GregorianCalendar dataEntrada = new GregorianCalendar(LerDatas.getAno(aBilhete.getHoraEntrada()), LerDatas.getMes(aBilhete.getHoraEntrada()), LerDatas.getDia(aBilhete.getHoraEntrada()), LerDatas.getHora(aBilhete.getHoraEntrada()), LerDatas.getMin(aBilhete.getHoraEntrada()), LerDatas.getSec(aBilhete.getHoraEntrada()));
        GregorianCalendar dataSaida = new GregorianCalendar(LerDatas.getAno(aBilhete.getHoraSaida()), LerDatas.getMes(aBilhete.getHoraSaida()), LerDatas.getDia(aBilhete.getHoraSaida()), LerDatas.getHora(aBilhete.getHoraSaida()), LerDatas.getMin(aBilhete.getHoraSaida()), LerDatas.getSec(aBilhete.getHoraSaida()));

        float preco = TabelaPreco.calculaPreco(dataEntrada, dataSaida);
        return preco;
    }

    public static float leValor() {
        return 0;
    }

    public static  float calculaTroco(float aValorInserido, float aValorPagar) {
        float troco = aValorInserido-aValorPagar;
        return troco;
    }
}
