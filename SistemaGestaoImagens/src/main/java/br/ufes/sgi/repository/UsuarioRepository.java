package br.ufes.sgi.repository;

import br.ufes.sgi.dao.UsuarioDAO;
import br.ufes.sgi.model.Usuario;
import java.util.ArrayList;

public class UsuarioRepository {

    private final UsuarioDAO usuarioDao;

    public UsuarioRepository() throws Exception {
        this.usuarioDao = new UsuarioDAO();
    }

    public ArrayList<Usuario> getAll() throws Exception {
        return usuarioDao.getAll();
    }

    public void salvar(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("Usuário fornecido é inválido");
        } else {
            if (usuario.getUsuario() == null || usuario.getUsuario().isBlank()) {
                throw new Exception("Login fornecido é inválido");
            }
            if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
                throw new Exception("Senha fornecida é inválida");
            }
            usuarioDao.salvar(usuario);
        }
    }

    public void atualizar(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("Usuário fornecido é inválido");
        } else {
            if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
                throw new Exception("Senha fornecida é inválida");
            }
        }
        usuarioDao.atualizar(usuario);
    }

    public void excluir(Usuario usuario) throws Exception {
        usuarioDao.excluir(usuario);
    }

    public Usuario getByID(int idUsuario) throws Exception {
        return usuarioDao.getByID(idUsuario);
    }
}
