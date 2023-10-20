package model;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private int id;
    private String categoriaUsuario;
    private String livros;
    private String redeSocial;

    public Usuario(String nome, String email, String senha, int id, String categoriaUsuario, String livros, String redeSocial) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id = id;
        this.categoriaUsuario = categoriaUsuario;
        this.livros = livros;
        this.redeSocial = redeSocial;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }
}
