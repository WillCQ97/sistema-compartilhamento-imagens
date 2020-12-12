package br.ufes.sgi.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            
            // para utilizar banco de dados em memória, sem escrever nada em arquivo
            //connection = DriverManager.getConnection("jdbc:sqlite::memory:");
            
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
