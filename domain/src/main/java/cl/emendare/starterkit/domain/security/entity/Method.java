/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.security.entity;

import java.io.Serializable;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class Method implements Serializable {

    private int service;
    private int method;

    public Method() {
    }

    public Method(int service, int method) {
        this.service = service;
        this.method = method;
    }

    /**
     * @return the service
     */
    public int getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(int service) {
        this.service = service;
    }

    /**
     * @return the method
     */
    public int getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(int method) {
        this.method = method;
    }
}
