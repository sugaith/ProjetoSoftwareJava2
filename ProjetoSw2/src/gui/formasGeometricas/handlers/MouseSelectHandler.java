package gui.formasGeometricas.handlers;

import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import gui.formasGeometricas.Retangulo;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class MouseSelectHandler implements InterfaceFormaHandler {
    private MouseSelect mouseSelect;


    public MouseSelectHandler(MouseSelect l) {
        this.mouseSelect = l;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        int px = Math.min( mouseSelect.getA().getX(), mouseSelect.getB().getX() );
        int py = Math.min( mouseSelect.getA().getY(), mouseSelect.getB().getY() );
        int pw=Math.abs( mouseSelect.getA().getX() - mouseSelect.getB().getX() );
        int ph=Math.abs( mouseSelect.getA().getY() - mouseSelect.getB().getY() );

        g.drawRect(px, py, pw, ph);
        g.setColor(Color.BLACK);
    }

    @Override
    public boolean intersects(MouseSelect mouseSelect) {
        return false;
    }

    @Override
    public void translade(int w, int h) {

    }

    @Override
    public void rotate(Ponto eixo, int gr) {

    }

    @Override
    public FormaGeometrica getForma() {
        return mouseSelect;
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
        mouseSelect.setB(new Ponto(x, y));
    }


}
