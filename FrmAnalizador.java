/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java_cup.runtime.Symbol;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class FrmAnalizador extends javax.swing.JFrame {

    public DefaultTableModel mt = new DefaultTableModel();

    public FrmAnalizador() {

        setUndecorated(true);

        initComponents();

        /////////////////////////////// ESTILOS ///////////////////////////////
        BotonAnalisis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BotonAnalisis.setOpaque(false);
        BotonAnalisis.setForeground(Color.BLACK);
        BotonAnalisis.setFont(new Font("Arial", Font.BOLD, 20));
        BotonAnalisis.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        BotonAnalisis.setBackground(new Color(0, 0, 51, 0));
        BotonAnalisis.setBounds(20, 500, 92, 30);

        BotonSintactico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BotonSintactico.setOpaque(false);
        BotonSintactico.setForeground(Color.BLACK);
        BotonSintactico.setFont(new Font("Arial", Font.BOLD, 20));
        BotonSintactico.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        BotonSintactico.setBackground(new Color(0, 0, 51, 0));
        BotonSintactico.setBounds(20, 500, 92, 30);

        btnArchivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnArchivo.setOpaque(false);
        btnArchivo.setForeground(Color.BLACK);
        btnArchivo.setFont(new Font("Arial", Font.BOLD, 20));
        btnArchivo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        btnArchivo.setBackground(new Color(0, 0, 51, 0));
        btnArchivo.setBounds(20, 500, 92, 30);

        Borrar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Borrar1.setOpaque(false);
        Borrar1.setForeground(Color.BLACK);
        Borrar1.setFont(new Font("Arial", Font.BOLD, 20));
        Borrar1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        Borrar1.setBackground(new Color(0, 0, 51, 0));
        Borrar1.setBounds(20, 500, 92, 30);

        Borrar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Borrar2.setOpaque(false);
        Borrar2.setForeground(Color.BLACK);
        Borrar2.setFont(new Font("Arial", Font.BOLD, 20));
        Borrar2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        Borrar2.setBackground(new Color(0, 0, 51, 0));
        Borrar2.setBounds(20, 500, 92, 30);

        Boton_Intermedio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Boton_Intermedio.setOpaque(false);
        Boton_Intermedio.setForeground(Color.BLACK);
        Boton_Intermedio.setFont(new Font("Arial", Font.BOLD, 15));
        Boton_Intermedio.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        Boton_Intermedio.setBackground(new Color(0, 0, 51, 0));
        Boton_Intermedio.setBounds(20, 500, 92, 30);
        Boton_Intermedio.setVisible(false);

        Boton_Assembler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Boton_Assembler.setOpaque(false);
        Boton_Assembler.setForeground(Color.BLACK);
        Boton_Assembler.setFont(new Font("Arial", Font.BOLD, 15));
        Boton_Assembler.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        Boton_Assembler.setBackground(new Color(0, 0, 51, 0));
        Boton_Assembler.setBounds(20, 500, 92, 30);
        Boton_Assembler.setVisible(false);

        Boton_Objeto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Boton_Objeto.setOpaque(false);
        Boton_Objeto.setForeground(Color.BLACK);
        Boton_Objeto.setFont(new Font("Arial", Font.BOLD, 15));
        Boton_Objeto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        Boton_Objeto.setBackground(new Color(0, 0, 51, 0));
        Boton_Objeto.setBounds(20, 500, 92, 30);
        Boton_Objeto.setVisible(false);

        Boton_Ejecutable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Boton_Ejecutable.setOpaque(false);
        Boton_Ejecutable.setForeground(Color.BLACK);
        Boton_Ejecutable.setFont(new Font("Arial", Font.BOLD, 15));
        Boton_Ejecutable.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        Boton_Ejecutable.setBackground(new Color(0, 0, 51, 0));
        Boton_Ejecutable.setBounds(20, 500, 92, 30);
        Boton_Ejecutable.setVisible(false);

        Boton_Ejecutar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Boton_Ejecutar.setOpaque(false);
        Boton_Ejecutar.setForeground(Color.BLACK);
        Boton_Ejecutar.setFont(new Font("Arial", Font.BOLD, 15));
        Boton_Ejecutar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        Boton_Ejecutar.setBackground(new Color(0, 0, 51, 0));
        Boton_Ejecutar.setBounds(20, 500, 92, 30);
        Boton_Ejecutar.setVisible(false);

        /////////////////////////// Botones de codigo ////////////////////////////////////
        boton_declaracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton_declaracion.setOpaque(false);
        boton_declaracion.setForeground(Color.BLACK);
        boton_declaracion.setFont(new Font("Arial", Font.BOLD, 15));
        boton_declaracion.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        boton_declaracion.setBackground(new Color(0, 0, 51, 0));
        boton_declaracion.setBounds(20, 500, 92, 30);

        boton_default.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton_default.setOpaque(false);
        boton_default.setForeground(Color.BLACK);
        boton_default.setFont(new Font("Arial", Font.BOLD, 15));
        boton_default.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        boton_default.setBackground(new Color(0, 0, 51, 0));
        boton_default.setBounds(20, 500, 92, 30);

        boton_dowhile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton_dowhile.setOpaque(false);
        boton_dowhile.setForeground(Color.BLACK);
        boton_dowhile.setFont(new Font("Arial", Font.BOLD, 15));
        boton_dowhile.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        boton_dowhile.setBackground(new Color(0, 0, 51, 0));
        boton_dowhile.setBounds(20, 500, 92, 30);

        boton_entradaYSalida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton_entradaYSalida.setOpaque(false);
        boton_entradaYSalida.setForeground(Color.BLACK);
        boton_entradaYSalida.setFont(new Font("Arial", Font.BOLD, 15));
        boton_entradaYSalida.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        boton_entradaYSalida.setBackground(new Color(0, 0, 51, 0));
        boton_entradaYSalida.setBounds(20, 500, 92, 30);

        boton_for.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton_for.setOpaque(false);
        boton_for.setForeground(Color.BLACK);
        boton_for.setFont(new Font("Arial", Font.BOLD, 15));
        boton_for.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        boton_for.setBackground(new Color(0, 0, 51, 0));
        boton_for.setBounds(20, 500, 92, 30);

        boton_if.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton_if.setOpaque(false);
        boton_if.setForeground(Color.BLACK);
        boton_if.setFont(new Font("Arial", Font.BOLD, 15));
        boton_if.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        boton_if.setBackground(new Color(0, 0, 51, 0));
        boton_if.setBounds(20, 500, 92, 30);

        boton_inicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton_inicio.setOpaque(false);
        boton_inicio.setForeground(Color.BLACK);
        boton_inicio.setFont(new Font("Arial", Font.BOLD, 15));
        boton_inicio.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        boton_inicio.setBackground(new Color(0, 0, 51, 0));
        boton_inicio.setBounds(20, 500, 92, 30);

        boton_switch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton_switch.setOpaque(false);
        boton_switch.setForeground(Color.BLACK);
        boton_switch.setFont(new Font("Arial", Font.BOLD, 15));
        boton_switch.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        boton_switch.setBackground(new Color(0, 0, 51, 0));
        boton_switch.setBounds(20, 500, 92, 30);

        boton_while.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        boton_while.setOpaque(false);
        boton_while.setForeground(Color.BLACK);
        boton_while.setFont(new Font("Arial", Font.BOLD, 15));
        boton_while.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
        boton_while.setBackground(new Color(0, 0, 51, 0));
        boton_while.setBounds(20, 500, 92, 30);

        BotonSemantico.setEnabled(false);

        // Configuraciones por defecto del frame
        setTitle("Analizador de C++");

        // logo
//        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("../Compilador/src/Imagenes/logo.png"))).getImage());
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setAutoRequestFocus(false);
//        setResizable(false);
//        setBounds(0, 0, 1500, 900);
//        setLocationRelativeTo(null);

        ////////////////////////////////////////////
        JLabel lblTitulo = new JLabel("Analizador");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(Color.BLACK);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 38));
        lblTitulo.setBounds(0, 50, 1200, 40);
        this.add(lblTitulo);

        // Boton para cerrar el programa
        JButton btnCerrar = new JButton("X");
        btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });
        btnCerrar.setOpaque(false);
        btnCerrar.setForeground(Color.BLACK);
        btnCerrar.setFont(new Font("Arial", Font.BOLD, 40));
        btnCerrar.setBorder(null);
        btnCerrar.setBackground(new Color(0, 0, 51, 0));
        btnCerrar.setBounds(40, 40, 40, 40);
        this.add(btnCerrar);

        JLabel lblReservasApp = new JLabel("Analizador");
        lblReservasApp.setHorizontalAlignment(SwingConstants.CENTER);
        lblReservasApp.setForeground(SystemColor.controlHighlight);
        lblReservasApp.setFont(new Font("Arial", Font.BOLD, 38));
        lblReservasApp.setBounds(1200, 475, 300, 70);
        this.add(lblReservasApp);

