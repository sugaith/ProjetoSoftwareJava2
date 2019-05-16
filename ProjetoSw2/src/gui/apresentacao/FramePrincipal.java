/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.apresentacao;

import gui.Documento;
import gui.apresentacao.visualizacao.FrameTexto;
import gui.apresentacao.visualizacao.PanelTexto;
import gui.formasGeometricas.*;
import gui.uteis.Iterador;
import gui.uteis.ListaEncadeada;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Thiago Correa
 */
public class FramePrincipal extends javax.swing.JFrame {

    private Documento doc = new Documento();

    private FrameTexto frameTexto;
    private PanelTexto panelTexto;


    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {

        panelDesenho = new PanelDesenho(doc);

        //configura interface
        initComponents();
        setSize(1000,800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        //atualiza label com estado inicial
        labelSelectedTool.setText(panelDesenho.getStates().getSelectedTool());

        //listener para posicao do mouse
        panelDesenho.addListener4MousePos( labelPosicaoMouseX, labelPosicaoMouseY, labelEventoMouse );
        doc.adicionaOuvinte(panelDesenho);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelPosicaoMouseX = new javax.swing.JLabel();
        labelPosicaoMouseY = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnMouse = new javax.swing.JButton();
        btnPonto = new javax.swing.JButton();
        btnLapis = new javax.swing.JButton();
        btnLinha = new javax.swing.JButton();
        btnQuadrado = new javax.swing.JButton();
        btnRetangulo = new javax.swing.JButton();
        btnCirculo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        labelSelectedTool = new javax.swing.JLabel();
        labelEventoMouse = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        menuItem_abrirTxt = new javax.swing.JMenuItem();
        menuItem_salvarTxt = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItem_abrirBinaro = new javax.swing.JMenuItem();
        menuItem_salvarBinario = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuItem_abrirSerial = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItemArqBdAbrir = new javax.swing.JMenuItem();
        jMenuItemArqBdSalvar = new javax.swing.JMenuItem();
        jMenuItemArqBdSalvarComo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemLimparTela = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItemVerFormatoTexto = new javax.swing.JMenuItem();
        jMenuItemVerFormatoTabela = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDesenho.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(panelDesenho);
        panelDesenho.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setText("Posição do Ponteiro:");

        jLabel2.setText("X:");

        labelPosicaoMouseX.setForeground(new java.awt.Color(255, 255, 255));
        labelPosicaoMouseX.setText("0");

        labelPosicaoMouseY.setForeground(new java.awt.Color(255, 255, 255));
        labelPosicaoMouseY.setText("0");

        jLabel5.setText("Y:");


        btnPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPontoActionPerformed(evt);
            }
        });
//

        btnLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinhaActionPerformed(evt);
            }
        });

        btnLapis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapisActionPerformed(evt);
            }
        });

        btnQuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuadradoActionPerformed(evt);
            }
        });

        btnRetangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetanguloActionPerformed(evt);
            }
        });

        btnCirculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoActionPerformed(evt);
            }
        });


        btnMouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMouseActionPerformed(evt);
            }
        });
//
//        btnLapis.setText("lapis");
//
//        btnLinha.setText("linha");
//
//        btnQuadrado.setText("quadr");
//
//        btnRetangulo.setText("retangulo");
//
//        btnCirculo.setText("circulo");
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setText("selecionado:");

        labelSelectedTool.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelSelectedTool.setForeground(new java.awt.Color(255, 51, 51));
