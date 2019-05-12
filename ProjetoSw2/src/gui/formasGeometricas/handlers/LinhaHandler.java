package gui.formasGeometricas.handlers;

import gui.formasGeometricas.Linha;
import gui.formasGeometricas.Ponto;

import java.awt.*;

public class LinhaHandler implements InterfaceFormaHandler {
    private Linha l;

    public LinhaHandler(Linha l) {
        this.l = l;
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
        l.setB(new Ponto(x, y));
    }

    @Override
    public void paint(Graphics g) {

    }
}
