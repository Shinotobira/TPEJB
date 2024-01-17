package com.tp.tpfinalejb.session;

import com.tp.tpfinalejb.entity.ClientEntity;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface GestionLocal {
    void modifierClient(ClientEntity newClient, int id);
    void ajouterClient(ClientEntity client);
    void supprimerClient(int id);

    List<ClientEntity> consulterClients();

    ClientEntity consulterClient(int id);
}
