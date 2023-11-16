package model;

import java.time.LocalDate;

public class Comentario {

    private int id;
    private String comentario;
    private int idUsuario;
    private int idCategoria;
    private LocalDate dataComentario;

    public Comentario() {
    }

    public Comentario(String comentario, int idUsuario, int idCategoria) {
        this.comentario = comentario;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.dataComentario = LocalDate.now();
    }

    public Comentario(int id, String comentario, int idUsuario, int idCategoria) {
        this.id = id;
        this.comentario = comentario;
        this.idUsuario = idUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
