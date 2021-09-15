<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Libros</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/estilos.css">
        <link rel="icon" type="image/jpeg" href="Icono/icon.jpeg" />
        <script src="JS/jquery-3.4.0.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="bootstrap/bootstrap-3.4.1-dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="principal">    
            <header class="encabezado">
                <h1>GOLIAT</h1>
            </header>
            <nav class="navegador">
                <ul class="nav nav-pills">
                    <li role="presentation" ><a href="index">Inicio</a></li>
                    <li role="presentation" ><a href="Libros">Libros</a></li>
                    <li role="presentation" ><a href="Mangas">Mangas</a></li>
                    <li role="presentation" ><a href="Comics">Comics</a></li> 
                    <li role="presentation" ><a href="Sesion">Inicio Sesion</a></li>
                </ul>
            </nav>
            <div style="text-align: center">
                <%String msg = (String) request.getAttribute("msg");%>
                <br><br><br><br>
                <h2><label>Inicio de Sesion</label></h2>
                <br><br>
                <form class="navbar-form" action="validar" method="post">
                    <input name="usuario" type="text" placeholder="Usuario" class="form-control" required autofocus><br><br>
                    <input name="password" type="password" placeholder="Contraseña" class="form-control" required ><br><br>
                    <label class="checkbox">
                        <%=msg != null ? msg : ""%>
                    </label>    
                    <br>
                    <input  type="submit" class="form-control">
                    <br>
                </form>
            </div>
            <a href="NuevoUser" class="btn btn-block">Crear Nuevo Usuario</a>
            <footer class="piePag">
                <label>@ 2019 - Derechos Reservados a Semillitas del Saber©</label>
            </footer>
        </div>
    </body>
</html>
