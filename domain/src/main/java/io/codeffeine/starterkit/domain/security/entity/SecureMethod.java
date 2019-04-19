/*
 * StarterKit.
 */
package io.codeffeine.starterkit.domain.security.entity;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class SecureMethod {

    //private int id;
    private String name;
    private String detail;
    private Method method;

    public SecureMethod() {
    }

    public SecureMethod(String name, String detail, Method method) {
        this.name = name;
        this.detail = detail;
        this.method = method;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return the method
     */
    public Method getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(Method method) {
        this.method = method;
    }
}
