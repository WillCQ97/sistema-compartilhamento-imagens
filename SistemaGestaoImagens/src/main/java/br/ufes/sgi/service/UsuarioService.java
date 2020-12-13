/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.service;

import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.repository.UsuarioRepository;
import br.ufes.sgi.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class UsuarioService {

    UsuarioRepository repository;
    PermissaoService repositoryPermissao;

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

    public void excluir(Usuario usuarioLogin) throws Exception {
        repository.excluir(usuarioLogin);
    }

    public Usuario getByID(int idUsuario) throws Exception {
        return repository.getByID(idUsuario);
    }
    public void compartilharImagem(Usuario usuario,Permissao permissao) throws Exception{
        if(usuario.isAdmin()){
            repositoryPermissao.gerarCompartilhamento(permissao);
        }
        throw new Exception("O usuário não é administrador!");
    }

}
