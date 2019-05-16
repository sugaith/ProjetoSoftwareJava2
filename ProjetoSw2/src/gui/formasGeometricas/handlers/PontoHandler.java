package gui.formasGeometricas.handlers;

import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import utils.Uteis;

import java.awt.*;
import java.awt.geom.Area;

public class PontoHandler implements InterfaceFormaHandler {
    private Ponto ponto;

    public PontoHandler(Ponto ponto) {
        this.ponto = ponto;
    }

    @Override
    public boolean intersects(MouseSelect mouseSelect) {
        Area area = new Area( Uteis.mouseSelect_toRetangle(mouseSelect) );
        return area.contains(ponto.getX(), ponto.getY());
    }

    @Override
    public void translade(int w, int h) {
        ponto.setX( ponto.getX() + w);
        ponto.setY( ponto.getY() + h);
    }

    @Override
    public FormaGeometrica getForma() {
        return ponto;
    }

    @Override
    public void click(int x, int y) {
        ponto.setX(x);
        ponto.setY(y);
    }

    @Override
    public void press(int x, int y) {
        ponto.setX(x);
        ponto.setY(y);
    }

    @Override
    public void release(int x, int y) {
        ponto.setX(x);
        ponto.setY(y);
    }

    @Override
    public void drag(int x, int y) {
        ponto.setX(x);
        ponto.setY(y);
    }

    @Override
    public void paint(Graphics g) {
        g.fillOval(ponto.getX(), ponto.getY(), 5, 5);
    }
}
