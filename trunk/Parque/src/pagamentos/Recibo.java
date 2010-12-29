/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos;

/**
 *
 * @author Miguel
 */

public class Recibo {

    private String _idPaque = "PARKUM";
    private String _nipc = "987654321";
    private String _idMaquina;
    private String _nRecibo;
    private String _nBilhete;
    private String _horaEntrada;
    private float _tempoEstacionamento;
    private float _valorPago;
    private String _dataActual;
    private String _horaActual;
    public MaquinaPagamento _unnamed_MaquinaPagamento_;

    public void InformacoesRecibo(String aDados) {
        System.out.println(_idPaque);
        System.out.println("NIPC: "); System.out.println(_nipc);
        System.out.println("Máquina automática:"); System.out.println(_idMaquina);
        System.out.println("Recibo Nº: "); System.out.println(_nRecibo);
        System.out.println("Bilhete Nº: "); System.out.println(_nBilhete);
        System.out.println("Hora de Entrada: "); System.out.println(_horaEntrada);
        System.out.println("Tempo de estacionamento: "); System.out.println(_tempoEstacionamento);
        System.out.println("Valor pago:"); System.out.println(_valorPago);
        System.out.println("Data: "); System.out.println(_dataActual);
        System.out.println("Hora: "); System.out.println(_horaActual);
        System.out.println("IVA incluído à taxa em vigor\n");
        System.out.println("Recibo processado por computador\n");
        System.out.println("Contribuinte Nº:\n");
        System.out.println("Morada:\n");

        throw new UnsupportedOperationException();
    }
}
