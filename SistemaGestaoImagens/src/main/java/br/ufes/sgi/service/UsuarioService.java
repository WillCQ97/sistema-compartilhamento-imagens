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

    //DESSE MODO APENAS O ADMINISTRADOR PODE COMPARTILHAR
    //A verificação correta é se o usuário pode compartilhar a imagem em questão
    //compartilhar imagem, deveria receber uma imagem, usuario dono, usuario recebedor
    //essa classe instancia a permissao
    public void compartilharImagem(Usuario usuario, Permissao permissao) throws Exception {
        if (usuario.isAdmin()) {
            permissaoRepository.gerarCompartilhamento(permissao);
        } else {
            throw new Exception("O usuário não é administrador!");
        }
    }
    
    public Usuario getByName(String nome) throws Exception{
        return usuarioRepository.getByName(nome);
    }

}
