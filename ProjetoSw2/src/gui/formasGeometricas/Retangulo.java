package gui.formasGeometricas;

import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.formasGeometricas.handlers.MouseSelectHandler;
import gui.formasGeometricas.handlers.QuadradoHandler;
import gui.formasGeometricas.handlers.RetanguloHandler;

import java.awt.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Retangulo implements FormaGeometrica {
	public static final long serialVersionUID = 2L;
	public static final byte ID = 4;

	public static final String NOME = "Retangulo";
	private Ponto a;
	private Ponto b;

	private Ponto c;
	private Ponto d;

	public Retangulo(Retangulo l) {
		this.a = l.getA();
		this.b = l.getB();
		this.c = l.getC();
		this.d = l.getD();
	}

	public Retangulo(Ponto p) {
		this.a = new Ponto(p);
		this.b = new Ponto(p);
		this.c = new Ponto(p);
		this.d = new Ponto(p);
	}

	public Retangulo(Ponto a, Ponto b) {
		this.a = new Ponto(a);
		this.b = new Ponto(b);

//		int px = Math.min( getA().getX(), getB().getX() );
//		int py = Math.min( getA().getY(), getB().getY() );
//		int pw = Math.abs( getA().getX() - getB().getX() );
//		int ph = Math.abs( getA().getY() - getB().getY() );
//
//		Polygon p = new Polygon();
//
//
//		p.addPoint(px, py);
//		p.addPoint(px +pw, py  );
//		p.addPoint(px + pw , py + ph);
//		p.addPoint(px , py + ph);
	}

	public Retangulo(byte arrayForma[]) {
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
		return new RetanguloHandler(this);
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

	public Ponto getC() {
		return c;
	}

	public void setC(Ponto c) {
		this.c = c;
	}

	public Ponto getD() {
		return d;
	}

	public void setD(Ponto d) {
		this.d = d;
	}
}
