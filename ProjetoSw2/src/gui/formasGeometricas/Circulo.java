package gui.formasGeometricas;

import gui.formasGeometricas.handlers.CirculoHandler;
import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.formasGeometricas.handlers.QuadradoHandler;

import java.awt.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Circulo implements FormaGeometrica {
	public static final long serialVersionUID = 2L;
	public static final String NOME = "Circulo";
	public static final byte ID = 3;

	private Ponto a;
	private Ponto b;

	public Circulo(Circulo l) {
		this.a = l.getA();
		this.b = l.getB();
	}

	public Circulo(Ponto p) {
		this.a = new Ponto(p);
		this.b = new Ponto(p);
	}

	public Circulo(Ponto a, Ponto b) {
		this.a = new Ponto(a);
		this.b = new Ponto(b);
	}

	public Circulo(byte arrayForma[]) {
		ByteBuffer bb = ByteBuffer.allocate(8);
//		bb.order(ByteOrder.LITTLE_ENDIAN);//ordem de bits esq p/ direita
		bb.put(arrayForma[1]);//x
		bb.put(arrayForma[2]);//x
		bb.put(arrayForma[3]);//y
		bb.put(arrayForma[4]);//y

		bb.put(arrayForma[5]);//x
		bb.put(arrayForma[6]);//x
		bb.put(arrayForma[7]);//y
		bb.put(arrayForma[8]);//y

		int x1 = bb.getShort(0);
		int y1 = bb.getShort(2);

		int x2 = bb.getShort(4);
		int y2 = bb.getShort(6);

		this.a = new Ponto(x1,y1);
		this.b = new Ponto(x2,y2);
	}

	@Override
	public InterfaceFormaHandler getFormaHandler(FormaGeometrica forma) {
		return new CirculoHandler(this);
	}

	@Override
	public String getStrPosition() {
		return NOME+" ("+a.getX()+", "+a.getY()+"),("+b.getX()+", "+b.getY()+");";
	}

	@Override
	public String toTextLine() {
		return NOME+" "+a.getX()+" "+a.getY()+" "+b.getX()+" "+b.getY();
	}

	@Override
	public byte[] toByteArray() {
		ByteBuffer buffer = ByteBuffer.allocate(9);
		buffer.put(ID);//id
		buffer.putShort( (short) getA().getX() );
		buffer.putShort( (short) getA().getY() );
		buffer.putShort( (short) getB().getX() );
		buffer.putShort( (short) getB().getY() );
		return buffer.array();
	}

    @Override
    public String toTextLineBD() {
		return a.getX()+","+a.getY()+" | "+b.getX()+","+b.getY();

    }


    @Override
	public String toString() {
		return NOME;
	}



	public Ponto getA() {
		return a;
	}

	public void setA(Ponto a) {
		this.a = a;
	}

	public Ponto getB() {
		return b;
	}

	public void setB(Ponto b) {
		this.b = b;
	}
}
