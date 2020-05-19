/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author esmeralda
 */
public class arista {

    private nodoG origen;
    private nodoG destino;
    private double distancia;
    private double tiempoVehiculo;
    private double tiempoPersona;
    private double gasolina;
    private double desgasteFisico;

    public arista(nodoG origen, nodoG destino, double distancia, 
            double tiempoVehiculo, double tiempoPersona, double gasolina, double desgasteFisico) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.tiempoVehiculo = tiempoVehiculo;
        this.tiempoPersona = tiempoPersona;
        this.gasolina = gasolina;
        this.desgasteFisico = desgasteFisico;
    }






    public nodoG getOrigen() {
        return origen;
    }

    public void setOrigen(nodoG origen) {
        this.origen = origen;
    }

    public nodoG getDestino() {
        return destino;
    }

    public void setDestino(nodoG destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getTiempoVehiculo() {
        return tiempoVehiculo;
    }

    public void setTiempoVehiculo(double tiempoVehiculo) {
        this.tiempoVehiculo = tiempoVehiculo;
    }

    public double getTiempoPersona() {
        return tiempoPersona;
    }

    public void setTiempoPersona(double tiempoPersona) {
        this.tiempoPersona = tiempoPersona;
    }

    public double getGasolina() {
        return gasolina;
    }

    public void setGasolina(double gasolina) {
        this.gasolina = gasolina;
    }

    public double getDesgasteFisico() {
        return desgasteFisico;
    }

    public void setDesgasteFisico(double desgasteFisico) {
        this.desgasteFisico = desgasteFisico;
    }

    
    @Override
    public String toString() {
        return "\n \t arista{" + "origen=" + origen.getCiudad()+ ", destino=" 
                + destino.getCiudad() + ", distancia=" + distancia +"}" 
                + ", tiempoVehiculo=" + tiempoVehiculo 
                + ", tiempoPersona=" + tiempoPersona 
                + ", gasolina=" + gasolina + ", desgasteFisico=" + desgasteFisico + '}';
  }
}
