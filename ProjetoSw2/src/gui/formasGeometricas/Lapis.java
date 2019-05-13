/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.formasGeometricas;

import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.formasGeometricas.handlers.LapisHandler;
import gui.formasGeometricas.handlers.PontoHandler;

import java.awt.*;
import java.beans.Transient;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago Correa
 */
public class Lapis implements FormaGeometrica {
    public static final String NOME = "Lapis";
    private List<Ponto> listaPontos = new ArrayList<>();

    public Lapis(Ponto p) {
        listaPontos.add(p);
    }

    public Lapis(Lapis l) {
        listaPontos.addAll(l.getListaPontos());
    }



    public static int getIdentificadorBinario() {
        return 0;
    }

    @Transient
    @Override
    public   void desenhar(  Graphics g) {
//        g.setColor(Color.RED);
        listaPontos.forEach(ponto ->
                g.fillOval(ponto.getX(), ponto.getY(), 2, 2));
    }

    @Override
    public String getStrPosition() {
        StringBuffer str = new StringBuffer();
        str.append("Lapis (");
        listaPontos.forEach(ponto -> {
            str.append(ponto.getX()).append(",").append(ponto.getY()).append("),");
        });

        return str.toString();
    }

    @Override
    public String toTextLine() {
        return "Lapis ----";
    }

    @Override
    public String toString() {
        return NOME;
    }

    @Override
    public byte[] toByteArray() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//        baos.write( this.getIdentificadorBinario() );
//        baos.write( x );
//        baos.write( y );

        return baos.toByteArray();
    }

    @Override
    public InterfaceFormaHandler getFormaHandler(FormaGeometrica forma) {
        return new LapisHandler(this);
    }

    public List<Ponto> getListaPontos() {
        return listaPontos;
    }

    public void setListaPontos(List<Ponto> listaPontos) {
        this.listaPontos = listaPontos;
    }
}
