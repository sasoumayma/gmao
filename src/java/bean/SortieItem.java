/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.Salle;
import bean.Sortie;
import com.sun.org.apache.xpath.internal.FoundIndex;
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
public class SortieItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     @ManyToOne
    private Equipement Equipement;
    private int numeroSerie;
    private int quantite;
    private int quantiteMinimale;
    private String observation;
    @ManyToOne
    private Salle salle;
    @ManyToOne
    private Sortie sortie;
    @ManyToOne // ManyToOne uni
    private Magasin magasin;

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
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

    public Sortie getSortie() {
        return sortie;
    }

    public void setSortie(Sortie sortie) {
        this.sortie = sortie;
    }

    public int getQuantiteMinimale() {
        return quantiteMinimale;
    }

    public void setQuantiteMinimale(int quantiteMinimale) {
        this.quantiteMinimale = quantiteMinimale;
    }
    
    
    public SortieItem() {
    }

    public SortieItem(Long id) {
        this.id = id;
    }

    public SortieItem(Long id, int numeroSerie, int quantite, int quantiteMinimale, String observation) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.quantite = quantite;
        this.quantiteMinimale = quantiteMinimale;
        this.observation = observation;
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
        if (!(object instanceof SortieItem)) {
            return false;
        }
        SortieItem other = (SortieItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SortieItem{" + "id=" + id + ", numeroSerie=" + numeroSerie + ", quantite=" + quantite + ", quantiteMinimale=" + quantiteMinimale + ", observation=" + observation + '}';
    }

   

}
