/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
public class Sortie implements Serializable {

    @OneToMany(mappedBy = "sortie")
    private List<SortieItem> sortieItems;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSortie;
    private Double nombreTotal;
    @ManyToOne
    private Fournisseur fournisseur;

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

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<SortieItem> getSortieItems() {
        return sortieItems;
    }

    public void setSortieItems(List<SortieItem> sortieItems) {
        this.sortieItems = sortieItems;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Double getNombreTotal() {
        return nombreTotal;
    }

    public void setNombreTotal(Double nombreTotal) {
        this.nombreTotal = nombreTotal;
    }

    public Sortie() {
    }

    public Sortie(Long id) {
        this.id = id;
    }

    public Sortie(Long id, Date dateSortie, Double nombreTotal) {
        this.id = id;
        this.dateSortie = dateSortie;
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
        if (!(object instanceof Sortie)) {
            return false;
        }
        Sortie other = (Sortie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sortie{" + "id=" + id + ", dateSortie=" + dateSortie + ", nombreTotal=" + nombreTotal + '}';
    }

    

}
