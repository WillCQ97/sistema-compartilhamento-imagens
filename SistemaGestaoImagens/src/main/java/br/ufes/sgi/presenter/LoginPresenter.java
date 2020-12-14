package br.ufes.sgi.presenter;

import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.view.ConfiguracaoInicialView;
import br.ufes.sgi.view.LoginView;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginPresenter {

    private LoginView loginView;
    private UsuarioService usuarioService;

    public LoginPresenter() {

        try {
            this.usuarioService = new UsuarioService();

            if (verificarPrimeiraExecucao()) {
                new ConfiguracaoInicialPresenter();

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
        String usuario = loginView.getTxtUsuario().getText();
        String senha = loginView.getPswSenha().getText();

        if (usuario.isBlank() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(loginView, "Por favor, informe usuário e senha!");

        } else {
            try {
                //em seguida validar no banco de dados o usuário informado

                //caso esteja, ele entra na tela inicial do sistema
                //se não, ele permanece na tela de login
                //TelaPrincipalPresenter pTelaPrincipal = new TelaPrincipalPresenter(usuario, "tst");
            } catch (Exception ex) {
                Logger.getLogger(LoginPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }

            loginView.setVisible(false);
            loginView.dispose();
        }
    }
}
