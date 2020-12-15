package br.ufes.sgi.telas.presenter;

import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.telas.view.ManterUsuariosView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManterUsuariosPresenter {

    private ManterUsuariosView view;

    private Usuario usuarioAtual;
    private UsuarioService usuarioService;

    public ManterUsuariosPresenter(Usuario usuarioAtual) {
        this.usuarioAtual = usuarioAtual;
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

            view.getBtnCriar().addActionListener((ActionEvent e) -> {
                //new CriarEditarUsuarioPresenter();
            });

            view.getBtnBuscar().addActionListener((ActionEvent e) -> {
                preencherTabela();
            });

            view.getBtnExcluir().addActionListener((ActionEvent e) -> {
                excluirUsuario();
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
            modelo.addRow(new Object[]{usuario.getId(), usuario.getApelido(), usuario.getNome(), tipoUsuario});
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

    private boolean verificarQuantidadeAdministradores() throws Exception {
        return usuarioService.getAdministradores().size() > 1;
    }

    private void excluirUsuario() {
        try {
            JTable tblUsuarios = view.getTblUsuarios();

            int select = tblUsuarios.getSelectedRow();
            int id = (int) tblUsuarios.getModel().getValueAt(select, 0);

            int resposta = JOptionPane.showConfirmDialog(null, "Confirma a exclusão",
                    "Exclusão", JOptionPane.YES_NO_OPTION);

            if (resposta > 0) {
                Usuario usuario = usuarioService.getById(id);
                
                if (!usuario.isAdmin() || usuario.isAdmin() && verificarQuantidadeAdministradores()) {
                    //permite a exclusao se for usuário comum, ou se for admim caso haja mais de um
                    //deve haver no mínimo um admin cadastrado
                    usuarioService.excluir(usuario);
                } else {
                    throw new Exception("Deve haver mais de um usuário administrador!");
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(),
                    "Erro ao excluir usuário!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void retornarTelaPrincipal() {
        new TelaPrincipalPresenter(usuarioAtual);

        view.setVisible(false);
        view.dispose();
    }
}
