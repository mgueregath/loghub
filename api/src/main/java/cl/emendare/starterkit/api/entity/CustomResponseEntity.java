/*
 * StarterKit.
 */
package cl.emendare.starterkit.api.entity;

import org.springframework.http.HttpStatus;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
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
