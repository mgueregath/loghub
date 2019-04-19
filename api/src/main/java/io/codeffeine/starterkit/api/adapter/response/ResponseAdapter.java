/*
 * StarterKit.
 */
package io.codeffeine.starterkit.api.adapter.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface ResponseAdapter {

    public ResponseEntity send(boolean result, HttpStatus code, Object data);

    public ResponseEntity send(boolean result, HttpStatus code);
}
