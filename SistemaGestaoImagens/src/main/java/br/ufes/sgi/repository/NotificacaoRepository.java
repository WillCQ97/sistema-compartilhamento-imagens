/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.repository;

import br.ufes.sgi.dao.NotificacaoDAO;
import br.ufes.sgi.model.Notificacao;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class NotificacaoRepository {
    public NotificacaoDAO dao;
    
    public NotificacaoRepository() throws Exception{
        this.dao = new NotificacaoDAO();
    }
    
    public void salvarById(Notificacao notificacao) throws Exception{
        if(notificacao == null){
            throw new Exception("Notificacao não pode estar nulo!");
        }
        dao.salvarById(notificacao);
    }
    
    public ArrayList<Notificacao> getNotificacaoById(int id) throws Exception{
        return dao.getNotificacaoById(id);
    }
    
}
