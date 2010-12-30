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

    public static ResultSet queryModosEntrada() throws SQLException{
        return Model.stmt.executeQuery("SELECT * FROM modos_entrada");
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
     * Procura um cliente pelo nome e devolve a linha
     * @param sel
     * @return
     * @throws SQLException
     */
    public static ResultSet procuraClientePorNome(String sel) throws SQLException{
        String sql = "SELECT * FROM clientes WHERE nome ='";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        return rSet;
    }

    /**
     * Procura o modo de entrada pelo ID e devolve a linha
     * @param sel
     * @return
     * @throws SQLException
     */
    public static ResultSet procuraModoEntradaPorID (String sel) throws SQLException{
        String sql = "SELECT * FROM modos_entrada WHERE id_entrada ='";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        return rSet;
    }

    /**
     * Procura o modo de entrada pelo Nome e devolve a linha
     * @param sel
     * @return
     * @throws SQLException
     */
    public static ResultSet procuraModoEntradaPorNome (String sel) throws SQLException {
        String sql = "SELECT * FROM modos_entrada WHERE modo_entrada ='";

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
