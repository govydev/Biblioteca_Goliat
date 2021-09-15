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
        <script>
            //Funcion que confirma las contraseñas
            function validar() {
                var pass1 = formx.pass.value;
                var pass2 = formx.pass2.value;

                if (pass1 === pass2) {
                    return true;
                }
                alert("Las Contraseñas no son iguales ... ");
                return false;
            }
            //AJAX
            //Lista de los paises en el formulario
            $.ajax({
                url: 'PaisServlet',
                type: 'GET',
                success: function (res) {
                    $("#listPais").html(res);
                }
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
                    <li role="presentation" ><a href="index">Inicio</a></li>
                    <li role="presentation" ><a href="Libros">Libros</a></li>
                    <li role="presentation" ><a href="Mangas">Mangas</a></li>
                    <li role="presentation" ><a href="Comics">Comics</a></li> 
                    <li role="presentation" ><a href="Sesion">Inicio Sesion</a></li>
                </ul>
            </nav>
            <div style="text-align: center">
                <h2><label>Registrar Nuevo Usuario</label></h2>
                <br>
                <form name="formx" class="navbar-form" method="post" action="Registrar">
                    <input name="nombre" type="text" placeholder="Nombres" class="form-control" required autofocus><br><br>
                    <input name="apellido" type="text" placeholder="Apellidos" class="form-control" required><br><br>
                    <input name="correo" type="text" placeholder="Correo" class="form-control" required><br><br>
                    Pais :   <select name="pais" id="listPais" class="form-control"></select><br><br>
                    <input name="telefono" type="text" placeholder="Telefono" class="form-control" required><br><br>
                    <input name="usuario" type="text" placeholder="Usuario" class="form-control" required><br><br>
                    <input name="pass" type="password" placeholder="Contraseña" class="form-control" required><br><br>
                    <input name="pass2" type="password" placeholder="Confirme Contraseña" class="form-control" required><br><br>
                    <br>
                    <input type="submit" value="Registrar" class="form-control" onclick="return validar()">
                </form>
            </div>
            <footer class="piePag">
                <label>@ 2019 - Derechos Reservados a Semillitas del Saber©</label>
            </footer>
        </div>
    </body>
</html>
