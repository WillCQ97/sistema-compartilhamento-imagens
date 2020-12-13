package br.ufes.sgi.principal;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.presenter.LoginPresenter;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    
    public Main(){
        this.inicializarBancoDados("configuracao-banco.sql");
    }
    
    private void inicializarBancoDados(String caminhoArquivoConfiguracao) {
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
        LoginPresenter pLogin = new LoginPresenter();
    }

}
