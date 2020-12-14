package br.ufes.sgi.presenter;

import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.view.ConfiguracaoInicialView;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ConfiguracaoInicialPresenter {

    private ConfiguracaoInicialView view;
    private UsuarioService usuarioService;

    public ConfiguracaoInicialPresenter() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detectamos que essa é a primeira execução do programa!\n");
        sb.append("É necessário que você crie um usuário que será o administrador\n");
        sb.append("e defina a pasta (diretório) do sistema onde estão os arquivos\n");
        sb.append("das imagens.\n");
        sb.append("Você também será o responsável por cadastrar os demais usuários\n");
        sb.append("no sistema.\n");
        sb.append("BOA SORTE!");
        
        this.view = new ConfiguracaoInicialView();
        view.getTxtCaminho().setEnabled(false);
        JOptionPane.showMessageDialog(view, sb.toString());
        
        try {
            this.usuarioService = new UsuarioService();
            
            view.getBtnInformarCaminho().addActionListener((ActionEvent e) -> {
                definirDiretorioImagens();
            });

            view.getBtnConfirmar().addActionListener((ActionEvent e) -> {
                efetuarCadastro();
            });

            view.getBtnSair().addActionListener((ActionEvent e) -> {
                view.setVisible(false);
                view.dispose();
            });

            view.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    private void definirDiretorioImagens() {
        int retorno = view.getJfcSeletorDiretorio().showOpenDialog(view);

        if (retorno == JFileChooser.APPROVE_OPTION) {

            File arquivo = view.getJfcSeletorDiretorio().getSelectedFile();
            String diretorio = arquivo.getPath();

            view.getTxtCaminho().setText(diretorio);
        }
    }
    
    // FIX-ME: OBSERVAÇÕES ABAIXO
    private void efetuarCadastro() {
        String nome = view.getTxtNome().getText();
        String usuario = view.getTxtUsuario().getText();
        String senha = view.getPswSenha().getText();
        String confirmacao = view.getPswConfirmarSenha().getText();
        String caminho = view.getTxtCaminho().getText();

        if (nome.isBlank() || usuario.isBlank() || senha.isBlank() || confirmacao.isBlank() || caminho.isBlank()) {

            JOptionPane.showMessageDialog(view, "Os campos são de preenchimento obrigatório!");

        } else if (!senha.equals(confirmacao)) {
            JOptionPane.showMessageDialog(view, "As senhas informadas não correspondem!");
            
            view.getPswSenha().setText("");
            view.getPswConfirmarSenha().setText("");
            
        } else {
            try {
                var novoUsuario = new Usuario();
                novoUsuario.setNome(nome);
                novoUsuario.setUsuario(usuario);
                novoUsuario.setSenha(senha);
                novoUsuario.setAdmin(true);

                usuarioService.salvar(novoUsuario);
                
                // AINDA TEM QUE SALVAR OS CAMINHOS DAS IMAGENS COM PERMISSAO TOTAL PARA ESSE USUÁRIO
                
                view.setVisible(false);
                view.dispose();
                
                var pTelaPrincipal = new TelaPrincipalPresenter(usuario, "Administrador");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Não foi possível criar novo usuário: \n"
                        + ex.getMessage());
            }
        }
    }
}
