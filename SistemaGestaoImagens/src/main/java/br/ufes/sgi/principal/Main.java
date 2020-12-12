package br.ufes.sgi.principal;

import br.ufes.sgi.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        Connection connection = ConnectionFactory.getConnection();
        
        //criação do banco, inserção e leitura dos dados
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("drop table if exists pessoa");
            statement.executeUpdate("create table pessoa (id integer, nome string)");
            statement.executeUpdate("insert into pessoa values(1, 'gabriel')");
            statement.executeUpdate("insert into pessoa values(2, 'willian')");

            ResultSet rs = statement.executeQuery("select * from pessoa");
            while (rs.next()) {
                // read the result set
                System.out.println("nome = " + rs.getString("nome"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}
