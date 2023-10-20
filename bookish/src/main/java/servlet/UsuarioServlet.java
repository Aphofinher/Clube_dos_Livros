package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsuarioServlet {

    ;



        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            //List<> cars = new CarDao().findAllCars();

            //req.setAttribute("cars", cars);

            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

        }

    }

