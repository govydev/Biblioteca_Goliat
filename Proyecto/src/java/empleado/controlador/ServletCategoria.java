package empleado.controlador;

import empleado.bean.Categoria;
import empleado.dao.CategoriaDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCategoria", urlPatterns = {"/ServletCategoria", "/AgregarCategoria",
    "/ListarCategoria", "/EditarCategoria", "/GrabarCategoria", "/EliminarCategoria", "/NuevaCategoria"})
public class ServletCategoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Path = request.getServletPath();
        //REDIRECCIONAR PARA EDITAR, AGREGAR, ELIMINAR Y LISTAR CATEGORIA
        if (Path.equals("/AgregarCategoria")) {
            request.setAttribute("l", new Categoria());
            request.getRequestDispatcher("WEB-INF/Administrador/formCategoria.jsp").forward(request, response);
        }
        if (Path.equals("/ListarCategoria")) {
            request.setAttribute("lista", new CategoriaDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/listarCategoria.jsp").forward(request, response);
        }
        if (Path.equals("/EditarCategoria")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("p", new CategoriaDao().buscar(id));
            request.getRequestDispatcher("WEB-INF/Administrador/formCategoria.jsp").forward(request, response);
        }
        if (Path.equals("/GrabarCategoria")) {
            String id = request.getParameter("id");
            Categoria categoria = new Categoria();
            categoria.setCategoria(request.getParameter("p"));
            if (id != "") {
                categoria.setIdcategoria(Integer.parseInt(id));
                new CategoriaDao().modificar(categoria);
            } else {
                new CategoriaDao().agregar(categoria);
            }
            response.sendRedirect("ListarCategoria");
        }
        if (Path.equals("/EliminarCategoria")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new CategoriaDao().eliminar(id);
            response.sendRedirect("ListarCategoria");
        }
        if (Path.equals("/NuevaCategoria")) {
            request.getRequestDispatcher("WEB-INF/Administrador/formCategoria.jsp").forward(request, response);
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
