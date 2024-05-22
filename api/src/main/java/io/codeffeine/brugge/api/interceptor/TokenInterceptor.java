/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.api.interceptor;

import io.codeffeine.brugge.api.header.ResponseHeadersSetter;
import io.codeffeine.brugge.domain.security.entity.User;
import io.codeffeine.brugge.facade.container.ServiceContainer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
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
