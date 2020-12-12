package br.ufes.sgi.principal;

import br.ufes.sgi.connection.ConnectionFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            File batch = new File("../batch.sql");
            
            try {
                Scanner scan = new Scanner(batch);

                while (scan.hasNextLine()) {
                    String linha = scan.nextLine();
                    statement.addBatch(linha);
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Erro " + ex.getMessage());
            }

            statement.executeBatch();

            ResultSet rs = statement.executeQuery("select * from pessoa");
            while (rs.next()) {
                // read the result set
                System.out.println("nome = " + rs.getString("nome"));
                System.out.println("id = " + rs.getInt("id"));
            }
            System.out.println("asd-----");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }

}
