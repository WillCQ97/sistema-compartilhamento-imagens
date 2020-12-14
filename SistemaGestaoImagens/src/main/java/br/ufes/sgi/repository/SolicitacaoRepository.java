/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.repository;

import br.ufes.sgi.dao.SolicitacaoDAO;
import br.ufes.sgi.model.Solicitacao;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class SolicitacaoRepository {

    private SolicitacaoDAO dao;

    public SolicitacaoRepository() {
        this.dao = new SolicitacaoDAO();
    }

    public ArrayList<Solicitacao> getByIdAdmin(int id) throws Exception {
        return this.dao.getByIdAdmin(id);
    }

    public void excluir(int id) throws Exception {
        this.dao.excluir(id);
    }

    public void salvar(Solicitacao solicitacao) throws Exception {
        this.dao.salvar(solicitacao);
    }

}
