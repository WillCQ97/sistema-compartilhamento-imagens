package br.ufes.sgi.dao;

import br.ufes.sgi.connection.ConnectionFactory;
import br.ufes.sgi.model.Imagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImagemDAO {

    public ArrayList<Imagem> getAll() throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select * from imagem");
            rs = ps.executeQuery();

            ArrayList<Imagem> list = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt(1);
                String descricao = rs.getString(2);

                list.add(new Imagem(id, descricao));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    public void salvar(Imagem imagem) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (imagem == null) {
            throw new Exception("Imagem não pode ser nulo!");
        }
        try {
            String SQL = "INSERT INTO imagem (caminho)"
                    + " values (?);";

            ps = conn.prepareStatement(SQL);

            ps.setString(1, imagem.getCaminho());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    public void excluir(Imagem imagem) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        if (imagem == null) {
            throw new Exception("Imagem não pode ser nulo!");
        }
        try {
            ps = conn.prepareStatement("delete from imagem where idImagem = ?");
            ps.setInt(1, imagem.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

    }

    public ArrayList<Imagem> getImagensByIdUsuario(int id) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement("select idImagem, caminho from imagem inner join permissao "
                    + "on (permissao.idImagem = Imagem.idImagem) where permissao.idUsuario = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            ArrayList<Imagem> list = new ArrayList<>();

            while (rs.next()) {
                int idImagem = rs.getInt(1);
                String caminho = rs.getString(2);

                list.add(new Imagem(idImagem, caminho));
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    public Imagem getImagemById(int id) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {

            ps = conn.prepareStatement("select Imagem.idImagem, imagem.caminho from permissao "
                    + "inner join imagem on (imagem.idImagem = ?)");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            int idImagem = rs.getInt(1);
            String caminho = rs.getString(2);

            Imagem img = new Imagem(idImagem, caminho);

            return img;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

}
