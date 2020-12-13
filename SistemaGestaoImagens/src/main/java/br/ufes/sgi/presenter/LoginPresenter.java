package br.ufes.sgi.presenter;

import br.ufes.sgi.view.LoginView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class LoginPresenter {

    private LoginView view;

    public LoginPresenter() {
        this.view = new LoginView();

        view.setVisible(true);

        view.getBtnEntrar().addActionListener((ActionEvent e) -> {
            efetuarLogin();
        });

        view.getBtnSair().addActionListener((ActionEvent e) -> {
            view.setVisible(false);
            view.dispose();
        });
    }

    public void efetuarLogin() {
        String usuario = view.getTxtUsuario().getText();
        String senha = view.getPswSenha().getText();

        if (usuario.isBlank() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, informe usuário e senha!");
            
        } else {
            //em seguida validar no banco de dados o usuário informado

            //caso esteja, ele entra na tela inicial do sistema
            //se não, ele permanece na tela de login
            TelaPrincipalPresenter pTelaPrincipal = new TelaPrincipalPresenter(usuario, "tst");

            view.setVisible(false);
            view.dispose();
        }
    }

}
