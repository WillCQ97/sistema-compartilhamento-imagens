package br.ufes.sgi.service;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.repository.PermissaoRepository;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;

public class PermissaoService {

    private final PermissaoRepository repository;

    public PermissaoService() throws Exception {
        this.repository = new PermissaoRepository();
    }

    public void gerarCompartilhamento(Permissao permissao) throws Exception {
        if (permissao.isCompartilhar()) {
            repository.gerarCompartilhamento(permissao);
        }
    }

    public void excluir(Permissao permissao) throws Exception {
        if (permissao.isExcluir()) {
            repository.excluir(permissao);
        } else {
            throw new Exception("O usuário não é administrador!");
        }
    }

    public void atualizar(Permissao permissao) throws Exception {
        repository.atualizar(permissao);
    }

    public boolean verificarPermissao(Usuario usuario, Imagem imagem) throws Exception {
        return repository.verificarPermissao(usuario, imagem);
    }

    public Permissao getPermissao(int idImagem, int idUsuario) throws Exception {
        return repository.getPermissao(idImagem, idUsuario);
    }

    public void gerarPedidoPermissao(Permissao permissao) throws Exception {
        repository.gerarPedidoPermissao(permissao);
    }
}
