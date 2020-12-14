package br.ufes.sgi.presenter;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.ImagemService;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.view.ConfiguracaoInicialView;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ConfiguracaoInicialPresenter {

    private ConfiguracaoInicialView view;
    private UsuarioService usuarioService;
    private ImagemService imagemService;
    private File diretorioImagens;

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
        JOptionPane.showMessageDialog(view, sb.toString(), "Primeira Execução", JOptionPane.INFORMATION_MESSAGE);
        
        try {
            this.usuarioService = new UsuarioService();
            this.imagemService = new ImagemService();
            
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
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void definirDiretorioImagens() {
        int retorno = view.getJfcSeletorDiretorio().showOpenDialog(view);

        if (retorno == JFileChooser.APPROVE_OPTION) {

            diretorioImagens = view.getJfcSeletorDiretorio().getSelectedFile();
            String diretorio = diretorioImagens.getPath();

            view.getTxtCaminho().setText(diretorio);
        }
    }
    
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
                
                for(File arquivo : diretorioImagens.listFiles()){
                    
                    String nomeArquivo = arquivo.getName();
                    
                    if (nomeArquivo.endsWith(".jpg") || nomeArquivo.endsWith(".png") || nomeArquivo.endsWith(".jpeg")) {
                        imagemService.salvar(new Imagem(arquivo.getPath()));
                    }
                }
                
                view.setVisible(false);
                view.dispose();
                
                //Problemas nessa instanciação
                //var pTelaPrincipal = new TelaPrincipalPresenter(usuario, "Administrador");
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Não foi possível criar novo usuário: \n"
                        + ex.getMessage(), "Erro", + JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
