/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDados;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class Query extends Model {

    public static ResultSet queryClientes () throws SQLException{
        return Model.stmt.executeQuery("SELECT id_cliente FROM clientes");
    }

}
