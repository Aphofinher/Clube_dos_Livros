package model;

import java.util.Date;

public class Livros {

    String nomeLivro;
    int idLivro;
    String categoriaLivro;
    String sinopse;
    Date dataLivro;

    public Livros(String nomeLivro, int idLivro, String categoriaLivro, String sinopse, Date dataLivro) {
        this.nomeLivro = nomeLivro;
        this.idLivro = idLivro;
        this.categoriaLivro = categoriaLivro;
        this.sinopse = sinopse;
        this.dataLivro = dataLivro;
    }

    public Livros() {
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getCategoriaLivro() {
        return categoriaLivro;
    }

    public void setCategoriaLivro(String categoriaLivro) {
        this.categoriaLivro = categoriaLivro;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public java.sql.Date getDataLivro() {
        return (java.sql.Date) dataLivro;
    }

    public void setDataLivro(Date dataLivro) {
        this.dataLivro = dataLivro;
    }
}
