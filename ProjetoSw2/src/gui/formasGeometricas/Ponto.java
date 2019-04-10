/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.formasGeometricas;

import java.awt.Graphics;
import java.beans.Transient;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author Thiago Correa
 */
public class Ponto implements FormaGeometrica {
    private int x;
    private int y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Ponto(byte[] arrayForma) {
        this.x = (arrayForma[0] & 0xFF);
        this.y = (arrayForma[1] & 0xFF);
    }


    public static int getIdentificadorBinario() {
        return 1;
    }

    @Transient
    @Override
    public   void desenhar(  Graphics g) {
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
        return "Ponto";
    }

    @Override
    public byte[] toByteArray() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        baos.write( this.getIdentificadorBinario() );
        baos.write( x );
        baos.write( y );

        return baos.toByteArray();
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
