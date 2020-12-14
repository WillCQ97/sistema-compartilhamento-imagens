package br.ufes.sgi.principal;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import br.ufes.sgi.presenter.LoginPresenter;
import br.ufes.sgi.service.ImagemService;
import br.ufes.sgi.service.PermissaoService;
import br.ufes.sgi.service.UsuarioService;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    private static void inicializarBancoDados(String caminhoArquivoConfiguracao) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            File arquivo = new File(caminhoArquivoConfiguracao);

            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (!linha.isBlank()) {
                    statement.addBatch(linha);
                }
            }

            statement.executeBatch();

        } catch (SQLException | FileNotFoundException ex) {
            System.err.println(ex.getMessage());

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        inicializarBancoDados("configuracao-banco.sql");
        LoginPresenter pLogin = new LoginPresenter();
        
        /*
        try {

            testarDAO();

        } catch (Exception ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
        */
    }

    private static void testarDAO() throws Exception {
        
        // USUARIO DAO
        UsuarioService sUsuario = new UsuarioService();

        for (Usuario usuario : sUsuario.getAll()) {
            System.out.println(usuario.toString());
        }
        System.out.println("--\n");

        //teste salvamento usuario
        Usuario lupita = new Usuario(3, "la_lupita", "senha-forte", "Lupita", false);
        sUsuario.salvar(lupita);

        for (Usuario usuario : sUsuario.getAll()) {
            System.out.println(usuario.toString());
        }
        System.out.println("--\n");

        //atualização usuario
        lupita.setSenha("senha-fraca");
        sUsuario.atualizar(lupita);

        for (Usuario usuario : sUsuario.getAll()) {
            System.out.println(usuario.toString());
        }
        System.out.println("--\n");

        //remoção usuario
        sUsuario.excluir(lupita);

        for (Usuario usuario : sUsuario.getAll()) {
            System.out.println(usuario.toString());
        }
        System.out.println("--\n");
        
        
        //TESTANDO IMAGEM
        ImagemService sImagem = new ImagemService();

        for (Imagem imagem : sImagem.getAll()) {
            System.out.println(imagem.toString());
        }
        System.out.println("--\n");

        Imagem img = new Imagem(2, "caminho-comprido/imagem.jpg");

        sImagem.salvar(img);
        for (Imagem imagem : sImagem.getAll()) {
            System.out.println(imagem.toString());
        }
        
        //TESTANDO PERMISSAO
        PermissaoService sPermissao = new PermissaoService();
        
        var uGabriel = sUsuario.getById(1);
        System.out.println(uGabriel.toString());

        /*
        Permissao permissao = sPermissao.getPermissaoByUsuario(uGabriel);
        System.out.println(permissao.toString());
        
        // TESTANDO COMPARTILHAMENTO 
        System.out.println("\n------------------------------");
        
        var uWillian = sUsuario.getById(2);
        System.out.println(uWillian.toString());
        
        var pWillian = new Permissao(uWillian, img, true, false, false);
        System.out.println("Adicionar a " + pWillian.toString());        
        
        System.out.println("----------------------------------");
        sUsuario.compartilharImagem(uGabriel, pWillian); //dono da imagem, permissao pro outro user
        
        System.out.println("-------------------------------");
        System.out.println(sPermissao.getPermissaoByUsuario(uGabriel).toString());
        System.out.println(sPermissao.getPermissaoByUsuario(uWillian).toString());
        System.out.println("-------------------------------");
        */

    }

}
