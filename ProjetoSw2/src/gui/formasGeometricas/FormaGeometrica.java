package gui.formasGeometricas;

import java.awt.*;
import java.beans.Transient;
import java.io.Serializable;

public interface FormaGeometrica extends Serializable {

    String toString();
    @Transient
    void desenhar(Graphics g);

    String getStrPosition();
    String toTextLine();
    byte[] toByteArray();


}
