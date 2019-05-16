package gui;

import gui.apresentacao.InterfaceOuvintePanels;
import gui.formasGeometricas.FormaGeometrica;
import gui.formasGeometricas.handlers.InterfaceFormaHandler;
import gui.uteis.Iterador;
import gui.uteis.ListaEncadeada;

import java.io.Serializable;

public class Documento implements Serializable {
    private static final long serialVersionUID = 1L;

    private ListaEncadeada<FormaGeometrica> lista;
    private transient ListaEncadeada<InterfaceOuvintePanels> listaOuvintes;

    public Documento(){
        this.lista = new ListaEncadeada<FormaGeometrica>();
        this.listaOuvintes = new ListaEncadeada<InterfaceOuvintePanels>();
    }

    public void inserirFim(FormaGeometrica forma) {
        this.lista.inserirFim(forma);
        atualizaOuvintes();
    }

    public Iterador<FormaGeometrica> getIterador() {
        return this.lista.getInicio();
    }


    // Metodo Attach(Observer) do padrão Observer
    public void adicionaOuvinte(InterfaceOuvintePanels view) {
        listaOuvintes.inserirFim(view);
        atualizaOuvintes();
    }

    public void removeOuvinte(InterfaceOuvintePanels view) {
        Iterador<InterfaceOuvintePanels> i = listaOuvintes.getInicio();
        InterfaceOuvintePanels view_lista;
        int index=0;
        while ((view_lista = (InterfaceOuvintePanels) i.proximo()) != null) {
            // Invoca o metodo Update do objeto Observer
            if (view.getClass().equals( view_lista.getClass() )){
                System.out.println(view.getClass());
                listaOuvintes.remover( index );
                break;
            }
            index++;
        }

        atualizaOuvintes();
    }




    public void atualizaOuvintes() {
        Iterador<InterfaceOuvintePanels> i = listaOuvintes.getInicio();
        InterfaceOuvintePanels view;
        while ((view = (InterfaceOuvintePanels) i.proximo()) != null) {
            // Invoca o metodo Update do objeto Observer
            view.atualizar();
        }
    }

    public ListaEncadeada<FormaGeometrica> getListaFormas() {
        return lista;
    }
    public void setListaFormas(ListaEncadeada<FormaGeometrica> lista) {
        this.lista = lista;
    }


}