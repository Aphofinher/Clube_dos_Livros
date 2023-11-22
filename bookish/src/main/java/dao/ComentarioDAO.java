package dao;

import config.ConnectionPoolConfig;
import model.Comentario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ComentarioDAO {
    public boolean inserirComentario(Comentario obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "INSERT INTO comentario (COMENTARIO, EMAIL, ID_CATEGORIA, LIVRO, DATA_COMENTARIO) VALUES (?, ?, ?, ?, ?)";

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, obj.getComentario());
            comandoSQL.setString(2, obj.getEmail());
            comandoSQL.setInt(3, obj.getIdCategoria());
            comandoSQL.setString(4, obj.getLivro());
            comandoSQL.setDate(5, Date.valueOf(obj.getDataComentario()));

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return retorno;

    }


    public boolean editarComentario(Comentario obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "UPDATE comentario SET comentario = ?, id_categoria = ? WHERE id = ?";

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, obj.getComentario());
            comandoSQL.setInt(2, obj.getIdCategoria());
            comandoSQL.setInt(3, obj.getId());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return retorno;

    }

    public static boolean excluirComentario(int id) {

        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("DELETE FROM comentario WHERE id = ?");

            comandoSQL.setInt(1, id);

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return retorno;
    }

    public ArrayList<Comentario> listarComentario(String email) {

        ArrayList<Comentario> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM comentario" +
                    " WHERE email = ? ORDER BY ID DESC");

            comandoSQL.setString(1, email);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    Comentario obj = new Comentario();

                    obj.setId(rs.getInt("id"));
                    obj.setComentario(rs.getString("comentario"));
                    obj.setEmail(rs.getString("email"));
                    obj.setLivro(rs.getString("livro"));
                    obj.setIdCategoria(rs.getInt("id_categoria"));
                    obj.setDataComentario(LocalDate.parse(rs.getDate("data_comentario").toString()));


                    listaRetorno.add(obj);

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return listaRetorno;
    }

    public ArrayList<Comentario> listarComentario(int idCategoria) {

        ArrayList<Comentario> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM comentario" +
                    " WHERE ID_CATEGORIA = ? ORDER BY ID DESC");

            comandoSQL.setInt(1, idCategoria);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    Comentario obj = new Comentario();

                    obj.setId(rs.getInt("id"));
                    obj.setComentario(rs.getString("comentario"));
                    obj.setEmail(rs.getString("email"));
                    obj.setLivro(rs.getString("livro"));
                    obj.setIdCategoria(rs.getInt("id_categoria"));
                    obj.setDataComentario(LocalDate.parse(rs.getDate("data_comentario").toString()));

                    listaRetorno.add(obj);

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return listaRetorno;
    }
}
