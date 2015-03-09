package jsf;

import entities.Emergencia;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import entities.session.EmergenciaFacade;
import java.io.File;
import java.io.IOException;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import jsf.util.ClaseInmueble;
import jsf.util.TipoMedioInformacion;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "emergenciaController")
@SessionScoped
public class EmergenciaController implements Serializable {

    @EJB
    private entities.session.EmergenciaFacade ejbFacade;
    private List<Emergencia> items = null;
    private Emergencia selected;

    public EmergenciaController() {
    }

    public Emergencia getSelected() {
        return selected;
    }

    public void setSelected(Emergencia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EmergenciaFacade getFacade() {
        return ejbFacade;
    }

    public Emergencia prepareCreate() {
        selected = new Emergencia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/resources/Bundle").getString("EmergenciaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/resources/Bundle").getString("EmergenciaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/resources/Bundle").getString("EmergenciaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Emergencia> getItems() {
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

    public Emergencia getEmergencia(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Emergencia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Emergencia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Emergencia.class)
    public static class EmergenciaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmergenciaController controller = (EmergenciaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "emergenciaController");
            return controller.getEmergencia(getKey(value));
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
            if (object instanceof Emergencia) {
                Emergencia o = (Emergencia) object;
                return getStringKey(o.getEmeId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Emergencia.class.getName()});
                return null;
            }
        }

    }

    public TipoMedioInformacion[] getMapaTipos() {
        return TipoMedioInformacion.values();
    }

    public String getTipoMedioInformacion(int value) {
        return TipoMedioInformacion.getFromValue(value).toString();
    }

    public ClaseInmueble[] getMapaClaseInmueble() {
        return ClaseInmueble.values();
    }

    public String getClaseInmueble(int value) {
        return ClaseInmueble.getFromValue(value).toString();
    }

    public Date minYear() {
        Calendar fechaMinima = Calendar.getInstance();
        fechaMinima.set(1900, 01, 01);
        return fechaMinima.getTime();
    }

    public void verPDF(ActionEvent actionEvent) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        try {

            ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            String ruta = context.getRealPath("/resources/reportes/reporte.jasper");

            File jasper = new File(ruta);

            byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(this.getItems()));
            HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);

            try (ServletOutputStream outStream = response.getOutputStream()) {
                outStream.write(bytes, 0, bytes.length);
            }

            facesContext.responseComplete();
        } catch (JRException | IOException e) {
            e.printStackTrace();
        }
    }

}
