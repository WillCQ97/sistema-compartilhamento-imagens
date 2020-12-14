/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.model;

/**
 *
 * @author 55289
 */
public class Solicitacao {

    private int id;
    private Usuario usuarioSolicitante;
    private Usuario adminSolicitado;
    private Imagem Imagem;
    private String descricao;

    public Solicitacao() {

    }

    public Solicitacao(int id, Usuario usuarioSolicitante, Usuario adminSolicitado, Imagem Imagem, String descricao) {
        this.id = id;
        this.usuarioSolicitante = usuarioSolicitante;
        this.adminSolicitado = adminSolicitado;
        this.Imagem = Imagem;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public Usuario getAdminSolicitado() {
        return adminSolicitado;
    }

    public void setAdminSolicitado(Usuario adminSolicitado) {
        this.adminSolicitado = adminSolicitado;
    }

    public Imagem getImagem() {
        return Imagem;
    }

    public void setImagem(Imagem Imagem) {
        this.Imagem = Imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
