/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.apresentacao;

import gui.Documento;
import gui.formasGeometricas.*;
import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.uteis.Iterador;
import utils.Uteis;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tania
 */
public class PanelDesenho extends javax.swing.JPanel implements MouseListener, MouseMotionListener,InterfaceOuvintePanels{
//    private ListaEncadeada<Ponto> points;
    private JLabel labelX, labelY, labelEventoMouse;
    private static int WIDTH_CANVAS = 2000, HEIGHT_CANVAS = 1800;

    BufferedImage canvas = new BufferedImage(WIDTH_CANVAS, HEIGHT_CANVAS, BufferedImage.TYPE_INT_RGB);
    BufferedImage snapCanvas = new BufferedImage(WIDTH_CANVAS, HEIGHT_CANVAS, BufferedImage.TYPE_INT_RGB);
    InterfaceFormaHandler manipulador = null;
    List<InterfaceFormaHandler> listaManipuladoresSelecionados = new ArrayList<>();
    Documento doc;
//    MaquinaDeEstados states;
    JPopupMenu popupMenu = new JPopupMenu();

    private MaquinaDeEstados states = new MaquinaDeEstados(this);


    /**
     * Creates new form PanelDesenho
     */
    public PanelDesenho(Documento doc) {
        super(true);
        this.doc = doc;
//        this.states = states;
        initComponents();//inicia componentes visuais layout
        createPopupMenu();//cria popup menu
        addMouseListener(this);
        addMouseMotionListener(this);

        iniciaCanvas();
    }

    public void iniciaCanvas() {
        Graphics2D newGraph = (Graphics2D) canvas.createGraphics();

        //inicia canvas com fundo branco e prepara a escrita negra
        newGraph.setColor(Color.WHITE);
//        newGraph.setBackground(Color.WHITE);
        newGraph.fillRect(0, 0, WIDTH_CANVAS, HEIGHT_CANVAS);
        newGraph.setColor(Color.BLACK);
        newGraph.setPaint(Color.BLACK);
        newGraph.dispose();

        //tira primeiro Snap
        snapCanvas = Uteis.deepCopyBI(canvas);
//        limpa manipulador e lista de selecionados
        manipulador = null;
        listaManipuladoresSelecionados.clear();

        repaint();//pinta o canvas no Panel
    }

    private void createPopupMenu(){
        ActionListener menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("menu item ["
                        + event.getActionCommand() + "] pressionado");

                if (event.getActionCommand().equals(MaquinaDeEstados.TRANSLATE)){
                    states.setSelectedSubTool(MaquinaDeEstados.TRANSLATE);
                    setCursor(new Cursor(Cursor.MOVE_CURSOR));

                }
                if (event.getActionCommand().equals(MaquinaDeEstados.ROTATE)){

                }

                popupMenu.setVisible(false);
            }
        };
        JMenuItem item;

        popupMenu.add(item = new JMenuItem(MaquinaDeEstados.TRANSLATE));
        item.addActionListener(menuListener);
        popupMenu.addSeparator();
        popupMenu.add(item = new JMenuItem(MaquinaDeEstados.ROTATE));
        item.addActionListener(menuListener);
        popupMenu.setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    void showPopupMenu(MouseEvent mouseEvent) {
        popupMenu.setLocation(MouseInfo.getPointerInfo().getLocation());
        popupMenu.setVisible(true);
    }

    void addListener4MousePos(JLabel labelX, JLabel labelY, JLabel labelEventoMouse){
        this.labelX = labelX;
        this.labelY = labelY;
        this.labelEventoMouse = labelEventoMouse;
    }


    Ponto mouseCoords_saved = new Ponto(0,0);
    @Override
    public void mousePressed(MouseEvent e) {

        states.mousePressed(e);

        atualizaPosicaoMouseXY(e);
        labelEventoMouse.setText( "pressionando.." );
        System.out.println("pressionou..");
        System.out.println("formas selecionadas -> " + listaManipuladoresSelecionados.size());

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        states.mouseDragged(e);

        //atualiza as posicoes do mouse nos labels
        atualizaPosicaoMouseXY(e);
        labelEventoMouse.setText( "arrastando.." );
        System.out.println("arrastando..");
        System.out.println("formas selecionadas -> " + listaManipuladoresSelecionados.size());
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        //atualiza as posicoes do mouse nos labels
        atualizaPosicaoMouseXY(e);
        labelEventoMouse.setText( "movendo.." );
    }
    @Override
    public void mouseReleased(MouseEvent e) {

        states.mouseReleased(e);

        atualizaPosicaoMouseXY(e);
        labelEventoMouse.setText( "soltou.." );
        System.out.println("soltou..");
        System.out.println("formas selecionadas -> " + listaManipuladoresSelecionados.size());

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        atualizaPosicaoMouseXY(e);
        labelEventoMouse.setText( "clicou.." );
        System.out.println("clicou ..");

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        states.mouseEntered(e);

        atualizaPosicaoMouseXY(e);
        labelEventoMouse.setText( "entrou.." );
        System.out.println("entrou ..");

//        setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        atualizaPosicaoMouseXY(e);
        labelEventoMouse.setText( "saiu.." );
        System.out.println("saiu ..");
    }


    void verificaSelecionados() {

        try {

            //salva e limpa lista de selecionados (caso foram deselecionados)
//            listaManipuladoresDes_selecionados.addAll( listaManipuladoresSelecionados );
            listaManipuladoresSelecionados.clear();

            Iterador<FormaGeometrica> it = doc.getIterador();
            FormaGeometrica forma;

             while((forma = it.proximo()) != null) {
                 InterfaceFormaHandler formaHandler = forma.getFormaHandler(forma);
                 if (formaHandler.intersects( (MouseSelect) manipulador.getForma() )){
                     listaManipuladoresSelecionados.add( formaHandler );
                     System.out.println("inseriu!! listaManipuladoresSelecionados ");
                     System.out.println(forma.toString());
                     System.out.println(listaManipuladoresSelecionados.size());
                 }
             }

        }catch (ClassCastException ce){
            System.out.println(ce.getMessage());
            ce.printStackTrace();
        }

    }



