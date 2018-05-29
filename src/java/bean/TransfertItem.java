/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.Salle;
import bean.Transfert;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
@Entity
public class TransfertItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantite;
    private int numeroSerie;
    private String observation;
    @ManyToOne
    private Equipement Equipement;
    @ManyToOne
    private Salle salleSource;
    @ManyToOne
    private Salle salleDestination;
    @ManyToOne
    private Transfert transfert;

    public Salle getSalleSource() {
        return salleSource;
    }

    public void setSalleSource(Salle salleSource) {
        this.salleSource = salleSource;
    }

    public Salle getSalleDestination() {
        return salleDestination;
    }

    public void setSalleDestination(Salle salleDestination) {
        this.salleDestination = salleDestination;
    }

    public Transfert getTransfert() {
        return transfert;
    }

    public void setTransfert(Transfert transfert) {
        this.transfert = transfert;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Equipement getEquipement() {
        return Equipement;
    }

    public void setEquipement(Equipement Equipement) {
        this.Equipement = Equipement;
    }

    public TransfertItem() {
    }

    public TransfertItem(Long id) {
        this.id = id;
    }

    public TransfertItem(Long id, int quantite, int numeroSerie) {
        this.id = id;
        this.quantite = quantite;
        this.numeroSerie = numeroSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransfertItem)) {
            return false;
        }
        TransfertItem other = (TransfertItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SortieItem{" + "id=" + id + ", quantite=" + quantite + ", numeroSerie=" + numeroSerie + '}';
    }

}
