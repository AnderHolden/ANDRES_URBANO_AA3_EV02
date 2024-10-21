<%-- 
    Document   : modificar
    Created on : 10/09/2024, 11:37:01 p. m.
    Author     : Holden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Datos</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Modificar Datos</h2>
    <form action="ModificarServlet" method="post">
        <!-- Campos para modificar los datos -->
        <label for="id_persona">ID Persona:</label>
        <input type="text" id="id_persona" name="id_persona" required><br><br>
        
        <label for="nombres">Nombres:</label>
        <input type="text" id="nombres" name="nombres"><br><br>
        
        <label for="apellidos">Apellidos:</label>
        <input type="text" id="apellidos" name="apellidos"><br><br>
        
        <!-- Agrega más campos según sea necesario -->
        
        <input type="submit" value="Modificar">
    </form>
</body>
</html>
