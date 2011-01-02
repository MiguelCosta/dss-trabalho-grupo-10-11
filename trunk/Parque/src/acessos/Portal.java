/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package acessos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import parkum_cs.PainelGlobal;
import sci.BaseDados;
import sci.Model;

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

    public boolean existeDispositivo(String codDisp) throws SQLException {

            ResultSet rSet = null;
            ArrayList<String> codigos = new ArrayList<String>();
            boolean encontrado = false;
            String sql = "SELECT * FROM CLIENTES WHERE ID_DISPOSITIVO = '";
            rSet=Model.stmt.executeQuery(sql+codDisp+"'");
            while(rSet.next()){

                String code = rSet.getString(6);
                codigos.add(code);
                }

            for(String cod: codigos){
                if(cod.equals(codDisp)){
                encontrado = true;
                }
            }
        return encontrado;
    }

}
