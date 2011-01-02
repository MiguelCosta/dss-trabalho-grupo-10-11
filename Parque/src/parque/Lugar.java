/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parque;

import parkum_cs.SensorEstacionamento;

/**
 *
 * @author Hugo
 */
public class Lugar {

    private int _idLugar;
    private boolean _estaLivre;
    private SensorEstacionamento _sensor;

    public void Lugar(){
        _idLugar=0;
        _estaLivre=true;
        _sensor =new SensorEstacionamento(""+_idLugar+"",_estaLivre);
    }

    public void Lugar(int idLugar, boolean estaLivre){
        _idLugar=idLugar;
        _estaLivre=estaLivre;
        _sensor = new SensorEstacionamento(""+_idLugar+"",_estaLivre);
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
