package security;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jsf.LoginController;

public class FiltroSeguridad implements Filter {

    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getParameterMap().containsKey(LoginController.LOGOUT_PARAM)) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Se elimina la variable de sesión");
            req.getSession().invalidate();
        }
        if ((req).getSession().getAttribute(
                LoginController.AUTH_KEY) == null) {
            ((HttpServletResponse) response).sendRedirect("../../index.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        config = null;
    }

}
