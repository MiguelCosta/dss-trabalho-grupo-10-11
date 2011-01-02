/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parkum_cs;

/**
 *
 * @author Miguel
 */
public class PainelGlobal {

    private int _nVeiculosTotal;
    private boolean _estaLivre;

    public PainelGlobal(){
        _nVeiculosTotal=0;
        _estaLivre = true;
    }

    public void actualizaInfo(int nVeiculos, boolean estaLivre) {
        _nVeiculosTotal=nVeiculos;
        _estaLivre=estaLivre;
    }
}
