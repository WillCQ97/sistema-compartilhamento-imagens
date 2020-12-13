package br.ufes.sgi.service;

import br.ufes.sgi.repository.PermissaoRepository;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;

public class PermissaoService {

    public PermissaoRepository repository;

    public PermissaoService() throws Exception {
        this.repository = new PermissaoRepository();
    }

    public void gerarCompartilhamento(Permissao permissao) throws Exception {
        repository.gerarCompartilhamento(permissao);
    }

    public void excluir(Permissao permissao) throws Exception {
        if (permissao.getUsuario().isAdmin()) {
            repository.excluir(permissao);
        } else {
            throw new Exception("O usuário não é administrador!");
        }
    }

    public void atualizarById(Permissao permissao) throws Exception {
        repository.atualizarById(permissao);
    }

    public boolean verificaPermissao(Permissao permissao) throws Exception {
        return repository.verificaPermissao(permissao) == null;
    }

    public Permissao getPermissaoByUsuario(Usuario usuario) throws Exception {
        return repository.getPermissaoByUsuario(usuario);
    }

    public void gerarPedidoPermissao(Permissao permissao) throws Exception {
        repository.gerarPedidoPermissao(permissao);
    }
}
