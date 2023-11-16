package servlet;

import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/login/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario usuario = new Usuario(email, senha);

        boolean isValidUser = new UsuarioDAO().verificaCredenciais(usuario);

        if (isValidUser) {

            req.getSession().setAttribute("loggedUser", email);

            resp.sendRedirect("Logada/logada.jsp");

        } else {



            req.setAttribute("aviso", "Usuário ou senha inválidos!!");

            //resp.sendRedirect("/login/login.jsp");

            req.getRequestDispatcher("login/login.jsp").forward(req, resp);




        }

    }


}
