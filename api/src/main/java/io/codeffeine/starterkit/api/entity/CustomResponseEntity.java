/*
 * StarterKit.
 */
package io.codeffeine.starterkit.api.entity;

import org.springframework.http.HttpStatus;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class CustomResponseEntity {

    protected boolean result;
    protected String status;
    protected int statusCode;
    protected Object data;

    public void setResult(boolean result) {
        this.result = result;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode.value();
        this.status = statusCode.getReasonPhrase();
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return the result
     */
    public boolean isResult() {
        return result;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }
}
