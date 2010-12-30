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

    public static ResultSet queryPisos () throws SQLException{
        return Model.stmt.executeQuery("SELECT * FROM pisos");
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
    public static ResultSet procuraClientePorNome(String sel) throws SQLException{
        String sql = "SELECT * FROM clientes WHERE nome ='";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        return rSet;
    }

    public static int totalPisos() throws SQLException{
        String sql = "SELECT * FROM pisos";
        int numPisos = 0;

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql);
        while(rSet.next()){
            numPisos++;
        }
        System.out.println("Total de Pisos: "+numPisos);
        return numPisos;
    }

    

    

}
