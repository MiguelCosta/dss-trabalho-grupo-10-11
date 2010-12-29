/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sci;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Aqui serve para colocar os metodos para charmar as query
 * @author Miguel
 */
public class Query extends Model {

    /**
     * Lista todos os clientes
     * @return ResultSet
     * @throws SQLException
     */
    public static ResultSet queryClientes () throws SQLException{
        return Model.stmt.executeQuery("SELECT * FROM clientes");
    }


    /**
     * Procura um cliente pelo ID e devolve a linha
     * @param idCliente
     * @return
     * @throws SQLException
     */
    public static ResultSet procuraClientePorID(String sel) throws SQLException{
        String sql = "SELECT * FROM clientes WHERE id_cliente ='";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        return rSet;
    }

    /**
     * Função que recebe um dia e calcula o numero total de entradas e saidas do parque
     * @param dia
     * @return String - relatorio completo já com paragrafos
     * @throws SQLException
     */
    public static String totalEntradasSaidas(int dia) throws SQLException {
        
        String rel              = "";
        int entradasBilhetes    = 0;
        int saidasBilhetes      = 0;
        int entradasRegistados  = 0;
        int saidasRegistados    = 0;
        int saidasTotal         = 0;
        int entradasTotal       = 0;
        ResultSet rSet          = null;

        String sqlEntradasRegistados = "SELECT * FROM registos_registados WHERE TO_CHAR(data_hora_entrada, 'dd') = "+dia;
        rSet = Model.stmt.executeQuery(sqlEntradasRegistados);
        while(rSet.next()){
            entradasRegistados++;
        }

        String sqlEntradasBilhetes = "SELECT * FROM bilhetes WHERE TO_CHAR(data_hora_entrada, 'dd') ="+dia;
        rSet = Model.stmt.executeQuery(sqlEntradasBilhetes);
        while(rSet.next()){
            entradasBilhetes++;
        }

        String sqlSaidasRegistados = "SELECT * FROM registos_registados WHERE TO_CHAR(data_hora_saida, 'dd') = "+dia;
        rSet = Model.stmt.executeQuery(sqlSaidasRegistados);
        while(rSet.next()){
            saidasRegistados++;
        }

        String sqlSaidasBilhetes = "SELECT * FROM bilhetes WHERE TO_CHAR(data_hora_saida, 'dd') = "+dia;
        rSet = Model.stmt.executeQuery(sqlSaidasBilhetes);
        while(rSet.next()){
            saidasBilhetes++;
        }

        entradasTotal   = entradasBilhetes+entradasRegistados;
        saidasTotal     = saidasBilhetes+saidasRegistados;

        rel = rel + "RELATORIO DIARIO DO DIA "+dia+"\n";
        rel = rel + "*************************************************";
        rel = rel + "Total de entradas de clientes registados:   "+entradasRegistados+"\n";
        rel = rel + "Total de entradas de clientes com bilhetes: "+entradasBilhetes+"\n";
        rel = rel + "Total de saidas de clientes redistados:     "+saidasRegistados+"\n";
        rel = rel + "Total de saidas de clientes com bilhetes:   "+saidasBilhetes+"\n";
        rel = rel + "*************************************************";
        rel = rel + "Total de entradas:                          "+entradasTotal+"\n";
        rel = rel + "Total de saidas:                            "+saidasTotal+"\n";

        return rel;
    }

}
