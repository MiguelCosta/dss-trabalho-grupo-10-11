/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sci;

import acessos.Bilhete;
import acessos.PortalEntrada;
import acessos.PortalSaida;
import clientes.GestaoClientes;
import java.sql.SQLException;
import pagamentos.MaquinaPagamento;

/**
 *
 * @author Miguel
 */
public class BaseDados {

    public PortalEntrada _unnamed_PortalEntrada_;
    public PortalSaida _unnamed_PortalSaida_;
    public GestaoRelatorios _unnamed_GestaoRelatorios_;
    public GestaoClientes _unnamed_GestaoClientes_;
    


    public void registaBilhete(int aId, String dataEntrada) throws SQLException {
       Model.stmt.executeQuery("INSERT INTO BILHETES VALUES '"+aId+"','"+dataEntrada+"','','',''");
    }

    public void registoEntradaAuto(int aCodDisp) {
        throw new UnsupportedOperationException();
    }

    public void registoEntradaBilhete(int aId) {
        throw new UnsupportedOperationException();
    }

    public void registoEntradaAvenca(int aNCliente) {
        throw new UnsupportedOperationException();
    }
    public MaquinaPagamento _unnamed_MaquinaPagamento_;

    public void registarPagamento(Bilhete aBilhete) {
        throw new UnsupportedOperationException();
    }

    public void registarManutencao(MaquinaPagamento aMaquina) {
        throw new UnsupportedOperationException();
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
