
<%@page import="java.util.ArrayList"%>
<%@page import="empleado.bean.Sugerencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sugerencia</title>
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/jpeg" href="Icono/icon.jpeg" />
        <link rel="stylesheet" href="bootstrap/bootstrap-3.4.1-dist/css/bootstrap.min.css">
        <script src="JS/jquery-3.4.0.min.js" type="text/javascript"></script>
        <script>
            $(function () {
                //AJAX
                //Busqueda de libro por titulo
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
                    <li role="presentation" ><a href="MiPerfilEmp">Mi Perfil</a></li>
                    <li role="presentation" ><a href="Cerrar">Cerrar Sesion</a></li>
                </ul>
            </nav>
            <aside class="menu">
                <label><h2>Listados</h2></label><br>
                <a href="ListarLibro" class='btn btn-default' >Libros</a><br><br>
                <a href="ListarCliente" class='btn btn-default'>Cliente</a><br><br>
                <a href="ListarEditorial" class='btn btn-default'>Editorial</a><br><br>
                <a href="ListarGenero" class='btn btn-default'>G??nero</a><br><br>
                <a href="ListarPais" class='btn btn-default'>Pa??s</a><br><br>
                <a href="ListarAutor" class='btn btn-default active'>Autor</a><br><br>
                <a href="ListarCategoria" class='btn btn-default'>Categoria</a><br><br>
                <a href="ListarSug" class='btn btn-default'>Sugerencia</a><br><br>
            </aside>
            <section class="productos">
                <div id="libros">
                    <h1>Lista de Sugerencia</h1>
                    <% ArrayList<Sugerencia> lista = (ArrayList<Sugerencia>) request.getAttribute("lista"); %>
                    <table class="table table-responsive">
                        <tr>
                            <td style="width: 10%">ID</td>
                            <td>Sugerencia</td>
                        </tr>
                        <% for (Sugerencia x : lista) {%>
                        <tr>
                            <td><%=x.getIdsugerencia()%></td>
                            <td><%=x.getSugerencia()%></td>
                        </tr>
                        <%}%>
                    </table>
                </div>
            </section>
            <footer class="piePag">
                <label>@ 2019 - Derechos Reservados a Semillitas del Saber??</label>
            </footer>
        </div>
    </body>
</html>