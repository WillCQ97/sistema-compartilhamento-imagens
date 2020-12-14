package br.ufes.sgi.repository;

import br.ufes.sgi.dao.NotificacaoDAO;
import br.ufes.sgi.model.Notificacao;
import java.util.ArrayList;

public class NotificacaoRepository {

    public NotificacaoDAO dao;

    public NotificacaoRepository() throws Exception {
        this.dao = new NotificacaoDAO();
    }

    public void salvar(Notificacao notificacao) throws Exception {
        if (notificacao == null) {
            throw new Exception("Notificacao não pode estar nulo!");
        }
        dao.salvar(notificacao);
    }

    public ArrayList<Notificacao> getNotificacaoById(int id) throws Exception {
        return dao.getNotificacaoById(id);
    }
    public void excluir(Notificacao notificacao) throws Exception {
        dao.excluir(notificacao);
    }

}
