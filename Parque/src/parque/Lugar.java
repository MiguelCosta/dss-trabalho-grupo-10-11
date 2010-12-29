/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parque;

/**
 *
 * @author Hugo
 */
public class Lugar {

    private int _idLugar;
    private boolean _estaLivre;

    public void Lugar(){
        _idLugar=0;
        _estaLivre=true;
    }

    public void Lugar(int idLugar, boolean estaLivre){
        _idLugar=idLugar;
        _estaLivre=estaLivre;
    }

    public int getIdLugar(){
        return _idLugar;
    }

    public boolean getEstaLivre(){
        return _estaLivre;
    }

    public void setIdLugar(int idLugar){
        _idLugar=idLugar;
    }

    public void setEstaLivre(boolean estaLivre){
        _estaLivre=estaLivre;
    }
}
