package br.ufes.sgi.telas.presenter;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.ImagemService;
import br.ufes.sgi.service.PermissaoService;
import br.ufes.sgi.service.SolicitacaoService;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.telas.view.TelaPrincipalView;
import br.ufes.sgi.telas.view.imagem.ManipuladorImagem;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class TelaPrincipalPresenter {

    private TelaPrincipalView view;

    private Usuario usuarioAtual;
    private ImagemService imagemService;
    private PermissaoService permissaoService;
    private SolicitacaoService solicitacaoService;
    private UsuarioService usuarioService;

    public TelaPrincipalPresenter(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
        this.view = new TelaPrincipalView();

        try {
            this.imagemService = new ImagemService();
            this.usuarioService = new UsuarioService();
            this.permissaoService = new PermissaoService();
            this.solicitacaoService = new SolicitacaoService();

            view.getTxtNomeUsuario().setText(usuarioAtual.getNome());

            this.configurarOpcoesPorTipoUsuario();

            //adicionar um método de espera aqui ou não kk
            this.carregarListaImagens();

            view.getBtnVisualizar().addActionListener((ActionEvent e) -> {
                visualizarImagem();
            });

            view.getBtnCompartilhar().addActionListener((ActionEvent e) -> {
                compartilharImagem();
            });

            view.getBtnExcluir().addActionListener((ActionEvent e) -> {
                excluirImagem();
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
        if (usuarioAtual.isAdmin()) {
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
        new ManterUsuariosPresenter(this.usuarioAtual);

        view.setVisible(false);
        view.dispose();
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
            if (posicaoImagem == -1) {
                throw new Exception("Selecione uma imagem e tente novamente!");
            }

            Imagem imagem = imagemService.getImagemByIndex(posicaoImagem);

            if (usuarioAtual.isAdmin()) {
                this.renderizarImagem(imagem);
            } else {
                if (permissaoService.verificarPermissao(usuarioAtual, imagem)) {
                    Permissao p = permissaoService.getPermissao(usuarioAtual.getId(), imagem.getId());
                    if (p.isVisualizar()) {
                        this.renderizarImagem(imagem);
                    }
                } else {

                    view.setEnabled(false);
                    String mensagem = "Você não tem permissão para visualizar esta imagem!\n"
                            + "Você deseja solicitar permissao?\n";

                    int resposta = JOptionPane.showConfirmDialog(view, mensagem,
                            "Acesso Negado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (resposta == JOptionPane.YES_OPTION) {
                        solicitarAcesso();
                    }
                    
                    view.setEnabled(true);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex);
        }
    }

    private void solicitarAcesso() {
        //processa a solicitação
    }
    
    private void compartilharImagem(){
        
    }
    
    private void excluirImagem(){
        
    }
}
