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

    public Usuario getByID(int idUsuario) throws Exception {
        return repository.getByID(idUsuario);
    }

    public void compartilharImagem(Permissao permissao) throws Exception {
        if (permissao.isCompartilhar()) {
            repositoryPermissao.gerarCompartilhamento(permissao);
        }
        throw new Exception("O usuário não é administrador!");
    }
    
    public Usuario getByName(String nome) throws Exception{
        return repository.getByName(nome);
    }
    
    public ArrayList<Usuario> getAllUser() throws Exception{
        return repository.getAllUser();
    }
    public ArrayList<Usuario> getAllAdm() throws Exception{
        return repository.getAllAdm();
    }

}
