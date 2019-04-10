package gui.apresentacao;

import gui.formasGeometricas.FormaGeometrica;

public interface InterfaceOuvintePanels {

    void novaFormaGeometrica(FormaGeometrica forma);
    // Metodo Update() do padrão Observer
    void atualizar();

}
