package br.ufes.sgi.service;

import br.ufes.sgi.model.Notificacao;
import br.ufes.sgi.repository.NotificacaoRepository;
import java.util.ArrayList;

public class NotificacaoService {

    private final NotificacaoRepository repository;

    public NotificacaoService() throws Exception {
        repository = new NotificacaoRepository();
    }

    public boolean verificaNotificacao(int id) throws Exception {
        return repository.getNotificacaoById(id) == null;
    }

    public ArrayList<Notificacao> getNotificacoesById(int id) throws Exception {
        return repository.getNotificacaoById(id);
    }

    public void salvar(Notificacao notificacao) throws Exception {
        repository.salvar(notificacao);
    }

    public void excluir(Notificacao notificacao) throws Exception {
        repository.excluir(notificacao);
    }
}
