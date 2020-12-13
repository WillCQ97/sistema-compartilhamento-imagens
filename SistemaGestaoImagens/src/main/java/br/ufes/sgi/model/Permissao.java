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
public class Permissao {

    public int id;
    public Usuario Usuario;
    public Imagem Imagem;
    public boolean visualizar;
    public boolean excluir;
    public boolean compartilhar;

    public Permissao(int id, Usuario Usuario, Imagem Imagem, boolean visualizar, boolean excluir, boolean compartilhar) {
        this.id = id;
        this.Usuario = Usuario;
        this.Imagem = Imagem;
        this.visualizar = visualizar;
        this.excluir = excluir;
        this.compartilhar = compartilhar;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario idUsuario) {
        this.Usuario = idUsuario;
    }

    public Imagem getImagem() {
        return Imagem;
    }

    public void setIdImagem(Imagem idImagem) {
        this.Imagem = idImagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVisualizar() {
        return visualizar;
    }

    public void setVisualizar(boolean visualizar) {
        this.visualizar = visualizar;
    }

    public boolean isExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }

    public boolean isCompartilhar() {
        return compartilhar;
    }

    public void setCompartilhar(boolean compartilhar) {
        this.compartilhar = compartilhar;
    }

}
