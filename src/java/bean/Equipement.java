/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.Fournisseur;
import bean.Fournisseur;
import bean.Utilisateur;
import bean.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class Equipement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String designation;
    private String type;
    private String emplacement;
    private String affectation;
    private String marque;
    @ManyToOne
    private Fournisseur fournisseur;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateMiseEnService;
    private String details;
    private String description;
    private String observation;
    @ManyToOne
    private Utilisateur utilisateur;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Equipement() {
    }

    public Equipement(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getAffectation() {
        return affectation;
    }

    public void setAffectation(String affectation) {
        this.affectation = affectation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    

    public Equipement(Long id, String designation, String type, String emplacement, String affectation, String marque, Date dateMiseEnService, String details, String description, String observation) {
        this.id = id;
        this.designation = designation;
        this.type = type;
        this.emplacement = emplacement;
        this.affectation = affectation;
        this.marque = marque;
        this.dateMiseEnService = dateMiseEnService;
        this.details = details;
        this.description = description;
        this.observation = observation;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Equipement)) {
            return false;
        }
        Equipement other = (Equipement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipement{" + "id=" + id + ", designation=" + designation + ", type=" + type + ", emplacement=" + emplacement + ", affectation=" + affectation + ", marque=" + marque + ", dateMiseEnService=" + dateMiseEnService + ", details=" + details + ", description=" + description + ", observation=" + observation + '}';
    }

   

}
