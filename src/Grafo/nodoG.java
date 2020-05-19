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
public class nodoG {

    private String ciudad;
    private listaAristas aristaNodo;

    public nodoG(String city) {
        this.ciudad = city;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String city) {
        this.ciudad = city;
    }

    public listaAristas getAristas() {
        return aristaNodo;
    }

    public void agregarArista(arista aristaN) {
        if (aristaNodo==null) {
            aristaNodo = new listaAristas();
        }
        aristaNodo.agregarAlFinal(aristaN);
    }

    @Override
    public String toString() {
        return "\n nodo{" + "city=" + ciudad + ", arista =" + aristaNodo + "\n}";
    }
}
