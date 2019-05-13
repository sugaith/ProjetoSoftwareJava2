package gui.formasGeometricas.handlers;

import gui.formasGeometricas.Quadrado;
import gui.formasGeometricas.Ponto;
import utils.Uteis;

import java.awt.*;

public class QuadradoHandler implements InterfaceFormaHandler {
    private Quadrado quadrado;

    public QuadradoHandler(Quadrado l) {
        this.quadrado = l;
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

    @Override
    public void paint(Graphics g) {
//        g.drawRect(quadrado.getA().getX(), quadrado.getA().getY(), quadrado.getB().getX(), quadrado.getB().getY());


        int r = Uteis.distanciaEuclidiana( quadrado.getA(), quadrado.getB() );

        int x = quadrado.getA().getX() - (r/2);
        int y = quadrado.getA().getY() - (r/2);
        g.drawRect(x,y,r,r);
    }
}
