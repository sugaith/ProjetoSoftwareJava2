package gui.apresentacao.visualizacao;

import gui.Documento;
import gui.apresentacao.InterfaceOuvintePanels;
import gui.formasGeometricas.FormaGeometrica;
import gui.uteis.Iterador;

import javax.swing.*;
import java.awt.*;

public class PanelTexto extends JTextArea implements InterfaceOuvintePanels {

    protected Documento doc;

    public PanelTexto(Documento doc) {
        super(8,15);
        this.doc = doc;
        setBackground(new Color(255,255,255));
    }

    @Override
    public void novaFormaGeometrica(FormaGeometrica forma) {
        doc.inserirFim(forma);
    }

    @Override
    public void atualizar() {
        StringBuffer buf = new StringBuffer();
        Iterador<FormaGeometrica> i = doc.getIterador();
        FormaGeometrica forma;
        while((forma = i.proximo()) != null) {
            buf.append(forma.getStrPosition());
            buf.append("\n");
        }
        setText(buf.toString());
    }

}