package gui.formasGeometricas;

import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.formasGeometricas.handlers.LinhaHandler;

import java.awt.Graphics;
import java.nio.ByteBuffer;

public class Linha implements FormaGeometrica {
	public static final long serialVersionUID = 2L;
	public static final String NOME = "Linha";
	private Ponto a;
	private Ponto b;

	public Linha(Linha l) {
		this.a = l.getA();
		this.b = l.getB();
	}

	public Linha(Ponto p) {
		this.a = new Ponto(p);
		this.b = new Ponto(p);
	}

	public Linha(Ponto a, Ponto b) {
		this.a = new Ponto(a);
		this.b = new Ponto(b);
	}


	@Override
	public String getStrPosition() {
		return "Linha ("+a.getX()+", "+a.getY()+"),("+b.getX()+", "+b.getY()+");";
	}

	@Override
	public String toTextLine() {
		return "Linha "+a.getX()+" "+a.getY()+" "+b.getX()+"  "+b.getY();
	}

	@Override
	public byte[] toByteArray() {
		return new byte[0];
	}

	@Override
	public InterfaceFormaHandler getFormaHandler(FormaGeometrica forma) {
		return new LinhaHandler(this);
	}

	public Linha(byte bytes[]) {
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
	public String toString() {
		return String.format("%s %s", a, b);
	}

	@Override
	public void desenhar(Graphics g) {
		g.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
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
