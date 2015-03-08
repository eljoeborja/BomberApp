package jsf;

import entities.IncendioEstructural;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import entities.session.IncendioEstructuralFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("incendioEstructuralController")
@RequestScoped
public class IncendioEstructuralController implements Serializable {

    @EJB
    private entities.session.IncendioEstructuralFacade ejbFacade;
    private List<IncendioEstructural> items = null;
    private IncendioEstructural selected;

    public IncendioEstructuralController() {
    }

    public IncendioEstructural getSelected() {
        return selected;
    }

    public void setSelected(IncendioEstructural selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private IncendioEstructuralFacade getFacade() {
        return ejbFacade;
    }

    public IncendioEstructural prepareCreate() {
        selected = new IncendioEstructural();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("IncendioEstructuralCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("IncendioEstructuralUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("IncendioEstructuralDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<IncendioEstructural> getItems() {
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

    public IncendioEstructural getIncendioEstructural(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<IncendioEstructural> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<IncendioEstructural> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = IncendioEstructural.class)
    public static class IncendioEstructuralControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            IncendioEstructuralController controller = (IncendioEstructuralController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "incendioEstructuralController");
            return controller.getIncendioEstructural(getKey(value));
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
            if (object instanceof IncendioEstructural) {
                IncendioEstructural o = (IncendioEstructural) object;
                return getStringKey(o.getInceId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), IncendioEstructural.class.getName()});
                return null;
            }
        }

    }

}
