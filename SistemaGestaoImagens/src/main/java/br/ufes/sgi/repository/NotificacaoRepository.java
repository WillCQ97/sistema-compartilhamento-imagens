package br.ufes.sgi.repository;

import br.ufes.sgi.dao.NotificacaoDAO;
import br.ufes.sgi.model.Notificacao;
import java.util.ArrayList;

public class NotificacaoRepository {

    public NotificacaoDAO dao;

    public NotificacaoRepository() throws Exception {
        this.dao = new NotificacaoDAO();
    }

    public void salvarById(Notificacao notificacao) throws Exception {
        if (notificacao == null) {
            throw new Exception("Notificacao não pode estar nulo!");
        }
        dao.salvarById(notificacao);
    }

    public ArrayList<Notificacao> getNotificacaoById(int id) throws Exception {
        return dao.getNotificacaoById(id);
    }

}