//        labelSelectedTool.setText("select tool");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnMouse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLapis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRetangulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCirculo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSelectedTool)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSelectedTool, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMouse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLapis, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCirculo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRetangulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        labelEventoMouse.setForeground(new java.awt.Color(255, 255, 255));
//        labelEventoMouse.setText("mouse clicado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(labelEventoMouse))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelPosicaoMouseY, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPosicaoMouseX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelPosicaoMouseX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPosicaoMouseY)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEventoMouse))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );



        jMenu1.setText("Arquivo");

        jMenu3.setText("Arquivo Txt");

        menuItem_abrirTxt.setText("Abrir txt");
        menuItem_abrirTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_abrirTxtActionPerformed(evt);
            }
        });
        jMenu3.add(menuItem_abrirTxt);

        menuItem_salvarTxt.setText("Salvar txt");
        menuItem_salvarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_salvarTxtActionPerformed(evt);
            }
        });
        jMenu3.add(menuItem_salvarTxt);

        jMenu6.add(jMenu3);

        jMenu4.setText("Arquivo binário");

        menuItem_abrirBinaro.setText("Abrir Binário");
        jMenu4.add(menuItem_abrirBinaro);

        menuItem_salvarBinario.setText("Salvar Binário");
        menuItem_salvarBinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_salvarBinarioActionPerformed(evt);
            }
        });
        jMenu4.add(menuItem_salvarBinario);

        jMenu6.add(jMenu4);

        jMenu5.setText("Arquivo Serial");

        menuItem_abrirSerial.setText("Abrir Serial");
        menuItem_abrirSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_abrirSerialActionPerformed(evt);
            }
        });
        jMenu5.add(menuItem_abrirSerial);

        jMenuItem1.setText("Salvar Serial");
        jMenu5.add(jMenuItem1);

        jMenu6.add(jMenu5);

        jMenu1.add(jMenu6);

        jMenu7.setText("Banco de Dados");

        jMenuItemArqBdAbrir.setText("Abrir...");
        jMenuItemArqBdAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemArqBdAbrirActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemArqBdAbrir);

        jMenuItemArqBdSalvar.setText("Salvar");
        jMenuItemArqBdSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemArqBdSalvarActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemArqBdSalvar);

        jMenuItemArqBdSalvarComo.setText("Salvar como..");
        jMenuItemArqBdSalvarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemArqBdSalvarComoActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemArqBdSalvarComo);

        jMenu1.add(jMenu7);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItemLimparTela.setText("Limpar Tela");
        jMenuItemLimparTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_limparTelaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemLimparTela);

        jMenuBar1.add(jMenu2);

        jMenu8.setText("Ver");

        jMenuItemVerFormatoTexto.setText("Formato Texto");
        jMenuItemVerFormatoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerFormatoTextoActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItemVerFormatoTexto);

        jMenuItemVerFormatoTabela.setText("Formato Tabela");
        jMenuItemVerFormatoTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerFormatoTabelaActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItemVerFormatoTabela);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDesenho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );


        btnMouse.setIcon(new javax.swing.ImageIcon("imgs\\btnMouse.fw.png"));
        Image image = ((ImageIcon)btnMouse.getIcon()).getImage();
        Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ((ImageIcon)btnMouse.getIcon()).setImage(newimg);

        btnPonto.setIcon(new javax.swing.ImageIcon("imgs\\btnPonto.fw.png"));
        image = ((ImageIcon)btnPonto.getIcon()).getImage();
        newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ((ImageIcon)btnPonto.getIcon()).setImage(newimg);

        btnLapis.setIcon(new javax.swing.ImageIcon("imgs\\btnLapis.fw.png"));
        image = ((ImageIcon)btnLapis.getIcon()).getImage();
        newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ((ImageIcon)btnLapis.getIcon()).setImage(newimg);

        btnLinha.setIcon(new javax.swing.ImageIcon("imgs\\btnLinha.fw.png"));
        image = ((ImageIcon)btnLinha.getIcon()).getImage();
        newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ((ImageIcon)btnLinha.getIcon()).setImage(newimg);

        btnQuadrado.setIcon(new javax.swing.ImageIcon("imgs\\btnQuadr.fw.png"));
        image = ((ImageIcon)btnQuadrado.getIcon()).getImage();
        newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ((ImageIcon)btnQuadrado.getIcon()).setImage(newimg);

        btnRetangulo.setIcon(new javax.swing.ImageIcon("imgs\\btnRet.fw.png"));
        image = ((ImageIcon)btnRetangulo.getIcon()).getImage();
        newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ((ImageIcon)btnRetangulo.getIcon()).setImage(newimg);

        btnCirculo.setIcon(new javax.swing.ImageIcon("imgs\\btnCirculo.fw.png"));
        image = ((ImageIcon)btnCirculo.getIcon()).getImage();
        newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ((ImageIcon)btnCirculo.getIcon()).setImage(newimg);





        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMouseActionPerformed(ActionEvent evt) {
        panelDesenho.getStates().setSelectedTool(MouseSelect.NOME);
        labelSelectedTool.setText(MouseSelect.NOME);
    }

    private void btnCirculoActionPerformed(ActionEvent evt) {
        panelDesenho.getStates().setSelectedTool(Circulo.NOME);
        labelSelectedTool.setText(Circulo.NOME);
    }

    private void btnRetanguloActionPerformed(ActionEvent evt) {
        panelDesenho.getStates().setSelectedTool(Retangulo.NOME);
        labelSelectedTool.setText(Retangulo.NOME);
    }

    private void btnQuadradoActionPerformed(ActionEvent evt) {
        panelDesenho.getStates().setSelectedTool(Quadrado.NOME);
        labelSelectedTool.setText(Quadrado.NOME);
    }

    private void btnLapisActionPerformed(ActionEvent evt) {
        panelDesenho.getStates().setSelectedTool(Lapis.NOME);
        labelSelectedTool.setText(Lapis.NOME);
    }

    private void btnPontoActionPerformed(ActionEvent evt) {
        panelDesenho.getStates().setSelectedTool(Ponto.NOME);
        labelSelectedTool.setText(Ponto.NOME);
    }

    private void btnLinhaActionPerformed(ActionEvent evt) {
        panelDesenho.getStates().setSelectedTool(Linha.NOME);
        labelSelectedTool.setText(Linha.NOME);
    }

    private void menuItem_limparTelaActionPerformed(ActionEvent evt) {
        doc.setListaFormas( new ListaEncadeada<>() );
        doc.atualizaOuvintes();
        panelDesenho.iniciaCanvas();
    }

    private void menuItem_abrirTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_abrirTxtActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Arq texto", "txt");
        fileChooser.addChoosableFileFilter(filterTxt);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("arquivo selecionado====> " + selectedFile.getAbsolutePath());
                Path file = Paths.get(selectedFile.getCanonicalPath());
                Stream<String> lines = Files.lines(file,Charset.forName("UTF-8") );
                ListaEncadeada<FormaGeometrica> listaPoint_aux = new ListaEncadeada<>();
                lines.forEach(s -> {
                    System.out.println(s);
                    String px, py;
                    px = s.split(" ")[1];
                    py = s.split(" ")[2];
                    int x = Integer.valueOf(px);
                    int y = Integer.valueOf(py);
                    
                    Ponto p = new Ponto(x, y);

//                    listaPoint_aux.inserirFim(p);
                    doc.inserirFim( p );
                });
