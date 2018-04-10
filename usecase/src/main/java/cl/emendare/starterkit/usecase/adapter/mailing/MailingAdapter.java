/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.adapter.mailing;

import cl.emendare.starterkit.domain.mailing.entity.Email;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public interface MailingAdapter {

    public void send(Email email);

}
