<%@page import="biblioteca.bean.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<%
    response.addHeader("Cache-control", "must-revalidate");
    response.addHeader("Cache-control", "no-cache");
    response.addHeader("Cache-control", "no-store");
    response.setDateHeader("Expires", 0);
    try {
        if (session.getAttribute("em") == null) {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    } catch (Exception e) {
        request.getRequestDispatcher("index.jsp").include(request, response);
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/jpeg" href="Icono/icon.jpeg" />
        <link rel="stylesheet" href="bootstrap/bootstrap-3.4.1-dist/css/bootstrap.min.css">
        <script src="JS/jquery-3.4.0.min.js" type="text/javascript"></script>
        <script>
            $(function () {
                $("#bus").on("keyup", function () {
                    $.ajax({
                        url: 'BusquedaServlet',
                        type: 'POST',
                        data: $('#Buscar').serialize(),
                        success: function (datos) {
                            $("#libros").html(datos);
                        }
                    });
                });
            });
        </script>
    </head>
    <body><div class="principal">    
            <header class="encabezado">
                <h1>GOLIAT</h1>
            </header>
            <nav class="navegador">
                <ul class="nav nav-pills">
                    <li role="presentation" >
                        <form id="Buscar" method="post" class="navbar-form navbar-left">
                            <input type="text" name="busqueda" placeholder="Buscar de libro" class="form-control" id="bus">
                        </form>
                    </li>
                    <li role="presentation" class="active"><a href="MiPerfilEmp">Mi Perfil</a></li>
                    <li role="presentation" ><a href="Cerrar">Cerrar Sesion</a></li>
                </ul>
            </nav>
            <aside class="menu">
                <a href="ListarLibro" class='btn btn-default' >Listar libros</a><br><br>
                <a href="ListarCliente" class='btn btn-default'>Listar cliente</a><br><br>
                <a href="ListarEditorial" class='btn btn-default'>Listar editorial</a><br><br>
                <a href="ListarGenero" class='btn btn-default'>Listar género</a><br><br>
                <a href="ListarPais" class='btn btn-default'>Listar país</a><br><br>
                <a href="ListarAutor" class='btn btn-default'>Listar autor</a><br><br>
                <a href="ListarCategoria" class='btn btn-default'>Listar categoria</a><br><br>
                <a href="ListarSug" class='btn btn-default'>Listar Sugerencia</a><br><br>
            </aside>
            <section class="productos">
                <div id="libros">
                    <%Empleado em = (Empleado) request.getSession().getAttribute("em");%>
                    <h1>-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*</h1>
                    <br>
                    <h2>Bienvenido  <%=em.getNombres() + " " + em.getApellidos()%>  a Goliat </h2>
                    <br><br>
                    <div class="usuario" style="text-align: left; margin: auto">
                        <h3>Nombres   :</h3><br>
                        <label><%=em.getNombres()%></label><br>
                        <h3>Apellidos :</h3><br>
                        <label><%=em.getApellidos()%></label><br>
                        <h3>Telefono  :</h3><br>
                        <label><%=em.getTelefono()%></label><br>
                        <h3>Correo    :</h3><br>
                        <label><%=em.getCorreo()%></label><br>
                    </div>
                    <br><br><br>
                </div>
            </section>
            <footer class="piePag">
                <label>@ 2019 - Derechos Reservados a Semillitas del Saber©</label>
            </footer>
        </div>
    </body>
</html>
