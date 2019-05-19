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
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.stream.Collectors;

/**
 *
 * @author Thiago Correa
 */
public class Ponto implements FormaGeometrica {
    public static final String NOME = "Ponto";
    public static final byte ID = 1;
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

//        this.x = (arrayForma[0]);
//        this.y = (arrayForma[1]);

        ByteBuffer bb = ByteBuffer.allocate(4);
//        bb.order(ByteOrder.LITTLE_ENDIAN);//ordem de bits esq p/ direita
        bb.put(arrayForma[1]);//x
        bb.put(arrayForma[2]);//x
        bb.put(arrayForma[3]);//y
        bb.put(arrayForma[4]);//y

        this.x = bb.getShort(0);
        this.y = bb.getShort(2);
    }

    @Override
    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put(ID);//id
        buffer.putShort( (short) x );
        buffer.putShort( (short) y );
        return buffer.array();
    }


    @Override
    public String getStrPosition() {
        return "Ponto ("+x+", "+y+");";
    }

    @Override
    public String toTextLine() {
        return NOME+" " + x + " " + y;
    }

    @Override
    public String toString() {
        return NOME;
    }



    @Override
    public String toTextLineBD() {
        return x+","+y;

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
