/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ResponsableMaintenance;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class ResponsableMaintenanceFacade extends AbstractFacade<ResponsableMaintenance> {

    @PersistenceContext(unitName = "gmaov2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResponsableMaintenanceFacade() {
        super(ResponsableMaintenance.class);
    }
    
}
