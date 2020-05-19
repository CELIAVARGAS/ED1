/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import static Archivos.creacionArbol.crearArchivoDotArbol;
import static Archivos.creacionImagen.dibujar;
import static Archivos.escrituraArchivoGrafica.escrituraArchivo;
import static Archivos.recorrido.creacionArbol;
import static Archivos.recorrido.listaRecorridos;
import static Archivos.recorrido.recorridoGrafo;
import Grafo.arista;
import Grafo.grafo;
import Grafo.listaCiudad;
import Grafo.nodoG;
import arbol.creacionArbol;
import interfaz.Pantalla;
import static interfaz.Pantalla.opcion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import static Archivos.creacionArchivoDot.crearArchivoDotIMagen;
import arbol.arbolB;
import static arbol.arbolB.imprimir;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author esmeralda
 */
public class lectura_Archivo {

    //lista de ciudades
    public static listaCiudad listaCiudades = new listaCiudad();
    public static LinkedList<String> listaCiudadesGrafica = new LinkedList<>();
    public static LinkedList<String> listaLineas = new LinkedList<String>();
    public static nodoG ciudad;
    public static grafo grafoCompleto;

    public static void abrirArchivo() throws FileNotFoundException, Exception {
        String linea = " ";
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser(".");
        int valor = fileChooser.showOpenDialog(fileChooser);
        if (valor == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            try {
                //Creamos un solo grafo
                listaCiudades.eliminar();
                listaLineas.clear();
                listaCiudadesGrafica.clear();
                File f = new File(ruta);
                entrada = new Scanner(f);
                int numeroLinea = 1;
                while (entrada.hasNext()) {
                    linea = entrada.nextLine();
                    //analisamos cada linea y creamos los nodos ciudades
                    analisisEntrada(linea, numeroLinea);
                    numeroLinea++;
                    /*                System.out.println(listaCiudades.size());
                    System.out.println(listaCiudades.toString());
                     */                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
            //despues de analizar cada linea agregamos las aristas a los nodos
            agregacionAristasANodos();
            creacionGrafo();
            recorridoGrafo("XELA", "PETEN");
            System.out.println("Lista de rutas");
            for (int i = 0; i < listaRecorridos.size(); i++) {
                System.out.println(listaRecorridos.get(i).toString());
            }
        } else {
            System.out.println("No se ha seleccionado ningún fichero");
        }
        opcion = 5;
        creacionArbol(1);
        crearArchivoDotIMagen(5);
        crearArchivoDotArbol();
        //    imprimir(arbolB.raizArbol);    
/*
        String ruta = "EstructuraArbol.dot";
        File file = new File(ruta);
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("}");
        bw.close();
*/
        dibujar("EstructuraGrafo.dot", "imagen.png");
        dibujar("EstructuraArbol.dot", "imagen2.png");
    }

    public static String obtenerNombreCiudad(String ciudad) {
        String ciudadR = "";
        String[] arregloLinea = ciudad.split("<");
        if (arregloLinea == null) {
        } else {
            if (arregloLinea.length == 2) {
                String dato1 = arregloLinea[1];
                String[] arregloLinea2 = dato1.split(">");
                if (arregloLinea2 == null) {
                } else {
                    ciudadR = arregloLinea2[0];
                }
            } else {
            }
        }
        return ciudadR;
    }

    public static void analisisEntrada(String linea, int numeroLinea) throws Exception {

        String[] arregloLinea = linea.split("\\|");
        //linea con parametros completos
        if (arregloLinea.length == 7) {
            //verificamos cada ciudad tanto destino como origen
            for (int j = 0; j < 2; j++) {
                String ciudadLeida = obtenerNombreCiudad(arregloLinea[j]);
                if (listaCiudades.esVacia()) {
                    //llenamos en caso este vacia la lista
                    ciudad = new nodoG(ciudadLeida);
                    listaCiudades.agregarAlFinal(ciudad);
                } else {
                    boolean encontrado = false;
                    for (int i = 0; i < listaCiudades.getTamanio(); i++) {
                        String ciudadIterada = listaCiudades.getValor(i).getCiudad();
                        if (ciudadIterada.equals(ciudadLeida)) {
                            //ya tenemos en la lista la ciudad
                            encontrado = true;
                            break;
                        } else {
                            encontrado = false;
                        }
                    }
                    if (encontrado == false) {
                        ciudad = new nodoG(ciudadLeida);
                        listaCiudades.agregarAlFinal(ciudad);
                    } else {
                    }
                }
            }
            //agregamos linea correcta  a lista de lineas para despues agregar aristas 
            listaLineas.add(linea);
        } else if (linea.isEmpty()) {//Linea vacia
        } else {//Linea con parametros extras o menores
            Pantalla.areaErroresPantalla.append("\n Error en  linea " + numeroLinea + " cantidad de parametros erroneos");
        }

    }

    public static void agregacionAristasANodos() throws Exception {
        //leemos cada linea obtenemos nodos
        for (int i = 0; i < listaLineas.size(); i++) {
            //separamos cada dato de lineas y lo buscamos en la lista nodos , despues de encontrar creamos los aristas
            String linea = listaLineas.get(i);
            String[] arregloLinea = linea.split("\\|");

            String ciudadOrigen = obtenerNombreCiudad(arregloLinea[0]);
            String ciudadDestino = obtenerNombreCiudad(arregloLinea[1]);
            double distanciaArista = conversionDouble(arregloLinea[2]);
            double tiempoVehiculoArista = conversionDouble(arregloLinea[3]);
            double tiempoPersonaArista = conversionDouble(arregloLinea[4]);
            double combustibleArista = conversionDouble(arregloLinea[5]);
            double desgasteFisicoArista = conversionDouble(arregloLinea[6]);

            nodoG ciudadO = null;
            nodoG ciudadD = null;

            for (int j = 0; j < listaCiudades.getTamanio(); j++) {
                String ciudadIterada = listaCiudades.getValor(j).getCiudad();
                if (ciudadIterada.equals(ciudadOrigen)) {
                    ciudadO = listaCiudades.getValor(j);
                }
                if (ciudadIterada.equals(ciudadDestino)) {
                    ciudadD = listaCiudades.getValor(j);
                } else {
                }
            }

            if (ciudadD == null && ciudadO == null) {
            } else {
                ciudadO.agregarArista(new arista(ciudadO, ciudadD, distanciaArista, tiempoVehiculoArista,
                        tiempoPersonaArista, combustibleArista, desgasteFisicoArista));
                //enviamos datos para llenar el archiv;o grafo para la imagen
                //              listaCiudadesGrafica.add(ciudadOrigen+","+ciudadDestino);
            }
        }
    }

    public static double conversionDouble(String dato) {
        double cantidad = 0;
        String[] arregloLinea = dato.split("<");
//        System.out.println(Arrays.toString(arregloLinea));
        if (arregloLinea == null) {
        } else {
            if (arregloLinea.length == 2) {
                String dato1 = arregloLinea[1];
                String[] arregloLinea2 = dato1.split(">");
                if (arregloLinea2 == null) {
                } else {
                    cantidad = Double.parseDouble(arregloLinea2[0]);
//                    System.out.println(cantidad);
                }
//                System.out.println(Arrays.toString(arregloLinea2));
            } else {
            }
        }
        return cantidad;
    }

    public static void creacionGrafo() throws Exception {
        grafoCompleto = new grafo();

        for (int i = 0; i < listaCiudades.getTamanio(); i++) {
            nodoG nodoLista = listaCiudades.getValor(i);
            grafoCompleto.agregarNodo(nodoLista);
        }
//grafoCompleto.listar();
        for (int i = 0; i < grafoCompleto.getNodes().size(); i++) {
            System.out.println(grafoCompleto.getNodes().get(i).getCiudad());
            if (grafoCompleto.getNodes().get(i).getAristas() == null) {
                System.out.println("No hay aristas");
            } else {
                grafoCompleto.getNodes().get(i).getAristas().listar();
//            System.out.println(grafoCompleto.getNodes().get(i).getAristas().);
            }
        }
//        System.out.println(grafoCompleto.toString());            
    }
}
