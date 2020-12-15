package br.ufes.sgi.telas.presenter;

import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.telas.view.CriarEditarUsuarioView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CriarEditarUsuarioPresenter {

    private CriarEditarUsuarioView view;
    private Usuario usuarioAtual;

    public CriarEditarUsuarioPresenter(Usuario usuarioAtual, CriarEditarUsuarioEnum opcao) {
        this.usuarioAtual = usuarioAtual;
        this.view = new CriarEditarUsuarioView();
        view.setVisible(true);

        view.getBtnSalvar().addActionListener((ActionEvent e) -> {
            executarOpcao(opcao);
        });

        view.getBtnCancelar().addActionListener((ActionEvent e) -> {
            view.setVisible(false);
            view.dispose();
            new ManterUsuariosPresenter(usuarioAtual);
        });
    }

    private void executarOpcao(CriarEditarUsuarioEnum opcao) {
        if (opcao == CriarEditarUsuarioEnum.CRIAR) {
            criarUsuario();
        } else if (opcao == CriarEditarUsuarioEnum.EDITAR) {
            editarUsuario();
        }
    }

    private void criarUsuario() {
        view.setTitle("Cadastro de Usuário");
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
                //usuarioService.salvar(novoUsuario);

                view.setVisible(false);
                view.dispose();

                JOptionPane.showMessageDialog(view, "Novo usuário cadastrado!: \n",
                        "Sucesso", +JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Não foi possível criar novo usuário: \n"
                        + ex.getMessage(), "Erro", +JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void editarUsuario() {
        view.setTitle("Edição de Usuário");
        
        
        JTable tblUsuarios = view.getTblUsuarios();

        int select = tblUsuarios.getSelectedRow();
        int id = (int) tblUsuarios.getModel().getValueAt(select, 0);
        /*
               this.serviceUsuario = new UsuarioService();
        this.user = user;
        jPFSenha.setText(user.getSenha());
        jTFNome.setText(user.getNome());
        jRbAdmin.setSelected(user.isAdmin());
         */
        /*
        if (jPFSenha.getText().equals(jPFConfirmarSenha.getText())) {
            user.setSenha(jPFSenha.getText());
            user.setNome(jTFNome.getText());
            user.setAdmin(jRbAdmin.isSelected());
            try {
                serviceUsuario.atualizar(user);
            } catch (Exception ex) {
                Logger.getLogger(EditarUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                throw new Exception("As senhas devem ser iguais!");
            } catch (Exception ex) {
                Logger.getLogger(EditarUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         */
        /*
        try {
            //new EditarUsuarioView(serviceUsuario.getById(id));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(),
                    "Erro ao iniciar edição do usuário!", JOptionPane.ERROR_MESSAGE);
        }
    }
                 }
