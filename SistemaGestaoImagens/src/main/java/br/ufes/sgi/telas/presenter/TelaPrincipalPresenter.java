package br.ufes.sgi.telas.presenter;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Notificacao;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Solicitacao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.ImagemService;
import br.ufes.sgi.service.NotificacaoService;
import br.ufes.sgi.service.PermissaoService;
import br.ufes.sgi.service.SolicitacaoService;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.telas.view.NotificacaoView;
import br.ufes.sgi.telas.view.SetarPermissaoView;
import br.ufes.sgi.telas.view.TelaPrincipalView;
import br.ufes.sgi.telas.view.imagem.ManipuladorImagem;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private NotificacaoService notificacaoService;
    private UsuarioService usuarioService;

    public TelaPrincipalPresenter(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
        this.view = new TelaPrincipalView();

        try {
            this.imagemService = new ImagemService();
            this.usuarioService = new UsuarioService();
            this.permissaoService = new PermissaoService();
            this.solicitacaoService = new SolicitacaoService();
            this.notificacaoService = new NotificacaoService();

            view.getTxtNomeUsuario().setText(usuarioAtual.getNome());

            this.configurarOpcoesPorTipoUsuario();

            this.verificarNotificacao();

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

            view.getBtnNotificacoes().addActionListener((ActionEvent e) -> {
                exibirNotificoes();
            });

            view.getLstImagens().addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (!usuarioAtual.isAdmin()) {
                        atualizaBotoesPorPermissaoPorImagem();
                    }
                }
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

    private void verificarNotificacao() {
        try {
            if (usuarioAtual.isAdmin()) {
                int qtdSol = solicitacaoService.getByIdAdmin(usuarioAtual.getId()).size();
                view.getBtnNotificacoes().setText(Integer.toString(qtdSol));

            } else {
                int qtdSol = notificacaoService.getNotificacoesById(usuarioAtual.getId()).size();
                view.getBtnNotificacoes().setText(Integer.toString(qtdSol));

                /*
                for (Notificacao not : notificacaoService.getNotificacoesById(usuarioAtual.getId())) {
                    NotificacaoView nv = new NotificacaoView(not);
                    nv.setVisible(true);
                }
                 */
            }
        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
        }
    }

    private void exibirNotificoes() {
        try {
            if (usuarioAtual.isAdmin()) {
                for (Solicitacao s : solicitacaoService.getByIdAdmin(usuarioAtual.getId())) {
                    SetarPermissaoView stv = new SetarPermissaoView(s);
                    stv.setVisible(true);
                }
            } else {
                for (Notificacao not : notificacaoService.getNotificacoesById(usuarioAtual.getId())) {
                    NotificacaoView nv = new NotificacaoView(not);
                    nv.setVisible(true);
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro " + ex.getMessage());
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
            view.getBtnVisualizar().setEnabled(false);
        }
    }

    private Imagem obterImagemSelecionada() throws Exception {
        JList lstImagens = view.getLstImagens();

        int posicaoImagem = lstImagens.getSelectedIndex();
        return imagemService.getImagemByIndex(posicaoImagem);
    }

    private void atualizaBotoesPorPermissaoPorImagem() {
        try {
            Imagem imagem = obterImagemSelecionada();
            view.getLblMostrarImagem().setIcon(null);

            if (permissaoService.verificarPermissao(usuarioAtual, imagem)) {
                Permissao p = permissaoService.getPermissao(usuarioAtual.getId(), imagem.getId());
                view.getBtnVisualizar().setEnabled(p.isVisualizar());
                view.getBtnCompartilhar().setEnabled(p.isCompartilhar());
                view.getBtnExcluir().setEnabled(p.isExcluir());

            } else {

                view.setEnabled(false);
                String mensagem = "Você não possui permissões para esta imagem!\n"
                        + "Você deseja solicitar permissao?\n";

                int resposta = JOptionPane.showConfirmDialog(view, mensagem,
                        "Acesso Negado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (resposta == JOptionPane.YES_OPTION) {
                    solicitarAcesso(imagem);
                }

                view.setEnabled(true);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro ao verificar permissões para imagem selecionada!",
                    JOptionPane.ERROR_MESSAGE);
        }
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
            Imagem imagem = obterImagemSelecionada();
            this.renderizarImagem(imagem);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao renderizar imagem:\n" + ex.getMessage());
        }
    }

    private void solicitarAcesso(Imagem imagem) {
        try {
            new ListarUsuariosPresenter(usuarioAtual, ListarUsuariosEnum.PEDIR_PERMISSAO, imagem);
            view.setVisible(false);
            view.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Erro ao renderizar imagem:\n" + e.getMessage());
        }
    }

    private void compartilharImagem() {
        try {
            new ListarUsuariosPresenter(usuarioAtual, ListarUsuariosEnum.COMPARTILHAR, obterImagemSelecionada());
            view.setVisible(false);
            view.dispose();
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void excluirImagem() {
        JOptionPane.showMessageDialog(view, "Funcionalidade não implementada!");
    }
}
