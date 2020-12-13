package br.ufes.sgi.dao;

import br.ufes.sgi.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ufes.sgi.model.Usuario;

public class UsuarioDAO {

    public ArrayList<Usuario> getAll() throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement("select * from usuario");
            rs = ps.executeQuery();

            ArrayList<Usuario> list = new ArrayList<>();

            while (rs.next()) {
                int idUsuario = rs.getInt(1);
                String usuario = rs.getString(2);
                String senha = rs.getString(3);
                String nome = rs.getString(4);
                boolean admin = rs.getBoolean(5);

                list.add(new Usuario(idUsuario, usuario, senha, nome, admin));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    public void salvar(Usuario usuario) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (usuario == null) {
            throw new Exception("Usuario não pode ser nulo!");
        }

        try {
            String SQL = "INSERT INTO usuario (usuario, senha, nome, admin)"
                    + " values (?, ?, ?,?);";

            ps = conn.prepareStatement(SQL);

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNome());
            ps.setBoolean(4, usuario.isAdmin());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public void atualizar(Usuario usuario) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (usuario == null) {
            throw new Exception("Usuario não pode ser nulo!");
        }

        try {
            String SQL = "UPDATE usuario SET usuario=?, senha=?, nome = ?, admin=?"
                    + "where idUsuario = ?;";

            ps = conn.prepareStatement(SQL);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNome());
            ps.setBoolean(4, usuario.isAdmin());
            ps.setInt(5, usuario.getId());
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: " + sqle);

        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public void excluir(Usuario usuario) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (usuario == null) {
            throw new Exception("Usuario não pode ser nulo!");
        }

        try {
            ps = conn.prepareStatement("delete from usuario where idUsuario = ?");
            ps.setInt(1, usuario.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public Usuario getById(int idUsuario) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement("select * from usuario where idUsuario = ?;");
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();

            String usuario = rs.getString(2);
            String senha = rs.getString(3);
            String nome = rs.getString(4);
            boolean admin = rs.getBoolean(5);

            return new Usuario(idUsuario, usuario, senha, nome, admin);

        } catch (SQLException sqle) {
            throw new Exception(sqle);

        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    public Usuario getByName(String nome) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement("select * from usuario where nome = ?");
            ps.setString(1, nome);
            rs = ps.executeQuery();

            int idUsuario = rs.getInt(1);
            String usuario = rs.getString(2);
            String senha = rs.getString(3);
            String nome1 = rs.getString(4);
            boolean admin = rs.getBoolean(5);

            Usuario user = new Usuario(idUsuario, usuario, senha, nome1, admin);

            return user;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

    }

}
