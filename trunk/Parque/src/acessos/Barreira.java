/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acessos;

/**
 *
 * @author Grupo1
 */
public class Barreira {
    



    private int id;
    private boolean estado;
    // true - aberta
    // false - fechada
    

    public Barreira(){
        estado = false;
    }
    public void abrirBarreira() {
        estado = true;
    }

    public void fecharBarreira() {
        estado = false;
    }

    @Override
    public String toString(){
        if (estado == true)
            return "Barreira aberta";
        else return "Barreira fechada";
    }

}