//        JLabel lblLogoBlanco = new JLabel("");
//        lblLogoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
//        lblLogoBlanco.setOpaque(false);
//        lblLogoBlanco.setBounds(1200, 300, 300, 200);
//        lblLogoBlanco.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Mini logo.png")));
//        this.add(lblLogoBlanco);

//        JLabel fondoMorado = new JLabel("");
//        fondoMorado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Fondo azul.jpg")));
//        fondoMorado.setBounds(1200, 0, 300, 900);
//        fondoMorado.setOpaque(true);
//        this.add(fondoMorado);

        JLabel fondoBlanco = new JLabel("");
        fondoBlanco.setBounds(0, 0, 1500, 1000);
        fondoBlanco.setBackground(new Color(213, 226, 247));
        fondoBlanco.setOpaque(true);
        this.add(fondoBlanco);

        /////////////////////////////////// TABLA SEMANTICA //////////////////////////////////////////////
        String ids[] = {"variable", "tipo", "estado", "valor", "tipovalor"};
        mt.setColumnIdentifiers(ids);
        tablaSemantica.setModel(mt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonAnalisis = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Resultado = new javax.swing.JTextArea();
        BotonSintactico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnArchivo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        Borrar1 = new javax.swing.JButton();
        Borrar2 = new javax.swing.JButton();
        Boton_Intermedio = new javax.swing.JButton();
        Boton_Assembler = new javax.swing.JButton();
        Boton_Objeto = new javax.swing.JButton();
        Boton_Ejecutable = new javax.swing.JButton();
        Boton_Ejecutar = new javax.swing.JButton();
        boton_switch = new javax.swing.JButton();
        boton_declaracion = new javax.swing.JButton();
        boton_entradaYSalida = new javax.swing.JButton();
        boton_if = new javax.swing.JButton();
        boton_dowhile = new javax.swing.JButton();
        boton_for = new javax.swing.JButton();
        boton_while = new javax.swing.JButton();
        boton_inicio = new javax.swing.JButton();
        boton_default = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaSemantica = new javax.swing.JTable();
        BotonSemantico = new javax.swing.JButton();
        Borrar3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtSeguimientoSemantico = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonAnalisis.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonAnalisis.setText("Análisis Léxico");
        BotonAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnalisisActionPerformed(evt);
            }
        });

        Resultado.setColumns(20);
        Resultado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Resultado.setRows(5);
        jScrollPane1.setViewportView(Resultado);

        BotonSintactico.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonSintactico.setText("Análisis Sintático");
        BotonSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSintacticoActionPerformed(evt);
            }
        });

        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        btnArchivo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnArchivo.setText("Elegir archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        Borrar1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Borrar1.setText("Limpiar");
        Borrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar1ActionPerformed(evt);
            }
        });

        Borrar2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Borrar2.setText("Limpiar");
        Borrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar2ActionPerformed(evt);
            }
        });

        Boton_Intermedio.setText("Generar código intermedio");
        Boton_Intermedio.setEnabled(false);
        Boton_Intermedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_IntermedioActionPerformed(evt);
            }
        });

        Boton_Assembler.setText("Generar codigo assembler");
        Boton_Assembler.setEnabled(false);
        Boton_Assembler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AssemblerActionPerformed(evt);
            }
        });

        Boton_Objeto.setText("Generar objeto");
        Boton_Objeto.setEnabled(false);
        Boton_Objeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ObjetoActionPerformed(evt);
            }
        });

        Boton_Ejecutable.setText("Generar ejecutable");
        Boton_Ejecutable.setEnabled(false);
        Boton_Ejecutable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EjecutableActionPerformed(evt);
            }
        });

        Boton_Ejecutar.setText("Ejecutar");
        Boton_Ejecutar.setEnabled(false);
        Boton_Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EjecutarActionPerformed(evt);
            }
        });

        boton_switch.setText("Switch");
        boton_switch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_switchActionPerformed(evt);
            }
        });

        boton_declaracion.setText("Declaracion y asignacion");
        boton_declaracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boton_declaracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_declaracionActionPerformed(evt);
            }
        });

        boton_entradaYSalida.setText("IO");
        boton_entradaYSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_entradaYSalidaActionPerformed(evt);
            }
        });

        boton_if.setText("If");
        boton_if.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ifActionPerformed(evt);
            }
        });

        boton_dowhile.setText("Do while");
        boton_dowhile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_dowhileActionPerformed(evt);
            }
        });

        boton_for.setText("For");
        boton_for.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_forActionPerformed(evt);
            }
        });

        boton_while.setText("While");
        boton_while.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_whileActionPerformed(evt);
            }
        });

        boton_inicio.setText("Inicio");
        boton_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_inicioActionPerformed(evt);
            }
        });

        boton_default.setText("Default");
        boton_default.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_defaultActionPerformed(evt);
            }
        });

        tablaSemantica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaSemantica);

        BotonSemantico.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonSemantico.setText("Análisis semántico");
        BotonSemantico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSemanticoActionPerformed(evt);
            }
        });

        Borrar3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Borrar3.setText("Limpiar");
        Borrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Borrar3ActionPerformed(evt);
            }
        });

        txtSeguimientoSemantico.setColumns(20);
        txtSeguimientoSemantico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSeguimientoSemantico.setRows(5);
        txtSeguimientoSemantico.setFocusable(false);
        jScrollPane5.setViewportView(txtSeguimientoSemantico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(Boton_Intermedio)
                .addGap(28, 28, 28)
                .addComponent(Boton_Assembler, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Boton_Objeto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Boton_Ejecutable, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Boton_Ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(boton_default, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                                .addComponent(boton_switch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(boton_dowhile, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                                .addComponent(boton_while, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(boton_for, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(boton_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(boton_declaracion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(boton_entradaYSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(boton_if, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(BotonSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Borrar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)))
                            .addComponent(jScrollPane3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(jScrollPane5))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195)
                        .addComponent(BotonAnalisis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Borrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(BotonSemantico)
                        .addGap(10, 10, 10)
                        .addComponent(Borrar3))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Borrar1)
                        .addComponent(BotonAnalisis)
                        .addComponent(BotonSemantico)
                        .addComponent(Borrar3))
                    .addComponent(btnArchivo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(boton_declaracion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_entradaYSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_if, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_switch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_dowhile, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_while, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_for, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(boton_default, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Borrar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Intermedio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_Assembler, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_Objeto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_Ejecutable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_Ejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void analizarLexico() throws IOException {
        int cont = 1;

        String expr = (String) Resultado.getText();
        Analizador.Lexico lexicos = new Analizador.Lexico(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Analizador.Tokens token = lexicos.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case Break:
                    resultado += "  <Palabra reservada break>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Include:
                    resultado += "  <Palabra reservada include>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Define:
                    resultado += "  <Palabra reservada define>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Case:
                    resultado += "  <Palabra reservada case>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Const:
                    resultado += "  <Palabra reservada const>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Continue:
                    resultado += "  <Palabra reservada continue>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Default:
                    resultado += "  <Palabra reservada Default>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Tdato_Entero:
                    resultado += "  <Tipo de dato entero>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Tdato_byte:
                    resultado += "  <Tipo de dato byte>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Tdato_char:
                    resultado += "  <Tipo de dato char>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Tdato_long:
                    resultado += "  <Tipo de dato long>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Tdato_float:
                    resultado += "  <Tipo de dato float>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Tdato_doble:
                    resultado += "  <Tipo de dato doble>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Switch:
                    resultado += "  <Revervada Switch>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Cadena:
                    resultado += "  <Tipo de dato>\t" + lexicos.lexemas + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexicos.lexemas + "\n";
                    break;
                case Int:
                    resultado += "  <Reservada int>\t" + lexicos.lexemas + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexicos.lexemas + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexicos.lexemas + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexicos.lexemas + "\n";
                    break;
                case For:
                    resultado += "  <Reservada while>\t" + lexicos.lexemas + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexicos.lexemas + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexicos.lexemas + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexicos.lexemas + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexicos.lexemas + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexicos.lexemas + "\n";
                    break;
                case AndBinario:
                    resultado += "  <Operador logico and binario>\t" + lexicos.lexemas + "\n";
                    break;
                case And:
                    resultado += "  <Operador logico and>\t" + lexicos.lexemas + "\n";
                    break;
                case Not:
                    resultado += "  <Operador logico not>\t" + lexicos.lexemas + "\n";
                    break;
                case Or:
                    resultado += "  <Operador logico or>\t" + lexicos.lexemas + "\n";
                    break;
                case OrBinario:
                    resultado += "  <Operador logico orBinario>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexicos.lexemas + "\n";
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexicos.lexemas + "\n";
                    break;
                case Parent_a:
                    resultado += "  <Parentesis de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Parent_c:
                    resultado += "  <Parentesis de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_a:
                    resultado += "  <Corchete de apertura>\t" + lexicos.lexemas + "\n";
                    break;
                case Corchete_c:
                    resultado += "  <Corchete de cierre>\t" + lexicos.lexemas + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexicos.lexemas + "\n";
                    break;

                case Register:
                    resultado += "  <Reservada register>\t" + lexicos.lexemas + "\n";
                    break;

                case Return:
                    resultado += "  <Reservada return>\t" + lexicos.lexemas + "\n";
                    break;

                case Short:
                    resultado += "  <Tipo de dato short>\t" + lexicos.lexemas + "\n";
                    break;

                case Unsigned:
                    resultado += "  <Reservada unsigned>\t" + lexicos.lexemas + "\n";
                    break;

                case Struct:
                    resultado += "  <Reservada struct>\t" + lexicos.lexemas + "\n";
                    break;

                case Typedef:
                    resultado += "  <Reservada typedef>\t" + lexicos.lexemas + "\n";
                    break;

                case Void:
                    resultado += "  <Reservada void>\t" + lexicos.lexemas + "\n";
                    break;

                case Printf:
                    resultado += "  <Función printf>\t" + lexicos.lexemas + "\n";
                    break;

                case Scanf:
                    resultado += "  <Función scanf>\t" + lexicos.lexemas + "\n";
                    break;

                case Cin:
                    resultado += "  <Función cin>\t" + lexicos.lexemas + "\n";
                    break;

                case Cout:
                    resultado += "  <Función cout>\t" + lexicos.lexemas + "\n";
                    break;

                case Using:
                    resultado += "  <Función using>\t" + lexicos.lexemas + "\n";
                    break;

                case Namespace:
                    resultado += "  <Función namespace>\t" + lexicos.lexemas + "\n";
                    break;

                case Std:
                    resultado += "  <Función std>\t" + lexicos.lexemas + "\n";
                    break;

                case String:
                    resultado += "  <Tipo de dato string>\t" + lexicos.lexemas + "\n";
                    break;

                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexicos.lexemas + "\n";
                    break;
                case Punto:
                    resultado += "  <Punto>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Indicador:
                    resultado += "  <Indicador #>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexicos.lexemas + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexicos.lexemas + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexicos.lexemas + " >\n";
                    break;
            }
        }

    }

    private void BotonAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnalisisActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotonAnalisisActionPerformed

    private void Borrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar2ActionPerformed
        txtAnalizarSin.setText(null);
    }//GEN-LAST:event_Borrar2ActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        int cont = 1;
        JFileChooser escoger = new JFileChooser();
        escoger.showOpenDialog(null);
        File arc = new File(escoger.getSelectedFile().getAbsolutePath());

        try {
            String ST = new String(Files.readAllBytes(arc.toPath()));
            Resultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmAnalizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void BotonSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSintacticoActionPerformed

        String ST = Resultado.getText();
        Analizador.Sintaxis s = new Analizador.Sintaxis(new Analizador.LexicoCup(new StringReader(ST)));

        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
            Boton_Intermedio.setEnabled(true);
            BotonSemantico.setEnabled(true);

        } catch (Exception ex) {
            Symbol sym = s.getS();
            if (sym.value == null) {
                txtAnalizarSin.setText("No se ha encontrado el corchete de cierre de una o mas sentencias");
            } else {
                txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            }
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_BotonSintacticoActionPerformed

    public String[] separarCodigo(String codigo) {

        // Insertar espacio a cada simbolo encontrado 
        String textoAlterado = codigo.replaceAll("<=", "≤").replaceAll(">=", "≥");
        textoAlterado = textoAlterado.replaceAll("(\\(|\\)|:|;|,|\\+=|-=|\\*=|/=|%=|\\-|\\+|/\\*|%|=|<|>)", " $1 ");
        textoAlterado = textoAlterado.replaceAll("≤", "<=").replaceAll("≥", ">=");

        // Separar cadena en un string
        textoAlterado = textoAlterado.replaceAll("\\s+", " ").trim();

        List<String> words = new ArrayList<>();
        boolean insideQuotes = false;
        StringBuilder currentWord = new StringBuilder();

        for (char c : textoAlterado.toCharArray()) {
            if (c == '"') {
                insideQuotes = !insideQuotes;
                currentWord.append(c);
            } else if (Character.isWhitespace(c) && !insideQuotes) {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }
            } else {
                currentWord.append(c);
            }
        }

        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        return words.toArray(new String[0]);
        //String[] palabras = textoAlterado.replaceAll("\\s+", " ").trim().split(" ");

    }


    private void Borrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar1ActionPerformed
        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_Borrar1ActionPerformed

    private void Boton_IntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_IntermedioActionPerformed
        try {
            String[] intermedio = {"intermedio.bat"};
            Runtime.getRuntime().exec(intermedio);
            System.out.println("Ejecución del convertidor de código fuente a código intermedio");
            Boton_Assembler.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_Boton_IntermedioActionPerformed

    private void Boton_AssemblerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AssemblerActionPerformed
        try {
            String[] gassembler = {"ensamblador.bat"};
            Runtime.getRuntime().exec(gassembler);
            System.out.println("Ejecucion del convertidor de código intermedio a assembler");
            Boton_Objeto.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_Boton_AssemblerActionPerformed

    private void Boton_ObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ObjetoActionPerformed
        try {
            String[] gobjeto = {"objeto.bat"};
            Runtime.getRuntime().exec(gobjeto);
            System.out.println("Ejecucion del convertiro assembler a objeto");
            Boton_Ejecutable.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_Boton_ObjetoActionPerformed

    private void Boton_EjecutableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EjecutableActionPerformed
        try {
            String[] gejecutable = {"ejecutable.bat"};
            Runtime.getRuntime().exec(gejecutable);
            System.out.println("Ejecución del generador del programa ejecutable");
            Boton_Ejecutar.setEnabled(true);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_Boton_EjecutableActionPerformed

    private void Boton_EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EjecutarActionPerformed
        try {
            String[] comando = {"correr.bat"};
            Runtime.getRuntime().exec(comando);
            System.out.println("Ejecución del programa en el sistema operativo");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_Boton_EjecutarActionPerformed

    private void boton_declaracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_declaracionActionPerformed
        Resultado.setText("using namespace std;\n"
                + "int main()\n"
                + "{\n"
                + "    int a = 5,m,p;\n"
                + "    long b = 5;\n"
                + "    short c = 5;\n"
                + "    float d  = 50.12;\n"
                + "    double e = 5.13;\n"
                + "    string j,k,l;\n"
                + "    char y = 'a', t, f=\"j\";\n"
                + "    char f = 'aa';\n"
                + "    string g = \"aa\";\n"
                + "    bool h = false;\n"
                + "    int a;\n"
                + "    a = 5;\n"
                + "    a = 5.10;\n"
                + "    a = \"Hola\";\n"
                + "    char car = 'c', cara = 'b';\n"
                + "    cara = 'f';\n"
                + "    char car = 'c';\n"
                + "    car = 'e';\n"
                + "    int perro = 10;\n"
                + "    double x = 5.5;\n"
                + "    x = \"hola mundo\";\n"
                + "    x = 'r';\n"
                + "    x = 10.3;\n"
                + "    int a = 5, b, c;\n"
                + "    char h;\n"
                + "    h = \"Hola Mundo Cruel\";\n"
                + "    string t = \"Hola\", y = \"a\", carlos = \"perro\";\n"
                + "    t = 5;\n"
                + "    y = \"perro\";\n"
                + "    carlos = 'f';\n"
                + "    int ar = 5, br = 6, cr = 10;\n"
                + "}");

    }//GEN-LAST:event_boton_declaracionActionPerformed

    private void boton_ifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ifActionPerformed
        Resultado.setText("#include <stdlib.h>\n"
                + "#include <iostream>\n"
                + "\n"
                + "using namespace std;\n"
                + "int main()\n"
                + "{\n"
                + "    int var;\n"
                + "    if (var == 5)\n"
                + "    {\n"
                + "        int a = 5;\n"
                + "        string nombre;\n"
                + "\n"
                + "        cout << \"Ingrese un numero: \";\n"
                + "        cin >> numero;\n"
                + "\n"
                + "        cout << \"Ingrese su nombre: \";\n"
                + "        cin >> nombre;\n"
                + "    }\n"
                + "    if (var == 5 && var == var)\n"
                + "    {\n"
                + "        int b = 5;\n"
                + "        string edad;\n"
                + "\n"
                + "        cout << \"Ingrese un numero: \";\n"
                + "        cin >> numero;\n"
                + "\n"
                + "        cout << \"Ingrese su nombre: \";\n"
                + "        cin >> edad;\n"
                + "    }\n"
                + "    else\n"
                + "    {\n"
                + "        int c = 5;\n"
                + "        string genero;\n"
                + "\n"
                + "        cout << \"Ingrese un numero: \";\n"
                + "        cin >> numero;\n"
                + "\n"
                + "        cout << \"Ingrese su nombre: \";\n"
                + "        cin >> genero;\n"
                + "    }\n"
                + "}");
    }//GEN-LAST:event_boton_ifActionPerformed

    private void boton_entradaYSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_entradaYSalidaActionPerformed
        Resultado.setText("#include <stdlib.h>\n"
                + "#include <iostream>\n"
                + "\n"
                + "using namespace std;\n"
                + "int main()\n"
                + "{\n"
                + "    \n"
                + "    cout << \"Hola\";\n"
                + "    cout << \"Hola\"\n"
                + "         << \"Hola\";\n"
                + "    cout << var << hola;\n"
                + "    cout << var << \"Hola\";\n"
                + "    cin >> var;\n"
                + "    cin >> var >> var;\n"
                + "}");
    }//GEN-LAST:event_boton_entradaYSalidaActionPerformed

    private void boton_forActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_forActionPerformed
        Resultado.setText("#include <stdlib.h>\n"
                + "#include <iostream>\n"
                + "\n"
                + "using namespace std;\n"
                + "int main()\n"
                + "{\n"
                + "    for (int i = 0; i <= n; i++)\n"
                + "    {\n"
                + "        int a = 5;\n"
                + "        string nombre;\n"
                + "\n"
                + "        cout << \"Ingrese un numero: \";\n"
                + "        cin >> numero;\n"
                + "\n"
                + "        cout << \"Ingrese su nombre: \";\n"
                + "        cin >> nombre;\n"
                + "    }\n"
                + "    for (i = 2; i > 10; i--)\n"
                + "    {\n"
                + "        int b = 5;\n"
                + "        string genero;\n"
                + "\n"
                + "        cout << \"Ingrese un numero: \";\n"
                + "        cin >> numero;\n"
                + "\n"
                + "        cout << \"Ingrese su nombre: \";\n"
                + "        cin >> nombre;\n"
                + "    }\n"
                + "    for (i = 3; i < n; i++)\n"
                + "    {\n"
                + "        int c = 5;\n"
                + "        string edad;\n"
                + "\n"
                + "        cout << \"Ingrese un numero: \";\n"
                + "        cin >> numero;\n"
                + "\n"
                + "        cout << \"Ingrese su nombre: \";\n"
                + "        cin >> nombre;\n"
                + "    }\n"
                + "}");
    }//GEN-LAST:event_boton_forActionPerformed

    private void boton_switchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_switchActionPerformed
        Resultado.setText("#include <stdlib.h>\n"
                + "#include <iostream>\n"
                + "\n"
                + "using namespace std;\n"
                + "int main()\n"
                + "{\n"
                + "    int a;\n"
                + "    int var;\n"
                + "    switch (var)\n"
                + "    {\n"
                + "    case 5:\n"
                + "        var = 6;\n"
                + "        break;\n"
                + "    default:\n"
                + "        a = 4;\n"
                + "        break;\n"
                + "    }\n"
                + "\n"
                + "    switch (var)\n"
                + "    {\n"
                + "    case \"hola\":\n"
                + "        var = 2;\n"
                + "        break;\n"
                + "    case 'h':\n"
                + "        var = 1;\n"
                + "        break;\n"
                + "    default:\n"
                + "        a = 3;\n"
                + "        break;\n"
                + "    }\n"
                + "}");
    }//GEN-LAST:event_boton_switchActionPerformed

    private void boton_dowhileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_dowhileActionPerformed
        Resultado.setText("#include <stdlib.h>\n"
                + "#include <iostream>\n"
                + "\n"
                + "using namespace std;\n"
                + "int main()\n"
                + "{\n"
                + "    do\n"
                + "    {\n"
                + "        int a = 5;\n"
                + "        string nombre;\n"
                + "\n"
                + "        cout << \"Ingrese un numero: \";\n"
                + "        cin >> numero;\n"
                + "\n"
                + "        cout << \"Ingrese su nombre: \";\n"
                + "        cin >> nombre;\n"
                + "    } while (var <= 10);\n"
                + "}");
    }//GEN-LAST:event_boton_dowhileActionPerformed

    private void boton_whileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_whileActionPerformed
        Resultado.setText("#include <stdlib.h>\n"
                + "#include <iostream>\n"
                + "\n"
                + "using namespace std;\n"
                + "int main()\n"
                + "{\n"
                + "    while (var <= 10)\n"
                + "    {\n"
                + "        int a = 5;\n"
                + "        string nombre;\n"
                + "\n"
                + "        cout << \"Ingrese un numero: \";\n"
                + "        cin >> numero;\n"
                + "\n"
                + "        cout << \"Ingrese su nombre: \";\n"
                + "        cin >> nombre;\n"
                + "    }\n"
                + "}");
    }//GEN-LAST:event_boton_whileActionPerformed

    private void boton_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_inicioActionPerformed
        Resultado.setText("#include <iostream>\n"
                + "#include <math.h>\n"
                + "#include <stdio.h>\n"
                + "#include <stdlib.h>\n"
                + "using namespace std;\n"
                + "int main() {}");
    }//GEN-LAST:event_boton_inicioActionPerformed

    private void boton_defaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_defaultActionPerformed
        Resultado.setText("#include <stdlib.h>\n"
                + "using namespace std;\n"
                + "int main(){\n"
                + "    int n=0;\n"
                + "    cin >> n;\n"
                + "    for(int i=0; i<=n; i++){\n"
                + "        for(int j=5; j>=1; j--){\n"
                + "            cout << ' ';\n"
                + "        }\n"
                + "        cout << endl;\n"
                + "    }\n"
                + "    for(int a=0; a<n; a++){\n"
                + "        for(int f=0; f<n; f++){\n"
                + "            cout << ' ';\n"
                + "        }\n"
                + "        cout << ' ';\n"
                + "    \n"
                + "    if(n > 10){\n"
                + "        cout << \"es mayor a 10\";\n"
                + "    }\n"
                + "    cout << endl;\n"
                + "    }\n"
                + "    int d = 10;\n"
                + "    while(d>0){\n"
                + "        cout<<d;\n"
                + "        d=10;\n"
                + "    }\n"
                + "    return 0;\n"
                + "}");
    }//GEN-LAST:event_boton_defaultActionPerformed

    private void BotonSemanticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSemanticoActionPerformed
        int rowCount = mt.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            mt.removeRow(i);
        }
        String codigo = Resultado.getText();
        String[] codigoFormateado = separarCodigo(codigo);
        ArrayList<ArrayList<Object>> declaraciones = encontrarDeclaraciones(codigo);
        ArrayList<ArrayList<Object>> asignaciones = encontrarAsignaciones(codigo);
        ArrayList<ArrayList<Object>> declaracionesYAsignaciones = new ArrayList<>();

        for (ArrayList<Object> lista : declaraciones) {
            declaracionesYAsignaciones.add(lista);
        }
        for (ArrayList<Object> lista : asignaciones) {
            declaracionesYAsignaciones.add(lista);
        }

        ordenarDeclaracionesYAsignaciones(declaracionesYAsignaciones);

        txtSeguimientoSemantico.setText(imprimirAnalisisSemantico(declaracionesYAsignaciones));

        BotonSemantico.setEnabled(false);
    }//GEN-LAST:event_BotonSemanticoActionPerformed

    // Método para buscar una fila por ID
    public Object[] buscarFilaPorID(String idABuscar, int columnaID) {
        Object[] filaEncontrada = null;

        // Recorrer todas las filas del modelo
        for (int i = 0; i < mt.getRowCount(); i++) {
            // Obtener el valor de la columna de ID en la fila actual
            Object idEnFila = mt.getValueAt(i, columnaID);

            // Verificar si el ID coincide con el ID buscado
            if (idEnFila != null && idEnFila.equals(idABuscar)) {
                // Copiar los datos de la fila encontrada a un arreglo de objetos
                filaEncontrada = new Object[mt.getColumnCount()];
                for (int j = 0; j < mt.getColumnCount(); j++) {
                    filaEncontrada[j] = mt.getValueAt(i, j);
                }
                break; // Terminar el bucle una vez que se haya encontrado la fila
            }
        }

        return filaEncontrada; // Devolver la fila encontrada o null si no se encontró
    }

    public void editarFilaPorId(String idBuscado, Object[] nuevosDatos) {
        int rowCount = mt.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Object id = mt.getValueAt(i, 0); // Columna del ID es la primera (índice 0)
            if (id != null && id.toString().equals(idBuscado)) {
                // Encontrar la fila con el ID buscado
                for (int j = 0; j < nuevosDatos.length; j++) {
                    // Actualizar cada valor en la fila con los nuevos datos
                    mt.setValueAt(nuevosDatos[j], i, j);
                }
                break; // Detener la búsqueda después de encontrar la fila
            }
        }
    }

    public String imprimirAnalisisSemantico(ArrayList<ArrayList<Object>> declaracionesYAsignaciones) {
        Map<String, String> variables = new HashMap<>();;
        Map<String, String> variablesAsignadas = new HashMap<>();;
        String mensaje = "";
        Analizador.TypeDetector tipo = new Analizador.TypeDetector();
        for (ArrayList<Object> fila : declaracionesYAsignaciones) {
            // Obtener los valores de cada columna
            Object valor = fila.get(0);  // valor de la variable
            String nombreVariable = (String) fila.get(1);  // nombre de la variable

            int tipoOperacion = (int) fila.get(3);  // tipo de operación (0: declaración, 1: asignación)
            // Determinar el tipo de mensaje según el tipo de operación
            switch (tipoOperacion) {
                case 0:
                    String tipoVariable = (String) fila.get(0);
                    if (mensaje.contains("La variable '" + nombreVariable + "' se declaro")) {
                        mensaje += "Error: La variable '" + nombreVariable + "' ya se habia declarado\n\n";
                    } else {
                        mensaje += "La variable '" + nombreVariable + "' se declaro\n\n";
                        variables.put(nombreVariable, tipoVariable);

                        mt.addRow(new Object[]{nombreVariable, tipoVariable, "Declarada", "", ""});
                    }
                    break;
                // Imprimir el mensaje
                case 1:
                    if (!mensaje.contains("La variable '" + nombreVariable + "' se declaro\n")) {
                        mensaje += "Error: La variable '" + nombreVariable + "' no se ha declarado\n\n";
                    } else if (mensaje.contains("A la variable '" + nombreVariable + "' se le asigno el valor ")) {
                        if (variables.get((String) valor) != null) {
                            Object[] filaDeVariable = buscarFilaPorID((String) valor, 0);

                            if (filaDeVariable[2].equals("Declarada")) {
                                mensaje += "Error: A la variable '" + nombreVariable + "' no se le puede asignar \nla variable " + valor
                                        + " porque no se le ha asignado un valor\n\n";
                            } else if (filaDeVariable[2].equals("Asignado") && filaDeVariable[1].equals(variables.get(nombreVariable))) {
                                mensaje += "A la variable " + nombreVariable + " se le asigno el nuevo valor " + filaDeVariable[3]
                                        + "\nalmacenado en la variable " + filaDeVariable[0] + "\n\n";
                                String[] nuevosDatos = {nombreVariable, variables.get(nombreVariable), "Asignado", (String) filaDeVariable[3], tipo.detectType((String) filaDeVariable[3], variables.get(nombreVariable))};
                                editarFilaPorId(nombreVariable, nuevosDatos);
                            } else if (filaDeVariable[2].equals("Asignado") && !filaDeVariable[1].equals(variables.get(nombreVariable))) {
                                mensaje += "Error: A la variable " + nombreVariable + " no se le puede asignar el valor \n" + filaDeVariable[3]
                                        + " almacenado en la variable " + filaDeVariable[0] + " \npor que son de tipo " + variables.get(nombreVariable)
                                        + " y de tipo " + filaDeVariable[1] + " respectivamente\n\n";
                            }
                        } else if (variables.get(nombreVariable).equals(tipo.detectType((String) valor, variables.get(nombreVariable)))) {
                            mensaje += "A la variable '" + nombreVariable + "' se le asigno el nuevo valor " + valor + "\n\n";
                            variablesAsignadas.put(nombreVariable, (String) valor);

                            String[] nuevosDatos = {nombreVariable, variables.get(nombreVariable), "Asignado", (String) valor, tipo.detectType((String) valor, variables.get(nombreVariable))};
                            editarFilaPorId(nombreVariable, nuevosDatos);
                        } else {
                            mensaje += "Error: A la variable '" + nombreVariable + "' se le asigno el valor " + valor + "\nde tipo " + tipo.detectType((String) valor, variables.get(nombreVariable))
                                    + " pero la variable es de tipo " + variables.get(nombreVariable) + "\n\n";
                        }

                    } else {
                        if (variables.get((String) valor) != null) {
                            Object[] filaDeVariable = buscarFilaPorID((String) valor, 0);

                            if (filaDeVariable[2].equals("Declarada")) {
                                mensaje += "Error: A la variable '" + nombreVariable + "' no se le puede asignar \nla variable " + valor
                                        + " porque no se le ha asignado un valor\n\n";
                            } else if (filaDeVariable[2].equals("Asignado") && filaDeVariable[1].equals(variables.get(nombreVariable))) {
                                mensaje += "A la variable " + nombreVariable + " se le asigno el valor " + filaDeVariable[3]
                                        + "\nalmacenado en la variable " + filaDeVariable[0] + "\n\n";
                                String[] nuevosDatos = {nombreVariable, variables.get(nombreVariable), "Asignado", (String) filaDeVariable[3], tipo.detectType((String) filaDeVariable[3], variables.get(nombreVariable))};
                                editarFilaPorId(nombreVariable, nuevosDatos);
                            } else if (filaDeVariable[2].equals("Asignado") && !filaDeVariable[1].equals(variables.get(nombreVariable))) {
                                mensaje += "Error: A la variable " + nombreVariable + " no se le puede asignar el valor \n" + filaDeVariable[3]
                                        + " almacenado en la variable " + filaDeVariable[0] + " \npor que son de tipo " + variables.get(nombreVariable)
                                        + " y de tipo " + filaDeVariable[1] + " respectivamente\n\n";
                            }
                        } else if (variables.get(nombreVariable).equals(tipo.detectType((String) valor, variables.get(nombreVariable)))) {
                            mensaje += "A la variable '" + nombreVariable + "' se le asigno el valor " + valor + "\n\n";
                            variablesAsignadas.put(nombreVariable, (String) valor);

                            String[] nuevosDatos = {nombreVariable, variables.get(nombreVariable), "Asignado", (String) valor, tipo.detectType((String) valor, variables.get(nombreVariable))};
                            editarFilaPorId(nombreVariable, nuevosDatos);
                        } else {
                            mensaje += "Error: A la variable '" + nombreVariable + "' se le asigno el valor " + valor + "\n de tipo " + tipo.detectType((String) valor, variables.get(nombreVariable))
                                    + " pero la variable es de tipo " + variables.get(nombreVariable) + "\n\n";
                        }
                    }

                    break;
                default:
                    mensaje += "Tipo de operacion no reconocido para la variable '" + nombreVariable + "' \n";
                    break;
            }
        }
        return mensaje;
    }

    // Función para ordenar una lista de listas por el valor del tercer objeto
    public static void ordenarDeclaracionesYAsignaciones(ArrayList<ArrayList<Object>> lista) {
        // Creamos un comparador personalizado basado en el tercer objeto de cada lista
        Comparator<ArrayList<Object>> comparator = new Comparator<ArrayList<Object>>() {
            @Override
            public int compare(ArrayList<Object> lista1, ArrayList<Object> lista2) {
                // Obtener el tercer objeto de cada lista (suponiendo que hay al menos 3 elementos en cada lista)
                Object tercerObjetoLista1 = lista1.get(2);
                Object tercerObjetoLista2 = lista2.get(2);

                // Comparar los terceros objetos (asumiendo que son números enteros)
                if (tercerObjetoLista1 instanceof Integer && tercerObjetoLista2 instanceof Integer) {
                    return ((Integer) tercerObjetoLista1).compareTo((Integer) tercerObjetoLista2);
                } else {
                    // Manejo de errores si los terceros objetos no son enteros (podrías adaptar esta lógica según tu necesidad)
                    throw new IllegalArgumentException("Los terceros objetos no son enteros");
                }
            }
        };

        // Ordenar la lista de listas usando el comparador personalizado
        Collections.sort(lista, comparator);
    }

    public ArrayList<ArrayList<Object>> encontrarDeclaraciones(String codigo) {
        String textoAlterado = codigo.replaceAll(",", "; porAsignar ");
        String[] codigoFormateado = separarCodigo(textoAlterado);
        ArrayList<ArrayList<Object>> declaraciones = new ArrayList<>();
        ArrayList<Object> objeto;
        String anteriorTipo = "";
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < codigoFormateado.length; i++) {
            String token = codigoFormateado[i];
            line.append(token);
            if (token.equals(";")) {
                Pattern pattern = Pattern.compile("(float|int|double|char|string|long|bool|short|porAsignar)\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*(=\\s*([^;]*))?;");
                Matcher matcher = pattern.matcher(line.toString());
                if (matcher.find()) {

                    String type = matcher.group(1);
                    String name = matcher.group(2);

                    objeto = new ArrayList<>();

                    if (type.equals("porAsignar")) {
                        objeto.add(anteriorTipo);
                    } else {
                        objeto.add(type);
                        anteriorTipo = type;
                    }

                    objeto.add(name);
                    objeto.add(i - 4);
                    objeto.add(0);
                    declaraciones.add(objeto);

                }
                line = new StringBuilder();
            } else {
                line.append(" ");
            }
        }

        return declaraciones;
    }

    public ArrayList<ArrayList<Object>> encontrarAsignaciones(String codigo) {
        String textoAlterado = codigo.replaceAll(",", "; porAsignar ");
        String[] codigoFormateado = separarCodigo(textoAlterado);
        ArrayList<ArrayList<Object>> declaraciones = new ArrayList<>();
        ArrayList<Object> objeto;
        int index = 0;

        while (index < codigoFormateado.length - 2) {
            String nombre = codigoFormateado[index];
            String igual = codigoFormateado[index + 1];
            String valor = codigoFormateado[index + 2];

            // Verificar si los tokens forman una declaración de variable (nombre = valor)
            if (igual.equals("=") && !valor.equals("=") && !nombre.equals("=")) {
                objeto = new ArrayList<>();
                objeto.add(valor);
                objeto.add(nombre);
                objeto.add(index);
                objeto.add(1);
                declaraciones.add(objeto);
                index += 3; // Avanzar al siguiente conjunto de tokens
            } else {
                index++; // Avanzar al siguiente token
            }
        }

        return declaraciones;
    }

    public void imprimirArrayList(ArrayList<ArrayList<Object>> arrayList) {
        for (ArrayList<Object> lista : arrayList) {
            System.out.println(lista);
        }
    }
    private void Borrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Borrar3ActionPerformed
        int rowCount = mt.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            mt.removeRow(i);
        }
        txtSeguimientoSemantico.setText("");
    }//GEN-LAST:event_Borrar3ActionPerformed

    // Metodo del boton cerrar
    public void cerrar() {
        String botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "\u00bfDeseas cerrar la aplicaci\u00f3n?",
                "Cerrar aplicaci\u00f3n", 0, 0, null, botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAnalizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAnalizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar1;
    private javax.swing.JButton Borrar2;
    private javax.swing.JButton Borrar3;
    private javax.swing.JButton BotonAnalisis;
    private javax.swing.JButton BotonSemantico;
    private javax.swing.JButton BotonSintactico;
    private javax.swing.JButton Boton_Assembler;
    private javax.swing.JButton Boton_Ejecutable;
    private javax.swing.JButton Boton_Ejecutar;
    private javax.swing.JButton Boton_Intermedio;
    private javax.swing.JButton Boton_Objeto;
    private javax.swing.JTextArea Resultado;
    private javax.swing.JButton boton_declaracion;
    private javax.swing.JButton boton_default;
    private javax.swing.JButton boton_dowhile;
    private javax.swing.JButton boton_entradaYSalida;
    private javax.swing.JButton boton_for;
    private javax.swing.JButton boton_if;
    private javax.swing.JButton boton_inicio;
    private javax.swing.JButton boton_switch;
    private javax.swing.JButton boton_while;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tablaSemantica;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtSeguimientoSemantico;
    // End of variables declaration//GEN-END:variables
}
