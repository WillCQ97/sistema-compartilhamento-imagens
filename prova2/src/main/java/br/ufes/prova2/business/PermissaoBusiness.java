/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.prova2.business;

import br.ufes.prova2.dao.PermissaoDAO;
import br.ufes.prova2.model.Permissao;

/**
 *
 * @author 55289
 */
public class PermissaoBusiness {

    private PermissaoDAO dao;

    public PermissaoBusiness() throws Exception {
        this.dao = new PermissaoDAO();
    }

    public void salvarByIds(Permissao permissao) throws Exception {
        if (permissao.getUsuario() == null) {
            throw new Exception("Usuario não pode estar nulo!");
        }
        if (permissao.getImagem() == null) {
            throw new Exception("Imagem não pode estar nulo!");
        }
        if (permissao.getImagem().getPath() == null) {
            throw new Exception("Imagem não pode estar com o caminho nulo!");
        }
        dao.salvarByIds(permissao);
    }

    public void excluir(Permissao permissao) throws Exception {

        dao.excluir(permissao);
    }

    public void atualizarById(Permissao permissao) throws Exception {

        dao.atualizarById(permissao);
    }
}
