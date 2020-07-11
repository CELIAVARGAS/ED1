/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author esmeralda
 */
public class creacionImagen {

    public static void dibujar(String direccionDot, String direccionPng) {
        ProcessBuilder pbuilder = null;
        try {
            pbuilder = new ProcessBuilder("dot", "-Tjpg", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
/*        if (pbuilder.redirectErrorStream() == true) {

        } else {

        }*/
    }
}
