/*
 * StarterKit.
 */
package cl.emendare.starterkit.api.exception;

import cl.emendare.starterkit.usecase.exception.data.AlreadyExistException;
import cl.emendare.starterkit.api.adapter.response.ResponseAdapter;
import cl.emendare.starterkit.domain.exception.MappedException;
import cl.emendare.starterkit.usecase.exception.auth.UnauthorizedException;
import cl.emendare.starterkit.usecase.exception.data.DataNotFoundException;
import cl.emendare.starterkit.usecase.exception.jwt.JwtGenerationException;
import cl.emendare.starterkit.usecase.exception.jwt.JwtValidationException;
import cl.emendare.starterkit.usecase.exception.jwt.MalformedJwtException;
import cl.emendare.starterkit.usecase.exception.security.ForbiddenException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
@ControllerAdvice
public class CustomExceptionHandler {

    @Autowired
    private ResponseAdapter response;

    @ExceptionHandler
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        HashMap<String, Object> responseObject = new HashMap<>();
        String[] className = ex.getClass().getName().split("\\.");
        responseObject.put("error", className[className.length - 1]);
        responseObject.put("message", ex.getMessage());

        HttpStatus status = INTERNAL_SERVER_ERROR;

        Logger.getAnonymousLogger().log(Level.INFO, "EXCEPTION LOGGER", ex);

        if (ex.getClass() == UnauthorizedException.class
                || ex.getClass() == MalformedJwtException.class
                || ex.getClass() == JwtGenerationException.class
                || ex.getClass() == JwtValidationException.class) {
            status = HttpStatus.UNAUTHORIZED;
        } else if (ex.getClass() == DataNotFoundException.class) {
            status = HttpStatus.NOT_FOUND;
        } else if (ex.getClass() == AlreadyExistException.class) {
            status = HttpStatus.CONFLICT;
        } else if (ex.getClass() == ForbiddenException.class) {
            status = HttpStatus.FORBIDDEN;
        } else if (ex instanceof MappedException) {
            status = HttpStatus.BAD_REQUEST;
        }

        return response.send(false, status, responseObject);
    }
}
