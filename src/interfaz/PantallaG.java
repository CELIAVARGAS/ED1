/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import static Archivos.creacionArbol.crearArchivoDotArbol;
import static Archivos.creacionArchivoDot.crearArchivoDotIMagen;
import static Archivos.creacionImagen.dibujar;
import Archivos.lectura_Archivo;
import static Archivos.lectura_Archivo.abrirArchivo;
import static Archivos.lectura_Archivo.grafoCompleto;
import static Archivos.lectura_Archivo.listaCiudades;
import static Archivos.recorrido.creacionArbol;
import static Archivos.recorrido.recorridoGrafo;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author esmeralda
 */
public class PantallaG extends javax.swing.JFrame {

    public static int opcion = 0;
    public static String ciudadINicio = "";
    public static String ciudadDestino = "";

    /**
     * Creates new form PantallaG
     */
    public PantallaG() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        comboBOxCIudades = new javax.swing.JComboBox<>();
        comboBoxMejoresRutas = new javax.swing.JComboBox<>();
        comboBoxPeoresRUtas = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        comboBoxRutasFavoritas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaErroresPantalla = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        panelG = new javax.swing.JPanel();
        botonG = new javax.swing.JButton();
        origen = new javax.swing.JComboBox<>();
        destino = new javax.swing.JComboBox<>();
        origenLabel = new javax.swing.JLabel();
        destinoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.black);

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.pink);
        jLabel1.setText("CIUDAD ORIGEN");

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.pink);
        jLabel2.setText("CIUDAD DESTINO");

        jButton2.setText("CALCULAR RUTAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MEJOR RUTA (Gasolina Vehiculo)", "MEJOR RUTA (Distancia Vehiculo)", "MEJOR RUTA (Distancia Caminando)", "MEJOR RUTA (Desgaste Fisico)", "MEJOR RUTA (Gasolina y Distancia Vehiculo)", "MEJOR RUTA (Desgaste Fisico y Distancia Caminando)", "PEOR RUTA (Gasolina Vehiculo)", "PEOR RUTA (Distancia Vehiculo)", "PEOR RUTA (Distancia Caminando)", "PEOR RUTA (Desgaste Fisico)", "PEOR RUTA (Gasolina y Distancia Vehiculo)", "PEOR RUTA (Desgaste Fisico y Distancia Caminando)" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        comboBOxCIudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBOxCIudadesActionPerformed(evt);
            }
        });

        comboBoxMejoresRutas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxMejoresRutasItemStateChanged(evt);
            }
        });
        comboBoxMejoresRutas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMejoresRutasActionPerformed(evt);
            }
        });

        comboBoxPeoresRUtas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxPeoresRUtasItemStateChanged(evt);
            }
        });
        comboBoxPeoresRUtas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPeoresRUtasActionPerformed(evt);
            }
        });

        jButton4.setText("DESPLAZAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        comboBoxRutasFavoritas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRutasFavoritasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel3.setForeground(java.awt.Color.cyan);
        jLabel3.setText("MEJORES RUTAS");

        jLabel4.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(java.awt.Color.cyan);
        jLabel4.setText("PEORES RUTAS");

        jLabel5.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(java.awt.Color.cyan);
        jLabel5.setText("TIPO DE RUTA");

        jLabel6.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel6.setForeground(java.awt.Color.cyan);
        jLabel6.setText("RUTAS FAVORITAS");

        jLabel7.setFont(new java.awt.Font("Open Sans", 3, 12)); // NOI18N
        jLabel7.setForeground(java.awt.Color.pink);
        jLabel7.setText("CIUDAD ACTUAL : ");

        jLabel8.setFont(new java.awt.Font("Open Sans", 3, 12)); // NOI18N
        jLabel8.setForeground(java.awt.Color.pink);
        jLabel8.setText("CIUDAD DESTINO : ");

        jLabel9.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel9.setForeground(java.awt.Color.pink);
        jLabel9.setText("CIUDADES");

        jLabel10.setFont(new java.awt.Font("Open Sans", 2, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.yellow);
        jLabel10.setText("* SELECCIONE MEJOR/PEOR/FAVORITA RUTA PARA DESPLAZARSE DE UNA CIUDAD A OTRA");

        jButton1.setText("CARGAR ARCHIVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        areaErroresPantalla.setColumns(20);
        areaErroresPantalla.setRows(5);
        jScrollPane3.setViewportView(areaErroresPantalla);

        jLabel11.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.red);
        jLabel11.setText("ERRORES");

        jButton3.setText("CARGAR GRAFO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        botonG.setBackground(java.awt.Color.black);
        botonG.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonG.setFocusPainted(false);
        botonG.setFocusable(false);
        botonG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGLayout = new javax.swing.GroupLayout(panelG);
        panelG.setLayout(panelGLayout);
        panelGLayout.setHorizontalGroup(
            panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGLayout.createSequentialGroup()
                .addComponent(botonG, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        panelGLayout.setVerticalGroup(
            panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonG, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );

        origenLabel.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        origenLabel.setForeground(java.awt.Color.green);
        origenLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        destinoLabel.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        destinoLabel.setForeground(java.awt.Color.green);
        destinoLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(origen, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addComponent(comboBoxMejoresRutas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(comboBoxRutasFavoritas, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboBOxCIudades, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(origenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(destinoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxPeoresRUtas, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jButton1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButton3)
                            .addComponent(destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxMejoresRutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxPeoresRUtas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(comboBoxRutasFavoritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(origenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(destinoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(comboBOxCIudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        lectura_Archivo.ilustrarGrafo();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            abrirArchivo();
        } catch (Exception ex) {
            Logger.getLogger(PantallaG.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboBOxCIudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBOxCIudadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBOxCIudadesActionPerformed

    private void comboBoxPeoresRUtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPeoresRUtasActionPerformed
        LinkedList<String> lista = new LinkedList<String>();
        comboBOxCIudades.removeAllItems();
        lista = (LinkedList<String>) comboBoxPeoresRUtas.getSelectedItem();
        try {
            if (lista.isEmpty()) {
            } else {
                for (int i = 0; i < lista.size() - 1; i++) {
                    System.out.println(lista.get(i));
                    comboBOxCIudades.addItem(lista.get(i).toString());
                }
                listaGeneral = lista;
            }
        } catch (Exception e) {
            System.out.println("ERROR EN PEOR RUTA");

        }
    }//GEN-LAST:event_comboBoxPeoresRUtasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String origen1 = (String) origen.getSelectedItem();
        String destino1 = (String) destino.getSelectedItem();

        try {
            if (origen1.isEmpty() || destino1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese nombres de ciudades a recorrer");
            } else {
                if (origen1.equals(destino1)) {
                    JOptionPane.showMessageDialog(null, "HA LLEGADO A SU DESTINO");
                    origenLabel.setText(ciudadINicio);
                    destinoLabel.setText(ciudadDestino);
                } else {
                    boolean encontrado1 = false, encontrado2 = false;
                    for (int i = 0; i < listaCiudades.getTamanio(); i++) {
                        String ciudad = listaCiudades.getValor(i).getCiudad();
                        if (origen1.equals(ciudad)) {
                            encontrado1 = true;
                        }
                        if (ciudad.equals(destino1)) {
                            encontrado2 = true;
                        } else {
                        }
                    }
                    if (encontrado1 == true && encontrado2 == true) {
                        ciudadINicio = origen1;
                        ciudadDestino = destino1;
                        recorridoGrafo(origen1, destino1);
                        origenLabel.setText(origen1);
                        destinoLabel.setText(destino1);
                        JOptionPane.showMessageDialog(null, "Finalizado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error las ciudades no son validas");
                    }
                }
            }
            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(PantallaG.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGActionPerformed

    String tipoRuta = "";
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int opcion = jComboBox1.getSelectedIndex() + 1;
        System.out.println(opcion);
        try {
            crearArchivoDotIMagen(opcion);
            dibujar("EstructuraGrafo.dot", "imagen.jpg");
            creacionArbol(opcion);
            crearArchivoDotArbol();
            dibujar("EstructuraArbol.dot", "imagen2.jpg");
            switch (opcion) {
                case 1:
                    tipoRuta = "MR Gasolina";
                    break;
                case 2:
                    tipoRuta = "MR Distancia_Vehiculo";
                    break;
                case 3:
                    tipoRuta = "MR Distancia_Caminando";
                    break;
                case 4:
                    tipoRuta = "MR Desgaste_Fisico";
                    break;
                case 5:
                    tipoRuta = "MR Gasolina_Vehiculo";
                    break;
                case 6:
                    tipoRuta = "MR DesgasteF_Caminando";
                    break;

                case 7:
                    tipoRuta = "PR Gasolina";
                    break;
                case 8:
                    tipoRuta = "PR Distancia_Vehiculo";
                    break;
                case 9:
                    tipoRuta = "PR Distancia_Caminando";
                    break;
                case 10:
                    tipoRuta = "PR Desgaste_Fisico";
                    break;
                case 11:
                    tipoRuta = "PR Gasolina_Vehiculo";
                    break;
                case 12:
                    tipoRuta = "PR DesgasteF_Caminando";
                    break;
                default:
                    tipoRuta = "";
                    break;
            }
            System.out.println(tipoRuta);

            /*            ImageIcon iconoOriginal = new ImageIcon("imagen.jpg");
            int ancho = botonI.getWidth();
            int alto = botonI.getHeight();
            ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
            botonI.setIcon(iconoEscala);
             */
 /*            ImageIcon iconoOriginal2 = new ImageIcon("imagen2.jpg");
            int ancho2 = jButton4.getWidth();
            int alto2 = jButton4.getHeight();
            ImageIcon iconoEscala2 = new ImageIcon(iconoOriginal2.getImage().getScaledInstance(ancho2, alto2, java.awt.Image.SCALE_DEFAULT));
            jButton4.setIcon(iconoEscala2);
             */
        } catch (Exception ex) {
            Logger.getLogger(PantallaG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String ciudadD2 = (String) comboBOxCIudades.getSelectedItem();
        try {
            System.out.println("ciudad inicio " + ciudadINicio);
            if (ciudadINicio.isEmpty() || ciudadD2.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese nombres de ciudades a recorrer");
            } else {
                if (ciudadINicio.equals(ciudadDestino)) {
                    JOptionPane.showMessageDialog(null, "HA LLEGADO A SU DESTINO");
                    origenLabel.setText(ciudadINicio);
                    destinoLabel.setText(ciudadDestino);
                    controlRutasFavoritas(listaGeneral, tipoRuta);
                } else {
                    boolean encontrado1 = false, encontrado2 = false;
                    String origen1 = ciudadINicio;
                    String destino1 = ciudadD2;
                    for (int i = 0; i < listaCiudades.getTamanio(); i++) {
                        String ciudad = listaCiudades.getValor(i).getCiudad();
                        if (origen1.equals(ciudad)) {
                            encontrado1 = true;
                        }
                        if (ciudad.equals(destino1)) {
                            encontrado2 = true;
                        } else {
                        }
                    }

                    if (encontrado1 == true && encontrado2 == true) {
                        for (int i = 0; i < grafoCompleto.getNodes().size(); i++) {
                            String ciudad = grafoCompleto.getNodes().get(i).getCiudad();
                            System.out.println("ciudad " + ciudad);
                            if (ciudad.equals(origen1)) {
                                boolean encontrado = false;
                                //verificamos si es adyacente la ciudad 
                                if (grafoCompleto.getNodes().get(i).getAristas() == null) {
                                } else {
                                    for (int j = 0; j < grafoCompleto.getNodes().get(i).getAristas().getTamanio(); j++) {
                                        String arista = grafoCompleto.getNodes().get(i).getAristas().getValor(j).getDestino().getCiudad();
                                        /*     for (int k = 0; k < arista.getAristas().getTamanio(); k++) {
                                    String aristaD= arista.getAristas().getValor(k).getDestino().getCiudad();
                                }
                                         */ System.out.println("arista " + arista);
                                        if (arista.equals(destino1)) {
                                            encontrado = true;
                                            break;
                                        } else {
                                        }
                                    }
                                    if (encontrado == true) {
                                        recorridoGrafo(destino1, ciudadDestino);
                                        ciudadINicio = destino1;
                                        origenLabel.setText(destino1);
                                        destinoLabel.setText(ciudadDestino);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "La ciudad " + destino1 + " no es adyacente de " + origen1);
                                    }
                                    break;
                                }
                            } else {
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error las ciudades no son validas");
                    }
                }
            }
            // TODO add your handling code here:
        } catch (Exception ex) {

            System.out.println("ERROR EN DESPLAZAMIENTO");
            Logger.getLogger(PantallaG.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    LinkedList< String> listaGeneral;
    private void comboBoxMejoresRutasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMejoresRutasActionPerformed
        LinkedList<String> lista = new LinkedList<String>();
        comboBOxCIudades.removeAllItems();
        lista = (LinkedList<String>) comboBoxMejoresRutas.getSelectedItem();
        try {
            if (lista.isEmpty()) {
            } else {
                for (int i = 0; i < lista.size() - 1; i++) {
                    System.out.println(lista.get(i));
                    comboBOxCIudades.addItem(lista.get(i).toString());
                }
                listaGeneral = lista;
            }
        } catch (Exception e) {
            System.out.println("ERROR EN MEJOR RUTA");

        }

    }//GEN-LAST:event_comboBoxMejoresRutasActionPerformed

    private void comboBoxRutasFavoritasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRutasFavoritasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxRutasFavoritasActionPerformed

    private void comboBoxMejoresRutasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxMejoresRutasItemStateChanged
        // TODO add your handling code here:
        //obtener la lista del combo y mostrar cada elemento en el combo de ciudades.

    }//GEN-LAST:event_comboBoxMejoresRutasItemStateChanged

    private void comboBoxPeoresRUtasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxPeoresRUtasItemStateChanged


    }//GEN-LAST:event_comboBoxPeoresRUtasItemStateChanged

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    LinkedList<String> listaTemporal = new LinkedList<String>();
    LinkedList<LinkedList> listasFavoritas = new LinkedList<LinkedList>();

    public void controlRutasFavoritas(LinkedList<String> listaIngresada, String tipo) {
        listaTemporal.clear();
        boolean encontrado = false;
        String contador = "1";
        listaIngresada.removeLast();
        if (listasFavoritas.isEmpty()) {
            LinkedList<String> listaA = listaIngresada;
//            listaA.add(tipoRuta);
            listaA.add(contador);
            listasFavoritas.add(listaA);
        } else {
            for (int i = 0; i < listasFavoritas.size(); i++) {
                LinkedList<String> listaAuxiliar = listasFavoritas.get(i);
                //obtenemos solo parate que nos interesa
                contador = listaAuxiliar.get(listaAuxiliar.size() - 1);
    //            String tipoRuta = listaAuxiliar.get(listaAuxiliar.size() - 2);
                int contadorRuta=1;
                System.out.println("Contador " + contador);
                try {
                    contadorRuta = Integer.parseInt(contador)+1;
                    contador = String.valueOf(contadorRuta);
                } catch (Exception e) {
                    contadorRuta = 1;
                    contador = "1";
                }
                for (int j = 0; j < listaAuxiliar.size() - 1; j++) {

                    System.out.println("DATOS DE FILA  " + listaAuxiliar.get(j));
                    listaTemporal.add(listaAuxiliar.get(j));
                }

                System.out.println("LI "+listaIngresada.toString());
                System.out.println("LT "+listaTemporal.toString());

                //verificamos si 
                if (listaTemporal.equals(listaIngresada)) {
                    System.out.println("datos iguales en lista");

                    listasFavoritas.remove(listaAuxiliar);
                    LinkedList<String> listaA = listaIngresada;
  //                  listaA.add(tipoRuta);
                    listaA.add(contador);
                    listasFavoritas.add(listaA);
                    encontrado = true;
                    break;
                } else {
                }
            }

            if (encontrado == false) {
                System.out.println("datos no son iguales en lista");
                //ingresamos nueva lista
                LinkedList<String> listaA = listaIngresada;
//                listaA.add(tipoRuta);
                listaA.add("1");
                listasFavoritas.add(listaA);
            }

        }
        comboBoxRutasFavoritas.removeAllItems();
        for (int i = 0; i < listasFavoritas.size(); i++) {
            LinkedList<String> lista = listasFavoritas.get(i);
            comboBoxRutasFavoritas.addItem(lista);
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea areaErroresPantalla;
    public static javax.swing.JButton botonG;
    private javax.swing.JComboBox<String> comboBOxCIudades;
    public static javax.swing.JComboBox<LinkedList> comboBoxMejoresRutas;
    public static javax.swing.JComboBox<LinkedList> comboBoxPeoresRUtas;
    public static javax.swing.JComboBox<LinkedList> comboBoxRutasFavoritas;
    public static javax.swing.JComboBox<String> destino;
    private javax.swing.JLabel destinoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JComboBox<String> origen;
    private javax.swing.JLabel origenLabel;
    private javax.swing.JPanel panelG;
    // End of variables declaration//GEN-END:variables
}