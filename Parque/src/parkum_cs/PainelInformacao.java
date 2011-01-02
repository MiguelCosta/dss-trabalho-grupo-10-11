/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parkum_cs;

/**
 *
 * @author Miguel
 */
public class PainelInformacao {

    private int _nivel;
    private int _nVeiculosNivel;

    public PainelInformacao(){
        _nivel = 1;
        _nVeiculosNivel=0;
    }

    public PainelInformacao(int nivel, int nVeiculos){
        _nivel=nivel;
        _nVeiculosNivel=nVeiculos;
    }

    public void actualizaInfo(int nVeiculos) {
        _nVeiculosNivel=nVeiculos;
    }
}
