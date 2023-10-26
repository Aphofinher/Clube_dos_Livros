package dao;

import Ferramentas.Conexao;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    public  boolean inserirUsuario(Usuario Obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "INSERT INTO usuario SET nome = ? , email = ?, senha = ?,"
                + " categoriausuario = ?, livros = ?, redesocial = ?";


        try {

            conexao = Conexao.conectar();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, Obj.getNome());
            comandoSQL.setString(2, Obj.getEmail());
            comandoSQL.setString(3, Obj.getSenha());
            comandoSQL.setInt(4, Obj.getId());
            comandoSQL.setString(5, Obj.getCategoriaUsuario());
            comandoSQL.setString(6, Obj.getLivros());
            comandoSQL.setString(8, Obj.getRedeSocial());

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

    public static ArrayList<Usuario> listarUsuario(String nome) {

        ArrayList<Usuario> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {

            conexao = Conexao.conectar();

            // Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM usuario" +
                    " WHERE nome like ?" );

            comandoSQL.setString(1, nome);

            // Passo 4 - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    Usuario obj = new Usuario();

                    obj.setId(rs.getInt("id"));
                    obj.setNome(rs.getString("nome"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setCategoriaUsuario(rs.getString("categoriaUsuario"));
                    obj.setLivros(rs.getString("livros"));
                    obj.setRedeSocial(rs.getString("redeSocial"));



                    //Passo o objeto para a lista de retorno
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


    public static boolean alterarUsuario(Usuario Obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "UPDATE usuario SET nome = ? , email = ?, senha = ?,"
                + " categoriausuario = ?, livros = ?, redesocial = ?"
                + " WHERE id = ?";


        try {

            conexao = Conexao.conectar();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, Obj.getNome());
            comandoSQL.setString(2, Obj.getEmail());
            comandoSQL.setString(3, Obj.getSenha());
            comandoSQL.setInt(4, Obj.getId());
            comandoSQL.setString(5, Obj.getCategoriaUsuario());
            comandoSQL.setString(6, Obj.getLivros());
            comandoSQL.setString(8, Obj.getRedeSocial());

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

    public static boolean excluirUsuario(int id) {

        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = Conexao.conectar();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");

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


}
