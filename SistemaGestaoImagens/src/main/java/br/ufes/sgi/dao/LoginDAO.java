/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufes.sgi.model.Usuario;

/**
 *
 * @author 55289
 */
public class LoginDAO {

    private Connection conn;

    public LoginDAO() throws Exception {
        try {
            //this.conn = ConexaoSQLITE.getConexao();
        } catch (Exception e) {
            throw new Exception("Erro: \n" + e.getMessage());
        }
    }

    public LoginDAO(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<Usuario> getAll() throws Exception {
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select * from UsuarioLogin");
            rs = ps.executeQuery();

            ArrayList<Usuario> list = new ArrayList<>();

            while (rs.next()) {
                int idUsuarioLogin = rs.getInt(1);
                String usuario = rs.getString(2);
                String senha = rs.getString(3);
                String nome = rs.getString(4);
                boolean admin = rs.getBoolean(5);

                list.add(new Usuario(idUsuarioLogin, usuario, senha, nome, admin));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            //Conexao.fecharConexao(conn, ps, rs);
        }
    }

    public void salvar(Usuario usuarioLogin) throws Exception {
        PreparedStatement ps = null;

        if (usuarioLogin == null) {
            throw new Exception("UsuarioLogin não pode ser nulo!");
        }
        try {
            String SQL = "INSERT INTO usuariologin (usuario, senha, nome, admin)"
                    + " values (?, ?, ?,?);";

            ps = conn.prepareStatement(SQL);

            ps.setString(1, usuarioLogin.getUsuario());
            ps.setString(2, usuarioLogin.getSenha());
            ps.setString(3, usuarioLogin.getNome());
            ps.setBoolean(4, usuarioLogin.isAdmin());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            //Conexao.fecharConexao(conn, ps);
        }
    }

    public void atualizar(Usuario usuarioLogin) throws Exception {
        PreparedStatement ps = null;

        if (usuarioLogin == null) {
            throw new Exception("UsuarioLogin não pode ser nulo!");
        }
        try {
            String SQL = "UPDATE usuarioLogin SET usuario=?, senha=?, nome = ?, admin=?"
                    + "where idUsuarioLogin = ?;";

            ps = conn.prepareStatement(SQL);
            ps.setString(1, usuarioLogin.getUsuario());
            ps.setString(2, usuarioLogin.getSenha());
            ps.setString(3, usuarioLogin.getNome());
            ps.setBoolean(4, usuarioLogin.isAdmin());
            ps.setInt(5, usuarioLogin.getId());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: " + sqle);
        } finally {
            //Conexao.fecharConexao(conn, ps);
        }
    }

    public void excluir(Usuario usuarioLogin) throws Exception {
        PreparedStatement ps = null;

        if (usuarioLogin == null) {
            throw new Exception("UsuarioLogin não pode ser nulo!");
        }
        try {
            ps = conn.prepareStatement("delete from usuarioLogin where idUsuarioLogin = ?");
            ps.setInt(1, usuarioLogin.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            //Conexao.fecharConexao(conn, ps);
        }
    }
}
