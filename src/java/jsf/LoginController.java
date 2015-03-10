package jsf;

import entities.Usuario;
import entities.session.UsuarioFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import jsf.util.JsfUtil;

@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    public static final String AUTH_KEY = "r2r.usuario";
    public static final String LOGOUT_PARAM = "logout";

    @EJB
    private UsuarioFacade ejbFacade;

    private Usuario user;

    private String userName;
    private String password;

    public LoginController() {
    }

    public Usuario getUser() {
        if (user == null && FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get(AUTH_KEY) != null) {
            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().get(AUTH_KEY);
        }
        return user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public void login() {
        try {
            user = getFacade().login(userName, password);
            if (user != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY, user);
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("LoginSuccess"));
            } else {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(AUTH_KEY);
                JsfUtil.addWarnMessage(ResourceBundle.getBundle("/resources/Bundle").getString("LoginFailedMessage"));
            }
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
        }

    }

    public void logoutLink() {

        String url = ((HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest()).getContextPath()
                .concat("/faces/content/content/?").concat(LOGOUT_PARAM);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex, "Error...");
        }
    }

}
