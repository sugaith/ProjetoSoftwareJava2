package gui.formasGeometricas.handlers;

import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Quadrado;
import gui.formasGeometricas.Ponto;
import utils.Uteis;

import java.awt.*;
import java.awt.geom.Area;

public class QuadradoHandler implements InterfaceFormaHandler {
    private Quadrado quadrado;

    public QuadradoHandler(Quadrado l) {
        this.quadrado = l;
    }

    @Override
    public void paint(Graphics g) {
//        g.drawRect(quadrado.getA().getX(), quadrado.getA().getY(), quadrado.getB().getX(), quadrado.getB().getY());


        int r = Uteis.distanciaEuclidiana( quadrado.getA(), quadrado.getB() );

        int x = quadrado.getA().getX() - (r/2);
        int y = quadrado.getA().getY() - (r/2);
        g.drawRect(x,y,r,r);
    }


    @Override
    public boolean intersects(MouseSelect mouseSelect) {
        int r = Uteis.distanciaEuclidiana( quadrado.getA(), quadrado.getB() );

        int x = quadrado.getA().getX() - (r/2);
        int y = quadrado.getA().getY() - (r/2);

        Polygon p = new Polygon();

        p.addPoint(x, y);
        p.addPoint(x+r, y);
        p.addPoint(x, y+r);
        p.addPoint(x+r, y+r);

        Area area = new Area(p);

        return area.intersects( Uteis.mouseSelect_toRetangle( mouseSelect ) );
    }

    @Override
    public void translade(int w, int h) {
        quadrado.setA(new Ponto( quadrado.getA().getX() + w, quadrado.getA().getY() + h  ));
        quadrado.setB(new Ponto( quadrado.getB().getX() + w, quadrado.getB().getY() + h  ));
    }

    @Override
    public void rotate(Ponto eixo, int gr) {
        quadrado.setA(Uteis.rotacionaPonto(quadrado.getA(), eixo, gr));
        quadrado.setB(Uteis.rotacionaPonto(quadrado.getB(), eixo, gr));
    }

    @Override
    public FormaGeometrica getForma() {
        return quadrado;
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
        quadrado.setB(new Ponto(x, y));
    }


}
