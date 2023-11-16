package servlet;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/alterar-usuario")

public class AlterarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String categorias = req.getParameter("categorias");
        String livros = req.getParameter("livros");
        String instagram = req.getParameter("instagram");


        Usuario usuario = new Usuario(nome, email, senha, instagram);

        new UsuarioDAO().alterarUsuario(usuario);

        req.setAttribute("confirma-alteração", "Usuario alterado com sucesso!");


    }

}
