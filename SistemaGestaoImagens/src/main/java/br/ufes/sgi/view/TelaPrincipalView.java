package br.ufes.sgi.view;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class TelaPrincipalView extends javax.swing.JFrame {

    public TelaPrincipalView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstImagens = new javax.swing.JList<>();
        lblMostrarImagem = new javax.swing.JLabel();
        btnCompartilhar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
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

        jScrollPane1.setViewportView(lstImagens);

        btnCompartilhar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnCompartilhar.setText("Compartilhar");

        btnExcluir.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnExcluir.setText("Excluir");

        btnVisualizar.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblMostrarImagem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCompartilhar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnExcluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnVisualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(btnVisualizar)
                        .addGap(118, 118, 118)
                        .addComponent(btnCompartilhar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMostrarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addGap(71, 71, 71))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMostrarImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVisualizar)
                    .addComponent(btnCompartilhar)
                    .addComponent(btnExcluir))
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

    private void jMenuItemManterUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemManterUsuarioActionPerformed
        /*
        ListarUsuariosView l;
        try {
            l = new ListarUsuariosView();
            l.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }//GEN-LAST:event_jMenuItemManterUsuarioActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        /*        try {

            int k = lstImagens.getSelectedIndex();
            String path = listOfFiles[k].toString();

            Imagem im = new Imagem();
            for (Imagem imagem : serviceImagem.getImagensByIdUsuario(usuario)) {
                if (imagem.getCaminho().equals(path)) {//procura a imagem pelo path
                    im = imagem;
                }
            }

            Permissao p = new Permissao(usuario, im, true, true, true);

            if (servicePermissao.verificaPermissao(p)) {//verifica se existe permissao

                if (p.isVisualizar()) {//verifica se ele pode visualizar
                    BufferedImage imagem;
                    imagem = ManipuladorImagem.setImagemDimensao(listOfFiles[k].getAbsolutePath(), 200, 200);
                    ImageIcon ii = new ImageIcon(imagem);
                    lblMostrarImagem.setIcon(ii);//mostra a imagem no label
                }

            }
            //caso ele não tenho permissao
            else{
                new AcessoNegadoView(usuario,im).setVisible(true);
            }

        } catch (Exception ex) {
            Logger.getLogger(TelaPrincipalView.class.getName()).log(Level.SEVERE, null, ex);

        }*/
    }//GEN-LAST:event_btnVisualizarActionPerformed

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
                new TelaPrincipalView().setVisible(true);
            }
        });
    }

    public JButton getBtnCompartilhar() {
        return this.btnCompartilhar;
    }

    public JButton getBtnExcluir() {
        return this.btnExcluir;
    }

    public JButton getBtnVisualizar() {
        return this.btnVisualizar;
    }

    public JButton getBtnNotificacoes() {
        return this.btnNotificacao;
    }

    public JList getLstImagens() {
        return this.lstImagens;
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
    private javax.swing.JButton btnCompartilhar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNotificacao;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel lblMostrarImagem;
    private javax.swing.JList<String> lstImagens;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenuItem menuItemSair;
    private javax.swing.JMenu menuOpcoes;
    private javax.swing.JToolBar tbRodape;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JTextField txtTipoUsuario;
    // End of variables declaration//GEN-END:variables
}
