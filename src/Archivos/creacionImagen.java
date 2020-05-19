/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

/**
 *
 * @author esmeralda
 */
public class creacionImagen {

    public static  void dibujar(String direccionDot, String direccionPng) {
        try {
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tjpg", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
