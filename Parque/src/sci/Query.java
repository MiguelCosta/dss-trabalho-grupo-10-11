/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sci;

import com.sun.org.apache.xpath.internal.operations.Mod;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import parque.LerDatas;

/**
 * Aqui serve para colocar os metodos para charmar as query
 * @author Miguel
 */
public class Query extends Model {


    /*********************************
     * Fazer commit da Base de Dados *
     *********************************/
    public static void commit2() throws Exception {
        Model.stmt.executeQuery("commit");
    }
    
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
     * Procura o modo de entrada pelo ID e devolve o nome
     * @param sel
     * @return
     * @throws SQLException
     */
    public static String procuraModoEntradaPorID (String sel) throws SQLException{
        String sql = "SELECT * FROM modos_entrada WHERE id_entrada ='";
        String r   = "";
        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + sel + "'");
        while(rSet.next()){
            r = rSet.getString(2);
        }

        return r;
    }

    /**
     * Procura o modo de entrada pelo Nome e devolve o ID
     * @param sel
     * @return
     * @throws SQLException
     */
    public static String procuraModoEntradaPorNome (String sel) throws SQLException {
        String sql = "SELECT * FROM modos_entrada WHERE modo_entrada ='";
        String r   = "";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql + sel + "'");

        while(rSet.next()){
            r = rSet.getString(1);
        }
        return r;
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

    public static void adicionarCliente (String id_cliente, String nome_cliente, String modo_pagamento, String matricula, String nib) throws SQLException, Exception{

        String sql = "INSERT INTO clientes  VALUES ('"+id_cliente+"','"+nome_cliente+"','"+modo_pagamento+"','"+matricula+"','"+nib+"')";

        System.out.println(sql);

        Model.stmt.executeQuery(sql);
        commit2();
    }

    public static void alterarNomeCliente(String idCliente, String newNome) throws SQLException, Exception{
        String sql = "UPDATE clientes SET nome = '"+newNome+"' WHERE id_cliente = '"+idCliente+"'";
        Model.stmt.executeQuery(sql);
        commit2();
    }

    public static void alterarModo(String idCliente, String newModo) throws SQLException, Exception{
        String sql = "UPDATE clientes SET id_entrada = '"+procuraModoEntradaPorNome(newModo)+"' WHERE id_cliente = '"+idCliente+"'";
        Model.stmt.executeQuery(sql);
        commit2();
    }

    public static void alterarMatricula(String idCliente, String newMatricula) throws SQLException, Exception{
        String sql = "UPDATE clientes SET matricula = '"+newMatricula+"' WHERE id_cliente = '"+idCliente+"'";
        Model.stmt.executeQuery(sql);
        commit2();
    }

    public static void alterarNib(String idCliente, String newNib) throws SQLException, Exception{
        String sql = "UPDATE clientes SET nib = '"+newNib+"' WHERE id_cliente = '"+idCliente+"'";
        Model.stmt.executeQuery(sql);
        commit2();
    }

    public static ResultSet listarPagamentosCliente (String idCliente) throws SQLException{
        String sql = "SELECT * FROM pagamentos WHERE pagamentos.id_cliente = '";

        ResultSet rSet = null;
        rSet = Model.stmt.executeQuery(sql +idCliente + "'");

        return rSet;
    }

    public static GregorianCalendar listarUltimoPagamento (String idCliente) throws SQLException{
        String sql = "SELECT * FROM pagamentos WHERE pagamentos.id_cliente = '";
        GregorianCalendar dataUltimoPagamento   = new GregorianCalendar();
        GregorianCalendar dataTemp              = new GregorianCalendar();
        String dataS                            = "";
        float diferenca                         = 0;
        ResultSet rSet = null;
        
        rSet = Model.stmt.executeQuery(sql +idCliente + "'");

        while(rSet.next()){
            dataS = rSet.getString(2);
            dataTemp.set(LerDatas.getAno(dataS), LerDatas.getMes(dataS), LerDatas.getDia(dataS), LerDatas.getHora(dataS), LerDatas.getMin(dataS), LerDatas.getSec(dataS));
            diferenca = LerDatas.diferencaEntreDatas(dataUltimoPagamento, dataTemp);
            if (diferenca > 0) dataUltimoPagamento = dataTemp;
        }

        return dataUltimoPagamento;


    }

    public static GregorianCalendar listarUltimaEntradaParque (String idCliente) throws SQLException {
        String sql = "SELECT * FROM pagamentos WHERE pagamentos.id_cliente = '";
        GregorianCalendar dataUltimoEntrada     = new GregorianCalendar();
        GregorianCalendar dataTemp              = new GregorianCalendar();
        String dataS                            = "";
        float diferenca                         = 0;
        ResultSet rSet = null;
        
        rSet = Model.stmt.executeQuery(sql +idCliente + "'");

        while(rSet.next()){
            dataS = rSet.getString(2);
            dataTemp.set(LerDatas.getAno(dataS), LerDatas.getMes(dataS), LerDatas.getDia(dataS), LerDatas.getHora(dataS), LerDatas.getMin(dataS), LerDatas.getSec(dataS));
            diferenca = LerDatas.diferencaEntreDatas(dataUltimoEntrada, dataTemp);
            if (diferenca > 0) dataUltimoEntrada = dataTemp;
        }

        return dataUltimoEntrada;
    }

    public static String pagamentoEmAtraso (String idCliente) throws SQLException{
        GregorianCalendar dataUltimoPagamento   = new GregorianCalendar();
        GregorianCalendar dataUltimaEntrada     = new GregorianCalendar();
        GregorianCalendar dataPagar             = new GregorianCalendar();
        String resultado                        = "";
        float diferenca                         = 0;

        dataUltimaEntrada   = listarUltimaEntradaParque(idCliente);
        dataUltimoPagamento = listarUltimoPagamento(idCliente);

        LerDatas.diferencaEntreDatas(dataUltimoPagamento, dataUltimaEntrada);
        if (diferenca > 0) dataPagar = dataUltimaEntrada;
        resultado = dataUltimaEntrada.getTime().toString();

        return resultado;
    }

}
