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

    public String gerarRelatoriosDiarios(int relatorio, int dia, int niveis) throws SQLException {
        String rel = null;

        switch (relatorio) {
            case 1: 
                rel = Query.relatorioDiariototalEntradasSaidas(dia);
                break;
            case 2:
                rel = Query.relatorioDiarioOcupacaoPorNivel(niveis, dia);
                break;
        }
        
        return rel;
    }

    public void apresentaRelatorio(String aRelatorio) {
        throw new UnsupportedOperationException();
    }
}
