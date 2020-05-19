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
public class nodoArista {

    private arista valor;
    // Variable para enlazar los nodos.
    private nodoArista siguiente;

    /**
     * Constructor que inicializamos el valor de las variables.
     */
    public void Nodo() {
        this.valor = null;
        this.siguiente = null;
    }

    public arista getValor() {
        return valor;
    }

    public void setValor(arista valor) {
        this.valor = valor;
    }

    public nodoArista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoArista siguiente) {
        this.siguiente = siguiente;
    }
   
}
