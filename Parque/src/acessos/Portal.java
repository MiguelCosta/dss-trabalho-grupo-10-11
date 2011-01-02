/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package acessos;

import parkum_cs.PainelGlobal;

/**
 *
 * @author Miguel
 */
public class Portal {
    private int _id_portal;

    public Barreira _barreira;
    public Monitor _monitor;
    public PainelGlobal  _painelGlobal;

    public Portal (int id_portal){
        this._id_portal = id_portal;
        _barreira = new Barreira();
        _monitor = new Monitor();
        _painelGlobal = new PainelGlobal();
    }

    public int getID(){
        return _id_portal;
    }

    public Barreira getBarreira(){
        return _barreira;
    }

    public Monitor getMonitor(){
        return _monitor;
    }

    public PainelGlobal getPainelGlobal(){
        return _painelGlobal;
    }

    public void chamarFuncionario() {
	_monitor.mostrar("O funcionário foi contactado");
    }

    

}
