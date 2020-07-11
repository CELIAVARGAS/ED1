/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import static Archivos.creacionArbol.crearArchivoDotArbol;
import static Archivos.creacionArchivoDot.crearArchivoDotIMagen;
import static Archivos.creacionImagen.dibujar;
import static Archivos.escrituraArchivoGrafica.escrituraArchivo;
import static Archivos.recorrido.creacionArbol;
import static Archivos.recorrido.listaRecorridos;
import static Archivos.recorrido.recorridoGrafo;
import Grafo.arista;
import Grafo.grafo;
import Grafo.listaCiudad;
import Grafo.nodoG;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import arbol.arbolB;
import static arbol.arbolB.imprimir;
import interfaz.PantallaG;
import static interfaz.PantallaG.areaErroresPantalla;
import static interfaz.PantallaG.botonG;
import static interfaz.PantallaG.destino;
import static interfaz.PantallaG.origen;
import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
        PantallaG.areaErroresPantalla.setText("");
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
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
            File imagen = new File("imagen.jpg");
//            FileInputStream readImage = new FileInputStream(imagen);
//            readImage.close();
            imagen.delete();

            //despues de analizar cada linea agregamos las aristas a los nodos
            agregarAristasANodos1();
            creacionGrafo();
            crearArchivoDotIMagen(13);
            dibujar("EstructuraGrafo.dot", "imagen.jpg");
            JOptionPane.showMessageDialog(null, "ARCHIVO CARGADO");

        } else {
            areaErroresPantalla.append("\nNo se ha seleccionado ningún fichero");
            System.out.println("No se ha seleccionado ningún fichero");
        }
    }

    public static void ilustrarGrafo() {
        ImageIcon iconoOriginal = new ImageIcon("imagen.jpg");
        int ancho = botonG.getWidth();
        int alto = botonG.getHeight();
        ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
        botonG.setIcon(iconoEscala);
        botonG.repaint();

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
                String ciudadLeida = arregloLinea[j];
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
            areaErroresPantalla.append("\n Error en  linea " + numeroLinea + " cantidad de parametros erroneos");
        }

    }

    public static void agregarAristasANodos1() throws Exception {

        //leemos cada linea obtenemos nodos
        for (int i = 0; i < listaLineas.size(); i++) {
            //separamos cada dato de lineas y lo buscamos en la lista nodos , despues de encontrar creamos los aristas
            String linea = listaLineas.get(i);
            String[] arregloLinea = linea.split("\\|");

            String ciudadOrigen = arregloLinea[0];
            String ciudadDestino = arregloLinea[1];
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
        try {
            cantidad = Double.parseDouble(dato);
        } catch (Exception e) {
            areaErroresPantalla.append("\n Error en  conversion de dato " + dato);
        }/*        String[] arregloLinea = dato.split("<");
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
        }*/
        return cantidad;
    }

    public static void creacionGrafo() throws Exception {
        grafoCompleto = new grafo();

        origen.removeAllItems();
        destino.removeAllItems();
        for (int i = 0; i < listaCiudades.getTamanio(); i++) {
            nodoG nodoLista = listaCiudades.getValor(i);
            grafoCompleto.agregarNodo(nodoLista);
        }
        for (int i = 0; i < grafoCompleto.getNodes().size(); i++) {
            System.out.println(grafoCompleto.getNodes().get(i).getCiudad());
            String ciudadE=grafoCompleto.getNodes().get(i).getCiudad(); 
            //agregamos a combox de ciudades esta lista
            origen.addItem(ciudadE);
            destino.addItem(ciudadE);

            if (grafoCompleto.getNodes().get(i).getAristas() == null) {
                //      System.out.println("No hay aristas");
            } else {
                grafoCompleto.getNodes().get(i).getAristas().listar();
//            System.out.println(grafoCompleto.getNodes().get(i).getAristas().);
            }
        }
//        System.out.println(grafoCompleto.toString());            
    }
}
