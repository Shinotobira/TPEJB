package com.tp.tpfinalejb;

import java.io.*;
import java.util.List;

import com.tp.tpfinalejb.entity.ClientEntity;
import com.tp.tpfinalejb.session.GestionLocal;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "clientServlet", value = "/")
public class ClientServlet extends HttpServlet {
    @EJB
    GestionLocal metier;
    public void init(){
        metier.ajouterClient(new ClientEntity("John", "Smith", "3 rue saint martin", "john.smith@example.com", "0617543608"));
        metier.ajouterClient(new ClientEntity("Jean", "Makenzi", "545 rue jean moulin", "jean.makenzi@example.com", "0751643525"));
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<ClientEntity> listeClient = metier.consulterClients();
        request.setAttribute("listeClient", listeClient);
        request.getRequestDispatcher("listClient.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            String action = request.getParameter("action");
            if (action.equals("deleteClient")) {
                String clientId = request.getParameter("clientId");
                if (clientId != null && !clientId.isEmpty()) {
                    metier.supprimerClient(Integer.parseInt(clientId));
                    response.sendRedirect("/TPFinalEJB-1.0-SNAPSHOT/");
                }
            }
        } catch (Exception e) {
        }
    }


    public void destroy() {}
}