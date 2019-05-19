package utils;

import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.text.SimpleDateFormat;
import java.util.Date;

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


    public static String showInput(String msg){
        return JOptionPane.showInputDialog(msg);
    }

    public static void showAlert(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }


    public static String date2TS(Date d){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (d == null)
                return "0000-00-00 00:00:00";

            return formatter.format(d);
        } catch (Exception e) {
            System.out.println("Erro de conversão ( date2TS() )");
            e.printStackTrace();
            return null;
        }
    }
    public static Date ts2Date(String ts){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if(ts == null)
                return null;

            return formatter.parse(ts);
        } catch (Exception e) {
            System.out.println("Erro de conversão ( ts2Date() )");
            e.printStackTrace();
            return null;
        }
    }


}
