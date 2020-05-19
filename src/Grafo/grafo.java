/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author esmeralda
 */
public class grafo {

    private List<nodoG> nodes;

    public void agregarNodo(nodoG node) {
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
    }

    public List<nodoG> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return "Graph [nodes=" + nodes + "]";
    }

}
