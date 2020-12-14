package br.ufes.sgi.view;

import br.ufes.sgi.view.imagem.ManipuladorImagem;
import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.service.ImagemService;
import br.ufes.sgi.service.PermissaoService;
import br.ufes.sgi.service.SolicitacaoService;
import br.ufes.sgi.service.UsuarioService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class TelaPrincipalView extends javax.swing.JFrame {

    private DefaultListModel listModel;
    private ImagemService serviceImagem;
    private Usuario usuario;//preciso receber um usuario por parametro
    private File[] listOfFiles;
    private PermissaoService servicePermissao;
    private UsuarioService serviceUsuario;
    private SolicitacaoService serviceSolicitacao;

    public TelaPrincipalView() throws Exception {
        initComponents();
        serviceUsuario = new UsuarioService();
        serviceSolicitacao = new SolicitacaoService();
        servicePermissao = new PermissaoService();
        listModel = new DefaultListModel();
        serviceImagem = new ImagemService();
        jList1 = new JList(modeloJlist(""));
    }

    private DefaultListModel modeloJlist(String path) throws Exception {
        File folder = new File(path);
        listOfFiles = folder.listFiles();

        int count = 0;
        for (int i = 0; i < listOfFiles.length; i++) {

            String name = listOfFiles[i].toString();
            preencherBanco(name);
            System.out.println(name);

            if (name.endsWith("jpg") || name.endsWith("png") || name.endsWith("jpeg")) {
                BufferedImage imagem;
                imagem = ManipuladorImagem.setImagemDimensao(listOfFiles[i].getAbsolutePath(), 60, 60);

                ImageIcon ii = new ImageIcon(imagem);
                listModel.add(count++, ii);
            }
        }
        return listModel;
    }

    // FIX-ME: ANALISAR ESTE CÓDIGO E REMOVELO DEPOIS
    public void preencherBanco(String path) throws Exception {
        if (serviceImagem.isNull()) {
            serviceImagem.salvar(new Imagem(path));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabelMostrarImagem = new javax.swing.JLabel();
        jButtonCompartilhar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonVisualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        tbRodape = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        txtNomeUsuario = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        txtTipoUsuario = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnNotificacao = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdministrador = new javax.swing.JMenu();
        menuOpcoes = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemManterUsuario = new javax.swing.JMenuItem();
        menuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Compartilhamento de Imagens");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabelMostrarImagem.setText("jLabel4");

        jButtonCompartilhar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonCompartilhar.setText("Compartilhar");
        jButtonCompartilhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompartilharActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonVisualizar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonVisualizar.setText("Visualizar");
        jButtonVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelMostrarImagem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonCompartilhar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonExcluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonVisualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButtonVisualizar)
                        .addGap(118, 118, 118)
                        .addComponent(jButtonCompartilhar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMostrarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExcluir)
                        .addGap(71, 71, 71))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelMostrarImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVisualizar)
                    .addComponent(jButtonCompartilhar)
                    .addComponent(jButtonExcluir))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        tbRodape.setFloatable(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("Usuário:");
        tbRodape.add(jLabel1);
        tbRodape.add(jSeparator7);

        txtNomeUsuario.setEditable(false);
        tbRodape.add(txtNomeUsuario);
        tbRodape.add(jSeparator3);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Tipo:");
        tbRodape.add(jLabel2);
        tbRodape.add(jSeparator6);

        txtTipoUsuario.setEditable(false);
        tbRodape.add(txtTipoUsuario);

        jSeparator2.setSeparatorSize(new java.awt.Dimension(100, 10));
        tbRodape.add(jSeparator2);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("Novas Notificações:");
        tbRodape.add(jLabel3);
        tbRodape.add(jSeparator5);

        btnNotificacao.setText("0");
        btnNotificacao.setFocusable(false);
        btnNotificacao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNotificacao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbRodape.add(btnNotificacao);
        tbRodape.add(jSeparator4);

        menuAdministrador.setText("Administrador");
        jMenuBar1.add(menuAdministrador);

        menuOpcoes.setText("Opções");

        jMenu2.setText("Usuário");

        jMenuItemManterUsuario.setText("Manter Usuário");
        jMenuItemManterUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemManterUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemManterUsuario);

        menuOpcoes.add(jMenu2);

        menuItemSair.setText("Sair");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });
        menuOpcoes.add(menuItemSair);

        jMenuBar1.add(menuOpcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(tbRodape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemSairActionPerformed

    private void jMenuItemManterUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManterUsuarioActionPerformed
        ListarUsuariosView l;
        try {
            l = new ListarUsuariosView();
            l.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemManterUsuarioActionPerformed

    private void jButtonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarActionPerformed
        try {
            int k = jList1.getSelectedIndex();
            String path = listOfFiles[k].toString();

            Imagem im = new Imagem();
            for (Imagem imagem : serviceImagem.getImagensByIdUsuario(usuario)) {
                if (imagem.getCaminho().equals(path)) {//procura a imagem pelo path
                    im = imagem;
                }
            }
            Permissao p = servicePermissao.getPermissao(im.getId(), usuario.getId());

            if (p != null) {//verifica se existe permissao

                if (p.isVisualizar()) {//verifica se ele pode visualizar
                    BufferedImage imagem;
                    imagem = ManipuladorImagem.setImagemDimensao(listOfFiles[k].getAbsolutePath(), 200, 200);
                    ImageIcon ii = new ImageIcon(imagem);
                    jLabelMostrarImagem.setIcon(ii);//mostra a imagem no label
                } else {//caso ela não possa visualizar
                    p.setVisualizar(true);//mudo o visualizar e passo para o pedido de permissao para ser aprovado
                    new AcessoNegadoView(p).setVisible(true);
                }

            } else {//caso ele não tenha permissao no banco
                
            }

        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jButtonVisualizarActionPerformed

    private void jButtonCompartilharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompartilharActionPerformed
        try {
            int k = jList1.getSelectedIndex();
            String path = listOfFiles[k].toString();

            Imagem im = new Imagem();
            for (Imagem imagem : serviceImagem.getImagensByIdUsuario(usuario)) {
                if (imagem.getCaminho().equals(path)) {//procura a imagem pelo path
                    im = imagem;
                }
            }

            Permissao p = servicePermissao.getPermissao(im.getId(), usuario.getId());

            if (p != null) {//verifica se existe permissao

                if (p.isCompartilhar()) {//verifica se ele pode compartilhar
                    new CompartilharImagemView(im, true);
                } else {
                    p.setCompartilhar(true);
                    new AcessoNegadoView(p).setVisible(true);
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCompartilharActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            int k = jList1.getSelectedIndex();
            String path = listOfFiles[k].toString();

            Imagem im = new Imagem();
            for (Imagem imagem : serviceImagem.getImagensByIdUsuario(usuario)) {
                if (imagem.getCaminho().equals(path)) {//procura a imagem pelo path
                    im = imagem;
                }
            }
            Permissao p = servicePermissao.getPermissao(im.getId(), usuario.getId());

            if (p != null) {//verifica se existe permissao

                if (p.isExcluir()) {//verifica se ele pode compartilhar
                    serviceImagem.excluir(p);
                } else {
                    new AcessoNegadoView(p).setVisible(true);
                }

            } else {

            }

        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaPrincipalView().setVisible(true);

                } catch (Exception ex) {
                    Logger.getLogger(TelaPrincipalView.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public JButton getBtnNotificacoes() {
        return this.btnNotificacao;
    }

    public JMenu getMenuAdministrador() {
        return this.menuAdministrador;
    }

    public JMenuItem getMenuItemSair() {
        return this.menuItemSair;
    }

    public JTextField getTxtNomeUsuario() {
        return this.txtNomeUsuario;
    }

    public JTextField getTxtTipoUsuario() {
        return this.txtTipoUsuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNotificacao;
    private javax.swing.JButton jButtonCompartilhar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonVisualizar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelMostrarImagem;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemManterUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenuItem menuItemSair;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JToolBar tbRodape;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JTextField txtTipoUsuario;
    // End of variables declaration//GEN-END:variables
}
