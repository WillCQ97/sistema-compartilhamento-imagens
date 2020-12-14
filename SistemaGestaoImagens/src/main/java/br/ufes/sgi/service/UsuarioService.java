package br.ufes.sgi.service;

import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.repository.UsuarioRepository;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.repository.PermissaoRepository;
import java.util.ArrayList;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PermissaoRepository permissaoRepository;

    public UsuarioService() throws Exception {
        this.usuarioRepository = new UsuarioRepository();
        this.permissaoRepository = new PermissaoRepository();
    }

    public ArrayList<Usuario> getAll() throws Exception {
        return usuarioRepository.getAll();
    }

    public void salvar(Usuario usuario) throws Exception {
        usuarioRepository.salvar(usuario);
    }

    public void atualizar(Usuario usuario) throws Exception {
        usuarioRepository.atualizar(usuario);
    }

    public void excluir(Usuario usuario) throws Exception {
        usuarioRepository.excluir(usuario);
    }

    public Usuario getById(int idUsuario) throws Exception {
        return usuarioRepository.getById(idUsuario);
    }

    public void compartilharImagem(Permissao permissao) throws Exception {
        if (permissao.isCompartilhar()) {
            permissaoRepository.gerarCompartilhamento(permissao);
        }
    }
    
    public Usuario getByApelido(String apelido) throws Exception{
        return usuarioRepository.getByApelido(apelido);
    }

}
