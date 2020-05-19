/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_ed;

import Grafo.arista;
import Grafo.grafo;
import Grafo.nodoG;
import interfaz.Pantalla;

/**
 *
 * @author esmeralda
 */
public class FINAL_ED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Pantalla principal = new Pantalla();

        principal.setVisible(true);

//        grafo graph = getCities();
//        System.out.println(graph);
    }

    public static grafo getCities() {
        nodoG df = new nodoG("DF");
        nodoG toluca = new nodoG("Toluca");
        nodoG cuernavaca = new nodoG("Cuernavaca");
        nodoG puebla = new nodoG("Puebla");
        nodoG tlaxcala = new nodoG("Tlaxcala");

        /*        df.agregarArista(new arista(df, toluca, 100));
        df.agregarArista(new arista(df, cuernavaca, 90));
        
        toluca.agregarArista(new arista(toluca, cuernavaca, 150));
        toluca.agregarArista(new arista(toluca, puebla, 350));
        toluca.agregarArista(new arista(toluca, tlaxcala, 340));

        cuernavaca.agregarArista(new arista(cuernavaca, puebla, 100));

        puebla.agregarArista(new arista(puebla, tlaxcala, 20));

         */ grafo graph = new grafo();
        graph.agregarNodo(df);
        graph.agregarNodo(toluca);
        graph.agregarNodo(cuernavaca);
        graph.agregarNodo(puebla);
        return graph;

    }

}
