/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.persistence.storage.exception;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class FileConvertionException extends RuntimeException {

    public FileConvertionException() {
        super("An error has occurred converting the file");
    }
}
