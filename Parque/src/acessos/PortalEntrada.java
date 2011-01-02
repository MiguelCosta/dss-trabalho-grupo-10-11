/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package acessos;


/**
 *
 * @author Miguel
 */
public class PortalEntrada extends Portal {
        private int _portalID;
	private boolean _estado;

        public PortalEntrada(int portalID){
            super(portalID);
            _estado=false;
        }

	public boolean estado() {
		throw new UnsupportedOperationException();
	}

	public int verificarFormaEntrada() {
            return 0;
	}

	public boolean existeDispositivo() {
            return true;
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
