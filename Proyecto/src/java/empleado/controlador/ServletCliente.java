package empleado.controlador;

import empleado.bean.Cliente;
import empleado.dao.ClienteDao;
import empleado.dao.PaisDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente", "/ListarCliente", "/EliminarCliente", "/EditarCliente", "/GrabarCliente", "/NuevoCliente"})
public class ServletCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //REDIRECCIONAR PARA EDITAR, AGREGAR, ELIMINAR Y LISTAR CLIENTES
        String Path = request.getServletPath();
        if (Path.equals("/ListarCliente")) {
            request.setAttribute("lista", new ClienteDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/listarCliente.jsp").forward(request, response);
        }
        if (Path.equals("/EditarCliente")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("c", new ClienteDao().buscar(id));
            request.setAttribute("pa", new PaisDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/formCliente.jsp").forward(request, response);
        }
        if (Path.equals("/GrabarCliente")) {
            String id = request.getParameter("id");
            Cliente cliente = new Cliente();
            cliente.setNombres(request.getParameter("n"));
            cliente.setApellidos(request.getParameter("a"));
            cliente.setCorreo(request.getParameter("c"));
            cliente.setEstado(Integer.parseInt(request.getParameter("e")));
            cliente.setIdpais(Integer.parseInt(request.getParameter("idp")));
            cliente.setTelefono(request.getParameter("t"));
            cliente.setUsuario(request.getParameter("u"));
            if (id != "") {
                cliente.setIdcliente(Integer.parseInt(id));
                new ClienteDao().modificar(cliente);
            } else {
                new ClienteDao().agregar(cliente);
            }
            response.sendRedirect("ListarCliente");
        }
        if (Path.equals("/EliminarCliente")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new ClienteDao().eliminar(id);
            response.sendRedirect("ListarCliente");
        }
        if (Path.equals("/NuevoCliente")) {
            request.setAttribute("pa", new PaisDao().listar());
            request.getRequestDispatcher("WEB-INF/Administrador/formCliente.jsp").forward(request, response);
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
