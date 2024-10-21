<%-- 
    Document   : eliminar
    Created on : 11/09/2024, 9:47:27 a. m.
    Author     : Holden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Datos</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Eliminar Datos</h2>
    <form action="EliminarServlet" method="post">
        <label for="id_persona">ID Persona:</label>
        <input type="text" id="id_persona" name="id_persona" required><br><br>
        
        <input type="submit" value="Eliminar">
    </form>
</body>
</html>
