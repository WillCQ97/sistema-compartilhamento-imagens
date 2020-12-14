package br.ufes.sgi.model;

public class Permissao {

    private int id;
    private Usuario usuario;
    private Imagem imagem;
    private boolean visualizar;
    private boolean excluir;
    private boolean compartilhar;

    public Permissao(Usuario usuario, Imagem imagem, boolean visualizar,
            boolean excluir, boolean compartilhar) {
        this.usuario = usuario;
        this.imagem = imagem;
        this.visualizar = visualizar;
        this.excluir = excluir;
        this.compartilhar = compartilhar;
    }
    public Permissao (){
        
    }

    public Permissao(int id, Usuario usuario, Imagem imagem, boolean visualizar,
            boolean excluir, boolean compartilhar) {
        this.id = id;
        this.usuario = usuario;
        this.imagem = imagem;
        this.visualizar = visualizar;
        this.excluir = excluir;
        this.compartilhar = compartilhar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario idUsuario) {
        this.usuario = idUsuario;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem idImagem) {
        this.imagem = idImagem;
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

    @Override
    public String toString() {
        return "Permissao{" + "id=" + id + ", Usuario=" + usuario + ", Imagem=" + imagem
                + ", visualizar=" + visualizar + ", excluir=" + excluir + ", compartilhar=" + compartilhar + '}';
    }

}
