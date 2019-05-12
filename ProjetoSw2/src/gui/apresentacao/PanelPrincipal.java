/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.apresentacao;

import gui.Documento;
import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.Linha;
import gui.formasGeometricas.Ponto;
import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.uteis.Iterador;
import gui.uteis.ListaEncadeada;
import gui.uteis.StateMach;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 *
 * @author Tania
 */
public class PanelPrincipal extends javax.swing.JPanel implements MouseListener, MouseMotionListener,InterfaceOuvintePanels{
//    private ListaEncadeada<Ponto> points;
    protected JLabel labelX, labelY, labelEventoMouse;
    protected Documento doc;
    private StateMach states;

    private InterfaceFormaHandler manipulador = null;

    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal(Documento doc, StateMach states) {
        this.doc = doc;
        this.states = states;
        initComponents();
        addMouseListener(this);
        addMouseMotionListener(this);


    }

    public void addListener4MousePos(JLabel labelX, JLabel labelY, JLabel labelEventoMouse){
        this.labelX = labelX;
        this.labelY = labelY;
        this.labelEventoMouse = labelEventoMouse;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (states.getSelectedTool()){
            case (StateMach.MOUSE_TOOL):{


            }break;

            case (Ponto.NOME):{
                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                novaFormaGeometrica( p );
                manipulador = p.getFormaHandler(p);
                atualizar(); // repinta JFrame
            }break;

            case (Linha.NOME):{
                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Linha l = new Linha( p );
                novaFormaGeometrica( l );
                manipulador = l.getFormaHandler(l);
                atualizar(); // repinta JFrame
            }break;




            default: break;
        }




        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "pressionando.." );
        System.out.println("pressionou..");

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //salva forma na lista
//                    getPoints().inserirFim( new Ponto( e.getPoint().x, e.getPoint().y ) );
//                    repaint();

        //todo aqui vai ser diferenciado As formas geometricas,
        // por enquanto so tem ponto
//                    doc.inserirFim( new Ponto( e.getPoint().x, e.getPoint().y ) );
//        novaFormaGeometrica( new Ponto( e.getPoint().x, e.getPoint().y ) );
//        atualizar(); // repinta JFrame


        switch (states.getSelectedTool()){
            case (StateMach.MOUSE_TOOL):{


            }break;

            case (Ponto.NOME):{
                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                novaFormaGeometrica( p );
                manipulador = p.getFormaHandler(p);
                atualizar(); // repinta JFrame
            }break;

            default: {
                if (manipulador != null){
                    manipulador.drag(e.getPoint().x, e.getPoint().y );
                    atualizar(); // repinta JFrame
                }
            }break;
        }

        //atualiza as posicoes do mouse nos labels
        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "arrastando.." );
        System.out.println("arrastando..");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //atualiza as posicoes do mouse nos labels
        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "movendo.." );
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "soltou.." );
        System.out.println("soltou..");

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "clicou.." );
        System.out.println("clicou ..");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "entrou.." );
        System.out.println("entrou ..");

//        setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "saiu.." );
        System.out.println("saiu ..");
    }

    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);//limpa area de desenho        
         //desenha todos ospontos do array
//        for (int i=0; i<getPoints().getTamanho(); i++){
//            Ponto p = getPoints().pesquisar(i);
//            g.fillOval(p.getX(), p.getY(), 4, 4);
//        }

        //todo novo esquema de desenhar por iterador
        // e com FormaGeometrica
        Iterador<FormaGeometrica> it = doc.getIterador();
        FormaGeometrica forma;
        super.paintComponent(g);//limpa area de desenho

        while((forma = it.proximo()) != null) {
            forma.desenhar(g);
        }
    }

    @Override
    public void atualizar() {
        getParent().revalidate();
        repaint();
    }
    @Override
    public void novaFormaGeometrica(FormaGeometrica forma) {
        doc.inserirFim(forma);
    }






    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setStates(StateMach states) {
        this.states = states;
    }

//    /**
//     * @return the points
//     */
//    public ListaEncadeada<Ponto> getPoints() {
//        return points;
//    }
//
//    /**
//     * @param points the points to set
//     */
//    public void setPoints(ListaEncadeada<Ponto> points) {
//        this.points = points;
//    }
//

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
