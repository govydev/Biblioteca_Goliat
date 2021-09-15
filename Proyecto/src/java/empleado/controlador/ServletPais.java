package empleado.controlador;

import empleado.bean.Pais;
import empleado.dao.PaisDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletPais", urlPatterns = {"/ServletPais", "/AgregarPais", "/ListarPais", "/EditarPais", "/GrabarPais", "/EliminarPais", "/NuevoPais"})
public class ServletPais extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Path = request.getServletPath();
        //REDIRECCIONAR PARA EDITAR, AGREGAR, ELIMINAR Y LISTAR PAIS
        if (Path.equals("/AgregarPais")) {
            request.setAttribute("l", new Pais());
            request.getRequestDispatcher("WEB-INF/Administrador/formPais.jsp").forward(request, response);
        }
        if (Path.equals("/ListarPais")) {
            request.setAttribute("lista", new PaisDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/listarPais.jsp").forward(request, response);
        }
        if (Path.equals("/EditarPais")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("p", new PaisDao().buscar(id));
            request.getRequestDispatcher("WEB-INF/Administrador/formPais.jsp").forward(request, response);
        }
        if (Path.equals("/GrabarPais")) {
            String id = request.getParameter("id");
            Pais pais = new Pais();
            pais.setPais(request.getParameter("p"));
            if (id != "") {
                pais.setIdpais(Integer.parseInt(id));
                new PaisDao().modificar(pais);
            } else {
                new PaisDao().agregar(pais);
            }
            response.sendRedirect("ListarPais");
        }
        if (Path.equals("/EliminarPais")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new PaisDao().eliminar(id);
            response.sendRedirect("ListarPais");
        }
        if (Path.equals("/NuevoPais")) {
            request.getRequestDispatcher("WEB-INF/Administrador/formPais.jsp").forward(request, response);
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
