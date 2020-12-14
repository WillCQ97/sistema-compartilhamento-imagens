package br.ufes.sgi.service;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.repository.ImagemRepository;
import br.ufes.sgi.repository.PermissaoRepository;
import java.util.ArrayList;

public class ImagemService {

    private final ImagemRepository repository;
    private PermissaoRepository permissaoRepository;

    public ImagemService() throws Exception {
        repository = new ImagemRepository();
    }

    public ArrayList<Imagem> getAll() throws Exception {
        return repository.getAll();
    }

    public void salvar(Imagem imagem) throws Exception {
        repository.salvar(imagem);
    }

    public void excluir(Permissao permissao) throws Exception {
        repository.excluir(permissao.getImagem());
        permissaoRepository.excluir(permissao);
    }

    public ArrayList<Imagem> getImagensByIdUsuario(Usuario usuario) throws Exception {
        return repository.getImagensByIdUsuario(usuario.getId());
    }

    public Imagem getImagemById(int id) throws Exception {
        return repository.getImagemById(id);
    }

    public boolean isNull() throws Exception {
        return repository.isNull();
    }

}
