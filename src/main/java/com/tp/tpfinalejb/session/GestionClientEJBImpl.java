package com.tp.tpfinalejb.session;

import com.tp.tpfinalejb.entity.ClientEntity;
import jakarta.ejb.Singleton;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Singleton(name = "GestionClientEJBImpl")
public class GestionClientEJBImpl implements GestionLocal{
    static List<ClientEntity> listeClient = new ArrayList<>();
    @Override
    public void modifierClient(ClientEntity newClient, int id) {
        int indiceClient = -1;
        for (int i = 0; i < listeClient.size(); i++) {
            if (listeClient.get(i).getId() == id) {
                indiceClient = i;
                break;
            }
        }

        if(indiceClient != -1){
            listeClient.set(indiceClient, newClient);
        }
    }

    @Override
    public void ajouterClient(ClientEntity client) {
        listeClient.add(client);

    }

    @Override
    public void supprimerClient(ClientEntity client) {
        int indiceClient = -1;
        for (int i = 0; i < listeClient.size(); i++) {
            if (listeClient.get(i).getId() == client.getId()) {
                indiceClient = i;
                break;
            }
        }

        if (indiceClient != -1) {
            listeClient.remove(indiceClient);
        } else {
            throw new RuntimeException("Client introuvable");
        }

    }

    @Override
    public List<ClientEntity> consulterClients() {
        return listeClient;
    }

    @Override
    public ClientEntity consulterClient(int id) {
        int indiceClient = -1;
        for (int i = 0; i < listeClient.size(); i++) {
            if (listeClient.get(i).getId() == id) {
                indiceClient = i;
                break;
            }
        }
        if(indiceClient == -1){
            throw new RuntimeException("Client introuvable");
        }
        return listeClient.get(indiceClient);
    }


    static {
        listeClient.add(new ClientEntity("John", "Doe", "123 Main St", "john.doe@example.com", "555-1234"));
        listeClient.add(new ClientEntity("Jane", "Smith", "456 Oak St", "jane.smith@example.com", "555-5678"));

    }
}
