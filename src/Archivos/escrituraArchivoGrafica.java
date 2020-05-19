/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/**
 *
 * @author esmeralda
 */
public class escrituraArchivoGrafica {
    public static void escrituraArchivo(String contenido){
         try {
            String ruta = "EstructuraGrafo.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("\n"+contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
