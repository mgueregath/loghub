/*
 * StarterKit.
 */
package cl.emendare.starterkit.external.mailing.exceptions;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class MailingException extends RuntimeException {

    public MailingException() {
        super("The email could not be sent");
    }
}
