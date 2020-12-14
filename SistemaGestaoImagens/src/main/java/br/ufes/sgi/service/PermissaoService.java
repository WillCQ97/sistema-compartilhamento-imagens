package br.ufes.sgi.service;

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

    public void atualizar(Permissao permissao) throws Exception {
        repository.atualizar(permissao);
    }

    public boolean verificaPermissao(Permissao permissao) throws Exception {
        return repository.verificaPermissao(permissao) == null;
    }
<<<<<<< HEAD

    public Permissao getPermissao(Permissao permissao) throws Exception {
        return repository.getPermissao(permissao);
=======
    
    // entretanto um usuário pode ter mais de uma permissão... aliás terá
    public Permissao getPermissaoByUsuario(Usuario usuario) throws Exception {
        return repository.getPermissaoByUsuario(usuario);
>>>>>>> 96be0cd2fa5446b521aea2b1e09d03ee3e0527b5
    }

    public void gerarPedidoPermissao(Permissao permissao) throws Exception {
        repository.gerarPedidoPermissao(permissao);
    }
}
