/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sci;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import parque.LerDatas;

/**
 *
 * @author Miguel
 */
public class GestaoRelatorios {



    public BaseDados _baseDados;

    public static String gerarRelatoriosDiarios(int relatorio, int dia, int mes, int ano, int niveis) throws SQLException {
        String rel = null;

        switch (relatorio) {
            case 1: 
                rel = relatorioDiariototalEntradasSaidas(dia,mes,ano);
                break;
            case 2:
                rel = relatorioDiarioOcupacaoPorNivel(niveis, dia,mes,ano);
                break;
            case 3:
                rel = relatorioDiarioTemposEstacionamento(niveis, dia,mes,ano);
                break;
            case 5:
                rel = relatorioDiarioDiferencaPagamentoBilheteSaidaParque(dia,mes,ano);
                break;
            case 7:
                rel = relatorioDiarioViaturasQueNaoEntraramNemSairam(dia,mes,ano);
                break;
        }
        
        return rel;
    }

    public static void apresentaRelatorio(String aRelatorio) {
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo que recebe um dia e calcula o numero total de entradas e saidas do parque
     * @param dia
     * @return String - relatorio completo já com paragrafos
     * @throws SQLException
     */
    public static String relatorioDiariototalEntradasSaidas(int dia, int mes, int ano) throws SQLException {

        String rel              = "";
        int entradasBilhetes    = 0;
        int saidasBilhetes      = 0;
        int entradasRegistados  = 0;
        int saidasRegistados    = 0;
        int saidasTotal         = 0;
        int entradasTotal       = 0;
        ResultSet rSet          = null;

        String sqlEntradasRegistados = "SELECT * FROM registos_registados WHERE TO_CHAR(data_hora_entrada, 'dd') = "+dia;
        sqlEntradasRegistados = sqlEntradasRegistados + " AND TO_CHAR(data_hora_entrada, 'mm') = "+mes;
        sqlEntradasRegistados = sqlEntradasRegistados + " AND TO_CHAR(data_hora_entrada, 'yyyy') = "+ano;
        System.out.println(sqlEntradasRegistados);
        rSet = Model.stmt.executeQuery(sqlEntradasRegistados);
        while(rSet.next()){
            entradasRegistados++;
        }

        String sqlEntradasBilhetes = "SELECT * FROM bilhetes WHERE TO_CHAR(data_hora_entrada, 'dd') ="+dia;
        sqlEntradasBilhetes = sqlEntradasBilhetes + " AND TO_CHAR(data_hora_entrada, 'mm') = "+mes;
        sqlEntradasBilhetes = sqlEntradasBilhetes + " AND TO_CHAR(data_hora_entrada, 'yyyy') = "+ano;
        System.out.println(sqlEntradasBilhetes);
        rSet = Model.stmt.executeQuery(sqlEntradasBilhetes);
        while(rSet.next()){
            entradasBilhetes++;
        }

        String sqlSaidasRegistados = "SELECT * FROM registos_registados WHERE TO_CHAR(data_hora_saida, 'dd') = "+dia;
        sqlSaidasRegistados = sqlSaidasRegistados + " AND TO_CHAR(data_hora_saida, 'mm') = "+mes;
        sqlSaidasRegistados = sqlSaidasRegistados + " AND TO_CHAR(data_hora_saida, 'yyyy') = "+ano;
        System.out.println(sqlSaidasRegistados);
        rSet = Model.stmt.executeQuery(sqlSaidasRegistados);
        while(rSet.next()){
            saidasRegistados++;
        }

        String sqlSaidasBilhetes = "SELECT * FROM bilhetes WHERE TO_CHAR(data_hora_saida, 'dd') = "+dia;
        sqlSaidasBilhetes = sqlSaidasBilhetes + " AND TO_CHAR(data_hora_saida, 'mm') = "+mes;
        sqlSaidasBilhetes = sqlSaidasBilhetes + " AND TO_CHAR(data_hora_saida, 'yyyy') = "+ano;
        System.out.println(sqlSaidasBilhetes);
        rSet = Model.stmt.executeQuery(sqlSaidasBilhetes);
        while(rSet.next()){
            saidasBilhetes++;
        }

        entradasTotal   = entradasBilhetes+entradasRegistados;
        saidasTotal     = saidasBilhetes+saidasRegistados;

        rel = rel + "RELATORIO DIARIO DO DIA "+dia+"-"+mes+"-"+ano+"\n";
        rel = rel + "*************************************************\n";
        rel = rel + "Total de entradas de clientes registados: "+entradasRegistados+"\n";
        rel = rel + "Total de entradas de clientes com bilhetes: "+entradasBilhetes+"\n";
        rel = rel + "Total de saidas de clientes redistados: "+saidasRegistados+"\n";
        rel = rel + "Total de saidas de clientes com bilhetes: "+saidasBilhetes+"\n";
        rel = rel + "*************************************************\n";
        rel = rel + "Total de entradas: "+entradasTotal+"\n";
        rel = rel + "Total de saidas: "+saidasTotal+"\n";

        return rel;
    }

    /**
     * Metodo que recebe o numero total de niveis e um dia, e calcula o relatorio de ocupaçao diario de todos os niveis
     * @param niveis
     * @param dia
     * @return
     * @throws SQLException
     */
    public static String relatorioDiarioOcupacaoPorNivel(int niveis, int dia, int mes, int ano) throws SQLException{
        String rel      = "";
        ResultSet rSet  = null;
        int totalNivel  = 0;

        int i = 1;
        rel = rel + "RELATORIO DIARIO DO DIA "+dia+"-"+mes+"-"+ano+" POR NIVEL\n";
        rel = rel + "*************************************************\n";

        while(i<=niveis){
            totalNivel = 0;
            String sql = "SELECT * FROM lugares, registos_lugares, pisos WHERE lugares.id_piso = "+i;
            sql = sql + " AND TO_CHAR(registos_lugares.data_hora_ocupado, 'dd') = "+dia;
            sql = sql + " AND TO_CHAR(registos_lugares.data_hora_ocupado, 'mm') = "+mes;
            sql = sql + " AND TO_CHAR(registos_lugares.data_hora_ocupado, 'yyyy') = "+ano;
            sql = sql + " AND pisos.id_piso = lugares.id_piso";
            sql = sql + " AND registos_lugares.id_lugar = lugares.id_lugar";

            System.out.println(sql);
            rSet = Model.stmt.executeQuery(sql);
            while(rSet.next()){
                totalNivel++;
            }
            rel = rel + "Total de clientes que estacionaram no nivel "+i+": "+totalNivel+"\n";
            i++;
        }
        rel = rel + "*************************************************\n";
        System.out.println(rel);
        return rel;
    }

    /**
     * Mostra os tempos medios, tempo maximo e tempo minimo de estacionamentos por piso
     * @param niveis
     * @param dia
     * @param mes
     * @param ano
     * @return relatorio
     * @throws SQLException
     */
    private static String relatorioDiarioTemposEstacionamento(int niveis, int dia, int mes, int ano) throws SQLException {
        String rel                      = "";
        ResultSet rSet                  = null;
        float tempoMax                  = 0;
        float tempoMin                  = 0;
        float tempoMedio                = 0;
        float tempoTotal                = 0;
        int numeroEstacionametos        = 0;
        String data_inicio              = "";
        String data_fim                 = "";
        GregorianCalendar dataInicio    = new GregorianCalendar();
        GregorianCalendar dataFim       = new GregorianCalendar();
        float diferenca                 = 0;

        int i = 1;
        rel = rel + "RELATORIO DIARIO DOS TEMPOS DE ESTACIONAETO DO DIA "+dia+"-"+mes+"-"+ano+" POR NIVEL\n";
        rel = rel + "****************************************************************************\n";

        while(i<=niveis){
            tempoTotal  = 0;
            tempoMax    = 0;
            tempoMin    = 10000;
            tempoMedio  = 0;
            numeroEstacionametos = 0;
            String sql = "SELECT to_char(data_hora_ocupado, 'yyyy-mm-dd hh24:mi:ss'), to_char(data_hora_livre, 'yyyy-mm-dd hh24:mi:ss')";
            sql = sql + " FROM registos_lugares, lugares ";
            sql = sql + " WHERE to_char(data_hora_ocupado, 'dd') = "+dia;
            sql = sql + " AND to_char(data_hora_ocupado, 'mm') = "+mes;
            sql = sql + " AND to_char(data_hora_ocupado, 'yyyy') = "+ano;
            sql = sql + " AND to_char(data_hora_livre, 'dd') > 0 ";
            sql = sql + " AND registos_lugares.id_lugar = lugares.id_lugar ";
            sql = sql + " AND lugares.id_piso = "+i;
            System.out.println(sql);

            rSet = Model.stmt.executeQuery(sql);
            
            while(rSet.next()){
                data_inicio = rSet.getString(1);
                data_fim = rSet.getString(2);

                dataInicio.set(LerDatas.getAno(data_inicio), LerDatas.getMes(data_inicio) , LerDatas.getDia(data_inicio), LerDatas.getHora(data_inicio), LerDatas.getMin(data_inicio), LerDatas.getSec(data_inicio));
                dataFim.set(LerDatas.getAno(data_fim), LerDatas.getMes(data_fim) , LerDatas.getDia(data_fim), LerDatas.getHora(data_fim), LerDatas.getMin(data_fim), LerDatas.getSec(data_fim));

                diferenca = LerDatas.diferencaEntreDatas(dataInicio, dataFim);
                tempoTotal = tempoTotal + diferenca;
                numeroEstacionametos++;
                if (diferenca>tempoMax) tempoMax = diferenca;
                if (diferenca<tempoMin && diferenca >0 ) tempoMin = diferenca;
                System.out.println("max "+tempoMax);
                System.out.println("min "+tempoMin);
                System.out.println("dif "+diferenca);
                
            }
            if(tempoMin==10000) tempoMin=0;
            if(numeroEstacionametos>0) tempoMedio = tempoTotal/numeroEstacionametos;
            System.out.println("med "+tempoMedio);
            rel = rel + "Piso "+i+"\n";
            rel = rel + "Tempo medio de estacionamento:  "+tempoMedio+"\n";
            rel = rel + "Tempo máximo de estacionamento: "+tempoMax+"\n";
            rel = rel + "Tempo minimo de estacionamento: "+tempoMin+"\n";
            rel = rel + "\n";
            i++;
        }
        return rel;
    }

    /**
     * Mostra o relatoria diario das diferencas de tempo entre o pagamento do bilhete e a saida do parque
     * @param dia
     * @param mes
     * @param ano
     * @return relatorio
     */
    private static String relatorioDiarioDiferencaPagamentoBilheteSaidaParque(int dia, int mes, int ano) throws SQLException {
        String rel = "";
        int numeroBilhetes              = 0;
        float diferenca                 = 0;
        float tempoMax                  = 0;
        float tempoMin                  = 10000;
        float tempoMedio                = 0;
        float tempoTotal                = 0;
        String data_pagamento           = "";
        String data_saida               = "";
        GregorianCalendar dataPagamento = new GregorianCalendar();
        GregorianCalendar dataSaida     = new GregorianCalendar();
        ResultSet rSet                  = null;
        
        String sql = "SELECT to_char(data_hora_pagamento, 'yyyy-mm-dd hh24:mi:ss'), to_char(data_hora_saida, 'yyyy-mm-dd hh24:mi:ss') FROM bilhetes";

        rSet = Model.stmt.executeQuery(sql);

        rel = rel + "RELATORIO DIARIO DOS TEMPOS ENTRE O PAGAMENTO E SADIDA DOS BILHETES\n";
        rel = rel + "DIA "+dia+"-"+mes+"-"+ano+" POR NIVEL\n";
        rel = rel + "*****************************************************************************************\n";

        while(rSet.next()){
           data_pagamento   = rSet.getString(1);
           data_saida       = rSet.getString(2);

           dataPagamento.set(LerDatas.getAno(data_pagamento), LerDatas.getMes(data_pagamento) , LerDatas.getDia(data_pagamento), LerDatas.getHora(data_pagamento), LerDatas.getMin(data_pagamento), LerDatas.getSec(data_pagamento));
           dataSaida.set(LerDatas.getAno(data_saida), LerDatas.getMes(data_saida) , LerDatas.getDia(data_saida), LerDatas.getHora(data_saida), LerDatas.getMin(data_saida), LerDatas.getSec(data_saida));

           diferenca = LerDatas.diferencaEntreDatas(dataPagamento, dataSaida);
           tempoTotal = tempoTotal + diferenca;
           numeroBilhetes++;

           if (diferenca>tempoMax) tempoMax = diferenca;
           if (diferenca<tempoMin && diferenca >0 ) tempoMin = diferenca;
           System.out.println("max "+tempoMax);
           System.out.println("min "+tempoMin);
           System.out.println("dif "+diferenca);
        }

        if(tempoMin==10000) tempoMin=0;
        if(numeroBilhetes>0) tempoMedio = tempoTotal/numeroBilhetes;
        System.out.println("med "+tempoMedio);

        rel = rel + "Tempo medio:  "+tempoMedio+"\n";
        rel = rel + "Tempo máximo: "+tempoMax+"\n";
        rel = rel + "Tempo minimo: "+tempoMin+"\n";
        rel = rel + "Numero de bilhetes: "+numeroBilhetes+"\n";

        rel = rel + "*****************************************************************************************\n";

        return rel;
    }

    
    private static String relatorioDiarioViaturasQueNaoEntraramNemSairam(int dia, int mes, int ano) throws SQLException {
        String rel          = "";
        int totalClientes   = 0;

        ResultSet rSet      = null;

        String sql = "SELECT * FROM clientes WHERE clientes.id_cliente NOT IN (";
        sql = sql + " SELECT registos_registados.id_cliente FROM registos_registados";
        sql = sql + " WHERE to_char(registos_registados.data_hora_entrada, 'dd') = "+dia;
        sql = sql + " AND to_char(registos_registados.data_hora_entrada, 'mm') = "+mes;
        sql = sql + " AND to_char(registos_registados.data_hora_entrada, 'yyyy') = "+ano;
        sql = sql + " GROUP BY registos_registados.id_cliente)";

        rel = rel + "RELATORIO DIARIO DOS CLIENTES QUE NAO ESTIVERAM NO PARQUE\n";
        rel = rel + "DIA "+dia+"-"+mes+"-"+ano+" POR NIVEL\n";
        rel = rel + "*****************************************************************************************\n";

        rSet = Model.stmt.executeQuery(sql);
        while(rSet.next()){
            rel = rel + rSet.getString(1) + " " + rSet.getString(2) +"\n";
            totalClientes++;
        }

        rel = rel + "*****************************************************************************************\n";
        rel = rel + "TOTAL DE CLIENTES: "+totalClientes;
        return rel;
    }


     public static String gerarRelatoriosMaqPagamento(int relatorio, String idMaq) throws SQLException {
        String rel = null;

        switch (relatorio) {
            case 1:
                rel = relatorioMaqPagamentoNumeroPagamanentoTipo(idMaq);
                break;
            case 2:
                rel = relatorioMaqPagamentoTotalRecebidoPorCadaPagamento(idMaq);
                break;
            case 3:
                rel = relatorioMaqPagamentoNumeroPercentagemRecibos(idMaq);
                break;
            case 4:
                rel = relatorioMaqPagamentoNumAvariasOperaçõesManutencao(idMaq);
                break;
        }

        return rel;
    }

     private static String relatorioMaqPagamentoNumeroPagamanentoTipo(String idMaq) throws SQLException {
        String rel              = "";
        String sql              = "SELECT * FROM pagamentos_maquinas WHERE id_maquina = '";
        int numDinheiro         = 0;
        int numMultibanco       = 0;
        int totalPagamentos     = 0;
        float montanteTotal     = 0;
        float montanteDinehiro  = 0;
        float montanteMultibanco= 0;


        rel = rel + "NUMERO PAGAMENTOS POR TIPO DA MÁQUINA "+idMaq+"\n";
        rel = rel + "***************************************************\n";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + idMaq + "'");

        while(rSet.next()){
            if (rSet.getString(4).equalsIgnoreCase("1")) {
                numDinheiro++;
                montanteDinehiro = montanteDinehiro + Float.parseFloat(rSet.getString(3));
            }
            
            if (rSet.getString(4).equalsIgnoreCase("3")) {
                numMultibanco++;
                montanteMultibanco = montanteMultibanco + Float.parseFloat(rSet.getString(3));
            }
            
            totalPagamentos++;
            montanteTotal = montanteTotal + Float.parseFloat(rSet.getString(3));
        }

        rel = rel + "TOTAL PAGAMENTOS EM DINHEIRO: "+numDinheiro+"\n";
        rel = rel + "TOTAL PAGAMENTOS POR MULTIBACO: "+numMultibanco+"\n";
        rel = rel + "TOTAL PAGAMENTOS: "+totalPagamentos+"\n";
        rel = rel + "***************************************************\n";
        /*
        rel = rel + "MONTANTE TOTAL RECEBIDO EM DINHEIRO: "+montanteDinehiro+"€\n";
        rel = rel + "MONTANTE TOTAL RECEBIDO POR MULTIBANCO: "+montanteMultibanco+"€\n";
        rel = rel + "MONTANTE TOTAL RECEBIDO: "+montanteTotal+"€\n";
        rel = rel + "***************************************************\n";
*/

     return rel;
   }

