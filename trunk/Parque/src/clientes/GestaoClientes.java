/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.sql.SQLException;
import pagamentos.Pagamento;

/**
 *
 * @author Miguel
 */
public class GestaoClientes {

    public FichaCliente _fichaCliente;
    public Pagamento _unnamed_Pagamento_;

    public boolean verificaPagEmAtraso() throws SQLException {
        boolean existe = false;
        String resultado = sci.Query.pagamentoEmAtraso(_fichaCliente.getIdCliente());
        if (resultado.equalsIgnoreCase("") == false || resultado.equalsIgnoreCase(null)==false) existe =  true;
        return existe;
    }

    public String comunicaErro(String aErro) {
        return aErro;
    }

    public String apresentaListaPagEmAtraso() throws SQLException {
        String resultado = sci.Query.pagamentoEmAtraso(_fichaCliente.getIdCliente());
        return resultado;
    }

    public void pedeIdentificacaoDoCliente() {
        throw new UnsupportedOperationException();
    }

    public String leDados() {
        throw new UnsupportedOperationException();
    }

    public void mostraFicha(int aIdCliente) {
        _fichaCliente.toString();
    }

    public boolean validaDados(String aDadosNovos) {
        if (_fichaCliente.getIdCliente().equalsIgnoreCase(null)) return false ;
        if (_fichaCliente.getCodigoEntrada().equalsIgnoreCase(null)) return false;
        if (_fichaCliente.getMatricula().equalsIgnoreCase(null)) return false;
        if (_fichaCliente.getNib().equalsIgnoreCase(null)) return false;
        if (_fichaCliente.getNomeCliente().equalsIgnoreCase(null)) return false;
        return true;
    }

    public void actualizaDadosCliente(String aDadosNovos) {
        
    }

    public void confirmaSucessoOperacao() {
        throw new UnsupportedOperationException();
    }

    public void registaCliente(String aDadosV, String aFPagamento) {
        throw new UnsupportedOperationException();
    }

    public void emiteCartaoAvenca() {
        throw new UnsupportedOperationException();
    }

    public void removerCliente(int aIdCliente) {
        throw new UnsupportedOperationException();
    }

    public float calculaMultaPerda() {
        throw new UnsupportedOperationException();
    }

    public void emiteRecibo() {
        throw new UnsupportedOperationException();
    }
}
