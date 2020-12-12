package br.ufes.sgi.principal;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.presenter.LoginPresenter;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        
        /*
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            File arquivo = new File("configuracao-banco.sql");

            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (!linha.isBlank()) {
                    statement.addBatch(linha);
                }
            }

            statement.executeBatch();

            // Verifica as informações adicionadas --> FIX-ME: REMOVER ESSA PARTE APÓS A FINALIZAÇÃO
            ResultSet rs = statement.executeQuery("select * from usuario");

            while (rs.next()) {
                System.out.println("id = " + rs.getInt("idUsuario"));
                System.out.println("nome = " + rs.getString("nome"));
                System.out.println("usuario = " + rs.getString("usuario"));
                System.out.println("senha = " + rs.getString("senha"));
                System.out.println("admin = " + rs.getString("admin"));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        */
        LoginPresenter pLogin = new LoginPresenter();
    }
}
