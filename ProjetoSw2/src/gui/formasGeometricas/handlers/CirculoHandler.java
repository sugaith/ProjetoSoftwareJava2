package gui.formasGeometricas.handlers;

import gui.formasGeometricas.Circulo;
import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import utils.Uteis;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class CirculoHandler implements InterfaceFormaHandler {
    private Circulo circulo;

    public CirculoHandler(Circulo l) {
        this.circulo = l;
    }

    @Override
    public void paint(Graphics g) {

        int r = Uteis.distanciaEuclidiana( circulo.getA(), circulo.getB() );

        int x = circulo.getA().getX() - (r/2);
        int y = circulo.getA().getY() - (r/2);
        g.drawOval(x,y,r,r);

//        g.drawOval(circulo.getA().getX(), circulo.getB().getX(), circulo.getA().getY(), circulo.getB().getY());
    }

    @Override
    public boolean intersects(MouseSelect mouseSelect) {

        int r = Uteis.distanciaEuclidiana( circulo.getA(), circulo.getB() );

        int x = circulo.getA().getX() - (r/2);
        int y = circulo.getA().getY() - (r/2);
        Shape circle = new Ellipse2D.Double(x, y, r, r);

        Area area = new Area(circle);

        return area.intersects( Uteis.mouseSelect_toRetangle( mouseSelect ) );
    }

    @Override
    public void translade(int w, int h) {

        circulo.setA(new Ponto( circulo.getA().getX() + w, circulo.getA().getY() + h  ));
        circulo.setB(new Ponto( circulo.getB().getX() + w, circulo.getB().getY() + h  ));

    }

    @Override
    public void rotate(Ponto eixo, int gr) {
        circulo.setA(Uteis.rotacionaPonto(circulo.getA(), eixo, gr));
        circulo.setB(Uteis.rotacionaPonto(circulo.getB(), eixo, gr));
    }

    @Override
    public FormaGeometrica getForma() {
        return circulo;
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
        circulo.setB(new Ponto(x, y));
    }


}
