package controler;

import bean.ResponsableMaintenance;
import controler.util.JsfUtil;
import controler.util.JsfUtil.PersistAction;
import service.ResponsableMaintenanceFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("responsableMaintenanceController")
@SessionScoped
public class ResponsableMaintenanceController implements Serializable {

    @EJB
    private service.ResponsableMaintenanceFacade ejbFacade;
    private List<ResponsableMaintenance> items = null;
    private ResponsableMaintenance selected;

    public ResponsableMaintenanceController() {
    }

    public ResponsableMaintenance getSelected() {
        return selected;
    }

    public void setSelected(ResponsableMaintenance selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ResponsableMaintenanceFacade getFacade() {
        return ejbFacade;
    }

    public ResponsableMaintenance prepareCreate() {
        selected = new ResponsableMaintenance();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ResponsableMaintenanceCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ResponsableMaintenanceUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ResponsableMaintenanceDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ResponsableMaintenance> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ResponsableMaintenance getResponsableMaintenance(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<ResponsableMaintenance> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ResponsableMaintenance> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ResponsableMaintenance.class)
    public static class ResponsableMaintenanceControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ResponsableMaintenanceController controller = (ResponsableMaintenanceController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "responsableMaintenanceController");
            return controller.getResponsableMaintenance(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ResponsableMaintenance) {
                ResponsableMaintenance o = (ResponsableMaintenance) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ResponsableMaintenance.class.getName()});
                return null;
            }
        }

    }

}
