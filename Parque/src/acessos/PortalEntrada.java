/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package acessos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sci.BaseDados;
import sci.Model;


/**
 *
 * @author Miguel
 */
public class PortalEntrada extends Portal {
        private int nBilhete=1;

        public PortalEntrada(int portalID){
            super(portalID);
        }
	public int verificarFormaEntrada() {


            return 0;
	}

        public boolean verificaOcupacao() throws SQLException {

            ResultSet rSet = null;
            ArrayList<String> estadosPisos = new ArrayList<String>();
            boolean ocupado = true;
            rSet=Model.stmt.executeQuery("SELECT * FROM PISOS");
            while(rSet.next()){
                String estado = rSet.getString(3);
                estadosPisos.add(estado);
                }

            for(String estado: estadosPisos){
                if(estado.equals("0")){
                ocupado = false;
                }
            }


            return ocupado;
	}
	public void devolveCartaoAvenca() {
		throw new UnsupportedOperationException();
	}

	public int leNumClienteAvenca() {
		throw new UnsupportedOperationException();
	}

	public boolean verificaValidadeAvenca(int aNCliente) {
		throw new UnsupportedOperationException();
	}

	public boolean verificaPagOrdemAvenca(int aNCliente) {
		throw new UnsupportedOperationException();
	}

	public Bilhete emiteBilhete() throws SQLException {
                String dataEntrada = "" ; //Falta
                String dataSaida = "a"; // Falta
		Bilhete b = new Bilhete(nBilhete,dataEntrada,dataSaida,super.getID());
                BaseDados.registarEntradaCliBilhete(""+nBilhete+"", dataEntrada);
                nBilhete++;
                
          return b;
	}


}
