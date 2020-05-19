/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import static Archivos.lectura_Archivo.grafoCompleto;
import static Archivos.recorrido.listaRO;
import arbol.arbolB;
import static arbol.arbolB.imprimir;
import static arbol.arbolB.listaArbol;
import arbol.nodoArbol;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author esmeralda
 */
public class creacionArbol {

    public static void crearArchivoDotArbol() throws IOException {
        String ruta = "EstructuraArbol.dot";
        File file = new File(ruta);
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("\n digraph grafica{\n"
                + " node [shape=rectangle];\n"
                + " node [style=filled];\n"
                + " node [fillcolor=\"#EEEEEE\"];\n"
                + " node [color=\"#EEEEEE\"];\n"
                + " edge [color=\"#31CEF0\"];");
        for (int i = 0; i < listaArbol.size(); i++) {
            String dato = listaArbol.get(i);
            double dato1 = Double.parseDouble(dato);
            for (int j = 0; j < listaRO.size(); j++) {
                double numero = (double) listaRO.get(j).getLast();
                if (j == listaRO.size() - 1) {
                    if (dato1 == numero) {
                        String linea = listaRO.get(j).toString();
                       String linea2=conversionLinea(linea);
                        System.out.println(linea2);
                        bw.write("\n" + linea2);
                    } else {
                    }
                } else {
                    if (dato1 == numero) {
                        String linea = listaRO.get(j).toString();
                       String linea2=conversionLinea(linea);
                        System.out.println(linea2);
                        bw.write("\n" + linea2 + "->");
                    } else {
                    }
                }
            }
        }
        bw.write("\nrankdir=LR;\n"
                + "}");
        bw.close();
    }

    public static String conversionLinea(String linea) {
        String linea2 = linea.replace(',', ' ');
        String linea3 = linea2.replace(' ', '_');
        String linea4 = linea3.replace('[', ' ');
        String linea5 = linea4.replace(']', ' ');
        int numero=linea5.indexOf('.');
        String linea6= linea5.substring(0,numero);
        return linea6;
    }
}
