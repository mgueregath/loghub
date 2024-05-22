/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.api.header;

import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class ResponseHeadersSetter {

    private ResponseHeadersSetter() {
        // Hiding constructor
    }

    public static HttpServletResponse setHeaders(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS, POST, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization, Client-Security-Token");
        response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate, max-age=0");

        return response;
    }
}
