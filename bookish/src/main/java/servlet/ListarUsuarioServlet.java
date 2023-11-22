package servlet;


import dao.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lista-usuario")
public class ListarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");

        //List<Usuario> usuario = new UsuarioDAO().listarUsuario(nome);

        //req.setAttribute("nome", usuario);

        req.getRequestDispatcher("../logada/logada.jsp").forward(req, resp);

    }

}