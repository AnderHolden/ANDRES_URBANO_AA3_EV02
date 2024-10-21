/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.senapractica.disenasalud.EliminarServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Holden
 */
@WebServlet(name = "EliminarServlet", urlPatterns = {"/EliminarServlet"})
public class EliminarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Configurar la codificación de caracteres
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Obtener los parámetros del formulario
        String idPersona = request.getParameter("id_persona");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Conectar a la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diseñasalud", "root", "");

            // Eliminar los datos en la tabla
            String query = "DELETE FROM 01personas WHERE ID_persona = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, idPersona);

            ps.executeUpdate();

            // Redirigir a la página de éxito
            response.sendRedirect("eliminar_exitoso.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error: No se encontró el driver de la base de datos.");
            request.setAttribute("errorMessage", "Error: No se encontró el driver de la base de datos.");
            request.getRequestDispatcher("eliminar_fallido.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error: Problema con la base de datos.");
            request.setAttribute("errorMessage", "Error: Problema con la base de datos.");
            request.getRequestDispatcher("eliminar_fallido.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: Ocurrió un problema inesperado.");
            request.setAttribute("errorMessage", "Error: Ocurrió un problema inesperado.");
            request.getRequestDispatcher("eliminar_fallido.jsp").forward(request, response);
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
