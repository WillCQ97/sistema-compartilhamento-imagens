package br.ufes.sgi.repository;

import br.ufes.sgi.dao.PermissaoDAO;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;

public class PermissaoRepository {

    private final PermissaoDAO dao;

    public PermissaoRepository() throws Exception {
        this.dao = new PermissaoDAO();
    }

    public void gerarCompartilhamento(Permissao permissao) throws Exception {
        if (permissao.getUsuario() == null) {
            throw new Exception("Usuario não pode estar nulo!");
        }
        if (permissao.getImagem() == null) {
            throw new Exception("Imagem não pode estar nulo!");
        }
        if (permissao.getImagem().getCaminho() == null) {
            throw new Exception("Imagem não pode estar com o caminho nulo!");
        }
        dao.gerarCompartilhamento(permissao);
    }

    public void excluir(Permissao permissao) throws Exception {

        dao.excluir(permissao);
    }

    public void atualizarById(Permissao permissao) throws Exception {

        dao.atualizarById(permissao);
    }

    public Long verificaPermissao(Permissao permissao) throws Exception {
        if (permissao == null) {
            throw new Exception("Permissao não pode estar com o caminho nulo!");
        }
        if (permissao.getUsuario() == null) {
            throw new Exception("Usuario não pode estar com o caminho nulo!");
        }
        if (permissao.getImagem() == null) {
            throw new Exception("Imagem não pode estar com o caminho nulo!");
        }
        return dao.verificaPermissao(permissao);
    }

    public Permissao getPermissaoByUsuario(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("Usuario não pode estar com o caminho nulo!");
        }
        return dao.getPermissaoByUsuario(usuario);
    }

}
