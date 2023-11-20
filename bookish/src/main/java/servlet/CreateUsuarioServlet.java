package servlet;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/create-usuario")

public class CreateUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String usuarioNome = req.getParameter("nome");
        String usuarioEmail = req.getParameter("email");
        String usuarioSenha = req.getParameter("senha");
        String categoriaUsuario = req.getParameter("categoria-usuario");
        String usuarioLivro = req.getParameter("usuario-livro");
        String redeSocial = req.getParameter("rede-social");

        Usuario usuario = new Usuario(usuarioNome, usuarioEmail, usuarioSenha,categoriaUsuario,usuarioLivro,redeSocial);

        boolean isCadastrado = new UsuarioDAO().primeiroCadastroUsuario(usuario);


        if (isCadastrado) {

            req.getRequestDispatcher("login.jsp").forward(req, resp);

        } else {


            req.setAttribute("erroCadastro", "Erro ao cadastrar !!");


            req.getRequestDispatcher("cadastro/cadastro.jsp").forward(req, resp);


        }


    }

}
