package br.ufes.sgi.telas.presenter;

import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.telas.view.CriarEditarUsuarioView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class CriarEditarUsuarioPresenter {

    private CriarEditarUsuarioView view;
    private Usuario usuarioAtual;
    private UsuarioService usuarioService;
    private boolean isEdicao;
    private int idUsuarioEdicao;

    public CriarEditarUsuarioPresenter(Usuario usuarioAtual, String campos) {
        try {
            this.usuarioAtual = usuarioAtual;
            this.usuarioService = new UsuarioService();
            this.view = new CriarEditarUsuarioView();

            if (campos == null) {
                view.setTitle("Cadastro de Usuário");
                this.isEdicao = false;
            } else {
                view.setTitle("Edição de Usuário");
                this.isEdicao = true;
                preencherCampos(campos);
                idUsuarioEdicao = Integer.parseInt(campos.split(",")[0]);
            }

            view.setVisible(true);

            view.getBtnSalvar().addActionListener((ActionEvent e) -> {
                if (isEdicao) {
                    editarUsuario();
                } else {
                    criarUsuario();
                }
            });

            view.getBtnCancelar().addActionListener((ActionEvent e) -> {
                view.setVisible(false);
                view.dispose();
                new ManterUsuariosPresenter(usuarioAtual);
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao efetuar operação: "
                    + ex.getMessage(), "Erro", +JOptionPane.ERROR_MESSAGE);
        }
    }

    private void criarUsuario() {

        String nome = view.getTxtNome().getText();
        String apelido = view.getTxtApelido().getText();
        String senha = view.getPswSenha().getText();
        String confirmacao = view.getPswConfirmarSenha().getText();
        boolean admin = view.getBtnAdministrador().isSelected();

        if (nome.isBlank() || apelido.isBlank() || senha.isBlank() || confirmacao.isBlank()) {

            JOptionPane.showMessageDialog(view, "Os campos são de preenchimento obrigatório!");

        } else if (!senha.equals(confirmacao)) {

            JOptionPane.showMessageDialog(view, "As senhas informadas não correspondem!");
            view.getPswSenha().setText("");
            view.getPswConfirmarSenha().setText("");

        } else {
            try {
                var novoUsuario = new Usuario(apelido, senha, nome, admin);
                usuarioService.salvar(novoUsuario);

                view.setVisible(false);
                view.dispose();


                JOptionPane.showMessageDialog(view, "Novo usuário cadastrado!: \n",
                        "Sucesso", +JOptionPane.INFORMATION_MESSAGE);

                new ManterUsuariosPresenter(usuarioAtual);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Não foi possível criar novo usuário: \n"
                        + ex.getMessage(), "Erro", +JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void preencherCampos(String campos) {
        String[] informacoes = campos.split(",");

        view.getTxtNome().setText(informacoes[1]);
        view.getTxtApelido().setText(informacoes[2]);
        view.getPswSenha().setText(informacoes[3]);
        view.getPswConfirmarSenha().setText(informacoes[3]);
        view.getBtnAdministrador().setSelected(Boolean.parseBoolean(informacoes[4]));

    }

    private void editarUsuario() {

        String nome = view.getTxtNome().getText();
        String apelido = view.getTxtApelido().getText();
        String senha = view.getPswSenha().getText();
        String confirmacao = view.getPswConfirmarSenha().getText();
        boolean admin = view.getBtnAdministrador().isSelected();

        if (nome.isBlank() || apelido.isBlank() || senha.isBlank() || confirmacao.isBlank()) {

            JOptionPane.showMessageDialog(view, "Os campos são de preenchimento obrigatório!");

        } else if (!senha.equals(confirmacao)) {

            JOptionPane.showMessageDialog(view, "As senhas informadas não correspondem!");
            view.getPswSenha().setText("");
            view.getPswConfirmarSenha().setText("");

        } else {
            try {
                var novoUsuario = new Usuario(idUsuarioEdicao, apelido, senha, nome, admin);
                usuarioService.atualizar(novoUsuario);

                view.setVisible(false);
                view.dispose();

                JOptionPane.showMessageDialog(view, "Dados do usuário atualizados!: \n",
                        "Sucesso", +JOptionPane.INFORMATION_MESSAGE);

                new ManterUsuariosPresenter(usuarioAtual);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Não foi possível atualizar usuário: \n"
                        + ex.getMessage(), "Erro", +JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
