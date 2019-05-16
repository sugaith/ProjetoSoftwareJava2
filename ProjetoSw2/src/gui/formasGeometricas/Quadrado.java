package gui.formasGeometricas;

import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.formasGeometricas.handlers.LinhaHandler;
import gui.formasGeometricas.handlers.QuadradoHandler;

import java.awt.*;

public class Quadrado implements FormaGeometrica {
	public static final long serialVersionUID = 2L;
	public static final String NOME = "Quadrado";
	private Ponto a;
	private Ponto b;

	public Quadrado(Quadrado l) {
		this.a = l.getA();
		this.b = l.getB();
	}

	public Quadrado(Ponto p) {
		this.a = new Ponto(p);
		this.b = new Ponto(p);
	}

	public Quadrado(Ponto a, Ponto b) {
		this.a = new Ponto(a);
		this.b = new Ponto(b);
	}

	public Quadrado(byte bytes[]) {
//		if (ByteBuffer.wrap(bytes, 0, 8).getLong() != serialVersionUID) {
//			a.x = 0;
//			a.y = 0;
//			b.x = 0;
//			b.y = 0;
//			return;
//		}
//		a.x = ByteBuffer.wrap(bytes, 8, 12).getInt();
//		a.y = ByteBuffer.wrap(bytes, 12, 16).getInt();
//		b.x = ByteBuffer.wrap(bytes, 16, 20).getInt();
//		b.y = ByteBuffer.wrap(bytes, 20, 24).getInt();
	}

	@Override
	public InterfaceFormaHandler getFormaHandler(FormaGeometrica forma) {
		return new QuadradoHandler(this);
	}

	@Override
	public String getStrPosition() {
		return NOME+" ("+a.getX()+", "+a.getY()+"),("+b.getX()+", "+b.getY()+");";
	}

	@Override
	public String toTextLine() {
		return NOME+" "+a.getX()+" "+a.getY()+" "+b.getX()+"  "+b.getY();
	}

	@Override
	public byte[] toByteArray() {
		return new byte[0];
	}


	@Override
	public String toString() {		return NOME;	}



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
