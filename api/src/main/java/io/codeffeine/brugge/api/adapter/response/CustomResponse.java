/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.api.adapter.response;

import io.codeffeine.brugge.api.entity.CustomResponseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class CustomResponse implements ResponseAdapter {

    @Override
    public ResponseEntity send(boolean result, HttpStatus code, Object data) {
        CustomResponseEntity response = new CustomResponseEntity();
        response.setResult(result);
        response.setStatusCode(code);
        if (data instanceof List<?>) {
            response.setData((List<Object>) data);
        } else if (Boolean.class.isInstance(data)) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("result", data);
            response.setData(dataMap);
        } else {
            response.setData(data);
        }
        return new ResponseEntity<>(response, code);
    }

    @Override
    public ResponseEntity send(boolean result, HttpStatus code) {
        CustomResponseEntity response = new CustomResponseEntity();
        response.setResult(result);
        response.setStatusCode(code);

        return new ResponseEntity<>(response, code);
    }
}
