package br.ufes.sgi.principal;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
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
        //LoginPresenter pLogin = new LoginPresenter();

        try {

            //testarCRUDUsuarioService();
            //testarCRUDImagem();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void testarCRUDUsuarioService() throws Exception {
        //teste listagem usuarios
        UsuarioService servicoUsuario = new UsuarioService();

        for (Usuario usuario : servicoUsuario.getAll()) {
            System.out.println(usuario.toString());
        }
        System.out.println("--\n");

        //teste salvamento usuario
        Usuario lupita = new Usuario(3, "la_lupita", "senha-forte", "Lupita", false);
        servicoUsuario.salvar(lupita);

        for (Usuario usuario : servicoUsuario.getAll()) {
            System.out.println(usuario.toString());
        }
        System.out.println("--\n");

        //atualização usuario
        lupita.setSenha("senha-fraca");
        servicoUsuario.atualizar(lupita);

        for (Usuario usuario : servicoUsuario.getAll()) {
            System.out.println(usuario.toString());
        }
        System.out.println("--\n");

        //remoção usuario
        servicoUsuario.excluir(lupita);

        for (Usuario usuario : servicoUsuario.getAll()) {
            System.out.println(usuario.toString());
        }
        System.out.println("--\n");

    }

    private static void testarCRUDImagem() throws Exception {

        ImagemService servico = new ImagemService();

        for (Imagem imagem : servico.getAll()) {
            System.out.println(imagem.toString());
        }
        System.out.println("--\n");

        Imagem img = new Imagem(2, "caminho-comprido/imagem.jpg");

        servico.salvar(img);
        for (Imagem imagem : servico.getAll()) {
            System.out.println(imagem.toString());
        }

    }

}
