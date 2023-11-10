/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.external.mailing.exceptions;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public class MailingException extends RuntimeException {

    public MailingException() {
        super("The email could not be sent");
    }
}
