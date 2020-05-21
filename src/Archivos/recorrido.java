/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import static Archivos.lectura_Archivo.grafoCompleto;
import Grafo.listaAristas;
import Grafo.nodoG;
import arbol.arbolB;
import static arbol.arbolB.listaArbol;
import static interfaz.Pantalla.areaListas;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author esmeralda
 */
public class recorrido {

    public static Stack pilaNodosRecorridos = new Stack();
    public static LinkedList<LinkedList> listaRecorridos = new LinkedList<>();

    public static void recorridoGrafo(String ciudadInicio, String ciudadDestino) throws Exception {
        /*Obtenemos nodo inicio y nodo destino
        buscamos en grafo el nodo inicio, obtenemos sus adyacentes
        y evaluamos adyacentes de cada uno.
         */
        pilaNodosRecorridos.clear();
        listaRecorridos.clear();
        if (ciudadInicio.equals(ciudadDestino)) {
            System.out.println("La ciudad origen  es la misma que el destino");
        } else {
            for (int i = 0; i < grafoCompleto.getNodes().size(); i++) {
                String ciudadEncontrada = grafoCompleto.getNodes().get(i).getCiudad();
                nodoG ciudadEncontrada2 = grafoCompleto.getNodes().get(i);

                if (ciudadEncontrada.equals(ciudadInicio)) {
                    //agregamos a pila la primera ciudad
                    pilaNodosRecorridos.push(ciudadInicio);
                    System.out.println(ciudadEncontrada);
                    recorridoAdyacentes(ciudadEncontrada2, ciudadDestino);
                } else {
                }
            }
        }
    }

    public static void recorridoAdyacentes(nodoG ciudad, String ciudadDestino) throws Exception {
        //obtenemos aristas de la ciudad
        listaAristas lista1 = ciudad.getAristas();

        System.out.println(" ciudad " + ciudad.getCiudad());
        System.out.println(pilaNodosRecorridos.toString());
        if (lista1 == null) {//si no hay aristas quitamos de la pila
    //        System.out.println(" No hay aristas ");
            pilaNodosRecorridos.pop();
            System.out.println(pilaNodosRecorridos.toString());
        } else {//Hay aristas
            //recorremos cada arista para obtener destino
            for (int i = 0; i < lista1.getTamanio(); i++) {
                //agregamos a pila ciudad recorrida
                String ciudadRecorrida = lista1.getValor(i).getDestino().getCiudad();
                System.out.println("\t Adyacentes " + ciudadRecorrida);
                pilaNodosRecorridos.push(ciudadRecorrida);
                nodoG ciudadL = lista1.getValor(i).getDestino();
                System.out.println(pilaNodosRecorridos.toString());

                //si esta ciudad es la que hemos buscado entonces se desapila,
                if (ciudadRecorrida.equals(ciudadDestino)) {
                    //imprimimos la pila
                    //eliminamos el dato de la pila
                    System.out.println("\t\t Ciudad Destino encontrada ");
                    System.out.println("\t\t" + pilaNodosRecorridos.toString());
                    //verificar porque la pila queda vacia
                    llenarlista(pilaNodosRecorridos);
                    pilaNodosRecorridos.pop();
                } else {//si no es la ciudad buscada 
                    boolean ciudadEncontrada = false;
                    //buscamos en la pila si esta ciudad ya existe 
                    for (int j = 0; j < pilaNodosRecorridos.size(); j++) {
                        String dato = (String) pilaNodosRecorridos.get(j);
                        if (j == pilaNodosRecorridos.size() - 1) {
                        } else {
                            if (dato.equals(ciudadRecorrida)) {
                                ciudadEncontrada = true;
                                break;
                            } else {
                                ciudadEncontrada = false;
                            }
                        }
                    }
                    //la ciudad ya esta en pila, no buscamos adyacentes
                    if (ciudadEncontrada == true) {
                        System.out.println("\t\t Existe la ciudad en pila");
                        pilaNodosRecorridos.pop();
                        System.out.println(pilaNodosRecorridos.toString());
                    } //no se ha encontrado la ciudad entonces buscamos sus adyacente
                    else {
                        System.out.println("\t\t No existe la ciudad en pila");
                        System.out.println("c" + ciudadL.getCiudad());
                        recorridoAdyacentes(ciudadL, ciudadDestino);
                    }
                }
            }
            //cuando termine el recorrido de cada nodo entonces se  desapila 
            pilaNodosRecorridos.pop();
            System.out.println(pilaNodosRecorridos.toString());
        }
    }

    public static void llenarlista(Stack pila) {
        LinkedList<String> lista1 = new LinkedList<>();
        for (int i = 0; i < pila.size(); i++) {
            String dato = (String) pila.get(i);
            lista1.add(dato);
        }
        listaRecorridos.add(lista1);
    }

    public static void creacionArbol(int opcion) throws Exception {
        for (int i = 0; i < listaRecorridos.size(); i++) {
            //modificaremos y agregaremos la distancia dependiendo el numero de parametro en la eleccion
            // de la lista retornada se agrega al arbol la lista
            obtenerCantidadUtilizadaRecorrido(listaRecorridos.get(i), opcion);
        }
        System.out.println(listaRecorridos.toString());
        ordenDatos(opcion);
    }

