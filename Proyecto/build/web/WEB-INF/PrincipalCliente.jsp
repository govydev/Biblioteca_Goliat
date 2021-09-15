
<%@page import="biblioteca.bean.Genero"%>
<%@page import="biblioteca.bean.Categoria"%>
<%@page import="biblioteca.bean.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="biblioteca.bean.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-control", "must-revalidate");
    response.addHeader("Cache-control", "no-cache");
    response.addHeader("Cache-control", "no-store");
    response.setDateHeader("Expires", 0);
    try {
        if (session.getAttribute("cliente") == null) {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    } catch (Exception e) {
        request.getRequestDispatcher("Login.jsp").include(request, response);
    }

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/jpeg" href="Icono/icon.jpeg" />
        <link rel="stylesheet" href="bootstrap/bootstrap-3.4.1-dist/css/bootstrap.min.css">
        <script src="JS/jquery-3.4.0.min.js" type="text/javascript"></script>
        <title>Perfil</title>
        <script>
            //Confirmacion del envio de la sugerencia
            function Confirmar() {
                var mensaje = confirm("¿Desea enviar la sugerencia?");
                if (mensaje) {
                    alert("¡Gracias por Compartir tu Sugerencia con nostros!");
                }
            }
            $(function () {
                //AJAX
                //Lista de genero en busqueda profunda
                $.ajax({
                    url: 'GeneroServlet',
                    type: 'GET',
                    success: function (res) {
                        $("#listGen").html(res);
                    }
                });
                //Lista de autor en busqueda profunda
                $.ajax({
                    url: 'AutorServlet',
                    type: 'GET',
                    success: function (res) {
                        $("#listAut").html(res);
                    }
                });
                //Enviar el genero seleccionado para mostrar el resultado 
                $("#enviarO1").on("click", function () {
                    $.ajax({
                        url: 'MenuClienteServlet',
                        type: 'POST',
                        data: $('#opc1').serialize(),
                        success: function (datos) {
                            $("#libros").html(datos);
                        }
                    });
                });
                //Enviar el autor seleccionado para mostrar el resultado 
                $("#enviarO2").on("click", function () {
                    $.ajax({
                        url: 'MenuClienteServlet',
                        type: 'POST',
                        data: $('#opc2').serialize(),
                        success: function (datos) {
                            $("#libros").html(datos);
                        }
                    });
                });
                //Realiza la busqueda por el titulo
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
                //Realiza el envio de la sugerencia a la base de datos
                $("#enviarSugerencia").on("click", function () {
                    $.ajax({
                        url: 'SugerenciaServlet',
                        type: 'POST',
                        data: $('#sugerencia').serialize(),
                    })
                });
            });
        </script>
    </head>
    <body>
        <div class="principal">    
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
                    <li role="presentation" ><a href="Inicio.pe">Inicio</a></li>
                    <li role="presentation" ><a href="Libros.pe">Libros</a></li>
                    <li role="presentation" ><a href="Mangas.pe">Mangas</a></li>
                    <li role="presentation" ><a href="Comics.pe">Comics</a></li>
                    <li role="presentation" class="active"><a href="MiPerfil">Mi Perfil</a></li>
                    <li role="presentation" ><a href="Cerrar">Cerrar Sesion</a></li>
                </ul>
            </nav>
            <aside class="menu">
                <h2><label>Busqueda Profunda</label></h2><br>
                <label>Género :</label><br>
                <form id='opc1' method='post'>
                    <input type="text" value="gen" name="opc" hidden>
                    <select name="buspro" class="form-control" id="listGen">

                    </select><br>
                    <button type='button' class='btn btn-default' id='enviarO1'><label>Buscar por Género</label></button>
                </form>
                <br>
                <label>Autor :</label><br>
                <form id='opc2' method='post'>
                    <input type="text" value="aut" name="opc" hidden>
                    <select name="buspro" class="form-control" id="listAut">
                    </select><br>
                    <button type='button' class='btn btn-default' id='enviarO2'><label>Buscar por Autor</label></button>
                </form>
            </aside>
            <section class="productos">
                <div id="libros">
                    <%Cliente clnt = (Cliente) request.getSession().getAttribute("cliente");%>

                    <h1>-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*</h1>
                    <br>
                    <h2>Bienvenido  <%=clnt.getNombres() + " " + clnt.getApellidos()%>  a Goliat </h2>
                    <br><br>
                    <div class="usuario" style="text-align: left; margin: auto">
                        <h3>Nombres   :</h3><br>
                        <label><%=clnt.getNombres()%></label><br>
                        <h3>Apellidos :</h3><br>
                        <label><%=clnt.getApellidos()%></label><br>
                        <h3>Telefono  :</h3><br>
                        <label><%=clnt.getTelefono()%></label><br>
                        <h3>Correo    :</h3><br>
                        <label><%=clnt.getCorreo()%></label><br>
                    </div>
                    <br><br><br>
                    <div class="Area" align="center">
                        <form id="sugerencia" class="navbar-form navbar-left">
                            <h1>Sugerencia de libros</h1><br>
                            <textarea name="Sugerencia" placeholder="Ingrese sugerencia" style="width: 100%; height: 30%" class="form-control"></textarea><br><br>
                            <button id="enviarSugerencia" type="button" onclick="Confirmar()" class="btn btn-default">Enviar Sugerencia</button>
                        </form>
                    </div>
                </div>
            </section>
            <footer class="piePag">
                <label>@ 2019 - Derechos Reservados a Semillitas del Saber©</label>
            </footer>
        </div>
    </body>
</html>