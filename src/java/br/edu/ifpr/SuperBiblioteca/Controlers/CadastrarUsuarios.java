/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.edu.ifpr.SuperBiblioteca.Controlers;

import br.edu.ifpr.SuperBiblioteca.Entities.Usuarios;
import br.edu.ifpr.SuperBiblioteca.Models.UsuarioModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alquimista290
 */
public class CadastrarUsuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("WEB-INF/cadastro.jsp").
                forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String nome, username, senha, email;
            int idade;
            
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            senha = request.getParameter("senha");
            idade = Integer.parseInt(request.getParameter("idade"));
            username = request.getParameter("username");

            UsuarioModel model = new UsuarioModel();
            model.cadastrar(new Usuarios(nome, username, email, senha, idade));
            
            response.sendRedirect("Menu");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
