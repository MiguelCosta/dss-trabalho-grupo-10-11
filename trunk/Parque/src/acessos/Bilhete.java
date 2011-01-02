/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acessos;

/**
 *
 * @author Miguel
 */
public class Bilhete {
    private int _idBilhete;
    private String _dataHoraEntrada;
    private String _dataHoraSaida;
    public int _id_PortalEntrada;

    public Bilhete (){

        _idBilhete=0;
        _dataHoraEntrada=null;
        _dataHoraSaida=null;
        _id_PortalEntrada=0;
    }


    public Bilhete(Bilhete b){

        _idBilhete=b.getIdBilhete();
        _dataHoraEntrada = b.getHoraEntrada();
        _dataHoraSaida = b.getHoraSaida();
        _id_PortalEntrada=b.getPortalEntrada();
    }

    private int getIdBilhete() {
        return _idBilhete;
    }

    private String getHoraSaida() {
        return _dataHoraSaida;
    }

    private String getHoraEntrada() {
        return _dataHoraEntrada;
    }

    private int getPortalEntrada() {
        return _id_PortalEntrada;
    }






}
