/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.repository;

import br.ufes.sgi.dao.UsuarioDAO;
import br.ufes.sgi.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class UsuarioRepository {

    private UsuarioDAO daoLogin;

    public UsuarioRepository() throws Exception {
        this.daoLogin = new UsuarioDAO();
    }

    public ArrayList<Usuario> getAll() throws Exception {
        return daoLogin.getAll();
    }

    public void salvar(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("Usuário fornecido é inválido");
        } else {
            if (usuario.getUsuario() == null || usuario.getUsuario().isBlank()) {
                throw new Exception("Login fornecido é inválido");
            }
            if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
                throw new Exception("Senha fornecida é inválida");
            }
            daoLogin.salvar(usuario);
        }
    }

    public void atualizar(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("Usuário fornecido é inválido");
        } else {
            if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
                throw new Exception("Senha fornecida é inválida");
            }
        }
        daoLogin.atualizar(usuario);
    }

    public void excluir(Usuario usuarioLogin) throws Exception {
        daoLogin.excluir(usuarioLogin);
    }

    public Usuario getByID(int idUsuario) throws Exception {
        return daoLogin.getByID(idUsuario);
    }
}
