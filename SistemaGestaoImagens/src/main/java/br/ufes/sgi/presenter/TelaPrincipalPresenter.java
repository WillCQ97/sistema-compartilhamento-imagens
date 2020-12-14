package br.ufes.sgi.presenter;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.ImagemService;
import br.ufes.sgi.service.PermissaoService;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.view.AcessoNegadoView;
import br.ufes.sgi.view.ListarUsuariosView;
import br.ufes.sgi.view.TelaPrincipalView;
import br.ufes.sgi.view.imagem.ManipuladorImagem;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class TelaPrincipalPresenter {

    private TelaPrincipalView view;

    private Usuario usuario;
    private ImagemService imagemService;
    private PermissaoService permissaoService;
    private UsuarioService usuarioService;

    public TelaPrincipalPresenter(Usuario usuario) {
        this.usuario = usuario;
        this.view = new TelaPrincipalView();

        try {
            this.imagemService = new ImagemService();
            this.usuarioService = new UsuarioService();
            this.permissaoService = new PermissaoService();

            view.getTxtNomeUsuario().setText(usuario.getNome());

            this.configurarOpcoesPorTipoUsuario();

            //adicionar um método de espera aqui
            this.carregarListaImagens();

            view.getBtnVisualizar().addActionListener((ActionEvent e) -> {
                visualizarImagem();
            });

            view.getBtnCompartilhar().addActionListener((ActionEvent e) -> {
                //implementação do compartilhamento
            });

            view.getBtnExcluir().addActionListener((ActionEvent e) -> {
                //implementação da exclusão
            });

            view.getMenuItemManterUsuarios().addActionListener((ActionEvent e) -> {
                manterUsuarios();
            });

            view.getMenuItemSair().addActionListener((ActionEvent e) -> {
                view.setVisible(false);
                view.dispose();
            });

            view.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void configurarOpcoesPorTipoUsuario() {
        if (usuario.isAdmin()) {
            view.getTxtTipoUsuario().setText("Administrador");
        } else {
            view.getTxtTipoUsuario().setText("Usuário");
            view.getMenuItemManterUsuarios().setEnabled(false);
            view.getBtnCompartilhar().setEnabled(false);
            view.getBtnExcluir().setEnabled(false);
        }
    }

    // será necessário haver um listener na tabela, quando for identificado o clic
    //pega a posição, instancia a imagem, perquisa pelo permissao e atualiza os botoes
    private void atualizarPermissaoPorImagem(Imagem imagem) {

        //realizar um get por imagem no banco
        //view.getBtnCompartilhar().setEnabled(false);
        //view.getBtnExcluir().setEnabled(false);
    }

    private void carregarListaImagens() {
        DefaultListModel listModel = new DefaultListModel();
        JList listaImagens = view.getLstImagens();

        try {

            int count = 0;
            for (Imagem imagem : imagemService.getAll()) {
                BufferedImage buffImage;
                buffImage = ManipuladorImagem.setImagemDimensao(imagem.getCaminho(), 100, 100);

                ImageIcon icon = new ImageIcon(buffImage);
                listModel.add(count++, icon);
            }

            listaImagens.setModel(listModel);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Não foi possível obter a lista de imagens.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void manterUsuarios() {

        ListarUsuariosView lusuariosView;
        try {
            
            lusuariosView = new ListarUsuariosView();
            lusuariosView.setVisible(true);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Não foi possível iniciar tela de Manter Usuários.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void renderizarImagem(Imagem imagem) {
        BufferedImage buffImage;
        buffImage = ManipuladorImagem.setImagemDimensao(imagem.getCaminho(), 450, 450);

        ImageIcon imageIcon = new ImageIcon(buffImage);
        view.getLblMostrarImagem().setIcon(imageIcon);
    }

    private void visualizarImagem() {
        try {
            JList lstImagens = view.getLstImagens();

            int posicaoImagem = lstImagens.getSelectedIndex();
            Imagem imagem = imagemService.getAll().get(posicaoImagem);

            if (usuario.isAdmin()) {
                this.renderizarImagem(imagem);
            } else {
                //verifica a permissao para esse user e imagem no banco se houver
                //                permissaoService.ver
                System.out.println(permissaoService.verificarPermissao(usuario, imagem));
            }
            /*
            if (permissaoService.verificarPermissao(usuario, imagem)) {
                if (p.isVisualizar()) {
                   
                }
            } else {
                new AcessoNegadoView(usuario, imagem).setVisible(true);
            }
             */
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex);
        }
    }
}
