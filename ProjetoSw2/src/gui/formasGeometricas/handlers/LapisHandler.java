package gui.formasGeometricas.handlers;

import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.Lapis;
import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import utils.Uteis;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

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
    public void translade(int w, int h) {
        lapis.getListaPontos().forEach( ponto -> {
            ponto.setX( ponto.getX() + w);
            ponto.setY( ponto.getY() + h);
        });
    }

    @Override
    public void rotate(Ponto eixo, int gr) {
        lapis.getListaPontos().forEach( ponto -> {
            Ponto novoPonto = Uteis.rotacionaPonto( ponto, eixo, gr );
            ponto.setX( novoPonto.getX() );
            ponto.setY( novoPonto.getY() );
        });
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
