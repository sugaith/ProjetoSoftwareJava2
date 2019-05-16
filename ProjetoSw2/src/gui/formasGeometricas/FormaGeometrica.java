package gui.formasGeometricas;

import gui.formasGeometricas.handlers.InterfaceFormaHandler;

import java.awt.*;
import java.beans.Transient;
import java.io.Serializable;

public interface FormaGeometrica extends Serializable {

    String toString();

    String getStrPosition();
    String toTextLine();
    byte[] toByteArray();

    InterfaceFormaHandler getFormaHandler(FormaGeometrica forma);


}
