/*
 * StarterKit.
 */
package cl.emendare.starterkit.domain.mailing.contract;

import cl.emendare.starterkit.domain.mailing.entity.Email;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface SendEmailInterface {

    public void send(Email email);
}
