package com.tp.tpfinalejb.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Clients", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;

    public ClientEntity(String nom, String prenom, String adresse, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
    }

    public ClientEntity() {

    }

    @Override
    public String toString() {
        return "Client_Entity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ClientEntity setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public ClientEntity setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public ClientEntity setAdresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public ClientEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public ClientEntity setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }


    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

}
