/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.service;

import br.ufes.sgi.model.Notificacao;
import br.ufes.sgi.repository.NotificacaoRepository;
import java.util.ArrayList;

/**
 *
 * @author 55289
 */
public class NotificacaoService {
    
    public NotificacaoRepository repository;
    
    public NotificacaoService() throws Exception {
        repository = new NotificacaoRepository();
    }
    
    public boolean verificaNotificacao(int id) throws Exception {
        return repository.getNotificacaoById(id) == null;
    }
    
    public ArrayList<Notificacao> getNotificacoesById(int id) throws Exception {
        return repository.getNotificacaoById(id);
    }
    
    public void salvarById(Notificacao notificacao) throws Exception {
        repository.salvarById(notificacao);
    }
    
}
