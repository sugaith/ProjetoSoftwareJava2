package gui.formasGeometricas;

import gui.formasGeometricas.handlers.CirculoHandler;
import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.formasGeometricas.handlers.QuadradoHandler;

import java.awt.*;

public class Circulo implements FormaGeometrica {
	public static final long serialVersionUID = 2L;
	public static final String NOME = "Circulo";
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

	public Circulo(byte bytes[]) {

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
		return NOME+" "+a.getX()+" "+a.getY()+" "+b.getX()+"  "+b.getY();
	}

	@Override
	public byte[] toByteArray() {
		return new byte[0];
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
