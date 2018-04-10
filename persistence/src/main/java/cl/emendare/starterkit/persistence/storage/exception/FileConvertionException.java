/*
 * StarterKit.
 */
package cl.emendare.starterkit.persistence.storage.exception;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class FileConvertionException extends RuntimeException {

    public FileConvertionException() {
        super("An error has occurred converting the file");
    }
}
