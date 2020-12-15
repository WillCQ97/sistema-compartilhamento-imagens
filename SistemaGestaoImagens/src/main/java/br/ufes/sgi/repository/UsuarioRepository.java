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
            if (usuario.getApelido() == null || usuario.getApelido().isBlank()) {
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
    
    public Usuario getById(int idUsuario) throws Exception {
        return dao.getById(idUsuario);
    }

    public Usuario getByApelido(String apelido) throws Exception {
        if (apelido == null) {
            throw new Exception("nome fornecido é nulo");
        }
        
        for(Usuario usuario : this.getAll()){
            if(apelido.equals(usuario.getApelido())){
                return usuario;
            }
        }
        throw new Exception("Usuário com o apelido informado não encontrado!");
    }
    
    public ArrayList<Usuario> getAllAdministradores() throws Exception{
        ArrayList<Usuario> administradores = new ArrayList<>();
        
        for (Usuario usuario: this.getAll()){
            if(usuario.isAdmin()){
                administradores.add(usuario);
            }
        }
        
        return administradores;
    }
    
}
