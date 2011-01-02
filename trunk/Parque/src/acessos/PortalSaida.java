/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acessos;

import java.sql.ResultSet;
import java.sql.SQLException;
import sci.BaseDados;
import sci.Model;

/**
 *
 * @author Miguel
 */
public class PortalSaida {

    public BaseDados _baseDados;
    public Barreira _barreiraSaida;
    public Monitor _monitor;

    public Bilhete leBilhete() {
        throw new UnsupportedOperationException();
    }

    public boolean verificaValidadeBilhete(Bilhete aBilhete) throws SQLException {
        
        // Rever por causa das datas

        ResultSet rSet = null;
        int idBilhete = aBilhete.getIdBilhete();
        String data = aBilhete.getHoraEntrada();
        String dataHoraPagamento="", modoPagmanto = "";
        Boolean valido = false;

        String sql = "SELECT * WHERE ID_BILHETE = '"+idBilhete+"'";
        sql = sql +" AND DATA_HORA_ENTRADA = '"+data+"'";
        rSet=Model.stmt.executeQuery(sql);

        while(rSet.next()){
           dataHoraPagamento = rSet.getString(3);
           modoPagmanto= rSet.getString(5);
        }

        if (!dataHoraPagamento.equals("") && !modoPagmanto.equals("")){
            valido = true;
        }
        return valido;
    }

    public void devolveBilhete() {
        throw new UnsupportedOperationException();
    }

    public boolean verificaPagamentoBilhete(Bilhete aBilhete) {
        throw new UnsupportedOperationException();
    }

    public int verificaFormaSaida() {
        throw new UnsupportedOperationException();
    }

    public boolean existeDispositivo(int aCodDisp) {
        throw new UnsupportedOperationException();
    }

    public int leNumClienteAvenca() {
        throw new UnsupportedOperationException();
    }

    public void verificaValidadeAvenca(int aNCliente) {
        throw new UnsupportedOperationException();
    }

    public String escreveSaidaCartaoAvenca() {
        throw new UnsupportedOperationException();
    }

    public void devolveCartaoAvenca() {
        throw new UnsupportedOperationException();
    }
}
