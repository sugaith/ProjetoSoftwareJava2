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
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Thiago Correa
 */
public class Lapis implements FormaGeometrica {
    public static final String NOME = "Lapis";
    public static final byte ID = 6;

    private List<Ponto> listaPontos = new ArrayList<>();

    public Lapis(Ponto p) {
        listaPontos.add(p);
    }

    public Lapis(Lapis l) {
        listaPontos.addAll(l.getListaPontos());
    }

    public Lapis(List<Ponto> listaPontos) {
        this.listaPontos.addAll(listaPontos);
    }

    public Lapis(byte[] arrayForma) {
        //aloca-se 1 p/ ID, 2 P/ tamanho, 4*tamanho p/ cada ponto

        byte[] tam = Arrays.copyOfRange(arrayForma, 1, 3);//pega o tamanho
        ByteBuffer bb_aux = ByteBuffer.allocate( 2 );
//        bb_aux.order(ByteOrder.BIG_ENDIAN);//ordem de bits esq p/ direita
        bb_aux.put(tam[0]);//tamanho vet pontos
        bb_aux.put(tam[1]);//tamanho vet pontos
        int tamanho = bb_aux.getShort(0);//tamanho vet pontos

        for (int i=3; i< tamanho*4 ; i+=4){
            try{
                ByteBuffer bb = ByteBuffer.allocate( 4 ); //aloca apenas o tam de 1 ponto = 2 shorts, 1 byte
//            bb.order(ByteOrder.LITTLE_ENDIAN);//ordem de bits esq p/ direita
                bb.put( arrayForma[ i ]) ;//x
                bb.put( arrayForma[ i + 1 ]);//x
                bb.put( arrayForma[ i + 2 ]);//y
                bb.put( arrayForma[ i + 3 ]);//y

                int x = bb.getShort(0);
                int y = bb.getShort(2);
                listaPontos.add( new Ponto(x,y) );
            }catch (Exception e){
                //vetor acabou e resto lixo??
                e.printStackTrace();
            }
        }
    }

    @Override
    public byte[] toByteArray() {
        //aloca 1 p/ ID, 2 P/ tamanho, 4*tamanho p/ cada ponto (2 shorts p/ x e 2 p/ y)
        int num_alloc = 1 + 2 + 4 * listaPontos.size();
        ByteBuffer buffer = ByteBuffer.allocate( num_alloc );

        buffer.put(ID);//id
        buffer.putShort( (short) listaPontos.size() );//tamanho (em pontos (shorts, nao bytes))
        listaPontos.forEach(p -> {//lista pontos
            buffer.putShort( (short) p.getX() );
            buffer.putShort( (short) p.getY() );
        });

        return buffer.array();
    }

    public static int getIdentificadorBinario() {
        return 0;
    }




    @Override
    public String getStrPosition() {
        StringBuffer str = new StringBuffer();
        str.append(NOME+" ");
        listaPontos.forEach(ponto -> {
            str.append("(");
            str.append(ponto.getX()).append(",").append(ponto.getY()).append("),");
        });

        return str.toString();
    }

    @Override
    public String toTextLine() {
        StringBuffer str = new StringBuffer();
        str.append(NOME+" ");
        listaPontos.forEach(ponto -> {
            str.append(ponto.getX()).append(" ").append(ponto.getY()).append(" ");
        });

        return str.toString();
    }

    @Override
    public String toString() {
        return NOME;
    }



    @Override
    public String toTextLineBD() {
        StringBuffer str = new StringBuffer();
        listaPontos.forEach(ponto -> {
            str.append(ponto.getX()).append(",").append(ponto.getY()).append(" | ");
        });

        return str.toString();
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
