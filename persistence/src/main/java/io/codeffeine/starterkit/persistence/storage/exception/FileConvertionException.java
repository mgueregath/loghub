/*
 * StarterKit.
 */
package io.codeffeine.starterkit.persistence.storage.exception;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class FileConvertionException extends RuntimeException {

    public FileConvertionException() {
        super("An error has occurred converting the file");
    }
}
