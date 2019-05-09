package gui.formasGeometricas.handlers;

import java.awt.*;

public interface  InterfaceFormaHandler {
    void click (int x, int y);
    void press(int x, int y);
    void release (int x, int y);
    void drag (int x, int y);
    void paint (Graphics g);
}
