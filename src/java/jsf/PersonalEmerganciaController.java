package jsf;

import entities.PersonalEmergancia;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import entities.session.PersonalEmerganciaFacade;

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

@Named("personalEmerganciaController")
@SessionScoped
public class PersonalEmerganciaController implements Serializable {

    @EJB
    private entities.session.PersonalEmerganciaFacade ejbFacade;
    private List<PersonalEmergancia> items = null;
    private PersonalEmergancia selected;

    public PersonalEmerganciaController() {
    }

    public PersonalEmergancia getSelected() {
        return selected;
    }

    public void setSelected(PersonalEmergancia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PersonalEmerganciaFacade getFacade() {
        return ejbFacade;
    }

    public PersonalEmergancia prepareCreate() {
        selected = new PersonalEmergancia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("PersonalEmerganciaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("PersonalEmerganciaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("PersonalEmerganciaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PersonalEmergancia> getItems() {
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

    public PersonalEmergancia getPersonalEmergancia(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<PersonalEmergancia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PersonalEmergancia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PersonalEmergancia.class)
    public static class PersonalEmerganciaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PersonalEmerganciaController controller = (PersonalEmerganciaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personalEmerganciaController");
            return controller.getPersonalEmergancia(getKey(value));
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
            if (object instanceof PersonalEmergancia) {
                PersonalEmergancia o = (PersonalEmergancia) object;
                return getStringKey(o.getPeremeId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PersonalEmergancia.class.getName()});
                return null;
            }
        }

    }

}
