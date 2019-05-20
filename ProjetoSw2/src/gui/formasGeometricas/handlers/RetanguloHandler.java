package gui.formasGeometricas.handlers;

import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.MouseSelect;
import gui.formasGeometricas.Ponto;
import gui.formasGeometricas.Retangulo;
import utils.Uteis;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class RetanguloHandler implements InterfaceFormaHandler {
    private Retangulo retangulo;

    public RetanguloHandler(Retangulo l) {
        this.retangulo = l;
    }

    @Override
    public void paint(Graphics g) {


//
//        int px = Math.min( retangulo.getA().getX(), retangulo.getB().getX() );
//        int py = Math.min( retangulo.getA().getY(), retangulo.getB().getY() );
//        int pw = Math.abs( retangulo.getA().getX() - retangulo.getB().getX() );
//        int ph = Math.abs( retangulo.getA().getY() - retangulo.getB().getY() );
//
//        Polygon p = new Polygon();
//
//        p.addPoint(px, py);
//        p.addPoint(px , py + ph);
//        p.addPoint(px + pw , py + ph);
//        p.addPoint(px +pw, py  );


//        //TODO novo com 4 pontos
        Polygon p = new Polygon();

        p.addPoint(retangulo.getA().getX(), retangulo.getA().getY());
        p.addPoint(retangulo.getB().getX(), retangulo.getB().getY());
        p.addPoint(retangulo.getC().getX(), retangulo.getC().getY());
        p.addPoint(retangulo.getD().getX(), retangulo.getD().getY());

        g.drawPolygon(p);



//        g.drawRect(px, py, pw, ph);


    }

    @Override
    public boolean intersects(MouseSelect mouseSelect) {

        int px = Math.min( retangulo.getA().getX(), retangulo.getB().getX() );
        int py = Math.min( retangulo.getA().getY(), retangulo.getB().getY() );
        int pw = Math.abs( retangulo.getA().getX() - retangulo.getB().getX() );
        int ph = Math.abs( retangulo.getA().getY() - retangulo.getB().getY() );

        Polygon p = new Polygon();

//        p.addPoint(px, py);
//        p.addPoint(px +pw, py  );
//        p.addPoint(px + pw , py + ph);
//        p.addPoint(px , py + ph);


        //TODO COM 4 PONTOS
        p.addPoint(retangulo.getA().getX(), retangulo.getA().getY());
        p.addPoint(retangulo.getB().getX(), retangulo.getB().getY());
        p.addPoint(retangulo.getC().getX(), retangulo.getC().getY());
        p.addPoint(retangulo.getD().getX(), retangulo.getD().getY());




        Area area = new Area(p);

        return area.intersects( Uteis.mouseSelect_toRetangle( mouseSelect ) );
    }

    @Override
    public void translade(int w, int h) {
        retangulo.setA(new Ponto( retangulo.getA().getX() + w, retangulo.getA().getY() + h  ));
        retangulo.setB(new Ponto( retangulo.getB().getX() + w, retangulo.getB().getY() + h  ));
        retangulo.setC(new Ponto( retangulo.getC().getX() + w, retangulo.getC().getY() + h  ));
        retangulo.setD(new Ponto( retangulo.getD().getX() + w, retangulo.getD().getY() + h  ));
    }

    @Override
    public void rotate(Ponto eixo, int gr) {
        retangulo.setA(Uteis.rotacionaPonto(retangulo.getA(), eixo, gr));
        retangulo.setB(Uteis.rotacionaPonto(retangulo.getB(), eixo, gr));
        retangulo.setC(Uteis.rotacionaPonto(retangulo.getC(), eixo, gr));
        retangulo.setD(Uteis.rotacionaPonto(retangulo.getD(), eixo, gr));
    }

    @Override
    public void drag(int x, int y) {
        retangulo.setB(new Ponto(x, y));


        //todo adivinhar pontos C e D (outra diagonal)
        int px = Math.min( retangulo.getA().getX(), retangulo.getB().getX() );
        int py = Math.min( retangulo.getA().getY(), retangulo.getB().getY() );
        int pw = Math.abs( retangulo.getA().getX() - retangulo.getB().getX() );
        int ph = Math.abs( retangulo.getA().getY() - retangulo.getB().getY() );

//        Polygon p = new Polygon();

//        if ((retangulo.getA().getX() - retangulo.getB().getX()) < 0)
        retangulo.setA(new Ponto( px , py ));
        retangulo.setB(new Ponto( px + pw, py ));
        retangulo.setC(new Ponto( px + pw , py + ph ));
        retangulo.setD(new Ponto( px , py + ph ));


//        retangulo.setA(new Ponto( px , py ));
//        retangulo.setB(new Ponto( px + pw, py ));
//        retangulo.setC(new Ponto( retangulo.getA().getX() + retangulo.getA().getX() - retangulo.getB().getX() , retangulo.getA().getY() + retangulo.getA().getY() - retangulo.getB().getY() ));
//        retangulo.setD(new Ponto( retangulo.getA().getX() , retangulo.getA().getY() + retangulo.getA().getY() - retangulo.getB().getY() ));

//        p.addPoint(px, py);
//        p.addPoint(px +pw, py  );
//        p.addPoint(px + pw , py + ph);
//        p.addPoint(px , py + ph);
//
//        g.drawPolygon(p);


    }

    @Override
    public FormaGeometrica getForma() {
        return retangulo;
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




}
