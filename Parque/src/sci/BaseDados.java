/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sci;

import acessos.Bilhete;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import pagamentos.MaquinaPagamento;

/**
 *
 * @author Miguel
 */
public class BaseDados {

   
    /**
     *
     * @param aId
     * @param dataEntrada
     * @throws SQLException
     */
    public static void registarEntradaCliBilhete(String aIdB, String dataEntrada) throws SQLException {
       Model.stmt.executeQuery("INSERT INTO BILHETES VALUES '"+aIdB+"','"+dataEntrada+"','','',''");
    }
    /**
     *
     * @param identificacao
     * @throws SQLException
     * @throws Exception
     */
    public static void registoEntradaCliRegistado(String identificacao) throws SQLException, Exception {
       String sql = "SELECT * FROM CLIENTES WHERE ID_DISPOSITIVO = '";
       ResultSet rSet = null;
       String idCliente ="";
       GregorianCalendar data = new GregorianCalendar();
       rSet= Model.stmt.executeQuery(sql+identificacao+"'");

       while(rSet.next()){
            idCliente = rSet.getString(1);
       }
       String sql1 = "INSERT INTO REGISTOS_REGISTADOS VALUES ('"+idCliente+"','"+ data.toString()+"','')";
       Model.stmt.executeQuery(sql1);
       Query.commit2();
    }
   /**
    *
    * @param id_cliente
    * @param data
    * @param modo
    * @param montante
    * @throws SQLException
    * @throws Exception
    */
    public static void registarPagamentoBilhete(String idBilhete, String dataPagamento, String id_maq, String modoPag, String montante, String recibo) throws SQLException{

        String sql = "UPDATE BILHETES SET DATA_HORA_PAGAMENTO = TO_DATE('"+dataPagamento+"','yyyy-mm-dd hh24:mi:ss') WHERE ID_BILHETE = '" + idBilhete+"'";
        Model.stmt.executeQuery(sql);
        String sql1 = "INSERT INTO PAGAMENTOS_MAQUINAS VALUES('"+id_maq+"','"+idBilhete+"','"+montante+"','"+modoPag+"',TO_DATE('"+dataPagamento+"','yyyy-mm-dd hh24:mi:ss'),'"+recibo+"'";
        Model.stmt.executeQuery(sql1);
    }

    /**
     *
     * @param id_Maquina
     * @param desc
     * @param hora_manutencao
     * @param tempo_Manutencao
     * @param id_funcionario
     * @throws SQLException
     * @throws Exception
     */
    public static void registarManutencao(String id_Maquina, String desc,String hora_manutencao, String tempo_Manutencao,String id_funcionario) throws SQLException, Exception{
       Query.adicionarManutencao(id_Maquina, desc, hora_manutencao, tempo_Manutencao, id_funcionario);
    }
    /**
     *
     * @param aIdCliente
     * @return
     * @throws SQLException
     */
    public static boolean existeCliente(String aIdCliente) throws SQLException {
        ResultSet rSet = null;
        String sql = "SELECT * FROM CLIENTES WHERE ID_CLIENTE = '";
        rSet=Model.stmt.executeQuery(sql+aIdCliente+"'");
        boolean existe = false;
        String idCliente;
        while(rSet.next()){
            idCliente = rSet.getString(1);

            if(idCliente.equals(aIdCliente)){
                existe = true;
            }
        }
        return existe;
    }

    public static void registarPagamentoDeMulta(String idBlhete) throws SQLException {
        ResultSet rSet = null;
        String sql = "SELECT * FROM BILHETES WHERE ID_BILHETE = '" +idBlhete+"'";
        rSet=Model.stmt.executeQuery(sql);

        String idBi="", dataEntrada="", dataPagamento="", dataSaida="";
        while(rSet.next()){
            idBi=rSet.getString(1);
            dataEntrada = rSet.getString(2);
            dataPagamento= rSet.getString(3);
            dataSaida = rSet.getString(4);
        }

        int idInt= Integer.parseInt(idBi);
        Bilhete aux = new Bilhete(idInt, dataEntrada,dataSaida);
        GregorianCalendar dataActual = new GregorianCalendar();

        float montante = pagamentos.MaquinaPagamento.calculaMulta(aux);
        String sql1 = "INSERT INTO PAGAMENTOS_MULTAS VALUES('"+aux.getIdBilhete()+"','"+montante+"',TO_DATE('"+dataActual+"','yyyy-mm-dd hh24:mi:ss')'";
        Model.stmt.executeQuery(sql1);
    }

    public static void registaSaidaCliBilhete(String aIdB, String dataSaida) throws SQLException{
        String sql = "UPDATE BILHETES SET DATA_HORA_SAIDA = '"+dataSaida+"' WHERE ID_BILHETE ='"+aIdB+"'";
        Model.stmt.executeQuery(sql);

    }

    public static void registaSaidaCliRegistado(String ident, String dataSaida) throws SQLException {
       String sql = "UPDATE REGISTOS_REGISTADOS SET DATA_HORA_SAIDA = '"+dataSaida+"' WHERE ID_CLIENTE ='"+ident+"'";
       Model.stmt.executeQuery(sql);

    }
}
