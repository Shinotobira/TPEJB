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

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<ClientEntity> listeClient = metier.consulterClients();
        request.setAttribute("listeClient", listeClient);
        request.getRequestDispatcher("listClient.jsp").forward(request, response);
    }

    public void destroy() {}
}