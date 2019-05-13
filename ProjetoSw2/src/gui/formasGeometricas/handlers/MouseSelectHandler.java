package gui.formasGeometricas.handlers;

import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import gui.formasGeometricas.Retangulo;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MouseSelectHandler implements InterfaceFormaHandler {
    private MouseSelect mouseSelect;


    public MouseSelectHandler(MouseSelect l) {
        this.mouseSelect = l;
        Polygon p = new Polygon();
        p.addPoint(16, 14);
        p.addPoint(12, 18);
        p.addPoint(8, 14);
        p.addPoint(12, 10);
//        p.intersects()
//        p.getPathIterator()
//        p.getBounds2D()


                System.out.println(p.toString());

//        Shape circle = new Ellipse2D.Double(100, 100, 100, 100);
//        circle.contains()

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
}
