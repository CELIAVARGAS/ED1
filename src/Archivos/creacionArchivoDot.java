/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import static Archivos.lectura_Archivo.grafoCompleto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author esmeralda
 */
public class creacionArchivoDot {

    public static void crearArchivoDotIMagen(int opcion) {
        try {
            String ruta = "EstructuraGrafo.dot";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("digraph G \n"
                    + "{\n"
                    + " node [shape=circle];\n"
                    + " node [style=filled];\n"
                    + " node [fillcolor=\"#EEEEEE\"];\n"
                    + " node [color=\"#EEEEEE\"];\n"
                    + " edge [color=\"#31CEF0\"];");

//grafoCompleto.listar();
            for (int i = 0; i < grafoCompleto.getNodes().size(); i++) {
                String ciudadOrigen = grafoCompleto.getNodes().get(i).getCiudad();
                if (grafoCompleto.getNodes().get(i).getAristas() == null) {
              //      System.out.println("No hay aristas");
                } else {
                    for (int j = 0; j < grafoCompleto.getNodes().get(i).getAristas().getTamanio(); j++) {
                        String ciudadDestino = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDestino().getCiudad();
                        double distancia = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDistancia();
                        double tiempoV = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getTiempoVehiculo();
                        double tiempoP = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getTiempoVehiculo();
                        double combustible = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getGasolina();
                        double desgasteF = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDesgasteFisico();
                        switch (opcion) {
                            case 1:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label=\"C  " + combustible + " \"];");
                                break;
                            case 2:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label=\"TV  " + tiempoV + " \"];");
                                break;
                            case 3:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label=\"TP  " + tiempoP + " \"];");
                                break;
                            case 4:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label=\"DF  " + desgasteF + " \"];");
                                break;
                            case 5:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label= \"C  " + combustible
                                        + " D " + distancia + " \"];");
                                break;
                            case 6:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label= \"DF  " + desgasteF
                                        + " D " + distancia + " \"];");
                                break;
                            case 7:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label=\"C  " + combustible + " \"];");
                                break;
                            case 8:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label=\"TV  " + tiempoV + " \"];");
                                break;
                            case 9:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label=\"TP  " + tiempoP + " \"];");
                                break;
                            case 10:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label=\"DF  " + desgasteF + " \"];");
                                break;
                            case 11:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label= \"C  " + combustible
                                        + " D " + distancia + " \"];");
                                break;
                            case 12:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label= \"DF  " + desgasteF
                                        + " D " + distancia + " \"];");
                                break;
                            case 13:
                                bw.write("\n" + ciudadOrigen + "->" + ciudadDestino + "[label= \"D" + distancia + " \"];");
                                break;
                        }
                    }
                }
            }
            bw.write("\n rankdir=LR;\n"
                    + "\n}");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
