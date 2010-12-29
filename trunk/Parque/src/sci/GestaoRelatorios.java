/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sci;

import java.sql.ResultSet;
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
                rel = relatorioDiariototalEntradasSaidas(dia);
                break;
            case 2:
                rel = relatorioDiarioOcupacaoPorNivel(niveis, dia);
                break;
            case 3:
                rel = relatorioDiarioTemposEstacionamento(niveis, dia);
                break;
        }
        
        return rel;
    }

    public void apresentaRelatorio(String aRelatorio) {
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo que recebe um dia e calcula o numero total de entradas e saidas do parque
     * @param dia
     * @return String - relatorio completo já com paragrafos
     * @throws SQLException
     */
    public static String relatorioDiariototalEntradasSaidas(int dia) throws SQLException {

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

    /**
     * Metodo que recebe o numero total de niveis e um dia, e calcula o relatorio de ocupaçao diario de todos os niveis
     * @param niveis
     * @param dia
     * @return
     * @throws SQLException
     */
    public static String relatorioDiarioOcupacaoPorNivel(int niveis, int dia) throws SQLException{
        String rel      = "";
        ResultSet rSet  = null;
        int totalNivel  = 0;

        int i = 0;
        rel = rel + "RELATORIO DIARIO DO DIA "+dia+" POR NIVEL\n";
        rel = rel + "********************************************\n";

        while(i<niveis){
            totalNivel = 0;
            String sql = "SELECT * FROM lugares, registos_lugares WHERE lugares.id_lugar = "+i+" AND TO_CHAR(registos_lugares.data_hora_ocupado, 'dd') = "+dia+"\n";
            rSet = Model.stmt.executeQuery(sql);
            while(rSet.next()){
                totalNivel++;
            }
            rel = rel + "Total de clientes que estacionaram no nivel "+i+": "+totalNivel+"\n";
        }
        rel = rel + "********************************************\n";
        System.out.println(rel);
        return rel;
    }

    private String relatorioDiarioTemposEstacionamento(int niveis, int dia) throws SQLException {
        String rel                  = "";
        ResultSet rSet              = null;
        float tempoMax              = 0;
        float tempoMin              = 0;
        float tempoMedio            = 0;
        float tempoTotal            = 0;
        int numeroEstacionametos    = 0;

        int i = 0;
        rel = rel + "RELATORIO DIARIO DOS TEMPOS DE ESTACIONAETO DO DIA "+dia+" POR NIVEL\n";
        rel = rel + "************************************************************\n";

        while(i<niveis){
            tempoTotal = 0;
            numeroEstacionametos = 0;
            String sql = "SELECT to_char(data_hora_ocupado, 'yyyy-mm-dd hh24:mi:ss'), to_char(data_hora_livre, 'yyyy-mm-dd hh24:mi:ss')";
            sql = sql + "FROM registos_lugares, lugares ";
            sql = sql + "WHERE to_char(data_hora_ocupado, 'dd') = "+dia;
            sql = sql + "AND to_char(data_hora_livre, 'dd') > 0 ";
            sql = sql + "AND registos_lugares.id_lugar = lugares.id_lugar ";
            sql = sql + "AND lugares.id_piso = "+i;
            System.out.println(sql);

            rSet = Model.stmt.executeQuery(sql);
            
            

        }

        


        return rel;
    }

}
