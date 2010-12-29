/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos;

import acessos.Bilhete;
import sci.BaseDados;
import java.util.Vector;

/**
 *
 * @author Miguel
 */
public class MaquinaPagamento {

    private Object _idMaquina;
    public BaseDados _baseDados;
    public Vector<Recibo> _recibo = new Vector<Recibo>();

    public Bilhete leBilhete() {
        throw new UnsupportedOperationException();
    }

    public float calculaMulta(Bilhete aBilhete) {
        throw new UnsupportedOperationException();
    }

    public void mostra(float aValor) {
        throw new UnsupportedOperationException();
    }

    public void recebePagamento(float aValor) {
        throw new UnsupportedOperationException();
    }

    public void registaPagamentoNoBilhete() {
        throw new UnsupportedOperationException();
    }

    public void registaNovaHoraSaida() {
        throw new UnsupportedOperationException();
    }

    public void devolveBilhete() {
        throw new UnsupportedOperationException();
    }

    public void comunicaErro(String aErro) {
        throw new UnsupportedOperationException();
    }

    public void devolveCartaoMagnetico() {
        throw new UnsupportedOperationException();
    }

    public void pedeCodigoCartaoMagnetico() {
        throw new UnsupportedOperationException();
    }

    public float verificaSaldoCartaoMagnetico() {
        throw new UnsupportedOperationException();
    }

    public void efectuaTransaccaoMultibanco() {
        throw new UnsupportedOperationException();
    }

    public void leDados(String aImput) {
        throw new UnsupportedOperationException();
    }

    public void comunicaSucesso() {
        throw new UnsupportedOperationException();
    }

    public float calculaValorPagar(Bilhete aBilhete) {
        throw new UnsupportedOperationException();
    }

    public float leValor() {
        throw new UnsupportedOperationException();
    }

    public float calculaTroco(float aValorInserido, float aValorPagar) {
        throw new UnsupportedOperationException();
    }
}
