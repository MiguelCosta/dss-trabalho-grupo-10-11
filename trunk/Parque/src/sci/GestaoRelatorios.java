/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sci;

import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class GestaoRelatorios {

    public BaseDados _baseDados;

    public String gerarRelatoriosDiarios(int relatorio, int dia) throws SQLException {
        String rel = null;

        switch (relatorio) {
            case 1: rel = Query.totalEntradasSaidas(dia);
        }
        
        return rel;
    }

    public void apresentaRelatorio(String aRelatorio) {
        throw new UnsupportedOperationException();
    }
}
