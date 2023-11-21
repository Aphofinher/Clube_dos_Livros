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

        String SQL = "INSERT INTO comentario (COMENTARIO, ID_USUARIO, ID_CATEGORIA, DATA_COMENTARIO) VALUES (?, ?, ?, ?)";

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, obj.getComentario());
            comandoSQL.setString(2, obj.getEmail());
            comandoSQL.setInt(3, obj.getIdCategoria());
            comandoSQL.setDate(4, Date.valueOf(obj.getDataComentario()));

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

    public ArrayList<Comentario> listarComentario() {

        ArrayList<Comentario> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();


            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM comentario" +
                    " WHERE email = ? AND categoria = ? ORDER BY data_comentario DESC");


            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    Comentario obj = new Comentario();

                    obj.setId(rs.getInt("id"));
                    obj.setComentario(rs.getString("comentario"));
                    obj.setEmail(rs.getString("email"));
                    obj.setIdCategoria(rs.getInt("id-categoria"));
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
