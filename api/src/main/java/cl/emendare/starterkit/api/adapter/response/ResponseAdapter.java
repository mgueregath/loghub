/*
 * StarterKit.
 */
package cl.emendare.starterkit.api.adapter.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface ResponseAdapter {

    public ResponseEntity send(boolean result, HttpStatus code, Object data);

    public ResponseEntity send(boolean result, HttpStatus code);
}
