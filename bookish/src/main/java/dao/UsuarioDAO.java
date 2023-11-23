package dao;


import config.ConnectionPoolConfig;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {


    public boolean primeiroCadastroUsuario(Usuario Obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "INSERT INTO USUARIO (nome, email, senha, redesocial) values (?,?,?,?)";


        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, Obj.getNome());
            comandoSQL.setString(2, Obj.getEmail());
            comandoSQL.setString(3, Obj.getSenha());
            comandoSQL.setString(4, Obj.getRedeSocial());

            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {

                retorno = true;

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL" + ex.getMessage());
        }

        return retorno;

    }

    public boolean verificaCredenciais(Usuario user) {

        String SQL = "SELECT * FROM USUARIO WHERE EMAIL = ? AND SENHA= ?";

        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, user.getEmail());
            comandoSQL.setString(2, user.getSenha());


            ResultSet rs = comandoSQL.executeQuery();

            System.out.println("sucesso ao executar query");
            while (rs.next()) {

                String email = rs.getString("email");
                String senha = rs.getString("senha");

                if (senha.equals(user.getSenha()) && email.equals(user.getEmail())) {
                    return true;
                }
            }

            conexao.close();
            return false;

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

            return false;
        }


    }


    public Usuario buscarUsuario(String email) {

        Usuario obj = null;
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            // Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM usuario" +
                    " WHERE email = ?");

            comandoSQL.setString(1, email);

            // Passo 4 - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    obj = new Usuario();

                    obj.setNome(rs.getString("nome"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setRedeSocial(rs.getString("redeSocial"));

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return obj;
    }

    public List<Usuario> buscarUsuarios() {

        List<Usuario> listaUsuarios = new ArrayList<>();
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            // Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM usuario");

            // Passo 4 - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {

                    Usuario obj = new Usuario();

                    obj.setNome(rs.getString("nome"));
                    obj.setEmail(rs.getString("email"));
                    obj.setSenha(rs.getString("senha"));
                    obj.setRedeSocial(rs.getString("redeSocial"));

                    listaUsuarios.add(obj);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver");
        } catch (SQLException ex) {
            System.out.println("Erro no SQL");
        }

        return listaUsuarios;
    }


    public boolean alterarUsuario(Usuario Obj) {

        boolean retorno = false;

        Connection conexao = null;

        String SQL = "UPDATE usuario SET nome = ? , email = ?, senha = ?,"
                + "redesocial = ?"
                + " WHERE email = ?";


        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement(SQL);

            comandoSQL.setString(1, Obj.getNome());
            comandoSQL.setString(2, Obj.getEmail());
            comandoSQL.setString(3, Obj.getSenha());
            comandoSQL.setString(4, Obj.getRedeSocial());

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

    public boolean excluirUsuario(String email) {

        boolean retorno = false;
        Connection conexao = null;

        try {

            conexao = ConnectionPoolConfig.getConnection();

            PreparedStatement comandoSQL
                    = conexao.prepareStatement("DELETE FROM usuario WHERE EMAIL = ?");

            comandoSQL.setString(1, email);


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
