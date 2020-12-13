package br.ufes.sgi.model;

public class Imagem {

    public int id;
    public String caminho;

    public Imagem(int id, String caminho) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Imagem{" + "id=" + id + ", caminho=" + caminho + '}';
    }

}
