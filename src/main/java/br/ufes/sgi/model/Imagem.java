package br.ufes.sgi.model;

import br.ufes.sgi.command.ImagemCommandMemento;

public class Imagem implements ImagemCommandMemento {

    private int id;
    private String caminho;

    public Imagem(int id, String caminho) {
        this.id = id;
        this.caminho = caminho;
    }

    @Override
    public void restaurar(ImagemMemento memento) {
        this.id = memento.getId();
        this.caminho = memento.getCaminho();
    }

    @Override
    public ImagemMemento criar() {
        return new ImagemMemento(this.id, this.caminho);
    }

    public Imagem() {

    }

    public Imagem(String caminho) {
        this.caminho = caminho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

}
