package br.ufes.sgi.telas.presenter;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Notificacao;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Solicitacao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.NotificacaoService;
import br.ufes.sgi.service.PermissaoService;
import br.ufes.sgi.service.SolicitacaoService;
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
    private SolicitacaoService serviceSolicitacao;
    private Imagem imagem;

    public ListarUsuariosPresenter(Usuario usuarioAtual, ListarUsuariosEnum tipo, Imagem imagem) {
        this.usuarioAtual = usuarioAtual;
        this.imagem = imagem;
        this.view = new ListarUsuariosView();

        try {
            this.servicePermissao = new PermissaoService();
            this.serviceUsuario = new UsuarioService();
            this.serviceNotificacao = new NotificacaoService();
            this.serviceSolicitacao = new SolicitacaoService();

            if (tipo == ListarUsuariosEnum.COMPARTILHAR) {
                view.getBtnCompartilhar().setVisible(true);
                view.getBtnPedirPermissao().setVisible(false);
                view.setTitle("Compartilhamento de Imagem");
            } else {
                view.getBtnCompartilhar().setVisible(false);
                view.getBtnPedirPermissao().setVisible(true);
                view.setTitle("Solicitação de Acesso à Imagem");
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

                Notificacao n = new Notificacao(usuario, "Imagem: " + imagem.getCaminho() + " compartilhada com voce.");
                serviceNotificacao.salvar(n);

                JOptionPane.showMessageDialog(view, "compatilhamento efetuado");

            } catch (Exception ex) {
                System.out.println("erro " + ex.getMessage());
            }
        }
    }

    private void pedirPermissao() {
        JTable tabela = view.getTblUsuarios();
        int selecao = view.getTblUsuarios().getSelectedRow();

        try {
            String descricao = "Usuário " + usuarioAtual.getNome() + " solicitou acesso a imagem localizada em \n"
                    + imagem.getCaminho() + ".";

            Usuario administrador = serviceUsuario.getById((int) tabela.getModel().getValueAt(selecao, 0));

            Solicitacao s = new Solicitacao();
            s.setUsuarioSolicitante(usuarioAtual);
            s.setImagem(imagem);
            s.setAdminSolicitado(administrador);
            s.setDescricao(descricao);

            serviceSolicitacao.salvar(s);

            JOptionPane.showMessageDialog(view, "Solicitação enviada ao administrador!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro ao solicitar permissao: \n" + ex.getMessage());
        }
    }

}
