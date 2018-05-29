/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.EntreeItem;
import bean.EntreeItem;
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
 * @author user
 */
@Entity
public class Entree implements Serializable {

    @OneToMany(mappedBy = "entree")
    private List<EntreeItem> entreeItems;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEntree;
    private Double nombreTotal;
    @ManyToOne
    private Fournisseur founisseur;
    @ManyToOne
    private Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EntreeItem> getEntreeItems() {
        return entreeItems;
    }

    public void setEntreeItems(List<EntreeItem> entreeItems) {
        this.entreeItems = entreeItems;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Double getNombreTotal() {
        return nombreTotal;
    }

    public void setNombreTotal(Double nombreTotal) {
        this.nombreTotal = nombreTotal;
    }

    public Fournisseur getFounisseur() {
        return founisseur;
    }

    public void setFounisseur(Fournisseur founisseur) {
        this.founisseur = founisseur;
    }
    

    public Entree() {
    }

    public Entree(Long id) {
        this.id = id;
    }

    public Entree(Long id, Date dateEntree, Double nombreTotal) {
        this.id = id;
        this.dateEntree = dateEntree;
        this.nombreTotal = nombreTotal;
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
        if (!(object instanceof Entree)) {
            return false;
        }
        Entree other = (Entree) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entree{" + "id=" + id + ", dateEntree=" + dateEntree + ", nombreTotal=" + nombreTotal + '}';
    }

   

}
