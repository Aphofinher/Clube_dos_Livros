package model;

public class ComentarioTO {

    private String nome;
    private String comentario;
    private String redeSocial;
    private String livro;

    public ComentarioTO(String nome, String comentario, String redeSocial, String livro) {
        this.nome = nome;
        this.comentario = comentario;
        this.redeSocial = redeSocial;
        this.livro = livro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }
}
