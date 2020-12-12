/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.service;

import br.ufes.sgi.business.UsuarioBusiness;
import br.ufes.sgi.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class UsuarioService {

    UsuarioBusiness business;

    public UsuarioService() throws Exception {
        this.business = new UsuarioBusiness();
    }

    public ArrayList<Usuario> getAll() throws Exception {
        return business.getAll();
    }

    public void salvar(Usuario usuario) throws Exception {

        business.salvar(usuario);

    }

    public void atualizar(Usuario usuario) throws Exception {
        business.atualizar(usuario);
    }

    public void excluir(Usuario usuarioLogin) throws Exception {
        business.excluir(usuarioLogin);
    }

}
