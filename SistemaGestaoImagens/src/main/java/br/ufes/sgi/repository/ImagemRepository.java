package br.ufes.sgi.repository;

import br.ufes.sgi.dao.ImagemDAO;
import br.ufes.sgi.model.Imagem;
import java.util.ArrayList;

public class ImagemRepository {

    public ImagemDAO dao;

    public ImagemRepository() throws Exception {
        this.dao = new ImagemDAO();
    }

    public ArrayList<Imagem> getAll() throws Exception {
        return dao.getAll();
    }

    public void salvar(Imagem imagem) throws Exception {
        if (imagem == null) {
            throw new Exception("O usuário não é administrador!");
        }

        dao.salvar(imagem);
    }

    public void excluir(Imagem imagem) throws Exception {
        if (imagem == null) {
            throw new Exception("O usuário não é administrador!");
        }

        dao.excluir(imagem);
    }

    public ArrayList<Imagem> getImagensByIdUsuario(int id) throws Exception {
        return dao.getImagensByIdUsuario(id);
    }

    public Imagem getImagemById(int id) throws Exception {
        return dao.getImagemById(id);
    }
}