     private static String relatorioMaqPagamentoTotalRecebidoPorCadaPagamento(String idMaq) throws SQLException{
        String rel              = "";
        String sql              = "SELECT * FROM pagamentos_maquinas WHERE id_maquina = '";
        float montanteTotal     = 0;
        float montanteDinehiro  = 0;
        float montanteMultibanco= 0;
        float percentagemDinhe  = 0;
        float percentagemMulti  = 0;

        rel = rel + "NUMERO PAGAMENTOS POR TIPO DA MÁQUINA "+idMaq+"\n";
        rel = rel + "***************************************************\n";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + idMaq + "'");

        while(rSet.next()){
            if (rSet.getString(4).equalsIgnoreCase("1")) {
                montanteDinehiro = montanteDinehiro + Float.parseFloat(rSet.getString(3));
            }

            if (rSet.getString(4).equalsIgnoreCase("3")) {
                montanteMultibanco = montanteMultibanco + Float.parseFloat(rSet.getString(3));
            }

            montanteTotal = montanteTotal + Float.parseFloat(rSet.getString(3));
        }
        if (montanteTotal>0) percentagemDinhe = (montanteDinehiro/montanteTotal)*100;
        if (montanteTotal>0) percentagemMulti = (montanteMultibanco/montanteTotal)*100;

