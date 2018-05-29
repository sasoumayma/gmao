/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class MaintenanceItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateMaintenance;
    @ManyToOne
    private Equipement equipement;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateDebutTravaux;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFinTravaux;
    private String observation;
    @ManyToOne
    private ResponsableMaintenance responsableMaintenance;

    public ResponsableMaintenance getResponsableMaintenance() {
        return responsableMaintenance;
    }

    public void setResponsableMaintenance(ResponsableMaintenance responsableMaintenance) {
        this.responsableMaintenance = responsableMaintenance;
    }

    public MaintenanceItem() {
    }

    public MaintenanceItem(Long id) {
        this.id = id;
    }

    public MaintenanceItem(Long id, String description, Date dateMaintenance, Date dateDebutTravaux, Date dateFinTravaux, String observation) {
        this.id = id;
        this.description = description;
        this.dateMaintenance = dateMaintenance;
        this.dateDebutTravaux = dateDebutTravaux;
        this.dateFinTravaux = dateFinTravaux;
        this.observation = observation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateMaintenance() {
        return dateMaintenance;
    }

    public void setDateMaintenance(Date dateMaintenance) {
        this.dateMaintenance = dateMaintenance;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Date getDateDebutTravaux() {
        return dateDebutTravaux;
    }

    public void setDateDebutTravaux(Date dateDebutTravaux) {
        this.dateDebutTravaux = dateDebutTravaux;
    }

    public Date getDateFinTravaux() {
        return dateFinTravaux;
    }

    public void setDateFinTravaux(Date dateFinTravaux) {
        this.dateFinTravaux = dateFinTravaux;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
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
        if (!(object instanceof MaintenanceItem)) {
            return false;
        }
        MaintenanceItem other = (MaintenanceItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaintenanceItem{" + "id=" + id + ", description=" + description + ", dateMaintenance=" + dateMaintenance + ", dateDebutTravaux=" + dateDebutTravaux + ", dateFinTravaux=" + dateFinTravaux + ", observation=" + observation + '}';
    }

}
