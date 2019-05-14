package gui.formasGeometricas.handlers;

import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.Lapis;
import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import utils.Uteis;

import java.awt.*;
import java.awt.geom.Area;

public class LapisHandler implements InterfaceFormaHandler {
    private Lapis lapis;

    public LapisHandler(Lapis l) {
        this.lapis = l;
    }

    @Override
    public void paint(Graphics g) {
        lapis.getListaPontos().forEach(ponto ->
                g.fillOval(ponto.getX(), ponto.getY(), 4, 4));
    }

    @Override
    public boolean intersects(MouseSelect mouseSelect) {
        Area area = new Area( Uteis.mouseSelect_toRetangle(mouseSelect) );
        boolean ret_aux = false;

        ret_aux = lapis.getListaPontos()
                .stream()
                .anyMatch(ponto ->
                        area.contains(ponto.getX(), ponto.getY()));

        return ret_aux;
    }

    @Override
    public FormaGeometrica getForma() {
        return lapis;
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


}
