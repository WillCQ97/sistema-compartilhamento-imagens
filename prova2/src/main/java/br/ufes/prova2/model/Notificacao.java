/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.prova2.model;

/**
 *
 * @author 55289
 */
public class Notificacao {

    public int id;
    public UsuarioLogin usuario;
    public String descricao;

    public Notificacao(int id, UsuarioLogin idUsuario, String descricao) {
        this.id = id;
        this.usuario = idUsuario;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioLogin getUsuario() {
        return usuario;
    }

    public void setIdUsuario(UsuarioLogin idUsuario) {
        this.usuario = idUsuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
