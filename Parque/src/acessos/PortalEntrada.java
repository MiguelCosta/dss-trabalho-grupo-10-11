/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package acessos;

import sci.BaseDados;


/**
 *
 * @author Miguel
 */
public class PortalEntrada {
    private int _portalID;
	private boolean _estado;
	private int _codDisp;
	public MonitorEntrada _monitor;
	public Bilhete _bilhete;
	public BarreiraEntrada _barreiraEntrada;
	public BaseDados _baseDados;

	public boolean estado() {
		throw new UnsupportedOperationException();
	}

	public void chamarFuncionario() {
		throw new UnsupportedOperationException();
	}

	public void imprimeBilhete() {
		throw new UnsupportedOperationException();
	}

	public int verificarFormaEntrada() {
            int codDiap = 0;
            return codDiap;
	}

	public boolean existeDispositivo() {
		throw new UnsupportedOperationException();
	}

	public boolean verificaOcupacao() {
		throw new UnsupportedOperationException();
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

	public Bilhete emiteBilhete() {
		throw new UnsupportedOperationException();
	}


}
