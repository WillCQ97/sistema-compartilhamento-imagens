package br.ufes.sgi.telas.presenter;

import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.telas.view.CriarEditarUsuarioView;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CriarEditarUsuarioPresenter {

    private CriarEditarUsuarioView dadosView;

    public CriarEditarUsuarioPresenter() {
        this.dadosView = new CriarEditarUsuarioView();
        dadosView.setVisible(false);
    }

    private void criarUsuario() {
        dadosView.setVisible(true);
        dadosView.setTitle("Cadastro de Usuário");

        //aqui, ele deve apenas instanciar a tela de inserção/edição
        String nome = dadosView.getTxtNome().getText();
        String apelido = dadosView.getTxtApelido().getText();
        String senha = dadosView.getPswSenha().getText();
        String confirmacao = dadosView.getPswConfirmarSenha().getText();
        boolean admin = dadosView.getBtnAdministrador().isSelected();

        if (nome.isBlank() || apelido.isBlank() || senha.isBlank() || confirmacao.isBlank()) {

            JOptionPane.showMessageDialog(dadosView, "Os campos são de preenchimento obrigatório!");

        } else if (!senha.equals(confirmacao)) {

            JOptionPane.showMessageDialog(dadosView, "As senhas informadas não correspondem!");
            dadosView.getPswSenha().setText("");
            dadosView.getPswConfirmarSenha().setText("");

        } else {
            try {
                var novoUsuario = new Usuario(apelido, senha, nome, admin);
                //usuarioService.salvar(novoUsuario);

                dadosView.setVisible(false);
                dadosView.dispose();

                JOptionPane.showMessageDialog(dadosView, "Novo usuário cadastrado!: \n",
                        "Sucesso", +JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dadosView, "Não foi possível criar novo usuário: \n"
                        + ex.getMessage(), "Erro", +JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void editarUsuario() {
        JTable tblUsuarios = manterView.getTblUsuarios();

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
