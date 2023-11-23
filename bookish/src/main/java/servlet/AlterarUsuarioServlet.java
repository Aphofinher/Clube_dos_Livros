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


@WebServlet("/alterar-usuario")

public class AlterarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String confirmaSenha = req.getParameter("confirmaSenha");
        String redeSocial = req.getParameter("rede-social");

        if (senha.equals(confirmaSenha)) {

            Usuario usuario = new Usuario(nome, email, senha, redeSocial);
            new UsuarioDAO().alterarUsuario(usuario);
            preencheAtributosBase(req, email);

            req.setAttribute("confirma-alteração", "Usuario alterado com sucesso!");
        } else {
            req.setAttribute("erro-alteração", "As senhas não coincidem!");
            req.getRequestDispatcher("atualizar/atualizar.jsp");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String usuarioEmail = req.getSession().getAttribute("loggedUser").toString();
        Usuario usuario = new UsuarioDAO().buscarUsuario(usuarioEmail);
        req.setAttribute("usuario", usuario);

        req.getRequestDispatcher("atualizar/atualizar.jsp").forward(req, resp);
    }

    private void preencheAtributosBase(HttpServletRequest req, String email) {

        ArrayList<Comentario> comentarios = new ComentarioDAO().listarComentario(email);
        List<ComentarioTO> comentarioView = preencherTO(comentarios);
        req.setAttribute("comentarios", comentarioView);
    }

    private List<ComentarioTO> preencherTO(ArrayList<Comentario> comentarios) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<ComentarioTO> comentarioView = new ArrayList<>();
        List<Usuario> usuarios = usuarioDAO.buscarUsuarios();

        for (Comentario comentario : comentarios) {
            for (Usuario usuario : usuarios) {
                if (comentario.getEmail().equals(usuario.getEmail())) {
                    comentarioView.add(new ComentarioTO(usuario.getNome(), comentario.getComentario(), usuario.getRedeSocial(), comentario.getLivro()));
                }
            }
        }
        return comentarioView;
    }


}