        rel = rel + "MONTANTE TOTAL RECEBIDO EM DINHEIRO: "+montanteDinehiro+"€ ("+percentagemDinhe+"%)\n";
        rel = rel + "MONTANTE TOTAL RECEBIDO POR MULTIBANCO: "+montanteDinehiro+"€ ("+percentagemMulti+"%)\n";
        rel = rel + "MONTANTE TOTAL RECEBIDO: "+montanteTotal+"€\n";
        rel = rel + "***************************************************\n";

        return rel;
     }


     public static String relatorioMaqPagamentoNumeroPercentagemRecibos (String idMaq) throws SQLException{
        String rel              = "";
        String sql              = "SELECT * FROM pagamentos_maquinas WHERE id_maquina = '";
        int numRecibos          = 0;
        int totalPagamentos     = 0;
        float percentagemRecibo = 0;

        rel = rel + "NUMERO/PERCENTAGEM RECIBOS EMITOS DA MÁQUINA "+idMaq+"\n";
        rel = rel + "******************************************************************\n";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + idMaq + "'");

        while(rSet.next()){
            if (rSet.getString(6).equalsIgnoreCase("1")) numRecibos ++;
            totalPagamentos ++;
        }
        if (totalPagamentos > 0) percentagemRecibo = numRecibos/totalPagamentos;
        
        rel = rel + "TOTAL DE RECIBOS: "+numRecibos+"\n";
        rel = rel + "PERCENTAGEM RECIBOS: "+percentagemRecibo+"\n";
        rel = rel + "TOTAL DE PAGAMENTOS: "+totalPagamentos+"\n";
        rel = rel + "******************************************************************\n";

        return rel;
     }


     public static String relatorioMaqPagamentoNumAvariasOperaçõesManutencao(String idMaq) throws SQLException {
        String rel             = "";
        String sql             = "SELECT * FROM registos_manutencao WHERE id_maquina = '";
        int numManutencoes     = 0;

        rel = rel + "NUMERO DE AVARIAS E OPERACOES DE MANUTENCAO DA MAQUINA "+idMaq+"\n";
        rel = rel + "******************************************************************\n";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + idMaq + "'");

        while (rSet.next()){
            numManutencoes++;
        }

        rel = rel + "TOTAL: "+numManutencoes+"\n";
        rel = rel + "******************************************************************\n";

        return rel;
     }


     public static String gerarRelatoriosCliente(int relatorio, String idCliente) throws SQLException {
        String rel = null;

        switch (relatorio) {
            case 1:
                rel = relatorioNumeroEntradas(idCliente);
                break;
            case 2:
                rel = relatorioTemposMediosEstacionamento(idCliente);
                break;
            case 3:
           //     rel = relatorioValorMensalPagar(idCliente);
                break;
        }

        return rel;
    }





    public static String relatorioNumeroEntradas(String idCliente) throws SQLException{

	String rel= "";
	int nEntradas = 0;
	ResultSet rSet;

	String sql = "SELECT * FROM registos_registados WHERE id_cliente='";
	rSet = Model.stmt.executeQuery(sql + idCliente + "'");


	while( rSet.next() ){
		nEntradas++;
	}

	rel = rel + "NUMERO ENTRADAS DO CLINTE "+idCliente+"\n";
        rel = rel + "***************************************************\n";
	rel = rel + " \n";
        rel = rel + "O cliente entrou no parque: " +nEntradas+ " vezes \n";
	rel = rel + " \n";
        rel = rel + "***************************************************\n";

        return rel;
    }
 private static String relatorioTemposMediosEstacionamento(String idCliente) throws SQLException {
       
	String rel                      = "";
        ResultSet rSet                  = null;
        float tempoMedio                = 0;
        float tempoTotal                = 0;
        int numeroEstacionametos        = 0;
        String data_inicio              = "";
        String data_fim                 = "";
        GregorianCalendar dataInicio    = new GregorianCalendar();
        GregorianCalendar dataFim       = new GregorianCalendar();
        float diferenca                 = 0;

        rel = rel + "RELATORIO DOS TEMPOS DE ESTACIONAMENTO DO CLIENTE " + idCliente + " \n";
        rel = rel + "****************************************************************************\n";

            tempoMedio  = 0;
            String sql = "SELECT to_char(data_hora_saida, 'yyyy-mm-dd hh24:mi:ss'), to_char(data_hora_entrada, 'yyyy-mm-dd hh24:mi:ss')";
            sql = sql + " FROM registos_registados";
            sql = sql + " WHERE id_cliente='";

            rSet = Model.stmt.executeQuery(sql+idCliente+"'");

            while(rSet.next()){
                data_inicio = rSet.getString(2);
                data_fim = rSet.getString(1);

                dataInicio.set(LerDatas.getAno(data_inicio), LerDatas.getMes(data_inicio) , LerDatas.getDia(data_inicio), LerDatas.getHora(data_inicio), LerDatas.getMin(data_inicio), LerDatas.getSec(data_inicio));
                dataFim.set(LerDatas.getAno(data_fim), LerDatas.getMes(data_fim) , LerDatas.getDia(data_fim), LerDatas.getHora(data_fim), LerDatas.getMin(data_fim), LerDatas.getSec(data_fim));

                diferenca = LerDatas.diferencaEntreDatas(dataInicio, dataFim);
                tempoTotal = tempoTotal + diferenca;
                numeroEstacionametos++;
            }
            
            if(numeroEstacionametos>0) tempoMedio = tempoTotal/numeroEstacionametos;


            rel = rel + "Tempo medio de estacionamento:  "+tempoMedio+"\n";
            rel = rel + "\n";
            return rel;
        }
        
    










}
