package model;

import java.time.LocalDate;

public class Comentario {

    private int id;
    private String comentario;
    private String email;
    private int idCategoria;
    private LocalDate dataComentario;

    public Comentario() {
    }

    public Comentario(int id, String comentario, String email, int idCategoria, LocalDate dataComentario) {
        this.id = id;
        this.comentario = comentario;
        this.email = email;
        this.idCategoria = idCategoria;
        this.dataComentario = dataComentario;
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

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public LocalDate getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(LocalDate dataComentario) {
        this.dataComentario = dataComentario;
    }
}
