package persistencia.dao.entidade;

import java.util.Date;
import java.util.List;

public class Desenho {
    private int id;
    private String nome;
    private Date create_date;
    private Date update_date;

    private List<Forma> listaFormas;

    public Desenho() {
    }

    public Desenho(String nome ) {
        this.nome = nome;
    }

    public List<Forma> getListaFormas() {
        return listaFormas;
    }

    public void setListaFormas(List<Forma> listaFormas) {
        this.listaFormas = listaFormas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }
}
