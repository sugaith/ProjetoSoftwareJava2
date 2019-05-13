package utils;

import gui.formasGeometricas.Ponto;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class Uteis {

    public static int distanciaEuclidiana(Ponto pa, Ponto pb){
        double ax, ay, bx, by;
        ax = pa.getX();
        ay = pa.getY();
        bx = pb.getX();
        by = pb.getY();
        return (int) Math.sqrt( Math.pow(bx - ax, 2) + Math.pow(by - ay, 2) );
    }

    public static BufferedImage deepCopyBI(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }


}
