/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acessos;

/**
 *
 * @author Miguel
 */
public class Monitor {

    private String _informacao;

    public Monitor (){
        _informacao = "";
    }
    public String comunicaErro(String aErro) {
        throw new UnsupportedOperationException();
    }

    public void mostrar(String info) { //getInformacao
        System.out.println(info);
    }

    public void alterarInfo(String informacao){
        _informacao = informacao;
    }

    public void adicionarInfo(String informacao){
        _informacao = _informacao + "\n" + informacao;
    }
}
