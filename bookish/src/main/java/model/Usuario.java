package model;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String categoriaUsuario;
    private String livros;
    private String instagram;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha, int id, String categoriaUsuario, String livros, String instagram) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.categoriaUsuario = categoriaUsuario;
        this.livros = livros;
        this.instagram = instagram;


    }

    public Usuario(String nome, String livros, String instagram) {
        this.nome = nome;
        this.livros = livros;
        this.instagram = instagram;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCategoriaUsuario() {
        return categoriaUsuario;
    }

    public void setCategoriaUsuario(String categoriaUsuario) {
        this.categoriaUsuario = categoriaUsuario;
    }

    public String getLivros() {
        return livros;
    }

    public void setLivros(String livros) {
        this.livros = livros;
    }

    public String instagram() {
        return instagram;
    }

    public void instagram(String instagram) {
        this.instagram = instagram;
    }
}
