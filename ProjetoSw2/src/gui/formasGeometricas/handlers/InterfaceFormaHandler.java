package gui.formasGeometricas.handlers;

import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.MouseSelect;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public interface  InterfaceFormaHandler {
    void click (int x, int y);
    void press(int x, int y);
    void release (int x, int y);
    void drag (int x, int y);
    void paint (Graphics g);

    boolean intersects(MouseSelect mouseSelect);
    FormaGeometrica getForma();
}
