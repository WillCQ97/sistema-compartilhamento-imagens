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
public class ImagemMemento {

    private int id;
    private String caminho;

    public ImagemMemento(int id, String caminho) {
        this.id = id;
        this.caminho = caminho;
    }

    public int getId() {
        return id;
    }

    public String getCaminho() {
        return caminho;
    }

}
