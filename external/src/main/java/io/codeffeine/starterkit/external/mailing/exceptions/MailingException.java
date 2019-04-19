/*
 * StarterKit.
 */
package io.codeffeine.starterkit.external.mailing.exceptions;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class MailingException extends RuntimeException {

    public MailingException() {
        super("The email could not be sent");
    }
}
