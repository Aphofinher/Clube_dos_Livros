package servlet;

import dao.ComentarioDAO;
import model.Comentario;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/retornar-comentario")

public class RetornaComentárioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        List<Comentario> comentario = new ComentarioDAO().listarComentario();

        req.setAttribute("comentarios", comentario);

        req.getRequestDispatcher("logada/logada.jsp").forward(req, resp);


    }
}

