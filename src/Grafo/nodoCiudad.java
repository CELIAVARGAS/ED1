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
public class nodoCiudad {

    private nodoG valor;
    private nodoCiudad siguiente;

    public void Nodo() {
        this.valor = null;
        this.siguiente = null;
    }

    public nodoG getValor() {
        return valor;
    }

    public void setValor(nodoG valor) {
        this.valor = valor;
    }

    public nodoCiudad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoCiudad siguiente) {
        this.siguiente = siguiente;
    }

}
