package arbol;

import static interfaz.Pantalla.opcion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class arbolB {

// aquí hay variables disponibles para el árbol  
    static int gradoArbol;
    public static nodoArbol raizArbol;

// aquí está el constructor para el árbol -
    public arbolB(int grado) {
        this.gradoArbol = grado;
        raizArbol = new nodoArbol(grado, null);
    }

// ------------------------------------------------ --------
// este será el método para buscar un nodo dado donde 
// queremos insertar un valor clave. este método se llama 
// de SearchnPrintNode. Devuelve un nodo con clave 
// valor en ella 
// ------------------------------------------------ --------
    public nodoArbol buscarNodo(nodoArbol raiz, double llave) {
        int i = 0;// siempre queremos comenzar a buscar el índice 0 del nodo

        while (i < raiz.cantidadCLave && llave > raiz.claves[i]) // sigue incrementando
        // en nodo mientras clave>
        //valor actual.
        {
            i++;
        }

        if (i <= raiz.cantidadCLave && llave == raiz.claves[i]) // obviamente si la clave está en el nodo
        // fuimos al nodo de retorno.
        {
            return raiz;
        }

        if (raiz.hoja)// ya que hemos verificado la raíz
        // si es hoja no tenemos nada más que verificar
        {
            return null;

        } else // de lo contrario, si no es así, deja que recurse hacia abajo a través de un hijo
        {
            return buscarNodo(raiz.getChild(i), llave);
        }
    }

// ------------------------------------------------ --------
// este será el método de división. Se dividirá el nodo que 
// desea insertar en si está lleno.
// ------------------------------------------------ --------
    public void division(nodoArbol x, int i, nodoArbol y) {
        // tengo que tener un nodo extra si estamos
        //dividir.
        nodoArbol nodoAuxiliar = new nodoArbol(gradoArbol, null);

        nodoAuxiliar.hoja = y.hoja;// establece boolean igual que y

        nodoAuxiliar.cantidadCLave = gradoArbol - 1;// este es el tamaño actualizado

        for (int j = 0; j < gradoArbol - 1; j++) {
            nodoAuxiliar.claves[j] = y.claves[j + gradoArbol]; // copia el final de y al frente de z
        }
        if (!y.hoja)// si no la hoja tenemos que reasignar nodos secundarios.
        {
            for (int k = 0; k < gradoArbol; k++) {
                nodoAuxiliar.hijos[k] = y.hijos[k + gradoArbol]; // reasegurando hijo de y
            }
        }

        y.cantidadCLave = gradoArbol - 1; // nuevo tamaño de y

        for (int j = x.cantidadCLave; j > i; j--)// si presionamos la tecla en x tenemos
        {				 // para reorganizar nodos secundarios

            x.hijos[j + 1] = x.hijos[j]; // Desplazar hijas de x

        }
        x.hijos[i + 1] = nodoAuxiliar; //reassign i+1 child of x

        for (int j = x.cantidadCLave; j > i; j--) {
            x.claves[j + 1] = x.claves[j]; // shift keys
        }
        x.claves[i] = y.claves[gradoArbol - 1];//finally push value up into root.

        y.claves[gradoArbol - 1] = 0; //erase value where we pushed from

        for (int j = 0; j < gradoArbol - 1; j++) {
            y.claves[j + gradoArbol] = 0; //'delete' old values
        }

        x.cantidadCLave++;  //increase count of keys in x
    }

// ------------------------------------------------ ----------
// este será el método de inserción cuando el nodo no esté lleno. El |
// ------------------------------------------------ ----------
    public void insercionNodoLleno(nodoArbol nodo, double clave) {
        int i = nodo.cantidadCLave; //i is number of keys in node x
        if (nodo.hoja) {
            while (i >= 1 && clave < nodo.claves[i - 1])//here find spot to put key.
            {
                nodo.claves[i] = nodo.claves[i - 1];//shift values to make room
                i--;//decrement
            }

            nodo.claves[i] = clave;//finally assign value to node
            nodo.cantidadCLave++; //increment count of keys in this node now.

        } else {
            int j = 0;
            while (j < nodo.cantidadCLave && clave > nodo.claves[j])//find spot to recurse
            {			             //on correct child  		
                j++;
            }

            //	i++;
            if (nodo.hijos[j].cantidadCLave == gradoArbol * 2 - 1) {
                division(nodo, j, nodo.hijos[j]);//call split on node x's ith child

                if (clave > nodo.claves[j]) {
                    j++;
                }
            }

            insercionNodoLleno(nodo.hijos[j], clave);//recurse
        }
    }

// ------------------------------------------------ --------------
// este será el método para insertar en general, llamará a 
// insertar no lleno si es necesario.
// ------------------------------------------------ --------------
    public void insertar(arbolB arbol, double clave) {
        nodoArbol nodoAux = arbol.raizArbol;//this method finds the node to be inserted as 
        //it goes through this starting at root node.
        if (nodoAux.cantidadCLave == 2 * gradoArbol - 1)//if is full
        {
            nodoArbol nodoNUevo = new nodoArbol(gradoArbol, null);//new node

            arbol.raizArbol = nodoNUevo;    //\
            // \	
            nodoNUevo.hoja = false;//  \
            //   > this is to initialize node.
            nodoNUevo.cantidadCLave = 0;   //  /
            // /	
            nodoNUevo.hijos[0] = nodoAux;///

            division(nodoNUevo, 0, nodoAux);//division de taiz

            insercionNodoLleno(nodoNUevo, clave); //call insert method
        } else {
            insercionNodoLleno(nodoAux, clave);//if its not full just insert it
        }
    }

// ------------------------------------------------ ---------------------------------
// este será el método para imprimir un nodo o se repetirá cuando el nodo raíz no sea hoja |
// ------------------------------------------------ ---------------------------------
    public static LinkedList<String> listaArbol = new LinkedList<>();

    public static void imprimir(nodoArbol nodo) throws IOException {
        System.out.println(nodo.padre);
        for (int i = 0; i < nodo.cantidadCLave; i++) {
            System.out.println("**" + nodo.getValue(i) + "**");
            double numero = nodo.getValue(i);
            String dato = String.valueOf(nodo.getValue(i));
            listaArbol.add(dato);
        }
        if (!nodo.hoja)// esto se llama cuando root no es leaf;
        {
            for (int j = 0; j <= nodo.cantidadCLave; j++) // en este bucle repetimos
            {// para imprimir el árbol en
                if (nodo.getChild(j) != null) // preordenar.
                {			  //llendo desde el mas izquierda
                    System.out.println("--");	  //hijo a la derecha
                    imprimir(nodo.getChild(j));    //hijo
                }
            }
        }
    }

    
// ------------------------------------------------ ------------
// este será el método para imprimir un nodo |
// ------------------------------------------------ ------------
    public void imprimirNodo(arbolB arbol, double clave) throws IOException {
        nodoArbol temp = new nodoArbol(gradoArbol, null);

        temp = buscarNodo(arbol.raizArbol, clave);

        if (temp == null) {

            System.out.println("La clave no existe en el arbol");
        } else {

            imprimir(temp);
        }

    }

// ------------------------------------------------ --------------
// este método eliminará un valor clave del nodo hoja que es |
//en. Utilizaremos el método de búsqueda para recorrer el |
// árbol para encontrar el nodo donde se encuentra la clave. Luego, lo haremos 
// iterado a través de la matriz de claves [] hasta que lleguemos al nodo y lo 
// asigna k [i] = k [i + 1] sobrescribiendo la clave que queremos eliminar y 
// manteniendo los espacios en blanco también. Tenga en cuenta que este es el más 
// caso simple de eliminar que hay y no tendremos tiempo 
// para implementar todos los casos correctamente.
// ------------------------------------------------ --------------
    public void borrarCLave(arbolB arbol, double clave) {

        nodoArbol auxNodo = new nodoArbol(gradoArbol, null);//temp Bnode

        auxNodo = buscarNodo(arbol.raizArbol, clave);//call of search method on tree for key

        if (auxNodo.hoja && auxNodo.cantidadCLave > gradoArbol - 1) {
            int i = 0;

            while (clave > auxNodo.getValue(i)) {
                i++;
            }
            for (int j = i; j < 2 * gradoArbol - 2; j++) {
                auxNodo.claves[j] = auxNodo.getValue(j + 1);
            }
            auxNodo.cantidadCLave--;

        } else {
            System.out.println("Este nodo no es una hoja o tiene menos de orden: 1 teclas.");
        }
    }

}
