package gui.formasGeometricas.handlers;

import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.Linha;
import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import javafx.scene.shape.Line;
import utils.Uteis;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Line2D;

public class LinhaHandler implements InterfaceFormaHandler {
    private Linha linha;
    private Linha eraseLinha = null;

    public LinhaHandler(Linha l) {
        this.linha = l;
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

    @Override
    public boolean intersects(MouseSelect mouseSelect) {

        Line2D l = new Line2D.Double(linha.getA().getX(),linha.getA().getY() ,linha.getB().getX() ,linha.getB().getY());

        return l.intersects( Uteis.mouseSelect_toRetangle( mouseSelect ) );
    }

    @Override
    public FormaGeometrica getForma() {
        return linha;
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


}
