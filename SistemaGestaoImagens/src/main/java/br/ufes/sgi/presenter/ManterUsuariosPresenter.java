package br.ufes.sgi.presenter;

import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.view.ManterUsuariosView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManterUsuariosPresenter {

    private ManterUsuariosView view;
    private Usuario usuarioAtual;
    private UsuarioService usuarioService;

    public ManterUsuariosPresenter(Usuario usuario) {
        this.usuarioAtual = usuario;
        this.view = new ManterUsuariosView();

        view.getBtnEditar().setEnabled(false);
        view.getBtnExcluir().setEnabled(false);

        try {
            usuarioService = new UsuarioService();

            view.getTblUsuarios().addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    atualizarBotoes();
                }
            });

            view.getBtnBuscar().addActionListener((ActionEvent e) -> {
                preencherTabela();
            });

            view.getBtnVoltar().addActionListener((ActionEvent e) -> {
                retornarTelaPrincipal();
            });

            view.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(),
                    "Erro ao iniciar Manter Usuários!", JOptionPane.ERROR_MESSAGE);

            retornarTelaPrincipal();
        }

    }

    private void atualizarBotoes() {
        if (view.getTblUsuarios().getSelectedRow() != -1) {
            view.getBtnEditar().setEnabled(true);
            view.getBtnExcluir().setEnabled(true);
        } else {
            view.getBtnEditar().setEnabled(false);
            view.getBtnExcluir().setEnabled(false);
        }
    }

    private void popularTabela(DefaultTableModel modelo, ArrayList<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            String tipoUsuario = usuario.isAdmin() ? "Administrador" : "Usuário";
            modelo.addRow(new Object[]{usuario.getId(), usuario.getApelido(), usuario.getNome(), tipoUsuario });
        }
    }

    private void preencherTabela() {
        DefaultTableModel modeloTabela = (DefaultTableModel) view.getTblUsuarios().getModel();
        modeloTabela.setNumRows(0);

        try {
            if (!view.getBtnAdministrador().isSelected()) {
                popularTabela(modeloTabela, usuarioService.getAll());
            } else {
                popularTabela(modeloTabela, usuarioService.getAdministradores());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(),
                    "Erro ao preencher a tabela!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void retornarTelaPrincipal() {
        new TelaPrincipalPresenter(usuarioAtual);

        view.setVisible(false);
        view.dispose();
    }
}
