/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.formasGeometricas;

import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.formasGeometricas.handlers.PontoHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.Transient;
import java.io.ByteArrayOutputStream;
import java.util.stream.Collectors;

/**
 *
 * @author Thiago Correa
 */
public class Ponto implements FormaGeometrica {
    public static final String NOME = "Ponto";
    private int x;
    private int y;

    public Ponto(Ponto p) {
        x = p.getX();
        y = p.getY();
    }

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Ponto(byte[] arrayForma) {
//        this.x = (arrayForma[0] & 0xFF);
//        this.y = (arrayForma[1] & 0xFF);
        this.x = (arrayForma[0]);
        this.y = (arrayForma[1]);
    }

    public static int getIdentificadorBinario() {
        return 1;
    }

    @Transient
    @Override
    public   void desenhar(  Graphics g) {
//        g.setColor(Color.RED);
        g.fillOval(x, y, 4, 4);

    }

    @Override
    public String getStrPosition() {
        return "Ponto ("+x+", "+y+");";
    }

    @Override
    public String toTextLine() {
        return "Ponto " + x + " " + y;
    }

    @Override
    public String toString() {
        return NOME;
    }

    @Override
    public byte[] toByteArray() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        baos.write( this.getIdentificadorBinario() );
        baos.write( x );
        baos.write( y );

        return baos.toByteArray();
    }

    @Override
    public InterfaceFormaHandler getFormaHandler(FormaGeometrica forma) {
        return new PontoHandler(this);
    }

    public int getX(){
        return x;
    }
    
    public void setX(int  x){
        this.x = x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    
}
