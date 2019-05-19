package gui.formasGeometricas;

import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.formasGeometricas.handlers.MouseSelectHandler;
import gui.formasGeometricas.handlers.RetanguloHandler;

import java.awt.*;

public class MouseSelect implements FormaGeometrica {
	public static final long serialVersionUID = 2L;
	public static final String NOME = "MouseSelect";
	private Ponto a;
	private Ponto b;

	public MouseSelect(MouseSelect l) {
		this.a = l.getA();
		this.b = l.getB();
	}

	public MouseSelect(Ponto p) {
		this.a = new Ponto(p);
		this.b = new Ponto(p);
	}

	public MouseSelect(Ponto a, Ponto b) {
		this.a = new Ponto(a);
		this.b = new Ponto(b);
	}

	public MouseSelect(byte bytes[]) {
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
		return new MouseSelectHandler(this);
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
    public String toTextLineBD() {
        return null;
    }


    @Override
	public String toString() {
		return String.format("%s %s", a, b);
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
