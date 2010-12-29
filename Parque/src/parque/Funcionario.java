/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parque;

/**
 *
 * @author Hugo
 */
public class Funcionario {

    private int _idFuncionario;
    private String _nomeFunc;

    public void Funcionario(){
        _idFuncionario=0;
        _nomeFunc=null;
    }

    public void Funcionario(int idFuncionario, String nomeFuncionario){
        _idFuncionario=idFuncionario;
        _nomeFunc=nomeFuncionario;
    }

    public int getIdFuncionario(){
        return _idFuncionario;
    }

    public String getNomeFuncionario(){
        return _nomeFunc;
    }

    public void setIdFunc(int idFuncionario){
        _idFuncionario=idFuncionario;
    }

    public void setNomeFunc(String nomeFuncionario){
        _nomeFunc=nomeFuncionario;
}

}

