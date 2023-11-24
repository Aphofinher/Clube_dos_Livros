package servlet;

import dao.CategoriaDAO;
import model.Categoria;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/retorna-categoria")

public class RetornaCategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        List<Categoria> categoria = new CategoriaDAO().listarCategoria();

        req.setAttribute("categorias", categoria);

        req.getRequestDispatcher("logada/logada.jsp").forward(req, resp);


    }
}
