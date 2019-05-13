package gui.formasGeometricas.handlers;

import gui.formasGeometricas.Circulo;
import gui.formasGeometricas.Ponto;
import gui.formasGeometricas.Retangulo;
import gui.uteis.Uteis;

import java.awt.*;

public class CirculoHandler implements InterfaceFormaHandler {
    private Circulo circulo;

    public CirculoHandler(Circulo l) {
        this.circulo = l;
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

    @Override
    public void paint(Graphics g) {
        int r = Uteis.distanciaEuclidiana( circulo.getA(), circulo.getB() );

        int x = circulo.getA().getX() - (r/2);
        int y = circulo.getA().getY() - (r/2);
        g.drawOval(x,y,r,r);

//        g.drawOval(circulo.getA().getX(), circulo.getB().getX(), circulo.getA().getY(), circulo.getB().getY());
    }
}
