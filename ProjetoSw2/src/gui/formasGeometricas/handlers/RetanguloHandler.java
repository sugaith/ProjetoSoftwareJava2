package gui.formasGeometricas.handlers;

import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import gui.formasGeometricas.Retangulo;
import utils.Uteis;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class RetanguloHandler implements InterfaceFormaHandler {
    private Retangulo retangulo;

    public RetanguloHandler(Retangulo l) {
        this.retangulo = l;
    }

    @Override
    public void paint(Graphics g) {



        int px = Math.min( retangulo.getA().getX(), retangulo.getB().getX() );
        int py = Math.min( retangulo.getA().getY(), retangulo.getB().getY() );
        int pw = Math.abs( retangulo.getA().getX() - retangulo.getB().getX() );
        int ph = Math.abs( retangulo.getA().getY() - retangulo.getB().getY() );

        g.drawRect(px, py, pw, ph);


    }

    @Override
    public boolean intersects(MouseSelect mouseSelect) {

        int px = Math.min( retangulo.getA().getX(), retangulo.getB().getX() );
        int py = Math.min( retangulo.getA().getY(), retangulo.getB().getY() );
        int pw = Math.abs( retangulo.getA().getX() - retangulo.getB().getX() );
        int ph = Math.abs( retangulo.getA().getY() - retangulo.getB().getY() );

        Polygon p = new Polygon();

        p.addPoint(px, py);
        p.addPoint(px +pw, py  );
        p.addPoint(px , py + ph);
        p.addPoint(px + pw , py + ph);

        Area area = new Area(p);

        return area.intersects( Uteis.mouseSelect_toRetangle( mouseSelect ) );
    }

    @Override
    public void translade(int w, int h) {
        retangulo.setA(new Ponto( retangulo.getA().getX() + w, retangulo.getA().getY() + h  ));
        retangulo.setB(new Ponto( retangulo.getB().getX() + w, retangulo.getB().getY() + h  ));
    }

    @Override
    public FormaGeometrica getForma() {
        return retangulo;
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
        retangulo.setB(new Ponto(x, y));
    }


}
