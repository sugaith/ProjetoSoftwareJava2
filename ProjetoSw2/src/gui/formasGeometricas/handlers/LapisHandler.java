package gui.formasGeometricas.handlers;

import gui.formasGeometricas.Lapis;
import gui.formasGeometricas.Ponto;

import java.awt.*;

public class LapisHandler implements InterfaceFormaHandler {
    private Lapis lapis;

    public LapisHandler(Lapis l) {
        this.lapis = l;
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
        lapis.getListaPontos().add( new Ponto(x, y) );
    }

    @Override
    public void paint(Graphics g) {
        lapis.getListaPontos().forEach(ponto ->
                g.fillOval(ponto.getX(), ponto.getY(), 4, 4));
    }
}
