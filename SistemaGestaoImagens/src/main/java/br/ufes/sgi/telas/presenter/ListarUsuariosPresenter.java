package br.ufes.sgi.telas.presenter;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Notificacao;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.NotificacaoService;
import br.ufes.sgi.service.PermissaoService;
import br.ufes.sgi.service.UsuarioService;
import br.ufes.sgi.telas.view.ListarUsuariosView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListarUsuariosPresenter {

    private ListarUsuariosView view;
    private Usuario usuarioAtual;

    private PermissaoService servicePermissao;
    private UsuarioService serviceUsuario;
    private NotificacaoService serviceNotificacao;
    private Imagem imagem;

    public ListarUsuariosPresenter(Usuario usuarioAtual, ListarUsuariosEnum tipo, Imagem imagem) {
        this.usuarioAtual = usuarioAtual;
        this.imagem = imagem;
        this.view = new ListarUsuariosView();

        try {
            this.servicePermissao = new PermissaoService();
            this.serviceUsuario = new UsuarioService();
            this.serviceNotificacao = new NotificacaoService();

            if (tipo == ListarUsuariosEnum.COMPARTILHAR) {
                view.getBtnCompartilhar().setVisible(true);
                view.getBtnPedirPermissao().setVisible(false);
            } else {
                view.getBtnCompartilhar().setVisible(false);
                view.getBtnPedirPermissao().setVisible(true);
            }
            preencheTabela(tipo);

            view.getBtnCancelar().addActionListener((ActionEvent e) -> {
                new TelaPrincipalPresenter(usuarioAtual);
                view.setVisible(false);
                view.dispose();
            });

            view.getBtnCompartilhar().addActionListener((ActionEvent e) -> {
                compartilharImagem();
            });

            view.getBtnPedirPermissao().addActionListener((ActionEvent e) -> {
                pedirPermissao();
            });

            view.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(ListarUsuariosPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popularTabelaUsuarios(ArrayList<Usuario> usuarios) {
        DefaultTableModel modelo = (DefaultTableModel) view.getTblUsuarios().getModel();

        for (Usuario usuario : usuarios) {
            modelo.addRow(new Object[]{usuario.getId(), usuario.getNome()});
        }
    }

    private void preencheTabela(ListarUsuariosEnum tipo) throws Exception {
        if (tipo == ListarUsuariosEnum.COMPARTILHAR) {
            popularTabelaUsuarios(serviceUsuario.getUsuariosComuns());
        } else {
            popularTabelaUsuarios(serviceUsuario.getAdministradores());
        }
    }

    private void compartilharImagem() {

        JTable tabela = view.getTblUsuarios();

        int[] selecao = tabela.getSelectedRows();

        for (int i = 0; i < selecao.length; i++) {
            try {
                Usuario usuario = serviceUsuario.getById((int) tabela.getModel().getValueAt(selecao[i], 0));

                Permissao p = new Permissao(usuario, imagem, true, false, false);
                servicePermissao.salvarPermissao(p);
                System.out.println(p.toString());
                System.out.println(servicePermissao.getPermissao(usuario.getId(), imagem.getId()));

                Notificacao n = new Notificacao(usuario, "Imagem: " + imagem.getCaminho() + " compartilhada com voce.");
                serviceNotificacao.salvar(n);

                JOptionPane.showMessageDialog(view, "compatilhamento efetuado");

            } catch (Exception ex) {
                System.out.println("erro " + ex.getMessage());
            }
        }
    }

    private void pedirPermissao() {
        int selecao = view.getTblUsuarios().getSelectedRow();

        try {

            //IMPLEMENTAR O PEDIR PERMISSAO
            //aqui em notificacao, a gente descreve qual foi o pedido, passando o id da permissao, ai quando o admin abrir o sistema ele vai receber o notificacao
            //serviceNotificacao.salvarById(new Notificacao(new Usuario((int) jTable1.getModel().getValueAt(selecao, 0)),
            //       "Imagem: " + imagem.getCaminho() + " gerou um pedido de permissão pra ser visualizada"));
        } catch (Exception ex) {
            Logger.getLogger(ListarUsuariosView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
