/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.prova2.service;

import br.ufes.prova2.business.PermissaoBusiness;
import br.ufes.prova2.model.Permissao;

/**
 *
 * @author 55289
 */
public class PermissaoService {

    public PermissaoBusiness business;

    public PermissaoService() throws Exception {
        this.business = new PermissaoBusiness();
    }

    public void salvarByIds(Permissao permissao) throws Exception {
        business.salvarByIds(permissao);
    }

    public void excluir(Permissao permissao) throws Exception {
        if(permissao.getUsuario().isAdmin()){
         business.excluir(permissao);   
        } 
        else{
            throw new Exception("O usuário não é administrador!");
        }
    }

    public void atualizarById(Permissao permissao) throws Exception {
        business.atualizarById(permissao);
    }
    
    //asdfaasdfasdfsadfasdfasdf

}
