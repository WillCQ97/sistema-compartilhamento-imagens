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
        if(permissao.isCompartilhar()){
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

    public void atualizarById(Permissao permissao) throws Exception {
        repository.atualizarById(permissao);
    }

    public boolean verificarPermissao(Usuario usuario, Imagem imagem) throws Exception {
        return repository.verificarPermissao(usuario, imagem);
    }
    
    // entretanto um usuário pode ter mais de uma permissão... aliás terá
    public Permissao getPermissaoByUsuario(Usuario usuario) throws Exception {
        return repository.getPermissaoByUsuario(usuario);
    }

    public void gerarPedidoPermissao(Permissao permissao) throws Exception {
        repository.gerarPedidoPermissao(permissao);
    }
}
