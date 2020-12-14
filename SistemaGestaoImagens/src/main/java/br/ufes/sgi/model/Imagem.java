package br.ufes.sgi.model;

public class Imagem {

    private int id;
    private String caminho;

    public Imagem(int id, String caminho) {
        this.id = id;
        this.caminho = caminho;
    }
    public Imagem(){
        
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

    @Override
    public String toString() {
        return "Imagem{" + "id=" + id + ", caminho=" + caminho + '}';
    }

}
