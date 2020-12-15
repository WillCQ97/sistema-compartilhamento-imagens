package br.ufes.sgi.telas.presenter;

import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.telas.view.LoginView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class LoginPresenter {

    private LoginView loginView;
    private UsuarioService usuarioService;

    public LoginPresenter() {

        try {
            this.usuarioService = new UsuarioService();

            if (verificarPrimeiraExecucao()) {
                new EfetuarConfiguracaoPresenter();

            } else {

                this.loginView = new LoginView();
                loginView.setVisible(true);

                loginView.getBtnEntrar().addActionListener((ActionEvent e) -> {
                    efetuarLogin();
                });

                loginView.getBtnSair().addActionListener((ActionEvent e) -> {
                    loginView.setVisible(false);
                    loginView.dispose();
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(loginView, ex.getMessage(), "Erro ao inicializar!", JOptionPane.ERROR_MESSAGE);
        }

    }

    private boolean verificarPrimeiraExecucao() throws Exception {
        int quantidadeUsuarios = usuarioService.getAll().size();

        return quantidadeUsuarios == 0;
    }

    private void efetuarLogin() {
        String apelido = loginView.getTxtApelido().getText();
        String senha = loginView.getPswSenha().getText();

        try {
            if (apelido.isBlank() || senha.isEmpty()) {
                throw new Exception("Por favor, informe usuário e senha!");

            } else {

                Usuario usuario = usuarioService.getByApelido(apelido);

                if (!senha.equals(usuario.getSenha())) {
                    loginView.getPswSenha().setText("");
                    throw new Exception("A senha está incorreta!");

                } else {

                    loginView.setVisible(false);
                    loginView.dispose();
                    new TelaPrincipalPresenter(usuario);

                }

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(loginView, "Erro ao efetuar login: \n" + ex.getMessage());
        }
    }
}
