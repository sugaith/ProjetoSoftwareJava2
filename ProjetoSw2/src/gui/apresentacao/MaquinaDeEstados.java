package gui.apresentacao;

import gui.formasGeometricas.*;
import utils.Uteis;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MaquinaDeEstados {
    public static final String DELETE = "Remover";
    public static String NONE = "NONE";
    public static String ROTATE = "Rotação";
    public static String EIXO_DEFINE = "definindo_eixo";
    public static String TRANSLATE  = "Translação";



    //TOOLS
    private String selectedTool;
    private String selectedSubTool;
    private String selectedSubSubTool;


    private PanelDesenho panelDesenho;

    public MaquinaDeEstados(PanelDesenho panelDesenho) {
        this.panelDesenho = panelDesenho;

        selectedTool = MouseSelect.NOME;
        selectedSubTool = NONE;
        selectedSubSubTool = NONE;
    }



    void mouseDragged(MouseEvent e){

        //salva forma na lista
//                    getPoints().inserirFim( new Ponto( e.getPoint().x, e.getPoint().y ) );
//                    repaint();

        //todo aqui vai ser diferenciado As formas geometricas,
        // por enquanto so tem ponto
//                    doc.inserirFim( new Ponto( e.getPoint().x, e.getPoint().y ) );
//        novaFormaGeometrica( new Ponto( e.getPoint().x, e.getPoint().y ) );
//        atualizar(); // repinta JFrame


        switch (this.getSelectedTool()){
            case (MouseSelect.NOME):{

                //todo por SWITCH CASE
                if (this.getSelectedSubTool().equals( MaquinaDeEstados.TRANSLATE )){
                    //constantes de translado
                    int w = e.getX() - panelDesenho.mouseCoords_saved.getX()  ;
                    int h = e.getY() - panelDesenho.mouseCoords_saved.getY()  ;
                    System.out.println("TRANSLADE --->");
                    System.out.println(w);
                    System.out.println(h);

//                    final int cw, ch;
//                    subtrai alguns pixels para precisao
                    double pCent = 1;
                    final int cw = (int) (w * pCent);
                    final int ch = (int) (h * pCent);

                    panelDesenho.listaManipuladoresSelecionados.forEach(handler ->{
                        handler.translade(cw,ch);
                    });

                    //salva coordenadas do mouse
                    panelDesenho.mouseCoords_saved = new Ponto(e.getX(), e.getY());
                    panelDesenho.doc.atualizaOuvintes();

                }else if (this.getSelectedSubTool().equals( MaquinaDeEstados.ROTATE )){
//                    Ponto eixo = new Ponto(850,450);
//                    int graus = 90;
                    //constante de rotacao (GRAUS
                    int gr = e.getX() - panelDesenho.mouseCoords_saved.getX()  ;
                    System.out.println("ROTATE graus --->");
                    System.out.println(gr);

                    panelDesenho.listaManipuladoresSelecionados.forEach(handler ->{
                        handler.rotate(panelDesenho.pontoEixo, gr);
                    });

                    //salva coordenadas do mouse
                    panelDesenho.mouseCoords_saved = new Ponto(e.getX(), e.getY());
                    panelDesenho.doc.atualizaOuvintes();
                }else{

                    //atualiza retangulo de selecao e selecionados
                    if (panelDesenho.manipulador != null){
                        panelDesenho.manipulador.drag(e.getPoint().x, e.getPoint().y );

                        //1. metodo verifica em cada forma se Rect_de_selecao intersecta com alguma forma
                        //2. retorna lista de manipuladores intersectores
                        panelDesenho.verificaSelecionados();
                        //3. pinta-los-ei de vermei em atualizar()
                    }
                    panelDesenho.doc.atualizaOuvintes();

                }


            }break;

//            case (Ponto.NOME):{
//                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
//                novaFormaGeometrica( p );
//                manipulador = p.getFormaHandler(p);
//                doc.atualizaOuvintes(); // repinta JFrame
//            }break;


            default: {
                if (panelDesenho.manipulador != null){
                    panelDesenho.manipulador.drag(e.getPoint().x, e.getPoint().y );
                    panelDesenho.doc.atualizaOuvintes();
                }
            }break;
        }
        
        
    }
    

    void mousePressed(MouseEvent e){

        panelDesenho.popupMenu.setVisible(false);


        //todo POR DENTRO DA MAQUINA ESTADOS
        switch (this.getSelectedTool()){

            case (MouseSelect.NOME):{
                //todo fazer SWITCH CASE


                if (this.getSelectedSubTool().equals( MaquinaDeEstados.TRANSLATE )){
                    //salva coordenadas do mouse
                    panelDesenho.mouseCoords_saved = new Ponto(e.getX(), e.getY());


//                    pinta formas selecionadas de BRANCO PARA APAGAR
                    if (! panelDesenho.listaManipuladoresSelecionados.isEmpty()){
                        Graphics2D newGraph = (Graphics2D) panelDesenho.canvas.createGraphics();
                        newGraph.setColor(Color.WHITE);
                        panelDesenho.listaManipuladoresSelecionados.forEach(formaHandler ->{
                            formaHandler.paint(newGraph);
                            System.out.println("pintou de BRANCOWW " +formaHandler.getForma().toString());
                        });
                        newGraph.setColor(Color.BLACK);

                        newGraph.dispose();
                        //limpa lista
//                        listaManipuladoresSelecionados.clear();
                    }

                    panelDesenho.snapCanvas =Uteis.deepCopyBI( panelDesenho.canvas );

                }else if (this.getSelectedSubTool().equals( MaquinaDeEstados.ROTATE )){

                    if (this.getSelectedSubSubTool().equals( MaquinaDeEstados.EIXO_DEFINE )){
                        panelDesenho.pontoEixo.setX( e.getX() );
                        panelDesenho.pontoEixo.setY( e.getY() );

                    }else{

                        //salva coordenadas do mouse
                        panelDesenho.mouseCoords_saved = new Ponto(e.getX(), e.getY());


//                    pinta formas selecionadas de BRANCO PARA APAGAR
                        if (! panelDesenho.listaManipuladoresSelecionados.isEmpty()){
                            Graphics2D newGraph = (Graphics2D) panelDesenho.canvas.createGraphics();
                            newGraph.setColor(Color.WHITE);
                            panelDesenho.listaManipuladoresSelecionados.forEach(formaHandler ->{
                                formaHandler.paint(newGraph);
                                System.out.println("pintou de BRANCOWW " +formaHandler.getForma().toString());
                            });
                            newGraph.setColor(Color.BLACK);

                            newGraph.dispose();
                            //limpa lista
//                        listaManipuladoresSelecionados.clear();
                        }
                        panelDesenho.snapCanvas =Uteis.deepCopyBI( panelDesenho.canvas );

                    }

                }else{
                    panelDesenho.snapCanvas =Uteis.deepCopyBI( panelDesenho.canvas );

                    Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                    MouseSelect retangulo = new MouseSelect( p );
//                panelDesenho.novaFormaGeometrica( retangulo );
                    panelDesenho.manipulador = retangulo.getFormaHandler(retangulo);

                    //        pinta formas selecionadas de PRETO se houver
                    if (! panelDesenho.listaManipuladoresSelecionados.isEmpty()){
                        Graphics2D newGraph = (Graphics2D) panelDesenho.snapCanvas.createGraphics();
                        newGraph.setColor(Color.BLACK);
                        panelDesenho.listaManipuladoresSelecionados.forEach(formaHandler ->{
                            formaHandler.paint(newGraph);
                            System.out.println("pintou de PRETOWW " +formaHandler.getForma().toString());
                        });
                        newGraph.dispose();

                        //limpa lista
                        panelDesenho.listaManipuladoresSelecionados.clear();
                    }

                }


                panelDesenho.doc.atualizaOuvintes(); // repinta JFrame
            }break;

            case (Ponto.NOME):{
                panelDesenho.snapCanvas =Uteis.deepCopyBI( panelDesenho.canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                panelDesenho.novaFormaGeometrica( p );
                panelDesenho.manipulador = p.getFormaHandler(p);
                panelDesenho.doc.atualizaOuvintes(); // repinta JFrame
            }break;

            case (Linha.NOME):{
                panelDesenho.snapCanvas =Uteis.deepCopyBI( panelDesenho.canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Linha linha = new Linha( p );
                panelDesenho.novaFormaGeometrica( linha );
                panelDesenho.manipulador = linha.getFormaHandler(linha);
                panelDesenho.doc.atualizaOuvintes(); // repinta JFrame
            }break;

            case (Lapis.NOME):{
                panelDesenho.snapCanvas =Uteis.deepCopyBI( panelDesenho.canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Lapis lapis = new Lapis( p );
                panelDesenho.novaFormaGeometrica( lapis );
                panelDesenho.manipulador = lapis.getFormaHandler(lapis);
                panelDesenho.doc.atualizaOuvintes(); // repinta JFrame
            }break;

            case (Quadrado.NOME):{
                panelDesenho.snapCanvas =Uteis.deepCopyBI( panelDesenho.canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Quadrado quadrado = new Quadrado( p );
                panelDesenho.novaFormaGeometrica( quadrado );
                panelDesenho.manipulador = quadrado.getFormaHandler(quadrado);
                panelDesenho.doc.atualizaOuvintes(); // repinta JFrame
            }break;

            case (Retangulo.NOME):{
                panelDesenho.snapCanvas =Uteis.deepCopyBI( panelDesenho.canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Retangulo retangulo = new Retangulo( p );
                panelDesenho.novaFormaGeometrica( retangulo );
                panelDesenho.manipulador = retangulo.getFormaHandler(retangulo);
                panelDesenho.doc.atualizaOuvintes(); // repinta JFrame
            }break;

            case (Circulo.NOME):{
                panelDesenho.snapCanvas =Uteis.deepCopyBI( panelDesenho.canvas );

                Ponto p = new Ponto( e.getPoint().x, e.getPoint().y );
                Circulo circulo = new Circulo( p );
                panelDesenho.novaFormaGeometrica( circulo );
                panelDesenho.manipulador = circulo.getFormaHandler(circulo);
                panelDesenho.doc.atualizaOuvintes(); // repinta JFrame
            }break;




            default: break;
        }






    }




    void mouseReleased(MouseEvent e) {
        switch (this.getSelectedTool()){

            case (MouseSelect.NOME):{
                panelDesenho.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

                panelDesenho.manipulador = null;
                panelDesenho.canvas = Uteis.deepCopyBI(panelDesenho.snapCanvas);
                panelDesenho.doc.atualizaOuvintes();


                if (this.getSelectedSubTool().equals(MaquinaDeEstados.TRANSLATE) ||
                        this.getSelectedSubTool().equals(MaquinaDeEstados.ROTATE)){

                    if (this.getSelectedSubTool().equals(MaquinaDeEstados.TRANSLATE)){
                        this.setSelectedSubTool(MaquinaDeEstados.NONE);
                    }

                    //se esta rotacionando e definindo eixo, state = nao definindo eixo,
                    if (this.getSelectedSubTool().equals(MaquinaDeEstados.ROTATE) &&
                        this.getSelectedSubSubTool().equals(MaquinaDeEstados.EIXO_DEFINE))
                    {
                        this.setSelectedSubSubTool(NONE);
                        panelDesenho.setCursor(new Cursor(Cursor.MOVE_CURSOR));
                    }else{
                        this.setSelectedSubTool(MaquinaDeEstados.NONE);

                        panelDesenho.iniciaCanvas();
                        panelDesenho.setPintarTodos(true);
                        panelDesenho.doc.atualizaOuvintes();
                    }

                }else{
                    //mostra popup caso haja selecionados
                    if (panelDesenho.listaManipuladoresSelecionados.size() > 0)
                        panelDesenho.showPopupMenu(e);
                }


            }break;


            default: break;
        }
    }


    void mouseEntered(MouseEvent e) {

        if (getSelectedTool().equals( MouseSelect.NOME )){
            panelDesenho.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

            if (getSelectedSubTool().equals( MaquinaDeEstados.TRANSLATE ) ||
                    getSelectedSubTool().equals( MaquinaDeEstados.ROTATE ) ){
                panelDesenho.setCursor(new Cursor(Cursor.MOVE_CURSOR));

                if (getSelectedSubSubTool().equals(MaquinaDeEstados.EIXO_DEFINE)){
                    panelDesenho.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

        }else{
            panelDesenho.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }
    }













    public String getSelectedTool() {
        return selectedTool;
    }

    public void setSelectedTool(String selectedTool) {
        this.selectedTool = selectedTool;
    }

    public String getSelectedSubTool() {
        return selectedSubTool;
    }

    public void setSelectedSubTool(String selectedSubTool) {
        this.selectedSubTool = selectedSubTool;
    }

    public String getSelectedSubSubTool() {
        return selectedSubSubTool;
    }

    public void setSelectedSubSubTool(String selectedSubSubTool) {
        this.selectedSubSubTool = selectedSubSubTool;
    }
}