//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//
////        if (manipulador != null)
////            manipulador.paint(g);
//    }


    @Override
    public void paintComponent (Graphics g){
//ORIGINAL 2
//        super.paintComponent(g);//limpa area de desenho
//        Iterador<FormaGeometrica> it = doc.getIterador();
//        FormaGeometrica forma;
//
//         while((forma = it.proximo()) != null) {
//                forma.desenhar(g);
//         }




//TODO TENTAR FAZER SEM REDESENHAR TUDO
//todo try 4 SUCESSO!!!!!!!!!
        //RECUPERA SNAPSHOT
        canvas = Uteis.deepCopyBI(snapCanvas);

        //pinta formas selecionadas de vermelho se houver
        if (! listaManipuladoresSelecionados.isEmpty()){
//            canvas = Uteis.deepCopyBI(snapCanvas);
            Graphics2D newGraph = (Graphics2D) canvas.createGraphics();
            newGraph.setColor(Color.RED);
            listaManipuladoresSelecionados.forEach(formaHandler ->{
                formaHandler.paint(newGraph);
                System.out.println("pintou de VERMEI" +formaHandler.getForma().toString());

            });
            newGraph.setColor(Color.BLACK);
            newGraph.dispose();
        }

        if (manipulador != null){ //pinta manipulador atual
//            canvas = Uteis.deepCopyBI(snapCanvas);
            Graphics2D newGraph = (Graphics2D) canvas.createGraphics();
            newGraph.setColor(Color.BLACK);
            manipulador.paint(newGraph);

            newGraph.dispose();
        }

        //pinta canvas no Panel
        g.drawImage(canvas, 0, 0, null);
//        repaint(); //loop infinito na thead!! (RECURSãO)
        System.out.println("pintou canvas");



//todo try 3 SUCESSO +-
//        if (manipulador != null){
//            Graphics2D newGraph = (Graphics2D) canvas.createGraphics();
//            newGraph.setColor(Color.black);
//            manipulador.paint(newGraph);
//            newGraph.dispose();
//        }
//        g.drawImage(canvas, 0, 0, null);
//        repaint();


//todo try 2
//        if (newGraph == null){
//            super.paintComponent(g);//limpa area de desenho
//            newGraph = (Graphics2D) g.create();
//        }else{
//            if (manipulador != null)
//                manipulador.paint(newGraph);
//        }


//todo try1
//        newGraph = (Graphics2D) g.create();
//        newGraph.setBackground(Color.WHITE);
//        super.paintComponent(newGraph);
//        if (manipulador != null)
//            manipulador.paint(newGraph);

    }

    @Override
    public void atualizar() {
//        getParent().revalidate();
        repaint();
    }
    @Override
    public void novaFormaGeometrica(FormaGeometrica forma) {
        doc.inserirFim(forma);
    }


    void atualizaPosicaoMouseXY(MouseEvent e){
        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
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

    public void setStates(MaquinaDeEstados states) {
        this.states = states;
    }

    public MaquinaDeEstados getStates() {
        return states;
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
