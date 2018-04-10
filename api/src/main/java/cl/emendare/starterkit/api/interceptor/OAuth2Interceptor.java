/*
 * StarterKit.
 */
package cl.emendare.starterkit.api.interceptor;

import cl.emendare.starterkit.api.header.ResponseHeadersSetter;
import cl.emendare.starterkit.domain.security.entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class OAuth2Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse response, Object o) throws Exception {
        response = ResponseHeadersSetter.setHeaders(response);
        User user = new User();
        user.setId(1);
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
