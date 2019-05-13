package gui.uteis;

import gui.formasGeometricas.Ponto;

public class Uteis {

    public static int distanciaEuclidiana(Ponto pa, Ponto pb){
        double ax, ay, bx, by;
        ax = pa.getX();
        ay = pa.getY();
        bx = pb.getX();
        by = pb.getY();
        return (int) Math.sqrt( Math.pow(bx - ax, 2) + Math.pow(by - ay, 2) );
    }


}
