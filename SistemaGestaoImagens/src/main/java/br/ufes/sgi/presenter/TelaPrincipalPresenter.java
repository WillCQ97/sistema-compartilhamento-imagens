package br.ufes.sgi.presenter;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.ImagemService;
import br.ufes.sgi.service.PermissaoService;
import br.ufes.sgi.service.UsuarioService;
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
            this.carregarListaArquivos();

            view.getBtnVisualizar().addActionListener((ActionEvent e) -> {
                //implementação da visualização
            });

            view.getBtnCompartilhar().addActionListener((ActionEvent e) -> {
                //implementação do compartilhamento
            });

            view.getBtnExcluir().addActionListener((ActionEvent e) -> {
                //implementação da exclusão
            });

            view.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Ocorreu um erro!", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void configurarOpcoesPorTipoUsuario() {
        
        if (usuario.isAdmin()) {
            //deixar todas as opções habilitadas
            view.getTxtTipoUsuario().setText("Administrador");
        } else {
            //desabilitar algumas funcionalidades
        }
    }

    private void carregarListaArquivos() {
        DefaultListModel listModel = new DefaultListModel();
        JList listaImagens = view.getLstImagens();
        
        try {
        
            int count = 0;
            for (Imagem imagem : imagemService.getAll()) {
                System.out.println(imagem.toString());

                BufferedImage buffImage;
                buffImage = ManipuladorImagem.setImagemDimensao(imagem.getCaminho(), 60, 60);

                ImageIcon icon = new ImageIcon(buffImage);
                listModel.add(count++, icon);
            }
            
            listaImagens.setModel(listModel);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Não foi possível obter a lista de imagens.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void visualizarImagem() {

    }
}
