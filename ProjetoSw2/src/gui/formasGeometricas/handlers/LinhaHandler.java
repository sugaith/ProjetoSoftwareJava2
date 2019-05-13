package gui.formasGeometricas.handlers;

import gui.formasGeometricas.Linha;
import gui.formasGeometricas.Ponto;

import java.awt.*;

public class LinhaHandler implements InterfaceFormaHandler {
    private Linha linha;
    private Linha eraseLinha = null;

    public LinhaHandler(Linha l) {
        this.linha = l;
    }

    @Override
    public void click(int x, int y) {

    }

    @Override
    public void press(int x, int y) {

    }

    @Override
    public void release(int x, int y) {

    }

    @Override
    public void drag(int x, int y) {
        eraseLinha = new Linha(linha);
        linha.setB(new Ponto(x, y));
    }

    @Override
    public void paint(Graphics g) {
        //apaga linha anterior
//        if (eraseLinha != null){
////            g.setColor( new Color(0f,0f,0f,1f ) );
//            g.setColor(Color.WHITE);
//            g.drawLine(eraseLinha.getA().getX(), eraseLinha.getA().getY(), eraseLinha.getB().getX(), eraseLinha.getB().getY());
//            g.setColor(Color.BLACK);
//            eraseLinha = null;
//        }

        g.drawLine(linha.getA().getX(), linha.getA().getY(), linha.getB().getX(), linha.getB().getY());
    }
}
