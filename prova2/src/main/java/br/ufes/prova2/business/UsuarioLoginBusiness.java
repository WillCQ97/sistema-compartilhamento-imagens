/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.prova2.business;

import br.ufes.prova2.dao.LoginDAO;
import br.ufes.prova2.model.UsuarioLogin;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class UsuarioLoginBusiness {

    private LoginDAO daoLogin;

    public UsuarioLoginBusiness() throws Exception {
        this.daoLogin = new LoginDAO();
    }

    public ArrayList<UsuarioLogin> getAll() throws Exception {
        return daoLogin.getAll();
    }

    public void salvar(UsuarioLogin usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("Usuário fornecido é inválido");
        } else {
            if (usuario.getUsuario()== null || usuario.getUsuario().isBlank()) {
                throw new Exception("Login fornecido é inválido");
            }
            if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
                throw new Exception("Senha fornecida é inválida");
            }
            daoLogin.salvar(usuario);
        }
    }

    public void atualizar(UsuarioLogin usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("Usuário fornecido é inválido");
        } else {   
            if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
                throw new Exception("Senha fornecida é inválida");
            }
        }        
        daoLogin.atualizar(usuario);
    }

    public void excluir(UsuarioLogin usuarioLogin) throws Exception {
        daoLogin.excluir(usuarioLogin);
    }
}
