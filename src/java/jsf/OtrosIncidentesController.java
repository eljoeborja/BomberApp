package jsf;

import entities.OtrosIncidentes;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import entities.session.OtrosIncidentesFacade;

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

@Named("otrosIncidentesController")
@SessionScoped
public class OtrosIncidentesController implements Serializable {

    @EJB
    private entities.session.OtrosIncidentesFacade ejbFacade;
    private List<OtrosIncidentes> items = null;
    private OtrosIncidentes selected;

    public OtrosIncidentesController() {
    }

    public OtrosIncidentes getSelected() {
        return selected;
    }

    public void setSelected(OtrosIncidentes selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OtrosIncidentesFacade getFacade() {
        return ejbFacade;
    }

    public OtrosIncidentes prepareCreate() {
        selected = new OtrosIncidentes();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("OtrosIncidentesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("OtrosIncidentesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("OtrosIncidentesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<OtrosIncidentes> getItems() {
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public OtrosIncidentes getOtrosIncidentes(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<OtrosIncidentes> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<OtrosIncidentes> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = OtrosIncidentes.class)
    public static class OtrosIncidentesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OtrosIncidentesController controller = (OtrosIncidentesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "otrosIncidentesController");
            return controller.getOtrosIncidentes(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof OtrosIncidentes) {
                OtrosIncidentes o = (OtrosIncidentes) object;
                return getStringKey(o.getOtrId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OtrosIncidentes.class.getName()});
                return null;
            }
        }

    }

}