    public static LinkedList<String> obtenerCantidadUtilizadaRecorrido(LinkedList lista, int opcion) throws Exception {
        double cantidad = 0;
        String ultimaCiudad = "";
        for (int i = 0; i < lista.size(); i++) {
            //cada dato de la lista es una ciudad, obtenemos la distancia dependiendp del parametro
            //opcion y se ira sumando la cantidad, luego se a;ade a la lista y se regresa la lista 
            //con su cantidad agregada
            String ciudad1 = (String) lista.get(i).toString();
            System.out.println(ciudad1);
            if (i == lista.size() - 1) {//ya no hay otra ciudad despues
                ultimaCiudad = (String) lista.get(i).toString();;
            } else {
                String ciudad2 = (String) lista.get(i + 1).toString();
                cantidad = cantidad + cantidad(ciudad1, ciudad2, opcion);
            }
        }
        if (lista.getLast().equals(ultimaCiudad)) {
            lista.add(cantidad);
        } else {
            lista.removeLast();
            lista.add(cantidad);
        }
        return lista;
    }

    public static double cantidad(String ciudad1, String ciudad2, int opcion) throws Exception {
        double cantidad = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < grafoCompleto.getNodes().size(); i++) {
            String ciudadO = grafoCompleto.getNodes().get(i).getCiudad();
            if (ciudadO.equals(ciudad1)) {
                if (grafoCompleto.getNodes().get(i).getAristas() == null) {
            //        System.out.println("No hay aristas");
                } else {
                    for (int j = 0; j < grafoCompleto.getNodes().get(i).getAristas().getTamanio(); j++) {
                        nodoG ciudadD = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDestino();
                        if (ciudadD.getCiudad().equals(ciudad2)) {
                            switch (opcion) {
                                case 1:
                                    cantidad = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getGasolina();
                                    break;
                                case 2:
                                    cantidad = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getTiempoVehiculo();
                                    break;
                                case 3:
                                    cantidad = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getTiempoPersona();
                                    break;
                                case 4:
                                    cantidad = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDesgasteFisico();
                                    break;
                                case 5:
                                    //gasolina y distancia
                                    c1 = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getGasolina();
                                    c2 = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDistancia();
                                    cantidad = c1 + c2;
                                    break;
                                case 6:
                                    //desgaste fisico y distancia
                                    c1 = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDesgasteFisico();
                                    c2 = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDistancia();
                                    cantidad = c1 + c2;
                                    break;
                                case 7:
                                    cantidad = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getGasolina();
                                    break;
                                case 8:
                                    cantidad = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getTiempoVehiculo();
                                    break;
                                case 9:
                                    cantidad = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getTiempoPersona();
                                    break;
                                case 10:
                                    cantidad = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDesgasteFisico();
                                    break;
                                case 11:
                                    //gasolina y distancia
                                    c1 = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getGasolina();
                                    c2 = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDistancia();
                                    cantidad = c1 + c2;
                                    break;
                                case 12:
                                    //desgaste fisico y distancia
                                    c1 = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDesgasteFisico();
                                    c2 = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDistancia();
                                    cantidad = c1 + c2;
                                    break;
                                case 13:
                                    cantidad = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDistancia();
                                    break;
                                default:
                                    break;
                            }
                        } else {
                        }
                    }
                }
            } else {
            }
        }
        return cantidad;
    }

    public static LinkedList<LinkedList> listaRO = new LinkedList<>();

    public static void ordenDatos(int opcion) throws IOException {
        double datos[] = new double[listaRecorridos.size()];

        listaRO.clear();
        for (int i = 0; i < listaRecorridos.size(); i++) {
            double numero = (double) listaRecorridos.get(i).getLast();
            System.out.println(numero);
            datos[i] = numero;
        }
        if (opcion == 1 | opcion == 2 | opcion == 3 | opcion == 4 | opcion == 5 | opcion == 6) {
            for (int x = 0; x < datos.length; x++) {
                for (int i = 0; i < datos.length - x - 1; i++) {
                    if (datos[i] > datos[i + 1]) {
                        double tmp = datos[i + 1];
                        datos[i + 1] = datos[i];
                        datos[i] = tmp;
                    }
                }
            }
        } else {
            for (int x = 0; x < datos.length; x++) {
                for (int i = 0; i < datos.length - x - 1; i++) {
                    if (datos[i] < datos[i + 1]) {
                        double tmp = datos[i + 1];
                        datos[i + 1] = datos[i];
                        datos[i] = tmp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(datos));

        for (int j = 0; j < datos.length; j++) {
            double numeroOrden = datos[j];
            for (int i = 0; i < listaRecorridos.size(); i++) {
                double numero = (double) listaRecorridos.get(i).getLast();
                if (numero == numeroOrden) {
                    listaRO.add(listaRecorridos.get(i));
                } else {
                }
            }
        }
        areaListas.setText("");
        System.out.println("Lista RO");
        for (int i = 0; i < listaRO.size(); i++) {
            areaListas.append("\n"+listaRO.get(i));
        }
        System.out.println(listaRO.toString());
        llenarArbol();
    }

    public static void llenarArbol() throws IOException {
        arbolB arbol = new arbolB(5);//  B-Tree Tree with order  N is created.
        for (int i = 0; i < listaRO.size(); i++) {
            double numero = (double) listaRO.get(i).getLast();
            arbol.insertar(arbol, numero);
        }
        arbol.imprimir(arbolB.raizArbol);
        System.out.println(listaArbol.toString());
    }
}
