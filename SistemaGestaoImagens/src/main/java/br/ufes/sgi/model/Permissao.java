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
    public int idUsuario;
    public int idImagem;
    public boolean visualizar;
    public boolean excluir;
    public boolean compartilhar;

    public Permissao(int idUsuario, int idImagem) {
        this.idUsuario = idUsuario;
        this.idImagem = idImagem;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }
    
    
}
