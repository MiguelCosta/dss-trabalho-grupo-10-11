/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

/**
 *
 * @author Miguel
 */
public class Model extends Observable {

    public static Statement stmt;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection conn = DriverManager.getConnection(url, "GRUPO1", "grupo1");
        conn.setAutoCommit(false);
        stmt = conn.createStatement();
    }

    public static void disconnect() throws SQLException {
        stmt.close();
    }
}
