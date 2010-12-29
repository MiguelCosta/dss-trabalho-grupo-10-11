/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

/**
 *
 * @author Miguel
 */
public class FichaCliente {

    private String _idCliente;
    private String _nomeCliente;
    private String _codigoEntrada;
    private String _matricula;
    private String _nib;
    //public GestaoClientes _unnamed_GestaoClientes_;

    public FichaCliente() {
        _idCliente       = null;
        _nomeCliente     = null;
        _codigoEntrada   = null;
        _matricula       = null;
        _nib             = null;
    }

    public FichaCliente(String idCliente, String nomeCliente, String codigoEntrada, String matricula, String nib){
        _idCliente      = idCliente;
        _nomeCliente    = nomeCliente;
        _codigoEntrada  = codigoEntrada;
        _matricula      = matricula;
        _nib            = nib;
    }

    public FichaCliente(FichaCliente fichaCliente){
        _idCliente      = fichaCliente.getIdCliente();
        _nomeCliente    = fichaCliente.getNomeCliente();
        _codigoEntrada  = fichaCliente.getCodigoEntrada();
        _matricula      = fichaCliente.getMatricula();
        _nib            = fichaCliente.getNib();
    }

    public String getIdCliente() {
        return this._idCliente;
    }

    public String getNomeCliente() {
        return this._nomeCliente;
    }

    public String getCodigoEntrada() {
        return this._codigoEntrada;
    }

    public String getMatricula() {
        return this._matricula;
    }

    public String getNib() {
        return this._nib;
    }

    public void setIdCliente(String idCliente){
        _idCliente = idCliente;
    }

    public void setNomeCliente(String nomeCliente){
        _nomeCliente = nomeCliente;
    }

    public void setCodigoEntrada(String codigoEntrada){
        _codigoEntrada = codigoEntrada;
    }

    public void setMatricula(String matricula){
        _matricula = matricula;
    }

    public void setNib(String nib){
        _nib = nib;
    }
}
