/*
 * StarterKit.
 */
package cl.emendare.starterkit.api.interceptor;

import cl.emendare.starterkit.api.header.ResponseHeadersSetter;
import cl.emendare.starterkit.domain.security.entity.User;
import cl.emendare.starterkit.facade.container.ServiceContainer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class TokenInterceptor implements HandlerInterceptor {

    private ServiceContainer sc;

    public TokenInterceptor(ServiceContainer sc) {
        this.sc = sc;
    }

    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse response, Object o) throws Exception {
        response = ResponseHeadersSetter.setHeaders(response);
        if (hsr.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true;
        }

        String token = hsr.getHeader("Authorization");
        User user = (User) sc.getAuthenticationService().validateToken(token);
        hsr.setAttribute("user", user);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {
        // Do nothing
    }

    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
        // Do nothing
    }
}
