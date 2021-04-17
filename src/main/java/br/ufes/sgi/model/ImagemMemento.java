package br.ufes.sgi.model;

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
