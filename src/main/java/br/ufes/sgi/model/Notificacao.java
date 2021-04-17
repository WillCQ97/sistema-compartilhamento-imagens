package br.ufes.sgi.model;

public class Notificacao {

    private int id;
    private Usuario usuario;
    private String descricao;

    public Notificacao(int id, Usuario usuario, String descricao) {
        this.id = id;
        this.usuario = usuario;
        this.descricao = descricao;
    }

    public Notificacao(Usuario usuario, String descricao) {
        this.usuario = usuario;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.usuario = idUsuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
