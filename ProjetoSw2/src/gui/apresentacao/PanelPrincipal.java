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
import gui.uteis.StateMach;
import utils.Uteis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tania
 */
public class PanelPrincipal extends javax.swing.JPanel implements MouseListener, MouseMotionListener,InterfaceOuvintePanels{
//    private ListaEncadeada<Ponto> points;
    protected JLabel labelX, labelY, labelEventoMouse;
    protected Documento doc;
    private StateMach states;
    public static int WIDTH_CANVAS = 2000, HEIGHT_CANVAS = 1800;
    private BufferedImage canvas = new BufferedImage(WIDTH_CANVAS, HEIGHT_CANVAS, BufferedImage.TYPE_INT_RGB);
    private BufferedImage snapCanvas = new BufferedImage(WIDTH_CANVAS, HEIGHT_CANVAS, BufferedImage.TYPE_INT_RGB);

    private InterfaceFormaHandler manipulador = null;

    private List<InterfaceFormaHandler> listaManipuladoresSelecionados = new ArrayList<>();

    /**
     * Creates new form PanelPrincipal
     */
    public PanelPrincipal(Documento doc, StateMach states) {
        super(true);
        this.doc = doc;
        this.states = states;
        initComponents();
        addMouseListener(this);
        addMouseMotionListener(this);

        iniciaCanvas();
    }

    public void iniciaCanvas() {
        Graphics2D newGraph = (Graphics2D) canvas.createGraphics();

        newGraph.setColor(Color.WHITE);
        newGraph.fillRect(0, 0, WIDTH_CANVAS, HEIGHT_CANVAS);
        newGraph.setColor(Color.BLACK);
//
//        newGraph.setBackground(Color.WHITE);
        newGraph.setPaint(Color.BLACK);
//        newGraph.setColor(Color.BLACK);
        newGraph.dispose();

        snapCanvas = Uteis.deepCopyBI(canvas);
        manipulador = null;

        repaint();
    }

    public void addListener4MousePos(JLabel labelX, JLabel labelY, JLabel labelEventoMouse){
        this.labelX = labelX;
        this.labelY = labelY;
        this.labelEventoMouse = labelEventoMouse;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (states.getSelectedTool()){

            case (MouseSelect.NOME):{

                //        pinta formas DEselecionadas de PRETO se houver


                snapCanvas = Uteis.deepCopyBI( canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                MouseSelect retangulo = new MouseSelect( p );
//                novaFormaGeometrica( retangulo );
                manipulador = retangulo.getFormaHandler(retangulo);

                if (! listaManipuladoresSelecionados.isEmpty()){
                    Graphics2D newGraph = (Graphics2D) snapCanvas.createGraphics();
                    newGraph.setColor(Color.BLACK);
                    listaManipuladoresSelecionados.forEach(formaHandler ->{
                        formaHandler.paint(newGraph);
                        System.out.println("pintou de PRETOWW " +formaHandler.getForma().toString());

                    });
                    newGraph.dispose();

                    listaManipuladoresSelecionados.clear();
                }


                atualizar(); // repinta JFrame
            }break;

            case (Ponto.NOME):{
                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                novaFormaGeometrica( p );
                manipulador = p.getFormaHandler(p);
                atualizar(); // repinta JFrame
            }break;

            case (Linha.NOME):{
                snapCanvas = Uteis.deepCopyBI( canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Linha linha = new Linha( p );
                novaFormaGeometrica( linha );
                manipulador = linha.getFormaHandler(linha);
                atualizar(); // repinta JFrame
            }break;

            case (Lapis.NOME):{
                snapCanvas = Uteis.deepCopyBI( canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Lapis lapis = new Lapis( p );
                novaFormaGeometrica( lapis );
                manipulador = lapis.getFormaHandler(lapis);
                atualizar(); // repinta JFrame
            }break;

            case (Quadrado.NOME):{
                snapCanvas = Uteis.deepCopyBI( canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Quadrado quadrado = new Quadrado( p );
                novaFormaGeometrica( quadrado );
                manipulador = quadrado.getFormaHandler(quadrado);
                atualizar(); // repinta JFrame
            }break;

            case (Retangulo.NOME):{
                snapCanvas = Uteis.deepCopyBI( canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Retangulo retangulo = new Retangulo( p );
                novaFormaGeometrica( retangulo );
                manipulador = retangulo.getFormaHandler(retangulo);
                atualizar(); // repinta JFrame
            }break;

            case (Circulo.NOME):{
                snapCanvas = Uteis.deepCopyBI( canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Circulo circulo = new Circulo( p );
                novaFormaGeometrica( circulo );
                manipulador = circulo.getFormaHandler(circulo);
                atualizar(); // repinta JFrame
            }break;




            default: break;
        }




        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "pressionando.." );
        System.out.println("pressionou..");
        System.out.println("formas selecionadas -> " + listaManipuladoresSelecionados.size());

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
            case (MouseSelect.NOME):{
                if (manipulador != null){
                    manipulador.drag(e.getPoint().x, e.getPoint().y );

                    //1. metodo verifica em cada forma se Rect_de_selecao intersecta com alguma forma
                    //2. retorna lista de manipuladores intersectores
                    this.verificaSelecionados();
                    //3. pinta-los-ei de vermei em atualizar()

                    atualizar();
                }
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
                    atualizar();
                }
            }break;
        }

        //atualiza as posicoes do mouse nos labels
        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "arrastando.." );
        System.out.println("arrastando..");
        System.out.println("formas selecionadas -> " + listaManipuladoresSelecionados.size());
    }

    private void verificaSelecionados() {

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

    @Override
    public void mouseMoved(MouseEvent e) {
        //atualiza as posicoes do mouse nos labels
        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "movendo.." );
    }
    @Override
    public void mouseReleased(MouseEvent e) {


        switch (states.getSelectedTool()){

            case (MouseSelect.NOME):{
                manipulador = null;
                canvas = Uteis.deepCopyBI(snapCanvas);
                atualizar();

            }break;



            default: {

            }break;
        }












        labelX.setText( String.valueOf( e.getPoint().x ) );
        labelY.setText( String.valueOf( e.getPoint().y ) );
        labelEventoMouse.setText( "soltou.." );
        System.out.println("soltou..");
        System.out.println("formas selecionadas -> " + listaManipuladoresSelecionados.size());

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
        if (manipulador != null){
            canvas = Uteis.deepCopyBI(snapCanvas);

            Graphics2D newGraph = (Graphics2D) canvas.createGraphics();
            newGraph.setColor(Color.BLACK);
            manipulador.paint(newGraph);

            newGraph.dispose();
        }

        //pinta formas selecionadas de vermelho se houver
        if (! listaManipuladoresSelecionados.isEmpty()){
            Graphics2D newGraph = (Graphics2D) canvas.createGraphics();
            newGraph.setColor(Color.RED);
            listaManipuladoresSelecionados.forEach(formaHandler ->{
                formaHandler.paint(newGraph);
                System.out.println("pintou de VERMEI" +formaHandler.getForma().toString());

            });
            newGraph.setColor(Color.BLACK);
            newGraph.dispose();
        }

        g.drawImage(canvas, 0, 0, null);
//        repaint(); //loop infinito na thead!!
        System.out.println("pintou");



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
