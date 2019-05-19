package persistencia.dao.entidade;

import java.util.Date;

public class Forma {
    private int id;
    private int desenho_id;

    private String nome;
    private String pontos;
    private Date create_date;
    private Date update_date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDesenho_id() {
        return desenho_id;
    }

    public void setDesenho_id(int desenho_id) {
        this.desenho_id = desenho_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
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
