/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parkum_cs;

/**
 *
 * @author Miguel
 */
public class SensorEstacionamento {

    private String _idSensor;
    private boolean _estaOcupado;

    public String getId(){
        return _idSensor;
    }

    public boolean getEstaOcupado(){
        return _estaOcupado;
    }

    public void actualizaSensor() {
        throw new UnsupportedOperationException();
    }

    public void comunicaEstacionamento() {
        throw new UnsupportedOperationException();
    }
}
