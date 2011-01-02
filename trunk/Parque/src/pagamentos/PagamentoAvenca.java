/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos;

import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class PagamentoAvenca extends Pagamento {

    public static void registarPagamento(String id_cliente, String data, String modo,String montante) throws SQLException, Exception {
        sci.Query.adicionarPagamento(id_cliente, data, modo, montante);
    }

}
