/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.prova2.service;

import br.ufes.prova2.business.UsuarioLoginBusiness;
import br.ufes.prova2.model.UsuarioLogin;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class UsuarioLoginService {

    UsuarioLoginBusiness business;

    public UsuarioLoginService() throws Exception {
        this.business = new UsuarioLoginBusiness();
    }

    public ArrayList<UsuarioLogin> getAll() throws Exception {
        return business.getAll();
    }

    public void salvar(UsuarioLogin usuario) throws Exception {

        business.salvar(usuario);

    }

    public void atualizar(UsuarioLogin usuario) throws Exception {
        business.atualizar(usuario);
    }

    public void excluir(UsuarioLogin usuarioLogin) throws Exception {
        business.excluir(usuarioLogin);
    }

}
