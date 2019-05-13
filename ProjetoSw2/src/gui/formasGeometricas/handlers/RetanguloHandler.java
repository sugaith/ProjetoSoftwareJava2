package gui.formasGeometricas.handlers;

import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import gui.formasGeometricas.Retangulo;

import java.awt.*;

public class RetanguloHandler implements InterfaceFormaHandler {
    private Retangulo retangulo;

    public RetanguloHandler(Retangulo l) {
        this.retangulo = l;
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

    @Override
    public void paint(Graphics g) {



        int px = Math.min( retangulo.getA().getX(), retangulo.getB().getX() );
        int py = Math.min( retangulo.getA().getY(), retangulo.getB().getY() );
        int pw = Math.abs( retangulo.getA().getX() - retangulo.getB().getX() );
        int ph = Math.abs( retangulo.getA().getY() - retangulo.getB().getY() );

        g.drawRect(px, py, pw, ph);


    }
}
