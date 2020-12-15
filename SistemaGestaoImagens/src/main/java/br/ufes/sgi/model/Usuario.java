package br.ufes.sgi.model;

public class Usuario {

    private int id;
    private String apelido;
    private String senha;
    private String nome;
    private boolean admin;

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String apelido, String senha, String nome, boolean admin) {
        this.apelido = apelido;
        this.senha = senha;
        this.nome = nome;
        this.admin = admin;
    }

    public Usuario(int id, String apelido, String senha, String nome, boolean admin) {
        this.id = id;
        this.apelido = apelido;
        this.senha = senha;
        this.nome = nome;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", usuario=" + apelido + ", senha=" + senha + ", admin=" + admin + '}';
    }
}
