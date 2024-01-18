package com.tp.clientweb;

import com.tp.clientejb.entity.ClientEntity;
import com.tp.clientejb.session.GestionLocal;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "editClientServlet", value = "/editClient")
public class EditClientServlet extends HttpServlet {

    @EJB
    GestionLocal metier;

    ClientEntity clientToEdit;
    public void init(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        clientToEdit = metier.consulterClient(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("client", clientToEdit);
        request.getRequestDispatcher("editClient.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        ClientEntity client = new ClientEntity(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("adresse"), request.getParameter("email"), request.getParameter("telephone"));
        metier.modifierClient(client, clientToEdit.getId());
        response.sendRedirect("/clientWEB");
    }
    public void destroy() {}
}
