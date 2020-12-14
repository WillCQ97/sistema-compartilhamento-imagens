package br.ufes.sgi.repository;

import br.ufes.sgi.dao.UsuarioDAO;
import br.ufes.sgi.model.Usuario;
import java.util.ArrayList;

public class UsuarioRepository {

    private final UsuarioDAO dao;

    public UsuarioRepository() throws Exception {
        this.dao = new UsuarioDAO();
    }

    public ArrayList<Usuario> getAll() throws Exception {
        return dao.getAll();
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
            dao.salvar(usuario);
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
        dao.atualizar(usuario);
    }

    public void excluir(Usuario usuario) throws Exception {
        dao.excluir(usuario);
    }

    public Usuario getByID(int idUsuario) throws Exception {
        return dao.getByID(idUsuario);
    }
    public Usuario getByName(String nome) throws Exception{
        if(nome == null){
         throw new Exception("nome fornecido é nulo");   
        }
        return dao.getByName(nome);
    }
    
    public ArrayList<Usuario> getAllUser() throws Exception{
        return dao.getAllUser();
    }
    public ArrayList<Usuario> getAllAdm() throws Exception{
        return dao.getAllAdm();
    }
}
