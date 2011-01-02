/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parkum_cs;

import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class PARKUM_CS {

    private PainelGlobal _painelGlobal;
    private PainelInformacao _panelInfo;
    private ArrayList<SensorEstacionamento> _sensorEstacionamento = new ArrayList<SensorEstacionamento>();

    public int nViaturasNoParque(int nViaturas){
        int contador=0;

        for(SensorEstacionamento sensor: _sensorEstacionamento){
            if(sensor.getEstaOcupado()==true){
                contador++;
            }
        }
        return contador;
    }

    public int incrementa(int aViaturasActuais) {
        throw new UnsupportedOperationException();
    }

    public int decrementa(int aViaturasActuais) {
        throw new UnsupportedOperationException();
    }
}
