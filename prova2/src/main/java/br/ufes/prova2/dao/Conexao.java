/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.prova2.dao;

import java.sql.*;

/**
 *
 * @author Lucas
 */
public class Conexao {

    public static Connection getConexao() {

        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/bdrepublica?useTimezone=true&serverTimezone=UTC", "root","1234");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
        return c;
    }

    public static void fecharConexao(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {}
    }

    public static void fecharConexao(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {}
    }

    public static void fecharConexao(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {}
    }
}
