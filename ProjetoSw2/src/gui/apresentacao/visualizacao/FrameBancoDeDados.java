/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.apresentacao.visualizacao;

import gui.apresentacao.FramePrincipal;
import gui.uteis.DesenhoTableModel;
import gui.uteis.FormaDaoTableModel;
import persistencia.ConexaoMySQL;
import persistencia.dao.DaoDesenho;
import persistencia.dao.entidade.Desenho;
import persistencia.dao.entidade.Forma;
import utils.Uteis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 *
 * @author suga
 */
public class FrameBancoDeDados extends javax.swing.JFrame {
    private  FramePrincipal pai;
    private List<Desenho> listaDesenhos;
    private ConexaoMySQL mySQL;

    private boolean detailsVisible = false;

    /**
     * Creates new form FrameTabela
     */
    public FrameBancoDeDados( FramePrincipal pai, ConexaoMySQL mySQL) {
        this.mySQL = mySQL;
        this.pai = pai;
        initComponents();

        mySQL.conectar();
        listaDesenhos = new DaoDesenho(mySQL.getConexao()).consultaTodos();
        mySQL.desconectar();

        this.preencheTabela();
    }

    private void preencheTabela() {
        jTableFormas.setModel( new DesenhoTableModel(listaDesenhos) );
//        jTableFormas.setModel( new FormaDaoTableModel( listaDesenhos.get(0).getListaFormas() ));


        //double click na tabela p/ trocar info
        jTableFormas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                //s'o funga quando tem linha
                //                int row = jTableFormas.getSelectedRow();

                //funciona mesmo quando nao tem linha
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2) {
                    System.out.println( "row->" +  jTableFormas.getSelectedRow() );

                    if (detailsVisible){
                        jTableFormas.setModel( new DesenhoTableModel(listaDesenhos) );
                        detailsVisible = false;

                    }else{
                        List<Forma> lista = listaDesenhos.get( row ).getListaFormas();
                        jTableFormas.setModel( new FormaDaoTableModel( lista ));
                        detailsVisible = true;
                    }
                }
            }
        });

    }

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTableFormas.getSelectedRow() < 0 && !detailsVisible){
            Uteis.showAlert("Selecione algum desenho");
            return;
        }

        pai.abreDesenho( listaDesenhos.get( jTableFormas.getSelectedRow() ) ) ;
    }

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTableFormas.getSelectedRow() < 0 && !detailsVisible){
            Uteis.showAlert("Selecione algum desenho");
            return;
        }

        int id = listaDesenhos.get( jTableFormas.getSelectedRow() ).getId();

        mySQL.conectar();
        new DaoDesenho(mySQL.getConexao()).excluirDesenho_id( id );
        listaDesenhos = new DaoDesenho(mySQL.getConexao()).consultaTodos();
        mySQL.desconectar();

        preencheTabela();

        Uteis.showAlert("Desenho excluido - " + id);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFormas = new javax.swing.JTable();
        btnAbrir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTableFormas);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnExcluir.setText("Deletar");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFormas;
    // End of variables declaration//GEN-END:variables
}
