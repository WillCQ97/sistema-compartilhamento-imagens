/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.service;

import br.ufes.sgi.dao.SolicitacaoDAO;
import br.ufes.sgi.model.Solicitacao;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class SolicitacaoService {
       private SolicitacaoDAO repository;

    public SolicitacaoService() {
        this.repository = new SolicitacaoDAO();
    }

    public ArrayList<Solicitacao> getByIdAdmin(int id) throws Exception {
        return this.repository.getByIdAdmin(id);
    }

    public void excluir(int id) throws Exception {
        this.repository.excluir(id);
    }

    public void salvar(Solicitacao solicitacao) throws Exception {
        this.repository.salvar(solicitacao);
    }
}
