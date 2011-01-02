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
    private int _id_PortalEntrada;

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

    public Bilhete(int id, String dataEntrada, String dataSaida){
         _idBilhete=id;
         _dataHoraEntrada= dataEntrada;
         _dataHoraSaida= dataSaida;
    }

    public  int getIdBilhete() {
        return _idBilhete;
    }

    public String getHoraSaida() {
        return _dataHoraSaida;
    }

    public String getHoraEntrada() {
        return _dataHoraEntrada;
    }

    public int getPortalEntrada() {
        return _id_PortalEntrada;
    }

    public void setPortalEntrada(int portal){
        _id_PortalEntrada=portal;
    }






}
