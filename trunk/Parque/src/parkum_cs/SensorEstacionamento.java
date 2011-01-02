/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parkum_cs;

import java.sql.SQLException;
import sci.Model;

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

    public void setID(String id){
        _idSensor =id;
    }

    public void setEstaOcupado(boolean estaOcupado){
        _estaOcupado=estaOcupado;
    }

    public void actualizaSensor() {
        if(_estaOcupado==true)
            _estaOcupado = false;
        else _estaOcupado= true;
    }

    public void comunicaEstacionamento(String data) throws SQLException {
        String sql="";
        if(_estaOcupado == false){

             sql= sql + "INSERT INTO REGISTOS_LUGARES VALUES('"+_idSensor+"',TO_DATE('"+data+"','yyyy-mm-dd hh24:mi:ss'),''";
        }
        else {
            sql = sql + "UPDATE REGISTOS_LUGARES SET DATA_HORA_LIVRE = TO_DATE('"+data+"','yyyy-mm-dd hh24:mi:ss')";
        }
        Model.stmt.executeQuery(sql);
    }
}
