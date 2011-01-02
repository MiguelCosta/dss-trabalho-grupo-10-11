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
    

    public int nViaturasNoParque(){
        int nTotalViaturas=0;
        for(SensorEstacionamento sensor: _sensorEstacionamento){
            if(sensor.getEstaOcupado()==true){
                nTotalViaturas++;
            }
        }
        return nTotalViaturas;
    }

    public int incrementa() {
        int nViaturas = nViaturasNoParque();
        return nViaturas++;
    }

    public int decrementa(int aViaturasActuais) {
        int nViaturas = nViaturasNoParque();
        return nViaturas--;
    }
}
