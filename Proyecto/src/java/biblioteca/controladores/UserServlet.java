package biblioteca.controladores;

import biblioteca.DAO.ClienteDAO;
import biblioteca.DAO.EmpleadoDAO;
import biblioteca.DAO.UsuarioCienteDAO;
import biblioteca.DAO.UsuarioEmpleadoDAO;
import biblioteca.bean.Cliente;
import biblioteca.bean.Empleado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet", "/validar", "/Registrar","/NuevoUser"})
public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getServletPath();
        //VALIDA LOS USUARIOS QUE INICIA SESION (USUARIO, ADMINISTRADOR)
        if (path.equals("/validar")) {
            String us = request.getParameter("usuario");
            String pa = request.getParameter("password");
            UsuarioCienteDAO user = new UsuarioCienteDAO();
            Cliente u = user.validarUsuario(us, pa);
            UsuarioEmpleadoDAO User = new UsuarioEmpleadoDAO();
            Empleado e = User.validarUsuario(us, pa);
            //Valida el iingreso del usuario y contraseña del usuario o cliente
            if (u == null) {
                //valida el ingreso del usuario y contraseña del empleado o administrador 
                if (e == null) {
                    request.setAttribute("msg", "Usuario y/o password incorrecto...");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                } else {
                    //Direcciona a la pagina principal del empleado
                    request.getSession().setAttribute("em", new EmpleadoDAO().buscarID(e.getIdempleado()));
                    request.getRequestDispatcher("WEB-INF/PrincipalEmpleado.jsp").forward(request, response);
                }
            } else {
                //Direcciona a la pagina principal del cliente
                request.getSession().setAttribute("cliente", new ClienteDAO().buscarID(u.getIdcliente()));
                request.getRequestDispatcher("WEB-INF/PrincipalCliente.jsp").forward(request, response);
            }
        }
        
        //REGISTRA A LOS NUEVOS CLIENTES O USUARIOS 
        if (path.equals("/Registrar")) {
            
            //Se crea el objeto cliente el cual se le otorga todos los datos
            Cliente cl = new Cliente();
            cl.setNombres(request.getParameter("nombre"));
            cl.setApellidos(request.getParameter("apellido"));
            cl.setTelefono(request.getParameter("telefono"));
            cl.setCorreo(request.getParameter("correo"));
            cl.setIdpais(Integer.parseInt(request.getParameter("pais")));
            cl.setUsuario(request.getParameter("usuario"));
            cl.setPass(request.getParameter("pass"));
            cl.setEstado(1);
            //Se aplica la funcion para registrar al nuevo cliente
            new ClienteDAO().agregar(cl);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        if(path.equals("/NuevoUser")){
            request.getRequestDispatcher("NuevoUsuario.jsp").forward(request, response);
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
