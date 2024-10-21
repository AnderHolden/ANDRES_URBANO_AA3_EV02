/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.senapractica.disenasalud.RegistroServlet;

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
@WebServlet(name = "RegistroServidor", urlPatterns = {"/Registro"})
public class RegistroServidor extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Configurar la codificación de caracteres
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // Obtener los parámetros del formulario
        String idPersona = request.getParameter("id_persona");
        String identificacion = request.getParameter("identificacion");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String estadoCivil = request.getParameter("estado_civil");
        String direccion = request.getParameter("direccion");
        String fecNac = request.getParameter("fec_nac");
        String sexo = request.getParameter("sexo");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Conectar a la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diseñasalud", "root", "");

            // Insertar los datos en la tabla
            String query = "INSERT INTO 01personas (ID_persona, identificacion, nombres, apellidos, Estado_Civil, Direccion_Residencia, Fec_Nac, Sexo, Telefono, correo, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, idPersona);
            ps.setString(2, identificacion);
            ps.setString(3, nombres);
            ps.setString(4, apellidos);
            ps.setString(5, estadoCivil);
            ps.setString(6, direccion);
            ps.setString(7, fecNac);
            ps.setString(8, sexo);
            ps.setString(9, telefono);
            ps.setString(10, correo);
            ps.setString(11, contrasena);

            ps.executeUpdate();

            // Redirigir a la página de éxito
            response.sendRedirect("registro_exitoso.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error: No se encontró el driver de la base de datos.");
            request.setAttribute("errorMessage", "Error: No se encontró el driver de la base de datos.");
            request.getRequestDispatcher("registro_fallido.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error: Problema con la base de datos.");
            request.setAttribute("errorMessage", "Error: Problema con la base de datos.");
            request.getRequestDispatcher("registro_fallido.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: Ocurrió un problema inesperado.");
            request.setAttribute("errorMessage", "Error: Ocurrió un problema inesperado.");
            request.getRequestDispatcher("registro_fallido.jsp").forward(request, response);
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
