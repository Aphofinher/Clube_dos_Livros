package model;

import java.time.LocalDate;

public class Comentario {

    private int id;
    private String comentario;
    private String email;

    private String livro;
    private int idCategoria;



    public Comentario() {
    }

    public Comentario(String comentario, String email, String livro, int idCategoria) {

        this.comentario = comentario;
        this.email = email;
        this.livro = livro;
        this.idCategoria = idCategoria;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }


}
