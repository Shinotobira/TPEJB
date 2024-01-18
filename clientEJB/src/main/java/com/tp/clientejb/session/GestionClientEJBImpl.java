package com.tp.clientejb.session;

import com.tp.clientejb.entity.ClientEntity;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

@Singleton(name = "GestionClientEJBImpl")
public class GestionClientEJBImpl implements GestionLocal{
    @PersistenceContext(unitName = "ClientPersistent")
    private EntityManager entityManager;

    @Override
    public void modifierClient(ClientEntity newClient, int id) {
        ClientEntity client = consulterClient(id);
        client.setNom(newClient.getNom());
        client.setPrenom(newClient.getPrenom());
        client.setAdresse(newClient.getAdresse());
        client.setEmail(newClient.getEmail());
        client.setTelephone(newClient.getTelephone());
        entityManager.merge(client);
    }

    @Override
    public void ajouterClient(ClientEntity client) {
        entityManager.persist(client);
    }

    @Override
    public void supprimerClient(int id) {
        entityManager.remove(consulterClient(id));
    }

    @Override
    public List<ClientEntity> consulterClients() {
        Query requete = entityManager.createQuery("SELECT c FROM ClientEntity c");
        return requete.getResultList();
    }

    @Override
    public ClientEntity consulterClient(int id) {
        ClientEntity client = entityManager.find(ClientEntity.class, id);
        if(client == null)
            throw new RuntimeException("Le Client inexistant");
        return client;
    }
}
