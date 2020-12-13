package br.ufes.sgi.service;

import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.repository.UsuarioRepository;
import br.ufes.sgi.model.Usuario;
import java.util.ArrayList;

public class UsuarioService {

    private final UsuarioRepository repository;
    private PermissaoService repositoryPermissao;

    public UsuarioService() throws Exception {
        this.repository = new UsuarioRepository();
    }

    public ArrayList<Usuario> getAll() throws Exception {
        return repository.getAll();
    }

    public void salvar(Usuario usuario) throws Exception {
        repository.salvar(usuario);
    }

    public void atualizar(Usuario usuario) throws Exception {
        repository.atualizar(usuario);
    }

    public void excluir(Usuario usuario) throws Exception {
        repository.excluir(usuario);
    }

    public Usuario getById(int idUsuario) throws Exception {
        return repository.getById(idUsuario);
    }
    
    //DESSE MODO APENAS O ADMINISTRADOR PODE COMPARTILHAR
    public void compartilharImagem(Usuario usuario, Permissao permissao) throws Exception {
        if (usuario.isAdmin()) {
            repositoryPermissao.gerarCompartilhamento(permissao);
        }
        throw new Exception("O usuário não é administrador!");
    }

}
