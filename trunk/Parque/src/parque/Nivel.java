/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parque;

/**
 *
 * @author Hugo
 */
public class Nivel {

    private int _idNivel;
    private int _nLugares;
    private boolean _estaLivre;

    public void Nivel() {
        _idNivel = 0;
        _nLugares = 0;
        _estaLivre = true;
    }

    public void Nivel(int idNivel,int nLugares,boolean estaLivre){
        _idNivel=idNivel;
        _nLugares=nLugares;
        _estaLivre=estaLivre;
    }

    public int getIdNivel(){
        return _idNivel;
    }

    public int getNLugares(){
        return _nLugares;
    }

    public boolean getEstaLivre(){
        return _estaLivre;
    }


    public void setIdNivel(int idNivel){
        _idNivel=idNivel;
    }

    public void setNlugares(int nLugares){
        _nLugares=nLugares;
    }

    public void setEstaLivre(boolean estaLivre){
        _estaLivre=estaLivre;
    }
}
