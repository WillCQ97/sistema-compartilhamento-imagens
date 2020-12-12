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
public class Notificacao {
    public int id;
    public int idUsuario;
    public String descricao;

    public Notificacao(int id, int idUsuario) {
        this.id = id;
        this.idUsuario = idUsuario;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
