/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.service;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.repository.ImagemRepository;
import br.ufes.sgi.repository.PermissaoRepository;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class ImagemService {

    public ImagemRepository repository;
    public PermissaoRepository permissaoRepository;

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
        if (!permissao.isExcluir()) {
            throw new Exception("Não tem permissão para excluir");
        }
        repository.excluir(permissao.getImagem());
        permissaoRepository.excluir(permissao);

    }

    public ArrayList<Imagem> getImagensByIdUsuario(Usuario usuario) throws Exception {
        if (permissaoRepository.getPermissaoByUsuario(usuario).isVisualizar()) {
            return repository.getImagensByIdUsuario(usuario.getId());
        }
        throw new Exception("Não tem permissão para visualizar");
    }

    public Imagem getImagemById(int id) throws Exception {
        return repository.getImagemById(id);
    }

}
