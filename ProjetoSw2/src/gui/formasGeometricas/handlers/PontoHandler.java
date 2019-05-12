package gui.formasGeometricas.handlers;

import gui.formasGeometricas.Ponto;

import java.awt.*;

public class PontoHandler implements InterfaceFormaHandler {
    private Ponto p;

    public PontoHandler(Ponto p) {
        this.p = p;
    }

    @Override
    public void click(int x, int y) {
        p.setX(x);
        p.setY(y);
    }

    @Override
    public void press(int x, int y) {
        p.setX(x);
        p.setY(y);
    }

    @Override
    public void release(int x, int y) {
        p.setX(x);
        p.setY(y);
    }

    @Override
    public void drag(int x, int y) {
        p.setX(x);
        p.setY(y);
    }

    @Override
    public void paint(Graphics g) {
        g.fillOval(p.getX(), p.getY(), 4, 4);
    }
}
