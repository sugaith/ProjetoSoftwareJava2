package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Uteis {
//    xRot = xCenter + cos(Angle) * (x - xCenter) - sin(Angle) * (y - yCenter)
//    yRot = yCenter + sin(Angle) * (x - xCenter) + cos(Angle) * (y - yCenter)
//        Note that in most programming languages you will need to give Angle in radian,
//        so multiply your degree value with Pi devided by 180
//        (Angle = Degree * PI / 180).



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
