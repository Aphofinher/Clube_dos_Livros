package servlet;

import dao.CategoriaDAO;
import dao.ComentarioDAO;
import dao.UsuarioDAO;
import model.Categoria;
import model.Comentario;
import model.ComentarioTO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/exibir-por-categoria")
public class FiltrarPorCategoriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoriaId = Integer.parseInt(req.getParameter("categoriaId"));

        preencheAtributosBase(req, categoriaId);
        buscaUsuarioLogado(req);

        req.getRequestDispatcher("logada/logada.jsp").forward(req, resp);
    }

    private void buscaUsuarioLogado(HttpServletRequest req) {
        String email = req.getSession().getAttribute("loggedUser").toString();
        Usuario usuarioLogado = new UsuarioDAO().buscarUsuario(email);
        req.setAttribute("usuarioLogado", usuarioLogado);
    }

    private void preencheAtributosBase(HttpServletRequest req, int categoriaId) {
        ArrayList<Categoria> categorias = new CategoriaDAO().listarCategoria();
        ArrayList<Comentario> comentarios = new ComentarioDAO().listarComentario(categoriaId);
        List<ComentarioTO> comentarioView = preencherTO(comentarios);

        req.setAttribute("categorias", categorias);
        req.setAttribute("comentarios", comentarioView);
    }

    private List<ComentarioTO> preencherTO(ArrayList<Comentario> comentarios) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<ComentarioTO> comentarioView = new ArrayList<>();
        comentarios.forEach(comentario -> {
            Usuario usuario = usuarioDAO.buscarUsuario(comentario.getEmail());
            comentarioView.add(new ComentarioTO(usuario.getNome(), comentario.getComentario(), usuario.getRedeSocial(), comentario.getLivro()));
        });
        return comentarioView;
    }

}
