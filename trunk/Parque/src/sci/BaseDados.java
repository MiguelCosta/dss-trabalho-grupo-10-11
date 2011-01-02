/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sci;

import acessos.Bilhete;
import java.sql.SQLException;
import pagamentos.MaquinaPagamento;
import sci.Query;

/**
 *
 * @author Miguel
 */
public class BaseDados {

   

    public static void registaBilhete(int aId, String dataEntrada) throws SQLException {
       Model.stmt.executeQuery("INSERT INTO BILHETES VALUES '"+aId+"','"+dataEntrada+"','','',''");
    }

    public static void registoEntradaAuto(int aCodDisp) {
        
    }

     public static void registoEntradaAvenca(int aNCliente) {
    
    }
    public static void registarPagamento(String id_cliente, String data, String modo,String montante) throws SQLException, Exception {
        Query.adicionarPagamento(id_cliente, data, modo, montante);
    }

    public static void registarManutencao(String id_Maquina, String desc,String hora_manutencao, String tempo_Manutencao,String id_funcionario) throws SQLException, Exception{
       Query.adicionarManutencao(id_Maquina, desc, hora_manutencao, tempo_Manutencao, id_funcionario);
    }

    public void existeCliente(int aIdCliente) {
        throw new UnsupportedOperationException();
    }

    public void registarPagamentoDeMulta(String aIdCliente, Object aValor_float) {
        throw new UnsupportedOperationException();
    }

    public String recolhePesq(String aDados) {
        throw new UnsupportedOperationException();
    }

    public void tabOcupacoes(int aNivel, String aHora) {
        throw new UnsupportedOperationException();
    }

    public void registaSaidaBilhete(Bilhete aBilhete) {
        throw new UnsupportedOperationException();
    }

    public void registaSaidaAutomatico(int aCodDisp) {
        throw new UnsupportedOperationException();
    }

    public void registaSaidaAvenca(int aNCliente) {
        throw new UnsupportedOperationException();
    }
}
