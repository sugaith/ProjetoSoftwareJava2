package utils;

import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;

import java.awt.*;
import java.awt.geom.Rectangle2D;
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

    public static Rectangle2D mouseSelect_toRetangle(MouseSelect mouseSelect) {

        int px = Math.min( mouseSelect.getA().getX(), mouseSelect.getB().getX() );
        int py = Math.min( mouseSelect.getA().getY(), mouseSelect.getB().getY() );
        int pw = Math.abs( mouseSelect.getA().getX() - mouseSelect.getB().getX() );
        int ph = Math.abs( mouseSelect.getA().getY() - mouseSelect.getB().getY() );


        return new Rectangle(px,py,pw,ph);
    }


}