//                panelDesenho panel = (panelDesenho) panelDesenho;
//                panel.setPoints(listaPoint_aux);
//                panel.repaint();

                doc.atualizaOuvintes();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }//GEN-LAST:event_menuItem_abrirTxtActionPerformed

    private void menuItem_abrirSerialActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Arq serial", "ser");
        fileChooser.addChoosableFileFilter(filterTxt);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try {
                FileInputStream fi = new FileInputStream(fileToSave);
                ObjectInputStream oi = new ObjectInputStream(fi);

                // Read objects
                Documento obj = (Documento) oi.readObject();
                oi.close();
                fi.close();

                doc.setListaFormas( obj.getListaFormas() );
//                this.doc = obj;

                doc.atualizaOuvintes();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void menuItem_salvarSerialActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar como");
        FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Arq serial", "ser");
        fileChooser.addChoosableFileFilter(filterTxt);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                File fileToSave = fileChooser.getSelectedFile();
                Path file = Paths.get(fileToSave.getCanonicalPath() + ".ser");

                FileOutputStream f = new FileOutputStream( file.toString() );
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(doc);
                o.close();
                f.close();
                System.out.println("arquivo salvo====> " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void menuItem_salvarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_salvarTxtActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar como");  
        FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Arq texto", "txt");
        fileChooser.addChoosableFileFilter(filterTxt);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();            
            try {
                List<String> lines = new ArrayList<>();

//                panelDesenho panel = (panelDesenho) panelDesenho;
//                for (int i=0; i<panel.getPoints().getTamanho(); i++){
////                    Point p = panel.getPoints().pesquisar(i);
//                    Ponto p = panel.getPoints().pesquisar(i);
////                    Double x = p.getX();
////                    Double y = p.getY();
//
//                    String line = "Ponto " + p.getX() + " " + p.getY();
//                    lines.add(line);
//                }

                //todo novo salvar com forma
                Iterador<FormaGeometrica> it = doc.getIterador();
                FormaGeometrica forma;
                while((forma = it.proximo()) != null) {
                    String line = forma.toTextLine();
                    lines.add(line);
                }

                Path file = Paths.get(fileToSave.getCanonicalPath() + ".txt");
                Files.write(file, lines, Charset.forName("UTF-8"));
                //Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
                System.out.println("arquivo salvo====> " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_menuItem_salvarTxtActionPerformed

    private void menuItem_salvarBinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_salvarBinarioActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar como");  
        FileNameExtensionFilter filterBin = new FileNameExtensionFilter("Arq Binario", "bin");
        fileChooser.addChoosableFileFilter(filterBin);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
//                File fileToSave = fileChooser.getSelectedFile();
                File fileToSave = new File( fileChooser.getSelectedFile().getCanonicalPath() + ".bin" );
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

//                panelDesenho panel = (panelDesenho) panelDesenho;
//                for (int i=0; i < panel.getPoints().getTamanho(); i++){
////                    Point p = panel.getPoints().pesquisar(i);
//                    Ponto p = panel.getPoints().pesquisar(i);
////                    Double x = p.getX();
////                    Double y = p.getY();
//                    int repr_ponto = 1;
//                    baos.write(repr_ponto);
////                    baos.write(x.intValue());
////                    baos.write(y.intValue());
//                    baos.write(p.getX());
//                    baos.write(p.getY());
//                }

                //todo novo salvar com forma OK
                Iterador<FormaGeometrica> it = doc.getIterador();
                FormaGeometrica forma;
                while((forma = it.proximo()) != null) {
                    baos.write( forma.toByteArray() );
                }
                
                FileOutputStream fos = new FileOutputStream(fileToSave);
                fos.write(baos.toByteArray());
                fos.close();
                
                System.out.println("arquivo salvo====> " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_menuItem_salvarBinarioActionPerformed

    private void menuItem_abrirBinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_abrirBinarioActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Arq binario", "bin");
        fileChooser.addChoosableFileFilter(filterTxt);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("arqivo selecionado====> " + selectedFile.getAbsolutePath());
                Path file = Paths.get(selectedFile.getCanonicalPath());

                byte[] fileContent = Files.readAllBytes(file);
                int i=0;
                while (i<fileContent.length){
                    //le primeiro byte INDENTIFICADOR (por enquanto apenas ponto)
                    byte byteID = fileContent[i];

                    if (byteID == Ponto.getIdentificadorBinario()){
                        int qtPontos = 2;

                        byte[] arrayForma = Arrays.copyOfRange(fileContent, i+1, i+1+ qtPontos);
                        Ponto p = new Ponto( arrayForma );
                        doc.inserirFim( p );

                        //todo acrescenta depenendo da forma
                        i += qtPontos + 1;
                    }


                    //todo substutuir por switch-case de formas
                }

                doc.atualizaOuvintes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_menuItem_abrirBinarioActionPerformed

    private void jMenuItemArqBdAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemArqBdAbrirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemArqBdAbrirActionPerformed

    private void jMenuItemArqBdSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemArqBdSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemArqBdSalvarActionPerformed

    private void jMenuItemArqBdSalvarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemArqBdSalvarComoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemArqBdSalvarComoActionPerformed

    private void jMenuItemVerFormatoTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerFormatoTabelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemVerFormatoTabelaActionPerformed

    private void jMenuItemVerFormatoTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerFormatoTextoActionPerformed

        panelTexto = new PanelTexto(doc);
        doc.adicionaOuvinte(panelTexto);

        frameTexto = new FrameTexto( panelTexto );
        frameTexto.setVisible(true);

        //todo SOBRESCREVER ONCLOSE PARA REMOVER DA LISTA DE OUVINTE
        frameTexto.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
//                doc.removeOuvinte(panelTexto);
                panelTexto = null;
                frameTexto.dispose();
            }

        });


    }//GEN-LAST:event_jMenuItemVerFormatoTextoActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PanelDesenho panelDesenho;
    private javax.swing.JButton btnCirculo;
    private javax.swing.JButton btnLapis;
    private javax.swing.JButton btnLinha;
    private javax.swing.JButton btnMouse;
    private javax.swing.JButton btnPonto;
    private javax.swing.JButton btnQuadrado;
    private javax.swing.JButton btnRetangulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelEventoMouse;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemLimparTela;
    private javax.swing.JMenuItem jMenuItemArqBdAbrir;
    private javax.swing.JMenuItem jMenuItemArqBdSalvar;
    private javax.swing.JMenuItem jMenuItemArqBdSalvarComo;
    private javax.swing.JMenuItem jMenuItemVerFormatoTabela;
    private javax.swing.JMenuItem jMenuItemVerFormatoTexto;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPosicaoMouseX;
    private javax.swing.JLabel labelPosicaoMouseY;
    private javax.swing.JLabel labelSelectedTool;
    private javax.swing.JMenuItem menuItem_abrirBinaro;
    private javax.swing.JMenuItem menuItem_abrirSerial;
    private javax.swing.JMenuItem menuItem_abrirTxt;
    private javax.swing.JMenuItem menuItem_salvarBinario;
    private javax.swing.JMenuItem menuItem_salvarTxt;
    // End of variables declaration//GEN-END:variables
}
