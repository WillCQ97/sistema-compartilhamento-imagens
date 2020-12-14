package br.ufes.sgi.service;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.repository.ImagemRepository;
import br.ufes.sgi.repository.PermissaoRepository;
import java.util.ArrayList;

public class ImagemService {

    private final ImagemRepository imagemRepository;
    private final PermissaoRepository permissaoRepository;

    public ImagemService() throws Exception {
        imagemRepository = new ImagemRepository();
        permissaoRepository = new PermissaoRepository();
    }

    public ArrayList<Imagem> getAll() throws Exception {
        return imagemRepository.getAll();
    }

    public void salvar(Imagem imagem) throws Exception {
        imagemRepository.salvar(imagem);
    }

    public void excluir(Permissao permissao) throws Exception {
<<<<<<< HEAD
        repository.excluir(permissao.getImagem());
=======
        if (!permissao.isExcluir()) {
            throw new Exception("Não tem permissão para excluir");
        }

        imagemRepository.excluir(permissao.getImagem());
>>>>>>> 96be0cd2fa5446b521aea2b1e09d03ee3e0527b5
        permissaoRepository.excluir(permissao);
    }

    public ArrayList<Imagem> getImagensByIdUsuario(Usuario usuario) throws Exception {
<<<<<<< HEAD
        return repository.getImagensByIdUsuario(usuario.getId());
=======
        if (permissaoRepository.getPermissaoByUsuario(usuario).isVisualizar()) {
            return imagemRepository.getImagensByIdUsuario(usuario.getId());
        }

        throw new Exception("Não tem permissão para visualizar");
>>>>>>> 96be0cd2fa5446b521aea2b1e09d03ee3e0527b5
    }

    public Imagem getImagemById(int id) throws Exception {
        return imagemRepository.getImagemById(id);
    }

    public boolean isNull() throws Exception {
        return imagemRepository.isNull();
    }

}
