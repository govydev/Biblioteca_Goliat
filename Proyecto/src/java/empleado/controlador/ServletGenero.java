package empleado.controlador;

import empleado.bean.Genero;
import empleado.dao.CategoriaDao;
import empleado.dao.GeneroDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletGenero", urlPatterns = {"/ServletGenero", "/ListarGenero", "/EditarGenero", "/GrabarGenero", "/EliminarGenero","/NewGenero"})
public class ServletGenero extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Path = request.getServletPath();
        //REDIRECCIONAR PARA EDITAR, AGREGAR, ELIMINAR Y LISTAR GENERO
        if (Path.equals("/ListarGenero")) {
            request.setAttribute("lista", new GeneroDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/listarGenero.jsp").forward(request, response);
        }
        if (Path.equals("/EditarGenero")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("g", new GeneroDao().buscar(id));
            request.setAttribute("Cat", new CategoriaDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/formGenero.jsp").forward(request, response);
        }
        if (Path.equals("/NewGenero")) {
            request.setAttribute("Cat", new CategoriaDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/formGenero.jsp").forward(request, response);
        }
        if (Path.equals("/GrabarGenero")) {
            String id = request.getParameter("id");
            Genero genero = new Genero();
            genero.setGenero(request.getParameter("g"));
            genero.setIdcategoria(Integer.parseInt(request.getParameter("idg")));
            if (id != "") {
                genero.setIdgenero(Integer.parseInt(id));
                new GeneroDao().modificar(genero);
            } else {
                new GeneroDao().agregar(genero);
            }
            response.sendRedirect("ListarGenero");
        }
        if (Path.equals("/EliminarGenero")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new GeneroDao().eliminar(id);
            response.sendRedirect("ListarGenero");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
