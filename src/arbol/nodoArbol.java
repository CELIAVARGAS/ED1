package arbol;

// this is implementation of Node class for Balanced tree.
import java.util.LinkedList;

public class nodoArbol {

    static int gradoTree;  //variable to determine order of tree

    public static int cantidadCLave; // number of keys in node

    double[] claves;  // array of key values

    nodoArbol[] hijos; //array of references

    public static boolean hoja; //is node a leaf or not

    nodoArbol padre;  //parent of current node.
    // ----------------------------------------------------
    // this will be default constructor for new node      |
    // ----------------------------------------------------

    public nodoArbol() {
    }
// ----------------------------------------------------
// initial value constructor for new node             |
// will be called from BTree.java                     |
// ----------------------------------------------------

    public nodoArbol(int t, nodoArbol parent) {
        this.gradoTree = t;  //assign size

        this.padre = parent; //assign parent

        claves = new double[2 * t - 1];  // array of proper size

        hijos = new nodoArbol[2 * t]; // array of refs proper size

        hoja = true; // everynode is leaf at first;

        cantidadCLave = 0; //until we add keys later.
    }

// -----------------------------------------------------
// this is method to return key value at index position|
// -----------------------------------------------------
    public double getValue(int index) {
        return claves[index];
    }

// ----------------------------------------------------
// this is method to get ith child of node            |
// ----------------------------------------------------
    public nodoArbol getChild(int index) {
        return hijos[index];
    }

}
